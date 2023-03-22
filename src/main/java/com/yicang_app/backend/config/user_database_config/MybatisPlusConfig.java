package com.yicang_app.backend.config.user_database_config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 配置 MybatisPlus
 * @author linorman
 * @date 2023/03/19
 */

@Configuration
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
        return bean.getObject();
    }

    @Bean(name = "userCollectionNovelSqlSessionFactory")
    public SqlSessionFactory userCollectionNovelSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(userCollectionNovelDataSource);
        return bean.getObject();
    }

    @Bean(name = "userCollectionPaintingSqlSessionFactory")
    public SqlSessionFactory userCollectionPaintingSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(userCollectionPaintingDataSource);
        return bean.getObject();
    }


//    @Bean(name = "userInfoSqlSessionTemplate")
//    public SqlSessionTemplate userInfoSqlSessionTemplate(@Qualifier("userInfoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//    @Bean(name = "userCollectionNovelSqlSessionTemplate")
//    public SqlSessionTemplate userCollectionNovelSqlSessionTemplate(@Qualifier("userCollectionNovelSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//    @Bean(name = "userCollectionPaintingSqlSessionTemplate")
//    public SqlSessionTemplate userCollectionPaintingSqlSessionTemplate(@Qualifier("userCollectionPaintingSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }

    @Bean(name = "userInfoTransactionManager")
    public DataSourceTransactionManager userInfoTransactionManager() {
        return new DataSourceTransactionManager(userInfoDataSource);
    }

    @Bean(name = "userCollectionNovelTransactionManager")
    public DataSourceTransactionManager userCollectionNovelTransactionManager() {
        return new DataSourceTransactionManager(userCollectionNovelDataSource);
    }

    @Bean(name = "userCollectionPaintingTransactionManager")
    public DataSourceTransactionManager userCollectionPaintingTransactionManager() {
        return new DataSourceTransactionManager(userCollectionPaintingDataSource);
    }

    @Bean(name = "userInfoMapperScannerConfigurer")
    public MapperScannerConfigurer userInfoMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.yicang_app.backend.mapper.user.user_info");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("userInfoSqlSessionFactory");
        return mapperScannerConfigurer;
    }

    @Bean(name = "userCollectionNovelMapperScannerConfigurer")
    public MapperScannerConfigurer userCollectionNovelMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.yicang_app.backend.mapper.user.user_collection_novel");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("userCollectionNovelSqlSessionFactory");
        return mapperScannerConfigurer;
    }

    @Bean(name = "userCollectionPaintingMapperScannerConfigurer")
    public MapperScannerConfigurer userCollectionPaintingMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.yicang_app.backend.mapper.user.user_collection_painting");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("userCollectionPaintingSqlSessionFactory");
        return mapperScannerConfigurer;
    }
}
