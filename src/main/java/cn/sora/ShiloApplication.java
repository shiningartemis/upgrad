package cn.sora;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan(value = "cn.sora.mapper")
public class ShiloApplication {
    public static void main(String[] args){
        SpringApplication.run(ShiloApplication.class,args);
    }
}
