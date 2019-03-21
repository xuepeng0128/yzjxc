package com.yxp.yzjxc.service.dic;

import com.yxp.yzjxc.entity.Unit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UnitService {
    public Unit insertUnit(Unit unit);
    public Unit updateUnit(Unit unit);
    public void deleteUnit(String unitId);
    public List<Unit> unitList();
}
