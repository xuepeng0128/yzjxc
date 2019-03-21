package com.yxp.yzjxc.service.dic;

import com.yxp.yzjxc.entity.PaymentAgreement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PaymentAgreementService {

    public PaymentAgreement insertPaymentAgreement(PaymentAgreement paymentAgreement);
    public PaymentAgreement updatePaymentAgreement(PaymentAgreement paymentAgreement);
    public void deletePaymentAgreement(Integer paymentAgreementId);
    public List<PaymentAgreement> paymentAgreementList();
}
