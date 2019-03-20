package com.yxp.yzjxc.repo.sys;

import com.yxp.yzjxc.entity.Menu;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepo extends ReactiveMongoRepository<Menu,String> {

}
