package com.amalthea.amalthea.amalthea18;


import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class frag6 extends Fragment {
    private RecyclerView mRecyclerView;
    private Spons_Adapter mSpons_adapter;

    public frag6() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View mView =  inflater.inflate(R.layout.fragment_frag6, container, false);

        TextView imageView12= (TextView) mView.findViewById(R.id.sponsimg);

        AnimationDrawable animationDrawable = (AnimationDrawable) imageView12.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        final ArrayList<Sponsobj> mArraylist = new ArrayList<>();
        mRecyclerView = (RecyclerView)mView.findViewById(R.id.recyclerview_spons);
        final Spons_Adapter mAdapter = new Spons_Adapter(mArraylist);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        db.setFirestoreSettings(settings);
        db.collection("Sponsors").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    for (DocumentSnapshot documentSnapshot : task.getResult()){
                        HashMap<String,Object> mList = (HashMap<String, Object>) documentSnapshot.getData();
                        int n = mList.size();
                        Log.e("spons", "onComplete: "+ mList.get("url"));
                        int i = 0;
                        ArrayList<String> mURl = (ArrayList<String>) mList.get("url");

                        mArraylist.add(new Sponsobj(mList.get("name").toString(),mURl));
                        mRecyclerView.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();
                    }
            }
        });

        Button btn = (Button) mView.findViewById(R.id.button_subscribe);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getContext(), subscribe.class);
                startActivity(myIntent);
            }
        });
        return mView;
    }

}

