package com.yxp.yzjxc.serviceimpl.dic;

import com.yxp.yzjxc.entity.Unit;
import com.yxp.yzjxc.repo.dic.UnitRepo;
import com.yxp.yzjxc.service.dic.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UnitServiceImpl implements UnitService {
    @Autowired
    private UnitRepo repo;
    @Override
    public void saveUnit(Unit unit) {
         repo.save(unit);
    }

    @Override
    public void deleteUnit(String unitId) {
          repo.deleteById(unitId);
    }

    @Override
    public List<Unit> unitList() {
        List<Unit> list =repo.findAll();
        return list;
    }
}