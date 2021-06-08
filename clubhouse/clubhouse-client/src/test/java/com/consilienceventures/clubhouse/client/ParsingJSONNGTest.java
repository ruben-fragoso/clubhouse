/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consilienceventures.clubhouse.client;

import com.consilienceventures.clubhouse.model.Iteration;
import java.util.HashMap;
import java.util.UUID;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.consilienceventures.clubhouse.model.Project;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ruben
 */
public class ParsingJSONNGTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ParsingJSONNGTest.class);
    
    public ParsingJSONNGTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @BeforeMethod
    public void setUpMethod() throws Exception {
    }
    
    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    @Test
    public void testParseProject() throws IOException, ParseException {
        ClubhouseJSONParser clubhouseJSONParser = new ClubhouseJSONParser();
        byte[] lines = Files.readAllBytes((Paths.get("src/test/resources/json/projects.json")));
        String json = new String(lines, StandardCharsets.UTF_8);
        HashMap<UUID, Project> hashMap = clubhouseJSONParser.getProjects(json);
        LOGGER.info("" + hashMap.size());
    }

    @Test
    public void testParseIterations() throws IOException, ParseException {
        ClubhouseJSONParser clubhouseJSONParser = new ClubhouseJSONParser();
        byte[] lines = Files.readAllBytes((Paths.get("src/test/resources/json/iterations.json")));
        String json = new String(lines, StandardCharsets.UTF_8);
        HashMap<UUID, Iteration> hashMap = clubhouseJSONParser.getIterations(json);
        LOGGER.info("" + hashMap.size());
        
    }
}
