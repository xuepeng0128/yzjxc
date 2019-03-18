package com.yxp.yzjxc.repo.purchase;

import com.yxp.yzjxc.entity.OrderBill;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface OrderBillRepo extends ReactiveMongoRepository<OrderBill,String> {
}
