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
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;
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
    @NamedQuery(name = ElectricMeter.FIND_ALL,
            query = "SELECT e FROM ElectricMeter e"),
    @NamedQuery(name = "ElectricMeter.findElectricMetersById",
            query = "SELECT e FROM ElectricMeter e WHERE e.id = :id"),
    @NamedQuery(name = "ElectricMeter.findElectricMetersByNote", 
            query = "SELECT e FROM ElectricMeter e WHERE e.note = :note")
})
@XmlRootElement
public class ElectricMeter implements Serializable {
    
    public static final String FIND_ALL = "ElectricMeter.findAll";
    
    @Id
    @GeneratedValue(generator = "uuid", strategy = IDENTITY)
    @Convert("uuidConverter")
    @Column (name = "ID", nullable = false)
    private UUID id;
    
    @Column(name = "ADD_YARD_LIGHTING", nullable = false)
    private boolean addYardLighting;
    
    @Column(name = "NOTE", length = 255)
    private String note;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "electric_meter_id")
    @OrderBy("date ASC")
    private List<ElectricMetersValue> valuesList;
    
    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "electric_meter_id")
    private List<ElectricMetersAccrual> acccrualList;
    
    public ElectricMeter() {
    }

    public ElectricMeter(UUID id, boolean addYardLighting, String note) {
        this.id = id;
        this.addYardLighting = addYardLighting;
        this.note = note;
    }
    
     public ElectricMeter(boolean addYardLighting, String note) {
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

    public List<ElectricMetersValue> getValuesList() {
        return valuesList;
    }

    public void setValuesList(List<ElectricMetersValue> valuesList) {
        this.valuesList = valuesList;
    }

    public List<ElectricMetersAccrual> getAcccrualList() {
        return acccrualList;
    }

    public void setAcccrualList(List<ElectricMetersAccrual> acccrualList) {
        this.acccrualList = acccrualList;
    }
    
    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("id", this.id.toString())
                .add("addYardLighting", this.addYardLighting)
                .add("note", this.note)
                .build();
    }
    
    
    @Override
    public String toString() {
        return "ElectricMeters { " + "\nid = " + id + 
                ", \naddYardLighting = " + addYardLighting + 
                ", \nnote = " + note + " }";
    }
    
}
