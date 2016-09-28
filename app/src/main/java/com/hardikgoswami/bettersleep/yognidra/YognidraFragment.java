package com.hardikgoswami.bettersleep.Yognidra;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.hardikgoswami.bettersleep.BuildConfig;
import com.hardikgoswami.bettersleep.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class YognidraFragment extends Fragment {


    public YognidraFragment() {
        // Required empty public constructor
    }

    private String title;
    private String hintsHtml;
    private int page;
    private static final String API_KEY = BuildConfig.YOUTUBE_API;
    private static final String VIDEO_ID = "Mkx88_3cD-s";
    TextView sleep_hints;

    public static YognidraFragment newInstance(int page, String title) {
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
        hintsHtml = "<p>How to Enhance Sleep quality :<br /> \n" +
                "1) Stick to a schedule - try to go to bed every day same time.<br />\n" +
                "2) Avoid Caffeine, Alcohol, Nicotine, and Other Chemicals that Interfere with Sleep<br />\n" +
                "3) Create Bedtime ritual like , listen to yoga Nidra every day or light reading of a book or some literature.<br />\n" +
                "4) Don&rsquo;t Be a Nighttime Clock-Watcher <br />\n" +
                "This will increase anxiety and stress<br />\n" +
                "5) Be comfortable in environment you can make it dark , quite ,etc <br />\n" +
                "6) Light food and long walk helps everyday</p>";
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.yognidra_frag, container, false);

        // setup sleep hints
        sleep_hints = (TextView) rootView.findViewById(R.id.sleep_hints);
        sleep_hints.setText(Html.fromHtml(hintsHtml));
        // setup youtube
        YouTubePlayerSupportFragment youTubePlayerSupportFragment = YouTubePlayerSupportFragment.newInstance();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_layout, youTubePlayerSupportFragment).commit();
        youTubePlayerSupportFragment.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean b) {
                if (!b) {
                    player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    player.loadVideo(VIDEO_ID);
                    player.play();
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult result) {
                String errorMessage = result.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("youtube error : ", errorMessage);
            }
        });
        return rootView;
    }
}
