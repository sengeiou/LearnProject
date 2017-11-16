package com.cocoa.springdemo.demo.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("/demo1")
@RestController
public class HelloController {

    @Value("valuetest")
    private String value;

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String hello(){
        return  value;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/modelandview")
    public ModelAndView modelview(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","cocoa");
        modelAndView.setViewName("modelview");
        return modelAndView;
    }



}
