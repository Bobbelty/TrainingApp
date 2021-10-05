package com.example.trainingapp.model;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise {

    String exerciseName;
    List<Integer> sets;

    private int exerciseId;

    public Exercise(String exerciseName, int exerciseId) {
        this.exerciseId = exerciseId;

        this.exerciseName = exerciseName;
    }

    public void addReps(Integer rep){
        sets.add(rep);
    }


//PLS WORK!
    //123dummycomment
    //further testing
}
