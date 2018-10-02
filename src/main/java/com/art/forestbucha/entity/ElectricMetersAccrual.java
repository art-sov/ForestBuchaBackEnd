/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.art.forestbucha.entity;

import com.art.forestbucha.util.UUIDConverter;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.Converter;
import org.eclipse.persistence.annotations.UuidGenerator;

/**
 *
 * @author artem
 */
@Entity
@UuidGenerator(name = "uuid")
@Converter(name = "uuidConverter", converterClass = UUIDConverter.class)
@Table (name = "ELECTRIC_METERS_ACCRUALS")
@NamedQuery(name = "ElectricMetersAccrual.findAll", 
        query = "SELECT e FROM ElectricMetersAccrual e")
public class ElectricMetersAccrual implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid", strategy = IDENTITY)
    @Convert("uuidConverter")
    @Column(name = "ID", nullable = false)
    private UUID id;
    
    @Convert("uuidConverter")
    @Column(name = "USER_ID", nullable = false)
    private UUID userId;
    
    @Column(name = "VALUE_ACCRUAL", nullable = false)
    private int valueAccrual;
    
    @Column(name = "NOTE")
    private String note;
    
    @Convert("uuidConverter")
    @Column(name = "ELECTRIC_METER_ID", nullable = false)
    private UUID electricMeterId;

    public ElectricMetersAccrual() {
    }

    public ElectricMetersAccrual(UUID id, UUID userId, int valueAccrual, String note, UUID electricMeterId) {
        this.id = id;
        this.userId = userId;
        this.valueAccrual = valueAccrual;
        this.note = note;
        this.electricMeterId = electricMeterId;
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

    public int getValueAccrual() {
        return valueAccrual;
    }

    public void setValueAccrual(int valueAccrual) {
        this.valueAccrual = valueAccrual;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public UUID getElectricMeterId() {
        return electricMeterId;
    }

    public void setElectricMeterId(UUID electricMeterId) {
        this.electricMeterId = electricMeterId;
    }
}
