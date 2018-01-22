package com.lzf.mvcModule.controller;

import com.alibaba.fastjson.JSON;
import com.lzf.mvcModule.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
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
    @RequestMapping( value = "/bootstrapTable", method = RequestMethod.GET )
    public String bootstrapTable(Map<String,Object> map){
        return "bootstrapTable";
    }

    @RequestMapping( value = "/tableData", method = RequestMethod.GET )
    @ResponseBody
    public String tableData(){
        User user1 = new User();
        user1.setId("张三1");
        user1.setName("1");
        user1.setPrice("1");
        User user2 = new User();
        user2.setId("张三2");
        user2.setName("2");
        user2.setPrice("2");
        User user3 = new User();
        user3.setId("张三3");
        user3.setName("3");
        user3.setPrice("3");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        return JSON.toJSONString(list);
    }


    /**
     * 返回html模板.
     */
    @RequestMapping( value = "/bootstrapValidator", method = RequestMethod.GET )
    public String bootstrapValidator(){
        return "bootstrapValidator";
    }



}
