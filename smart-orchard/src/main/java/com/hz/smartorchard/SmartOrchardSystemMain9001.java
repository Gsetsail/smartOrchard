package com.hz.smartorchard;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.hz.smartorchard.dao"})
public class SmartOrchardSystemMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(SmartOrchardSystemMain9001.class,args);
    }
}
