package com.example.rockeypandit.ipl2018;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


public class Home extends AppCompatActivity {


    public void fixtureCall(View view){
        Intent intent = new Intent(getApplicationContext(), FixtureView.class);
        startActivity(intent);

    }


    public void teamsCall(View view){
        Intent intent = new Intent(getApplicationContext(), Teams.class);
        startActivity(intent);

    }

    public void pointsCall(View view){
        Toast.makeText(this,"COMING SOON..!!",Toast.LENGTH_LONG).show();

    }




    ViewPager viewPager;
    LinearLayout sliderDotspane1;
    private  int dotsCount;
    private ImageView[] dots;





    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        sliderDotspane1 = (LinearLayout) findViewById(R.id.sliderDots);


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        dotsCount = viewPagerAdapter.getCount();
        dots = new ImageView[dotsCount];










        for(int i=0;i< dotsCount;i++){
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactivedot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8,0,8,0);
            sliderDotspane1.addView(dots[i],params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i=0;i<dotsCount;i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactivedot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
}
