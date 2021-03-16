package com.example.drsnoopy.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.drsnoopy.Adapter.DoctorReviewAdapter;
import com.example.drsnoopy.Model.DoctorReviewModel;
import com.example.drsnoopy.R;

import java.util.ArrayList;
import java.util.List;

public class DetailsDoctorActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<DoctorReviewModel> doctorReviewModelList;
    DoctorReviewAdapter doctorReviewAdapter;
    ImageView change_backarrow_id_doctor;

    TextView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_doctor);
        button = findViewById(R.id.appointment);
        change_backarrow_id_doctor=findViewById(R.id.change_backarrow_id_doctor);
        change_backarrow_id_doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoctorAppointmentActivity doctorAppointmentActivity = new DoctorAppointmentActivity();
                doctorAppointmentActivity.show(getSupportFragmentManager(),doctorAppointmentActivity.getTag());
            }
        });

        recyclerView = findViewById(R.id.recycler_doctor_review);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        doctorReviewModelList = new ArrayList<>();
        doctorReviewModelList.add(new DoctorReviewModel("He was friendly and diligent in getting to the right diagnosis and prescription", "a Verified Rreview"));
        doctorReviewModelList.add(new DoctorReviewModel("He was friendly and diligent in getting to the right diagnosis and prescription", "a Verified Rreview"));
        doctorReviewModelList.add(new DoctorReviewModel("He was friendly and diligent in getting to the right diagnosis and prescription", "a Verified Rreview"));
        doctorReviewModelList.add(new DoctorReviewModel("He was friendly and diligent in getting to the right diagnosis and prescription", "a Verified Rreview"));
        doctorReviewModelList.add(new DoctorReviewModel("He was friendly and diligent in getting to the right diagnosis and prescription", "a Verified Rreview"));
        doctorReviewAdapter = new DoctorReviewAdapter(this, doctorReviewModelList);
        recyclerView.setAdapter(doctorReviewAdapter);
    }
}