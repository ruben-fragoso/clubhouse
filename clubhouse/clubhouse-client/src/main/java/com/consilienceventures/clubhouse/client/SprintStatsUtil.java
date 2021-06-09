/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consilienceventures.clubhouse.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ruben
 */
public class SprintStatsUtil {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SprintStatsUtil.class);

    @PersistenceUnit
    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em;
    
    public void startPersistence() {
        LOGGER.info("Starting Persistence");
        emf = Persistence.createEntityManagerFactory( "clubhouse" );
        em = emf.createEntityManager();
        LOGGER.info("Persitence Completed: EntityManager is LIVE");
        
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }
    
    
    

}
