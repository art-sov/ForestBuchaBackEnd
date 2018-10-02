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
                UUID.fromString("11111111-c05a-496f-b95c-49d255339700"));
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(emv.getDate());
        assertEquals("2018-07-01", date);
        assertEquals(1000, emv.getMeterCount());
    }
    
    @Test
    public void shouldCreateElecricMetersValue() throws Exception {
        
        ElectricMetersValue emv = new ElectricMetersValue (UUID.randomUUID(), new Date(), 
                7777, "noteTest", UUID.fromString("77777777-281a-4fe6-85e2-bc9831b2c9fa"));
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
