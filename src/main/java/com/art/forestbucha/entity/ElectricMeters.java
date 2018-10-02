/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.art.forestbucha.entity;

import com.art.forestbucha.util.UUIDConverter;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.UuidGenerator;
import org.eclipse.persistence.annotations.Converter;
import org.eclipse.persistence.annotations.Convert;

/**
 *
 * @author artem
 */
@Entity
@UuidGenerator(name = "uuid")
@Converter(name = "uuidConverter", converterClass = UUIDConverter.class)
@Table(name = "ELECTRIC_METERS")
@NamedQueries({
    @NamedQuery(name = "ElectricMeters.findAll",
            query = "SELECT e FROM ElectricMeters e"),
    @NamedQuery(name = "ElectricMeters.findElectricMetersById",
            query = "SELECT e FROM ElectricMeters e WHERE e.id = :id"),
    @NamedQuery(name = "ElectricMeters.findElectricMetersByNote", 
            query = "SELECT e FROM ElectricMeters e WHERE e.note = :note")
})
public class ElectricMeters implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid", strategy = IDENTITY)
    @Convert("uuidConverter")
    @Column (name = "ID", nullable = false)
    private UUID id;
    
    @Column(name = "ADD_YARD_LIGHTING", nullable = false)
    private boolean addYardLighting;
    
    @Column(name = "NOTE", length = 255)
    private String note;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "electric_meter_id")
    @OrderBy("date ASC")
    private List<ElectricMetersValue> valuesList;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "electric_meter_id")
    private List<ElectricMetersAccrual> acccrualList;
    
    public ElectricMeters() {
    }

    public ElectricMeters(UUID id, boolean addYardLighting, String note) {
        this.id = id;
        this.addYardLighting = addYardLighting;
        this.note = note;
    }
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isAddYardLighting() {
        return addYardLighting;
    }

    public void setAddYardLighting(boolean addYardLighting) {
        this.addYardLighting = addYardLighting;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ElectricMeters { " + "\nid = " + id + 
                ", \naddYardLighting = " + addYardLighting + 
                ", \nnote = " + note + " }";
    }
}
