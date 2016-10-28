package com.hardikgoswami.githubprofile.login;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GithubAuthProvider;
import com.hardikgoswami.githubprofile.BuildConfig;
import com.hardikgoswami.githubprofile.R;
import com.hardikgoswami.githubprofile.home.HomeActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "GITHUBPROFILE";
    private static final String OAUTH_URL = "https://github.com/login/oauth/authorize";
    private static final String TOKEN_URL = "https://github.com/login/oauth/access_token";
    private static final String CLIENT_ID = BuildConfig.CLIENT_ID;
    private static final String  CLIENT_SECRET = BuildConfig.CLIENT_SECRET;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    public static String url = OAUTH_URL + "?client_id=" + CLIENT_ID ;;

    private Button mLoginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login_act);
 
        //setup button
        mLoginButton = (Button) findViewById(R.id.login_btn);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // start login dialog
                WebView webView = new WebView(getApplicationContext());
                webView.requestFocus(View.FOCUS_DOWN);
                webView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                            case MotionEvent.ACTION_UP:
                                if (!v.hasFocus()) {
                                    v.requestFocus();
                                }
                                break;
                        }
                        return false;
                    }
                });
                webView.loadUrl(url);

            }
        });

        // firebase helper and listener
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    navigateToUserHome();
                    // navigate to home activity
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");

                }
            }

        };

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Uri uri = intent.getData();
        String path = uri.toString(); // "/mnt/sdcard/FileName.mp3"
        Log.d(TAG,"uri data is : "+ path);
        String code[] = path.split("code=");
        getOauthToken(code[1]);
    }

    private void getOauthToken(String code){
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder builder = HttpUrl.parse(TOKEN_URL).newBuilder();
        builder.addQueryParameter("client_id",CLIENT_ID);
        builder.addQueryParameter("client_secret",CLIENT_SECRET);
        builder.addQueryParameter("code",code);
        String tokenUrl = builder.build().toString();

        final Request request = new Request.Builder()
                .header("Accept","application/json")
                .url(tokenUrl)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG,"failed token :"+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               try{
                   String responseData = response.body().string();
                   JSONObject json = new JSONObject(responseData);
                   String token = json.getString("access_token");
                   authWithFirebase(token);
               }catch (JSONException jExcep){
                   Log.d(TAG,"json exeption :"+jExcep.getMessage());
               }
            }
        });

    }

    private void authWithFirebase(String token) {
        AuthCredential credential = GithubAuthProvider.getCredential(token);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());
                        Toast.makeText(LoginActivity.this, "Authentication success.",
                                Toast.LENGTH_SHORT).show();
                        navigateToUserHome();
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithCredential", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

    private void navigateToUserHome(){
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}

