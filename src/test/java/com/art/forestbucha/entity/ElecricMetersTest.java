/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.art.forestbucha.entity;

import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author artem
 */
public class ElecricMetersTest {
    
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
        ElectricMeters electricMeters = em.find(ElectricMeters.class, 
                UUID.fromString("77777777-281a-4fe6-85e2-bc9831b2c9fa"));
        assertEquals(true, electricMeters.isAddYardLighting());
        assertEquals("дом 12, квартира 17", electricMeters.getNote());
    }
    
    @Test 
    public void createElecricMetersTest() throws Exception {
        
        ElectricMeters electricMeters = new ElectricMeters(UUID.randomUUID(), true, "created from test");
        tx.begin();
        em.persist(electricMeters);
        tx.commit();
        assertNotNull("Id can not be empty", electricMeters.getId());
    }
    
    @Test
    public void findElectricMetersByNoteTest(){
                ElectricMeters electricMeters = em.createNamedQuery("ElectricMeters.findElectricMetersByNote", 
                ElectricMeters.class)
                .setParameter("note", "дом 12, квартира 18")
                .getSingleResult();
        assertEquals("дом 12, квартира 18", electricMeters.getNote());
    }
    
    @Test (expected = EntityNotFoundException.class)
    public void entityNotFoundExceptionTest(){
        ElectricMeters electricMeters = em.getReference(ElectricMeters.class, UUID.randomUUID());
        
    }
    
//    @Test (expected = ConstraintViolationException.class)
//    public void shouldRaiseConstraintViolationCauseNullId(){
//        ElectricMeters electricMeters = new ElectricMeters(null, true, "created from test");
//        em.persist(electricMeters);
//    }
}
