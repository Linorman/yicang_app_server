package com.yicang_app.backend.config.user_database_config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 配置数据源
 * @author linorman
 * @date 2023/03/19
 */
@Configuration
public class UserDataSourceConfig {
    @Bean(name = "userInfoDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.user-info")
    public DataSource userInfoDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "userCollectionNovelDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.user-collection-novel")
    public DataSource userCollectionNovelDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "userCollectionPaintingDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.user-collection-painting")
    public DataSource userCollectionPaintingDataSource() {
        return new DruidDataSource();
    }
}
