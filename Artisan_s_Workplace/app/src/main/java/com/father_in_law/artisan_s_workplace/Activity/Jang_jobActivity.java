package com.father_in_law.artisan_s_workplace.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.father_in_law.artisan_s_workplace.R;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class Jang_jobActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jang_job);

        tv= findViewById(R.id.tv);
    }

    public void clickBtn(View view) {
        //Resources폴더 안에 있는 xml문서를 읽어와서 분석(parse)하는 작업 수행

        //res폴더 관리자 객체 소환
        Resources res= getResources();

        //창고 관리자로 부터 파서객체(분석가) 얻어오기
        XmlResourceParser xrp= res.getXml(R.xml.noticelist);

        StringBuffer buffer= new StringBuffer();

        //xml파서에게 xml문서를 분석하도록 코딩
        //xmlParser는 1)START_DOCUMENT 2)START_TAG 3)TEXT 4)END_TAG 5)END_DOCUMENT 로 구분

        try {
            xrp.next();
            int eventType=xrp.getEventType();

            String tagName; //태그 이름
            String text;    //내용 글씨

            while (eventType!=XmlResourceParser.END_DOCUMENT){

                switch(eventType){
                    case XmlResourceParser.START_DOCUMENT:
                        buffer.append("xml 파싱 시작합니다..\n\n");
                        break;

                    case XmlResourceParser.START_TAG:
                        tagName= xrp.getName(); //태그문의 이름 얻어오기

                        if(tagName.equals("no")){
                            buffer.append("번호:");
                        }else if(tagName.equals("title")){
                            buffer.append("제목:");
                        }else if(tagName.equals("genre")){
                            buffer.append("장르:");
                        }
                        break;

                    case XmlResourceParser.TEXT:
                        text= xrp.getText();
                        buffer.append(text);
                        break;

                    case XmlResourceParser.END_TAG:
                        tagName= xrp.getName();
                        if(tagName.equals("no")){
                            buffer.append("\n");
                        }else if(tagName.equals("title")){
                            buffer.append("\n");
                        }else if(tagName.equals("genre")){
                            buffer.append("\n");
                        }else if(tagName.equals("item")){
                            buffer.append("\n");
                        }
                        break;

                    case XmlResourceParser.END_DOCUMENT:
                        break;
                }//switch
                eventType=xrp.next();   //next를 하면 evetType을 준다.
            }//while

            buffer.append("파싱 종료 ....");
            tv.setText(buffer.toString());

        } catch (IOException e) {e.printStackTrace();} catch (XmlPullParserException e) {e.printStackTrace();}
    }// clickBtn() ..
}
