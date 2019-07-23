package com.cocoa.taobao.product_server.conf;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

//@Configuration
//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
//@ComponentScan  extends AbstractMongoConfiguration
//@EnableMongoRepositories
public class MongoDataSourceConfig  {

//    // 数据库名
//    @Value("${mongo.dbname}")
//    private String dbName;
//    // 数据库地址
//    @Value("${mongo.dbhost}")
//    private String dbHost;
//    // 数据库端口
//    @Value("${mongo.dbport}")
//    private String dbPort;
//    // 用户名
//    @Value("${mongo.username}")
//    private String userName;
//    // 密码
//    @Value("${mongo.password}")
//    private String password;
//
//    /**
//     * 无参数的构造函数
//     */
//    public MongoDataSourceConfig() {
//        if (null == dbHost || "".equalsIgnoreCase(dbHost.trim())) {
//            dbHost = "28080";
//        }
//    }
//
//    @SuppressWarnings("deprecation")
//    @Bean
//    public Mongo mongo() throws Exception {
//        ServerAddress serverAdress = new ServerAddress(dbHost, Integer.valueOf(dbPort));
//        MongoCredential credential = MongoCredential.createMongoCRCredential(userName, dbName, password.toCharArray());
//        Mongo mongo = new MongoClient(serverAdress, Arrays.asList(credential));
//        mongo.setWriteConcern(WriteConcern.SAFE);
//        return mongo;
//    }
//
//    public String getDbName() {
//        return dbName;
//    }
//
//    public void setDbName(String dbName) {
//        this.dbName = dbName;
//    }
//
//    public String getDbHost() {
//        return dbHost;
//    }
//
//    public void setDbHost(String dbHost) {
//        this.dbHost = dbHost;
//    }
//
//    public String getDbPort() {
//        return dbPort;
//    }
//
//    public void setDbPort(String dbPort) {
//        this.dbPort = dbPort;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    protected String getDatabaseName() {
//        return this.dbName;
//    }

}