package com.father_in_law.artisan_s_workplace.Activity.Contents;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.father_in_law.artisan_s_workplace.R;

public class Fragment_Work extends Fragment {

    public Fragment_Work() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recru, container, false);
    }

}