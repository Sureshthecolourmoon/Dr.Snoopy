package com.example.drsnoopy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drsnoopy.Model.DoctorTimingModel;
import com.example.drsnoopy.R;

import java.util.List;

public class DoctorTimingsAdapter extends RecyclerView.Adapter<DoctorTimingsAdapter.ViewHolder> {
    Context context;
    List<DoctorTimingModel>doctorTimingModelList;

    public DoctorTimingsAdapter(Context context, List<DoctorTimingModel> doctorTimingModelList) {
        this.context = context;
        this.doctorTimingModelList = doctorTimingModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.doctor_appointment_timing,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DoctorTimingModel doctorTimingModel= doctorTimingModelList.get(position);
        holder.timingtext.setText(doctorTimingModel.getTexttiming());

    }

    @Override
    public int getItemCount() {
        return doctorTimingModelList.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
TextView timingtext;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        timingtext=itemView.findViewById(R.id.text_time);
        }
    }
}
