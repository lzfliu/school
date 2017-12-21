package com.lzf.webservice.service.impl;

import com.lzf.webservice.entity.User;
import com.lzf.webservice.service.UserService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

/**
 * Created by lzf on 2017/12/20.
 */


@WebService(targetNamespace = "http://service.demo.lzf.cn/",
        endpointInterface = "com.lzf.webservice.service.UserService")
public class UserServiceImpl implements UserService {
    private Map<String, User> userMap = new HashMap<String, User>();

    public UserServiceImpl() {
        System.out.println("向实体类插入数据");
        User user = new User();
        user.setUserId("411001");
        user.setUsername("zhansan");
        user.setAge("20");
        user.setUpdateTime(new Date());
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId("411002");
        user.setUsername("lisi");
        user.setAge("30");
        user.setUpdateTime(new Date());
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId("411003");
        user.setUsername("wangwu");
        user.setAge("40");
        user.setUpdateTime(new Date());
        userMap.put(user.getUserId(), user);
    }

    @Override
    public String getName(String userId) {
        return "liyd-" + userId;
    }

    @Override
    public User getUser(String userId) {
        System.out.println("userMap是:" + userMap);
        return userMap.get(userId);
    }

}
