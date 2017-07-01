package com.example.demo.controller;

import com.example.demo.bean.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sj on 17/6/20.
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService mPersonService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Person> getList() {
        return mPersonService.getList();
    }

}
