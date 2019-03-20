package com.yxp.yzjxc.service.dic;

import com.yxp.yzjxc.entity.PaymentAgreement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaymentAgreementService {

    public Mono<PaymentAgreement> insertPaymentAgreement(PaymentAgreement paymentAgreement);
    public Mono<PaymentAgreement> updatePaymentAgreement(PaymentAgreement paymentAgreement);
    public void deletePaymentAgreement(Integer paymentAgreementId);
    public Flux<PaymentAgreement> paymentAgreementList();
}
