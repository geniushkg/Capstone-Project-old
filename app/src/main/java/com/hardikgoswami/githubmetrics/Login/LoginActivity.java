package com.hardikgoswami.githubmetrics.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.hardikgoswami.githubmetrics.BuildConfig;
import com.hardikgoswami.githubmetrics.Home.HomeActivity;
import com.hardikgoswami.githubmetrics.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = LoginActivity.class.getSimpleName();
    Button btn_login;
    public static final String CLIENT_ID = BuildConfig.GITHUB_ID;
    public static final String CLIENT_SECRET = BuildConfig.GITHUB_SECRET;
    public static final String GITHUB_URL = "https://github.com/login/oauth/authorize";
    public static final String GITHUB_OAUTH = "https://github.com/login/oauth/access_token";
    public static String CODE = "";

    WebView webview;
    TextView tv_web;
    com.rey.material.widget.ProgressView progresview;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_act);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        setContentView(R.layout.webview);
        progresview = (com.rey.material.widget.ProgressView) findViewById(R.id.progress_view);
        progresview.setVisibility(View.VISIBLE);
        webview = (WebView) findViewById(R.id.webview);
        tv_web = (TextView) findViewById(R.id.tv_webview);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                super.shouldOverrideUrlLoading(view, url);
                CODE = url.substring(url.lastIndexOf("?code=") + 1);
                Log.d(TAG,"code fetched is :"+CODE);
                String[] token_code = CODE.split("=");
                fetchOauthTokenWithCode(token_code[1]);
                return false;
            }
        });
        String url_load = GITHUB_URL + "?client_id=" + CLIENT_ID;
        webview.loadUrl(url_load);
    }

    private void fetchOauthTokenWithCode(String code) {
            OkHttpClient client = new OkHttpClient();
            HttpUrl.Builder url = HttpUrl.parse(GITHUB_OAUTH).newBuilder();
            url.addQueryParameter("client_id", CLIENT_ID);
            url.addQueryParameter("client_secret", CLIENT_SECRET);
            url.addQueryParameter("code", code);
            String url_oauth = url.build().toString();
            final Request request = new Request.Builder()
                    .header("Accept", "application/json")
                    .url(url_oauth)
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if(response.isSuccessful()){
                        String JsonData = response.body().string();
                        Log.d(TAG,"response is:"+JsonData);
                        try {
                            JSONObject jsonObject = new JSONObject(JsonData);
                            String auth_token = jsonObject.getString("access_token");
                           // progresview.setVisibility(View.INVISIBLE);
                            //tv_web.setText("Token found : "+auth_token);
                            Log.d(TAG,"token is :"+auth_token);
                            storeToSharedPreference(auth_token);
                        }catch (JSONException exp){
                            Log.d(TAG,"json exception :"+exp.getMessage());
                        }

                    }

                }
            });
    }

    private void storeToSharedPreference(String auth_token) {
        SharedPreferences prefs = getSharedPreferences("github_prefs",MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("oauth_token",auth_token);
        edit.commit();
        Intent intent = new Intent(this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }


}
