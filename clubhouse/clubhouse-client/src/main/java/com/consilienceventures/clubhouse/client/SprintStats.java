/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consilienceventures.clubhouse.client;

import com.consilienceventures.clubhouse.database.implementations.ChangeDAOImpl;
import com.consilienceventures.clubhouse.database.implementations.IterationDAOImpl;
import com.consilienceventures.clubhouse.database.implementations.ProjectDAOImpl;
import com.consilienceventures.clubhouse.database.implementations.StoryDAOImpl;
import com.consilienceventures.clubhouse.model.Change;
import com.consilienceventures.clubhouse.model.Iteration;
import com.consilienceventures.clubhouse.model.Project;
import com.consilienceventures.clubhouse.model.Story;
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
        EntityManagerUtil entityManagerUtil = new EntityManagerUtil();
        entityManagerUtil.startPersistence();
        StoryDAOImpl storyDAOImpl = new StoryDAOImpl();
        storyDAOImpl.setEntityManager(entityManagerUtil.getEm());
        ChangeDAOImpl changeDAOImpl = new ChangeDAOImpl();
        changeDAOImpl.setEntityManager(entityManagerUtil.getEm());
        ProjectDAOImpl projectDAOImpl = new ProjectDAOImpl();
        projectDAOImpl.setEntityManager(entityManagerUtil.getEm());
        IterationDAOImpl iterationDAOImpl = new IterationDAOImpl();
        iterationDAOImpl.setEntityManager(entityManagerUtil.getEm());
        HttpClient httpClient = new HttpClient();
        Boolean method = Boolean.TRUE;
        httpClient.setBaseURL(ClubHouseStatics.BASE);
        httpClient.setToken("608a81c5-e460-4b39-a6b0-d65ca054a6d5");
        HashMap<UUID, Project> projects = clubhouseJSONParser.getProjects(httpClient.getData(Boolean.FALSE, ClubHouseStatics.PROJECTS_STORY, ""));
        projectDAOImpl.getEntityManager().getTransaction().begin();
        HashMap<UUID, Story> Stories = new HashMap<UUID, Story>();
        for (Map.Entry<UUID, Project> project : projects.entrySet()) {
            Project aProject = project.getValue();
            Stories.putAll(clubhouseJSONParser.getStoryByProject(httpClient.getData(Boolean.FALSE,ClubHouseStatics.PROJECT_DETAIL.replace(ClubHouseStatics.REPLACE_ID,aProject.getProjectId().toString()), "")));
            projectDAOImpl.persist(aProject);
        }
        HashMap<UUID, Iteration> iterations = clubhouseJSONParser.getIterations(httpClient.getData(Boolean.FALSE, ClubHouseStatics.ITERATIONS, ""));
        for (Map.Entry<UUID, Iteration> iteration : iterations.entrySet()) {
            Iteration aIteration = iteration.getValue();
            iterationDAOImpl.persist(aIteration);
        }
        for (Map.Entry<UUID, Story> aStory : Stories.entrySet()){
            aStory.setValue(clubhouseJSONParser.getStory(
                    httpClient.getData(Boolean.FALSE, 
                            ClubHouseStatics.STORY_ENDPOINT.replace(ClubHouseStatics.REPLACE_ID, aStory.getValue().getStoryid().toString()),""),
                    aStory.getValue()));
            storyDAOImpl.persist(aStory.getValue());
            HashMap<UUID,Change> changes = clubhouseJSONParser.getChanges(httpClient.getData(Boolean.FALSE, 
                    ClubHouseStatics.STORY_DETAIL.replace(ClubHouseStatics.REPLACE_ID, aStory.getValue().getStoryid().toString()), ""));
            for (Map.Entry<UUID, Change> aChange : changes.entrySet()){
                changeDAOImpl.persist(aChange.getValue());
            }
        }
        
        
        
        

        projectDAOImpl.getEntityManager().getTransaction().commit();

    }

}
