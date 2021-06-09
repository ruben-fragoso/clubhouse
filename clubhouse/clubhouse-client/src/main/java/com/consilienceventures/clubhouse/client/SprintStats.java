/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consilienceventures.clubhouse.client;

import com.consilienceventures.clubhouse.database.implementations.ProjectDAOImpl;
import com.consilienceventures.clubhouse.model.Project;

/**
 *
 * @author ruben
 */
public class SprintStats {
    
    public static void main(String[] args) {
        
        SprintStatsUtil sprintStatsUtil = new SprintStatsUtil();
        sprintStatsUtil.startPersistence();
        ProjectDAOImpl projectDAOImpl = new ProjectDAOImpl();
        projectDAOImpl.setEntityManager(sprintStatsUtil.getEm());
        projectDAOImpl.getEntityManager().getTransaction().begin();
        Project aproject = new Project();
        aproject.setName("dd");
        aproject.setProjectId(Integer.SIZE);
        projectDAOImpl.persist(aproject);
        
        projectDAOImpl.getEntityManager().getTransaction().commit();
        
    }
    
}
