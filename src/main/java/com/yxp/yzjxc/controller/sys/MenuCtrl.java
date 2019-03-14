package com.yxp.yzjxc.controller.sys;

import com.yxp.yzjxc.common.MessageModel;
import com.yxp.yzjxc.entity.Menu;
import com.yxp.yzjxc.service.sys.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/sys/menu", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class MenuCtrl {
    @Autowired
    private MenuService svr;

    @GetMapping(value="/menuList")
    public MessageModel menuList(){
        MessageModel m = new MessageModel();
        List<Menu> list =svr.menuList();
        m.setData(list);
        m.setResultCode("1");
        return m;
    }


}
