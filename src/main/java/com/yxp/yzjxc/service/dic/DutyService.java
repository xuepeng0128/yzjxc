package com.yxp.yzjxc.service.dic;

import com.yxp.yzjxc.entity.Blank;
import com.yxp.yzjxc.entity.Duty;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DutyService {
    public Mono<Duty> insertDuty(Duty duty);
    public Mono<Duty> updateDuty(Duty duty);
    public void deleteDuty(String dutyId);
    public Flux<Duty> dutyList();
}
