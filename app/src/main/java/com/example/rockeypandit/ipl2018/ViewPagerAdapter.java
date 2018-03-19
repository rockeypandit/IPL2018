package com.example.rockeypandit.ipl2018;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Created by rockey pandit on 12-03-2018.
 */









public class ViewPagerAdapter extends PagerAdapter{


    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] images = {R.color.previousScore,R.drawable.firstmatch,R.color.previousScore};


    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

  //  String tt;






/*

        //CountdownTimer
       CountDownTimer mCountDownTimer;
        long mInitialTime = Calendar.getInstance().getTimeInMillis();
        String mInitialTimetoString = String.valueOf(mInitialTime);

       // timerText.setText("HELLO");



//        mTextView = (TextView) findViewById(R.id.timerText);

        mCountDownTimer = new CountDownTimer(mInitialTime, 1000) {

            StringBuilder time = new StringBuilder();
            @Override
            public void onFinish() {
               tt=DateUtils.formatElapsedTime(0);
                // timerText.setText(DateUtils.formatElapsedTime(0));
                //mTextView.setText("Times Up!");
            }

            @Override
            public void onTick(long millisUntilFinished) {
                time.setLength(0);
                // Use days if appropriate
                if(millisUntilFinished > DateUtils.DAY_IN_MILLIS) {
                    long count = millisUntilFinished / DateUtils.DAY_IN_MILLIS;
                    if(count > 1)
                        time.append(count).append(" days ");
                    else
                        time.append(count).append(" day ");

                    millisUntilFinished %= DateUtils.DAY_IN_MILLIS;
                }

                time.append(DateUtils.formatElapsedTime(Math.round(millisUntilFinished / 1000d)));
                timerTime[0] =time.toString();
                //mTextView.setText(time.toString());
            }
        };




*/



   //CountDownTimer




//mCountDownTimer.start();




  //      long currentTime = Calendar.getInstance().getTimeInMillis();
        String tt[]={"Previous Match Score","","Upcoming Match"};

    public Object instantiateItem(ViewGroup container , final int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.home_live_tile,null);

        final ImageView imageView = (ImageView) view.findViewById(R.id.imageView2);
        final TextView timerText = (TextView) view.findViewById(R.id.timerText);
        final String[] timerTime = new String[1];
      //  String crrTime;


        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY, HH:mm:ss");
        Date d = Calendar.getInstance().getTime();
      //  crrTime=formatter.format(d);


       // String matchTime = "07-04-2018, 08:00:00" ;
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));





        //Log.i("time",String.valueOf(Calendar.getInstance().getTime()));


        //long currentTime = Calendar.getInstance().getTimeInMillis();
        long diffTime=0;
        try {
            long mt =1523111400000L;
            diffTime=mt-Calendar.getInstance().getTimeInMillis();
          //  Log.i("DIFFERENCE",String.valueOf(diffTime));
            //BigInteger BI =new BigInteger("1523111400000");
            //long ll = 342565453434366754L;


        } catch (Exception e) {
            e.printStackTrace();
        }




        try {
            new CountDownTimer(diffTime,1000){


/*

                long diff;
                long oldLong;
                long NewLong;



               // SimpleDateFormat formatter = new SimpleDateFormat("dd-MM, HH:mm:ss");
               // String currentTime = "19.02.2018, 12:00";//Timer date 1
                String matchTime = "07-04,08:00:00" ;//Timer date 2
                Date date = formatter.parse(matchTime);//oldDate=, newDate="07.04.2018";
                long lg=date.getTime();
                long matchDate=date.getTime();
                  //  diff = NewLong - oldLong;

*/

                public void onTick(long miliSecondsUntilDone) {
    /*
                    Calendar cl = Calendar.getInstance();
                    cl.setTimeInMillis(miliSecondsUntilDone);  //here your time in miliseconds
                    String date = "" + cl.get(Calendar.DAY_OF_MONTH) + ":" + cl.get(Calendar.MONTH) + ":" + cl.get(Calendar.YEAR);
                    String time = "" + cl.get(Calendar.HOUR_OF_DAY) + ":" + cl.get(Calendar.MINUTE) + ":" + cl.get(Calendar.SECOND);

*/
                    String hms = (TimeUnit.MILLISECONDS.toDays(miliSecondsUntilDone)) + "Days "
                            + (TimeUnit.MILLISECONDS.toHours(miliSecondsUntilDone) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(miliSecondsUntilDone)) + ":")
                            + (TimeUnit.MILLISECONDS.toMinutes(miliSecondsUntilDone) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(miliSecondsUntilDone)) + ":"
                            + (TimeUnit.MILLISECONDS.toSeconds(miliSecondsUntilDone) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(miliSecondsUntilDone))));


                    imageView.setImageResource(images[position]);
                    tt[1]=hms;
                    timerText.setText(tt[position]);
                    Log.i("timer",String.valueOf(miliSecondsUntilDone));

                    //Toast.makeText(,String.valueOf(miliSecondsUntilDone),Toast.LENGTH_LONG);

                    // tt[1]=(String.valueOf(miliSecondsUntilDone/1000));

                   // String temp=(String.valueOf(miliSecondsUntilDone/1000));

                //    tt={"Previous Match Score",temp,"Upcoming Match"};


                 //   tt=String.valueOf(miliSecondsUntilDone);
                }

                @Override
                public void onFinish() {
                    Log.i("Timer","FINISHEDDDD");

                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //      String[] textView = {"Previous Match Score",tt,"Upcoming Match"};


        imageView.setImageResource(images[position]);
       // timerText.setText(textView[position]);


        ViewPager vp = (ViewPager) container;
        vp.addView(view,0);
        vp.setCurrentItem(1);
        return view;

    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}


