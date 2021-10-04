package com.example.trainingapp.model;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise {

    String exerciseName;
    List<Integer> sets;
    private static AtomicInteger nextId = new AtomicInteger();
    private int id;

    public Exercise(String exerciseName) {
        id = nextId.incrementAndGet();
        this.exerciseName = exerciseName;
    }
//PLS WORK!
    //123dummycomment
    //further testing
}
