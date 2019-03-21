package com.yxp.yzjxc.serviceimpl.dic;

import com.yxp.yzjxc.entity.PaymentAgreement;
import com.yxp.yzjxc.repo.dic.PaymentAgreementRepo;
import com.yxp.yzjxc.service.dic.PaymentAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PaymentAgreementServiceImpl implements PaymentAgreementService {
    @Autowired
    PaymentAgreementRepo repo;
    @Override
    public PaymentAgreement insertPaymentAgreement(PaymentAgreement paymentAgreement) {
        return repo.insert(paymentAgreement);
    }

    @Override
    public PaymentAgreement updatePaymentAgreement(PaymentAgreement paymentAgreement) {
        return repo.save(paymentAgreement);
    }

    @Override
    public void deletePaymentAgreement(Integer paymentAgreementId) {
        repo.deleteById(paymentAgreementId);
    }

    @Override
    public List<PaymentAgreement> paymentAgreementList() {
        return repo.findAll();
    }
}
