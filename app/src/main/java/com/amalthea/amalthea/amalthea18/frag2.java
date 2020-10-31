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


/**
 * A simple {@link Fragment} subclass.
 */
public class frag2 extends Fragment {

    private RecyclerView mRecyclerView1;
    private RecyclerView mRecyclerView2;
    private ArrayList<Speaker> list1 = new ArrayList<>();
    private ArrayList<Speaker> list2 = new ArrayList<>();
    private Conclave_Recycler mRecyclerAdapter;
    private Conclave_Recycler mConclave_recycler2;



    public frag2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag2, container, false);
        final ArrayList<Speaker> speakers = new ArrayList<>();
        final ArrayList<Speaker> speakers1 = new ArrayList<>();

        mRecyclerAdapter = new Conclave_Recycler(speakers);
        mConclave_recycler2 = new Conclave_Recycler(speakers1);

        TextView imageView12= (TextView) view.findViewById(R.id.imageView51);

       AnimationDrawable animationDrawable = (AnimationDrawable) imageView12.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();





        mRecyclerView1 = (RecyclerView) view.findViewById(R.id.recycler1);
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView1.setLayoutManager(manager);
        mRecyclerView1.setHasFixedSize(true);
        final LinearLayoutManager manager2 = new LinearLayoutManager(getContext());

        mRecyclerView2 = (RecyclerView) view.findViewById(R.id.recycler2);
        mRecyclerView2.setLayoutManager(manager2);
        mRecyclerView2.setHasFixedSize(true);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        db.setFirestoreSettings(settings);

        db.collection("Conclave Past")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                speakers.add(document.toObject(Speaker.class));

                                Log.e("TAG", document.getId() + " => " + document.getData());
                                Log.e("TAG", "onSuccess: "+ speakers.size());
                                mRecyclerView1.setAdapter(mRecyclerAdapter);
                                mRecyclerAdapter.notifyDataSetChanged();

                            }
                        } else {
                            Log.e("TAG", "onComplete: " + task.getException().toString());
                        }
                    }
                });


        Log.e("TAG", "onSuccess: "+ speakers.size());

        db.collection("Conclave Present").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot document : task.getResult()) {
                        speakers1.add(document.toObject(Speaker.class));
                        mRecyclerView2.setAdapter(mConclave_recycler2);
                        mConclave_recycler2.notifyDataSetChanged();

                    }

                }
                else{

                }
            }
        });



        Button btn = (Button) view.findViewById(R.id.button_subscribe);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getContext(), subscribe.class);
                startActivity(myIntent);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }





}
