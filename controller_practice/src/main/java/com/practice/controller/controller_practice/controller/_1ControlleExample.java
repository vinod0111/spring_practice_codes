package com.practice.controller.controller_practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("demo")
/**
 *  127.0.0.1:8080/demo
 */
public class _1ControlleExample {

    // need to add @ResponseBody to bind return to response body
    @RequestMapping(value = "/h1", method = RequestMethod.GET)
    public @ResponseBody String helloStudents() {
        System.out.println("invoked H1");
        return "Hello students from @controler demo from normal";
    }

    @GetMapping(value="/h2")
    public @ResponseBody String helloStudentGetMAp() {
        System.out.println("invoked H2");
        return "Hello from Get mapping";
    }


}
