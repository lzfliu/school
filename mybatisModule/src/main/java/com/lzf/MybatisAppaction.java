package com.lzf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 描述:
 * mybatisModule启动类
 *
 * @outhor liuzhenfei
 * @create 2017-09-20 上午 9:44
 */
@MapperScan("com.lzf.dao")
@SpringBootApplication
@EnableTransactionManagement
public class MybatisAppaction {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MybatisAppaction.class, args);
    }
}
