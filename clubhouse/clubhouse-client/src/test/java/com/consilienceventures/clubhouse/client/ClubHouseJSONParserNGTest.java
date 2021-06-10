/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consilienceventures.clubhouse.client;

import bsh.ParseException;
import com.consilienceventures.clubhouse.model.Change;
import com.consilienceventures.clubhouse.model.Iteration;
import com.consilienceventures.clubhouse.model.Project;
import com.consilienceventures.clubhouse.model.Story;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author ruben
 */
public class ClubHouseJSONParserNGTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClubHouseJSONParserNGTest.class);

    public ClubHouseJSONParserNGTest() {
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
    public void testParseProject() throws IOException, ParseException, java.text.ParseException {
        ClubHouseJSONParser clubhouseJSONParser = new ClubHouseJSONParser();
        byte[] lines = Files.readAllBytes((Paths.get("src/test/resources/json/projects.json")));
        String json = new String(lines, StandardCharsets.UTF_8);
        HashMap<UUID, Project> hashMap = clubhouseJSONParser.getProjects(json);
        LOGGER.info("" + hashMap.size());
    }

    @Test
    public void testParseIterations() throws IOException, ParseException, java.text.ParseException {
        ClubHouseJSONParser clubhouseJSONParser = new ClubHouseJSONParser();
        byte[] lines = Files.readAllBytes((Paths.get("src/test/resources/json/iterations.json")));
        String json = new String(lines, StandardCharsets.UTF_8);
        HashMap<UUID, Iteration> hashMap = clubhouseJSONParser.getIterations(json);
        LOGGER.info("" + hashMap.size());

    }

   
    /**
     * Test of getStory method, of class ClubHouseJSONParser.
     */
    @Test
    public void testGetStory() throws Exception {
        ClubHouseJSONParser clubhouseJSONParser = new ClubHouseJSONParser();
        byte[] lines = Files.readAllBytes((Paths.get("src/test/resources/json/Story.json")));
        String json = new String(lines, StandardCharsets.UTF_8);
        ClubHouseJSONParser instance = new ClubHouseJSONParser();
        Story expResult = new Story();
        expResult.setStoryid(Integer.SIZE);
        Story result = instance.getStory(json, expResult);
        assertEquals(result.getStoryid(), expResult.getStoryid());
//        assertEquals(result.getName(), "## Acceptance\\n- [Figma](https://www.figma.com/file/aBbk2LcaJDpmqlWWfW1bfo/Consilience-Ventures-UX-UI-%F0%9F%9B%A0?node-id=4318%3A390)\\n- Once the handshake between the selected bidder and TO is complete, the state icon on bid cards should read: Confirmed\\n- This label should appear on:\\n   - Bid cards in My Dashboard from the expert's POV\\n   - Bid cards on ticket details screen from the TO POV\\n   - Bid outcome component on bid details.\\n\\n> Note: It's likely that the label is correct in most places already - this card is about making it consistent across the three areas in the bullet point.");
        
    }
    
    @Test
    public void testGetChanges() throws Exception {
        ClubHouseJSONParser clubhouseJSONParser = new ClubHouseJSONParser();
        byte[] lines = Files.readAllBytes((Paths.get("src/test/resources/json/story_history.json")));
        ClubHouseJSONParser instance = new ClubHouseJSONParser();
        String json = new String(lines, StandardCharsets.UTF_8);
        HashMap<UUID,Change> result = instance.getChanges(json);
        LOGGER.info("OK");
        
    }

}
