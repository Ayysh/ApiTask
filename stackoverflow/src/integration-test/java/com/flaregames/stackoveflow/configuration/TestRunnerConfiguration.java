package com.flaregames.stackoveflow.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import static com.flaregames.stackoverflow.constants.Constants.BASE_PACKAGE;

@ComponentScan(BASE_PACKAGE)
@EnableAutoConfiguration
public class TestRunnerConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(TestRunnerConfiguration.class, args);
    }
}