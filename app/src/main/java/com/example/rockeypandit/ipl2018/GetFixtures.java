package com.example.rockeypandit.ipl2018;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class GetFixtures {




    String[] date_string;
    String[] finalname;
    String[] time;
    String[] venue;
    List<String> date = new ArrayList<String>();

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
     public GetFixtures(Context context)

    {
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
            //  Log.i("DATES LIST",date.get(1)+date.get(0));

            //    String[] date_string = date.toArray(new String[date.size()]);
            //    System.out.print("DATES   "+date_string[0]+"   "+date_string[1]+"   "+date_string[2]);
            //    Log.i("dsfasfas  ",String.valueOf(date_string.length));








/*
        groupFixtures = new Test[date.size()];

         for (int i=0; i < groupFixtures.length; i++) {
             groupFixtures[i] = new Test(finalname[i],date_string[i],venue[i],time[i]);

        // Log.i("TEAMS INFO   ",groupFixtures[i].getName());
         }


*/


        } catch (Exception e) {
            Toast.makeText(context, "PLEASE TRY AGAIN", Toast.LENGTH_LONG).show();
        }





    }


    public String[] getDate_string() {
        return date_string;
    }

    public String[] getFinalname() {
        return finalname;
    }

    public String[] getTime() {
        return time;
    }

    public String[] getVenue() {
        return venue;
    }

    public List<String> getDate() {
        return date;
    }
}

