package com.yxp.yzjxc.controller.sys;

import com.yxp.yzjxc.common.MessageModel;
import com.yxp.yzjxc.entity.CorpMsg;
import com.yxp.yzjxc.service.sys.CorpMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/sys", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class CorpMsgCtrl {
    @Autowired
    private CorpMsgService svr;
    @PostMapping(value="/saveCorpMsg")
    public MessageModel saveCorpMsg(@RequestBody CorpMsg corpMsg){
           MessageModel m = new MessageModel();
           if( svr.saveCorpMsg(corpMsg))
           {
               m.setResultCode("1");
               m.setResultMsg("保存成功");
           }else {

           }
        return  m;
    }

    @GetMapping(value="/allCorpMsg")
    public MessageModel allCorpMsg(){
        MessageModel m = new MessageModel();
        m.setData(svr.getCorpMsg());
        return m;
    }
    @GetMapping(value="/currentCorp")
    public  MessageModel currentCorp(String address){
        MessageModel m = new MessageModel();
        m.setData(svr.getCorpMsgbyadd(address));
        return m;
    }
}
