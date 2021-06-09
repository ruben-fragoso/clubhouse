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
    
    
}