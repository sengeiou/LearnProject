package com.cocoa.springboot.demo.t3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserJpaRepo userJpaRepo;


    @Override
    public User findByName(String name) {
        return userJpaRepo.findByName(name);
    }
}
