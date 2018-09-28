/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.art.forestbucha.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author artem
 */
@Entity
@Table(name = "ELECTRIC_METERS_VALUE")
public class ElectricMetersValue implements Serializable{
    
    @Id
    @Column(name = "ELECTRIC_METER_ID")
    private UUID id;
    
    @Temporal(TemporalType.DATE)
    @Column (name = "VALUE_DATE")
    private Date date;
    
    @Column(name = "METER_COUNT")
    private int meterCount;
    
    @Column(name = "NOTE")
    private String note;

    public ElectricMetersValue() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getValue() {
        return meterCount;
    }

    public void setValue(int value) {
        this.meterCount = value;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
    
}
