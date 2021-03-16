package com.example.drsnoopy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drsnoopy.Model.DoctorReviewModel;
import com.example.drsnoopy.R;

import java.util.List;

public class DoctorReviewAdapter extends RecyclerView.Adapter<DoctorReviewAdapter.ViewHolder> {
    Context context;
    List<DoctorReviewModel> doctorReviewModelList;

    public DoctorReviewAdapter(Context context, List<DoctorReviewModel> doctorReviewModelList) {
        this.context = context;
        this.doctorReviewModelList = doctorReviewModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.doctor_reviews, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DoctorReviewModel doctorReviewModel = doctorReviewModelList.get(position);
        holder.reviewtitel.setText(doctorReviewModel.getTitle());
        holder.line.setText(doctorReviewModel.getText());

    }

    @Override
    public int getItemCount() {
        return doctorReviewModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView line, reviewtitel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            line = itemView.findViewById(R.id.text_review);
            reviewtitel = itemView.findViewById(R.id.review_title);
        }
    }
}
