/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.art.forestbucha.entity;

import java.util.Date;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author artem
 */
public class ElectricMetersAccrualTest {
    
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
    public void findElectricMetersAccrualByIdTest() throws Exception {
        ElectricMetersAccrual ema = em.find(ElectricMetersAccrual.class, 
                UUID.fromString("4a2a0051-412c-4eb1-849a-cc1b00bbe7ed"));
        assertEquals(1111, ema.getValueAccrual());
        assertEquals("note1", ema.getNote());
     }
    
    @Test
      public void createElecricMetersAccrualTest() throws Exception {
        
        ElectricMetersAccrual ema = new ElectricMetersAccrual (UUID.randomUUID(), 
                UUID.randomUUID(),         
                7777, "noteTest", 
                UUID.fromString("2f517777-281a-4fe6-85e2-bc9831b2c9fa"));
        tx.begin();
        em.persist(ema);
        tx.commit();
        assertNotNull("Id can not be empty", ema.getId());
    }
      
    @Test (expected = EntityNotFoundException.class)
    public void shouldEntityNotFoundExceptionTest(){
        ElectricMetersAccrual ema = em.getReference(ElectricMetersAccrual.class, UUID.randomUUID());       
    }          
}
