package com.practice.rest_template_practice.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateBeanCreation {

    @Autowired
    RestTemplate restTemplate;
    String URI = "http://localhost:8080/demo_app/v1/ideas";

    public void fetchData() {

        ResponseEntity<String> ideaResponse = restTemplate.getForEntity(URI, String.class);
        System.out.println("<!------RESPONSE------------------>");
        System.out.println(ideaResponse);
        System.out.println("<!------RESPONSE------------------>");
        System.out.println(ideaResponse.getBody());
        System.out.println("<!------RESPONSE------------------>");
        System.out.println(ideaResponse.getStatusCode());
        System.out.println("<!------RESPONSE------------------>");
        System.out.println(ideaResponse.getHeaders());
    }
}
