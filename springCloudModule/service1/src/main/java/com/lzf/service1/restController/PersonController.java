package com.lzf.service1.restController;

import com.lzf.service1.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * Person接口
 *
 * @outhor liuzhenfei
 * @create 2017-09-19 上午 10:21
 */
@RestController
@RequestMapping(value="/person")
public class PersonController {

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="/setUser", method= RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        UserController.users.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value="/getUser", method= RequestMethod.GET)
    public List<User> getUserList() {
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        List<User> r = new ArrayList<User>(UserController.users.values());
        return r;
    }

    @ApiOperation(value="测试热部署", notes="")
    @RequestMapping(value="/getString", method= RequestMethod.GET)
    public String getString() {
        return "测试热部署";
    }

}
