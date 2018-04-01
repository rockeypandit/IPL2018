package com.example.rockeypandit.ipl2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class FixtureView extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapters adapters;


     String[] finalname;
     String[] time;
     String[] venue;
    List<String> date = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixture_view);




        //sending url
        String s=MainActivity.s ;

        GetFixtures getFixtures = new GetFixtures(this);
        //adapters=getFixtures.getAdapters();
        finalname=getFixtures.getFinalname();
        date=getFixtures.getDate();
        venue=getFixtures.getVenue();
        time=getFixtures.getTime();



        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapters = new Adapters(this, finalname, date, venue, time);
        recyclerView.setAdapter(adapters);




    }}





