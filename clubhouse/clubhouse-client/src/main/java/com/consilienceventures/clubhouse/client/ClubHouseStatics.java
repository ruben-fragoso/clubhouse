/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consilienceventures.clubhouse.client;

/**
 *
 * @author ruben
 */
public interface ClubHouseStatics {
    
    
    public static final String BASE="https://api.clubhouse.io/api/v3/";
    public static final String STORIES_SEARCH = "stories/search";
    public static final String ITERATION_FILTER ="{\"iteration_id\": </id>";
    public static final String PROJECT_FILTER ="{\"project_id\": </id>";  
    public static final String STORY_DETAIL ="stories/</id>/history";
    public static final String WORKFLOW_ENTITY ="workflow_state_id";
    public static final String ENTITY_TYPE="entity_type";
    public static final String NEW_ENTITY="new";
    public static final String OLD_ENTITY="old";
    public static final String CHANGED_ENTITY="changed_at";
    public static final String PROJECT_DETAIL="projects/</id>/stories";
    public static final String ID_ENTITY = "id";
    public static final String NAME_ENTITY = "name";
    public static final String TOKEN_HEADER = "Clubhouse-Token";
    public static final String BODY_TYPE = "application/json";
    public static final String PROJECTS_STORY = "projects";
    public static final String ITERATIONS = "iterations";
    public static final String START_DATE = "start_date";
    public static final String END_DATE = "end_date";
    public static final String EPIC_ID = "epic_id";
    public static final String REPLACE_ID = "</id>";
    public static final String STORY_ENDPOINT = "stories/</id>";
    public static final String TYPE_ENTITY = "story_type";
    public static final String PROJECT_ID = "project_id";
    public static final String CREATED_AT = "created_at";
    public static final String ESTIMATE_ENTITY = "estimate";
    public static final String ACTIONS_ENTITY = "actions";
    public static final String CHANGES_ENTITY = "changes";
    public static final String REFERENCES_ENTITY = "references";
    public static final String TIME_STAMP = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String CHANGE_STORY_ID = "primary_id";
    public static final String SPRING_STATUS = "status";
   
    
}
