/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.art.forestbucha.entity;

import java.text.SimpleDateFormat;
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
public class ElectricMetersValueTest {
    
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
    public void findElectricMetersValueByIdTest() throws Exception {
        ElectricMetersValue emv = em.find(ElectricMetersValue.class, 
                UUID.fromString("9ec76737-ec67-4f2f-be94-9b7ff9e38d58"));
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(emv.getDate());
        assertEquals("2018-09-25", date);
        assertEquals(1222, emv.getMeterCount());
    }
    
    @Test
      public void shouldCreateElecricMetersValue() throws Exception {
        
        ElectricMetersValue emv = new ElectricMetersValue (UUID.randomUUID(), new Date(), 
                7777, "noteTest", UUID.fromString("2f517777-281a-4fe6-85e2-bc9831b2c9fa"));
        tx.begin();
        em.persist(emv);
        tx.commit();
        assertNotNull("Id can not be empty", emv.getId());
    }
      
    @Test (expected = EntityNotFoundException.class)
    public void shouldEntityNotFoundExceptionTest(){
        ElectricMetersValue emv = em.getReference(ElectricMetersValue.class, UUID.randomUUID());       
    }   
}
