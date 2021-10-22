package com.example.trainingapp.mockDataBase;

import com.example.trainingapp.model.activeComponents.ActiveExercise;
import com.example.trainingapp.model.activeComponents.ActiveWorkout;
import com.example.trainingapp.model.activeComponents.ActiveWorkoutSession;
import com.example.trainingapp.model.components.Exercise;
import com.example.trainingapp.model.components.Plan;
import com.example.trainingapp.model.components.Workout;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

/**
 * Class for the database holding the data used in the application.
 */
public class MockDataBase implements IDatabase {


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


    public MockDataBase(){

        Plan examplePlan1 = new Plan();
        examplePlan1.setPlanName("Bulk");

        Workout exampleWorkout1 = new Workout();
        exampleWorkout1.setName("Chest and shoulders");
        Workout exampleWorkout2 = new Workout();
        exampleWorkout2.setName("Back");

        Exercise exampleExercise0 = new Exercise("Dips");
        Exercise exampleExercise1 = new Exercise("Bench Press");
        Exercise exampleExercise2 = new Exercise("Military Press");

        Workout exampleWorkout5 = new Workout();
        exampleWorkout5.setName("Legs");
        Exercise exampleExercise3 = new Exercise("Squats");
        Exercise exampleExercise4 = new Exercise("Leg press");

        exampleExercise1.setNumberOfSets(4);
        exampleExercise1.setNumberOfReps(8);

        exampleExercise2.setNumberOfSets(5);
        exampleExercise2.setNumberOfReps(10);

        exampleExercise3.setNumberOfSets(4);
        exampleExercise3.setNumberOfReps(4);

        exampleExercise4.setNumberOfSets(6);
        exampleExercise4.setNumberOfReps(12);

        exampleWorkout1.addExercise(exampleExercise1);
        exampleWorkout1.addExercise(exampleExercise2);
        exampleWorkout1.addExercise(exampleExercise3);
        exampleWorkout1.addExercise(exampleExercise4);
        examplePlan1.addWorkout(exampleWorkout1);
        examplePlan1.addWorkout(exampleWorkout2);

        addPlan(examplePlan1);

        examplePlan1 = new Plan();
        examplePlan1.setPlanName("Deff");
        exampleWorkout2 = new Workout();
        exampleWorkout2.setName("Heavy chest");
        exampleExercise3 = new Exercise();
        exampleExercise4 = new Exercise();

        exampleWorkout1 = new Workout();
        exampleWorkout1.setName("Backday");
        exampleExercise1 = new Exercise();

        exampleWorkout2 = new Workout();
        exampleExercise3 = new Exercise("Bench Press");
        exampleExercise4 = new Exercise("Military Press");

        exampleWorkout1 = new Workout();
        exampleExercise1 = new Exercise("Squats");
        exampleExercise2 = new Exercise("Leg press");

        exampleExercise1.setNumberOfSets(4);
        exampleExercise1.setNumberOfReps(4);

        exampleExercise2.setNumberOfSets(5);
        exampleExercise2.setNumberOfReps(3);

        exampleExercise3.setNumberOfSets(4);
        exampleExercise3.setNumberOfReps(4);

        exampleExercise4.setNumberOfSets(6);
        exampleExercise4.setNumberOfReps(5);

        exampleWorkout1.addExercise(exampleExercise1);
        exampleWorkout1.addExercise(exampleExercise2);
        exampleWorkout1.addExercise(exampleExercise3);
        exampleWorkout1.addExercise(exampleExercise4);
        examplePlan1.addWorkout(exampleWorkout1);
        examplePlan1.addWorkout(exampleWorkout2);

        ActiveWorkoutSession activeWorkoutSession = new ActiveWorkoutSession();
        ActiveWorkout activeWorkout1 = activeWorkoutSession.convertWorkoutToActiveWorkout(exampleWorkout1);
        ActiveWorkout activeWorkout2 = activeWorkoutSession.convertWorkoutToActiveWorkout(exampleWorkout2);
        activeWorkout1.setCurrentTime("2020-05-12");
        activeWorkout2.setCurrentTime("2019-10-02");
        completedWorkouts.add(activeWorkout1);
        completedWorkouts.add(activeWorkout2);

        addPlan(examplePlan1);
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
        List<Plan> planListCopy = new ArrayList();
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
        return new ArrayList<>(completedWorkouts);
    }

    public void addToCompletedWorkouts(ActiveWorkout workout) {completedWorkouts.add(workout);}

    public List<ActiveExercise> getCurrentPBs() {
        return currentPBs;
    }

    public void addToCurrentPBs(ActiveExercise activeExercise) {
        currentPBs.add(activeExercise);
    }

    public void updateWorkoutName(String name, String planId, String workoutId) throws NullPointerException{
        getPlanFromMap(planId).setWorkoutName(name, workoutId);
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

    public void updateExerciseName(String exerciseName, String planId, String workoutId, String exerciseId) throws NullPointerException{
        getPlanFromMap(planId).updateExerciseName(exerciseName, workoutId, exerciseId);
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
    
    public void updateWeightInSet(String exerciseId, double weight){
        activeWorkout.updateWeightInSet(exerciseId, weight);
    }

    public void endActiveWorkout(){
        activeWorkout.setCurrentTime(activeWorkoutSession.getCurrentDate());
        completedWorkouts.add(activeWorkout);
        activeWorkout = null; //How to remove the pointer? Maybe null is bad? /Valdemar
    }

    private Plan getPlanFromMap(String planId) throws NullPointerException {
        return Objects.requireNonNull(planMap.get(planId), "No plan with this Id exists");
    }
}