package com.amalthea.amalthea.amalthea18;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class SpeakerAdapter extends PagerAdapter {
    private Context mContext;
    private ArrayList<Speaker> mSpeakers;
    private LayoutInflater inflater;

    public SpeakerAdapter(Context context) {
        mContext = context;
    }

    public SpeakerAdapter(Context context, ArrayList<Speaker> speakers) {
        mContext = context;
        mSpeakers = speakers;
        inflater = LayoutInflater.from(mContext);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mSpeakers.size();
    }


    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View myImageLayout = inflater.inflate(R.layout.home_past_speaker, view, false);
        CircleImageView myImage = (CircleImageView) myImageLayout.findViewById(R.id.home_speakers);
        TextView textView1 = (TextView) myImageLayout.findViewById(R.id.textView12);
        TextView textView2 = (TextView) myImageLayout.findViewById(R.id.textView13);
        TextView textView3 = (TextView) myImageLayout.findViewById(R.id.textView14);
        Picasso.get().load(mSpeakers.get(position).getUrl().toString()).into(myImage);
        textView1.setText(mSpeakers.get(position).getDetails().toString());
        textView2.setText(mSpeakers.get(position).getName().toString());
        textView3.setText(mSpeakers.get(position).getJob().toString());
        view.addView(myImageLayout, position);
        return myImageLayout;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
}
