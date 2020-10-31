package com.amalthea.amalthea.amalthea18;


import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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
public class frag4 extends Fragment {
    private RecyclerView mRecyclerView;
    private Exhi_recycler mExhi_recycler;



    public frag4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView =  inflater.inflate(R.layout.fragment_frag4, container, false);
        final ArrayList<Exhi_Adapter> mExhi_adapters = new ArrayList<>();

        TextView imageView12= (TextView) mView.findViewById(R.id.imageView5);

        AnimationDrawable animationDrawable = (AnimationDrawable) imageView12.getBackground();
        animationDrawable.setEnterFadeDuration(0);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        mExhi_recycler = new Exhi_recycler(mExhi_adapters);
        mRecyclerView =  (RecyclerView)mView.findViewById(R.id.exhi_recycler);

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setHasFixedSize(true);


        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        db.setFirestoreSettings(settings);

        db.collection("Exhibition")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot documentSnapshot : task.getResult()){
                            mExhi_adapters.add(documentSnapshot.toObject(Exhi_Adapter.class));
                            mRecyclerView.setAdapter(mExhi_recycler);
                            mExhi_recycler.notifyDataSetChanged();

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
