package com.example.drsnoopy.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.drsnoopy.Adapter.SelectAdapter;
import com.example.drsnoopy.Model.SelectModel;
import com.example.drsnoopy.R;

import java.util.ArrayList;
import java.util.List;

public class SelectActivity extends AppCompatActivity implements SelectAdapter.selecteditemlistlistner {
    RecyclerView recyclerView;
    List<SelectModel> selectModelList;
    SelectAdapter selectAdapter;
    Button selectbutton;
    ImageView change_backarrow_id_select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        change_backarrow_id_select=findViewById(R.id.change_backarrow_id_select);
        change_backarrow_id_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        selectbutton = findViewById(R.id.select_proceedbutton);
        selectbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectActivity.this, DoctorActivity.class);
                overridePendingTransition(R.anim.enter,R.anim.exit);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recycler_select);
        recyclerView.setHasFixedSize(true);
        int Countvalue = 3;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, Countvalue);
        recyclerView.setLayoutManager(gridLayoutManager);
        selectModelList = new ArrayList<>();
        selectModelList.add(new SelectModel(R.drawable.doctors, "Doctors"));
        selectModelList.add(new SelectModel(R.drawable.clinics, "Pet Clinics"));
        selectModelList.add(new SelectModel(R.drawable.grooming, "Pet Grooming"));
        selectModelList.add(new SelectModel(R.drawable.shelter, "Pet Shelter"));
        selectModelList.add(new SelectModel(R.drawable.store, "Pet Store"));
        selectModelList.add(new SelectModel(R.drawable.date, "Pet Date"));
        selectModelList.add(new SelectModel(R.drawable.training, "Pet Training"));
        selectAdapter = new SelectAdapter(SelectActivity.this, selectModelList);
        selectAdapter.setSelecteditemlistlistner(this);
        recyclerView.setAdapter(selectAdapter);
    }


    @Override
    public void Onselecteditemlistner(int position) {
        if (position == 0) {
            Intent intent = new Intent(SelectActivity.this, DoctorActivity.class);
            overridePendingTransition(R.anim.enter,R.anim.exit);
            startActivity(intent);


        }
    }
}