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
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

/**
 *
 * @author ruben
 */
@Entity
@Table ( name= "stories")

public class Story {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Type(type="pg-uuid")
    private UUID id;
    @Column(name="storyid") 
    private Integer storyid;
    @Column(name="ownerid")
    private String ownerId;
    @Column (name="epicid")
    private Integer epicId;
    @Column (name="name")
    private String name;
    @Column (name="created")
    private Timestamp created;

    public Timestamp getCreated() {
        return created;
    }

    public Integer getEpicId() {
        return epicId;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public Integer getStoryid() {
        return storyid;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public void setEpicId(Integer epicId) {
        this.epicId = epicId;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public void setStoryid(Integer storyid) {
        this.storyid = storyid;
    }
    
    
    
    
    
    
    
}
