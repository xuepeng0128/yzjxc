package com.yxp.yzjxc.service.dic;

import com.yxp.yzjxc.entity.Blank;
import com.yxp.yzjxc.entity.Duty;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface DutyService {
    public Duty insertDuty(Duty duty);
    public Duty updateDuty(Duty duty);
    public void deleteDuty(String dutyId);
    public List<Duty> dutyList();
}
