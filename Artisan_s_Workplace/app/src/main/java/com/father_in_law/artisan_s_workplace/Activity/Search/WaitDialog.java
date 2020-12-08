package com.father_in_law.artisan_s_workplace.Activity.Search;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.father_in_law.artisan_s_workplace.R;

public class WaitDialog extends Dialog {
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_wait_dialog);
        setCancelable(false);
    }
    public WaitDialog(Context mContext) {
        super(mContext);
        this.mContext = mContext;
    }

    public void die(){
        Toast.makeText(getContext(),"die",Toast.LENGTH_SHORT).show();
        dismiss();
    }
}