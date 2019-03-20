package com.yxp.yzjxc.serviceimpl.dic;

import com.yxp.yzjxc.entity.Duty;
import com.yxp.yzjxc.repo.dic.DutyRepo;
import com.yxp.yzjxc.service.dic.DutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DutyServiceImpl implements DutyService {
    @Autowired
    DutyRepo repo;
    @Override
    public Mono<Duty> insertDuty(Duty duty) {
          return repo.insert(duty);
    }

    @Override
    public Mono<Duty> updateDuty(Duty duty) {
        return repo.save(duty);
    }

    @Override
    public void deleteDuty(String dutyId) {
        repo.deleteById(dutyId);
    }

    @Override
    public Flux<Duty> dutyList() {
        return repo.findAll();
    }
}
