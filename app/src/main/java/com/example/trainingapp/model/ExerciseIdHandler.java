package com.example.trainingapp.model;

import com.example.trainingapp.mockDataBase.MockDataBase;

import java.util.concurrent.atomic.AtomicInteger;

//class name very bad sorry
public class ExerciseIdHandler {
    private MockDataBase mockDatabase = new MockDataBase();

    private static AtomicInteger nextId = new AtomicInteger();
    private int id;



    public void addNewExerciseToDatabase(String name) {
        id = nextId.incrementAndGet();
        mockDatabase.addExerciseIdToMap(name, id);
    }
}
