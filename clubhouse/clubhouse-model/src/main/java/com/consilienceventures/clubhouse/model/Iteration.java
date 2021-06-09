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
import org.hibernate.type.PostgresUUIDType;


/**
 *
 * @author ruben
 */
@Entity
@Table (name = "iterations")
public class Iteration {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private PostgresUUIDType id;
    @Column(name = "iterationsId")
    private Integer iterationId;
    @Column(name = "name")
    private String name;
    @Column(name = "startDate")
    private Timestamp startDate;
    @Column(name = "endDate")
    private Timestamp endDate;

    public Timestamp getEnd() {
        return endDate;
    }

   
    public Integer getIterationId() {
        return iterationId;
    }

    public String getName() {
        return name;
    }

    public Timestamp getStart() {
        return startDate;
    }

    public void setEnd(Timestamp end) {
        this.endDate = end;
    }

    public void setIterationId(Integer iterationId) {
        this.iterationId = iterationId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStart(Timestamp start) {
        this.startDate = start;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public void setId(PostgresUUIDType id) {
        this.id = id;
    }

    public PostgresUUIDType getId() {
        return id;
    }
    
    
    
    
    
    
    
    
}
