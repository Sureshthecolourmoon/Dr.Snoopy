package com.example.drsnoopy.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.drsnoopy.Adapter.PetrecyclerAdapter;
import com.example.drsnoopy.Fragments.CameraBottomSheetFragment;
import com.example.drsnoopy.Model.PetrecyclerModel;
import com.example.drsnoopy.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PetRegistrationActivity extends AppCompatActivity implements CameraBottomSheetFragment.CameraBottomSheetListener {
    private static final String IMAGE_DIRECTORY = "/demonuts";
    Button submit_buttonpet;
    RecyclerView recyclerView;
    List<PetrecyclerModel> petrecyclerModelList;
    PetrecyclerAdapter petrecyclerAdapter;
    ImageView change_backarrow_id_petregister;
    LinearLayout linearimagefront;
    ImageView imageViewfront;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_registration);
        recyclerView = findViewById(R.id.pets_recyclerview);
        change_backarrow_id_petregister = findViewById(R.id.change_backarrow_id_petregister);
        change_backarrow_id_petregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        imageViewfront = findViewById(R.id.frontimage);
        linearimagefront = findViewById(R.id.linearimagefront);
        linearimagefront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CameraBottomSheetFragment cameraBottamSheetFragment = CameraBottomSheetFragment.getInstance();
                cameraBottamSheetFragment.setCameraBottomSheetListener(PetRegistrationActivity.this);
                cameraBottamSheetFragment.show(getSupportFragmentManager(), "cameraBottomSheet");
            }
        });

        submit_buttonpet = findViewById(R.id.submit_buttonpet);
        submit_buttonpet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(PetRegistrationActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.activity_success_petregistrationpopup_);
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                Button ok;
                ok = dialog.findViewById(R.id.successok);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(PetRegistrationActivity.this, PetregistedOtpActivity.class);
                        overridePendingTransition(R.anim.enter, R.anim.exit);
                        startActivity(intent);
                    }
                });
            }
        });
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        petrecyclerModelList = new ArrayList<>();
        petrecyclerModelList.add(new PetrecyclerModel(R.drawable.dog, "DOG"));
        petrecyclerModelList.add(new PetrecyclerModel(R.drawable.cat, "CAT"));
        petrecyclerModelList.add(new PetrecyclerModel(R.drawable.rabbit, "RABBIT"));
        petrecyclerModelList.add(new PetrecyclerModel(R.drawable.bird, "BIRD"));
        petrecyclerModelList.add(new PetrecyclerModel(R.drawable.others, "OTHERS"));

        petrecyclerAdapter = new PetrecyclerAdapter(this, petrecyclerModelList);
        recyclerView.setAdapter(petrecyclerAdapter);
    }


/*    @Override
    public void bottomsheet(Bitmap bitmap) {
        imageViewfront.setImageBitmap(bitmap);
         = saveImage(bitmap);
    }*/

    private String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY);
// have the object build the directory structure, if needed.
        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs();
        }
        try {
            File f = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                f = new File(wallpaperDirectory, Calendar.getInstance()
                        .getTimeInMillis() + ".jpg");
            }
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(this,
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);
            fo.close();
            Log.d("TAG", "File Saved::--->" + f.getAbsolutePath());

            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }


    @Override
    public void onEventSelected(String eventType) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}