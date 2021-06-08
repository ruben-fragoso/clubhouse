/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consilienceventures.clubhouse.implementations;

import com.consilienceventures.clubhouse.database.implementations.StoryDAOImpl;
import com.consilienceventures.clubhouse.interfaces.IClubhouseBroker;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ruben
 */
public class ClubhouseBrokerImpl implements IClubhouseBroker{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ClubhouseBrokerImpl.class);
    private EntityManagerFactory factory;
    private EntityManager entityManager;
    private StoryDAOImpl  storyDAOImpl;
    /*
    private JiraOAuthClient jiraOAuthClient;
    private JIRAURLBuilder builder;
    private OAuthClient authClient;
    private JIRAJSONParser aJSONParser;
    private SprintsDAOImpl sprintsDAOImpl;
    private SprintReportDAOImpl sprintReportDAOImpl;
    private IssueChangeLogDAOImpl issueChangeLogDAOImpl;
    */

    @Override
    public void setup() {
        factory = Persistence.createEntityManagerFactory("TestDB");
        entityManager = factory.createEntityManager();
        storyDAOImpl = new StoryDAOImpl();
        storyDAOImpl.setEntityManager(entityManager);
    }
    
    
    @Override
    public StoryDAOImpl getStoryDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
