package com.father_in_law.artisan_s_workplace.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.father_in_law.artisan_s_workplace.R;
import com.father_in_law.artisan_s_workplace.Repository.FirebaseRepo.LoginRepository;

public class LoginActivity extends AppCompatActivity implements LoginRepository.FirebaseLoginListener {

    private EditText email, password;
    private Button signIn, signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.login_email_text);
        password = findViewById(R.id.login_password_text);

        signIn = findViewById(R.id.signin_btn);
        signUp = findViewById(R.id.signup_btn);

        //리스너 연결
        final LoginRepository loginRepository = new LoginRepository(this, this);

        // 로그인 버튼
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailstr = email.getText().toString();
                String passwordstr = password.getText().toString();

                if(emailstr.equals("") || passwordstr.equals("")){
                    Toast.makeText(LoginActivity.this, "입력하세요.", Toast.LENGTH_SHORT).show();
                }else {
                    loginRepository.firebaseLogin(emailstr, passwordstr);
                }
            }
        });

        // 회원가입 버튼
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSuccess() {
        Toast.makeText(LoginActivity.this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onError() {
        Toast.makeText(LoginActivity.this, "로그인 에러", Toast.LENGTH_SHORT).show();
    }
}