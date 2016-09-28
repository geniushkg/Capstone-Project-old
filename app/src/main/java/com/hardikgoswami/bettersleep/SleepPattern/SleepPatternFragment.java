package com.hardikgoswami.bettersleep.SleepPattern;


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
public class SleepPatternFragment extends Fragment {


    public SleepPatternFragment() {
        // Required empty public constructor
    }

    private String title;
    private int page;

    public static SleepPatternFragment newInstance(int page , String title){
        SleepPatternFragment sleepPatternFragment = new SleepPatternFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        sleepPatternFragment.setArguments(args);
        return sleepPatternFragment;
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
        View rootView =inflater.inflate(R.layout.sleeppatter_frag, container, false);

        return rootView;
    }

}
