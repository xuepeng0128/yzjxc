package com.yxp.yzjxc.serviceimpl.purchase;

import com.yxp.yzjxc.entity.OrderBill;
import com.yxp.yzjxc.entity.PaymentAgreement;
import com.yxp.yzjxc.entity.Supplier;
import com.yxp.yzjxc.entity.User;
import com.yxp.yzjxc.repo.purchase.OrderBillRepo;
import com.yxp.yzjxc.service.purchase.OrderBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.ScriptOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.Field;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    public Flux<OrderBill> orderBillList(String orderId,String supplierName,String paymentAgreementId,String otherAgreement,String pageSize,String pageNo) {
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

        Flux<OrderBill> result= reactiveMongoTemplate.aggregate(agg,"orderbill",OrderBill.class);
//        List<OrderBill> listRes = result.collectList().block();
//        Map<String,Object> re = new HashMap<String,Object>();
//        re.put("result",listRes);
        return  result;
    }

    @Override
    public Mono<String> insertOrderBill(OrderBill orderBill) {
        orderBill.setOrderId(this.makeOrderId());
        return  repo.insert(orderBill)==null ? Mono.just(""): Mono.just(orderBill.getOrderId())  ;
    }

    @Override
    public Mono<Boolean> updateOrderBill(OrderBill orderBill) {
       return  repo.save(orderBill)==null ? Mono.just(false) :Mono.just(true);
    }

    @Override
    public Mono<Boolean> deleteOrderBill(String orderId) {
        try{
            repo.deleteById(orderId);
            return Mono.just(true);
        }catch (Exception ex){
            return Mono.just(false);
        }
    }



    private String makeOrderId(){
        ScriptOperations scriptOps = mongoTemplate.scriptOps();
        String orderid= scriptOps.call("makeBillId","orderbill").toString();
        return orderid;
    }



}
