package com.example.drsnoopy.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chaos.view.PinView;
import com.example.drsnoopy.R;

public class PhoneVerificationActivity extends AppCompatActivity {
    public PinView otp_view;
    private String otpview;
    TextView textView;
    LinearLayout resendOTP;
    ImageView login_back;
    Button button;
    EditText otp_Thired_Digit, otp_Four_Digit, otp_First_Digit, otp_Second_Digit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_verification);
        textView = findViewById(R.id.time);
//        resendOTP = findViewById(R.id.resendOTP);

        login_back=findViewById(R.id.login_back);
        login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

       /* button = findViewById(R.id.loging_verification_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhoneVerificationActivity.this, SelectActivity.class);
                startActivity(intent);
            }
        });*/


        otp_First_Digit = findViewById(R.id.otp_first_digit);
        otp_Second_Digit = findViewById(R.id.otp_second_digit);
        otp_Thired_Digit = findViewById(R.id.otp_thired_digit);
        otp_Four_Digit = findViewById(R.id.otp_four_digit);


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
                        otp_Thired_Digit.setBackground(ContextCompat.getDrawable(PhoneVerificationActivity.this,
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
                        otp_Second_Digit.setBackground(ContextCompat.getDrawable(PhoneVerificationActivity.this,
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
                        otp_First_Digit.setBackground(ContextCompat.getDrawable(PhoneVerificationActivity.this,
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
                        otp_First_Digit.setBackground(ContextCompat.getDrawable(PhoneVerificationActivity.this,
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
                    otp_First_Digit.setBackground(ContextCompat.getDrawable(PhoneVerificationActivity.this,
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
                    otp_Second_Digit.setBackground(ContextCompat.getDrawable(PhoneVerificationActivity.this,
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
                    otp_Thired_Digit.setBackground(ContextCompat.getDrawable(PhoneVerificationActivity.this,
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
                    otp_Four_Digit.setBackground(ContextCompat.getDrawable(PhoneVerificationActivity.this,
                            R.drawable.verify_shape_orange));

                    hideSoftInput(PhoneVerificationActivity.this);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });


    }

    public static void hideSoftInput(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view == null) view = new View(activity);
        InputMethodManager imm = (InputMethodManager) activity
                .getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    private void countdown() {
        final int[] counter = {30};

        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                textView.setText("Resend Code in " + "0:" + counter[0]);
                counter[0]--;
                Log.d("timer", String.valueOf(counter[0]));
            }

            public void onFinish() {
                textView.setText("Resend Otp");
            }
        }.start();
    }
}