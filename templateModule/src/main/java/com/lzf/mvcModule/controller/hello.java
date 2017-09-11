package com.lzf.mvcModule.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class hello {

    /**
     * 返回freemarker模板.
     */
    @RequestMapping("/hello")
    public String helloJsp(Map<String,Object> map){
        map.put("name", "[Angel -- 守护天使]");
        return "freemarker/hello";
    }

    /**
     * 返回html模板.
     */
    @RequestMapping("/helloHtml")
    public String helloHtml(Map<String,Object> map){
        map.put("hello","from TemplateController.helloHtml");
        return"/thymeleaf/helloHtml";
    }

}
