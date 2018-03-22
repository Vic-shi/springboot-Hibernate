package com.example.auction.application.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootConfiguration
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class, basePackages = "com.example.auction")
// @EnableJpaRepositories basePackages属性: 扫描repository所在package及子package
//                        basePackageClasses属性: 指定repository类
//                        repositoryFactoryBeanClass属性: 指定工厂类
public class Config {
}
