package com.amalthea.amalthea.amalthea18;


import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class frag1 extends Fragment {



    public frag1() {
        // Required empty public constructor
        ViewPager mViewPager;
        ImageAdapter imageAdapter;


    }

    private static ViewPager mPager;
    private static ViewPager mPager2;
    public static boolean startSlider = true;
    public Timer swipeTimer = new Timer();
    private Button button;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.fragment_frag1, container, false);
        ImageView imageView1=(ImageView)view.findViewById(R.id.imageView5);
        //ImageView imageView = null;
        //imageView = (ImageView) imageView.findViewById(R.id.imageView5);
        //ImageView imageView = (ImageView) getView().findViewById(R.id.imageView5);
        //LinearLayout linearLayout = (LinearLayout) getView().findViewById(R.id.lol);
        //NestedScrollView nestedScrollView =(NestedScrollView) getView().findViewById(R.id.lol) ;
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        button = (Button) view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://amalthea.iitgn.ac.in/ca.php/"));
                startActivity(i);
            }
        });

        final ArrayList<Image> image = new ArrayList<>();
        final ArrayList<Speaker> mSpeakers = new ArrayList<>();



        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        db.setFirestoreSettings(settings);

        db.collection("Home").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for (DocumentSnapshot documentSnapshot : task.getResult()) {

                    image.add(documentSnapshot.toObject(Image.class));
                    Log.e("CHUTIYAP", "onComplete: " + image.get(0).getUrl().toString());
                    mPager = (ViewPager) view.findViewById(R.id.pager);
                    mPager.setAdapter(new ImageAdapter(getContext(), image));
                    TabLayout mTabLayout = (TabLayout) view.findViewById(R.id.tabDots_multiple);
                    mTabLayout.setupWithViewPager(mPager);
                }

                Button btn = (Button) view.findViewById(R.id.button_subscribe);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent myIntent = new Intent(getContext(), subscribe.class);
                        startActivity(myIntent);
                    }
                });

            }
        });


        db.collection("Home_Past").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot documentSnapshot : task.getResult()) {
                        mSpeakers.add(documentSnapshot.toObject(Speaker.class));
                        mPager2 = (ViewPager) view.findViewById(R.id.pager2);
                        mPager2.setAdapter(new SpeakerAdapter(getContext(), mSpeakers));
                        Log.e("ptani", "onComplete: " + mSpeakers.size());
                        TabLayout mTabLayout2 = (TabLayout) view.findViewById(R.id.tabDots_multiple2);
                        mTabLayout2.setupWithViewPager(mPager2);

                    }
                }
            }
        });

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                Integer mInt = mPager.getCurrentItem();
                if (mPager.getCurrentItem() == image.size() - 1) {
                    mInt = -1;
                }
                mInt++;
                mPager.setCurrentItem((mInt), true);
            }


        };

        swipeTimer = new Timer();
        swipeTimer.scheduleAtFixedRate((new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }),10000, 8000);



        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onDestroyView() {
        swipeTimer.cancel();
        super.onDestroyView();
    }
}
