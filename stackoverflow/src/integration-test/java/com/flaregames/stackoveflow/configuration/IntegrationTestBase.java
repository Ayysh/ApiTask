package com.flaregames.stackoveflow.configuration;

import io.restassured.RestAssured;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeSuite;

/**
 * The base class to extend for setting and running integration tests with {@code RestAssured} as HTTP client.
 *
 * @author ayyswariyaa
 * @see AbstractTestNGSpringContextTests - creates Application Context for Test
 *
 */
//The @SpringBootTest annotation tells Spring Boot to go and look for a main configuration class
// (one with @SpringBootApplication for instance), and use that to start a Spring application context
//webEnvironment=RANDOM_PORT to start the server with a random port (useful to avoid conflicts in test environments),
// and the injection of the port with @LocalServerPort
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class IntegrationTestBase extends AbstractTestNGSpringContextTests {

    @BeforeSuite // This makes the initial setup for the test.
    @SuppressWarnings("squid:S2696")
    public void setUpSuite() {
        String basePath = System.getProperty("server.base");

        //configure RestAssured basepath
        RestAssured.basePath = (basePath == null || basePath.isEmpty()) ? "" : basePath;

        String baseHost = System.getProperty("server.host");
        //configure RestAssured baseURI
        RestAssured.baseURI = (baseHost == null || baseHost.isEmpty()) ? "http://localhost" : baseHost;
    }

    //injects the RANDOM_PORT to RestAssured Port.
    @LocalServerPort
    @SuppressWarnings("squid:S2696")
    public void setPort(int port) {
        RestAssured.port = port;
    }

}
