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
   public List<Unit> unitList(){

       List<Unit> list = svr.unitList();
       return list;

   }

   @PostMapping(value="/insertUnit")
    public String insertUnit(@RequestBody Unit unit)
   {
          Unit insertUnit=svr.insertUnit(unit);
          if (insertUnit !=null){
                 return insertUnit.getUnitId();
          }else {
                 return  "fail";
          }
   }

    @PostMapping(value="/updateUnit")
    public String updateUnit(@RequestBody Unit unit)
    {
        Unit updateUnit=svr.updateUnit(unit);
        if (updateUnit !=null){
            return updateUnit.getUnitId();
        }else {
            return  "fail";
        }
    }

    @GetMapping(value="/deleteUnit")
    public String deleteUnit(String unitId){
        try{
             svr.deleteUnit(unitId);
             return "ok";
        }catch (Exception ex){
            return "fail";
        }
    }

}
