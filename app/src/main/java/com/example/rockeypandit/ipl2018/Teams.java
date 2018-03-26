package com.example.rockeypandit.ipl2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Teams extends AppCompatActivity {


    public void chennaiInfo(View v){
        Intent i = new Intent(this,TeamInfo.class).putExtra("teamvalue","1");
        startActivity(i);
    }
    public void mumbaiInfo(View v){
        Intent i = new Intent(this,TeamInfo.class).putExtra("teamvalue","2");
        startActivity(i);
    }
    public void hyderabadInfo(View v){
        Intent i = new Intent(this,TeamInfo.class).putExtra("teamvalue","6");
        startActivity(i);
    }
    public void kolkataInfo(View v){
        Intent i = new Intent(this,TeamInfo.class).putExtra("teamvalue","4");
        startActivity(i);
    }
    public void rajasthanInfo(View v){
        Intent i = new Intent(this,TeamInfo.class).putExtra("teamvalue","8");
        startActivity(i);
    }
    public void bangaloreInfo(View v){
        Intent i = new Intent(this,TeamInfo.class).putExtra("teamvalue","3");
        startActivity(i);
    }
    public void punjabInfo(View v){
        Intent i = new Intent(this,TeamInfo.class).putExtra("teamvalue","5");
        startActivity(i);
    }
    public void delhiInfo(View v){
        Intent i = new Intent(this,TeamInfo.class).putExtra("teamvalue","7");
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);



    }
}
