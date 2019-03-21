package com.yxp.yzjxc.controller.purchase;

import com.yxp.yzjxc.common.MessageModel;
import com.yxp.yzjxc.entity.OrderBill;
import com.yxp.yzjxc.service.purchase.OrderBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/purchase/orderbill", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class OrderBillCtrl {
    @Autowired
    OrderBillService svr;

    @GetMapping(value="/orderBillList")
    public MessageModel orderBillList(String orderId,String supplierName,String paymentAgreementId,String otherAgreement,String pageSize,String pageNo){
          MessageModel m= new MessageModel();
          List<OrderBill> list=    svr.orderBillList(orderId,supplierName,paymentAgreementId,otherAgreement,pageSize,pageNo);
          m.setData(list);
          return m;
    }

    @PostMapping(value="/insertOrderBill")
    public MessageModel insertOrderBill(@RequestBody OrderBill orderBill){
        MessageModel m= new MessageModel();
        OrderBill o=svr.insertOrderBill(orderBill);
        m.setData(o == null ? "fail" : o.getOrderId());
        return m;
    }
    @PostMapping(value="/updateOrderBill")
    public MessageModel updateOrderBill(@RequestBody OrderBill orderBill){
        MessageModel m= new MessageModel();
        OrderBill o=svr.updateOrderBill(orderBill);
        m.setData(o == null ? "fail" : o.getOrderId());
        return m;
    }
    @GetMapping(value="/deleteOrderBill")
    public MessageModel deleteOrderBill(String orderId){
       MessageModel m= new MessageModel();
       try{
           svr.deleteOrderBill(orderId);
           m.setData("ok");
       }catch (Exception ex){
           m.setData(ex.toString());
       }
       return m;
    }
}
