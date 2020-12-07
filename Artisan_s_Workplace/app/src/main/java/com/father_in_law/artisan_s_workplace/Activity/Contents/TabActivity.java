package com.father_in_law.artisan_s_workplace.Activity.Contents;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TextView;

import com.father_in_law.artisan_s_workplace.Activity.Data.NoInJob;
import com.father_in_law.artisan_s_workplace.Activity.Data.TalentShare;
import com.father_in_law.artisan_s_workplace.R;


public class TabActivity extends AppCompatActivity {

    private String apiKey;
    private NoInJob getNoInJob;
    private TextView hpCont;
    private TextView n_Notidate;
    private TextView n_hpNotiEdate;
    private TextView n_intCnt;
    private TextView n_jobType;
    private TextView n_orgName;
    private TextView n_projNo;
    private String projNo = "";
    private TextView n_projYear;
    private TextView n_trnStatNm;
    private TextView n_workPlace;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // ... 코드 계속
/*
        super.onCreate(savedInstanceState);
        TabHost tabHost1 = (TabHost) findViewById(R.id.tabHost1);
        tabHost1.setup();

        apiKey = getString(R.string.noin_job_key);
        n_hpNotiEdate = findViewById(R.id.hpNotiEdate_noinjobdetail);
        n_intCnt = findViewById(R.id.intCnt_noinjobdetail);
        n_jobType =findViewById(R.id.jobType_noinjobdetail);
        n_orgName = findViewById(R.id.orgName_noinjobdetail);
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
            n_orgName.setText(getNoInJob.getOrgNamee());
            n_hpNotiEdate.setText(" ~ " + getNoInJob.getHpNotiEdate() + "까지");
            n_projYear.setText(getNoInJob.getProjYear());
            n_trnStatNm.setText(getNoInJob.getTrnStatNm());
            n_workPlace.setText(getNoInJob.getWorkPlace());
            n_Notidate.setText(getNoInJob.getHpNotiSdate() + " ~ " + getNoInJob.getHpNotiEdate());
            String projNo2 = getNoInJob.getProjNo();
            this.n_projNo = projNo2;
        }

        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"content1")
        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1");
        ts1.setContent(R.id.tab1);
        ts1.setIndicator("TAB 1");
        tabHost1.addTab(ts1);

        // 두 번째 Tab. (탭 표시 텍스트:"TAB 2"), (페이지 뷰:"content2")
        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2");
        ts2.setContent(R.id.tab2);
        ts2.setIndicator("TAB 2");
        tabHost1.addTab(ts2);

        // 세 번째 Tab. (탭 표시 텍스트:"TAB 3"), (페이지 뷰:"content3")
        TabHost.TabSpec ts3 = tabHost1.newTabSpec("Tab Spec 3");
        ts3.setContent(R.id.tab3);
        ts3.setIndicator("TAB 3");
        tabHost1.addTab(ts3);
*/
    }
}