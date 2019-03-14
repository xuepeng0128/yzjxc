package com.yxp.yzjxc.controller.sys;

import com.yxp.yzjxc.common.MessageModel;
import com.yxp.yzjxc.entity.User;
import com.yxp.yzjxc.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/sys/user", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class UserCtrl {
    @Autowired
    private UserService svr;
    @PostMapping(value="/validateLogin")
    public MessageModel validateLogin(@RequestBody User user){
        MessageModel m=new MessageModel();
        List<User> list =svr.getUser(user.getUserId(),user.getPassWord());
        if (list.size()>0){
            m.setData(list.get(0));
            m.setResultCode("1");
        }else {
            m.setResultCode("0");
        }
        return m;
    }

}
