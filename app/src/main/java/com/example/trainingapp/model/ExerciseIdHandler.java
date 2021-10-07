package com.example.trainingapp.model;

import com.example.trainingapp.mockDataBase.MockDataBase;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class containing logic for handling ExerciseId:s.
 * Takes care of creating new ExerciseId:s, adding them to Database, and removing them from Database.
 */
public class ExerciseIdHandler {
    /**
     * Instance of mockDatabase for accessing data
     */
    private MockDataBase mockDatabase = new MockDataBase();

    /**
     *  An int value that maybe updated atomically. Used for generating unique id:s.
     */
    private static AtomicInteger nextId = new AtomicInteger();
    /**
     * The id number that a newly generated exerciseId will have
     */
    private int Id;

    /**
     *
     * @param exerciseIdKey The key to a Map in database that contains all exerciseId:s.
     *                      The key is always a exercise name in string for, e.g "Bench Press"
     *                      or "Deadlift"
     *
     */

    public void addNewExerciseToDatabase(String exerciseIdKey) {
        Id = nextId.incrementAndGet();
        mockDatabase.addExerciseIdToMap(exerciseIdKey, Id);
    }


}
