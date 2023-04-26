package com.linyangkai.mallproduct.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("com.linyangkai.mallproduct.dao")
public class MybatisConfig {
  @Bean
  public PaginationInterceptor paginationInterceptor(){
    PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
    paginationInterceptor.setOverflow(true);
    paginationInterceptor.setLimit(1000);
    return paginationInterceptor;
  }
}
