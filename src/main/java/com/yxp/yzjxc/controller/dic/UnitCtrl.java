package com.yxp.yzjxc.controller.dic;

import com.yxp.yzjxc.common.MessageModel;
import com.yxp.yzjxc.entity.Unit;
import com.yxp.yzjxc.service.dic.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dic/unit", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class UnitCtrl {
   @Autowired
    private UnitService svr;

   @GetMapping(value = "/unitList")
   public Flux<Unit> unitList(){

       Flux<Unit> list = svr.unitList();
       return list;

   }

   @PostMapping(value="/insertUnit")
    public Mono<Unit> insertUnit(@RequestBody Unit unit)
   {
          return svr.insertUnit(unit);
   }

    @PostMapping(value="/insertUnit")
    public Mono<Unit> updateUnit(@RequestBody Unit unit)
    {
        return svr.updateUnit(unit);
    }

    @GetMapping(value="/insertUnit")
    public Mono<String> deleteUnit(String unitId){
        try{
             svr.deleteUnit(unitId);
             return Mono.just("ok");
        }catch (Exception ex){
            return Mono.just(ex.toString());
        }
    }

}
