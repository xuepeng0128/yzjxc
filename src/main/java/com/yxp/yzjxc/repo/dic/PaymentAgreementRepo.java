package com.yxp.yzjxc.repo.dic;

import com.yxp.yzjxc.entity.PaymentAgreement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PaymentAgreementRepo extends MongoRepository<PaymentAgreement,Integer> {
}
