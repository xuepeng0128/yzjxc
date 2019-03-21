package com.yxp.yzjxc.repo.purchase;

import com.yxp.yzjxc.entity.OrderBill;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface OrderBillRepo extends MongoRepository<OrderBill,String> {
}
