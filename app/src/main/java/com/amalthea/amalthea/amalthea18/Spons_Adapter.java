package com.amalthea.amalthea.amalthea18;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Spons_Adapter extends RecyclerView.Adapter<Spons_Adapter.ViewHolder>{
    private Context mContext;
    private ArrayList<Sponsobj> mUrls;
    private LayoutInflater inflater;

    public Spons_Adapter(){

    }

    public Spons_Adapter(ArrayList<Sponsobj> urls) {
        mUrls = urls;
    }


    @Override
    public Spons_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.spons_grid, parent, false);
        mContext = parent.getContext();
        return new Spons_Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Spons_Adapter.ViewHolder holder, int position) {
        final String name = mUrls.get(position).getName();
        final ArrayList<String> urls = mUrls.get(position).getUrls();
        holder.setTextView(name);
        Log.e("TAG", "onBindViewHolder: " + urls.size());
        holder.setRecyclerView(urls);
    }

    @Override
    public int getItemCount() {
        return mUrls.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private View mView;
        private RecyclerView mRecyclerView;
        private TextView mTextView;
        private Spoons_grid_Adapter mSpoons_grid_adapter;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mContext = itemView.getContext();
        }

       public void setRecyclerView(final ArrayList<String> URL){
            mRecyclerView = (RecyclerView) mView.findViewById(R.id.recycler_spons_grid);
            mSpoons_grid_adapter = new Spoons_grid_Adapter(URL);
            Log.e("TAG", "setRecyclerView: " + URL.size() );
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mView.getContext(),2);
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (URL.size()==1) {
                        return 2;
                    }else if((URL.size()%2 == 1 && position == URL.size()-1)){
                        Log.e("TAG", "getSpanSize: " + "Hogya" );
                        return 2;
                    }
                    return 1;
                }
            });
            mRecyclerView.setAdapter(mSpoons_grid_adapter);
            mRecyclerView.setLayoutManager(gridLayoutManager);
            mRecyclerView.setHasFixedSize(true);
            mSpoons_grid_adapter.notifyDataSetChanged();

        }

        public void setTextView(String text){
            mTextView = (TextView) mView.findViewById(R.id.textView15);
            mTextView.setText(text);
        }


    }


}

