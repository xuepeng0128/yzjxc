package com.yxp.yzjxc.controller.dic;

import com.yxp.yzjxc.entity.Blank;
import com.yxp.yzjxc.service.dic.BlankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/dic/blank", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class BlankCtrl {
    @Autowired
    BlankService svr;

    @GetMapping(value = "/blankList")
    public Flux<Blank> blankList(){
        Flux<Blank> list = svr.blankList();
        return list;

    }

    @PostMapping(value="/insertBlank")
    public Mono<Blank> insertUnit(@RequestBody Blank blank)
    {
        return svr.insertBlank(blank);
    }

    @PostMapping(value="/insertBlank")
    public Mono<Blank> updateUnit(@RequestBody Blank blank)
    {
        return svr.updateBlank(blank);
    }

    @GetMapping(value="/insertBlank")
    public Mono<String> deleteBlank(String blankId){
        try{
            svr.deleteBlank(blankId);
            return Mono.just("ok");
        }catch (Exception ex){
            return Mono.just(ex.toString());
        }
    }

}
