package com.hardikgoswami.githubmetrics.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.hardikgoswami.githubmetrics.R;
import com.hardikgoswami.githubmetrics.persistence.UserHistory;

import java.util.List;

/**
 * Created by geniushkg on 12/10/2016.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryVh>  {

    private List<UserHistory> historyList;
    private Context mContext;

    public HistoryAdapter(List<UserHistory> historyList, Context mContext) {
        this.historyList = historyList;
        this.mContext = mContext;
    }

    @Override
    public HistoryVh onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View historyRow = inflater.inflate(R.layout.rv_history_row,parent,false);
        HistoryVh viewHolder = new HistoryVh(historyRow);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HistoryVh holder, int position) {
           UserHistory userHistoryEach = historyList.get(position);
            if (userHistoryEach.getRating()>0){
                holder.ratingBar.setRating(userHistoryEach.getRating());
            }else {
                holder.ratingBar.setRating(1f);
            }

            if (userHistoryEach.getEmail()!=null)holder.tvEmail.setText(userHistoryEach.getEmail());
            if (userHistoryEach.getUsername()!=null)holder.tvName.setText(userHistoryEach.getUsername());
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public static class HistoryVh extends RecyclerView.ViewHolder{

        TextView tvName,tvEmail;
        RatingBar ratingBar;
        public HistoryVh(View itemView) {
            super(itemView);
            tvEmail = (TextView)itemView.findViewById(R.id.tvEmailHistoryRow);
            tvName = (TextView)itemView.findViewById(R.id.tvNameHistoryRow);
            ratingBar = (RatingBar)itemView.findViewById(R.id.ratingBarHistoryRow);
        }
    }
}
