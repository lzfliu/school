package com.lzf.service1;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Service1Application {

    @ApiOperation(value="获取项目组Sonar对应的所有Url信息")
    @RequestMapping("/service1")
    public  String service1(){
        return "service1";
    }


    public static void main(String[] args) {
        SpringApplication.run(Service1Application.class,args);
    }
}
