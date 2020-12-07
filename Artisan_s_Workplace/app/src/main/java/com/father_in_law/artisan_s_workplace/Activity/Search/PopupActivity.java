package com.father_in_law.artisan_s_workplace.Activity.Search;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.father_in_law.artisan_s_workplace.Activity.MainActivity;
import com.father_in_law.artisan_s_workplace.R;

import java.lang.reflect.Array;

import io.grpc.internal.SharedResourceHolder;

public class PopupActivity extends Dialog{
    private Context mContext;
    private Spinner spinner1;
    private Spinner spinner2;
    public static int num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        Button btn = (Button)findViewById(R.id.save);
        spinner1 = (Spinner)findViewById(R.id.spinner2);
        spinner2 = (Spinner)findViewById(R.id.spinner3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = spinner1.getSelectedItem().toString();
                String gu = spinner2.getSelectedItem().toString();

                if(num ==1)
                    ((SearchActivity)SearchActivity.mCon).method1(city,gu,1);
                else if( num ==2)
                    ((SearchActivity)SearchActivity.mCon).method1(city,gu,2);

                dismiss();
            }
        });
    }
    public PopupActivity(Context mContext) {
        super(mContext);
        this.mContext = mContext;
    }
}