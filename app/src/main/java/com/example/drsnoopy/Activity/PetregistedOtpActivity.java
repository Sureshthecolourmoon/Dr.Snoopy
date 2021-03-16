package com.example.drsnoopy.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.drsnoopy.R;

import java.util.Objects;

import static com.example.drsnoopy.Activity.PhoneVerificationActivity.hideSoftInput;

public class PetregistedOtpActivity extends AppCompatActivity {
    Button loginbutton;
    EditText otp_Thired_Digit, otp_Four_Digit, otp_First_Digit, otp_Second_Digit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petregisted_otp);
        loginbutton = findViewById(R.id.submit_verification_button);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(PetregistedOtpActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.activity_pet_popup);
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                Button petlink_button_success_popup;
                petlink_button_success_popup = dialog.findViewById(R.id.petlink_button_success_popup);
                petlink_button_success_popup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(PetregistedOtpActivity.this, SuccessRegistrationActivity.class);
                        overridePendingTransition(R.anim.enter, R.anim.exit);
                        startActivity(intent);
                    }
                });
            }
        });

        otp_First_Digit = findViewById(R.id.otp_first_digit_pet);
        otp_Second_Digit = findViewById(R.id.otp_second_digit_pet);
        otp_Thired_Digit = findViewById(R.id.otp_thired_digit_pet);
        otp_Four_Digit = findViewById(R.id.otp_four_digit_pet);
        addFirstListner();
        addSecondListner();
        addThirdListner();
        addFourthListner();


        otp_Four_Digit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.KEYCODE_DEL) {
                    if (otp_Four_Digit.getText().length() == 0) {
                        otp_Thired_Digit.requestFocus();
                        otp_Thired_Digit.setBackground(ContextCompat.getDrawable(PetregistedOtpActivity.this,
                                R.drawable.verify_shape));
                    }

                }
                return false;
            }
        });
        otp_Thired_Digit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.KEYCODE_DEL) {
                    if (otp_Thired_Digit.getText().length() == 0) {
                        otp_Second_Digit.requestFocus();
                        otp_Second_Digit.setBackground(ContextCompat.getDrawable(PetregistedOtpActivity.this,
                                R.drawable.verify_shape));

                    }
                }
                return false;
            }
        });
        otp_Second_Digit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.KEYCODE_DEL) {
                    if (otp_Second_Digit.getText().length() == 0) {
                        otp_First_Digit.requestFocus();
                        otp_First_Digit.setBackground(ContextCompat.getDrawable(PetregistedOtpActivity.this,
                                R.drawable.verify_shape));
                    }
                }
                return false;
            }
        });
        otp_First_Digit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.KEYCODE_DEL) {
                    if (otp_First_Digit.getText().length() == 0) {
                        otp_First_Digit.setBackground(ContextCompat.getDrawable(PetregistedOtpActivity.this,
                                R.drawable.verify_shape));
                    }
                }
                return false;
            }
        });
    }


    private void addFirstListner() {
        otp_First_Digit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (otp_First_Digit.length() == 1) {
                    otp_First_Digit.setBackground(ContextCompat.getDrawable(PetregistedOtpActivity.this,
                            R.drawable.verify_shape_orange));
                    otp_Second_Digit.requestFocus();
                }


            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });


    }

    private void addSecondListner() {
        otp_Second_Digit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (otp_Second_Digit.length() == 1) {
                    otp_Second_Digit.setBackground(ContextCompat.getDrawable(PetregistedOtpActivity.this,
                            R.drawable.verify_shape_orange));

                    otp_Thired_Digit.requestFocus();
                }


            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });


    }

    private void addThirdListner() {
        otp_Thired_Digit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (otp_Thired_Digit.length() == 1) {
                    otp_Thired_Digit.setBackground(ContextCompat.getDrawable(PetregistedOtpActivity.this,
                            R.drawable.verify_shape_orange));
                    otp_Four_Digit.requestFocus();
                }


            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });


    }

    private void addFourthListner() {
        otp_Four_Digit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (otp_Four_Digit.length() == 1) {
                    otp_Four_Digit.setBackground(ContextCompat.getDrawable(PetregistedOtpActivity.this,
                            R.drawable.verify_shape_orange));

                    hideSoftInput(PetregistedOtpActivity.this);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });


    }
}
