package com.exampl.traveler;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TravelerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelerApplication.class, args);
	}

}
