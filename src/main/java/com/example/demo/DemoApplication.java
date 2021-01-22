package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@MapperScan("com.example.demo.mapper")
@SpringBootApplication
@RestController
//开启security的注解功能
@EnableGlobalMethodSecurity(securedEnabled = true)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping("/test/hello")
    public String hello() {
        return "hello";
    }

    @Secured({"ROLE_manager"})
    @RequestMapping("/test/index")
    public String index() {
        return "index";
    }

    @Secured({"ROLE_admin"})
    @RequestMapping("/test/update")
    public String update() {
        return "update";
    }
}
