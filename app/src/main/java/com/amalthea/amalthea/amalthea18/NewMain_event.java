package com.amalthea.amalthea.amalthea18;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class NewMain_event extends AppCompatActivity {
    private ViewPager viewPager;
    private SlideAdapter myadapter;
    //Bundle extras = getIntent().getExtras();
    //int id = getIntent().getExtras().getInt("movie_id_key");

    //int id2 = Integer.parseInt(id);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main_2_event);
        viewPager = (ViewPager) findViewById(R.id.pager_events);
        myadapter = new SlideAdapter(this);
        viewPager.setAdapter(myadapter);

        //if (extras != null) {
        //    int position = extras.getInt("movie_id");
        //    viewPager.setCurrentItem(position);
        //}
        Bundle bundle = getIntent().getExtras();
        if(getIntent().getIntExtra("movie_id",0)!= 0){
            int position = bundle.getInt("movie_id");
            viewPager.setCurrentItem(position);
        }




    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
