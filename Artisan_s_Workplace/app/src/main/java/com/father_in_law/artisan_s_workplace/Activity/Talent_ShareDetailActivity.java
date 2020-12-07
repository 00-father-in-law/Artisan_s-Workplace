package com.father_in_law.artisan_s_workplace.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.father_in_law.artisan_s_workplace.Activity.Data.TalentShare;
import com.father_in_law.artisan_s_workplace.Activity.Data.TextviewData;
import com.father_in_law.artisan_s_workplace.Adapter.Talent_Share_Adapter;
import com.father_in_law.artisan_s_workplace.Adapter.TextviewListAdapter;
import com.father_in_law.artisan_s_workplace.R;

import java.util.ArrayList;
import java.util.List;

public class Talent_ShareDetailActivity extends AppCompatActivity {
    private String apiKey;
    private TalentShare getTalentShare;
    private TextView hpCont;
    private TextView notiEdate;
    private TextView orgNm_main;
    private TextView projName;
    private String projNo = "";
    private ArrayList<TextviewData> tDatas = new ArrayList();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talent__share_detail);

        //툴바
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbarMethod(toolbar);

        apiKey = getString(R.string.talent_share_key);
        //운영기관 명
        orgNm_main = findViewById(R.id.orgNm_main_talentshareDetail);
        //사업 제목
        projName = findViewById(R.id.projName_talentshareDetail);
        //접수마감기간
        notiEdate =findViewById(R.id.notiEdate_talentshareDetail);
        //공고 내용
        hpCont = findViewById(R.id.hpCont_talentshareDetail);

        TalentShare talentShare = getIntent().getParcelableExtra("talentshare");
        getTalentShare = talentShare;

        if (talentShare != null) {
            orgNm_main.setText(talentShare.getOrgNm());
            projName.setText(getTalentShare.getProjName());
            notiEdate.setText(" ~ " + dateParser(getTalentShare.getHpNotiEdate()) + "까지");
            String projNo2 = getTalentShare.getProjNo();
            this.projNo = projNo2;

            //텍스트 리사이클러뷰 데이터 넣기
            addData("수행 기관명", talentShare.getOrgNm());
            addData("사업 시작일", dateParser(talentShare.getProjSdate()));
            addData("사업 종료일", dateParser(talentShare.getProjEdate()));
            addData("모집 기간",dateParser(talentShare.getHpNotiSdate()) + "\n~  "
                    + dateParser(getTalentShare.getHpNotiEdate()));
        }

        //텍스트 리사이클러뷰 연결
        RecyclerView recyclerView = findViewById(R.id.textview_recyclerview);
        TextviewListAdapter textviewListAdapter = new TextviewListAdapter(tDatas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)) ;
        recyclerView.setAdapter(textviewListAdapter);
    }

    //날짜 년월일 넣기
    public String dateParser(String s){
        String str = "";
        str += s.substring(0,4) + "년 ";

        if(s.charAt(4) == '0') str+= s.charAt(5);
        else str+=s.substring(4,6);
        str+="월 ";

        if(s.charAt(6) == '0') str+= s.charAt(7);
        else str+=s.substring(6,8);
        str+="일";

        return str;
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

    //텍스트 리사이클러뷰에 데이터 넣기
    public void addData(String title, String contents){
        TextviewData item = new TextviewData(title, contents);
        tDatas.add(item);
    }


}