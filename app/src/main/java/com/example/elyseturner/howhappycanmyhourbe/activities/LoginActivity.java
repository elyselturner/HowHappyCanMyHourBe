package com.example.elyseturner.howhappycanmyhourbe.activities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.elyseturner.howhappycanmyhourbe.R;

/**
 * Created by elyseturner on 11/26/14.
 */
public class LoginActivity extends Activity {
    private static final String TAG = LoginActivity.class.getName();
    private EditText userName;
    private EditText passWord;
    private Button loginButton;

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        prefs = getSharedPreferences("com.example.elyseturner.howhappycanmyhourbe", MODE_PRIVATE);

        userName = (EditText) findViewById(R.id.user_name);
        passWord = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.login_button);

        userName.setText(prefs.getString("username", ""));
    }

    public void loginButtonClicked(View v) {
        final String userNameString = userName.getText().toString().trim();
        final String passwordString = passWord.getText().toString().trim();

        prefs.edit()
                .putString("username", userNameString)
                .apply();

        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection urlConnection = null;
                try {
                    Uri oauthUrl = new Uri.Builder()
                            .scheme("http")
                            .authority("platform.fatsecret.com")
                            .appendPath("rest")
                            .appendPath("server.api")
                            .appendQueryParameter("method", "profile.get_auth")
                            .appendQueryParameter("oauth_consumer_key", getString(R.string.api_key))
                            .appendQueryParameter("oauth_signature_method", "HMAC-SHA1")
                            .appendQueryParameter("oauth_timestamp", "" + System.currentTimeMillis())
                            .appendQueryParameter("oauth_nonce", "randobrando")
                            .appendQueryParameter("oauth_version", "1.0")
                            .appendQueryParameter("oauth_signature", "")
                            .appendQueryParameter("user_id", userNameString)
                            .appendQueryParameter("format", "json")
                            .build();

                    URL url = new URL(oauthUrl.toString());
                    urlConnection = (HttpURLConnection) url.openConnection();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    String line;
                    while((line = reader.readLine()) != null) {
                        Log.d(TAG, line);
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if(urlConnection != null) urlConnection.disconnect();
                }
            }

        }).start();
        */
    }
}
