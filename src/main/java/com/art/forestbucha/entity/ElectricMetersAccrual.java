/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.art.forestbucha.entity;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author artem
 */
@Entity
@Table (name = "ELECTRIC_METERS_ACCRUALS")
public class ElectricMetersAccrual implements Serializable{
    
    @Id
    @Column(name = "ELECTRIC_METER_ID")
    private UUID id;
    
    @Column(name = "USER_ID")
    private UUID userId;
    
    @Column(name = "VALUE_ACCRUAL")
    private int valueAccrual;
    
    @Column(name = "NOTE")
    private String note;

    public ElectricMetersAccrual() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public int getValue() {
        return valueAccrual;
    }

    public void setValue(int value) {
        this.valueAccrual = value;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
