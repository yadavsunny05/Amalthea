package com.amalthea.amalthea.amalthea18;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Exhi_recycler extends RecyclerView.Adapter<Exhi_recycler.ViewHolder> {
    public Context mContext;
    public ArrayList<Exhi_Adapter> mExhi_adapters;

    public Exhi_recycler() {
    }
    public Exhi_recycler(ArrayList<Exhi_Adapter> mExhi_adapters){

        this.mExhi_adapters = mExhi_adapters;
    }
    @Override
    public Exhi_recycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.exhi_card, parent, false);
        return new Exhi_recycler.ViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull Exhi_recycler.ViewHolder holder, int position) {
        final String img = mExhi_adapters.get(position).getImg().toString();
        final String name = mExhi_adapters.get(position).getName().toString();
        final String url = mExhi_adapters.get(position).getUrl().toString();
        final String details = mExhi_adapters.get(position).getDetails().toString();


        holder.setImageView(img);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(mContext);
                dialog.setContentView(R.layout.dialog_exhi);
                dialog.setCanceledOnTouchOutside(true);
                dialog.setCancelable(true);

                TextView t1 = dialog.findViewById(R.id.exi_dialogtext3);
                TextView t2 = dialog.findViewById(R.id.exi_dialogtext4);
                ImageView I1 = dialog.findViewById(R.id.exi_dialog_img);
                Button b1 = dialog.findViewById(R.id.exi_button);
                t1.setText(name);
                t2.setText(details);
                Picasso.get().load(img).fit().into(I1);
                dialog.show();
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        mContext.startActivity(i);}
                });


            }
        });


    }

    @Override
    public int getItemCount() {
        return mExhi_adapters.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private View mView;
        private ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mContext = itemView.getContext();
        }

        public void setImageView(String img){
            mImageView = mView.findViewById(R.id.exhi_image);
            Picasso.get().load(img).fit().centerInside().into(mImageView);

        }
    }

    }
