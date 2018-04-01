package com.example.rockeypandit.ipl2018;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;


public class MainActivity extends AppCompatActivity {


        static String s="";
    static String[] date_string;
    static String[] finalname;
    static String[] time;
    static String[] venue;
    static List<String> date = new ArrayList<String>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Intent i = new Intent(this, Home.class);
        final ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);


        ImageView imgLogo = (ImageView) findViewById(R.id.imglogo);
        final MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.sound);


        final Snackbar snackbar = Snackbar.make(imgLogo, "NO INTERNET CONNECTION", Snackbar.LENGTH_INDEFINITE);
        //   imgLogo.animate().translationY(0f);
        Animation slideup = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        imgLogo.startAnimation(slideup);


        Thread timer = new Thread() {
            public void run() {
                try {


                    sleep(500);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {


                    mp.start();


                    while (!(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                            connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)) {
                        //we are connected to a network

                        snackbar.show();


                    }

                    snackbar.dismiss();


                    try {


                        sleep(100);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
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



/*


        try {

            // getting team name to list
            String[] split = s.split("<td width=\"158\"><strong><b>Stadium &amp; Venues</b></strong></td>");
            List<String> teamName = new ArrayList<String>();
            Pattern p = compile("<td width=\"195\">(.*?)</td>");
            Matcher m = p.matcher(split[1]);
            while (m.find()) {
                // Log.i("team",m.group(1));
                teamName.add(m.group(1));
            }

//converting team name to shortform and to string
            //   Log.i("content of list",teamName.toString());
            finalname = new String[teamName.size()];
            String reg = "\\[(.*?)\\]";
            for (int j = 0; j < teamName.size(); j++) {
                finalname[j] = teamName.get(j);
                Pattern pp = compile(reg);
                Matcher mm = pp.matcher(teamName.get(j));
                while (mm.find()) {
                    // Log.i("team",m.group(1));
                    finalname[j] = mm.group(1);
                }
            }
       /* for (int i=0;i<teamName.size();i++){
            Log.i("final name = ",finalname[i]);
        }
       */
//getting date to list

        /*
            Pattern pd = compile("<td width=\"146\">(.*?)</td>");
            Matcher md = pd.matcher(split[1]);
            while (md.find()) {
                // Log.i("team",m.group(1));
                date.add(md.group(1));
            }
            date_string = date.toArray(new String[date.size()]);

//getting venue and time
            venue = new String[teamName.size()];

            Pattern pv = compile("<td width=\"158\">(.*?)</td>");
            Matcher mv = pv.matcher(split[1]);

            String[] tempString = new String[3];
            int j = 0;
            while (mv.find()) {
                //for(int i=0;i<venue.length;i++){
                if (mv.group(1).contains(",")) {
                    tempString = mv.group(1).split(",");
                    venue[j] = tempString[1].trim();
                } else {
                    venue[j] = mv.group(1).trim();
                }

                j++;

            }


            time = new String[teamName.size()];

            Pattern pt = compile("<td width=\"71\">(.*?)</td>");
            Matcher mt = pt.matcher(split[1]);

            // Log.i("mt ",mt.group(1));
            j = 0;
            while (mt.find()) {
                String regex = "<a href=\"https://web.archive.org/web/20170123110910/http://www.vivoipl2017schedule.com/\">";

                if (mt.group(1).contains("<a")) {
                    //  tempString[2]=mt.group(1).replace("<a href=\"https://web.archive.org/web/20170123110910/http://www.vivoipl2017schedule.com/\">"," ");
                    tempString[0] = mt.group(1);
                    tempString[0] = tempString[0].replaceAll(regex, "");
                    tempString[0] = tempString[0].replaceAll("</a>", "");

                    time[j] = tempString[0];
                } else {
                    time[j] = mt.group(1);
                    // Log.i("regex",regex);
                }
                //Log.i("time = ", time[j]);

                j++;
            }



            groupFixtures = new Test[date.size()];

            for (int z=0; z < groupFixtures.length; z++)
                groupFixtures[z] = new Test(finalname[z],date_string[z],venue[z],time[z]);






            }catch (Exception e){
            Toast.makeText(this,"PLEASE TRY AGAIN",Toast.LENGTH_LONG).show();
        }




*/


    }}
