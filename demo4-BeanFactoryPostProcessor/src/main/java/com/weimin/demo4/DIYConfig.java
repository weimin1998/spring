package com.weimin.demo4;

import com.alibaba.druid.pool.DruidDataSource;
import com.weimin.demo4.mapper.Mapper1;
import com.weimin.demo4.mapper.Mapper2;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.weimin.demo4.diycomponent")
public class DIYConfig {

    @Bean
    public Bean1 bean1() {
        return new Bean1();
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean(initMethod = "init")
    public DruidDataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername("root");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test");
        druidDataSource.setPassword("root");
        return druidDataSource;
    }

    // 其实 MapperPostProcessor中做的事情，就相当于向spring容器中，添加下面这两个 MapperFactoryBean
    // 我们也可以像下面那样手动添加mapper到spring容器，但是如果mapper太多，就会很麻烦
    // 所以要借助 BeanFactory后处理器 来扫描，进行批量添加

//    @Bean
//    public MapperFactoryBean<Mapper1> mapper1(SqlSessionFactory sqlSessionFactory) {
//        MapperFactoryBean<Mapper1> mapperFactoryBean = new MapperFactoryBean<>(Mapper1.class);
//        mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
//        return mapperFactoryBean;
//    }
//
//    @Bean
//    public MapperFactoryBean<Mapper2> mapper2(SqlSessionFactory sqlSessionFactory) {
//        MapperFactoryBean<Mapper2> mapperFactoryBean = new MapperFactoryBean<>(Mapper2.class);
//        mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
//        return mapperFactoryBean;
//    }
}
