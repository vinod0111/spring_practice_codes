package com.practice.controller.controller_practice.controller;

import com.practice.controller.controller_practice.DTO.IdeaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/demo_app/v1")
public class IdeaController {

    private static final Map<Integer, IdeaDTO> IDEA_MAP = new HashMap<>();

    public IdeaController() {
        IdeaDTO ideaDTO1 = new IdeaDTO(121, "idea1", "index value for idea is 1", "aron");
        IdeaDTO ideaDTO2 = new IdeaDTO(122, "idea2", "index value for idea is 2", "aron");
        IdeaDTO ideaDTO3 = new IdeaDTO(123, "idea3", "index value for idea is 3", "aron");
        IdeaDTO ideaDTO4 = new IdeaDTO(124, "idea4", "index value for idea is 4", "aron");

        IDEA_MAP.put(ideaDTO1.getId(), ideaDTO1);
        IDEA_MAP.put(ideaDTO2.getId(), ideaDTO2);
        IDEA_MAP.put(ideaDTO3.getId(), ideaDTO3);
        IDEA_MAP.put(ideaDTO4.getId(), ideaDTO4);

    }

    /**
     * Search idea based on the id
     * GET: 127.0.0.1:8080/demo_app/ideas/121
     * RESPONSE: details of idea 121
     */
    @GetMapping(value="/ideas/{id}")
    public ResponseEntity fetchIdeaById(@PathVariable(name="id") int id){
        return new ResponseEntity(IDEA_MAP.get(id), HttpStatus.OK);
    }

    /***
     *  CRUD
     *
     * C - create   : POST  : @PostMapping
     * R - Read     : GET   : @GetMapping
     * U - UPDATE   : PUT   : @PutMapping
     * D - DELETE   : DELETE: @DeleteMapping
     */
//    @PostMapping(value="/ideas")
//    public ResponseEntity createIdea(IdeaDTO ideaDTO) {
//
//        System.out.println(ideaDTO);
//
//        IDEA_MAP.put(ideaDTO.getId(), ideaDTO);
//
//        return new ResponseEntity(ideaDTO, HttpStatus.OK);
//    }

    // above method will get only null values as the mapping from input wahtever is coming that is not mapped

    @PostMapping(value="/ideas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createIdea(@RequestBody IdeaDTO ideaDTO) {

        System.out.println(ideaDTO);

        IDEA_MAP.put(ideaDTO.getId(), ideaDTO);

        return new ResponseEntity(ideaDTO, HttpStatus.OK);
    }

    /**
     * get all ideas
     *
     * GET: http://127.0.0.1:8080/demo_app/ideas
     */
    @GetMapping(value="/ideas", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity fetchAllTheIdeas(){

        List<IdeaDTO> ideas = new ArrayList<>();

        for (IdeaDTO ideaDTO: IDEA_MAP.values()) {
            ideas.add(ideaDTO);
        }

        return new ResponseEntity(ideas, HttpStatus.OK);
    }

    /**
     * U -> update
     *
     * @PutMapping
     *
     * PUT  :   127.0.0.1:8080/demo_app/v1/ideas
     *
     * request body: json
     *
     * path param -> @PathVariable
     *
     * request body -> @RequestBody
     */
    @PutMapping(value="/ideas/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateIdea(@PathVariable(name="id") int id, @RequestBody IdeaDTO ideaDTO) {
        IDEA_MAP.put(id, ideaDTO);
        return new ResponseEntity(ideaDTO, HttpStatus.OK);
    }

    /**
     * Delete resource
     *
     * DELETE 127.0.0.1:8080/demo_app/v1/ideas/{id}
     */
    @DeleteMapping(value="/ideas/{id}")
    public ResponseEntity deleteIdea(@PathVariable(name = "id") int id) {
        IDEA_MAP.remove(id);
        return new ResponseEntity(null, HttpStatus.OK);
    }

}
