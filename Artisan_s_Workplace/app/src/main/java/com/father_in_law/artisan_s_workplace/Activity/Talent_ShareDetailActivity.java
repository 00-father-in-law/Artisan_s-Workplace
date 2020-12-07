package com.father_in_law.artisan_s_workplace.Activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.father_in_law.artisan_s_workplace.Activity.Data.TalentShare;
import com.father_in_law.artisan_s_workplace.R;

public class Talent_ShareDetailActivity extends AppCompatActivity {
    private String apiKey;
    private TalentShare getTalentShare;
    private TextView hpCont;
    private TextView notiDate;
    private TextView notiEdate;
    private TextView orgNm_content;
    private TextView orgNm_main;
    private TextView projEdate;
    private TextView projName;
    private String projNo = "";
    private TextView projSdate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talent__share_detail);

        apiKey = getString(R.string.talent_share_key);
        orgNm_main = findViewById(R.id.orgNm_main_talentshareDetail);
        projName = findViewById(R.id.projName_talentshareDetail);
        notiEdate =findViewById(R.id.notiEdate_talentshareDetail);
        orgNm_content = findViewById(R.id.orgNm_talentshareDetail);
        projSdate =  findViewById(R.id.projSdate_talentshareDetail);
        projEdate =  findViewById(R.id.projEdate_talentshareDetail);
        notiDate =  findViewById(R.id.notiDate_talentshareDetail);
        hpCont = findViewById(R.id.hpCont_talentshareDetail);

        TalentShare talentShare = getIntent().getParcelableExtra("talentshare");
        getTalentShare = talentShare;

        if (talentShare != null) {
            orgNm_main.setText(talentShare.getOrgNm());
            projName.setText(getTalentShare.getProjName());
            notiEdate.setText(" ~ " + getTalentShare.getHpNotiEdate() + "까지");
            orgNm_content.setText(getTalentShare.getOrgNm());
            projSdate.setText(getTalentShare.getProjSdate());
            projEdate.setText(getTalentShare.getProjEdate());
            notiDate.setText(getTalentShare.getHpNotiSdate() + " ~ " + getTalentShare.getHpNotiEdate());
            String projNo2 = getTalentShare.getProjNo();
            this.projNo = projNo2;
        }
    }
}