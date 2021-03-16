package com.example.drsnoopy.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.drsnoopy.Adapter.DoctorDateAdapter;
import com.example.drsnoopy.Adapter.DoctorTimingsAdapter;
import com.example.drsnoopy.Model.DoctorDateModel;
import com.example.drsnoopy.Model.DoctorTimingModel;
import com.example.drsnoopy.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class DoctorAppointmentActivity extends BottomSheetDialogFragment {
    RecyclerView daterecyclerview;
    List<DoctorDateModel> doctorDateModelList;
    DoctorDateAdapter doctorDateAdapter;

    RecyclerView timerecyclerview;
    List<DoctorTimingModel> doctorTimingModelList;
    DoctorTimingsAdapter doctorTimingsAdapter;

    TextView book0n_appointment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.BottomSheetDialogStyle);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_doctor_appointment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        book0n_appointment=view.findViewById(R.id.book0n_appointment);
        book0n_appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),AppointmentSuccessActivity.class);
                startActivity(intent);
            }
        });



        timerecyclerview = view.findViewById(R.id.recycler_appointment_time);
        timerecyclerview.setHasFixedSize(true);
        int countvalue = 3;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), countvalue);
        timerecyclerview.setLayoutManager(gridLayoutManager);
        doctorTimingModelList = new ArrayList<>();
        doctorTimingModelList.add(new DoctorTimingModel("09:00 AM"));
        doctorTimingModelList.add(new DoctorTimingModel("09:30 AM"));
        doctorTimingModelList.add(new DoctorTimingModel("10:00 AM"));
        doctorTimingModelList.add(new DoctorTimingModel("10:30 AM"));
        doctorTimingModelList.add(new DoctorTimingModel("11:00 AM"));
        doctorTimingModelList.add(new DoctorTimingModel("11:30 AM"));
        doctorTimingModelList.add(new DoctorTimingModel("12:00 PM"));
        doctorTimingModelList.add(new DoctorTimingModel("12:30 PM"));
        doctorTimingModelList.add(new DoctorTimingModel("01:00 PM"));
        doctorTimingModelList.add(new DoctorTimingModel("01:30 PM"));
        doctorTimingModelList.add(new DoctorTimingModel("02:00 PM"));
        doctorTimingModelList.add(new DoctorTimingModel("02:30 PM"));
        doctorTimingModelList.add(new DoctorTimingModel("03:00 PM"));
        doctorTimingModelList.add(new DoctorTimingModel("03:30 PM"));
        doctorTimingModelList.add(new DoctorTimingModel("04:00 PM"));
        doctorTimingModelList.add(new DoctorTimingModel("04:30 PM"));
        doctorTimingModelList.add(new DoctorTimingModel("05:00 PM"));
        doctorTimingModelList.add(new DoctorTimingModel("05:30 PM"));
        doctorTimingModelList.add(new DoctorTimingModel("06:00 PM"));
        doctorTimingModelList.add(new DoctorTimingModel("06:30 PM"));
        doctorTimingModelList.add(new DoctorTimingModel("07:00 PM"));
        doctorTimingModelList.add(new DoctorTimingModel("07:30 PM"));
        doctorTimingModelList.add(new DoctorTimingModel("08:00 PM"));
        doctorTimingModelList.add(new DoctorTimingModel("08:30 PM"));
        doctorTimingModelList.add(new DoctorTimingModel("09:00 PM"));
        doctorTimingModelList.add(new DoctorTimingModel("09:30 PM"));
        doctorTimingModelList.add(new DoctorTimingModel("10:00 PM"));
        doctorTimingsAdapter=new DoctorTimingsAdapter(requireContext(),doctorTimingModelList);
        timerecyclerview.setAdapter(doctorTimingsAdapter);


        daterecyclerview = view.findViewById(R.id.appointment_date);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(),
                LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        daterecyclerview.setLayoutManager(linearLayoutManager);
        daterecyclerview.setHasFixedSize(true);

        doctorDateModelList = new ArrayList<>();
        doctorDateModelList.add(new DoctorDateModel("Today, Tue 09"));
        doctorDateModelList.add(new DoctorDateModel("Wed 10"));
        doctorDateModelList.add(new DoctorDateModel("Thu 11"));
        doctorDateModelList.add(new DoctorDateModel("Fri 12"));
        doctorDateModelList.add(new DoctorDateModel("Sat 13"));
        doctorDateModelList.add(new DoctorDateModel("Sun 14"));
        doctorDateModelList.add(new DoctorDateModel("Mon 15"));
        doctorDateModelList.add(new DoctorDateModel("Tue 16"));
        doctorDateModelList.add(new DoctorDateModel("Wed 17"));
        doctorDateModelList.add(new DoctorDateModel("Thu 18"));
        doctorDateModelList.add(new DoctorDateModel("Fri 19"));
        doctorDateModelList.add(new DoctorDateModel("Sat 20"));
        doctorDateModelList.add(new DoctorDateModel("Sun 21"));

        doctorDateAdapter = new DoctorDateAdapter(requireContext(), doctorDateModelList);
        daterecyclerview.setAdapter(doctorDateAdapter);
    }
}