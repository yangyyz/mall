package com.linyangkai.mallmember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.linyangkai.mallmember.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class MallMemberApplication {

  public static void main(String[] args) {
    SpringApplication.run(MallMemberApplication.class, args);
  }

}
