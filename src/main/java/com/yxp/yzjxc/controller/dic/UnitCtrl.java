package com.yxp.yzjxc.controller.dic;

import com.yxp.yzjxc.common.MessageModel;
import com.yxp.yzjxc.entity.Unit;
import com.yxp.yzjxc.service.dic.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dic/unit", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class UnitCtrl {
   @Autowired
    private UnitService svr;

   @GetMapping(value = "/unitList")
   public MessageModel  unitList(){
       MessageModel m=new MessageModel();
       List<Unit> list = svr.unitList();
       m.setData(list);
       m.setResultCode("1");
       return m;

   }





}
