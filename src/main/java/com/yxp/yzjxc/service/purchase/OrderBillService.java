package com.yxp.yzjxc.service.purchase;

import com.yxp.yzjxc.entity.OrderBill;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderBillService {

    public Flux<OrderBill> orderBillList(String orderId,String supplierName,String paymentAgreementId,String otherAgreement ,String pageSize,String pageNo);


    public Mono<String> insertOrderBill(OrderBill orderBill);

    public Mono<Boolean> updateOrderBill(OrderBill orderBill);

    public Mono<Boolean> deleteOrderBill(String orderId);
}
