package com.yxp.yzjxc.repo.dic;

import com.yxp.yzjxc.entity.Duty;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DutyRepo extends ReactiveMongoRepository<Duty,String> {
}
