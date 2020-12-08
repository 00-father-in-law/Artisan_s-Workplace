package com.father_in_law.artisan_s_workplace.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.father_in_law.artisan_s_workplace.Activity.Data.TalentShare;
import com.father_in_law.artisan_s_workplace.Adapter.Talent_Share_Adapter;
import com.father_in_law.artisan_s_workplace.R;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class Talent_ShareActivity extends AppCompatActivity {
    private String apiKey;
    private int pageNo = 1;
    private RecyclerView recyclerView;
    private List<TalentShare> tDatas = new ArrayList();
    private int totalCount;
    private Talent_Share_Adapter tsAdapter;
    private Button btn1;

    private ImageButton talent_share_back_btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talent__share);
        apiKey = getString(R.string.talent_share_key);
        recyclerView =findViewById(R.id.talent_share_recyclerview);
        talent_share_back_btn = findViewById(R.id.talent_share_back_btn);
        btn1 = findViewById(R.id.talent_share_contRegn1);

        btn1.setText("서울시 강남구");

        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), 1));

        Talent_Share_Adapter talent_Share_Adapter = new Talent_Share_Adapter(tDatas);
        tsAdapter = talent_Share_Adapter;

        recyclerView.setAdapter(talent_Share_Adapter);

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
                        Toast.makeText(Talent_ShareActivity.this, "더 불러오는중", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(Talent_ShareActivity.this, "끝", Toast.LENGTH_SHORT).show();
                }
            }
        });

        this.tsAdapter.setOnItemClickListener(new Talent_Share_Adapter.OnItemClickListener() {

            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(Talent_ShareActivity.this, Talent_ShareDetailActivity.class);
                intent.putExtra("talentshare", tDatas.get(position));
                startActivity(intent);
            }
        });

        talent_share_back_btn.setOnClickListener(new View.OnClickListener() {
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

                String adress = "http://apis.data.go.kr/B552474/JeOdJobOffPbServ/jegetOdJobOffPbList"
                        +"?serviceKey="+apiKey
                        +"&numOfRows=10"
                        +"&pageNo="+pageNo+"&contRegnStr1=서울특별시"+"&contRegnStr2=강남구";

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
                    TalentShare talentShare = null;

                    while(eventType!=XmlPullParser.END_DOCUMENT){

                        switch (eventType){
                            case XmlPullParser.START_DOCUMENT:
                                break;
                            case XmlPullParser.START_TAG:
                                tagName=xpp.getName();
                                if (tagName.equals("item")) {
                                    talentShare = new TalentShare();
                                } else if (tagName.equals("hpNotiEdate")) {
                                    talentShare.setHpNotiEdate(xpp.nextText());
                                } else if (tagName.equals("hpNotiSdate")) {
                                    talentShare.setHpNotiSdate(xpp.nextText());
                                } else if (tagName.equals("orgCd")) {
                                    talentShare.setOrgCd(xpp.nextText());
                                } else if (tagName.equals("orgNm")) {
                                    talentShare.setOrgNm(xpp.nextText());
                                } else if (tagName.equals("projEdate")) {
                                    talentShare.setProjEdate(xpp.nextText());
                                } else if (tagName.equals("projName")) {
                                    talentShare.setProjName(xpp.nextText());
                                } else if (tagName.equals("projNo")) {
                                    talentShare.setProjNo(xpp.nextText());
                                } else if (tagName.equals("projSdate")) {
                                    talentShare.setProjSdate(xpp.nextText());
                                } else if (tagName.equals("totalCount") && pageNo == 1) {
                                    totalCount = Integer.parseInt(xpp.nextText()) - 10;
                                }

                                break;

                            case XmlPullParser.TEXT:
                                break;

                            case XmlPullParser.END_TAG:
                                tagName = xpp.getName();
                                if (tagName.equals("item")) {
                                    tDatas.add(talentShare);
                                } else if (tagName.equals("items")) {
                                    runOnUiThread(new Runnable() {
                                        public void run() {
                                            tsAdapter.notifyDataSetChanged();
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
}