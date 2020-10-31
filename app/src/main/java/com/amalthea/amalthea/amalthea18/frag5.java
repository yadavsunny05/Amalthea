package com.amalthea.amalthea.amalthea18;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




/**
 * A simple {@link Fragment} subclass.
 */
public class frag5 extends Fragment {

    private ViewPager viewPager;
    private SlideAdapter myadapter;
    int i;

    public frag5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        final View view = inflater.inflate(R.layout.fragment_frag5, container, false);
        // Inflate the layout for this fragment

        RecyclerView recyclerView =  view.findViewById(R.id.recycler_view_event);


        recyclerView.setNestedScrollingEnabled(false);


        List<items> mlst = new ArrayList<>();
        Adapter_event adapter = new Adapter_event(getContext() ,mlst);
        mlst.add(new items(R.drawable.dcode));
        mlst.add(new items(R.drawable.electr));
        mlst.add(new items(R.drawable.drs));
        mlst.add(new items(R.drawable.icon));

        mlst.add(new items(R.drawable.inqui));

        mlst.add(new items(R.drawable.robo));
        mlst.add(new items(R.drawable.seis));
        mlst.add(new items(R.drawable.tech));
        mlst.add(new items(R.drawable.ta));


        recyclerView.setAdapter(adapter);
        Log.w("TAG", "onCreateView: "+ mlst.size() );
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);

        TextView imageView12= (TextView) view.findViewById(R.id.imageView5);

        AnimationDrawable animationDrawable = (AnimationDrawable) imageView12.getBackground();
        animationDrawable.setEnterFadeDuration(0);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();




/**
 * Created by Rohit Patil on 11-08-2018.
 */
        return view;

    }

}
