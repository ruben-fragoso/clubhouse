/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consilienceventures.clubhouse.model;

import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author ruben
 */
@Entity
@Table(name = "changes")

public class Change {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;
    private Integer storyId;
    private Timestamp snapshot;
    private String oldValue;
    private String newValue;

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

    public void setSnapshot(Timestamp snapshot) {
        this.snapshot = snapshot;
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

    public Timestamp getSnapshot() {
        return snapshot;
    }

    public Integer getStoryId() {
        return storyId;
    }
       
    
    
    
    
    
            
    
}
