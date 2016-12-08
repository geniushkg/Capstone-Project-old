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

public class LoginGithubActivity extends AppCompatActivity {

    public static final String GIT_CLIENT = BuildConfig.GITHUB_CLIENT;
    public static final String GIT_SECRET = BuildConfig.GITHUB_SECRET;
    public static final String PREF ="GithubMetricsPrefs";
    private static final String LOGIN = "Login" ;
    public static final String TAG = "GithubMetrics";
    Button loginBtn;
    Context mContext;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_github);
        mContext = this;
        sharedPreferences = getSharedPreferences(PREF,MODE_PRIVATE);
        boolean isLogged = sharedPreferences.getBoolean(LOGIN,false);
        if (isLogged){
            //user already logged in
            Intent intent = new Intent(this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }else {
            // user not logged in , do nothing
            Log.d(TAG, "onCreate: User not logged in");
        }

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
                        .execute();
                finish();

            }
        });
    }
}
