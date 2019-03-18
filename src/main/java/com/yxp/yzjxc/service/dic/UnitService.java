package com.yxp.yzjxc.service.dic;

import com.yxp.yzjxc.entity.Unit;

import java.util.List;

public interface UnitService {
    public void saveUnit(Unit unit);
    public void deleteUnit(String unitId);
    public List<Unit> unitList();
}
