package com.yxp.yzjxc.repo.dic;

import com.yxp.yzjxc.entity.Unit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepo extends MongoRepository<Unit,String> {
}