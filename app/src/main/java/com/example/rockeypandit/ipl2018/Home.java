package com.example.rockeypandit.ipl2018;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;




public class Home extends AppCompatActivity implements ForceUpdateChecker.OnUpdateNeededListener{


    public void fixtureCall(View view){
        Intent intent = new Intent(getApplicationContext(), FixtureView.class);
        startActivity(intent);

    }


    public void teamsCall(View view){
        Intent intent = new Intent(getApplicationContext(), Teams.class);
        startActivity(intent);

    }

    public void pointsCall(View view){
        Intent intent = new Intent(getApplicationContext(), PointsTable.class);
        startActivity(intent);
    }
    public void live(View view){
        Toast.makeText(this,"WAIT FOR THE IPL TO START...",Toast.LENGTH_LONG).show();
    }



    ViewPager viewPager;
    LinearLayout sliderDotspane1;
    private  int dotsCount;
    private ImageView[] dots;





    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ForceUpdateChecker.with(this).onUpdateNeeded(this).check();

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        sliderDotspane1 = (LinearLayout) findViewById(R.id.sliderDots);


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
//LottieAnimationView animationView=findViewById(R.id.test);

        viewPager.setAdapter(viewPagerAdapter);

        dotsCount = viewPagerAdapter.getCount();
        dots = new ImageView[dotsCount];
        try {
            ScrapCricbuzz cr= new ScrapCricbuzz();
            //  cr.func();
        }catch (Exception e){
            Log.i("ni","chala");
        }





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
             //   dots[position].setScaleType(ImageView.ScaleType.FIT_XY);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

      //  viewPager.setCurrentItem(1);





      //  ScrapFixture f=new ScrapFixture(this);
      //  f.crickbuzz();
      //   Log.i("TEAMS INFO   ",FixtureView.groupFixtures[2].getName());






    }









    @Override
    public void onUpdateNeeded(final String updateUrl) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("New version available")
                .setMessage("Please, update app to new version to continue.")
                .setPositiveButton("Update",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                redirectStore(updateUrl);
                            }
                        }).setNegativeButton("No, thanks",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).create();
        dialog.show();
    }

    private void redirectStore(String updateUrl) {
        final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(updateUrl));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }













}
