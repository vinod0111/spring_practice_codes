package com.practice.controller.controller_practice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("demo2")
public class _2RestControllerExample {
    // need to add @ResponseBody to bind return to response body
    @RequestMapping(value = "/h1", method = RequestMethod.GET)
    public String helloStudents() {
        System.out.println("invoked H1");
        return "Hello students from @controler demo from normal";
    }

    @GetMapping(value="/h2")
    public String helloStudentGetMAp() {
        System.out.println("invoked H2");
        return "Hello from Get mapping";
    }
}
