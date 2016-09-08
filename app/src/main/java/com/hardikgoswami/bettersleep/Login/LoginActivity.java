package com.hardikgoswami.bettersleep.Login;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.hardikgoswami.bettersleep.Dashboard.Dashboard;
import com.hardikgoswami.bettersleep.R;

public class LoginActivity extends AppCompatActivity {
    public static final String TAG = "LOGIN";
    private static final int RC_SIGN_IN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // implement google signIn using firebase ui kit

        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            Log.d(TAG, "user already logged in");
            startActivity(new Intent(this,Dashboard.class));
        } else {
            Log.d(TAG, "No loged in user found");
           // startActivityForResult(AuthUI.getInstance()
//                    .createSignInIntentBuilder()
//                    .setProviders(AuthUI.GOOGLE_PROVIDER)
//                    .build(),RC_SIGN_IN);

        }
    }

    

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_SIGN_IN){
            if(resultCode == RESULT_OK){
                Log.d(TAG,"user sign in success");
                startActivity(new Intent(this,Dashboard.class));
            }else {
                Log.d(TAG,"sign in result failed");
            }
        }
    }
}
