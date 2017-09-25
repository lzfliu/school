package com.lzf.servlet.druid;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * 描述:
 * 配置监控界面
 *启动测试。在application.java中启动，浏览器中先进入：localhost:8080/druid/login.html，输入用户名：admin，密码：123，进入。
 再执行一下localhost:8080/demo/findCity2?id=001，（你的数据）查看结果。这里需要你的数据库里有数据。
 在监控页面看看sql监控是否被监控到。

 * @outhor liuzhenfei
 * @create 2017-09-25 上午 9:17
 */
@WebServlet(urlPatterns = "/druid/*",
        initParams={
                @WebInitParam(name="allow",value="192.168.16.110,127.0.0.1"),// IP白名单 (没有配置或者为空，则允许所有访问)
                @WebInitParam(name="deny",value="192.168.16.111"),// IP黑名单 (存在共同时，deny优先于allow)
                @WebInitParam(name="loginUsername",value="admin"),// 用户名
                @WebInitParam(name="loginPassword",value="123"),// 密码
                @WebInitParam(name="resetEnable",value="false")// 禁用HTML页面上的“Reset All”功能
        })
public class DruidStatViewServlet extends StatViewServlet {
    private static final long serialVersionUID = 1L;

}