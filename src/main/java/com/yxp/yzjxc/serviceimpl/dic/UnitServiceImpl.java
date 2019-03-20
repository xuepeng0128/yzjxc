package com.yxp.yzjxc.serviceimpl.dic;

import com.yxp.yzjxc.entity.Unit;
import com.yxp.yzjxc.repo.dic.UnitRepo;
import com.yxp.yzjxc.service.dic.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
@Service
public class UnitServiceImpl implements UnitService {
    @Autowired
    private UnitRepo repo;


    @Override
    public Mono<Unit> insertUnit(Unit unit) {
           return repo.insert(unit);
    }

    @Override
    public Mono<Unit> updateUnit(Unit unit) {
          return repo.save(unit);
    }

    @Override
    public void deleteUnit(String unitId) {
          repo.deleteById(unitId);
    }

    @Override
    public Flux<Unit> unitList() {
        Flux<Unit> list =repo.findAll();
        return list;
    }
}
