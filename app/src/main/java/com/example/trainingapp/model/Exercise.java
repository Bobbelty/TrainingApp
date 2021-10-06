package com.example.trainingapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class for creating an exercise. Several exercises makes up a workout
 */
public class Exercise {

    /**
     * Name of the exercise
     */
    String exerciseName;


    /**
     * List of reps for each set. Each element of the list is the nr of reps and the size of the
     * list is the nr of sets. Ex [12, 12, 12] means 3 sets of 12
     */

    List<Integer> sets = new ArrayList<>();


    /**
     * An exercise contains an id to make it possible for PB-recording purposes
     */
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
