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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sleep_punch, container, false);
    }

}
