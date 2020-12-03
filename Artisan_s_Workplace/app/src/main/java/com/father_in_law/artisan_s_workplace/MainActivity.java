package com.father_in_law.artisan_s_workplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Login_btn = (Button) findViewById(R.id.login_btn); //로그인 페이지 이동
        Button Jangjob_btn = (Button) findViewById(R.id.Jang_Job_btn); //장애인 채용 페이지 이동
        Button Noinjob_btn = (Button) findViewById(R.id.NoIn_Job_btn); //노인 채용 페이지 이동
        Button TalentShare_btn = (Button) findViewById(R.id.Talent_Share_btn); //재능 나눔 페이지 이동
        Button EduPro_btn = (Button) findViewById(R.id.Edu_Pro_btn); //교육프로그램 페이지 이동

        //로그인 페이지 만들고 수정
        /*Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),);
                startActivity(intent);
            }
        });*/

        Jangjob_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Jang_jobActivity.class);
                startActivity(intent);
            }
        });

        Noinjob_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),NoIn_jobActivity.class);
                startActivity(intent);
            }
        });

        TalentShare_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Talent_ShareActivity.class);
                startActivity(intent);
            }
        });

        EduPro_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Edu_ProActivity.class);
                startActivity(intent);
            }
        });
    }
}
