package com.father_in_law.artisan_s_workplace.Activity.Contents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.father_in_law.artisan_s_workplace.Activity.Data.NoInJob;
import com.father_in_law.artisan_s_workplace.R;

public class NoIn_jobDetailActivity extends AppCompatActivity {

    private String apiKey;
    private NoInJob getNoInJob;
    private TextView hpCont;
    private TextView n_Notidate;
    private TextView n_hpNotiEdate;
    private TextView n_hpNotiSdate;
    private TextView n_intCnt;
    private TextView n_jobType;
    private TextView n_orgName_main;
    private TextView n_orgName_content;
    //private TextView n_projNo;
    private String n_projNo = "";
    private TextView n_projYear;
    private TextView n_trnStatNm;
    private TextView n_workPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_in_job_detail);

        apiKey = getString(R.string.noin_job_key);
        n_hpNotiEdate = findViewById(R.id.hpNotiEdate_noinjobdetail);
        n_Notidate =  findViewById(R.id.Notidate_noinjobdetail);
        n_intCnt = findViewById(R.id.intCnt_noinjobdetail);
        n_jobType =findViewById(R.id.jobType_noinjobdetail);
        n_orgName_main = findViewById(R.id.orgName_main_noinjobdetail);
        n_orgName_content = findViewById(R.id.orgName_content_noinjobdetail);
        //n_projNo =  findViewById(R.id.projSdate_talentshareDetail);
        n_projYear =  findViewById(R.id.projYear_noinjobdetail);
        n_trnStatNm =  findViewById(R.id.trnStatNm_noinjobdetail);
        n_workPlace =  findViewById(R.id.workPlace_noinjobdetail);
        hpCont = findViewById(R.id.hpCont_noinjobdetail);

        NoInJob noinjob = getIntent().getParcelableExtra("noinjob");
        getNoInJob = noinjob;

        if (noinjob != null) {
            n_intCnt.setText(noinjob.getIntCnt());
            n_jobType.setText(noinjob.getJobType());
            n_orgName_main.setText(noinjob.getOrgName());
            n_orgName_content.setText(getNoInJob.getOrgName());
            n_hpNotiEdate.setText(" ~ " + getNoInJob.getHpNotiEdate() + "까지");
            n_projYear.setText(getNoInJob.getProjYear());
            n_trnStatNm.setText(getNoInJob.getTrnStatNm());
            n_workPlace.setText(getNoInJob.getWorkPlace());
            n_Notidate.setText(getNoInJob.getHpNotiSdate() + " ~ " + getNoInJob.getHpNotiEdate());
            String projNo2 = getNoInJob.getProjNo();
            this.n_projNo = projNo2;
        }
    }
}