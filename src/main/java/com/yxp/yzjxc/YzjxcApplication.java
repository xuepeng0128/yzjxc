package com.yxp.yzjxc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class YzjxcApplication {

    public static void main(String[] args) {
        SpringApplication.run(YzjxcApplication.class, args);
    }
    @RequestMapping("/")
    public String test()
    {
        return "index.html";
    }
}
