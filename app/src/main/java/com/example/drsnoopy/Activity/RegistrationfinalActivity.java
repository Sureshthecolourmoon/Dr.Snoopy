package com.example.drsnoopy.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.drsnoopy.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import static com.example.drsnoopy.Activity.PhoneVerificationActivity.hideSoftInput;

public class RegistrationfinalActivity extends AppCompatActivity {
    EditText otp_Thired_Digit, otp_Four_Digit, otp_First_Digit, otp_Second_Digit;
    Button registerfinal_button;
    TextInputEditText reg_distric_enter;
    ImageView mapImgView, change_backarrow_id_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationfinal);
        registerfinal_button = findViewById(R.id.registerfinal_button);
        otp_First_Digit = findViewById(R.id.otp_first_digit_reg);
        reg_distric_enter = findViewById(R.id.reg_distric_enter);
        otp_Second_Digit = findViewById(R.id.otp_second_digit_reg);
        otp_Thired_Digit = findViewById(R.id.otp_thired_digit_reg);
        otp_Four_Digit = findViewById(R.id.otp_four_digit_reg);
        change_backarrow_id_register = findViewById(R.id.change_backarrow_id_register);
        mapImgView = findViewById(R.id.home_maplayout);
        change_backarrow_id_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        reg_distric_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationfinalActivity.this, MapActivity.class);
                overridePendingTransition(R.anim.enter,R.anim.exit);
                startActivity(intent);
            }
        });
        registerfinal_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationfinalActivity.this, SuccessRegisterActivity.class);
                overridePendingTransition(R.anim.enter,R.anim.exit);
                startActivity(intent);
            }
        });
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
                        otp_Thired_Digit.setBackground(ContextCompat.getDrawable(RegistrationfinalActivity.this,
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
                        otp_Second_Digit.setBackground(ContextCompat.getDrawable(RegistrationfinalActivity.this,
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
                        otp_First_Digit.setBackground(ContextCompat.getDrawable(RegistrationfinalActivity.this,
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
                        otp_First_Digit.setBackground(ContextCompat.getDrawable(RegistrationfinalActivity.this,
                                R.drawable.verify_shape));
                    }
                }
                return false;
            }
        });
        //MapView
        String latEiffelTower = "48.858235";
        String lngEiffelTower = "2.294571";
        String url = "http://maps.google.com/maps/api/staticmap?center=" + latEiffelTower + "," + lngEiffelTower + "&zoom=15&size=200x200&sensor=false&key=AIzaSyB7-I1_QqmQXOA-1pKN_8Uv0vAirxPqNyw";
        Glide.with(this).load(url).into(mapImgView);
    }


    private void addFirstListner() {
        otp_First_Digit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (otp_First_Digit.length() == 1) {
                    otp_First_Digit.setBackground(ContextCompat.getDrawable(RegistrationfinalActivity.this,
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
                    otp_Second_Digit.setBackground(ContextCompat.getDrawable(RegistrationfinalActivity.this,
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
                    otp_Thired_Digit.setBackground(ContextCompat.getDrawable(RegistrationfinalActivity.this,
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
                    otp_Four_Digit.setBackground(ContextCompat.getDrawable(RegistrationfinalActivity.this,
                            R.drawable.verify_shape_orange));

                    hideSoftInput(RegistrationfinalActivity.this);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });


    }


}