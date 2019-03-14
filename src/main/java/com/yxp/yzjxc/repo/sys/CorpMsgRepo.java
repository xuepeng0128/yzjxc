package com.yxp.yzjxc.repo.sys;

import com.yxp.yzjxc.entity.CorpMsg;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorpMsgRepo extends MongoRepository<CorpMsg,ObjectId> {
    public List<CorpMsg> findCorpMsgByAddress(String address);
}
