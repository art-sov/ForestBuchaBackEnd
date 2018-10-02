/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.art.forestbucha.entity;

import com.art.forestbucha.util.UUIDConverter;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.eclipse.persistence.annotations.Converter;
import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.UuidGenerator;

/**
 *
 * @author artem
 */
@Entity
@UuidGenerator(name = "uuid")
@NamedQuery(name = "ElectricMetersValue.findAll", 
            query = "SELECT e FROM ElectricMetersValue e")
@Converter(name = "uuidConverter", converterClass = UUIDConverter.class)
@Table(name = "ELECTRIC_METERS_VALUES")
public class ElectricMetersValue implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid", strategy = IDENTITY)
    @Convert("uuidConverter")
    @Column(name = "ID", nullable= false)
    private UUID id;
    
    @Temporal(TemporalType.DATE)
    @Column (name = "VALUE_DATE", nullable = false)
    private Date date;
    
    @Column(name = "METER_COUNT", nullable = false)
    private int meterCount;
    
    @Column(name = "NOTE")
    private String note;
    
    @Convert("uuidConverter")
    @Column(name = "ELECTRIC_METER_ID", nullable = false)
    private UUID electricMeterId;

    public ElectricMetersValue() {
    }

    public ElectricMetersValue(UUID id, Date date, int meterCount, String note, UUID electricMeterId) {
        this.id = id;
        this.date = date;
        this.meterCount = meterCount;
        this.note = note;
        this.electricMeterId = electricMeterId;
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

    public int getMeterCount() {
        return meterCount;
    }

    public void setMeterCount(int value) {
        this.meterCount = value;
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

    @Override
    public String toString() {
        return "ElectricMetersValue {" + 
                "\nid = " + id + ", "
                + "\ndate = " + date + ", "
                + "\nmeterCount = " + meterCount + ", "
                + "\nnote = " + note + ", "
                + "\nelectricMeterId = " + electricMeterId + "}";
    }   
}
