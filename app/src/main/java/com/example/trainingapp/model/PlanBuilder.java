package com.example.trainingapp.model;

import java.util.List;

public class PlanBuilder {

    private Plan createEmptyPlan(String name, List<Workout> workoutList){
        return PlanFactory.createPlan(name, workoutList);
    }

    private Workout createEmptyWorkout(String workoutName, List<Exercise> exerciseList) {
        return WorkoutFactory.createWorkout(workoutName,exerciseList);
    }

    private Exercise createExercise(String exerciseName, List<Integer> sets) {
        return ExerciseFactory.createExercise(exerciseName, sets);
    }


}
