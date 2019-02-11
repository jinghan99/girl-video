package com.girl.update;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * @Description: @EnableScheduling 注解即可开启定时任务
 * @auther: jinghan
 * @date: 2019/1/25 15:35
 */
@EnableScheduling
public class GirlVideoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GirlVideoApplication.class, args);
	}

}

