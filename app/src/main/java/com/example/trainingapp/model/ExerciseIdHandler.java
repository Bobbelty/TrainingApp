package com.example.trainingapp.model;

import com.example.trainingapp.mockDataBase.MockDataBase;

import java.util.concurrent.atomic.AtomicInteger;
//THIS CLASS IS REDUNDANT AND CAN BE REMOVED.
/**
 * Class containing logic for handling ExerciseId:s.
 * Takes care of creating new ExerciseId:s, adding them to Database, and removing them from Database.
 */
public class ExerciseIdHandler {


    /**
     *  An int value that maybe updated atomically. Used for generating unique id:s.
     */
    private static AtomicInteger nextId = new AtomicInteger();

    /**
     *
     * The key to a Map in database that contains all exerciseId:s.
     *                      The key is always a exercise name in string for, e.g "Bench Press"
     *                      or "Deadlift"
     *
     */

    public int getNewExerciseId() {
        return nextId.incrementAndGet();
    }


}
