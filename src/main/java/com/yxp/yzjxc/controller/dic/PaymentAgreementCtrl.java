package com.yxp.yzjxc.controller.dic;

import com.yxp.yzjxc.entity.PaymentAgreement;
import com.yxp.yzjxc.service.dic.PaymentAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dic/paymentAgreement", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class PaymentAgreementCtrl {
    @Autowired
    PaymentAgreementService svr;

    @GetMapping(value = "/paymentAgreementList")
    public List<PaymentAgreement> paymentAgreementList(){
        List<PaymentAgreement> list = svr.paymentAgreementList();
        return list;

    }

    @PostMapping(value="/insertPaymentAgreement")
    public PaymentAgreement insertPaymentAgreement(@RequestBody PaymentAgreement paymentAgreement)
    {
        return svr.insertPaymentAgreement(paymentAgreement);
    }

    @PostMapping(value="/updatePaymentAgreement")
    public PaymentAgreement updatePaymentAgreement(@RequestBody PaymentAgreement paymentAgreement)
    {
        return svr.updatePaymentAgreement(paymentAgreement);
    }

    @GetMapping(value="/deletePaymentAgreement")
    public String deletePaymentAgreement(String paymentAgreementId){
        try{
            svr.deletePaymentAgreement(Integer.valueOf(paymentAgreementId));
            return "ok";
        }catch (Exception ex){
            return ex.toString();
        }
    }




}
