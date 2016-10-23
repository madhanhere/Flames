package com.example.bijuli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.bijuli.birthday.R;

/**
 * Created by madhanhere on 10/23/2016.
 */

public class SplashScreen extends Activity{

    private static int TIMER = 3000;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        setContentView(R.layout.splashscreen_layout);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, TIMER);
    }

}
