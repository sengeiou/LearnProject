package com.example.demo.controller;

import com.example.demo.bean.CommitItem;
import com.example.demo.bean.CommitItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sj on 17/8/30.
 */
@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    private CommitItemRepo commitItemRepo;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String getTaoItem() {
        List<CommitItem> result = commitItemRepo.findAll();
        System.out.println(result.size()+"-=-====");
        return "123";
    }

}
