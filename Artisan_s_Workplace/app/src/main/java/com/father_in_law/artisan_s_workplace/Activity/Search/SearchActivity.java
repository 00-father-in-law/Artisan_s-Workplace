package com.father_in_law.artisan_s_workplace.Activity.Search;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.GetChars;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.father_in_law.artisan_s_workplace.Activity.Edu_ProActivity;
import com.father_in_law.artisan_s_workplace.Activity.Jang_jobActivity;
import com.father_in_law.artisan_s_workplace.Activity.LoginActivity;
import com.father_in_law.artisan_s_workplace.Activity.NoIn_jobActivity;
import com.father_in_law.artisan_s_workplace.Activity.Talent_ShareActivity;
import com.father_in_law.artisan_s_workplace.R;

import javax.xml.datatype.Duration;

public class SearchActivity extends AppCompatActivity {
    public static String text;
    public static Context mCon;
    public Button Locbtn1;
    public Button Locbtn2;
    public String mcity;
    public String mgu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //툴바
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbarMethod(toolbar);

        Button list_btn = (Button) findViewById(R.id.search_btn);
        list_btn = (Button) findViewById(R.id.search_btn);
        Locbtn1 = (Button) findViewById(R.id.locbtn1);
        Locbtn2 = (Button) findViewById(R.id.locbtn2);
        list_btn.setEnabled(false);
        mCon=this;

        //edittext 클릭시
        TextView et1 = (TextView) findViewById(R.id.inputKey1);
        TextView et2 = (TextView) findViewById(R.id.inputKey2);

        et1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SearchActivity.this, "개발 중입니다.", Toast.LENGTH_SHORT).show();
            }
        });

        et2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SearchActivity.this, "개발 중입니다.", Toast.LENGTH_SHORT).show();
            }
        });

        Locbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupActivity.num=1;
                PopupActivity dlg = new PopupActivity(SearchActivity.this);
                dlg.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dlg.show();
            }
        });

        Locbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupActivity.num=2;
                PopupActivity dlg = new PopupActivity(SearchActivity.this);
                dlg.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dlg.show();
            }
        });

        list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Intent intent1;

                int num = intent.getExtras().getInt("num"); /*int형*/
                switch (num) {
                    case 1:
                        intent1 = new Intent(getApplicationContext(), Jang_jobActivity.class);
                        intent.putExtra("city",mcity);
                        intent.putExtra("gu",mgu);
                        startActivity(intent1);
                        break;
                    case 2:
                        intent1 = new Intent(getApplicationContext(), NoIn_jobActivity.class);
                        intent.putExtra("city",mcity);
                        intent.putExtra("gu",mgu);
                        startActivity(intent1);
                        break;
                    case 3:
                        intent1 = new Intent(getApplicationContext(), Talent_ShareActivity.class);
                        intent.putExtra("city",mcity);
                        intent.putExtra("gu",mgu);
                        startActivity(intent1);
                        break;
                    case 4:
                        intent1 = new Intent(getApplicationContext(), Edu_ProActivity.class);
                        intent.putExtra("city",mcity);
                        intent.putExtra("gu",mgu);
                        startActivity(intent1);
                        break;
                }
            }
        });
    }

    public void method1(String city, String gu,int i){
        if(i==1){
            Locbtn1.setText(city+" "+gu);
            mcity=city;
            mgu=gu;
            Locbtn1.setTextColor(ResourcesCompat.getColor(getResources(),
                    R.color.darkskyblue, null));
            Locbtn1.setBackgroundResource(R.drawable.img_lightblue_btn);
        }
        if(i==2){
            Locbtn2.setText(city+" "+gu);
            mcity=city;
            mgu=gu;
            Locbtn2.setTextColor(ResourcesCompat.getColor(getResources(),
                    R.color.darkskyblue, null));
            Locbtn2.setBackgroundResource(R.drawable.img_lightblue_btn);
        }
    }


    public void toolbarMethod(Toolbar toolbar){
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
