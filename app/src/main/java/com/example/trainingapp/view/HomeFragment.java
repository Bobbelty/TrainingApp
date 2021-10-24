package com.example.trainingapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.trainingapp.R;
import com.example.trainingapp.databinding.FragmentHomeBinding;
import com.example.trainingapp.viewModel.HomeViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * HomeFragment acts as the "view" in mvvm. It is responsible for displaying all parts to the
 * fragment.home.xml
 *
 * @author Philip Rabia and Patrik Olsson
 */

public class HomeFragment extends Fragment {

    /**
     * Instance of HomeViewModel to enable communication and displaying of the correct elements.
     */

    private HomeViewModel homeViewModel;

    /**
     * Instance of the binding-class for fragment_home.xml. Allows for access of all the root views
     * ID's.
     */

    private FragmentHomeBinding binding;
    private TextView lblDate;

    /**
     * onCreateView creates and returns the view hierarchy associated with the fragment.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate any views in the fragment
     * @param container          If non-null, this is the parent view that the fragment's UI should be attached to.
     *                           The fragment should not add the view itself, but this can be used to generate the LayoutParams of the view.
     *                           This value may be null.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textHome;
        /*homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });*/
        initObjects(root);
        return root;
    }

    private void initObjects(View v) {
        TextView lblDate = v.findViewById(R.id.lblDate);
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(dateFormat.format(date));
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