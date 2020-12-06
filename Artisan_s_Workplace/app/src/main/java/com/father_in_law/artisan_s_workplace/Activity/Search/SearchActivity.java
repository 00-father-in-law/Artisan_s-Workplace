package com.father_in_law.artisan_s_workplace.Activity.Search;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.father_in_law.artisan_s_workplace.Activity.Jang_jobActivity;
import com.father_in_law.artisan_s_workplace.Activity.Talent_ShareActivity;
import com.father_in_law.artisan_s_workplace.R;

import javax.xml.datatype.Duration;

public class SearchActivity extends AppCompatActivity {

    private PopupActivity pop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Button list_btn = (Button) findViewById(R.id.search_btn);
        final Button Locbtn1 = (Button)findViewById(R.id.locbtn1);
        Button Locbtn2 = (Button)findViewById(R.id.locbtn2);

        Locbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strbtn;
                strbtn = Locbtn1.getText().toString();
                Toast.makeText(getApplicationContext(),strbtn, Toast.LENGTH_LONG).show();
            }
        });


        list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Intent intent1;

                int num = intent.getExtras().getInt("num"); /*int형*/
                switch (num){
                    case 1:
                        intent1 = new Intent(getApplicationContext(), Jang_jobActivity.class);
                        Toast.makeText(getApplicationContext(),"tessss", Toast.LENGTH_LONG).show();
                        startActivity(intent1);
                        break;
                    case 2:
                        break;
                    case 3:
                        intent1 = new Intent(getApplicationContext(), Talent_ShareActivity.class);
                        Toast.makeText(getApplicationContext(),"te", Toast.LENGTH_LONG).show();
                        startActivity(intent1);
                        break;
                    case 4:
                        break;
                }
            }
        });
    }
}
