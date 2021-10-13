package com.example.trainingapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.model.Plan;
import com.example.trainingapp.model.Workout;
import com.example.trainingapp.view.Adapter.EditScheduleRecyclerViewAdapter;
import com.example.trainingapp.viewModel.EditScheduleViewModel;

import java.util.ArrayList;
import java.util.List;

public class EditScheduleFragment extends Fragment {

    //Plan activePlan;
    private Workout selectedWorkout;
    private TextView titleText;
    private Button btnDeleteWorkout;
    private EditScheduleRecyclerViewAdapter recyclerViewAdapter;
    private EditScheduleViewModel editScheduleViewModel = EditScheduleViewModel.getInstance();

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
        selectedWorkout = editScheduleViewModel.getSelectedWorkout();
        btnDeleteWorkout = v.findViewById(R.id.btnDeleteWorkout);
        btnDeleteWorkout.setText("test");
        initTitleText(v);
        initRecyclerView(v);


        //initButton(v);
        return v;
    }
    private void initButton(View v) {

        btnDeleteWorkout = v.findViewById(R.id.btnDeleteWorkout);
        btnDeleteWorkout.setText("test");

        /*btnDeleteWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Plan> plans = editScheduleViewModel.getTrainingAppModel().getSavedPlans();
                for (int i = 0; i < plans.size(); i++) {
                    if (plans.get(i).equals(testPlans)) {
                        System.out.println(editScheduleViewModel.getTrainingAppModel().getSavedPlans().get(i).getWorkoutList().toString());
                        for (int k = 0; k < plans.get(i).getWorkoutList().size(); k++) {
                            if (plans.get(i).getWorkoutList().get(k).equals(selectedWorkout)) {
                                plans.get(i).getWorkoutList().remove(k);
                                System.out.println(editScheduleViewModel.getTrainingAppModel().getSavedPlans().get(i).getWorkoutList().toString());
                            }
                        }
                    }
                }
                testPlans = editScheduleViewModel.getTrainingAppModel().getSavedPlans();
                // better to call to ScheduleViewModel to do this
            }
        });*/
    }
    private void initRecyclerView(View v) {

        //selectedWorkout
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.editScheduleRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        recyclerViewAdapter = new EditScheduleRecyclerViewAdapter(selectedWorkout);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void initTitleText(View v) {
        titleText = v.findViewById(R.id.lblSelectedWorkout);
        titleText.setText(selectedWorkout.getName());
    }
    private void initObjects() {
        // setting up test objects
        testPlans = editScheduleViewModel.getTrainingAppModel().getSavedPlans();
        plan = testPlans.get(0); // get active plan instead
    }
}
