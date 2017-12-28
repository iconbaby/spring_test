package com.slkk.chapter3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class BbsDaemon {
    @RequestMapping("/")
    public String index() {
        return "hello";
    }

    public void main(String[] args) throws Exception {
        SpringApplication.run(this, args);
    }
}
