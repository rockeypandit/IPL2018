package com.example.rockeypandit.ipl2018;

/**
 * Created by rockey pandit on 26-03-2018.
 */
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

import cricbuzz.Cricbuzz;



public class ScrapCricbuzz {

Cricbuzz c = new Cricbuzz();


    ScrapCricbuzz() {
        try {
            Vector<HashMap<String, String>> matches = c.matches();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.print(gson);
            String json = gson.toJson(matches);
            System.out.println(json);
            System.out.println("kuch chala");

        }catch (Exception e){
            Log.i("ghanta","chala");
        }

        }

}
