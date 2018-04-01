package com.example.rockeypandit.ipl2018;

/**
 * Created by rockey pandit on 26-03-2018.
 */
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;


public class ScrapCricbuzz {

Cricbuzz c = new Cricbuzz();


    ScrapCricbuzz() {
        try {
            Vector<HashMap<String, String>> matches = c.matches();
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            System.out.print(gson);
//            String json = gson.toJson(matches);
//            System.out.println(json);
//            System.out.println("kuch chala");


        //    System.out.println("matches data :"+new Gson().toJson(matches));
            String id = matches.get(0).get("id");
          //  Map<String,Map> score = c.livescore(id);
          //  json = gson.toJson(score);
         //   System.out.println("FETCHING LIVE :  " +new Gson().toJson(score));


            Map<String,Map> livescore = c.livescore(id);


            /*
            Map<String,Map> comm = c.commentary(id);
           // json = gson.toJson(comm);
            System.out.println(new Gson().toJson(comm));



            for(int k=0;k<matches.size();k++){

                System.out.println("match "+(k+1)+" :"+new Gson().toJson(matches.get(k).get("status")));
            }



            System.out.print(new Gson().toJson(score));

//            System.out.println("matches data :"+new Gson().toJson(c.matches()));


*/



        }catch (Exception e){
            e.printStackTrace();
            Log.i("ghanta","chala");
        }

        }



}
