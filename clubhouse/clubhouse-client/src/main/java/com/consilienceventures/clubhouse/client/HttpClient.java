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

public class HttpClient {

    public static void main(String[] args) throws IOException, ParseException {

        
        GenericUrl url = new GenericUrl("https://api.clubhouse.io/api/v3/stories/search");
        HttpRequestFactory requestFactory
                = new NetHttpTransport().createRequestFactory();
            String requestBody =  "{\"project_id\": 2006}";
        HttpRequest request = requestFactory.buildPostRequest(url, ByteArrayContent.fromString("application/json", requestBody));
        request.getHeaders().setContentType("application/json");
        request.getHeaders().set("Clubhouse-Token", "608a81c5-e460-4b39-a6b0-d65ca054a6d5");    
        String rawResponse = request.execute().parseAsString();
        System.out.print(rawResponse);
        DocumentContext jsonContext = JsonPath.parse(rawResponse);
         JSONArray releasestest = jsonContext.read("$[*]");
        
        
    }

}
