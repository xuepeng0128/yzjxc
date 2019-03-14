package com.yxp.yzjxc.repo.sys;

import com.yxp.yzjxc.entity.CorpMsg;
import com.yxp.yzjxc.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends MongoRepository<User,String> {
    public List<User> findUserByUserId(String userId);
    public List<User> findUserByUserIdAndPassWord(String userId,String passWord);
}
