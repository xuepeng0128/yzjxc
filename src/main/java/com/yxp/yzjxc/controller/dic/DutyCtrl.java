package com.yxp.yzjxc.controller.dic;

import com.yxp.yzjxc.entity.Duty;
import com.yxp.yzjxc.service.dic.DutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dic/duty", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class DutyCtrl {

    @Autowired
    DutyService svr;

    @GetMapping(value = "/dutyList")
    public List<Duty> dutyList(){
        List<Duty> list = svr.dutyList();
        return list;

    }

    @PostMapping(value="/insertDuty")
    public Duty insertDuty(@RequestBody Duty duty)
    {
        return svr.insertDuty(duty);
    }

    @PostMapping(value="/updateDuty")
    public Duty updateUnit(@RequestBody Duty duty)
    {
        return svr.updateDuty(duty);
    }

    @GetMapping(value="/deleteDuty")
    public String deleteDuty(String dutyId){
        try{
            svr.deleteDuty(dutyId);
            return "ok";
        }catch (Exception ex){
            return ex.toString();
        }
    }

}
