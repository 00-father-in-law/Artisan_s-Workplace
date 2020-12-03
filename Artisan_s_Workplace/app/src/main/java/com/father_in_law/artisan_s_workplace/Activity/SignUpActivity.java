package com.father_in_law.artisan_s_workplace.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.father_in_law.artisan_s_workplace.R;
import com.father_in_law.artisan_s_workplace.Repository.FirebaseRepo.LoginRepository;

public class SignUpActivity extends AppCompatActivity implements LoginRepository.FirebaseLoginListener {

    private EditText email, password, passwordchk;
    private Button complete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.signup_email_text);
        password = findViewById(R.id.signup_password_text);
        passwordchk = findViewById(R.id.signup_passwordchk_text);
        //TODO : 비밀번호 확인 (미완) 

        complete = findViewById(R.id.signup_complete_btn);

        final LoginRepository loginRepository = new LoginRepository(this, this);

        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailstr = email.getText().toString();
                String passwordstr = password.getText().toString();

                if(emailstr.equals("") || passwordstr.equals("")){
                    Toast.makeText(SignUpActivity.this, "입력하세요.", Toast.LENGTH_SHORT).show();
                }else {
                    loginRepository.firebaseSignup(emailstr, passwordstr);
                }
            }
        });
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