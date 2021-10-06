package com.example.trainingapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise {

    String exerciseName;
    List<Integer> sets = new ArrayList<>();

    private int exerciseId;

    public Exercise(String exerciseName, int exerciseId) {
        this.exerciseId = exerciseId;

        this.exerciseName = exerciseName;
    }

    public List<Integer> getReps(){
        return sets;
    }

    public void addReps(Integer rep){
        sets.add(rep);
    }

    public void removeReps(int index){
        sets.remove(index);

    }




    public String getName(){
        return exerciseName;
    }

    public int getId(){
        return exerciseId;
    }


//PLS WORK!
    //123dummycomment
    //further testing
}
