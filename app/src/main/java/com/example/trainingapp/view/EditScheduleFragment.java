package com.example.trainingapp.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.model.components.Workout;
import com.example.trainingapp.view.Adapter.EditScheduleRecyclerViewAdapter;
import com.example.trainingapp.viewModel.EditWorkoutViewModel;

/**
 * Fragment for editing the workouts in plans
 */
public class EditScheduleFragment extends Fragment {

    private Workout selectedWorkout;
    private RecyclerView recyclerView;
    private EditScheduleRecyclerViewAdapter recyclerViewAdapter;
    private EditWorkoutViewModel editWorkoutViewModel = EditWorkoutViewModel.getInstance();


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
        selectedWorkout = editWorkoutViewModel.getSelectedWorkout();
        initTitleText(v);
        initRecyclerView(v);
        initDeleteWorkoutButton(v);
        initAddExerciseButton(v);
        return v;
    }

    /**
     * initAddExerciseButton initiates the add exercise button.
     *
     * @param v the current view used in the application
     */
    private void initAddExerciseButton(View v) {
        Button btnAddExercise = v.findViewById(R.id.btnFinishWorkout);
        btnAddExercise.setVisibility(View.VISIBLE);
        btnAddExercise.setText("Add exercise");
        btnAddExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editWorkoutViewModel.addExerciseToWorkout(editWorkoutViewModel.getSelectedPlan().getId(), selectedWorkout.getId());
                recyclerViewAdapter = new EditScheduleRecyclerViewAdapter();
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    /**
     * initDeleteWorkoutButton initiates the delete workout button
     *
     * @param v the current view used in the application
     */
    private void initDeleteWorkoutButton(View v) {
        Button btnDeleteWorkout = v.findViewById(R.id.btnDeleteWorkout);
        btnDeleteWorkout.setVisibility(View.VISIBLE);
        btnDeleteWorkout.setText("Delete workout");
        btnDeleteWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initPopupMessageView(v);
            }
        });
    }

    /**
     * initPopupMessageView initiates the popup message view
     *
     * @param v the current view used in the application
     */
    private void initPopupMessageView(View v) {
        TextView alertTextView = (TextView) v.findViewById(R.id.AlertTextView);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setCancelable(true);
        builder.setTitle("Remove workout");
        builder.setMessage("Are you sure you want to remove this workout?");

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.setPositiveButton("REMOVE WORKOUT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (getActivity().getCurrentFocus() != null) getActivity().getCurrentFocus().clearFocus();
                editWorkoutViewModel.removeWorkoutFromPlan(editWorkoutViewModel.getSelectedPlan().getId(), selectedWorkout.getId());
                getActivity().finish();
                alertTextView.setVisibility(View.VISIBLE);
            }
        });
        builder.show();
    }

    /**
     * initRecyclerView initiates the recyclerView and sets its adapter.
     *
     * @param v the current view used in the application.
     */
    private void initRecyclerView(View v) {
        recyclerView = (RecyclerView) v.findViewById(R.id.HistoryExerciseRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        recyclerViewAdapter = new EditScheduleRecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    /**
     * initTitleText initiates the title text label.
     *
     * @param v the current view used in the application
     */
    private void initTitleText(View v) {
        EditText etbxWorkoutName = v.findViewById(R.id.etbxWorkoutName);
        etbxWorkoutName.setText(selectedWorkout.getName());

        etbxWorkoutName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String txt = etbxWorkoutName.getText().toString();
                if(txt.equals("")) {
                    etbxWorkoutName.setText(selectedWorkout.getName() + "");
                }
                else {
                    editWorkoutViewModel.setNewWorkoutName(etbxWorkoutName.getText().toString(), editWorkoutViewModel.getSelectedPlan().getId(), selectedWorkout.getId());
                }
            }
        });
    }
}
