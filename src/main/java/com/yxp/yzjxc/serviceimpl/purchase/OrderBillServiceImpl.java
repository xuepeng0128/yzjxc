package com.yxp.yzjxc.serviceimpl.purchase;

import com.yxp.yzjxc.entity.OrderBill;
import com.yxp.yzjxc.entity.PaymentAgreement;
import com.yxp.yzjxc.entity.Supplier;
import com.yxp.yzjxc.entity.User;
import com.yxp.yzjxc.repo.purchase.OrderBillRepo;
import com.yxp.yzjxc.service.purchase.OrderBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.ScriptOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.Field;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class OrderBillServiceImpl implements OrderBillService {
    @Autowired
    MongoTemplate mongoTemplate ;
   @Autowired
   ReactiveMongoTemplate reactiveMongoTemplate;
   @Autowired
    OrderBillRepo repo;

    private Date orderDate;
    private Supplier supplier;
    private PaymentAgreement paymentAgreement;
    private String otherAgreement;
    private String memo;
    private User makeBillMan;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mi")
    private Date makeTime;


    @Override
    public List<OrderBill> orderBillList(String orderId,String supplierName,String paymentAgreementId,String otherAgreement,String pageSize,String pageNo) {
        Criteria criteria = new Criteria( );
        if (orderId!=null && !orderId.equals(""))
        {
            criteria=criteria.and("orderId").regex(".*" +orderId +"*.");
        }
        if (supplierName!=null && !supplierName.equals(""))
        {
            criteria=criteria.and("supplier.supplierName").regex(".*" + supplierName + "*.");
        }
        if (paymentAgreementId!=null && !paymentAgreementId.equals("0") && !paymentAgreementId.equals(""))
        {
            criteria=criteria.and("paymentAgreement.paymentAgreementId").is(paymentAgreementId);
        }
        if (otherAgreement!=null && !otherAgreement.equals(""))
        {
            criteria=criteria.and("otherAgreement").regex(".*" + otherAgreement + "*.");
        }

        if (otherAgreement!=null && !otherAgreement.equals(""))
        {
            criteria=criteria.and("otherAgreement").regex(".*" + otherAgreement + "*.");
        }

        List<Field> fields = new ArrayList<Field>();
        Aggregation agg = Aggregation.newAggregation(
                Aggregation.match(criteria),

                Aggregation.project("price").andExpression("{$avg : '$price'} " ).as("avgPrice"),

                Aggregation.sort(Sort.Direction.DESC,"avgPrice"),
                Aggregation.skip(Integer.parseInt(pageSize) * (Integer.parseInt(pageNo)-1)),
                Aggregation.limit(1)
        );

        List<OrderBill> result= mongoTemplate.aggregate(agg,"orderbill",OrderBill.class).getMappedResults();
//        List<OrderBill> listRes = result.collectList().block();
//        Map<String,Object> re = new HashMap<String,Object>();
//        re.put("result",listRes);
        return  result;
    }

    @Override
    public OrderBill insertOrderBill(OrderBill orderBill) {
        orderBill.setOrderId(this.makeOrderId());
        return  repo.insert(orderBill) ;
    }

    @Override
    public OrderBill updateOrderBill(OrderBill orderBill) {
       return  repo.save(orderBill);
    }

    @Override
    public void deleteOrderBill(String orderId) {
            repo.deleteById(orderId);
    }



    private String makeOrderId(){
        ScriptOperations scriptOps =  mongoTemplate.scriptOps();
        String orderid= scriptOps.call("makeBillId","orderbill").toString();
        return orderid;
    }



}
