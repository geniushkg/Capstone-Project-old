package com.hardikgoswami.githubmetrics.feedback;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hardikgoswami.githubmetrics.BuildConfig;
import com.hardikgoswami.githubmetrics.R;

import io.doorbell.android.Doorbell;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedbackFragment extends Fragment {


    public FeedbackFragment() {
        // Required empty public constructor
    }

    public static final String DOORBELL_KEY = BuildConfig.DOORBELL_KEY;
    public static final int  DOORBELL_ID = BuildConfig.DOORBELL_ID;
    public static final String NAME = "Name";
    public static final String EMAIL = "Email";
    public static final String PREFERENCE = "github_prefs";
    String email;
    String name;
    SharedPreferences sharedPreferences;
    TextView label;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =inflater.inflate(R.layout.fragment_feedback, container, false);

        sharedPreferences = getActivity().getSharedPreferences(PREFERENCE,0);
        email = sharedPreferences.getString(EMAIL,null);
        name = sharedPreferences.getString(NAME,null);
        label = (TextView)rootView.findViewById(R.id.tvFeedback);
        label.setText(Html.fromHtml(getString(R.string.feedbackLabelText)));
        Button feedback = (Button)rootView.findViewById(R.id.btnSendFeedBack);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Doorbell doorbell = new Doorbell(getActivity(),DOORBELL_ID,DOORBELL_KEY);
                if (email!=null){
                    doorbell.setEmail(email);
                    doorbell.setEmailFieldVisibility(View.INVISIBLE);
                    doorbell.setPoweredByVisibility(View.INVISIBLE);
                }
                if (name!=null){
                    doorbell.setName(name);
                }

                doorbell.setOnFeedbackSentCallback(new io.doorbell.android.callbacks.OnFeedbackSentCallback() {
                    @Override
                    public void handle(String message) {
                        // Show the message in a different way, or use your own message!
                        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
                    }
                });

                doorbell.show();
            }
        });
        return rootView;
    }

}
