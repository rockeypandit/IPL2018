package com.example.rockeypandit.ipl2018;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TeamInfo extends AppCompatActivity {
    ImageView teamInfoImage;
    int pos[] = new int[30];
    int inc;

    public class CustomList extends ArrayAdapter<String>{

        private final Activity context;
        private final String[] pName;
        private final Integer[] imageId;
        public CustomList(Activity context,String[] pName, Integer[] imageId) {
            super(context, R.layout.player_status, pName);
            this.context = context;
            this.pName = pName;
            this.imageId = imageId;

        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView= inflater.inflate(R.layout.player_status,null, true);
            TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
            ImageView imageView1 = (ImageView) rowView.findViewById(R.id.img1);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
           // String tempName=pName[position];
            if(pName[position].contains("(in)")){
                pName[position] = pName[position].replace("(in)","");

            }

            if(pName[position].contains("captain")) {
                pName[position] = pName[position].replace(" (captain)","");

            }

            if(pName[position].contains("Steve Smith")||pName[position].contains("David Warner")){
                imageView1.setImageResource(R.drawable.airplane);

            }

            txtTitle.setText(pName[position]);
            imageView.setImageResource(imageId[position]);



            return rowView;
        }
    }


    public static void getListViewSize(ListView myListView ,Context context) {
        ListAdapter myListAdapter = myListView.getAdapter();

        if (myListAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int size = 0; size < myListAdapter.getCount(); size++) {

            View listItem = myListAdapter.getView(size, null, myListView);

            if (listItem instanceof ViewGroup)
                listItem.setLayoutParams(new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT));


            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            @SuppressWarnings("deprecation")
            int screenWidth = display.getWidth();
            int listViewWidth = screenWidth - 65;
            int widthSpec = View.MeasureSpec.makeMeasureSpec(listViewWidth,View.MeasureSpec.AT_MOST);
            listItem.measure(widthSpec, 0);

            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = myListView.getLayoutParams();
        params.height = totalHeight+ (myListView.getDividerHeight() * (myListAdapter.getCount() - 1));
        myListView.setLayoutParams(params);
        myListView.requestLayout();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_info);


        teamInfoImage = (ImageView) findViewById(R.id.teamInfLogo);


        inc=0;

        ListView teamList = (ListView) findViewById(R.id.teamList);

        String chennaiTeam1 = "MS Dhoni (captain), Suresh Raina, Ravindra Jadeja, Faf du Plessis(in), Harbhajan Singh, Dwayne Bravo(in), Shane Watson(in), Kedar Jadhav, Ambati Rayudu, Imran Tahir(in), Karn Sharma, Shardul Thakur, N Jagdeesan, Mitchell Santner(in), Deepak Chahar, KM Asif, Lungisani Ngidi(in), Kanishk Seth, Dhruv Shorey, Murali Vijay, Sam Billings(in), Mark Wood(in), Kshitiz Sharma, Monu Kumar, Chaitanya Bishnoi";
        String mumbaiTeam2 = "Rohit Sharma (captain), Hardik Pandya, Jasprit Bumrah, Keiron Pollard(in), Mustafizur Rahman(in), Pat Cummins(in), Suryakumar Yadav, Krunal Pandya, Ishan Kishan, Rahul Chahar, Evin Lewis(in), Saurabh Tiwary, Ben Cutting(in), Pradeep Sangwan, JP Duminy(in), Jason Behrendorff(in), T N Dhillon, Sharad Lumba, Aditya Tare, Mayank Markande, Akila Dananjaya(in), Anukul Sudhakar Roy, Mohsin Khan, MD Nidheesh";
        String bangaloreTeam3 = "Virat Kohli (captain), AB de Villiers(in), Sarfaraz Khan, Brendon McCullum(in), Chris Woakes(in), Colin de Grandhomme(in), Moeen Ali(in), Quinton de Kock(in), Umesh Yadav, Yuzvendra Chahal, Manan Vohra, Kulwant Khejroliya, Aniket Choudhary, Navdeep Saini, Murugan Ashwin, Mandeep Singh, Washington Sundar, Pawan Negi, Mohammed Siraj, Nathan Coulter-Nile(in), Anirudha Joshi, Parthiv Patel, Tim Southee(in), Pavan Deshpande";

        String kolkataTeam4="Dinesh Karthik (captain), Andre Russell(in), Sunil Narine(in), Mitch Starc(in), Chris Lynn(in), Robin Uthappa, Piyush Chawla, Kuldeep Yadav, Shubman Gill, Ishank Jaggi, Kamlesh Nagarkoti, Nitish Rana, Vinay Kumar, Apoorv Wankhade, Rinku Singh, Shivam Mavi, Cameron Delport(in), Mitchell Johnson(in), Javon Searles(in)";
        String punjabTeam5="Ravichandran Ashwin (captain), Axar Patel, Yuvraj Singh, Karun Nair, KL Rahul, David Miller(in), Aaron Finch(in), Marcus Stoinis(in), Mayank Agarwal, Ankit Rajpoot, Manoj Tiwary, Mohit Sharma, Mujeeb Zadran(in), Barinder Sran, Andrew Tye(in), Akshdeep Nath, Ben Dwarshuis(in), Pardeep Sahu, Mayank Dagar, Chris Gayle(in), Manzoor Dar";
        String hyderabadTeam6="David Warner (captain)(in), Bhuvneshwar Kumar, Shikhar Dhawan, Shakib Al Hasan(in), Kane Williamson(in), Manish Pandey, Carlos Brathwaite(in), Yusuf Pathan, Wriddhiman Saha, Rashid Khan(in), Ricky Bhui, Deepak Hooda, T Natarajan, Siddarth Kaul, Khaleel Ahmed, Mohammad Nabi(in), Sandeep Sharma, Sachin Baby, Chris Jordan(in), Billy Stanlake(in), Tanmay Agarwal, Shreevats Goswami, Bipul Sharma, Mehdi Hasan";

        String delhiTeam7="Gautham Gambhir (captain), Shreyas Iyer, Rishabh Pant, Chris Morris(in), Glenn Maxwell(in), Jason Roy(in), Colin Munro(in), Mohammed Shami, Kagiso Rabada(in)    , Amit Mishra, Prithvi Shaw, Rahul Tewatia, Vijay Shankar, Harshal Patel, Avesh Khan, Shahbaz Nadeem, Daniel Christian(in), Jayant Yadav, Gurkeerat Singh Mann, Trent Boult(in), Manjot Kalra, Abhishek Sharma, Sandeep Lamichhane(in), Naman Ojha, Sayan Ghosh";
        String rajasthanTeam8="Steve Smith (captain)(in), Ben Stokes(in), Ajinkya Rahane, Stuart Binny, Sanju Samson, Jos Buttler(in), Rahul Tripathi, D’Arcy Short(in), Jofra Archer(in), Krishnappa Gowtham, Dhawal Kulkarni, Jaydev Unadkat, Ankit Sharma, Anureet Singh, Zahir Khan(in), Shreyas Gopal, S Midhun, Prashant Chopra, Ben Laughlin(in), Mahipal Lomror, Aryaman Birla, Jatin Saxena, Dushmantha Chameera(in)";
        String getName = getIntent().getStringExtra("teamvalue");
        String[] team={};



        switch(getName){
            case "1":   teamInfoImage.setImageResource(R.drawable.edtchennai);
                        team = chennaiTeam1.split(", ");break;
            case "2":   teamInfoImage.setImageResource(R.drawable.edtmumbai);
                        team=mumbaiTeam2.split(",");break;
            case "3":   teamInfoImage.setImageResource(R.drawable.edtbangalore);
                        team=bangaloreTeam3.split(",");break;
            case "4":   teamInfoImage.setImageResource(R.drawable.edtkolkata);
                        team=kolkataTeam4.split(",");break;
            case "5":   teamInfoImage.setImageResource(R.drawable.edtpunjab);
                        team=punjabTeam5.split(",");break;
            case "6":   teamInfoImage.setImageResource(R.drawable.edthyd);
                        team=hyderabadTeam6.split(",");break;
            case "7":   teamInfoImage.setImageResource(R.drawable.edtdelhi);
                        team=delhiTeam7.split(",");break;
            case"8":    teamInfoImage.setImageResource(R.drawable.edtrajasthan);
                        team=rajasthanTeam8.split(",");


        }

        for (int i=0;i<team.length;i++) {
            if (team[i].contains("(in)")) {
                pos[inc] = i;
                inc++;
            }
        }
        inc=0;

        //team = names.split(", ");
        Integer img[] = new Integer[team.length];
        for(int i = 0;i<team.length;i++){
            if(team[i].contains("captain"))
                img[i]=R.drawable.captian;
            else if(team[i].contains("(in)")){
                img[i]=R.drawable.airplane;
            }
            else
                img[i]=0;
        }

        CustomList adapter1 = new CustomList(this, team, img);


        teamList.setAdapter(adapter1);
        getListViewSize(teamList,this);


    }
}
