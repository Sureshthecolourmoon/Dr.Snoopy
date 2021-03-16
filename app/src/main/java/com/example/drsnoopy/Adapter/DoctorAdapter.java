package com.example.drsnoopy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drsnoopy.Fragments.DoctorFragment;
import com.example.drsnoopy.Model.DoctorModel;
import com.example.drsnoopy.R;

import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {
    Context context;
    List<DoctorModel>doctorModelList;

    public DoctorAdapter(Context context, List<DoctorModel> doctorModelList) {
        this.context = context;
        this.doctorModelList = doctorModelList;
    }


    public interface selectitemlistnerdoctor{
        void onselectitemlistnerdoctor(int position);
    }
    public selectitemlistnerdoctor selectitemlistnerdoctor;
public void setSelectitemlistnerdoctor(DoctorAdapter.selectitemlistnerdoctor selectitemlistnerdoctor){
    this.selectitemlistnerdoctor=selectitemlistnerdoctor;
}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
View view=LayoutInflater.from(context).inflate(R.layout.doctor_itemlist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
DoctorModel doctorModel=doctorModelList.get(position);
holder.image.setImageResource(doctorModel.getImage());
holder.location.setImageResource(doctorModel.getLocation());
holder.doctorname.setText(doctorModel.getDoctorname());
holder.experience.setText(doctorModel.getExperience());
//holder.rating.setText(doctorModel.getRating());
holder.km.setText(doctorModel.getKm());

    }

    @Override
    public int getItemCount() {
        return doctorModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image,location;;
        TextView doctorname,experience,km;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        image=itemView.findViewById(R.id.doctor_image);
        location=itemView.findViewById(R.id.location);
        doctorname=itemView.findViewById(R.id.doctor_name);
        experience=itemView.findViewById(R.id.doctor_experience);
       // rating=itemView.findViewById(R.id.rating);
        km=itemView.findViewById(R.id.km);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=getAdapterPosition();
                selectitemlistnerdoctor.onselectitemlistnerdoctor(position);
            }
        });

    }
}
}
