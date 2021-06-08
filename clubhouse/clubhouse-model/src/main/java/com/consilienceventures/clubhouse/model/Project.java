/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consilienceventures.clubhouse.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author ruben
 */
@Entity
@Table (name = "projects")
public class Project {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Type(type="pg-uuid")
    @Column(name="id")
    private UUID id;
    
    @Column(name = "project_id")
    private Integer projectId;
    @Column(name = "name")
    private String name;

    
    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public UUID getId() {
        return id;
    }

    public Project() {
    }

    public String getName() {
        return name;
    }

    public Integer getProjectId() {
        return projectId;
    }

    
    

  
    
}
