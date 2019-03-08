package com.yxp.yzjxc.repo.sys;

import com.yxp.yzjxc.entity.CorpMsg;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IcorpMsgRepo extends MongoRepository<CorpMsg,ObjectId> {
}
