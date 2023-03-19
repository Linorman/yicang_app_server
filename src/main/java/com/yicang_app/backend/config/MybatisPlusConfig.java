package com.yicang_app.backend.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 配置 MybatisPlus
 * @author linorman
 * @date 2023/03/19
 */

// TODO: 2021/3/19 还没完成编写，需要和yml进行耦合
@Configuration
@MapperScan("com.yicang_app.backend.mapper")
public class MybatisPlusConfig {
    @Autowired
    @Qualifier("userInfoDataSource")
    private DataSource userInfoDataSource;

    @Autowired
    @Qualifier("userCollectionNovelDataSource")
    private DataSource userCollectionNovelDataSource;

    @Autowired
    @Qualifier("userCollectionPaintingDataSource")
    private DataSource userCollectionPaintingDataSource;

    // 使用 @Bean 注解创建 SqlSessionFactory 对象，并指定对应的数据源和 Mapper 文件路径
    @Bean(name = "userInfoSqlSessionFactory")
    public SqlSessionFactory userInfoSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(userInfoDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/User/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "userCollectionNovelSqlSessionFactory")
    public SqlSessionFactory userCollectionNovelSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(userCollectionNovelDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/User/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "userCollectionPaintingSqlSessionFactory")
    public SqlSessionFactory userCollectionPaintingSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(userCollectionPaintingDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/User/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "userInfoSqlSessionTemplate")
    public SqlSessionTemplate userInfoSqlSessionTemplate(@Qualifier("userInfoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "userCollectionNovelSqlSessionTemplate")
    public SqlSessionTemplate userCollectionNovelSqlSessionTemplate(@Qualifier("userCollectionNovelSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "userCollectionPaintingSqlSessionTemplate")
    public SqlSessionTemplate userCollectionPaintingSqlSessionTemplate(@Qualifier("userCollectionPaintingSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }



}
