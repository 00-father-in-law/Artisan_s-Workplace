package com.father_in_law.artisan_s_workplace.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.father_in_law.artisan_s_workplace.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Talent_ShareActivity extends AppCompatActivity {
    String apiKey="hbTQ7F%2B3%2BWBpFBdl%2B0AQQ%2BTZs%2FdcIWpgAp6inN2%2BgR1ki44THNW8CLjRyD9l36Q3goAhGTgncXMwfou%2BGlFEXA%3D%3D";
    String loc = null;
    String loc1 = null;

    ListView listView;
    ArrayAdapter adapter;

    ArrayList<String> items=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talent__share);

        listView=findViewById(R.id.listview);
        adapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,items);
        //원래 layout을 .xml을 만들어야 하지만 예제이므로 안드로이에서 제공하는 것(android.R.layout.simple_list_item_1)을 사용
        listView.setAdapter(adapter);
    }

    public void clickBtn(View view) {
        //네트워크를 통해서 xml문서를 읽어오기..
        new Thread(){
            @Override
            public void run() {
                items.clear();

                if(loc1!=null){
                    loc1="jk";
                }

                String adress = "http://apis.data.go.kr/B552474/JeOdJobOffPbServ/jegetOdJobOffPbList"
                        +"?serviceKey="+apiKey
                        +"&numOfRows=100"
                        +"&pageNo=1"+"contRegnStr1"+loc+"contRegnStr2"+loc1;
                //주소 뒤에 [? key=Value & key = value id= aaa & pw= 1234] 이게 GET방식

                //adress="http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=430156241533f1d058c603178cc3ca0e&targetDt=20190919";
                //위 xml문서의 주소(address)에 스트림을 연결하여 데이터를 읽어오기


                try {
                    //URL객체생성
                    URL url= new URL(adress);

                    //Stream 열기                                     //is는 바이트 스트림이라 문자열로 받기위해 isr이 필요하고 isr을 pullparser에게 줘야하는데
                    InputStream is= url.openStream(); //바이트스트림
                    //문자스트림으로 변환
                    InputStreamReader isr=new InputStreamReader(is);

                    //읽어들인 XML문서를 분석(parse)해주는 객체 생성    //pullparser를 만들려면 Factory가 필요해서 팩토리 만들고 pullparser를 만들었다. 결론, 그리고 pullparser에게 isr연결
                    XmlPullParserFactory factory= XmlPullParserFactory.newInstance();
                    XmlPullParser xpp=factory.newPullParser();
                    xpp.setInput(isr);

                    //xpp를 이용해서 xml문서를 분석

                    //xpp.next();   //XmlPullParser는 시작부터 문서의 시작점에 있으므로 next해주면 START_DOCUMENT를 못만난다.
                    int eventType= xpp.getEventType();

                    String tagName;
                    StringBuffer buffer=null;

                    while(eventType!=XmlPullParser.END_DOCUMENT){

                        switch (eventType){
                            case XmlPullParser.START_DOCUMENT:

                                runOnUiThread(new Runnable() {  //여기는 별도 스레드이므로 화면 구성을 하려면 runOnUiThread 필요
                                    @Override
                                    public void run() {
                                        Toast.makeText(Talent_ShareActivity.this,"파싱을 시작했다.",Toast.LENGTH_SHORT).show();
                                    }
                                });

                                break;

                            case XmlPullParser.START_TAG:
                                tagName=xpp.getName();
                                if(tagName.equals("item")){
                                    buffer=new StringBuffer();
                                }else if(tagName.equals("hpInvtCnt")){
                                    buffer.append("홈페이지모집인원:");
                                    xpp.next();
                                    buffer.append(xpp.getText()+"\n");  //아래 두줄을 한줄로 줄일 수 있다.
//                                    String text = xpp.getText();
//                                    buffer.append(text+"\n");

                                }else if(tagName.equals("hpNotiEdate")){
                                    buffer.append("공고종료일:");
                                    xpp.next();
                                    buffer.append(xpp.getText()+"\n");

                                }else if(tagName.equals("orgNm")){
                                    buffer.append("수행기관명:");
                                    xpp.next();
                                    buffer.append(xpp.getText()+"\n");

                                }else if(tagName.equals("projName")){
                                    buffer.append("사업제목:");
                                    xpp.next();
                                    buffer.append(xpp.getText()+"\n");
                                }
                                break;

                            case XmlPullParser.TEXT:
                                break;

                            case XmlPullParser.END_TAG:
                                tagName = xpp.getName();
                                if(tagName.equals("item")){

                                    items.add(buffer.toString());

                                    //리스트뷰 갱신
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            adapter.notifyDataSetChanged();
                                        }
                                    });
                                }
                                break;
                        }

                        eventType=xpp.next();
                        //                        xpp.next();   //두줄을 한줄로 쓸 수 있다.
                        //                        eventType=xpp.getEventType();
                    }//while ..

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Talent_ShareActivity.this, "파싱종료!!",Toast.LENGTH_SHORT).show();
                        }
                    });


                } catch (MalformedURLException e) { e.printStackTrace();} catch (IOException e) {e.printStackTrace();} catch (XmlPullParserException e) {e.printStackTrace();}


            }// run() ..
        }.start();
    }
}
