package com.example.demo.service;

import com.example.demo.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by sj on 17/6/20.
 */
@Service
public class PersonService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Person> getList() {
        String sql = "select * from MyPerson";
        return jdbcTemplate.query(sql, new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet resultSet, int i) throws SQLException {
                Person p = new Person();
                p.setAge(resultSet.getInt("id"));
                p.setName(resultSet.getString("name"));
                return p;
            }
        });

    }
}
