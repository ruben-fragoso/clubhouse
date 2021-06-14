/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consilienceventures.clubhouse.client;

import com.consilienceventures.clubhouse.model.Change;
import com.consilienceventures.clubhouse.model.Iteration;
import com.consilienceventures.clubhouse.model.Project;
import com.consilienceventures.clubhouse.model.Story;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import net.minidev.json.JSONArray;
import org.hibernate.type.PostgresUUIDType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ruben
 */
public class ClubHouseJSONParser {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ClubHouseJSONParser.class);
    
    private Object getValueFromLinkedHashMap(Object linked, String key) {
        LinkedHashMap<String, Object> aList = (LinkedHashMap<String, Object>) linked;
        return aList.get(key);
    }
    
    private Date getDateFromString(String date, String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.parse(date);
    }
    
    public HashMap<UUID, Iteration> getIterations(String json) throws ParseException {
        HashMap<UUID, Iteration> returnValue = new HashMap<>();
        DocumentContext jsonContext = JsonPath.parse(json);
        JSONArray iterations = jsonContext.read("$[*]");
        DateFormat df = DateFormat.getDateInstance();
        for (int index = 0; index < iterations.size(); index++) {
            Iteration iteration = new Iteration();
            iteration.setIterationId((Integer) getValueFromLinkedHashMap(iterations.get(index), ClubHouseStatics.ID_ENTITY));
            iteration.setName((String) getValueFromLinkedHashMap(iterations.get(index), ClubHouseStatics.NAME_ENTITY));
            iteration.setStatus((String) getValueFromLinkedHashMap(iterations.get(index), ClubHouseStatics.SPRING_STATUS));
            iteration.setStart(new Timestamp(getDateFromString(
                    (String) getValueFromLinkedHashMap(iterations.get(index), ClubHouseStatics.START_DATE),
                    "yyyy-MM-dd"
            ).getTime()));
            iteration.setEnd(new Timestamp(getDateFromString(
                    (String) getValueFromLinkedHashMap(iterations.get(index), ClubHouseStatics.END_DATE),
                    "yyyy-MM-dd"
            ).getTime()));
            returnValue.put(UUID.randomUUID(), iteration);
        }
        return returnValue;
    }
    
    public HashMap<UUID, Story> getStoryByProject(String json) {
        HashMap<UUID, Story> returnValue = new HashMap<>();
        DocumentContext jsonContext = JsonPath.parse(json);
        JSONArray stories = jsonContext.read("$[*]");
        for (int index = 0; index < stories.size(); index++) {
            Story aStory = new Story();
            aStory.setStoryid((Integer) getValueFromLinkedHashMap(stories.get(index), ClubHouseStatics.ID_ENTITY));
            aStory.setType((String) getValueFromLinkedHashMap(stories.get(index), ClubHouseStatics.ENTITY_TYPE));
            returnValue.put(UUID.randomUUID(), aStory);
        }
        return returnValue;
    }
    
    public Story getStory(String json, Story aStory) throws ParseException {
        Story returnValue = aStory;
        DocumentContext jsonContext = JsonPath.parse(json);
        returnValue.setName((String) getValueFromLinkedHashMap(jsonContext.json(), ClubHouseStatics.NAME_ENTITY));
        returnValue.setEpicId((Integer) getValueFromLinkedHashMap(jsonContext.json(), ClubHouseStatics.EPIC_ID));
        returnValue.setType((String) getValueFromLinkedHashMap(jsonContext.json(), ClubHouseStatics.ENTITY_TYPE));
        returnValue.setProjectId((Integer) getValueFromLinkedHashMap(jsonContext.json(), ClubHouseStatics.PROJECT_ID));
        returnValue.setCreated(new Timestamp(
                getDateFromString((String) getValueFromLinkedHashMap(jsonContext.json(), ClubHouseStatics.CREATED_AT), "yyyy-MM-dd'T'HH:mm:ss'Z'").getTime()));
        returnValue.setEstimate((Integer) getValueFromLinkedHashMap(jsonContext.json(), ClubHouseStatics.ESTIMATE_ENTITY));
        return returnValue;
    }
    
    public HashMap<UUID, Project> getProjects(String json) throws ParseException {
        HashMap<UUID, Project> returnValue = new HashMap<>();
        DocumentContext jsonContext = JsonPath.parse(json);
        JSONArray projects = jsonContext.read("$[*]");
        for (int index = 0; index < projects.size(); index++) {
            Project aProject = new Project();
            //Object object = ;
            aProject.setProjectId((Integer) getValueFromLinkedHashMap(projects.get(index), ClubHouseStatics.ID_ENTITY));
            aProject.setName((String) getValueFromLinkedHashMap(projects.get(index), ClubHouseStatics.NAME_ENTITY));
            returnValue.put(UUID.randomUUID(), aProject);
            
        }
        return returnValue;
    }
    
    public HashMap<UUID, Change> getChanges(String json) throws ParseException {
        HashMap<UUID, Change> returnValue = new HashMap<>();
        DocumentContext jsonContext = JsonPath.parse(json);
        JSONArray changes = jsonContext.read("$[*]");
        boolean jump = false;
        Map<String, Integer> stateChanges = new HashMap<String, Integer>();
        for (int index = 0; index < changes.size(); index++) {
            jump = false;
            Change aChange = new Change();
            Integer newValue = null;
            Integer oldValue = null;
            aChange.setCreated(new Timestamp(getDateFromString((String) getValueFromLinkedHashMap(changes.get(index), ClubHouseStatics.CHANGED_ENTITY), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").getTime()));
            if ((Integer) getValueFromLinkedHashMap(changes.get(index), ClubHouseStatics.CHANGE_STORY_ID) != null) {
                aChange.setStoryId((Integer) getValueFromLinkedHashMap(changes.get(index), ClubHouseStatics.CHANGE_STORY_ID));
            } 
            JSONArray actions = (JSONArray) getValueFromLinkedHashMap(changes.get(index), ClubHouseStatics.ACTIONS_ENTITY);
            for (int indez = 0; indez < actions.size(); indez++) {
                aChange.setStoryId((Integer)getValueFromLinkedHashMap(actions.get(indez), ClubHouseStatics.ID_ENTITY));
                String action = (String) getValueFromLinkedHashMap(actions.get(indez), ACTION);
                switch (action) {
                    case CREATE: {
                        aChange.setChangeType(CREATION);
                        stateChanges.put(ClubHouseStatics.NEW_ENTITY, (Integer) getValueFromLinkedHashMap(actions.get(indez), ClubHouseStatics.WORKFLOW_ENTITY));
                        try {
                            Change iteration = new Change();
                            iteration.setCreated(aChange.getCreated());
                            iteration.setStoryId(aChange.getStoryId());
                            iteration.setChangeType(ITERATION);
                            iteration.setNewValue(getValueFromLinkedHashMap(actions.get(indez), ITERATION_ID).toString());
                            returnValue.put(UUID.randomUUID(), iteration);
                        } catch (Exception e) {
                            LOGGER.warn("Could read iteration_id on creating story");
                        }
                        break;
                    }
                    case UPDATE: {
                        if (getValueFromLinkedHashMap(actions.get(indez), ClubHouseStatics.CHANGES_ENTITY) != null) {
                            if (getValueFromLinkedHashMap(getValueFromLinkedHashMap(actions.get(indez), ClubHouseStatics.CHANGES_ENTITY), ClubHouseStatics.WORKFLOW_ENTITY) != null) {
                                aChange.setChangeType(ClubHouseStatics.WORKFLOW_ENTITY);
                                stateChanges.put(ClubHouseStatics.NEW_ENTITY, (Integer) getValueFromLinkedHashMap(getValueFromLinkedHashMap(getValueFromLinkedHashMap(actions.get(indez),
                                        ClubHouseStatics.CHANGES_ENTITY), ClubHouseStatics.WORKFLOW_ENTITY), ClubHouseStatics.NEW_ENTITY));
                                stateChanges.put(ClubHouseStatics.OLD_ENTITY, (Integer) getValueFromLinkedHashMap(getValueFromLinkedHashMap(getValueFromLinkedHashMap(actions.get(indez),
                                        ClubHouseStatics.CHANGES_ENTITY), ClubHouseStatics.WORKFLOW_ENTITY), ClubHouseStatics.OLD_ENTITY));
                                break;
                                
                            }
                            if (getValueFromLinkedHashMap(getValueFromLinkedHashMap(actions.get(indez), ClubHouseStatics.CHANGES_ENTITY), ITERATION_ID) != null) {
                                aChange.setChangeType(ITERATION);
                                if (getValueFromLinkedHashMap(getValueFromLinkedHashMap(getValueFromLinkedHashMap(actions.get(indez), ClubHouseStatics.CHANGES_ENTITY), ITERATION_ID), ClubHouseStatics.NEW_ENTITY) != null) {
                                    aChange.setNewValue(getValueFromLinkedHashMap(getValueFromLinkedHashMap(getValueFromLinkedHashMap(actions.get(indez), ClubHouseStatics.CHANGES_ENTITY), ITERATION_ID), ClubHouseStatics.NEW_ENTITY).toString());
                                }
                                if (getValueFromLinkedHashMap(getValueFromLinkedHashMap(getValueFromLinkedHashMap(actions.get(indez), ClubHouseStatics.CHANGES_ENTITY), ITERATION_ID), ClubHouseStatics.OLD_ENTITY) != null) {
                                    aChange.setOldValue(getValueFromLinkedHashMap(getValueFromLinkedHashMap(getValueFromLinkedHashMap(actions.get(indez), ClubHouseStatics.CHANGES_ENTITY), ITERATION_ID), ClubHouseStatics.OLD_ENTITY).toString());
                                }
                                break;
                                
                            } else {
                                jump = true;
                            }
                        } else {
                            jump = true;
                        }
                        break;
                    }
                    default: {
                        jump = true;
                        break;
                    }
                }
                if (jump) {
                    continue;
                }
            }
            if (jump) {
                continue;
            }
            JSONArray references = (JSONArray) getValueFromLinkedHashMap(changes.get(index), ClubHouseStatics.REFERENCES_ENTITY);
            for (int indey = 0; indey < references.size(); indey++) {
                try {
                    if (stateChanges.get(ClubHouseStatics.NEW_ENTITY).equals((Integer) getValueFromLinkedHashMap(references.get(indey), ClubHouseStatics.ID_ENTITY))) {
                        aChange.setNewValue((String) getValueFromLinkedHashMap(references.get(indey), ClubHouseStatics.NAME_ENTITY));
                    }
                    if (stateChanges.get(ClubHouseStatics.OLD_ENTITY).equals((Integer) getValueFromLinkedHashMap(references.get(indey), ClubHouseStatics.ID_ENTITY))) {
                        aChange.setOldValue((String) getValueFromLinkedHashMap(references.get(indey), ClubHouseStatics.NAME_ENTITY));
                    }
                } catch (Exception e) {
                    LOGGER.warn(" Error getting references");
                }
            }
            
            LOGGER.info(aChange.getStoryId().toString()
                    + ":" + aChange.getStoryId().toString()
                    + ":" + aChange.getChangeType()
                    + ":" + aChange.getOldValue()
                    + ":" + aChange.getNewValue());
            
            returnValue.put(UUID.randomUUID(), aChange);
        }
        return returnValue;
    }
    public static final String ITERATION = "iteration";
    public static final String ITERATION_ID = "iteration_id";
    public static final String UPDATE = "update";
    public static final String CREATION = "creation";
    public static final String CREATE = "create";
    public static final String ACTION = "action";
    
}
