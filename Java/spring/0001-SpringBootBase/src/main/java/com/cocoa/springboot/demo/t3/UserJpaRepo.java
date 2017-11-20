package com.cocoa.springboot.demo.t3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserJpaRepo extends JpaRepository<User,Long> {

    User findByName(String name);

}
