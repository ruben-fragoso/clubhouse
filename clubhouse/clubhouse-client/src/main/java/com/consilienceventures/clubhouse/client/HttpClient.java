/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consilienceventures.clubhouse.client;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import java.io.IOException;
import java.text.ParseException;
import net.minidev.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClient {

   private static final Logger LOGGER = LoggerFactory.getLogger(HttpClient.class);

    private String baseURL;
    private String token;

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public String getToken() {
        return token;
    }

    /**
     *
     * @param method True for Post, False for Get
     * @param id
     * @param body
     * @return
     */
    public String getData(Boolean method, String finalURL, String body) throws IOException {
        String returnValue = new String();
        GenericUrl url = new GenericUrl(getBaseURL() + finalURL);
        HttpRequest request;
        LOGGER.info(url.toString());
        HttpRequestFactory requestFactory
                = new NetHttpTransport().createRequestFactory();
        if (method == Boolean.TRUE) {
            request = requestFactory.buildPostRequest(url, ByteArrayContent.fromString(ClubHouseStatics.BODY_TYPE, body));
        } else {
            request = requestFactory.buildGetRequest(url);
        }
        request.getHeaders().setContentType(ClubHouseStatics.BODY_TYPE);
        request.getHeaders().set(ClubHouseStatics.TOKEN_HEADER, getToken());//"608a81c5-e460-4b39-a6b0-d65ca054a6d5");
        returnValue = request.execute().parseAsString();
        LOGGER.debug(returnValue);
        return returnValue;
    }

}
