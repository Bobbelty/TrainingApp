package com.example.trainingapp.model;

import java.util.List;

public class PlanFactory {
    public static Plan createPlan(String name, List<Workout> workoutList){return new Plan(name, workoutList);}
}
