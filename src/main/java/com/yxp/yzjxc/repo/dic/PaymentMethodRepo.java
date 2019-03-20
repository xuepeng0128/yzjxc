package com.yxp.yzjxc.repo.dic;

import com.yxp.yzjxc.entity.PaymentMethod;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepo extends ReactiveMongoRepository<PaymentMethod,Integer> {
}
