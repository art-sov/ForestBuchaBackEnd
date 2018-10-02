/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.art.forestbucha;

import com.art.forestbucha.entity.ElectricMeters;
import com.art.forestbucha.entity.ElectricMetersValue;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author artem
 */
public class Main {
    
    //private static List<ElectricMetersValue> valueList;
    
    public static void main (String[] args){
 
       //ElectricMeters electricMeter = new ElectricMeters(UUID.fromString("3500f7be-b0d0-4a2f-9254-590e53da7f16"), true, "note4");
        
       //ElectricMeters electricMeter = new ElectricMeters(UUID.randomUUID(), true, "note4");
//        ElectricMeters electricMeter = new ElectricMeters();
//        ElectricMeters electricMeter2 = new ElectricMeters();
//        ElectricMeters electricMeter3 = new ElectricMeters();
//        
        
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2test");
//        EntityManager manager = emf.createEntityManager();
//        
//        EntityTransaction et = manager.getTransaction();
//        et.begin();
//        manager.persist(electricMeter);
//        et.commit();
        
//        electricMeter = (ElectricMeters) manager.createNamedQuery("ElectricMeters.findElectricMetersByNote")
//                .setParameter("note", "note1")
//                .getSingleResult();
//        
//        electricMeter2 = (ElectricMeters) manager.createNamedQuery("ElectricMeters.findElectricMetersByNote")
//                .setParameter("note", "note2")
//                .getSingleResult();
//        
//        electricMeter3 = (ElectricMeters) manager.createNamedQuery("ElectricMeters.findElectricMetersByNote")
//                .setParameter("note", "note3")
//                .getSingleResult();
        
        //ElectricMeters electricMeters2 = new ElectricMeters(null, true, "created from test");
    
        //System.out.println(electricMeter);
        //System.out.println(electricMeter2);
        //System.out.println(electricMeter3);
        
//        List<ElectricMeters> list = new ArrayList();
//        
//        list = manager.createNamedQuery("ElectricMeters.findAll").getResultList();
        //System.out.println(list);
        
        
        
//        
//        ElectricMetersValue emv1 = new ElectricMetersValue();
//        ElectricMetersValue emv2 = new ElectricMetersValue();
//        ElectricMetersValue emv3 = new ElectricMetersValue();
//        
//        valueList = new ArrayList();
//        
//        et.begin();
//        TypedQuery<ElectricMetersValue> query;
//                
//        query = manager.createQuery("SELECT v FROM ElectricMetersValue v WHERE v.meterCount = 1150",
//                        ElectricMetersValue.class);
//        emv2 = query.getSingleResult();
//        System.out.println(emv2);
//
//        valueList = manager.createNamedQuery("ElectricMetersValue.findAll").getResultList();
//        
//        System.out.println(valueList);
//        et.commit();
//        manager.close();
//        emf.close();
        
}
    
}
