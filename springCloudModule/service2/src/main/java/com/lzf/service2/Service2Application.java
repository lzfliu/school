package com.lzf.service2;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Service2Application {


    @ApiOperation(value="获取项目组Sonar对应的所有Url信息")
    @RequestMapping("/service2")
    public  String service1(){
        return "service2";
    }


    public static void main(String[] args) {
        SpringApplication.run(Service2Application.class,args);
    }
}
