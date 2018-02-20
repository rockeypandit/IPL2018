package com.example.rockeypandit.ipl2018;

import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by rockey pandit on 18-02-2018.
 */
public class ScrapFixture extends AsyncTask<String,Void,String> {
        @Override
        protected void onPostExecute(String s) {




        }

        @Override
        protected String doInBackground(String... urls) {
            //Log.i("url",urls[0]);

            StringBuilder result = new StringBuilder();
            URL url;
            HttpURLConnection urlConnection = null;
            try{
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while(data !=-1){
                    char current = (char) data;
                    result.append(current);
                    data = reader.read();
                }
                return result.toString();

            }catch (Exception e){
                Log.e("Here is my error",e.toString());
                return "ERROR";
            }


        }
    }


