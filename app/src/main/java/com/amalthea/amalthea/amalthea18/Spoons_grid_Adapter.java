package com.amalthea.amalthea.amalthea18;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Spoons_grid_Adapter extends RecyclerView.Adapter<Spoons_grid_Adapter.ViewHolder> {
    private Context mContext;
    private ArrayList<String> mUrls;

    public Spoons_grid_Adapter(){

    }

    public Spoons_grid_Adapter(ArrayList<String> urls) {
        mUrls = urls;
    }


    @Override
    public Spoons_grid_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.exhi_card, parent, false);
        return new Spoons_grid_Adapter.ViewHolder(v);
    }


    @Override
    public int getItemCount() {
        return mUrls.size();
    }

    @Override
    public void onBindViewHolder(@NonNull Spoons_grid_Adapter.ViewHolder holder, int position) {
        final String url = mUrls.get(position).toString();
        holder.ImageView(url);
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        private View mView;
        private ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mContext = itemView.getContext();
        }

        public void ImageView(String url) {
            mImageView = (ImageView) mView.findViewById(R.id.exhi_image);
            Picasso.get().load(url).fit().centerInside().into(mImageView);

        }


    }
}
