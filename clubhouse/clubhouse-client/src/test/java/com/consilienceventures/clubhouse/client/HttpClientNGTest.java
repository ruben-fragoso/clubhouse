/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consilienceventures.clubhouse.client;

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
public class HttpClientNGTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientNGTest.class);

    public HttpClientNGTest() {
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

    /**
     * Test of getData method, of class HttpClient.
     */
    @Test
    public void testGetData() throws Exception {
        Boolean method = Boolean.TRUE;
        String finalURL = "stories/search";
        String body = "{\"iteration_id\": 2279}";
        HttpClient instance = new HttpClient();
        instance.setBaseURL(ClubHouseStatics.BASE);
        instance.setToken("608a81c5-e460-4b39-a6b0-d65ca054a6d5");
        String result = instance.getData(method, finalURL, body);
    }

}
