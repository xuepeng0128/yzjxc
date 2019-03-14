package com.yxp.yzjxc;

import com.yxp.yzjxc.service.sys.InitSysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class YzjxcApplication {
   @Autowired
    InitSysService svr;
    public static void main(String[] args) {

        SpringApplication.run(YzjxcApplication.class, args);
    }
    @RequestMapping("/")
    public String test()
    {
        svr.initSys();
        return "index.html";
    }
}
