package com.father_in_law.artisan_s_workplace.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.father_in_law.artisan_s_workplace.Activity.Data.TalentShare;
import com.father_in_law.artisan_s_workplace.R;
import com.father_in_law.artisan_s_workplace.data.JobItem;

import java.util.ArrayList;

public class JobAdapter extends BaseAdapter {

    ArrayList<JobItem> jobItemArrayList;

    public JobAdapter(ArrayList<JobItem> jobItems) {
        this.jobItemArrayList = jobItems;
    }

    @Override
    public int getCount() {
        if (jobItemArrayList != null)
            return jobItemArrayList.size();
        else
            return 0;
    }

    @Override
    public Object getItem(int position) {
        if (jobItemArrayList != null) {
            return jobItemArrayList.get(position);
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView , ViewGroup container) {
        if (convertView == null) {

            convertView = LayoutInflater.from(container.getContext())
                    .inflate(R.layout.list_jobitem, container, false);
        }

        if (getItem(position) instanceof JobItem) {
            JobItem item = (JobItem) getItem(position);

            //사업장 명
            ((TextView) convertView.findViewById(R.id.establishment_tv))
                    .setText(item.getEstablishmentName());

            //모집 기간
            ((TextView) convertView.findViewById(R.id.recruitmentperiod_tv))
                    .setText(item.getRecruitmentPeriod());

            //사업장 주소
            ((TextView) convertView.findViewById(R.id.address_tv))
                    .setText(item.getEstablishmentAddress());

            //임금
            ((TextView) convertView.findViewById(R.id.wages))
                    .setText(item.getWages().replaceAll("\"", "") + "원");
        }
        return convertView;
    }

}
