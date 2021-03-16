package com.example.drsnoopy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.drsnoopy.Activity.LoginActivity;
import com.example.drsnoopy.Activity.PhoneVerificationActivity;
import com.example.drsnoopy.Activity.Register;
import com.example.drsnoopy.Adapter.Home_Recycler_Adapter;
import com.example.drsnoopy.Model.Home_recycler_Model;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    Button button, register;
    RecyclerView recyclerView;
    List<Home_recycler_Model> home_recycler_modelList;
    Home_Recycler_Adapter home_recycler_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);
        recyclerView = findViewById(R.id.home_icon_recycle);

        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, Register.class);
                startActivity(intent);
            }
        });
        button = findViewById(R.id.button_continue);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, PhoneVerificationActivity.class);
                startActivity(intent);
            }
        });
        int numberofcolums = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberofcolums));
        recyclerView.setHasFixedSize(true);

        home_recycler_modelList = new ArrayList<>();
        home_recycler_modelList.add(new Home_recycler_Model(R.drawable.doctors, "Pet Doctors"));
        home_recycler_modelList.add(new Home_recycler_Model(R.drawable.clinics, "Pet Clinics"));
        home_recycler_modelList.add(new Home_recycler_Model(R.drawable.grooming, "Pet Grooming"));
        home_recycler_modelList.add(new Home_recycler_Model(R.drawable.shelter, "Pet Shelter"));
        home_recycler_modelList.add(new Home_recycler_Model(R.drawable.store, "Pet Store"));
        home_recycler_modelList.add(new Home_recycler_Model(R.drawable.date, "Pet Date"));
        home_recycler_modelList.add(new Home_recycler_Model(R.drawable.training, "Pet Training"));
        home_recycler_adapter = new Home_Recycler_Adapter(this, home_recycler_modelList);
        recyclerView.setAdapter(home_recycler_adapter);

    }
}