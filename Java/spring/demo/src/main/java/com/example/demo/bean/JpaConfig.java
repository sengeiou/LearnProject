package com.example.demo.bean;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManagerFactory;

/**
 * Created by sj on 17/8/30.
 */
@Configuration
@EnableJpaRepositories("com.example.demo.bean")
@EntityScan("com.example.demo.bean")
public class JpaConfig {
//    @Bean
//    public EntityManagerFactory entityManagerFactory{
//
//    }

}
