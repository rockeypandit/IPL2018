package com.example.rockeypandit.ipl2018;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imgLogo = (ImageView) findViewById(R.id.imglogo);
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.sound);
        mp.start();


        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);
        imgLogo.startAnimation(slide_up);


        final Intent i = new Intent(this,Home.class);
        Thread timer = new Thread(){
            public void run() {
                try{
                    sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally{
                    startActivity(i);
                    finish();
                }
            }


        };
        timer.start();








    }
}
