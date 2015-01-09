package com.example.elyseturner.howhappycanmyhourbe.activities.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.example.elyseturner.howhappycanmyhourbe.R;

/**
 * Created by elyseturner on 12/9/14.
 */
public class SplashScreenActivity extends Activity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 4000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_splash_screen);
//        TextView splashScreenText = (TextView) findViewById(R.id.how_happy);
//        splashScreenText.setText(getString(R.string.splash_screen_text));
    }


    @Override
    public void onResume() {
        super.onResume();
        // Load the ImageView that will host the animation and
        // set its background to our AnimationDrawable XML resource.
        ImageView splashScreenImage = (ImageView)findViewById(R.id.beer);
        splashScreenImage.setBackgroundResource(R.drawable.orange);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashScreenActivity.this,AppActivity.class);
                SplashScreenActivity.this.startActivity(mainIntent);
                SplashScreenActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

}
