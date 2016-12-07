package com.hardikgoswami.githubmetrics.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hardikgoswami.githubmetrics.R;
import com.hardikgoswami.oauthLibGithub.GithubOauth;

public class LoginGithubActivity extends AppCompatActivity {

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
