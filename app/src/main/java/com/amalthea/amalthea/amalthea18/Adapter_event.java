package com.amalthea.amalthea.amalthea18;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;





public class Adapter_event extends RecyclerView.Adapter<Adapter_event.myViewholder> {

    Context mContext;
    List<items> mData;




    public Adapter_event(Context mContext, List<items> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    //public void onClick(View view) {
    //    mContext.startActivity(new Intent(mContext,NewMain_event.class));
    //}

    public interface RecyclerViewClickListener {
        public void recyclerViewListClicked(View v, int position);
    }

    @NonNull
    @Override
    public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.card_item,parent,false);
        //v.setOnClickListener(this);
        Log.e("chutiyap", "onCreateViewHolder: " );


        return new myViewholder(v);
    }


    @Override


    public void onBindViewHolder(final myViewholder holder, final int position) {

        holder.background.setImageResource(mData.get(position).getBackground());
        holder.parentlayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //mContext.startActivity(new Intent(mContext,NewMain_event.class));
                Intent intent1= new Intent(mContext,NewMain_event.class);
                intent1.putExtra("movie_id",position);
                mContext.startActivity(intent1);
                Log.e("chutiyap", "onCreateViewHolder: " );


            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class myViewholder extends RecyclerView.ViewHolder{

        ImageView background;
        ConstraintLayout parentlayout;

        public myViewholder(View itemView) {
            super(itemView);
            background = itemView.findViewById(R.id.events_image_view);
            parentlayout = itemView.findViewById(R.id.parentlayout);
            Log.e("chutiyap", "onCreateViewHolder: " );


        }
    }
}
