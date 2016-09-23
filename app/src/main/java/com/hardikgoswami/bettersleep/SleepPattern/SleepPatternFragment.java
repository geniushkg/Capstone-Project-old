package com.hardikgoswami.bettersleep.SleepPattern;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hardikgoswami.bettersleep.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SleepPatternFragment extends Fragment {


    public SleepPatternFragment() {
        // Required empty public constructor
    }

    public static SleepPatternFragment newInstance(){
        SleepPatternFragment sleepPatternFragment = new SleepPatternFragment();
        return sleepPatternFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.sleeppatter_frag, container, false);
    }

}