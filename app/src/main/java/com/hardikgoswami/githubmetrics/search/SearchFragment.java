package com.hardikgoswami.githubmetrics.search;


import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.javierugarte.GitHubContributionsView;
import com.hardikgoswami.githubmetrics.R;
import com.hardikgoswami.githubmetrics.network.Contribution;
import com.hardikgoswami.githubmetrics.network.GithubDataLoader;
import com.hardikgoswami.githubmetrics.network.UserData;
import com.hardikgoswami.githubmetrics.persistence.HistoryContract;
import com.hardikgoswami.githubmetrics.util.ReposAdapter;
import com.hardikgoswami.githubmetrics.util.SimpleDividerItemDecoration;
import com.hardikgoswami.githubmetrics.util.StarsSorter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.hardikgoswami.githubmetrics.network.GithubDataLoader.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements LoaderManager.LoaderCallbacks<UserData> {


    public static final String USERNAME = "Username";

    public SearchFragment() {
        // Required empty public constructor
    }


    private List<Contribution> repoList;
    private GitHubContributionsView gitView;
    private EditText etGithubUsername;
    private Button btnSearch;
    private RatingBar ratingBar;
    private String searchedUser;
    private TextView tvEmail, tvLocation, tvBio, tvFollwers;
    private ImageView ivProfile;
    private RecyclerView repoListRv;
    private View linearCardView;
    private ReposAdapter adapter;
    private boolean isOnline;
    private LoaderManager.LoaderCallbacks<UserData> Loadercallbacks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        isOnline = true;
        linearCardView = rootView.findViewById(R.id.llCards);
        tvBio = (TextView) rootView.findViewById(R.id.tvBioCvUserDetail);
        tvEmail = (TextView) rootView.findViewById(R.id.tvEmailCvUserDetail);
        tvLocation = (TextView) rootView.findViewById(R.id.tvLocationCvUserDetail);
        tvFollwers = (TextView) rootView.findViewById(R.id.tvFollowersGitDetail);
        ivProfile = (ImageView) rootView.findViewById(R.id.ivAvatarCvUserDetail);
        repoListRv = (RecyclerView) rootView.findViewById(R.id.rvReposContribution);
        etGithubUsername = (EditText) rootView.findViewById(R.id.etGithubUser);
        gitView = (GitHubContributionsView) rootView.findViewById(R.id.github_contributions_view);
        btnSearch = (Button) rootView.findViewById(R.id.btnSearch);
        repoList = new ArrayList<Contribution>();
        repoListRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        repoListRv.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
        Loadercallbacks = SearchFragment.this;
        ratingBar = (RatingBar)rootView.findViewById(R.id.ratingBar);
        ConnectivityManager conMgr = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        if (netInfo == null){
            isOnline = false;
        }else {
            isOnline = true;
        }
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etGithubUsername.getText().toString() != null) {
                    searchedUser = etGithubUsername.getText().toString();
                }
                if (searchedUser != null && isOnline) {
                    Toast.makeText(getActivity(), "Please wait searching for : " + searchedUser, Toast.LENGTH_LONG).show();
                    gitView.loadUserName(searchedUser);
                    gitView.displayMonth(true);
                    gitView.setTextColor(R.color.colorAccent);
                    gitView.setBaseColor(Color.parseColor("#FF4081"));
                    // setvisible
                    linearCardView.setVisibility(View.VISIBLE);
                    Bundle bundle = new Bundle();
                    bundle.putString(USERNAME, searchedUser);
                    getLoaderManager().restartLoader(0, bundle, Loadercallbacks).forceLoad();

                }else {
                    if (isOnline){
                        Toast.makeText(getActivity(),"Username cannot be empty",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getActivity(),"Please check internet connection",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        return rootView;
    }

    @Override
    public android.support.v4.content.Loader<UserData> onCreateLoader(int id, Bundle args) {
        String username = args.getString(USERNAME, null);
        if (username != null) {
            //do nothing
            Log.d(TAG, "onCreateLoader: " + username);
        } else {
            Toast.makeText(getActivity(), "Empty username field", Toast.LENGTH_SHORT).show();
        }
        android.support.v4.content.Loader<UserData> loader = new GithubDataLoader(getActivity(), username);
        return loader;
    }

    @Override
    public void onLoadFinished(android.support.v4.content.Loader<UserData> loader, UserData data) {
        if (data.isValid()) {
            Log.d(TAG, "onLoadFinished: loader finished");
            Toast.makeText(getActivity(), "Data Loaded", Toast.LENGTH_SHORT);
            tvBio.setText(data.getBio());
            tvFollwers.setText("Number of Followers :- " + data.getFollowers());
            tvLocation.setText("Location :- " + data.getLocation());
            tvEmail.setText("Email :- " + data.getEmail());

            String imgUrl = data.getImageUrl() + "&s=150";
            Picasso.with(getActivity())
                    .load(imgUrl)
                    .into(ivProfile);
            // sort contribution list as of number of starts
            if (repoList.size()>0)repoList.clear();
            repoList = data.getRepoList();
            Collections.sort(repoList, new StarsSorter());
            Collections.reverse(repoList);
            adapter = new ReposAdapter(repoList,getActivity());
            repoListRv.setAdapter(adapter);
            ratingBar.setRating(data.getRating());
            ContentValues contentValues = new ContentValues();
            contentValues.put("email",data.getEmail());
            contentValues.put("username",searchedUser);
            contentValues.put("rating",data.getRating());
            getActivity().getContentResolver().insert(HistoryContract.CONTENT_URI,contentValues);
        } else {
            Log.d(TAG, "onLoadFinished: invalid username");
            linearCardView.setVisibility(View.INVISIBLE);
            Toast.makeText(getActivity(),"Invalid Username",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLoaderReset(android.support.v4.content.Loader<UserData> loader) {
        Log.d(TAG, "onLoaderReset: loader resent");
    }






}
