package com.hardikgoswami.githubmetrics.Login;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.hardikgoswami.githubmetrics.BuildConfig;
import com.hardikgoswami.githubmetrics.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_login;
    public static final String CLIENT_ID = BuildConfig.GITHUB_ID;
    public static final String CLIENT_SECRET=BuildConfig.GITHUB_SECRET;
    public static final String CODE = "";
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
        final WebView webview = (WebView) findViewById(R.id.webview);
        webview.loadUrl("https://github.com/login/oauth/authorize");
        webview.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                String fragment = "?code=";
                int start = url.indexOf(fragment);
                if (start > -1) {
                    webview.stopLoading();
                    final String code = url.substring(start+fragment.length(), url.length());
                    // Remember, never run network processes within UI threads

                    // ...so we use asynctask instead

                    final AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {
                        @Override
                        protected String doInBackground(Void... p) {
                            try {
                                // Create the JSON parameters to send to Github
                                JSONObject params = new JSONObject();
                                params.put("client_id",BuildConfig.GITHUB_ID);
                                params.put("client_secret", BuildConfig.GITHUB_SECRET);
                                params.put("code", code);

                                // Post

                                String data = null;
                                URL url = new URL("https://github.com/login/oauth/access_token");
                                String body = params.toString();  byte[] bytes = body.getBytes();
                                HttpURLConnection conn = null;
                                try {
                                    conn = (HttpURLConnection) url.openConnection();
                                    conn.setDoOutput(true);
                                    conn.setUseCaches(false);
                                    conn.setFixedLengthStreamingMode(bytes.length);
                                    conn.setRequestMethod("POST");
                                    conn.setRequestProperty("Content-Type", "application/json");
                                    conn.setRequestProperty("Accept", "application/json");
                                    // Github requires a user agent header

                                    conn.setRequestProperty("User-Agent", "Github Metrics App");

                                    OutputStream out = conn.getOutputStream();
                                    out.write(bytes);
                                    out.close();

                                    InputStream is = null;
                                    try {
                                        is = conn.getInputStream();
                                    }
                                    catch (IOException e) {
                                        //e.printStackTrace();

                                        // Hack for 4xx http headers

                                        is = conn.getErrorStream();
                                    }

                                    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                                    StringBuffer response = new StringBuffer();
                                    String line;
                                    while((line = rd.readLine()) != null) {
                                        response.append(line).append("\n");;
                                    }
                                    rd.close();
                                    data = response.toString();
                                } finally {
                                    if (conn != null) {
                                        conn.disconnect();
                                    }
                                }

                                try {
                                    JSONObject json = new JSONObject(data);
                                    String token = json.getString("access_token");
                                    Toast.makeText(getApplication(),"Token is : "+token,Toast.LENGTH_SHORT).show();
                                    // TODO: 11/1/2016 save token to shared prerence

                                    return null;
                                } catch (JSONException e) {
                                    // Log.e(TAG, e.getMessage());

                                }
                            }
                            catch (IOException e) {
                                // Log.e(TAG, e.getMessage());

                            }
                            catch (JSONException e) {
                                // Log.e(TAG, e.getMessage());

                            }

                            return null;
                        }

                        @Override
                        protected void onPostExecute(String s) {
                            super.onPostExecute(s);

                        }
                    };
                    task.execute();
                }
            }
        });
    }
}
