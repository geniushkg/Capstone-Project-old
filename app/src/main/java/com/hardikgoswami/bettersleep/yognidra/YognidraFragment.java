package com.hardikgoswami.bettersleep.Yognidra;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hardikgoswami.bettersleep.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class YognidraFragment extends Fragment {


    public YognidraFragment() {
        // Required empty public constructor
    }

    public static YognidraFragment newInstance (){
        YognidraFragment yognidraFragment = new YognidraFragment();
        return yognidraFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =inflater.inflate(R.layout.yognidra_frag, container, false);
        return rootView;
    }

}
