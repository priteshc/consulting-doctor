package com.consulting.doctor.consulting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by pritesh on 6/9/2017.
 */

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);

        Thread thread = new Thread(){

            @Override
            public void run() {
                try {

                    sleep(3000);

                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {

                    Intent intent = new Intent(Splash.this, WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                    }


            }

        };thread.start();
    }




}
