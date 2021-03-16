package com.example.drsnoopy.Fragments;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.example.drsnoopy.Contrains;
import com.example.drsnoopy.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Objects;

public class CameraBottomSheetFragment extends BottomSheetDialogFragment {
    TextView takePhotoView, galleryView;

    private CameraBottomSheetListener cameraBottomSheetListener;

    public static CameraBottomSheetFragment getInstance() {
        return new CameraBottomSheetFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setWhiteNavigationBar(Objects.requireNonNull(getDialog()));
        }
        View view = inflater.inflate(R.layout.fragment_camera_bottom_sheet, null);
        takePhotoView = view.findViewById(R.id.takePhotoView);
        galleryView = view.findViewById(R.id.galleryView);

        takePhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                cameraBottomSheetListener.onEventSelected(Contrains.CAMERA);

            }
        });

        galleryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                cameraBottomSheetListener.onEventSelected(Contrains.GALLERY);
            }
        });
        return view;
    }

    public interface CameraBottomSheetListener {
        void onEventSelected(String eventType);
    }

    public void setCameraBottomSheetListener(CameraBottomSheetListener cameraBottomSheetListener) {
        this.cameraBottomSheetListener = cameraBottomSheetListener;
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setWhiteNavigationBar(@NonNull Dialog dialog) {
        Window window = dialog.getWindow();
        if (window != null) {
            DisplayMetrics metrics = new DisplayMetrics();
            window.getWindowManager().getDefaultDisplay().getMetrics(metrics);

            GradientDrawable dimDrawable = new GradientDrawable();
// ...customize your dim effect here

            GradientDrawable navigationBarDrawable = new GradientDrawable();
            navigationBarDrawable.setShape(GradientDrawable.RECTANGLE);
            navigationBarDrawable.setColor(Color.WHITE);

            Drawable[] layers = {dimDrawable, navigationBarDrawable};

            LayerDrawable windowBackground = new LayerDrawable(layers);
            windowBackground.setLayerInsetTop(1, metrics.heightPixels);

            window.setBackgroundDrawable(windowBackground);
        }
    }

}
