package com.cocoa.springboot.demo.t1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Value("${valueTest}") // 从 application.properties 获取自定义的值
    private String valueTest;

    // 测试下没有的值
//    @Value("${valueTest123}")
//    private int noCount;

    @RequestMapping(value = "valueTest")
    public String valueTest(){
        return valueTest ;
    }

    // 定义 RequestMethod
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
