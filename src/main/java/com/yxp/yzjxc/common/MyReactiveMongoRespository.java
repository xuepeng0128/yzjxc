package com.yxp.yzjxc.common;

import lombok.NonNull;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleReactiveMongoRepository;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.io.Serializable;
import java.util.List;

public class MyReactiveMongoRespository<T, ID extends Serializable> extends SimpleReactiveMongoRepository {
    public MyReactiveMongoRespository(@NonNull MongoEntityInformation entityInformation, @NonNull ReactiveMongoOperations mongoOperations,
                                      MongoOperations mongoOperations1, MongoEntityInformation<T, ID> entityInformation1) {
        super(entityInformation, mongoOperations);
        this.mongoOperations = mongoOperations1;
        this.entityInformation = entityInformation1;
    }
    private final MongoOperations mongoOperations;
    private final MongoEntityInformation<T, ID> entityInformation;



    //包含Example的方法
    public <S extends T> Page<S> findAll(final Example<S> example, final Query query,
                                         Pageable pageable){
        Assert.notNull(example, "Sample must not be null!");
        query.addCriteria((new Criteria()).alike(example)).with(pageable);
        List<S> list = this.mongoOperations.find(query, example.getProbeType(),
                this.entityInformation.getCollectionName());
        return PageableExecutionUtils.getPage(list, pageable,
                () -> mongoOperations.count(query,example.getProbeType(),
                        entityInformation.getCollectionName()));
    }

    //去除Example的方法(大佬修改)
    public <S extends T> Page<S> findAll(Query query, Pageable pageable, Class<S> clazz) {
        final Class<S> clazz2  = (Class<S>) ClassUtils.getUserClass(clazz);
        query.with(pageable);
        List<S> list = this.mongoOperations.find(query,clazz,
                this.entityInformation.getCollectionName());
        return PageableExecutionUtils.getPage(list, pageable,
                () -> mongoOperations.count(query,clazz2,
                        entityInformation.getCollectionName()));
    }






}
