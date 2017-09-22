package com.lzf;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzf.dao.UserMapper;
import com.lzf.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

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

    List<User> users = null;

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
         * 例1：第一个参数是第几页；第二个参数是每页显示条数。
         *      用PageInfo对结果进行包装
         */
        demo14PageNumAndPageSize();
        /*
         * 例2：支持 ServletRequest,Map,POJO 对象，需要配合 params 参数
         * request: url?pageNum=1&pageSize=10
         */
        demo24Object();


    }

    /**
      * 例2：支持 ServletRequest,Map,POJO 对象，需要配合 params 参数
      * request: url?pageNum=1&pageSize=10
      */
    private void demo24Object() {

        Map<String,String> request = new HashMap<>();
        request.put("pageNum","1");
        request.put("pageSize","1");
        PageHelper.startPage(request);
        //紧跟着的第一个select方法会被分页
        users = userMapper.selectByPage();
        System.out.println(users.size());
        //后面的不会被分页，除非再次调用PageHelper.startPage
        users = userMapper.selectByPage();
        System.out.println(users.size());
    }

    /**
     * 例1：第一个参数是第几页；第二个参数是每页显示条数。
     */
    private void demo14PageNumAndPageSize() {

        PageHelper.startPage(1,1);
        users = userMapper.selectByPage();
        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(users);
        //测试PageInfo全部属性
        //PageInfo包含了非常全面的分页属性
        System.out.println("*************************   总条数："+page.getTotal()+"    ************************");
        System.out.println("*************************   StartRow："+page.getStartRow()+"    ************************");
        System.out.println("*************************   EndRow："+page.getEndRow()+"    ************************");
        System.out.println("*************************   总页数："+page.getPages()+"    ************************");
        System.out.println("*************************   pageNum："+page.getPageNum()+"    ************************");
        System.out.println("*************************   pageSize："+page.getPageSize()+"    ************************");
        System.out.println("*************************   prePage："+page.getPrePage()+"    ************************");
        System.out.println("*************************   nextPage："+page.getNextPage()+"    ************************");
        System.out.println("*************************   isIsFirstPage()："+page.isIsFirstPage()+"    ************************");
        System.out.println("*************************   isIsLastPage()："+page.isIsLastPage()+"    ************************");
        System.out.println("*************************   size："+page.getSize()+"    ************************");
        System.out.println("*************************   isHasNextPage()："+page.isHasNextPage()+"    ************************");
        System.out.println("*************************   isHasPreviousPage()："+page.isHasPreviousPage()+"    ************************");
        System.out.println("*************************   getNavigateFirstPage()："+page.getNavigateFirstPage()+"    ************************");
        System.out.println("*************************   getNavigateLastPage()："+page.getNavigateLastPage()+"    ************************");
        System.out.println("*************************   getNavigatepageNums()："+page.getNavigatepageNums()+"    ************************");
        System.out.println("*************************   getNavigatePages()："+page.getNavigatePages()+"    ************************");

    }


}
