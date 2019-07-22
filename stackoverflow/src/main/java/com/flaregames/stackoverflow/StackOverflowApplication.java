package com.flaregames.stackoverflow;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.flaregames.stackoverflow.constants.Constants.STACKOVERFLOW_BASE_PACKAGE;

/**
 * This class starts up springboot application
 */
@Slf4j
@EnableAutoConfiguration
@ComponentScan(STACKOVERFLOW_BASE_PACKAGE)
@SpringBootApplication
@EnableSwagger2
@EnableCaching
public class StackOverflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(StackOverflowApplication.class, args);
	}


}
