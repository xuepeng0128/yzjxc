package com.yxp.yzjxc.service.purchase;

import com.yxp.yzjxc.entity.OrderBill;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface OrderBillService {

    public List<OrderBill> orderBillList(String orderId, String supplierName, String paymentAgreementId, String otherAgreement , String pageSize, String pageNo);


    public OrderBill insertOrderBill(OrderBill orderBill);

    public OrderBill updateOrderBill(OrderBill orderBill);

    public void deleteOrderBill(String orderId);
}
