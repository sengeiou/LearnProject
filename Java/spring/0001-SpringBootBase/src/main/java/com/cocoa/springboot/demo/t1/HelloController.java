package com.cocoa.springboot.demo.t1;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {


    @RequestMapping(method = RequestMethod.GET, value = "/say")
    public String hello(){
        return "Hello Spring Boot";
    }

    // 读取 url 路径
    @RequestMapping(method = RequestMethod.GET , value = "/{path}")
    public String readPath(@PathVariable("path") String path){
        return path;
    }

}
