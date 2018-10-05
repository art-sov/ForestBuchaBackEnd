/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.art.forestbucha.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author artem
 */
public class ElecricMeterTest {
    
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("h2test");
    private EntityManager em;
    private EntityTransaction tx;
    
    @Before
    public void initEntityManager() throws Exception {
        em = EMF.createEntityManager();
        tx = em.getTransaction();
    }
    
    @After
    public void closeEntityManager() throws Exception {
        if (em != null) {
            em.close();
        }
    }
    
    @Test
    public void findElectricMetersByIdTest() throws Exception {
        ElectricMeter electricMeter = em.find(ElectricMeter.class, 
                UUID.fromString("77777777-281a-4fe6-85e2-bc9831b2c9fa"));
        assertEquals(true, electricMeter.isAddYardLighting());
        assertEquals("дом 12, квартира 17", electricMeter.getNote());
    }
    
    @Test 
    public void createElecricMeterTest() throws Exception {
        
       ElectricMeter electricMeter = persistElectricMeter();
       assertNotNull("Id can not be empty", electricMeter.getId());
    }
    
    @Test
    public void createElectricMeterWithElectricValuesTest() throws Exception {
        ElectricMeter electricMeter = new ElectricMeter(true, "created from test");
              
        tx.begin();
        em.persist(electricMeter);
        UUID id = electricMeter.getId();
     
        ElectricMetersValue emValue = new ElectricMetersValue(new Date(), 7777,
        "noteTest", id);                 
        
        List<ElectricMetersValue> list = new ArrayList();
        list.add(emValue);
        
        electricMeter.setValuesList(list);
        
        //em.persist(emValue);
        tx.commit();
        
        assertNotNull(electricMeter.getId());
        assertNotNull(emValue.getId());
        
        assertEquals(electricMeter.getId(), emValue.getElectricMeterId());
    }
    
    
    @Test
    public void refreshElectricMeterTest(){
        ElectricMeter electricMeter = em.find(ElectricMeter.class, 
                UUID.fromString("77777777-281a-4fe6-85e2-bc9831b2c9fa"));
        
        assertEquals(electricMeter.getNote(), "дом 12, квартира 17");
        
        electricMeter.setNote("кладовка");
        em.refresh(electricMeter);
        
        assertEquals(electricMeter.getNote(), "дом 12, квартира 17");
    }
    
    @Test
    public void containsElectricMeterTest(){
        ElectricMeter electricMeter = persistElectricMeter();
        
        tx.begin();
        em.remove(electricMeter);
        tx.commit();
        
        assertFalse(em.contains(electricMeter));
    }
    
    @Test
    public void detachElectricMeterTest(){
       ElectricMeter electricMeter = persistElectricMeter();
       assertTrue(em.contains(electricMeter));
        
        em.detach(electricMeter);
        assertFalse(em.contains(electricMeter));        
    }
    
    
    @Test
    public void mergeElectricMeterTest(){
        ElectricMeter electricMeter = persistElectricMeter();
        em.clear();
        
        electricMeter.setNote("merge test");
        
        tx.begin();
        em.merge(electricMeter);
        tx.commit();
        
        assertEquals(electricMeter.getNote(), "merge test");
    }
    
    @Test
    public void findElectricMeterByNoteTest(){
                ElectricMeter electricMeter = em.createNamedQuery("ElectricMeter.findElectricMetersByNote", 
                ElectricMeter.class)
                .setParameter("note", "дом 12, квартира 18")
                .getSingleResult();
        assertEquals("дом 12, квартира 18", electricMeter.getNote());
    }
    
    @Test (expected = EntityNotFoundException.class)
    public void entityNotFoundExceptionTest(){
        ElectricMeter electricMeters = em.getReference(ElectricMeter.class, UUID.randomUUID());
        
    }
    
    public ElectricMeter persistElectricMeter() {
        ElectricMeter electricMeters = new ElectricMeter(true, "created from test");
        tx.begin();
        em.persist(electricMeters);
        tx.commit();
        return electricMeters;
    }
    
//    @Test (expected = ConstraintViolationException.class)
//    public void shouldRaiseConstraintViolationCauseNullId(){
//        ElectricMeter electricMeters = new ElectricMeter(null, true, "created from test");
//        em.persist(electricMeters);
//    }
}
