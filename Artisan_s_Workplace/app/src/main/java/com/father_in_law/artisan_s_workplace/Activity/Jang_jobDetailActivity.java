package com.father_in_law.artisan_s_workplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.father_in_law.artisan_s_workplace.Activity.Data.TalentShare;
import com.father_in_law.artisan_s_workplace.Activity.Data.TextviewData;
import com.father_in_law.artisan_s_workplace.Adapter.TextviewListAdapter;
import com.father_in_law.artisan_s_workplace.R;
import com.father_in_law.artisan_s_workplace.data.JobItem;

import java.util.ArrayList;

public class Jang_jobDetailActivity extends AppCompatActivity {
    private JobItem getJobItem;

    private TextView name; //사업장
    private TextView retype; //모집 직종
    private TextView wage; //임금
    private TextView emtype; //고용형태
    private TextView wageform; //임금 형태
    private TextView day; //지원일

    private TextView Recru,Work,Loc,Agen;
    private TextView RecruCon,WorkCon,LocCon,AgenCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jang_job_detail);

        //툴바
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbarMethod(toolbar);

        //사업장 명
        name = findViewById(R.id.m_establishmentName);
        //모집 직종
        retype = findViewById(R.id.m_recruitmentType);
        //임금
        wage =findViewById(R.id.m_wages);
        //고용 형태
        emtype = findViewById(R.id.m_employmentType);
        //임금 형태
        wageform =findViewById(R.id.m_wageFrom);
        //모집 기간
        day = findViewById(R.id.m_recruitmentPeriod);
        //모집정보
        Recru = findViewById(R.id.tRecu);
        RecruCon = findViewById(R.id.tRecuContent);
        //근무정보
        Work = findViewById(R.id.twork);
        WorkCon = findViewById(R.id.tworkContent);
        //근무지역
        Loc = findViewById(R.id.tLoc);
        LocCon = findViewById(R.id.tLocContent);
        //기관정보
        Agen = findViewById(R.id.tAgen);
        AgenCon = findViewById(R.id.tAgenContent);

        JobItem jobitem = (JobItem) getIntent().getParcelableExtra("jangjob");
        getJobItem = jobitem;


        if (jobitem != null) {
            name.setText(jobitem.getEstablishmentName()); //사업장명
            retype.setText(jobitem.getRecruitmentType()); //모집 직종
            wage.setText(jobitem.getWages()); //임금
            emtype.setText(jobitem.getEmploymentType());//고용형태
            wageform.setText(jobitem.getWageFrom()); //임금형태
            day.setText(jobitem.getRecruitmentPeriod()); //모집기간

            //모집정보
            Recru.setText("모집 직종"+"\n"+"모집 기간"+"\n"+"요구 학력"+"\n"+"전공 계열"+"\n"+"요구 자격증"+"\n"+"요구 경력");
            RecruCon.setText(jobitem.getRecruitmentType()+"\n"+jobitem.getRecruitmentPeriod()+"\n"+jobitem.getRequiredEducational()+
                    "\n"+jobitem.getMajor()+"\n"+jobitem.getRequiredCertificate()+"\n"+jobitem.getRequiredCareer());

            //근무 정보
            Work.setText("임금"+"\n"+"임금 형태"+"\n"+"입사 형태"+"\n"+"직무");
            WorkCon.setText(jobitem.getWages()+"\n"+jobitem.getWageFrom()+"\n"+jobitem.getEntranceType()+"\n"+jobitem.getRecruitmentType());

            //근무 지역
            Loc.setText("사업장 명"+"\n"+"사업장 주소");
            LocCon.setText(jobitem.getEstablishmentName()+"\n"+jobitem.getEstablishmentAddress());

            //운영 기관 정보
            Agen.setText("사업장 명"+"\n"+"기업 형태"+"\n"+"담당 기관"+"\n"+"담당 기관 연락처");
            AgenCon.setText(jobitem.getEstablishmentName()+"\n"+jobitem.getCorporateForm()+"\n"+jobitem.getAgency()+
                    "\n"+jobitem.getContactInformation());

        }

    }


    //툴바 메서드
    public void toolbarMethod(Toolbar toolbar){
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() ==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}