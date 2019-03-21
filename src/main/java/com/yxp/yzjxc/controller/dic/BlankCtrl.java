package com.yxp.yzjxc.controller.dic;

import com.yxp.yzjxc.entity.Blank;
import com.yxp.yzjxc.service.dic.BlankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dic/blank", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class BlankCtrl {
    @Autowired
    BlankService svr;

    @GetMapping(value = "/blankList")
    public List<Blank> blankList(){
        List<Blank> list = svr.blankList();
        return list;

    }

    @PostMapping(value="/insertBlank")
    public Blank insertBlank(@RequestBody Blank blank)
    {

        return svr.insertBlank(blank);
    }

    @PostMapping(value="/updateBlank")
    public Blank updateBlank(@RequestBody Blank blank)
    {
        return svr.updateBlank(blank);
    }

    @GetMapping(value="/deleteBlank")
    public String deleteBlank(String blankId){
        try{
            svr.deleteBlank(blankId);
            return "ok";
        }catch (Exception ex){
            return ex.toString();
        }
    }

}
