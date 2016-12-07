package com.hardikgoswami.githubmetrics.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hardikgoswami.githubmetrics.BuildConfig;
import com.hardikgoswami.githubmetrics.R;

public class LoginGithubActivity extends AppCompatActivity {

    public static final String GIT_CLIENT = BuildConfig.GITHUB_CLIENT;
    public static final String GIT_SECRET = BuildConfig.GITHUB_SECRET;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_github);
        loginBtn =(Button)findViewById(R.id.btnLogin);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}
