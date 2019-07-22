package com.flaregames.stackoveflow.controllers;

import com.flaregames.stackoveflow.configuration.IntegrationTestBase;
import com.flaregames.stackoveflow.configuration.TestRunnerConfiguration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@ActiveProfiles("h2integration")
@ContextConfiguration(classes = TestRunnerConfiguration.class)
public class UserProxyControllerTest extends IntegrationTestBase {

    @Test
    public void getUser() {
        Response response = given().port(RestAssured.port).contentType(ContentType.JSON).when().get("/stackoverflow/users/ " + "848513");

        response.then().log().ifError();

        JsonPath jsonPath = response.jsonPath();

        response.then().statusCode(200);

        // Assert the response
        response.then()
                .content("display_name", Matchers.is("kneidels"))
                .content("user_id", Matchers.is(848513))
                .content("creation_date", Matchers.is("2011-07-17T11:01:27"))
                .statusCode(200);

    }

}

