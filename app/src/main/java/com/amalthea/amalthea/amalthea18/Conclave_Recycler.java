package com.amalthea.amalthea.amalthea18;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Conclave_Recycler extends RecyclerView.Adapter<Conclave_Recycler.ViewHolder> {
    public Context mContext;
    public ArrayList<Speaker> mSpeakers;
    public Conclave_Recycler(ArrayList<Speaker> mSpeakers){
        this.mSpeakers = mSpeakers;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.speakercard, parent, false);
        return new ViewHolder(v);
    }


    public interface CustomItemClickListener {
        public void onItemClick(View v, int position);
    }



    @Override
    public void onBindViewHolder(@NonNull final Conclave_Recycler.ViewHolder holder, final int position) {
        final String mTextView = mSpeakers.get(position).getName();
        final String mUrl = mSpeakers.get(position).getUrl();
        final String mDetails = mSpeakers.get(position).getDetails();
        final String mJob = mSpeakers.get(position).getJob();
        final String mUniv = mSpeakers.get(position).getUniv();
        holder.setImage(mUrl);
        holder.setText(mTextView,mJob,mUniv);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(mContext);
                dialog.setTitle(mSpeakers.get(position).getName());
                dialog.setCanceledOnTouchOutside(true);
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.dialog_box);
                TextView t1 = (TextView)dialog.findViewById(R.id.dialogtext1);
                TextView t2 = (TextView)dialog.findViewById(R.id.dialogtext2);
                TextView t3 = (TextView)dialog.findViewById(R.id.dialogtext3);
                TextView t4 = (TextView)dialog.findViewById(R.id.dialogtext4);
                CircleImageView I1 = (CircleImageView)dialog.findViewById(R.id.dialogimage1);
                t1.setText(mUniv);
                t2.setText(mJob);
                t3.setText(mTextView);
                t4.setText(mDetails);
                Picasso.get().load(mUrl).fit().into(I1);
                dialog.show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return mSpeakers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View mView;

        private TextView mTextView1;
        private TextView mTextView2;
        private TextView mTextView3;
        private CircleImageView mCircleImageView;


        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mContext = itemView.getContext();
        }

        public void setText(String name,String job,String univ) {

            mTextView1 = mView.findViewById(R.id.textView4);
            mTextView2 = mView.findViewById(R.id.textView3);
            mTextView3 = mView.findViewById(R.id.textView2);
            mTextView1.setText(name);
            mTextView2.setText(job);
            mTextView3.setText(univ);


        }

        public void setImage(String url) {
            mCircleImageView = mView.findViewById(R.id.profile_image);
            Picasso.get().load(url).fit().into(mCircleImageView);


        }
    }
}