package com.example.trainingapp.mockDatabase;

import com.example.trainingapp.model.activeComponents.ActiveExercise;
import com.example.trainingapp.model.activeComponents.ActiveWorkout;
import com.example.trainingapp.model.activeComponents.ActiveWorkoutSession;
import com.example.trainingapp.model.components.Exercise;
import com.example.trainingapp.model.components.Plan;
import com.example.trainingapp.model.components.Workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

/**
 * Class for the database holding the data used in the application.
 * @author Victor Hui, Valdemar Vålvik, Oscar Wallin
 */
public class MockDatabase implements IDatabase {

    /**
     * LinkedHashMap holding all the plans used in the application
     */
    private final LinkedHashMap<String, Plan> planMap = new LinkedHashMap<>();

    /**
     * Instance of ActiveWorkoutSession, used to convert workouts to active workouts in the database.
     */
    private final ActiveWorkoutSession activeWorkoutSession = new ActiveWorkoutSession();

    /**
     * Variable for the selected active workout, used for workout tab in application.
     */
    private ActiveWorkout activeWorkout;

    /**
     * List of completed workouts, used to display in history
     */
    private final List<ActiveWorkout> completedWorkouts = new ArrayList<>();

    /**
     * List containing personal bests (in terms of weight) in each completed exercise, used in
     * PB part of application (not yet implemented)
     */
    List<ActiveExercise> currentPBs = new ArrayList<>();

    /**
     * Class constructor is responsible for creating a number of mock Plan-objects. This is done
     * for UI presentation purposes.
     */
    public MockDatabase(){
        Plan examplePlan1 = new Plan("Bulk");
        addPlan(examplePlan1);

        Workout exampleWorkout1 = new Workout("Chest and shoulders");
        Workout exampleWorkout2 = new Workout("Back");
        Workout exampleWorkout3 = new Workout("Legs");

        addWorkoutToPlan(exampleWorkout1, examplePlan1.getId());
        addWorkoutToPlan(exampleWorkout2, examplePlan1.getId());

        Exercise exampleExercise0 = new Exercise("Dips", 12,4);
        Exercise exampleExercise1 = new Exercise("Bench Press",10,3);
        Exercise exampleExercise2 = new Exercise("Military Press",5,5);
        Exercise exampleExercise3 = new Exercise("Squats", 3,5);
        Exercise exampleExercise4 = new Exercise("Leg press",10,5);

        addExerciseToWorkout(exampleExercise0, examplePlan1.getId(), exampleWorkout1.getId());
        addExerciseToWorkout(exampleExercise1, examplePlan1.getId(), exampleWorkout1.getId());
        addExerciseToWorkout(exampleExercise2, examplePlan1.getId(), exampleWorkout1.getId());

        addExerciseToWorkout(exampleExercise3, examplePlan1.getId(), exampleWorkout2.getId());
        addExerciseToWorkout(exampleExercise4, examplePlan1.getId(), exampleWorkout2.getId());


        Plan examplePlan2 = new Plan("Deff");
        addPlan(examplePlan2);

        Workout exampleWorkout11 = new Workout("Legs");
        Workout exampleWorkout22 = new Workout("Back");

        addWorkoutToPlan(exampleWorkout11, examplePlan2.getId());
        addWorkoutToPlan(exampleWorkout22, examplePlan2.getId());

        exampleExercise0 = new Exercise("Squats", 12,4);
        exampleExercise1 = new Exercise("Leg press",10,3);
        exampleExercise2 = new Exercise("Leg extension",5,5);
        exampleExercise3 = new Exercise("Deadlift", 3,5);
        exampleExercise4 = new Exercise("Row",10,5);

        addExerciseToWorkout(exampleExercise0, examplePlan2.getId(), exampleWorkout11.getId());
        addExerciseToWorkout(exampleExercise1, examplePlan2.getId(), exampleWorkout11.getId());
        addExerciseToWorkout(exampleExercise2, examplePlan2.getId(), exampleWorkout11.getId());

        addExerciseToWorkout(exampleExercise3, examplePlan2.getId(), exampleWorkout22.getId());
        addExerciseToWorkout(exampleExercise4, examplePlan2.getId(), exampleWorkout22.getId());


        ActiveWorkout activeWorkout1 = activeWorkoutSession.convertWorkoutToActiveWorkout(exampleWorkout11);
        ActiveWorkout activeWorkout2 = activeWorkoutSession.convertWorkoutToActiveWorkout(exampleWorkout22);
        activeWorkout1.setCurrentTime("2019-05-12");
        activeWorkout2.setCurrentTime("2020-10-02");
        completedWorkouts.add(activeWorkout1);
        completedWorkouts.add(activeWorkout2);

    }
    

    public void addPlan(Plan plan) {
        planMap.put(plan.getId(), plan);
    }

    public void removePlan(String id){
        planMap.remove(id);
    }

    public void updatePlanName(String name, String id) throws NullPointerException{
        getPlanFromMap(id).setPlanName(name);
    }

    public List<Plan> getPlanList() throws NullPointerException {
        List<Plan> planListCopy = new ArrayList<>();
        for(String key : planMap.keySet()){
                planListCopy.add(new Plan(getPlanFromMap(key)));
        }
        return planListCopy;
    }

    public Plan getPlan(String planId) throws NullPointerException{
        return new Plan(getPlanFromMap(planId));
    }

    public Workout getWorkout(String planId, String workoutId) throws NullPointerException{
        return getPlanFromMap(planId).getWorkoutById(workoutId);
    }
    public List<ActiveWorkout> getCompletedWorkouts() {
        List<ActiveWorkout> temp = new ArrayList<>(completedWorkouts);
        Collections.reverse(temp);
        return temp;
    }

    public void addToCompletedWorkouts(ActiveWorkout workout) {completedWorkouts.add(workout);}

    public void updateWorkoutName(String name, String planId, String workoutId) throws NullPointerException{
        getPlanFromMap(planId).updateWorkoutName(name, workoutId);
    }

    public void removeWorkoutFromPlan(String planId, String workoutId) throws NullPointerException{
        getPlanFromMap(planId).removeWorkout(workoutId);
    }

    public void addWorkoutToPlan(Workout workout, String planId) throws NullPointerException{
        getPlanFromMap(planId).addWorkout(workout);
    }

    public void addExerciseToWorkout(Exercise exercise, String planId, String workoutId) throws NullPointerException{
        getPlanFromMap(planId).addExerciseToWorkout(exercise, workoutId);
    }

    public void removeExerciseFromWorkout(String planId, String workoutId, String exerciseId) throws NullPointerException{
        getPlanFromMap(planId).removeExerciseFromWorkout(workoutId, exerciseId);
    }

    public void updateExerciseName(String planId, String workoutId, String exerciseId, String exerciseName) throws NullPointerException{
        getPlanFromMap(planId).updateExerciseName(workoutId, exerciseId, exerciseName);
    }

    public void updateExerciseRep(int reps, String planId, String workoutId, String exerciseId) throws NullPointerException{
        getPlanFromMap(planId).updateExerciseRep(workoutId, exerciseId, reps);
    }

    public void updateExerciseSets(int sets, String planId, String workoutId, String exerciseId) throws NullPointerException{
        getPlanFromMap(planId).updateExerciseSets(workoutId, exerciseId, sets);
    }

    public void newActiveWorkout(String planId, String workoutId) throws NullPointerException{
        Workout workout = new Workout(getPlanFromMap(planId).getWorkoutById(workoutId));
        activeWorkout = activeWorkoutSession.convertWorkoutToActiveWorkout(workout);
    }

    public ActiveWorkout getActiveWorkout(){
        return new ActiveWorkout(activeWorkout);
    }

    public void updateActiveExerciseRep(int reps, String exerciseId){
        activeWorkout.updateActiveExerciseRep(reps, exerciseId);
    }

    public void updateActiveExerciseWeight(String exerciseId, double weight){
        activeWorkout.updateActiveExerciseWeight(exerciseId, weight);
    }

    public void endActiveWorkout(){
        activeWorkout.setCurrentTime(activeWorkoutSession.getCurrentDate());
        completedWorkouts.add(activeWorkout);
        activeWorkout = null; //How to remove the pointer? Maybe null is bad? /Valdemar
    }

    /**
     * Method for retrieving specific Plan-object from hashmap.
     *
     * @param planId what Plan-object to look for
     *
     * @return Plan from hashmap
     *
     * @throws NullPointerException if the id doesn't get a match in the hashmap
     */
    private Plan getPlanFromMap(String planId) throws NullPointerException {
        return Objects.requireNonNull(planMap.get(planId), "No plan with this Id exists");
    }
}