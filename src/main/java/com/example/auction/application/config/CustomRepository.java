package com.example.auction.application.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean // 一般用作父类的repository，有这个注解，spring不会去实例化该repository。
public interface CustomRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
}
