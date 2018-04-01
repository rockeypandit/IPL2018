package com.example.rockeypandit.ipl2018;


import android.content.Context;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Created by rockey pandit on 12-03-2018.
 */


public class ViewPagerAdapter extends PagerAdapter{


    private Context context;
    private LayoutInflater layoutInflater;
   // private Integer[] images = {R.color.previousScore,R.drawable.firstmatch,R.color.previousScore};



    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }





    String tt="";

    public Object instantiateItem(ViewGroup container , final int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.home_live_tile,null);
        final TextView timerText = (TextView) view.findViewById(R.id.timerText);
    //    final ImageView imageView = (ImageView) view.findViewById(R.id.imageView2);


        ImageView tl1 = (ImageView) view.findViewById(R.id.logo1);
        ImageView tl2 = (ImageView) view.findViewById(R.id.logo2);
        TextView tn1 = (TextView) view.findViewById(R.id.teamName1);
        TextView tn2 = (TextView) view.findViewById(R.id.teamName2);
        TextView date = (TextView) view.findViewById(R.id.date);
        TextView venue = (TextView) view.findViewById(R.id.venue);


        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy, HH:mm:ss", Locale.US);


        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));




        long diffTime=0;
        try {
            long mt =1523111400000L;
            diffTime=mt-Calendar.getInstance().getTimeInMillis();



        } catch (Exception e) {
            e.printStackTrace();
        }




        try {
            new CountDownTimer(diffTime,1000){



                public void onTick(long miliSecondsUntilDone) {
                        String hms = (TimeUnit.MILLISECONDS.toDays(miliSecondsUntilDone)) + "Days "
                            + (TimeUnit.MILLISECONDS.toHours(miliSecondsUntilDone) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(miliSecondsUntilDone)) + ":")
                            + (TimeUnit.MILLISECONDS.toMinutes(miliSecondsUntilDone) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(miliSecondsUntilDone)) + ":"
                            + (TimeUnit.MILLISECONDS.toSeconds(miliSecondsUntilDone) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(miliSecondsUntilDone))));


                //    imageView.setImageResource(images[position]);
                    tt=hms;
                    if (position==0)
                        timerText.setText(tt);
                 //   Log.i("timer",String.valueOf(miliSecondsUntilDone));


                }

                @Override
                public void onFinish() {
                    timerText.setVisibility(View.GONE);

                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }












        GetFixtures getFixtures = new GetFixtures(context);
        String fdate[]= getFixtures.getDate_string();
        String fname[]= getFixtures.getFinalname();
        String fvenue[]= getFixtures.getVenue();
        String ftime[]= getFixtures.getTime();


        String showtime[] = ftime.clone();
        String showdate[] = fdate.clone();

        String fname1,fname2;
        String vs="VS";
        if (fname[position].contains("vs")){
            vs="vs";
        }else if(fname[position].contains("Vs")){
            vs = "Vs";
        }
        String[] currentVerses=fname[position].split(vs);
        fname1= currentVerses[0].replaceAll("\\s+$", "");
        fname2 = currentVerses[1].trim();


        //tl1.setImageResource(images[position]);
        //tl2.setImageResource(images[position]);








        fdate[position]=fdate[position].replaceAll("-2018","");


     //   Date currentDate = Calendar.getInstance().getTime();
     //   Log.i("ORIGINAL SYSTEM DATE",currentDate.toString());

        ///   Calendar trycalender = Calendar.getInstance();
        ///  trycalender.set(trycalender.get(Calendar.MONTH),Calendar.APRIL,9);

        //LocalDate trydate = LocalDate(2012, 04, 4);



//        Format dateFormatter = new SimpleDateFormat("dd-MM");
//        String s =dateFormatter.format(currentDate);
//

        //  Log.i("TRY DATE ",dateFormatter.format(trycalender));


/*        if(fdate[position].contains("April")){
            fdate[position]=fdate[position].replaceAll("April","04");
        }else if(fdate[position].contains("May")){
            fdate[position]=fdate[position].replaceAll("May","05");
        }
*/

        //reformat date for checking





/*

        Format checkFormatter = new SimpleDateFormat("MMdd");
//        String newfdate = checkFormatter.format(fdate[position]);
        String newsdate = checkFormatter.format(currentDate);
        String newfdate="";
        if(fdate[position].contains("April")){
            fdate[position]="04"+fdate[position];
            newfdate=fdate[position].replaceAll("-April","");
        }else if(fdate[position].contains("May")){
            fdate[position]="05"+fdate[position];
            newfdate=fdate[position].replaceAll("-May","");
        }

        Log.i("char at",String.valueOf(newfdate.charAt(0)));
        char[] fc = new char[4];
        if(Integer.parseInt(newfdate)<100){


            fc[0]=newfdate.charAt(0);
            fc[1]=newfdate.charAt(1);
            fc[2]=newfdate.charAt(2);
            //   fc[3]=newfdate.charAt(3);

            fc[3]=fc[2];
            fc[2]='0';
        }
        // newfdate = String.valueOf(fc);

        Log.i("new f date",String.valueOf(fc));

        Log.i("new s date ",newsdate);


        Log.i("SYSTEM DATE ",s);
        Log.i("MATCH DATE ",fdate[position]);
/*
        int arr=0;
        while(Integer.parseInt(fc.toString()) <= Integer.parseInt(newsdate)){


            String[] currentVerses1=fname[arr].split(vs);
            fname1= currentVerses1[0].replaceAll("\\s+$", "");
            fname2 = currentVerses1[1].trim();
            finalTeamName1[2]=fname1;
            finalTeamName1[1]=fname1;


            arr++;
        }

*/





int variablePosition = position;
String tryFdate = fdate[position] + " " + ftime[position] + ":00";

tryFdate=tryFdate.replace("-"," ");
tryFdate=tryFdate.replace("April","04");


Log.i("try f date",tryFdate);
Date currentDate = Calendar.getInstance().getTime();

Log.i("crr date",currentDate.toString());


SimpleDateFormat tryDateFormatter = new SimpleDateFormat("dd MM HH:mm:ss",Locale.US);


//Log.i("formated f date",tryDateFormatter.format(tryFdate));
        Date dateTypeFdate = null;
        Date dateTypeCdate = null;

        String formattedCdate = tryDateFormatter.format(currentDate);
try {
             dateTypeFdate = tryDateFormatter.parse(tryFdate);
    dateTypeCdate = tryDateFormatter.parse(formattedCdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Log.i("CONVERTED F IN D FORMAT",String.valueOf(dateTypeFdate));
        Log.i("CONVERTED C IN D FORMAT",String.valueOf(dateTypeCdate));

String tryDate = "8 04 15:01:00";
        Date   tryDateinDate=null;
        try {
            tryDateinDate = tryDateFormatter.parse(tryDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.i("CONVERTED try IN D FORM",String.valueOf(tryDateinDate));


        //  assert dateTypeFdate != null;
        if (dateTypeFdate.before(dateTypeCdate)) {
            System.out.println("fDAte is before CDate");
        } else if (dateTypeFdate.after(dateTypeCdate)) {
            System.out.println("fDAte is after CDate");
        }else {
            System.out.println("Something weird happened...");
        }



//
//        if (dateTypeFdate.before(tryDateinDate)) {
//            System.out.println("fDAte is before CDate");
//        } else if (dateTypeFdate.after(tryDateinDate)) {
//            System.out.println("fDAte is after CDate");
//        }else {
//            System.out.println("Something weird happened...");
//        }
//






        //   Date parsedfDate = null;
//        try {
//            parsedfDate= tryDateFormatter.parse(tryFdate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

      //  String parsedfDate = tryDateFormatter.format(tryFdate);
//        String parsedCDate = tryDateFormatter.format(currentDate);


        // Log.i("trying f date",  String.valueOf(parsedfDate));
     //   tryFdate=tryDateFormatter.format(parsedfDate);

//
//        Date DateFdate = null;
//        Date DateCdate=null;
//        try {
//            DateFdate = tryDateFormatter.parse(tryFdate);
//            DateCdate = tryDateFormatter.parse(parsedCDate);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Date DateCdate = currentDate;


//        String tryCdate = tryDateFormatter.format(currentDate);
//        Log.i("trying f date",  tryDateFormatter.format(parsedfDate));
//
//        Log.i("trying crr date", (String) tryDateFormatter.format(currentDate));

//        String finalTryFdate = "08 04 16:00:00";
//        String finalTryCdate = "01 05 16:00:00";
//
//        Log.i("trying f date",  String.valueOf(DateFdate));
//
//        Log.i("trying crr date", String.valueOf(DateCdate));








        //tryFdate  = tryDateFormatter.parseObject(tryFdate);


//        try {
//          //  Date datefdate = tryDateFormatter.parseObject(tryFdate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }














        switch (fname1){
            case "KKR":tl1.setImageResource(R.drawable.kolkata);break;
            case "DD":tl1.setImageResource(R.drawable.delhi);break;
            case "MI":tl1.setImageResource(R.drawable.mumbai);break;
            case "KXIP":tl1.setImageResource(R.drawable.punjab);break;
            case "RR":tl1.setImageResource(R.drawable.rajasthan);break;
            case "SRH":tl1.setImageResource(R.drawable.hyderabad);break;
            case "RCB":tl1.setImageResource(R.drawable.bangalore);break;
            case "CSK":tl1.setImageResource(R.drawable.chennai);break;
            default:tl1.setImageResource(R.drawable.ques);break;

        }
        switch (fname2){
            case "KKR":tl2.setImageResource(R.drawable.kolkata);break;
            case "DD":tl2.setImageResource(R.drawable.delhi);break;
            case "MI":tl2.setImageResource(R.drawable.mumbai);break;
            case "KXIP":tl2.setImageResource(R.drawable.punjab);break;
            case "RR":tl2.setImageResource(R.drawable.rajasthan);break;
            case "SRH":tl2.setImageResource(R.drawable.hyderabad);break;
            case "RCB":tl2.setImageResource(R.drawable.bangalore);break;
            case "CSK":tl2.setImageResource(R.drawable.chennai);break;
            default:tl2.setImageResource(R.drawable.ques);break;

        }







    //    tl1.setImageResource(R.drawable.bangalore);
      //  tl2.setImageResource(R.drawable.chennai);


        tn1.setText(fname1);
        tn2.setText(fname2);
    //    venue.setText(fvenue[position]);
        showdate[position]=fdate[position].replaceAll("-2018","");

        String dateTime = showdate[position]+" ,"+showtime[position];
        date.setText(dateTime);

     //   imageView.setImageResource(images[position]);













        ViewPager vp = (ViewPager) container;
        vp.addView(view,0);
       // vp.setCurrentItem(1);

        return view;

    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}


