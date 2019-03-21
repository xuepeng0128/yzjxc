package com.yxp.yzjxc.controller.dic;

import com.yxp.yzjxc.entity.PaymentMethod;
import com.yxp.yzjxc.service.dic.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dic/paymentMethod", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class PaymentMethodCtrl {
    @Autowired
    PaymentMethodService svr;

    @GetMapping(value = "/paymentMethodList")
    public List<PaymentMethod> paymentMethodList(){
        List<PaymentMethod> list = svr.paymentMethodList();
        return list;

    }

    @PostMapping(value="/insertPaymentMethod")
    public PaymentMethod insertPaymentMethod(@RequestBody PaymentMethod paymentMethod)
    {
        return svr.insertPaymentMethod(paymentMethod);
    }

    @PostMapping(value="/updatePaymentMethod")
    public PaymentMethod updatePaymentMethod(@RequestBody PaymentMethod paymentMethod)
    {
        return svr.updatePaymentMethod(paymentMethod);
    }

    @GetMapping(value="/deletePaymentMethod")
    public String deletePaymentMethod(String paymentMethodId){
        try{
            svr.deletePaymentMethod(Integer.valueOf(paymentMethodId));
            return "ok";
        }catch (Exception ex){
            return ex.toString();
        }
    }
}
