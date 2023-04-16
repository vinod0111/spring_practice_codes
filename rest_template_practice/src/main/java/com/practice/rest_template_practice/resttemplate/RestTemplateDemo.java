package com.practice.rest_template_practice.resttemplate;

import com.practice.rest_template_practice.DTOS.IdeaDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestTemplateDemo {
    /**
     * Fetch the data in the form of plane json
     */



    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String URI = "http://localhost:8080/demo_app/v1/ideas";

//        restTemplateSimpleCall(restTemplate, URI);

//        readAsPOJO(restTemplate, URI);

//        makingPostCallFromRestTemplate(restTemplate, URI);
        makingPutCallFromRestTemplate(restTemplate, URI);

        makingDeleteCallFromRestTemplate(restTemplate, URI);


    }

    static void restTemplateSimpleCall(RestTemplate restTemplate, String URI) {
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

    static void readAsPOJO(RestTemplate restTemplate, String URI) {

        List<IdeaDTO> ideaDTOs = restTemplate.getForObject(URI, List.class);

        System.out.println(ideaDTOs);
    }

    static void makingPostCallFromRestTemplate(RestTemplate restTemplate, String URI) {

        IdeaDTO ideaDTO = new IdeaDTO(125, "idea no 125", "description for idea 125", "aron");

        IdeaDTO ideaDtoStored = restTemplate.postForObject(URI,ideaDTO, IdeaDTO.class);

        System.out.println("<!============CREATED RESOURCES===============>");
        System.out.println(ideaDtoStored);
    }

    static void makingPutCallFromRestTemplate(RestTemplate restTemplate, String URI) {
        IdeaDTO ideaDTO = new IdeaDTO(125, "idea no 125", "description for idea 125 udated", "aron");

        HttpEntity<IdeaDTO> updateRequest = new HttpEntity<>(ideaDTO, null);
        restTemplate.exchange(URI+"/"+ideaDTO.getId(), HttpMethod.PUT, updateRequest, Void.class);

    }

    static void makingDeleteCallFromRestTemplate(RestTemplate restTemplate, String URI) {

        restTemplate.delete(URI+"/125");
    }
}

