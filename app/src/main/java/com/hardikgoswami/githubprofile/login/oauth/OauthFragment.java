package com.hardikgoswami.githubprofile.login.oauth;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.hardikgoswami.githubprofile.R;
import com.hardikgoswami.githubprofile.login.LoginActivity;

import java.io.UnsupportedEncodingException;

import static android.content.ContentValues.TAG;

/**
 * Created by geniushkg on 10/26/2016.
 */

public class OauthFragment extends DialogFragment {

    public static final String PREFS_NAME = "OAUTH_PREFS";
    public static final String PREFS_KEY = "OAUTH_PREFS_CODE";
    private WebView webViewOauth;
    private static Context mContext;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Override
    public void onViewCreated(View arg0, Bundle arg1) {
        super.onViewCreated(arg0, arg1);
        try {
            //load the url of the oAuth login page
            webViewOauth
                    .loadUrl(LoginActivity.url);
            //activates JavaScript (just in case)
            WebSettings webSettings = webViewOauth.getSettings();
            webSettings.setJavaScriptEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Retrieve the webview
        View v = inflater.inflate(R.layout.auth_dialog, container, false);
        webViewOauth = (WebView) v.findViewById(R.id.web_oauth);
        getDialog().setTitle("Use your Github account");
        return v;
    }
}
