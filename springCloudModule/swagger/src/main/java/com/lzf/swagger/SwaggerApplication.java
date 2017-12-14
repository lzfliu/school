package com.lzf.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 描述:
 *
 * @author liuzhenfei
 * @create 2017-11-03 上午 8:40
 */
@SpringBootApplication
@Controller
public class SwaggerApplication {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String test() {
        return "index.html";
    }

    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class,args);
    }
}
