package com.hardikgoswami.bettersleep.SleepPunch;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hardikgoswami.bettersleep.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SleepPunchFragment extends Fragment {


    public SleepPunchFragment() {
        // Required empty public constructor
    }
    public static SleepPunchFragment newInstance () {
        SleepPunchFragment sleepPunchFragment = new SleepPunchFragment();
        return sleepPunchFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =inflater.inflate(R.layout.sleeppunch_frag, container, false);

        return rootView;
    }

}
