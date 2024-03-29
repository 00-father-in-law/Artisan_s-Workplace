package com.father_in_law.artisan_s_workplace.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.father_in_law.artisan_s_workplace.Activity.Edu_ProActivity;
import com.father_in_law.artisan_s_workplace.Activity.Jang_jobActivity;
import com.father_in_law.artisan_s_workplace.Activity.NoIn_jobActivity;
import com.father_in_law.artisan_s_workplace.Activity.Search.PopupActivity;
import com.father_in_law.artisan_s_workplace.Activity.Search.SearchActivity;
import com.father_in_law.artisan_s_workplace.Activity.Talent_ShareActivity;
import com.father_in_law.artisan_s_workplace.R;
import com.father_in_law.artisan_s_workplace.Util.Firebase.FirebaseUtil;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth = FirebaseUtil.getAuth();
    private TextView Login_btn, Logout_btn;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login_btn = (TextView) findViewById(R.id.login_btn); //로그인 페이지 이동
        Logout_btn = (TextView) findViewById(R.id.logout_btn); //로그아웃 버튼
        LinearLayout Jangjob_btn = (LinearLayout) findViewById(R.id.Jang_Job_btn); //장애인 채용 페이지 이동
        LinearLayout Noinjob_btn = (LinearLayout) findViewById(R.id.NoIn_Job_btn); //노인 채용 페이지 이동
        LinearLayout TalentShare_btn = (LinearLayout) findViewById(R.id.Talent_Share_btn); //재능 나눔 페이지 이동
        LinearLayout EduPro_btn = (LinearLayout) findViewById(R.id.Edu_Pro_btn); //교육프로그램 페이지 이동
        imageButton = findViewById(R.id.login_back_btn);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

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
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                intent.putExtra("num",1);
                startActivity(intent);
            }
        });

        Noinjob_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                intent.putExtra("num",2);
                startActivity(intent);
            }
        });

        TalentShare_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                intent.putExtra("num",3);
                startActivity(intent);
            }
        });

        EduPro_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                intent.putExtra("num",4);
                startActivity(intent);*/
                Toast.makeText(getApplicationContext(),"개발 중입니다.",Toast.LENGTH_SHORT).show();
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
