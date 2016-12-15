package com.hardikgoswami.githubmetrics.feedback;


import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.hardikgoswami.githubmetrics.BuildConfig;
import com.hardikgoswami.githubmetrics.R;
import com.hardikgoswami.githubmetrics.util.StargazerService;

import org.eclipse.egit.github.core.IRepositoryIdProvider;
import org.eclipse.egit.github.core.client.GitHubClient;

import java.io.IOException;

import io.doorbell.android.Doorbell;
import okhttp3.MediaType;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedbackFragment extends Fragment {


    public FeedbackFragment() {
        // Required empty public constructor
    }

    public static final String TAG = "GithubMetrics";
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    public static final String BASE_URL = "https://api.github.com/";
    public static final String DOORBELL_KEY = BuildConfig.DOORBELL_KEY;
    public static final int DOORBELL_ID = BuildConfig.DOORBELL_ID;
    public static final String NAME = "Name";
    public static final String EMAIL = "Email";
    public static final String PREFERENCE = "github_prefs";
    public static String TOKEN_USER = "";
    String email;
    String name;
    SharedPreferences sharedPreferences;
    TextView label;
    boolean isOnline;
    String oauthToken;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_feedback, container, false);
        isOnline = false;
        sharedPreferences = getActivity().getSharedPreferences(PREFERENCE, 0);
        email = sharedPreferences.getString(EMAIL, null);
        name = sharedPreferences.getString(NAME, null);
        oauthToken = sharedPreferences.getString("oauth_token", null);
        label = (TextView) rootView.findViewById(R.id.tvFeedback);
        label.setText(Html.fromHtml(getString(R.string.feedbackLabelText)));
        Button feedback = (Button) rootView.findViewById(R.id.btnSendFeedBack);
        ConnectivityManager conMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        if (netInfo == null) {
            isOnline = false;
        } else {
            isOnline = true;
        }


        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnline) {
                    Doorbell doorbell = new Doorbell(getActivity(), DOORBELL_ID, DOORBELL_KEY);
                    if (email != null) {
                        doorbell.setEmail(email);
                        doorbell.setEmailFieldVisibility(View.INVISIBLE);
                        doorbell.setPoweredByVisibility(View.INVISIBLE);
                    }
                    if (name != null) {
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

                } else {
                    Toast.makeText(getActivity(), "Please check internet connectivity", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button surveyBtn = (Button) rootView.findViewById(R.id.btnSurveyOptIn);
        surveyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isOnline) {
                    if (oauthToken != null) {
                        String[] params = new String[]{oauthToken};
                        OptInTask myAsyncTask = new OptInTask();
                        myAsyncTask.execute(params);
                    } else {
                        Toast.makeText(getActivity(), "App will close automatically ," +
                                " session expired, please login again", Toast.LENGTH_SHORT).show();
                        FirebaseAuth.getInstance().signOut();
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.clear();
                        edit.commit();
                        getActivity().finish();
                    }
                    Toast.makeText(getActivity(), "Please Wait.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), "Please check internet connectivity", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootView;
    }

    private class OptInTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {
            String oauthToken;
            oauthToken = params[0];

            //OAuth2 token authentication
            GitHubClient client = new GitHubClient();
            client.setOAuth2Token(oauthToken);

            StargazerService service = new StargazerService(client);

            try {
                service.star("geniushkg/capstone-project");
            } catch (IOException e) {
                e.printStackTrace();
                Log.d(TAG, "doInBackground: star repo : "+e.getMessage());
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getActivity(), "Thank you", Toast.LENGTH_SHORT).show();
        }
    }

}
