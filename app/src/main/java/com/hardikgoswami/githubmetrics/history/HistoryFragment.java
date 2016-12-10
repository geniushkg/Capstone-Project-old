package com.hardikgoswami.githubmetrics.history;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hardikgoswami.githubmetrics.R;
import com.hardikgoswami.githubmetrics.persistence.HistoryLoader;
import com.hardikgoswami.githubmetrics.persistence.UserHistory;
import com.hardikgoswami.githubmetrics.util.HistoryAdapter;
import com.hardikgoswami.githubmetrics.util.SimpleDividerItemDecoration;

import java.util.List;

import static com.hardikgoswami.githubmetrics.network.GithubDataLoader.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<UserHistory>>{


    public HistoryFragment() {
        // Required empty public constructor
    }

    HistoryAdapter historyAdapter;
    LoaderManager.LoaderCallbacks<List<UserHistory>> callbacks;
    RecyclerView RVHistory;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_history, container, false);
        RVHistory = (RecyclerView)rootView.findViewById(R.id.rvHistory);
        callbacks = HistoryFragment.this;
        getActivity().getSupportLoaderManager().restartLoader(0,null,callbacks).forceLoad();
        return rootView;
    }


    @Override
    public Loader<List<UserHistory>> onCreateLoader(int id, Bundle args) {
        return new HistoryLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<List<UserHistory>> loader, List<UserHistory> data) {
        if (data.size()>0){
            historyAdapter = new HistoryAdapter(data,getActivity());
            RVHistory.setAdapter(historyAdapter);
            RVHistory.setLayoutManager(new LinearLayoutManager(getActivity()));
            RVHistory.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
            Log.d(TAG, "onLoadFinished: "+data.size());
        }else {
            Log.d(TAG, "onLoadFinished: empty");
        }
    }

    @Override
    public void onLoaderReset(Loader<List<UserHistory>> loader) {
        Log.d(TAG, "onLoaderReset: reset");
    }


}
