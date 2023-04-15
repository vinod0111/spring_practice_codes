package com.practice.controller.controller_practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/demo3", "multiuri1"})
public class _3MultiUriExample {

    @RequestMapping(value = "/h1", method = RequestMethod.GET)
    public String helloStudents() {
        System.out.println("invoked H1");
        return "Hello students from @controler demo from normal";
    }

    @GetMapping(value={"/h2","/greet"})
    public String helloStudentGetMAp() {
        System.out.println("invoked H2");
        return "Hello from Get mapping";
    }

}
