package com.father_in_law.artisan_s_workplace.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.father_in_law.artisan_s_workplace.R;
import com.father_in_law.artisan_s_workplace.Repository.FirebaseRepo.LoginRepository;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements LoginRepository.FirebaseLoginListener {

    private EditText email, password;
    private Button signIn;
    private TextView signUp, searchId, searchPassword;
    private TextInputLayout inputLayout;
    private ImageButton imageButton;
    private ImageView kakao, google, naver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.login_email_text);
        password = findViewById(R.id.login_password_text);

        searchId = findViewById(R.id.login_searchId);
        searchPassword = findViewById(R.id.login_searchPassword);
        signIn = findViewById(R.id.login_login_btn);
        signUp = findViewById(R.id.login_signup_btn);
        imageButton = findViewById(R.id.login_back_btn);

        kakao = findViewById(R.id.login_kakao_btn);
        google = findViewById(R.id.login_kakao_btn);
        naver = findViewById(R.id.login_naver_btn);

        inputLayout = findViewById(R.id.login_password_textlayout);

        inputLayout.setPasswordVisibilityToggleEnabled(true);
        inputLayout.setHintEnabled(false);


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

        searchId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "개발중입니다..", Toast.LENGTH_SHORT).show();
            }
        });

        searchPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "개발중입니다..", Toast.LENGTH_SHORT).show();
            }
        });

        // 회원가입 버튼
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Test계정을 사용해주세요..", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
//                startActivity(intent);
            }
        });

        kakao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "개발중입니다..", Toast.LENGTH_SHORT).show();
            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "개발중입니다..", Toast.LENGTH_SHORT).show();
            }
        });
        naver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "개발중입니다..", Toast.LENGTH_SHORT).show();
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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


    //TODO:kms 자동 로그인, 카카오 로그인, 네이버 로그인, 비밀번호 찾기, 아이디 찾기
}