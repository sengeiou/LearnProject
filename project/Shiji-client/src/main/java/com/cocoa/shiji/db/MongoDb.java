package com.cocoa.shiji.db;

import com.cocoa.shiji.util.NullUtil;
import com.cocoa.shiji.util.PropretyUtil;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;
import com.mongodb.client.*;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class MongoDb {

    public static final String TAG = MongoDb.class.getSimpleName();


    MongoCollection<Document> collection;
    private int server_port ;
    private String server_url;
    private MongoClient mongoClient;

    private String username ;
    private String password ;
    private String auth_db ;
    private String db ;


    public MongoDb() {
        Properties  p = PropretyUtil.getPps();
        this.server_port = Integer.parseInt(p.getProperty("spring.data.mongodb.port"));
        this.server_url =  p.getProperty("spring.data.mongodb.host");
        this.username =  p.getProperty("spring.data.mongodb.username");
        this.password =  p.getProperty("spring.data.mongodb.password");
        this.auth_db =  p.getProperty("spring.data.mongodb.authentication-database");
        this.db =  p.getProperty("spring.data.mongodb.database");
    }

    public MongoDb(int server_port, String server_url) {
        this.server_port = server_port;
        this.server_url = server_url;
    }

    public MongoDb connect() {
        MongoCredential credential = MongoCredential.createCredential(username, auth_db, password.toCharArray());
        mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder ->
                                builder.hosts(Arrays.asList(new ServerAddress(server_url, server_port))))
                        .credential(credential)
                        .build());
        return this;
    }


    public MongoCollection<Document> useDbCollection(String collectionName) {
        MongoDatabase mongoDatabase = mongoClient.getDatabase(this.db );
        return mongoDatabase.getCollection(collectionName);
    }

    public void close() {
        mongoClient.close();
    }


}
