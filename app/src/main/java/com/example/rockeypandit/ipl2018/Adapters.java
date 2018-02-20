package com.example.rockeypandit.ipl2018;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rockey pandit on 09-02-2018.
 */

public class Adapters extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    Context context;
    String[] finalname,venue,time;
    List<String> date;

    public Adapters(Context context, String[] items,List<String> date,String[] venue,String[] time) {
        this.context = context;
        this.finalname = items;
        this.date=date;
        this.venue=venue;
        this.time=time;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.cardview, parent, false);
        Item item = new Item(row);

        return item;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {



        String vs="VS";
        if (finalname[position].contains("vs")){
            vs="vs";
        }else if(finalname[position].contains("Vs")){
            vs = "Vs";
        }



        String[] currentVerses=finalname[position].split(vs);

        ((Item) holder).team1.setText(currentVerses[0]);
        ((Item) holder).team2.setText(currentVerses[1]);
        ((Item) holder).date.setText(date.get(position).toString());
        ((Item) holder).venue.setText("Venue:"+venue[position]+","+time[position]);

        currentVerses[0] = currentVerses[0].replaceAll("\\s+$", "");
        currentVerses[1] = currentVerses[1].trim();
        //   Log.i(currentVerses[0],currentVerses[1]);



        switch (currentVerses[0]){
            case "KKR":((Item) holder).logo1.setImageResource(R.drawable.kolkata);break;
            case "DD":((Item) holder).logo1.setImageResource(R.drawable.delhi);break;
            case "MI":((Item) holder).logo1.setImageResource(R.drawable.mumbai);break;
            case "KXIP":((Item) holder).logo1.setImageResource(R.drawable.punjab);break;
            case "RR":((Item) holder).logo1.setImageResource(R.drawable.rajasthan);break;
            case "SRH":((Item) holder).logo1.setImageResource(R.drawable.hyderabad);break;
            case "RCB":((Item) holder).logo1.setImageResource(R.drawable.bangalore);break;
            case "CSK":((Item) holder).logo1.setImageResource(R.drawable.chennai);break;
            default:((Item) holder).logo1.setImageResource(R.drawable.ic_launcher_background);break;

        }
        switch (currentVerses[1]){
            case "KKR":((Item) holder).logo2.setImageResource(R.drawable.kolkata);break;
            case "DD":((Item) holder).logo2.setImageResource(R.drawable.delhi);break;
            case "MI":((Item) holder).logo2.setImageResource(R.drawable.mumbai);break;
            case "KXIP":((Item) holder).logo2.setImageResource(R.drawable.punjab);break;
            case "RR":((Item) holder).logo2.setImageResource(R.drawable.rajasthan);break;
            case "SRH":((Item) holder).logo2.setImageResource(R.drawable.hyderabad);break;
            case "RCB":((Item) holder).logo2.setImageResource(R.drawable.bangalore);break;
            case "CSK":((Item) holder).logo2.setImageResource(R.drawable.chennai);break;
            default:((Item) holder).logo2.setImageResource(R.drawable.ic_launcher_background);break;

        }




    }

    @Override
    public int getItemCount() {
        return finalname.length;
    }

    public class Item extends RecyclerView.ViewHolder {
        TextView team1,team2,date,venue;
        ImageView logo1,logo2;


        public Item(View itemView) {
            super(itemView);
            team1 = itemView.findViewById(R.id.teamName1);
            team2 = itemView.findViewById(R.id.teamName2);
            date = itemView.findViewById(R.id.date);
            logo1 = itemView.findViewById(R.id.logo1);
            logo2 = itemView.findViewById(R.id.logo2);
            venue=itemView.findViewById(R.id.venue);


        }
    }
}



