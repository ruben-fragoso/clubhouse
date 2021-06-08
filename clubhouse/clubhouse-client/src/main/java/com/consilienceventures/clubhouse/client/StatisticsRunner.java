/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consilienceventures.clubhouse.client;
import com.consilienceventures.clubhouse.database.implementations.IterationDAOImpl;
import com.consilienceventures.clubhouse.database.implementations.ProjectDAOImpl;
import com.consilienceventures.clubhouse.model.Iteration;
import com.consilienceventures.clubhouse.model.Project;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ruben
 */
public class StatisticsRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatisticsRunner.class);

    public static void main(String[] args) throws IOException, ParseException {
        ClubhouseJSONParser clubhouseJSONParser = new ClubhouseJSONParser();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.consilienceventures_clubhouse-model_jar_1.0PU");
        
        EntityManager entityManager = factory.createEntityManager();
        ProjectDAOImpl projectDAOImpl = new ProjectDAOImpl();
        projectDAOImpl.setEntityManager(entityManager);
        IterationDAOImpl iterationDAOImpl = new IterationDAOImpl();
        iterationDAOImpl.setEntityManager(entityManager);
        HttpClient httpClient = new HttpClient();
        Boolean method = Boolean.TRUE;
        httpClient.setBaseURL(ClubHouseStatics.BASE);
        httpClient.setToken("608a81c5-e460-4b39-a6b0-d65ca054a6d5");
        HashMap<UUID, Project> projects = clubhouseJSONParser.getProjects(httpClient.getData(Boolean.FALSE, ClubHouseStatics.PROJECTS_STORY, ""));
        projectDAOImpl.getEntityManager().getTransaction().begin();
        for (Map.Entry<UUID, Project> project : projects.entrySet()) {
            Project aProject =  project.getValue();
            projectDAOImpl.persist(aProject);
        }
        HashMap<UUID,Iteration> iterations = clubhouseJSONParser.getIterations(httpClient.getData(Boolean.FALSE, ClubHouseStatics.ITERATIONS, "")) ;
//        Iteration aIteration = new Iteration();
//        aIteration.setName("Test");
//        aIteration.setId(UUID.randomUUID());
//        iterationDAOImpl.persist(aIteration);
//        for (Map.Entry<UUID, Iteration> iteration : iterations.entrySet()) {
//            Iteration aIteration = iteration.getValue();
//            iterationDAOImpl.persist(aIteration);
//        }
        
        
        
        
        projectDAOImpl.getEntityManager().getTransaction().commit();
        
    }

}
