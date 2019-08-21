package com.flaregames.stackoveflow.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import static com.flaregames.stackoverflow.constants.Constants.BASE_PACKAGE;

//Look up for all components starting from com.flaregames package for dependency injection
@ComponentScan(BASE_PACKAGE)
@EnableAutoConfiguration // tells Spring Boot to start adding beans based on classpath settings, other beans,
// and  property settings.
public class TestRunnerConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(TestRunnerConfiguration.class, args);
    }
}