package com.example.elyseturner.howhappycanmyhourbe.activities.Activities;

/**
 * Created by elyseturner on 12/6/14.
 */


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.example.elyseturner.howhappycanmyhourbe.R;
import com.example.elyseturner.howhappycanmyhourbe.activities.utils.FatSecretUtils;

//        import com.google.gson.Gson;
//        import com.google.gson.GsonBuilder;
//        import com.google.gson.JsonObject;

//        import broken.shotgun.fatsecret.R;
//        import broken.shotgun.fatsecret.utils.FatSecretUtils;
//        import oauth.signpost.exception.OAuthCommunicationException;
//        import oauth.signpost.exception.OAuthExpectationFailedException;
//        import oauth.signpost.exception.OAuthMessageSignerException;


public class HomeActivity extends ActionBarActivity {
    private static final String ACCESS_TOKEN_MISSING = "gone";

    private static final String TAG = HomeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences pref = getSharedPreferences(FatSecretUtils.PREFERENCES_FILE, MODE_PRIVATE);
        String accessToken = pref.getString(FatSecretUtils.OAUTH_ACCESS_TOKEN_KEY, ACCESS_TOKEN_MISSING);

        if (accessToken.equals(ACCESS_TOKEN_MISSING)) {
            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);
            finish();
            return;
        }

        //code smell.... don't usually do this
        //add
        FatSecretUtils.setContext(this);

        TextView loggedInText = (TextView) findViewById(R.id.loggedInText);
        loggedInText.setText("auth token = " + pref.getString("oauth_access_token", ACCESS_TOKEN_MISSING));

    }
}
