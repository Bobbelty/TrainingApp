package com.example.trainingapp.view;

import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.databinding.FragmentHistoryBinding;
import com.example.trainingapp.model.activeComponents.ActiveWorkout;
import com.example.trainingapp.view.Adapter.HistoryRecyclerViewAdapter;
import com.example.trainingapp.viewModel.HistoryViewModel;


import java.util.ArrayList;

/**
 * HistoryFragment acts as the "view" in mvvm. It is responsible for displaying all parts to the
 * fragment.history.xml
 *
 * @author Valdemar Vålvik and Victor Hui
 */

public class HistoryFragment extends Fragment {

    /**
     * Instance of HistoryViewModel to enable communication and displaying of the correct elements.
     */

    private HistoryViewModel historyViewModel = new HistoryViewModel();

    /**
     * Instance of the binding-class for fragment_history.xml. Allows for access of all the root views
     * ID's.
     */

    private FragmentHistoryBinding binding;

    private List<ActiveWorkout> testActiveWorkouts = new ArrayList<>();
    Context context;
    HistoryRecyclerViewAdapter recyclerViewAdapter;

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

        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_history,container,false);

        initObjects();
        initRecyclerView(v);

        return v;
    }

    /**
     * initRecyclerView initiates the recyclerView and sets its adapter.
     *
     * @param v the current view used in the application.
     */
    private void initRecyclerView(View v) {
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.history_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        recyclerViewAdapter = new HistoryRecyclerViewAdapter(testActiveWorkouts, this.getActivity(), this.getContext());
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    /**
     * initObjects initiates the objects to be shown in history
     *
     */
    private void initObjects() {
        testActiveWorkouts = historyViewModel.getTrainingAppModel().getCompletedWorkouts();
    }

    /**
     * onDestroyView is called when the view previously created by onCreateView has been detached from the fragment.
     * The next time the fragment needs to be displayed, a new view will be created.
     */

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}