package com.amalthea.amalthea.amalthea18;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    // list of images
    public int[] lst_images = {
            R.drawable.dcode,
            R.drawable.electr,
            R.drawable.drs,
            R.drawable.icon,
            R.drawable.inqui,
            R.drawable.robo,
            R.drawable.seis,
            R.drawable.tech,
            R.drawable.ta


    };
    // list of titles
    public String[] lst_title = {

" 'The effective exploitation of his powers of abstraction must be regarded as one of the most vital activities of a competent'. -Edsger Dijkstra"
,"Think outside the circuit!\n" +
            "\n"
            ,"“Join us as we experience the battle between the professionals.”"
            ,"“Innovation distinguishes between leaders and followers.”\n"
            ,"“LOVE QUIZZING ?? IT’S TIME TO GET InQuizzed !!!”"
            ,"“War does not determine who is right-only who is left.” - Bertrand Russell\n"
            ,"“In an earthquake, I shouldn't run out of the house - I should run into it.”\n"
            ,"\n" +
            "‘’Each one thinks in his own way, that’s what makes him Unique”\n"
            ,"“Art” is an application of human creative skill and imagination.\n"
}   ;
    // list of descriptions
    public String[] lst_description = {"Don’t miss an opportunity to test your grit in algorithms and win some exciting prizes. D’code aims to foster coding talent in the world. It is an online programming contest with wide range of competitors from students to professionals. Combine your knowledge in different categories of competitive programming and construct efficient algorithms to win the title. Dare to compete and conquer the coding world.",
            "Electronica is conducted for electronics enthusiasts, to test their fundamental knowledge of electronics and electrical concepts. The event tests basic concept clarity of the students and their ability to apply it in real world problems.\n" +
                    "Electronica is carried out in form of a theory round and a practical hands-on round, testing your ability to put your knowledge to use along with loads of brain teasers and riddles of electronics that will have you stumped. So, for all the electro – enthusiasts out there, register and grab your chance to win lots of prizes!",
            "\n" +
                    "We are back with the third season of DRA, the first drone racing ever held in India. So, gear up for an unparalleled aerial racing competition as the best pilots assemble to battle it out where it all began. \n" +
                    "A thrilling do-or-die tournament where professionals from all over India showcase their drone racing skills in an exquisitely constructed arena.\n" +
                    "What’s more, you can come along and experience the thrill for free!"

            ," \n" +
            "ICon or Innovation Conference is an event which aims to provide a platform for the interaction of the creativity and passion of the participants with the experts of a field. The participants shall have to come up with technical project ideas regarding or related to a particular subject or field which they will have to present in front of a panel. So, if you have an idea that you think can change the world, participate in ICon at Amalthea and make the world a better place!\n"
            ,"Highly established as one of the best open quizzing competitions in India, Amalthea ’18  brings back to you the game of the best brains. Raising the bar of quizzing with questionnaire based on topics ranging from Current Affairs to Entertainment, Geography and History to Logical and Brainteasers, Science and Technology and Sports. Register for free and get a golden opportunity to visit the Sabarmati Campus, IIT Gandhinagar. Win and earn exciting goodies and a cash prize as well.\n" +
            " So pull up your socks and let’s get InQuizzed !!!"
            ,"Roboventure consists of two separate events.\n\n" +
            "  Drift\n" +
            "\n" +
            " “Are you a F1 racing lover?? Ever felt the throttle of the real RC Engines?”\n" +
            "Drift at Amalthea has one of the best arenas in Ahmedabad for RC racers. Drift is the only event of its kind in Ahmedabad. What are you waiting for then? Grab your cars and showcase your racing skills on the land of Ahmedabad.\n" +
            "\n" +
            "Roboquest \n" +
            "\n" +

            "\n" +
            "“Are you a tinkerer? Love making robots?” Then roboquest is right place for you to showcase your skills. Roboquest has been part of Amalthea since its inception. Over the year it has changed identities, some time drastically and sometimes subtly.  But one thing is for sure- that event has grown in scale and the difficulty and so has the response.and we expect this year to be even better. Build your robots with extraordinary skills to overcome your opponents and challenges. The task will check every aspects of robot speed, precision, strength and logic. \n" +
            "\n"
            ,"These words of Tony Danza reflect the standards we should expect from our budding civil engineers and architects.\n" +
            "So, are you ready to test your inner structural design skills?\n" +
            "If yes, get ready to build an earthquake resistant model that can withstand an earthquake shake table. Be in the run with other participants for the title of 'Seismism’ and win exciting prizes. Register today!\n"
            ,"TKQ is an online logic-based event where participants need to answer a variety of questions in the given time limit. It consists of two different sub-events, LOGIX and CRYPTIC.\n" +
            "\n" +
            "In Logix, brain teasers and puzzles block your path to victory. Rack your brains to tear down these obstacles. But don’t tear out your hair! And, after a successful first season, 'CRYPTIC' is back this year with its second iteration. This event will be focused on cryptography which will require you to exercise your grey cells. Can you break the code without breaking your head?\n" +
            "\n" +
            "So get ready to turn on the gears in your brain, churn out all your knowledge and burn the midnight oil as you use your imagination to go beyond logic.\n" +
            "\n" +
            "Details on the URL on which the event will be hosted will be announced later. Register now and stay glued to the website for updates. Meanwhile, we will post sample questions so that you can get a feel of the event."
            ,"Keeping this in mind, Amalthea ’18 brings you a brand new iteration of “TECHARTS”.\n" +
            "Techarts is a two-day enthralling event that brings out the inner technical artist of an individual using Brain Teasers and Puzzles which are fun, logical and challenge your problem-solving skills in a unique way. They are based on basic concepts of Technical subjects like Mathematics, Physics as well as implementing algorithms etc.\n" +
            "The Participant should untangle the puzzle within the given time bound.\n"
};
    public String[] register_links = {"https://goo.gl/forms/xFK2lIOyzi9NvooO2",
            "https://goo.gl/forms/yWHFvoTtftjl0o3p2",
            "https://goo.gl/forms/Rn9NugSutgh33ky82",
            "https://docs.google.com/forms/d/e/1FAIpQLSdHcNpRPv0oYG7LTmpJYpMnHzrRhraba-aRyiWkebeISWT8lg/viewform?c=0&w=1",
            "https://goo.gl/forms/XYzrsuNsU5Y148Io2",
            "https://goo.gl/forms/8b2kip4ncNlDnpiF2",//drift,
          "https://goo.gl/forms/YwlaFcrM35pevOhk1",
            "https://goo.gl/forms/mv4T1wAeAzuggPGZ2",//cryptic
            "https://goo.gl/forms/ckLXCDmDD3YMmZXn2",
            "https://goo.gl/forms/nbkxGor9zGU0MSg23",//RoboQuest
            "https://goo.gl/forms/O7wcQqwgnq5zksG63"//logix

    };
    public String[] rulebook_links = {
            "http://amalthea.iitgn.ac.in/Rulebooks/dCODE.pdf",
            "http://amalthea.iitgn.ac.in/Rulebooks/Electronica.pdf",
            "http://amalthea.iitgn.ac.in/Rulebooks/DRA%20Rulebook.pdf",
            "http://amalthea.iitgn.ac.in/Rulebooks/ICON.pdf",
            "http://amalthea.iitgn.ac.in/Rulebooks/inquizzed.pdf",
            "http://amalthea.iitgn.ac.in/Rulebooks/Drift.pdf",
            "http://amalthea.iitgn.ac.in/Rulebooks/Seismism.pdf",
            "http://amalthea.iitgn.ac.in/Rulebooks/TKQ_cryptic.pdf",
            "http://amalthea.iitgn.ac.in/Rulebooks/TechArts.pdf",
            "http://amalthea.iitgn.ac.in/Rulebooks/RoboQuest.pdf",
            "http://amalthea.iitgn.ac.in/Rulebooks/TKQ_logix.pdf"
    };
    // list of background colors
    public int[]  lst_backgroundcolor = {
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212),

            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212),
            Color.rgb(1,188,212),
            Color.rgb(1,188,212),


    };


    public SlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = (ImageView)  view.findViewById(R.id.slideimg);
        TextView txttitle= (TextView) view.findViewById(R.id.txttitle);
        TextView description = (TextView) view.findViewById(R.id.txtdescription);
        layoutslide.setBackgroundColor(lst_backgroundcolor[position]);
        imgslide.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        description.setText(lst_description[position]);
        container.addView(view);
        Button button1 = (Button) view.findViewById(R.id.button_register);
        Button button2 = (Button) view.findViewById(R.id.button_register_2);
        Button button3 = (Button) view.findViewById(R.id.button_rulebook);
        Button button4 = (Button) view.findViewById(R.id.button_rulebook_2);

        if (position==5){
            button1.setText("Register for DRIFT");
            button2.setText("Register for ROBOQUEST");
            button2.setVisibility(View.VISIBLE);

            button3.setText("Rulebook for DRIFT");

            button4.setText("Rulebook for ROBOQUEST");
            button4.setVisibility(View.VISIBLE);


            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(register_links[9]));
                    context.startActivity(i);
                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(rulebook_links[9]));
                    context.startActivity(i);
                }
            });
        }
        if (position==7){
            button1.setText("Register for CRYPTIC");
            button2.setText("Register for LOGIX");
            button2.setVisibility(View.VISIBLE);

            button3.setText("Rulebook for CRYPTIC");

            button4.setText("Rulebook for LOGIX");
            button4.setVisibility(View.VISIBLE);

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(register_links[10]));
                    context.startActivity(i);

                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(rulebook_links[10]));
                    context.startActivity(i);
                }
            });
        }



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(register_links[position]));
                context.startActivity(i);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(rulebook_links[position]));
                context.startActivity(i);
            }
        });
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
