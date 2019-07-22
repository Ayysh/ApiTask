package com.flaregames.stackoverflow.service;


/**
 * This class does the initialization of DB during startup
 */
public interface InitalizeDataService {

    /**
     * This method is called during startup to populate the database with Questions
     */
    void initializeDB();
}
