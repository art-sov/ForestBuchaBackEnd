/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.art.forestbucha.log;

import javax.enterprise.inject.Produces;
import java.util.logging.Logger;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author artem
 */
public class LogginProducer {
    
    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint){
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass()
        .getName());
    }
}
