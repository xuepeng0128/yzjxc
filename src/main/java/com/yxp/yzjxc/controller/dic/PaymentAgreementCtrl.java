package com.yxp.yzjxc.controller.dic;

import com.yxp.yzjxc.entity.PaymentAgreement;
import com.yxp.yzjxc.service.dic.PaymentAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/dic/paymentAgreement", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class PaymentAgreementCtrl {
    @Autowired
    PaymentAgreementService svr;

    @GetMapping(value = "/paymentAgreementList")
    public Flux<PaymentAgreement> paymentAgreementList(){
        Flux<PaymentAgreement> list = svr.paymentAgreementList();
        return list;

    }

    @PostMapping(value="/insertPaymentAgreement")
    public Mono<PaymentAgreement> insertUnit(@RequestBody PaymentAgreement paymentAgreement)
    {
        return svr.insertPaymentAgreement(paymentAgreement);
    }

    @PostMapping(value="/insertPaymentAgreement")
    public Mono<PaymentAgreement> updateUnit(@RequestBody PaymentAgreement paymentAgreement)
    {
        return svr.updatePaymentAgreement(paymentAgreement);
    }

    @GetMapping(value="/insertPaymentAgreement")
    public Mono<String> deletePaymentAgreement(String paymentAgreementId){
        try{
            svr.deletePaymentAgreement(Integer.valueOf(paymentAgreementId));
            return Mono.just("ok");
        }catch (Exception ex){
            return Mono.just(ex.toString());
        }
    }




}
