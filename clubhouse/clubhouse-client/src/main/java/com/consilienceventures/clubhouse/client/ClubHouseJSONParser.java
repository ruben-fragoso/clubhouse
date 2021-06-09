/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consilienceventures.clubhouse.client;

import com.consilienceventures.clubhouse.model.Iteration;
import com.consilienceventures.clubhouse.model.Project;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
        LinkedHashMap<String, Object> myList = (LinkedHashMap<String, Object>) linked;
        return myList.get(key);
    }
    
    private Date getDateFromString(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.parse(date);
    }
    
    
    public HashMap<UUID,Iteration> getIterations(String json) throws ParseException {
        HashMap<UUID,Iteration> returnValue = new HashMap<>();
        DocumentContext jsonContext = JsonPath.parse(json);
        JSONArray iterations = jsonContext.read("$[*]");
        DateFormat df  = DateFormat.getDateInstance();
        for (int index = 0; index<iterations.size(); index++){
            Iteration iteration = new Iteration();
            iteration.setIterationId((Integer) getValueFromLinkedHashMap(iterations.get(index), ClubHouseStatics.ID_ENTITY));
            iteration.setName((String) getValueFromLinkedHashMap(iterations.get(index), ClubHouseStatics.NAME_ENTITY));
            iteration.setStart(new Timestamp(getDateFromString((String)getValueFromLinkedHashMap(iterations.get(index), ClubHouseStatics.START_DATE)).getTime()));
            iteration.setEnd(new Timestamp(getDateFromString((String)getValueFromLinkedHashMap(iterations.get(index), ClubHouseStatics.END_DATE)).getTime()));
            returnValue.put(UUID.randomUUID(), iteration);
        }
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
            aProject.setName((String)getValueFromLinkedHashMap(projects.get(index), ClubHouseStatics.NAME_ENTITY) );
            returnValue.put(UUID.randomUUID(), aProject);
            
        }
        return returnValue;
    }
    
}
