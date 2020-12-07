package com.father_in_law.artisan_s_workplace.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.father_in_law.artisan_s_workplace.Activity.Data.TalentShare;
import com.father_in_law.artisan_s_workplace.Activity.Data.TextviewData;
import com.father_in_law.artisan_s_workplace.Fragment.Agency;
import com.father_in_law.artisan_s_workplace.Fragment.Recru;
import com.father_in_law.artisan_s_workplace.Fragment.Work;
import com.father_in_law.artisan_s_workplace.R;

import java.util.ArrayList;
import java.util.List;

public class TextviewListAdapter extends RecyclerView.Adapter<TextviewListAdapter.ViewHolder> {
    private ArrayList<TextviewData> list;
    private int pos;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title, tv_contents;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_contents = (TextView) itemView.findViewById(R.id.tv_contents);
        }
    }

    public TextviewListAdapter(ArrayList<TextviewData> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_textlist, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String title=list.get(position).getTitle();
        String contents=list.get(position).getContents();
        holder.tv_title.setText(title);
        holder.tv_contents.setText(contents);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
