package com.example.trainingapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.model.Exercise;
import com.example.trainingapp.model.Plan;
import com.example.trainingapp.model.Workout;
import com.example.trainingapp.view.Adapter.EditScheduleRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class EditScheduleFragment extends Fragment {

    //Plan activePlan;
    private Workout selectedWorkout;
    private TextView titleText;
    private EditScheduleRecyclerViewAdapter recyclerViewAdapter;

    private Exercise legpress;
    private Workout legday;
    private Exercise benchpress;
    private Workout chestday;

    private List<Plan> testPlans = new ArrayList<>();

    Plan plan; // plan should be the first plan in the database (SavedPlans)

    /**
     * onCreateView creates and returns the view hierarchy associated with the fragment.
     *
     * @param inflater The LayoutInflater object that can be used to inflate any views in the fragment
     * @param container If non-null, this is the parent view that the fragment's UI should be attached to.
     * The fragment should not add the view itself, but this can be used to generate the LayoutParams of the view.
     * This value may be null.
     * @param savedInstanceState  If non-null, this fragment is being re-constructed from a previous saved state as given here.
     *
     * @return Return the View for the fragment's UI, or null.
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_edit_schedule,container,false);
        // activePlan = user.getActivePlan();
        initObjects();
        selectedWorkout = plan.getWorkoutList().get(0);
        initTitleText(v);
        initRecyclerView(v);
        return v;
    }

    private void initRecyclerView(View v) {
        
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.editScheduleRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        recyclerViewAdapter = new EditScheduleRecyclerViewAdapter(selectedWorkout);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void initTitleText(View v) {
        titleText = v.findViewById(R.id.lblSelectedWorkout);
        //titleText.setText(activePlan.getPlanName());
        titleText.setText(selectedWorkout.getName());
    }
    private void initObjects() {
        // setting up test objects

        /*
        listOfSetsLegpress.add(5); // 5 reps 1 time
        listOfSetsBench.add(3); // 3 reps 1 time
         */

        legpress = new Exercise("legpress", 123);
        legpress.addSet(5);
        benchpress = new Exercise("benchpress", 231);
        benchpress.addSet(3);

        /*
        listOfExercisesLegday.add(legpress);
        listOfExercisesChestday.add(benchpress);
         */

        legday = new Workout("legday");
        legday.addExercise(legpress);
        chestday = new Workout("chestday");
        chestday.addExercise(benchpress);


        /*
        listOfWorkoutsLegday.add(legday);
        listOfWorkoutsLegday.add(chestday);

        listOfWorkoutsChestday.add(chestday);
        listOfWorkoutsChestday.add(legday);
         */

        Plan plan1 = new Plan("summer workout");
        plan1.addWorkout(legday);
        plan1.addWorkout(chestday);
        Plan plan2 = new Plan("winter workout");
        plan2.addWorkout(chestday);
        plan2.addWorkout(legday);

        testPlans.add(plan1);
        testPlans.add(plan2);
        plan = plan1;


    }

}
