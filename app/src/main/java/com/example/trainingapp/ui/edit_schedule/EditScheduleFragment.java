package com.example.trainingapp.ui.edit_schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.trainingapp.R;
import com.example.trainingapp.model.Plan;

public class EditScheduleFragment extends Fragment {

    Plan activePlan;

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


        initTitleText(v);

        return v;
    }

    private void initTitleText(View v) {
        TextView lblTitleText = v.findViewById(R.id.btnEditExercise);
        lblTitleText.setText(activePlan.getPlanName());
    }

}
