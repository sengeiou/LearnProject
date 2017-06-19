package com.example.demo;

import com.google.gson.Gson;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sj on 17/6/19.
 */
@RestController
@RequestMapping("/")
public class HelloController {

    @RequestMapping(value = "/{value}", method = RequestMethod.GET)
    @ResponseBody
    public List<User> hello() {
        User user = new User();
        user.setName("cocoa");
        user.setAge(22);
        user.setId(10023);
        ArrayList<User> arrayList = new ArrayList<>();
        arrayList.add(user);
        return arrayList;
    }
}
