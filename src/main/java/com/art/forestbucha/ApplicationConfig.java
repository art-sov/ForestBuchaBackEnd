/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.art.forestbucha;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;

import com.art.forestbucha.service.ElectricMeterService;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author artem
 */
@ApplicationPath("rs")
public class ApplicationConfig extends Application {
    
    private final Set<Class<?>> classes;

    public ApplicationConfig() {
        
        HashSet<Class<?>> c = new HashSet();
        c.add(ElectricMeterService.class);
        c.add(MOXyJsonProvider.class);
        classes = Collections.unmodifiableSet(c);
    }
    
    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }  
}
