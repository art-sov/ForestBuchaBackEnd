/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.art.forestbucha;

import com.art.forestbucha.entity.ElectricMeters;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author artem
 */
public class Main {
    
    public static void main (String[] args){
 
       //ElectricMeters electricMeter = new ElectricMeters(UUID.fromString("3500f7be-b0d0-4a2f-9254-590e53da7f16"), true, "note4");
        
       //ElectricMeters electricMeter = new ElectricMeters(UUID.randomUUID(), true, "note4");
        ElectricMeters electricMeter = new ElectricMeters();
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2");
        EntityManager manager = emf.createEntityManager();
        
        EntityTransaction et = manager.getTransaction();
        et.begin();
        manager.persist(electricMeter);
        et.commit();
        
        electricMeter = (ElectricMeters) manager.createNamedQuery("ElectricMeters.findElectricMetersByNote").getSingleResult();
        
        System.out.println(electricMeter);
        
        manager.close();
        emf.close();
        
}
    
}
