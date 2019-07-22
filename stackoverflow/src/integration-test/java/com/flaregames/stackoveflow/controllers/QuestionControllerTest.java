package com.flaregames.stackoveflow.controllers;


import com.flaregames.stackoveflow.configuration.IntegrationTestBase;
import com.flaregames.stackoveflow.configuration.TestRunnerConfiguration;
import com.flaregames.stackoverflow.dao.QuestionDao;
import com.flaregames.stackoverflow.domain.Question;
import com.flaregames.stackoverflow.domain.Tag;
import com.flaregames.stackoverflow.mapper.QuestionMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.given;

@ActiveProfiles("h2integration")
@ContextConfiguration(classes = TestRunnerConfiguration.class)
public class QuestionControllerTest extends IntegrationTestBase {


    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private QuestionMapper questionMapper;

    @BeforeMethod
    public void setUp() throws IOException {

        List<Question> questions = new ArrayList<>();

        Set<Tag> tag = new HashSet<>();
        tag.add(new Tag("python"));
        tag.add(new Tag("flaregamesjava"));

        questions.add(new Question(57086935, tag, false, 20, 0, "2019-07-18T06:00:09", 172677));

        questionDao.save(questions);
    }


    @Test
    public void getAllQuestions() {

        Response response = given().port(RestAssured.port).contentType(ContentType.JSON).when().get("/stackoverflow/questions");

        response.then().log().ifError();

        JsonPath jsonPath = response.jsonPath();

        response.then().statusCode(200);
    }

    @Test
    public void retrieveQuestion() {

        Response response = given().port(RestAssured.port).contentType(ContentType.JSON).when().get("/stackoverflow/questions/" +  "57086935");

        response.then().log().ifError();

        JsonPath jsonPath = response.jsonPath();

        response.then().statusCode(200);

        // Assert the response
        response.then()
                .content("question_id", Matchers.is(57086935))
                .content("user_id",Matchers.is(172677))
                .content("is_answered",Matchers.is(false))
                .content("view_count",Matchers.is(20))
                .statusCode(200);
    }

    @Test
    public void deleteQuestion() {
        Response response = given().port(RestAssured.port).contentType(ContentType.JSON).when().delete("/stackoverflow/questions/" +  "57086935");

        response.then().log().ifError();

        JsonPath jsonPath = response.jsonPath();

        response.then().statusCode(204);
    }

    @Test
    public void retrieveQuestionByTag() {

        Response response = given().port(RestAssured.port).contentType(ContentType.JSON).when().get("/stackoverflow/questions/tag?tagName=flaregamesjava");

        response.then().log().ifError();

        JsonPath jsonPath = response.jsonPath();

        response.then().statusCode(200);

        // Assert the response
        response.then()
                .content("[0].question_id", Matchers.is(57086935))
                .content("[0].user_id",Matchers.is(172677))
                .content("[0].is_answered",Matchers.is(false))
                .content("[0].view_count",Matchers.is(20))
                .statusCode(200);
    }

}
