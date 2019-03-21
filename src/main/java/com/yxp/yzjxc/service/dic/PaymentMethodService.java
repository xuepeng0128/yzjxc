package com.yxp.yzjxc.service.dic;

import com.yxp.yzjxc.entity.PaymentMethod;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PaymentMethodService {
    public PaymentMethod insertPaymentMethod(PaymentMethod paymentMethod);
    public PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod);
    public void deletePaymentMethod(Integer paymentMethodId);
    public List<PaymentMethod> paymentMethodList();
}
