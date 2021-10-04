package com.example.trainingapp.mockDataBase;

import com.example.trainingapp.model.Plan;
import com.example.trainingapp.model.Workout;

import java.util.ArrayList;
import java.util.List;

public class MockDataBase {
    List<Plan> planList = new ArrayList<>();

    public void addPlan(Plan plan) {
    planList.add(plan);
    }

    public void removePlan(Plan plan){
    planList.remove(plan);
    }
}