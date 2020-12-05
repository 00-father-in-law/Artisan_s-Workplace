package com.father_in_law.artisan_s_workplace.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.father_in_law.artisan_s_workplace.R;
import com.father_in_law.artisan_s_workplace.Repository.FirebaseRepo.LoginRepository;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SignUpActivity extends AppCompatActivity implements LoginRepository.FirebaseLoginListener {

    private EditText email, password, passwordchk, phone, code;
    private TextInputLayout password_layout, passwordchk_layout;
    private TextView birthday_txt, gender_txt;
    private Button complete, getcode;
    private ImageButton back_btn;
    private CheckBox agree;

    private ImageView step1_img, step2_img, step3_img, codechk;
    private LinearLayout step1_layout, step2_layout, step3_layout;
    private RelativeLayout birthday_btn, gender_btn;
    private int step = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.signup_email_text);
        password = findViewById(R.id.signup_password_text);
        passwordchk = findViewById(R.id.signup_passwordchk_text); //TODO : 비밀번호 확인 (미완)
        phone = findViewById(R.id.signup_phone_text);
        code = findViewById(R.id.signup_code);

        birthday_txt = findViewById(R.id.signup_birthday_txt);
        gender_txt = findViewById(R.id.signup_gender_txt);

        password_layout = findViewById(R.id.signup_password_textlayout);
        passwordchk_layout = findViewById(R.id.signup_passwordchk_textlayout);

        agree = findViewById(R.id.signup_agree);

        complete = findViewById(R.id.signup_complete_btn);
        getcode = findViewById(R.id.signup_getcode);

        back_btn = findViewById(R.id.signup_back_btn);

        step1_img = findViewById(R.id.signup_image_step1);
        step2_img = findViewById(R.id.signup_image_step2);
        step3_img = findViewById(R.id.signup_image_step3);
        codechk = findViewById(R.id.signup_codechk);

        step1_layout = findViewById(R.id.signup_step1_layout);
        step2_layout = findViewById(R.id.signup_step2_layout);
        step3_layout = findViewById(R.id.signup_step3_layout);

        birthday_btn = findViewById(R.id.signup_birthday_btn);
        gender_btn = findViewById(R.id.signup_gender_btn);

        final LoginRepository loginRepository = new LoginRepository(this, this);

        hideAll();

        password_layout.setPasswordVisibilityToggleEnabled(true);
        password_layout.setHintEnabled(false);
        passwordchk_layout.setPasswordVisibilityToggleEnabled(true);
        passwordchk_layout.setHintEnabled(false);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //성별 dialog처리
        final Dialog dialog = new BottomSheetDialog(this);

        gender_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.setContentView(R.layout.signup_gender_dialog);
                dialog.setCancelable(true);
                dialog.show();

                final TextView female = dialog.findViewById(R.id.gender_female);
                final TextView male = dialog.findViewById(R.id.gender_male);

                female.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        gender_txt.setText(female.getText().toString());
                        dialog.cancel();
                    }
                });

                male.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        gender_txt.setText(male.getText().toString());
                        dialog.cancel();
                    }
                });
            }
        });

        final DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear = (monthOfYear + 1) % 12;
                birthday_txt.setText(year + "년 " + monthOfYear + "월 " + dayOfMonth +"일");
            }
        };

        birthday_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(SignUpActivity.this, listener, 2000, 01, 01);
                dialog.show();
            }
        });





        //단계별 ui 미완
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(step == 1){
                    step++;

                    step1_img.setVisibility(View.GONE);
                    step1_layout.setVisibility(View.GONE);

                    step2_img.setVisibility(View.VISIBLE);
                    step2_layout.setVisibility(View.VISIBLE);
                }else if(step == 2){
                    step++;

                    step2_img.setVisibility(View.GONE);
                    step2_layout.setVisibility(View.GONE);

                    step3_img.setVisibility(View.VISIBLE);
                    step3_layout.setVisibility(View.VISIBLE);

                }else if(step == 3){
                    //입력한 정보들로 로그인처리
                }

//                String emailstr = email.getText().toString();
//                String passwordstr = password.getText().toString();
//
//                if(emailstr.equals("") || passwordstr.equals("")){
//                    Toast.makeText(SignUpActivity.this, "입력하세요.", Toast.LENGTH_SHORT).show();
//                }else {
//                    loginRepository.firebaseSignup(emailstr, passwordstr);
//                }
            }
        });







    }

    private void hideAll() {
        step2_layout.setVisibility(View.GONE);
        step3_layout.setVisibility(View.GONE);

        step2_img.setVisibility(View.GONE);
        step3_img.setVisibility(View.GONE);

        codechk.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess() {
        finish();
    }

    @Override
    public void onError() {
        Toast.makeText(SignUpActivity.this, "회원가입 에러", Toast.LENGTH_SHORT).show();
    }
}