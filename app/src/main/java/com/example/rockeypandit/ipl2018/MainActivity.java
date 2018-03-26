package com.example.rockeypandit.ipl2018;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity {
   static String s="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent i = new Intent(this, Home.class);
        final ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        ImageView imgLogo = (ImageView) findViewById(R.id.imglogo);
        final MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.sound);


        final Snackbar snackbar= Snackbar.make(imgLogo,"NO INTERNET CONNECTION",Snackbar.LENGTH_INDEFINITE);
     //   imgLogo.animate().translationY(0f);
        Animation slideup = AnimationUtils.loadAnimation(this,R.anim.slide_up);
        imgLogo.startAnimation(slideup);




        Thread timer = new Thread(){
            public void run() {
                try{



                    sleep(800);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally{


                    mp.start();



                    while(!(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                            connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) ){
                        //we are connected to a network

                        snackbar.show();


                    }

                    snackbar.dismiss();


                    try{



                        sleep(400);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    finally {
                        ScrapFixture scrapFixture = new ScrapFixture(MainActivity.this);
                        try {
                            s = scrapFixture.execute("https://iplschedule-2018.co.in/").get();
                        } catch (Exception e) {
                            Log.i("error in url", "error");
                            e.printStackTrace();
                        }
                        startActivity(i);

                        finish();

                    }
                }
            }


        };
        timer.start();








    }
}
