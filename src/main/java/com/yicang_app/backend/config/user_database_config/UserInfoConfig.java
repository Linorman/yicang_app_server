package com.yicang_app.backend.config.user_database_config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.yicang_app.backend.mapper.user.user_info", sqlSessionTemplateRef = "userInfoSqlSessionTemplate")
public class UserInfoConfig {

}
