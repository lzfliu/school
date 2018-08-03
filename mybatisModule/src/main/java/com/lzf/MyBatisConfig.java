package com.lzf;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 描述:
 * mybatis pageHelper分页插件,druid数据库检测插件
 *
 * @outhor liuzhenfei
 * @create 2017-09-20 下午 1:50
 */
@Configuration
@EnableTransactionManagement
@ServletComponentScan   //扫描Servlet
public class MyBatisConfig {

    @Autowired
    private Environment env;


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.source1")
    public DataSource druidDataSource1() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.source2")
    public DataSource druidDataSource2() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.source3")
    public DataSource druidDataSource3() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }


    /**
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
     */
    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier("druidDataSource1") DataSource myTestDbDataSource,
                                        @Qualifier("druidDataSource2") DataSource myTestDb2DataSource,
                                        @Qualifier("druidDataSource3") DataSource myTestDb3DataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>(16);
        targetDataSources.put(DatabaseType.mytestdb, myTestDbDataSource);
        targetDataSources.put(DatabaseType.mytestdb2, myTestDb2DataSource);
        targetDataSources.put(DatabaseType.mytestdb3, myTestDb3DataSource);

        DynamicDataSource dataSource = new DynamicDataSource();
        // 该方法是AbstractRoutingDataSource的方法
        dataSource.setTargetDataSources(targetDataSources);
        // 默认的datasource设置为myTestDbDataSource
        dataSource.setDefaultTargetDataSource(myTestDbDataSource);

        return dataSource;
    }

    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("druidDataSource1") DataSource myTestDbDataSource,
                                               @Qualifier("druidDataSource2") DataSource myTestDb2DataSource,
                                               @Qualifier("druidDataSource3") DataSource myTestDb3DataSource) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        // 指定数据源(这个必须有，否则报错)
        fb.setDataSource(this.dataSource(myTestDbDataSource,myTestDb2DataSource,myTestDb3DataSource));
        // 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
//        fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));// 指定基包
        fb.setMapperLocations( new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*.xml"));

        return fb.getObject();
    }

    /**
     * 配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }


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


}
