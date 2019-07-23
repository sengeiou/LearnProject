package com.cocoa.taobao.product_server.impl;

import com.cocoa.taobao.product_server.bean.page.MongoPageable;
import com.cocoa.taobao.product_server.bean.page.PageModel;
import com.cocoa.taobao.product_server.service.ItemDetailService;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDetailDaoImpl implements ItemDetailService {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public <T> T find(String id, Class<T> clazz, String collection) {
        return mongoTemplate.findOne(new Query(Criteria.where("_id").is(id)), clazz, collection);
    }

    @Override
    public <T> T findByNumiid(String num_iid, Class<T> clazz, String collection) {
        return mongoTemplate.findOne(new Query(Criteria.where("num_iid").is(num_iid)), clazz, collection);
    }

    public <T> List<T> findByNumiids(String num_iid, Class<T> clazz, String collection) {
        return mongoTemplate.find(new Query(Criteria.where("num_iid").is(num_iid)), clazz, collection);
    }


    @Override
    public <T> List<T> findAll(Class<T> clazz, String collection) {
        return mongoTemplate.findAll(clazz, collection);
    }

    @Override
    public <T> void insertOne(T item, String collection) {
        mongoTemplate.save(item, collection);
    }


    public <T> List<T> findSortList(PageModel page, String sortName, Sort.Direction direction, Class<T> clazz, String collection) {
        Query query = new Query();
        query.with(new Sort(new Sort.Order(direction, sortName)));
        query.skip(page.getSkip()).limit(page.getPageSize());
        return mongoTemplate.find(query, clazz, collection);
    }

    public <T> MongoPageable<T> findSortListTotal(PageModel page, String sortName, Sort.Direction direction, Class<T> clazz, String collection) {
//        Query query = new Query();
//        query.with(new Sort(new Sort.Order(direction, sortName)));
//        query.skip(page.getSkip()).limit(page.getPageSize());
//        MongoPageable mongoPageable = new MongoPageable();
//        mongoPageable.setList(mongoTemplate.find(query, clazz, collection));
//        mongoPageable.setTotal(mongoTemplate.count(query, clazz, collection));
        return findSortListTotal(page, sortName, direction, null, clazz, collection);
    }


    public <T> MongoPageable<T> findSortListTotal(PageModel page, String sortName, Sort.Direction direction, Criteria criteria, Class<T> clazz, String collection) {
        Query query = new Query();
        if (criteria != null) {
            query.addCriteria(criteria);
        }
        query.with(new Sort(new Sort.Order(direction, sortName)));
        query.skip(page.getSkip()).limit(page.getPageSize());
        MongoPageable mongoPageable = new MongoPageable();
        mongoPageable.setList(mongoTemplate.find(query, clazz, collection));
        mongoPageable.setTotal(mongoTemplate.count(query, clazz, collection));
        return mongoPageable;
    }


    public <T> T findBy_Id(String id, Class<T> clazz, String collection) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, clazz, collection);
    }

    public WriteResult update(String id, Update update, String collection) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.updateFirst(query, update, collection);
    }

}
