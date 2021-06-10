/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consilienceventures.clubhouse.model;

import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


/**
 *
 * @author ruben
 */
@Entity
@Table(name = "changes")

public class Change {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name="storyid")
    private Integer storyId;
    @Column(name="created")
    private Timestamp created;
    @Column(name="oldvalue")
    private String oldValue;
    @Column(name="newvalue")
    private String newValue;
    @Column(name="changetype")
    private String changeType;

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public void setStoryId(Integer storyId) {
        this.storyId = storyId;
    }

   

    public UUID getId() {
        return id;
    }

    public String getNewValue() {
        return newValue;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getChangeType() {
        return changeType;
    }

    public Timestamp getCreated() {
        return created;
    }

   

    public Integer getStoryId() {
        return storyId;
    }
       
    
    
    
    
    
            
    
}
