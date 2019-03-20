package com.yxp.yzjxc.service.dic;

import com.yxp.yzjxc.entity.PaymentMethod;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaymentMethodService {
    public Mono<PaymentMethod> insertPaymentMethod(PaymentMethod paymentMethod);
    public Mono<PaymentMethod> updatePaymentMethod(PaymentMethod paymentMethod);
    public void deletePaymentMethod(Integer paymentMethodId);
    public Flux<PaymentMethod> paymentMethodList();
}
