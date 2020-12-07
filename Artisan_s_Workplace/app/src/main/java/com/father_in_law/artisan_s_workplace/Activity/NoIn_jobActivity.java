package com.father_in_law.artisan_s_workplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.father_in_law.artisan_s_workplace.Activity.Contents.TapActivity;
import com.father_in_law.artisan_s_workplace.Activity.Data.NoInJob;
import com.father_in_law.artisan_s_workplace.Activity.Data.TalentShare;
import com.father_in_law.artisan_s_workplace.Activity.Search.SearchActivity;
import com.father_in_law.artisan_s_workplace.Adapter.NoIn_job_Adapter;
import com.father_in_law.artisan_s_workplace.Adapter.Talent_Share_Adapter;
import com.father_in_law.artisan_s_workplace.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NoIn_jobActivity extends AppCompatActivity {
    private String apiKey;
    private int pageNo = 1;
    private RecyclerView recyclerView;
    private List<NoInJob> nDatas = new ArrayList();
    private int totalCount;
    private NoIn_job_Adapter njAdapter;

    private ImageButton noinjob_back_btn;
    private Button btn1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_in_job);
        apiKey = getString(R.string.noin_job_key);
        recyclerView =findViewById(R.id.noinjob_recyclerview);
        noinjob_back_btn = findViewById(R.id.noinjob_back_btn);

        btn1 = findViewById(R.id.talent_share_contRegn1);

        btn1.setText("서울시 강남구");

        NoIn_job_Adapter noin_job_Adapter = new NoIn_job_Adapter(nDatas);
        njAdapter = noin_job_Adapter;

        recyclerView.setAdapter(noin_job_Adapter);

        loadData();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (!recyclerView.canScrollVertically(1)) {
                    if (totalCount > 0) {
                        totalCount -= 10;
                        pageNo++;
                        loadData();
                        Toast.makeText(NoIn_jobActivity.this, "더 불러오는중", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(NoIn_jobActivity.this, "끝", Toast.LENGTH_SHORT).show();
                }
            }
        });

        this.njAdapter.setOnItemClickListener(new NoIn_job_Adapter.OnItemClickListener() {

            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(NoIn_jobActivity.this, TapActivity.class);
                intent.putExtra("noinjob", nDatas.get(position));
                startActivity(intent);
            }
        });

        noinjob_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    private void loadData() {
        new Thread() {

            public void run() {
                Log.d("asdf", "시작전");

                String adress = "http://apis.data.go.kr/B552474/JobBsnInfoService/getJobBsnRecruitList"
                        +"?serviceKey="+apiKey
                        +"&numOfRows=10"
                        +"&pageNo="+pageNo+"&dstrCd2=1168000000";

                try {
                    //URL객체생성
                    URL url= new URL(adress);


                    InputStream is= url.openStream(); //바이트스트림

                    InputStreamReader isr=new InputStreamReader(is);

                    XmlPullParserFactory factory= XmlPullParserFactory.newInstance();
                    XmlPullParser xpp=factory.newPullParser();
                    xpp.setInput(isr);

                    int eventType= xpp.getEventType();

                    String tagName;
                    NoInJob noInJob = null;

                    while(eventType!=XmlPullParser.END_DOCUMENT){

                        switch (eventType){
                            case XmlPullParser.START_DOCUMENT:
                                break;
                            case XmlPullParser.START_TAG:
                                tagName=xpp.getName();
                                if (tagName.equals("item")) {
                                    noInJob = new NoInJob();
                                } else if (!tagName.equals("hpInvtCnt")) {
                                    if (tagName.equals("hpNotiEdate")) {
                                        noInJob.setHpNotiEdate(xpp.nextText());
                                    } else if (tagName.equals("hpNotiSdate")) {
                                        noInJob.setHpNotiSdate(xpp.nextText());
                                    } else if (tagName.equals("intCnt")) {
                                        noInJob.setIntCnt(xpp.nextText());
                                    }else if (tagName.equals("jobType")) {
                                        noInJob.setJobType(xpp.nextText());
                                    }else if (tagName.equals("orgName")) {
                                        noInJob.setOrgName(xpp.nextText());
                                    } else if (tagName.equals("projNo")) {
                                        noInJob.setProjNo(xpp.nextText());
                                    } else if (tagName.equals("projYear")) {
                                        noInJob.setProjYear(xpp.nextText());
                                    } else if (tagName.equals("trnStatNm")) {
                                        noInJob.setTrnStatNm(xpp.nextText());
                                    } else if (tagName.equals("workPlace")) {
                                        noInJob.setWorkPlace(xpp.nextText());
                                    } else if (tagName.equals("totalCount") && pageNo == 1) {
                                        totalCount = Integer.parseInt(xpp.nextText()) - 10;
                                    }
                                }
                                break;

                            case XmlPullParser.TEXT:
                                break;

                            case XmlPullParser.END_TAG:
                                tagName = xpp.getName();
                                if (tagName.equals("item")) {
                                    nDatas.add(noInJob);
                                } else if (tagName.equals("items")) {
                                    runOnUiThread(new Runnable() {
                                        public void run() {
                                            njAdapter.notifyDataSetChanged();
                                        }
                                    });
                                }
                                break;
                        }
                        eventType=xpp.next();

                    }//while ..

                } catch (MalformedURLException e) {
                    Log.d("asdf", "1 MalformedURLException");
                    e.printStackTrace();
                } catch (IOException e2) {
                    Log.d("asdf", "2 IOException");
                    e2.printStackTrace();
                } catch (XmlPullParserException e3) {
                    Log.d("asdf", "3 XmlPullParserException");
                    e3.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}
