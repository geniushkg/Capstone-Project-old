package com.hardikgoswami.bettersleep.Yognidra;


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
public class YognidraFragment extends Fragment {


    public YognidraFragment() {
        // Required empty public constructor
    }

    private String title;
    private int page;

    public static YognidraFragment newInstance (int page , String title){
        YognidraFragment yognidraFragment = new YognidraFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        yognidraFragment.setArguments(args);
        return yognidraFragment;
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
        View rootView =inflater.inflate(R.layout.yognidra_frag, container, false);
        TextView tvLabel = (TextView) rootView.findViewById(R.id.tvSampleText);
        tvLabel.setText(page + " -- " + title);
        return rootView;
    }

}
