package com.hardikgoswami.githubmetrics.home;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GithubAuthProvider;
import com.hardikgoswami.githubmetrics.R;
import com.hardikgoswami.githubmetrics.feedback.FeedbackFragment;
import com.hardikgoswami.githubmetrics.history.HistoryFragment;
import com.hardikgoswami.githubmetrics.search.SearchFragment;
import com.squareup.picasso.Picasso;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String NAME = "Name";
    public static final String EMAIL = "Email";
    public static final String LOGIN = "Login";
    public static final String IMG_URL = "ImageUrl";

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAnalytics mFirebaseAnalytics;
    boolean doubleBackToExitPressedOnce = false;
    private static final String TAG = "GithubMetrics";
    SharedPreferences sharedPreferences;
    public static final String PREFERENCE = "github_prefs";
    private String oauthToken;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharedPreferences = getSharedPreferences(PREFERENCE, 0);
        oauthToken = sharedPreferences.getString("oauth_token", null);
        Log.d(TAG, "oauth token for github loged in user is :" + oauthToken);

        //firebase setup user login setup
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(LOGIN, true);
                    if (user.getDisplayName() != null) {
                        editor.putString(NAME, user.getDisplayName());
                    }
                    if (user.getEmail() != null) {
                        editor.putString(EMAIL, user.getEmail());
                    }
                    if (user.getPhotoUrl() != null) {
                        editor.putString(IMG_URL, user.getPhotoUrl().toString());
                    }
                    editor.commit();


                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                    getAuthCredentials(oauthToken);
                }
            }
        };

        if (!sharedPreferences.getBoolean(LOGIN, false)) {
            //exchange oauth token with firebase and login user
            String token = oauthToken;
            AuthCredential credential = GithubAuthProvider.getCredential(token);
            mAuth.signInWithCredential(credential)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());
                            // display error for siginfails , for succesfull signin handle login in listener
                            if (!task.isSuccessful()) {
                                Log.d(TAG, "signInWithCredential", task.getException());
                                Toast.makeText(HomeActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                Toast.makeText(HomeActivity.this, "Please check internet connectivity", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        } else {
            //user credentail available, already logged in.
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        updateNavigationView();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_home, new SearchFragment())
                .commit();
    }

    private void updateNavigationView() {
        //update navigation view as per user details
        View headerView = navigationView.getHeaderView(0);
        if (headerView != null) {
            TextView name = (TextView) headerView.findViewById(R.id.tvNavHeaderName);
            String fetchedName = sharedPreferences.getString(NAME, null);
            if (fetchedName != null) name.setText(fetchedName);

            TextView email = (TextView) headerView.findViewById(R.id.tvNavHeaderEmail);
            String fetchedEmail = sharedPreferences.getString(EMAIL, null);
            if (fetchedEmail != null) email.setText(fetchedEmail);

            ImageView ivProfileImage = (ImageView) headerView.findViewById(R.id.imageViewNavigationProfile);
            if (ivProfileImage != null) {
                String profileUrl = sharedPreferences.getString(IMG_URL, null);
                Log.d(TAG, "onCreate: profile image url : " + profileUrl);
                profileUrl = profileUrl + "&s=50";
                if (profileUrl != null) {
                    Picasso.with(this)
                            .load(profileUrl)
                            .into(ivProfileImage);
                }
            } else {
                Log.d(TAG, "onCreate: profileview null");
            }
        }
    }

    private void getAuthCredentials(String oauthToken) {
        AuthCredential credential = GithubAuthProvider.getCredential(oauthToken);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithCredential", task.getException());
                        }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_search:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_home, new SearchFragment())
                        .commit();
                break;
            case R.id.nav_history:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_home, new HistoryFragment())
                        .commit();
                Bundle params2 = new Bundle();
                params2.putString(FirebaseAnalytics.Param.VALUE, "History Fragment");
                mFirebaseAnalytics.logEvent("User navigation", params2);
                break;
            case R.id.nav_feedback:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_home, new FeedbackFragment())
                        .commit();
                break;
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.clear();
                edit.commit();
                finish();
                break;
            default:
                Log.d(TAG, "onNavigationItemSelected: default case executed");
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
