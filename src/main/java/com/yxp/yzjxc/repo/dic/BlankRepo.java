package com.yxp.yzjxc.repo.dic;

import com.yxp.yzjxc.entity.Blank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlankRepo extends MongoRepository<Blank,String> {
}
