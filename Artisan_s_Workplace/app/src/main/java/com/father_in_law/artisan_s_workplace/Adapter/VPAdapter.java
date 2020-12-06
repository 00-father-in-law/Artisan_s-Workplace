package com.father_in_law.artisan_s_workplace.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.father_in_law.artisan_s_workplace.Fragment.Agency;
import com.father_in_law.artisan_s_workplace.Fragment.Recru;
import com.father_in_law.artisan_s_workplace.Fragment.Work;

import java.util.ArrayList;

public class VPAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> items;
    public VPAdapter(FragmentManager fm) {
        super(fm);
        items = new ArrayList<Fragment>();
        items.add(new Recru());
        items.add(new Work());
        items.add(new Agency());
    }

    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }
}
