package com.lzf.service2.restcontroller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 * 教师接口
 *
 * @outhor liuzhenfei
 * @create 2017-09-19 上午 10:35
 */
@RestController
@RequestMapping(value="/teacher")
public class TeacherController {


    @ApiOperation(value="获取项目组Sonar对应的所有Url信息")
    @RequestMapping(value="/getUser", method= RequestMethod.GET)
    public  String service1(){
        return "service2";
    }



}
