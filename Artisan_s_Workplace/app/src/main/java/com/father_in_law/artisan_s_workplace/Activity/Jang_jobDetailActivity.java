package com.father_in_law.artisan_s_workplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
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

    private ArrayList<TextviewData> tDatas = new ArrayList();
    private ArrayList<TextviewData> tDatas1 = new ArrayList();
    private ArrayList<TextviewData> tDatas2 = new ArrayList();
    private ArrayList<TextviewData> tDatas3 = new ArrayList();

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


        JobItem jobitem = (JobItem) getIntent().getParcelableExtra("jangjob");
        getJobItem = jobitem;

        if (jobitem != null) {
            name.setText(jobitem.getEstablishmentName()); //사업장명
            retype.setText(jobitem.getRecruitmentType()); //모집 직종
            wage.setText(jobitem.getWages()); //임금
            emtype.setText(jobitem.getEmploymentType());//고용형태
            wageform.setText(jobitem.getWageFrom()); //임금형태
            day.setText(jobitem.getRecruitmentPeriod()); //모집기간


            /*
            //텍스트 리사이클러뷰 데이터 넣기
            addData("모집 직종", jobitem.getRecruitmentType());
            addData("모집 기간",jobitem.getRecruitmentPeriod());
            addData("요구 학력", jobitem.getRequiredEducational());
            addData("전공 계열", jobitem.getMajor());
            addData("요구 자격증", jobitem.getRequiredCertificate());
            addData("요구 경력", jobitem.getRequiredCareer());


            addData1("임금",jobitem.getWages());
            addData1("임금 형태",jobitem.getWageFrom());
            addData1("입사 형태",jobitem.getEntranceType());
            addData1("직무",jobitem.getRecruitmentType());

            addData2("사업장 명",jobitem.getEstablishmentName());
            addData2("사업장 주소", jobitem.getEstablishmentAddress());

            addData3("사업장 명",jobitem.getEstablishmentName());
            addData3("기업 형태",jobitem.getCorporateForm());
            addData3("담당 기관",jobitem.getAgency());
            addData3("담당 기관 연락처",jobitem.getContactInformation());


             */
        }

        //텍스트 리사이클러뷰 연결
        /*RecyclerView recyclerView = findViewById(R.id.textview_recyclerview);
        RecyclerView recyclerView1 = findViewById(R.id.textview_recyclerview1);
        RecyclerView recyclerView2 = findViewById(R.id.textview_recyclerview2);
        RecyclerView recyclerView3 = findViewById(R.id.textview_recyclerview3);

        TextviewListAdapter textviewListAdapter = new TextviewListAdapter(tDatas);
        TextviewListAdapter textviewListAdapter1 = new TextviewListAdapter(tDatas1);
        TextviewListAdapter textviewListAdapter2 = new TextviewListAdapter(tDatas2);
        TextviewListAdapter textviewListAdapter3 = new TextviewListAdapter(tDatas3);

        recyclerView.setLayoutManager(new LinearLayoutManager(this)) ;
        recyclerView1.setLayoutManager(new LinearLayoutManager(this)) ;
        recyclerView2.setLayoutManager(new LinearLayoutManager(this)) ;
        recyclerView3.setLayoutManager(new LinearLayoutManager(this)) ;

        recyclerView.setAdapter(textviewListAdapter);
        recyclerView1.setAdapter(textviewListAdapter1);
        recyclerView2.setAdapter(textviewListAdapter2);
        recyclerView3.setAdapter(textviewListAdapter3);*/
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

    /*
    //텍스트 리사이클러뷰에 데이터 넣기1
    public void addData(String title, String contents){
        TextviewData item = new TextviewData(title, contents);
        tDatas.add(item);
    }

    //텍스트 리사이클러뷰에 데이터 넣기2
    public void addData1(String title, String contents){
        TextviewData item = new TextviewData(title, contents);
        tDatas1.add(item);
    }

    //텍스트 리사이클러뷰에 데이터 넣기3
    public void addData2(String title, String contents){
        TextviewData item = new TextviewData(title, contents);
        tDatas2.add(item);
    }

    //텍스트 리사이클러뷰에 데이터 넣기4
    public void addData3(String title, String contents){
        TextviewData item = new TextviewData(title, contents);
        tDatas3.add(item);
    }*/
}