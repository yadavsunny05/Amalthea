package com.amalthea.amalthea.amalthea18;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageAdapter extends PagerAdapter {
   private Context mContext;
   private ArrayList<Image> mImages;
    private LayoutInflater inflater;

    public ImageAdapter(Context context, ArrayList<Image> images) {
        mContext = context;
        mImages = images;
        inflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return mImages.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View myImageLayout = inflater.inflate(R.layout.image, view, false);
        ImageView myImage = (ImageView) myImageLayout.findViewById(R.id.imageview1);
        TextView textView = (TextView) myImageLayout.findViewById(R.id.image_text);
        Picasso.get().load(mImages.get(position).getUrl().toString()).into(myImage);
        textView.setText(mImages.get(position).getDetails().toString());
        view.addView(myImageLayout, position);
        return myImageLayout;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
}
