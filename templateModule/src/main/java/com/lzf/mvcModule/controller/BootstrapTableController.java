package com.lzf.mvcModule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * 描述:
 * Bootstrap Table 插件应用
 *
 * @author liuzhenfei
 * @create 2017-10-10 上午 10:18
 */
@Controller
@RequestMapping("/table")
public class BootstrapTableController {

    /**
     * 返回html模板.
     */
    @RequestMapping( value = "/hello", method = RequestMethod.GET )
    public String helloHtml(Map<String,Object> map){
        System.out.println("aaa的值是：--- " + 444 + "，当前方法=BootstrapTableController.helloHtml()");
        return "bootstrapTable";
    }

}
