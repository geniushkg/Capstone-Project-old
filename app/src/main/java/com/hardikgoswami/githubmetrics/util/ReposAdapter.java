package com.hardikgoswami.githubmetrics.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hardikgoswami.githubmetrics.R;
import com.hardikgoswami.githubmetrics.network.Contribution;

import java.util.ArrayList;
import java.util.List;

import static com.hardikgoswami.githubmetrics.network.GithubDataLoader.TAG;

/**
 * Created by geniushkg on 12/9/2016.
 */

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.RepoViewHolder> {

    private List<Contribution> contributionList;
    private Context mContext;

    public ReposAdapter(List<Contribution> contributionListFetched, Context mContext) {
        contributionList = new ArrayList<Contribution>();
        this.contributionList = contributionListFetched;
        this.mContext = mContext;
    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View contributionRow = inflater.inflate(R.layout.rv_contribution_row,parent,false);
        RepoViewHolder viewHolder = new RepoViewHolder(contributionRow);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
            Contribution contribution = contributionList.get(position);
            if (contribution.isFork()){
             holder.tvContributions.setText("Forked - "+contribution.getNameOfRepo()+"- Stars : "+contribution.getStars());
            }else {
                holder.tvContributions.setText(contribution.getNameOfRepo() + " - Stars:" + contribution.getStars());
            }
            if (contribution == null){
                Log.d(TAG, "onBindViewHolder: Contribution list null check data");
            }
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+contributionList.size());
        return contributionList.size();

    }

    public static class RepoViewHolder extends RecyclerView.ViewHolder {
        TextView tvContributions;
        public RepoViewHolder(View itemView) {
            super(itemView);
            tvContributions = (TextView)itemView.findViewById(R.id.tvContributionRow);
        }
    }
}
