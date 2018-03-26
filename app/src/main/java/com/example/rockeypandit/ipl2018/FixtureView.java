package com.example.rockeypandit.ipl2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class FixtureView extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixture_view);




        //sending url
        String s=MainActivity.s ;

     /*
        ScrapFixture scrapFixture = new ScrapFixture(this);
        try {
            s = scrapFixture.execute("https://iplschedule-2018.co.in/").get();
        } catch (Exception e) {
            Log.i("error in url","error");
            e.printStackTrace();
        }

       */
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
         String[] finalname = new String[teamName.size()];
         String reg = "\\[(.*?)\\]";
         for (int i = 0; i < teamName.size(); i++) {
             finalname[i] = teamName.get(i);
             Pattern pp = compile(reg);
             Matcher mm = pp.matcher(teamName.get(i));
             while (mm.find()) {
                 // Log.i("team",m.group(1));
                 finalname[i] = mm.group(1);
             }
         }
       /* for (int i=0;i<teamName.size();i++){
            Log.i("final name = ",finalname[i]);
        }
       */
//getting date to list
         List<String> date = new ArrayList<String>();
         Pattern pd = compile("<td width=\"146\">(.*?)</td>");
         Matcher md = pd.matcher(split[1]);
         while (md.find()) {
             // Log.i("team",m.group(1));
             date.add(md.group(1));
         }
//getting venue and time
         String[] venue = new String[teamName.size()];

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

         String[] time = new String[teamName.size()];

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
             Log.i("time = ", time[j]);

             j++;
         }





        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapters(this,finalname,date,venue,time));
     }catch (Exception e){
         Toast.makeText(this,"PLEASE TRY AGAIN",Toast.LENGTH_LONG).show();
     }
    }
}



