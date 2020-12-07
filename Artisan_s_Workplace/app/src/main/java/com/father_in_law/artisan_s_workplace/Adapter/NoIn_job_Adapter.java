package com.father_in_law.artisan_s_workplace.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.father_in_law.artisan_s_workplace.Activity.Data.NoInJob;
import com.father_in_law.artisan_s_workplace.Activity.Data.TalentShare;
import com.father_in_law.artisan_s_workplace.R;

import java.util.List;

public class NoIn_job_Adapter extends RecyclerView.Adapter<NoIn_job_Adapter.NoInJobViewHolder>{
    private List<NoInJob> datas;
    private NoIn_job_Adapter.OnItemClickListener mlistener = null;

    public interface OnItemClickListener {
        void onItemClick(View view, int i);
    }

    public void setOnItemClickListener(NoIn_job_Adapter.OnItemClickListener listener) {
        this.mlistener = listener;
    }

    public NoIn_job_Adapter(List<NoInJob> datas2) {
        this.datas = datas2;
    }

    @Override
    public NoIn_job_Adapter.NoInJobViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NoIn_job_Adapter.NoInJobViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_noinjob, parent, false));
    }

    public void onBindViewHolder(NoIn_job_Adapter.NoInJobViewHolder holder, int position) {
        NoInJob data = this.datas.get(position);
        holder.orgNm.setText("기관: " + data.getOrgNamee());
        holder.notiDate.setText("공고기간 :" + data.getHpNotiSdate() + " ~ " + data.getHpNotiEdate());
        holder.workplace.setText("사업자: " + data.getWorkPlace());
        holder.intCnt.setText("임금: " + data.getIntCnt());
    }

    @Override
    public int getItemCount() {
        return this.datas.size();
    }

    public class NoInJobViewHolder extends RecyclerView.ViewHolder {
        private TextView notiDate;
        private TextView orgNm;
        private TextView workplace;
        private TextView intCnt;

        public NoInJobViewHolder(View itemView) {
            super(itemView);
            this.orgNm = (TextView) itemView.findViewById(R.id.listitem_orgNm_noinjob);
            this.notiDate = (TextView) itemView.findViewById(R.id.listitem_notiDate_noinjob);
            this.workplace = (TextView) itemView.findViewById(R.id.listitem_workplace_noinjob);
            this.intCnt = (TextView) itemView.findViewById(R.id.listitem_incnt_noinjob);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = NoIn_job_Adapter.NoInJobViewHolder.this.getAdapterPosition();
                    if (pos != -1 && NoIn_job_Adapter.this.mlistener != null) {
                        NoIn_job_Adapter.this.mlistener.onItemClick(view, pos);
                    }
                }
            });
        }
    }
}
