package com.lzf;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * 描述:
 * mybatis pageHelper分页插件
 *
 * @outhor liuzhenfei
 * @create 2017-09-20 下午 1:50
 */
@Configuration
@EnableTransactionManagement
public class MyBatisConfig {
    @Bean
    public PageHelper pageHelper() {
        System.out.println("MyBatisConfiguration.pageHelper()");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);

        return pageHelper;
    }


 /*   @Bean
    public MybatisMapperRefresh setMybatisMapperRefresh(){
        return null;
    }*/


}
