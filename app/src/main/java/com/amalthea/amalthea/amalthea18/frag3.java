package com.amalthea.amalthea.amalthea18;


import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
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
public class frag3 extends Fragment {

    private RecyclerView mRecyclerView;
    private ArrayList<Speaker> mSpeakers;



    public frag3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag3, container, false);


        TextView imageView12= (TextView) view.findViewById(R.id.imageViewSymp);

        AnimationDrawable animationDrawable = (AnimationDrawable) imageView12.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        final ArrayList mSpeakers = new ArrayList<Speaker>();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclersymp);
        final Conclave_Recycler Adapter = new Conclave_Recycler(mSpeakers);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        db.setFirestoreSettings(settings);

        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);

        db.collection("Symposium").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(DocumentSnapshot documentSnapshot : task.getResult()){
                        mSpeakers.add(documentSnapshot.toObject(Speaker.class));
                        mRecyclerView.setAdapter(Adapter);
                        Adapter.notifyDataSetChanged();

                    }
                }else{

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
        return view;
    }

}
