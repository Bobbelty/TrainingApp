package com.example.trainingapp.view.Adapter;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.model.Plan;
import com.example.trainingapp.viewModel.EditScheduleViewModel;
import com.example.trainingapp.viewModel.HistoryViewModel;

public class HistoryRecyclerViewAdapter extends RecyclerView.Adapter<EditScheduleRecyclerViewAdapter.ListViewHolder>{

    private Plan plan;
    private Context context;
    private HistoryViewModel historyViewModel = HistoryViewModel.getInstance();


    static class ListViewHolder extends RecyclerView.ViewHolder{

        public ListViewHolder(@NonNull View itemView) {

        }
    }

}
