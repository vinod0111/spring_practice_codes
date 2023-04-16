package com.practice.rest_template_practice.webclienttemplates;

import com.practice.rest_template_practice.DTOS.IdeaDTO;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

public class WebClientDemo {

    public static void main(String[] args) {

        String host="http://localhost:8080";
        WebClient webClient = WebClient.create(host);
        /***
         * CRUD operations
         */
//        makePost(webClient);
//        makeGet(webClient);
//        makeUpdate(webClient);

        makeDelete(webClient);

    }

    static void makePost(WebClient webClient) {

        IdeaDTO ideaDTO = new IdeaDTO(126, "idea 126", "deascription for idea 126", "aron");

        Mono<IdeaDTO> savedIdeaDetails = webClient.post().uri("demo_app/v1/ideas").bodyValue(ideaDTO).retrieve().bodyToMono(IdeaDTO.class);
        System.out.println("Creating the idea");
        System.out.println(savedIdeaDetails.block());
        // to handle asynchronously we need ot add handleres
    }

    static void makeGet(WebClient webClient) {

        Mono<List> ideaDTOS = webClient.get().uri("demo_app/v1/ideas").retrieve().bodyToMono(List.class);
        System.out.println("<!===============IDEAS==============>");
        System.out.println(ideaDTOS.block());

        Mono<IdeaDTO> idea = webClient.get().uri("demo_app/v1/ideas/121").retrieve().bodyToMono(IdeaDTO.class);

        System.out.println("<!==============================FETCHING IDEA===========================>");
        System.out.println(idea.block());
    }

    static void makeUpdate(WebClient webClient) {

        System.out.println("");

        IdeaDTO ideaDTO = new IdeaDTO(122, "idea 122", "updated for idea 122", "aron");

        Mono<IdeaDTO> updatedIdea = webClient.put().uri("demo_app/v1/ideas/122").bodyValue(ideaDTO).retrieve().bodyToMono(IdeaDTO.class);

        System.out.println("<!=========updated value==========>");
        System.out.println(updatedIdea.block());


    }

    static void makeDelete(WebClient webClient) {

        Mono<IdeaDTO> deletedIdea = webClient.delete().uri("demo_app/v1/ideas/122").retrieve().bodyToMono(IdeaDTO.class);

        System.out.println(deletedIdea.block());

    }


}
