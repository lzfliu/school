package com.lzf;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzf.dao.UserMapper;
import com.lzf.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 描述:
 * 测试mybatisDAO
 *
 * @outhor liuzhenfei
 * @create 2017-09-20 上午 10:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUserDao {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSaveUser(){

        User user = new User();

        user.setUsername("王五");
        user.setAge("40");
        user.setSex("男");

        userMapper.insertSelective(user);
    }

    @Test
    public void testSelectUserByPage(){

        /*
         * 第一个参数是第几页；第二个参数是每页显示条数。
         */
        List<User> users = null;
        PageHelper.startPage(2,1);
        users = userMapper.selectByPage();
        for (User user : users) {
            System.out.println("*************************   "+user.getUsername()+"    ************************");
        }

        System.out.println("*************************   总条数："+((Page) users).getTotal()+"    ************************");
        System.out.println("*************************   StartRow："+((Page) users).getStartRow()+"    ************************");
        System.out.println("*************************   EndRow："+((Page) users).getEndRow()+"    ************************");
        System.out.println("*************************   页数："+((Page) users).getPages()+"    ************************");
    }



}
