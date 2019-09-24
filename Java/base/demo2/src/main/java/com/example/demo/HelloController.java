package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sj on 17/5/19.
 */

@RestController
public class HelloController {

    @RequestMapping("/index")
    public String hello(){
        return "Hello ";
    }

}
