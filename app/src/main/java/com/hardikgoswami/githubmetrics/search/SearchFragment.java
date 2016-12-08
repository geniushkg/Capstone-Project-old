package com.hardikgoswami.githubmetrics.search;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.javierugarte.GitHubContributionsView;
import com.hardikgoswami.githubmetrics.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }


    GitHubContributionsView gitView;
    EditText etGithubUsername;
    Button btnSearch;
    RatingBar ratingBar;
    String searchedUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        etGithubUsername = (EditText) rootView.findViewById(R.id.etGithubUser);
        gitView = (GitHubContributionsView)rootView.findViewById(R.id.github_contributions_view);
        btnSearch = (Button) rootView.findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etGithubUsername.getText().toString() != null) {
                    searchedUser = etGithubUsername.getText().toString();
                }
                if (searchedUser != null) {
                    Toast.makeText(getActivity(), "Seached is " + searchedUser, Toast.LENGTH_SHORT).show();
                    gitView.loadUserName(searchedUser);
                    gitView.displayMonth(true);
                    gitView.setTextColor(R.color.colorPrimary);
                }
                Toast.makeText(getContext(), "Searched", Toast.LENGTH_SHORT);
            }
        });


        return rootView;
    }

}
