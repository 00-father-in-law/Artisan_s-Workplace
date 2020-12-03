package com.father_in_law.artisan_s_workplace.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.father_in_law.artisan_s_workplace.Activity.Edu_ProActivity;
import com.father_in_law.artisan_s_workplace.Activity.Jang_jobActivity;
import com.father_in_law.artisan_s_workplace.Activity.NoIn_jobActivity;
import com.father_in_law.artisan_s_workplace.Activity.Talent_ShareActivity;
import com.father_in_law.artisan_s_workplace.R;
import com.father_in_law.artisan_s_workplace.Util.Firebase.FirebaseUtil;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth = FirebaseUtil.getAuth();
    private Button Login_btn, Logout_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login_btn = (Button) findViewById(R.id.login_btn); //로그인 페이지 이동
        Logout_btn = (Button) findViewById(R.id.logout_btn); //로그아웃 버튼
        Button Jangjob_btn = (Button) findViewById(R.id.Jang_Job_btn); //장애인 채용 페이지 이동
        Button Noinjob_btn = (Button) findViewById(R.id.NoIn_Job_btn); //노인 채용 페이지 이동
        Button TalentShare_btn = (Button) findViewById(R.id.Talent_Share_btn); //재능 나눔 페이지 이동
        Button EduPro_btn = (Button) findViewById(R.id.Edu_Pro_btn); //교육프로그램 페이지 이동

        Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        Logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        Jangjob_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Jang_jobActivity.class);
                startActivity(intent);
            }
        });

        Noinjob_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NoIn_jobActivity.class);
                startActivity(intent);
            }
        });

        TalentShare_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Talent_ShareActivity.class);
                startActivity(intent);
            }
        });

        EduPro_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Edu_ProActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        //인증이 없으면 로그인버튼이 보이고 로그아웃 안보임
        if(mAuth.getCurrentUser() == null){
            Login_btn.setVisibility(View.VISIBLE);
            Logout_btn.setVisibility(View.GONE);
        }else{
            //인증이 있으면 로그인버튼이 보이고 로그아웃 안보임
            Login_btn.setVisibility(View.GONE);
            Logout_btn.setVisibility(View.VISIBLE);
        }
    }
}
