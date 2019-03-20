package com.yxp.yzjxc.repo.dic;

import com.yxp.yzjxc.entity.Blank;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlankRepo extends ReactiveMongoRepository<Blank,String> {
}
