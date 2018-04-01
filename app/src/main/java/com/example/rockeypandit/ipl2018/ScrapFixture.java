package com.example.rockeypandit.ipl2018;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by rockey pandit on 18-02-2018.
 */







public class ScrapFixture extends AsyncTask<String,Void,String> {
    private Context context;
    Intent i;
    public ScrapFixture(Context context) {
        this.context=context;
        i = new Intent(context,Home.class);

    }
   // ProgressDialog progDailog;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//        progDailog = new ProgressDialog(context);
      //  progDailog.setMessage("Loading...");
     //   progDailog.setIndeterminate(false);
     //   progDailog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
     //   progDailog.setCancelable(true);
      //  progDailog.show();
       // context.startActivity(i);
    }

    @Override
        protected void onPostExecute(String s) {

        super.onPostExecute(s);
      //  progDailog.dismiss();
       // context.startActivity(i);



    }

        @Override
        protected String doInBackground(String... urls) {
            //Log.i("url",urls[0]);

            StringBuilder result = new StringBuilder();
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while (data != -1) {
                    char current = (char) data;
                    result.append(current);
                    data = reader.read();
                }

/*
                URL urr;
                StringBuilder res=new StringBuilder();
                HttpURLConnection urrConeection = null;
                urr = new URL("http://synd.cricbuzz.com/j2me/1.0/match/2018/2018_SLW_PAKW/SLW_PAKW_MAR28/commentary.xml");
                urrConeection = (HttpURLConnection) urr.openConnection();
                InputStream inn = urrConeection.getInputStream();
                InputStreamReader r = new InputStreamReader(inn);
                int d = r.read();
                while(d !=-1){
                    char crr= (char) d;
                    res.append(crr);
                    d=r.read();
                }

                Log.i("HERE IS MY WEBSITE ",res.toString());
*/
                return result.toString();

            } catch (Exception e) {
                Log.e("Here is my error", e.toString());
                return "ERROR";
            }


        }}





