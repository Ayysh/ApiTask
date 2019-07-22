package com.flaregames.stackoverflow.constants;

/**
 * This file defines all constants used in this project
 */

public class Constants {

    private Constants() {
    }

    public static final String BASE_PACKAGE = "com.flaregames";
    public static final String STACKOVERFLOW_BASE_PACKAGE = "com.flaregames.stackoverflow";
    public static final String GET_USER_RESOURCE_URL = "/users/{userId}";
    public static final String GET_QUESTIONS_RESOURCE_URL = "/questions";
    public static final String GET_QUESTIONBYID_RESOURCE_URL = "/questions/{id}";
    public static final String GET_QUESTION_TAG_RESOURCE_URL = "/questions/tag";
    public static final String STACK_OVERFLOW_BASE_URL = "/stackoverflow";
    public static final String REMOTE_STACK_OVERFLOW_BASE_URL = "http://api.stackexchange.com";
    public static final String REMOTE_STACK_OVERFLOW_USER_URL = REMOTE_STACK_OVERFLOW_BASE_URL + "/2.2/users/%s?key=U4DMV*8nvpm3EOpvf69Rxw((&site=stackoverflow&order=desc&sort=reputation&filter=default";

    public static final String REMOTE_STACK_OVERFLOW_QUESTION_URL = REMOTE_STACK_OVERFLOW_BASE_URL + "/2.2/questions/featured?key=U4DMV*8nvpm3EOpvf69Rxw((&site=stackoverflow&order=desc&sort=creation&filter=default&pagesize=20";
}
