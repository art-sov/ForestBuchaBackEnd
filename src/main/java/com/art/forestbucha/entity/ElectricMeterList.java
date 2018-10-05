/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.art.forestbucha.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author artem
 */
@XmlRootElement
@XmlSeeAlso(ElectricMeter.class)
public class ElectricMeterList extends ArrayList<ElectricMeter> {
    
    public ElectricMeterList(){
        super();
    }
    
    public ElectricMeterList(Collection<? extends ElectricMeter> c){
        super(c);
    }
    
    @XmlElement(name = "electric_meter")
    public List<ElectricMeter> getElectricMeters(){
        return this;
    }
    public void setElectricMeters(List<ElectricMeter> list){
        this.addAll(list);
    }
    
}
