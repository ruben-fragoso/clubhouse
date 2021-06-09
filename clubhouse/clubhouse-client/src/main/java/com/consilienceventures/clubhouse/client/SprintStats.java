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

/**
 *
 * @author ruben
 */
public class SprintStats {

    public static void main(String[] args) throws IOException, ParseException {
        ClubHouseJSONParser clubhouseJSONParser = new ClubHouseJSONParser();
        SprintStatsUtil sprintStatsUtil = new SprintStatsUtil();
        sprintStatsUtil.startPersistence();
        ProjectDAOImpl projectDAOImpl = new ProjectDAOImpl();
        projectDAOImpl.setEntityManager(sprintStatsUtil.getEm());
        IterationDAOImpl iterationDAOImpl = new IterationDAOImpl();
        iterationDAOImpl.setEntityManager(sprintStatsUtil.getEm());
        HttpClient httpClient = new HttpClient();
        Boolean method = Boolean.TRUE;
        httpClient.setBaseURL(ClubHouseStatics.BASE);
        httpClient.setToken("608a81c5-e460-4b39-a6b0-d65ca054a6d5");
        HashMap<UUID, Project> projects = clubhouseJSONParser.getProjects(httpClient.getData(Boolean.FALSE, ClubHouseStatics.PROJECTS_STORY, ""));
        projectDAOImpl.getEntityManager().getTransaction().begin();
        for (Map.Entry<UUID, Project> project : projects.entrySet()) {
            Project aProject = project.getValue();
            projectDAOImpl.persist(aProject);
        }
        HashMap<UUID, Iteration> iterations = clubhouseJSONParser.getIterations(httpClient.getData(Boolean.FALSE, ClubHouseStatics.ITERATIONS, ""));
        for (Map.Entry<UUID, Iteration> iteration : iterations.entrySet()) {
            Iteration aIteration = iteration.getValue();
            iterationDAOImpl.persist(aIteration);
        }

        projectDAOImpl.getEntityManager().getTransaction().commit();

    }

}
