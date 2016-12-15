package com.hardikgoswami.githubmetrics.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hardikgoswami.githubmetrics.BuildConfig;
import com.hardikgoswami.githubmetrics.R;
import com.hardikgoswami.githubmetrics.home.HomeActivity;
import com.hardikgoswami.oauthLibGithub.GithubOauth;

import java.util.ArrayList;
import java.util.Arrays;

public class LoginGithubActivity extends AppCompatActivity {

    public static final String GIT_CLIENT = BuildConfig.GITHUB_CLIENT;
    public static final String GIT_SECRET = BuildConfig.GITHUB_SECRET;
    private static final String LOGIN = "Login" ;
    public static final String TAG = "GithubMetrics";
    public static final String PREFERENCE = "github_prefs";
    Button loginBtn;
    Context mContext;
    SharedPreferences sharedPreferences;
    String oauthToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_github);
        mContext = this;
        sharedPreferences = getSharedPreferences(PREFERENCE, 0);
        oauthToken = sharedPreferences.getString("oauth_token", null);
        Log.d(TAG, "oauth token for github loged in user is :" + oauthToken);

        sharedPreferences = getSharedPreferences(PREFERENCE,MODE_PRIVATE);
        boolean isLogged = sharedPreferences.getBoolean(LOGIN,false);
        if (oauthToken!=null){
            Log.d(TAG, "onCreate: oauth token is :"+oauthToken);
            //user already logged in
            Intent intent = new Intent(this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }else {
            // user not logged in , do nothing
            Log.d(TAG, "onCreate: User not logged in");
        }
        final ArrayList<String> scopeList = new ArrayList<>();
        scopeList.add("user");
        scopeList.add("public_repo");
        loginBtn =(Button)findViewById(R.id.btnLogin);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GithubOauth
                        .Builder()
                        .withClientId(GIT_CLIENT)
                        .withClientSecret(GIT_SECRET)
                        .withContext(mContext)
                        .packageName("com.hardikgoswami.githubmetrics")
                        .nextActivity("com.hardikgoswami.githubmetrics.home.HomeActivity")
                        .debug(true)
                        .withScopeList(scopeList)
                        .execute();
                finish();

            }
        });
    }
}
