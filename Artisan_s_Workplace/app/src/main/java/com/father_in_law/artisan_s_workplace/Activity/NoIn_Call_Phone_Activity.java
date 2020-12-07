package com.father_in_law.artisan_s_workplace.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.father_in_law.artisan_s_workplace.R;

public class NoIn_Call_Phone_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_in_job_detail);

        Button b = findViewById(R.id.button_noin_call);
        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Context c = v.getContext();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:01012344321"));

                try {
                    c.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}