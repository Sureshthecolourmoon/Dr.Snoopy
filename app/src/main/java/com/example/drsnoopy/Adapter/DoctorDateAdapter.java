package com.example.drsnoopy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drsnoopy.Model.DoctorDateModel;
import com.example.drsnoopy.R;

import java.util.List;

public class DoctorDateAdapter extends RecyclerView.Adapter<DoctorDateAdapter.ViewHolder> {
    Context context;
    List<DoctorDateModel> doctorDateModelList;

    public DoctorDateAdapter(Context context, List<DoctorDateModel> doctorDateModelList) {
        this.context = context;
        this.doctorDateModelList = doctorDateModelList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.doctor_apointment_date_itemlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DoctorDateModel doctorDateModel = doctorDateModelList.get(position);
        holder.textView.setText(doctorDateModel.getText());

    }

    @Override
    public int getItemCount() {
        return doctorDateModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.appointment_date_tv);
        }
    }

}
