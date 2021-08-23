package com.example.banha_services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplachScreen extends AppCompatActivity {
ImageView imgin;
Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach_screen);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplachScreen.this,MainActivity.class);
                SplachScreen.this.startActivity(mainIntent);
                SplachScreen.this.finish();
            }
        }, 3000);
        imgin=(ImageView) findViewById(R.id.spl);
        animation= AnimationUtils.loadAnimation(this,R.anim.blink);
        imgin.setVisibility(View.VISIBLE);
        imgin.startAnimation(animation);
    }
}