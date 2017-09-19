package com.example.demo.bean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by sj on 17/8/30.
 */
@NoRepositoryBean
public interface CommitItemRepo extends JpaRepository<CommitItem,Long>{

}
