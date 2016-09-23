package com.hardikgoswami.bettersleep.SleepPunch;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hardikgoswami.bettersleep.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SleepPunchFragment extends Fragment {


    public SleepPunchFragment() {
        // Required empty public constructor
    }

    private String title;
    private int page;
    public static SleepPunchFragment newInstance (int page , String title) {
        SleepPunchFragment sleepPunchFragment = new SleepPunchFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        sleepPunchFragment.setArguments(args);
        return sleepPunchFragment;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =inflater.inflate(R.layout.sleeppunch_frag, container, false);
        TextView tvLabel = (TextView) rootView.findViewById(R.id.tvSampleText);
        tvLabel.setText(page + " -- " + title);

        return rootView;
    }

}
