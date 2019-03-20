package com.yxp.yzjxc.serviceimpl.dic;

import com.yxp.yzjxc.entity.PaymentMethod;
import com.yxp.yzjxc.repo.dic.PaymentMethodRepo;
import com.yxp.yzjxc.service.dic.PaymentAgreementService;
import com.yxp.yzjxc.service.dic.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
    @Autowired
    PaymentMethodRepo repo;
    @Override
    public Mono<PaymentMethod> insertPaymentMethod(PaymentMethod paymentMethod) {
        return repo.insert(paymentMethod);
    }

    @Override
    public Mono<PaymentMethod> updatePaymentMethod(PaymentMethod paymentMethod) {
        return repo.save(paymentMethod);
    }

    @Override
    public void deletePaymentMethod(Integer paymentMethodId) {
        repo.deleteById(paymentMethodId);
    }

    @Override
    public Flux<PaymentMethod> paymentMethodList() {
        return repo.findAll();
    }
}