package com.father_in_law.artisan_s_workplace.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.father_in_law.artisan_s_workplace.Activity.Data.TalentShare;
import com.father_in_law.artisan_s_workplace.R;

import java.util.List;

public class Talent_Share_Adapter extends RecyclerView.Adapter<Talent_Share_Adapter.TalentShareViewHolder> {
    private List<TalentShare> datas;
    private OnItemClickListener mlistener = null;

    public interface OnItemClickListener {
        void onItemClick(View view, int i);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mlistener = listener;
    }

    public Talent_Share_Adapter(List<TalentShare> datas2) {
        this.datas = datas2;
    }

    @Override
    public TalentShareViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TalentShareViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_talentshare, parent, false));
    }

    public void onBindViewHolder(TalentShareViewHolder holder, int position) {
        TalentShare data = this.datas.get(position);
        holder.orgNm.setText("기관: " + data.getOrgNm());
        holder.notiDate.setText("공고기간 :" + data.getHpNotiSdate() + " ~ " + data.getHpNotiEdate());
        holder.proNm.setText("사업명: " + data.getProjName());
        holder.proDate.setText("사업기간: " + data.getProjSdate() + " ~ " + data.getProjEdate());
    }

    @Override
    public int getItemCount() {
        return this.datas.size();
    }

    public class TalentShareViewHolder extends RecyclerView.ViewHolder {
        private TextView notiDate;
        private TextView orgNm;
        private TextView proDate;
        private TextView proNm;

        public TalentShareViewHolder(View itemView) {
            super(itemView);
            this.orgNm = (TextView) itemView.findViewById(R.id.listitem_orgNm_talentshare);
            this.notiDate = (TextView) itemView.findViewById(R.id.listitem_notiDate_telentshare);
            this.proNm = (TextView) itemView.findViewById(R.id.listitem_proNm_talentshare);
            this.proDate = (TextView) itemView.findViewById(R.id.listitem_proDate_talentshare);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = TalentShareViewHolder.this.getAdapterPosition();
                    if (pos != -1 && Talent_Share_Adapter.this.mlistener != null) {
                        Talent_Share_Adapter.this.mlistener.onItemClick(view, pos);
                    }
                }
            });
        }
    }
}