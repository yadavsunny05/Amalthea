package com.amalthea.amalthea.amalthea18;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    private StorageReference mStorageRef;
    FragmentPagerAdapter mFragmentAdapter;
    ViewPager mViewPager;
    private TabLayout mTabLayout;
    private ImageView mImageView;




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.qrviewinmenu);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);






        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        db.setFirestoreSettings(settings);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        setupwithViewPager(mViewPager);


        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);



        FileInputStream fis = null;
        try {
            File file = new File(getCacheDir(), "qr.jpg");

            Bitmap b = BitmapFactory.decodeStream( new FileInputStream(file));
            mImageView.setImageBitmap(b);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mTabLayout.getTabAt(0).setIcon(R.drawable.ic_home2);
        mTabLayout.getTabAt(1).setIcon(R.drawable.ic_lecture);
        mTabLayout.getTabAt(2).setIcon(R.drawable.ic_education);
        mTabLayout.getTabAt(3).setIcon(R.drawable.ic_whiteboard);
        mTabLayout.getTabAt(4).setIcon(R.drawable.ic_two_motor_flags);
        mTabLayout.getTabAt(5).setIcon(R.drawable.ic_money);
    }

    private void setupwithViewPager(ViewPager mViewPager){

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new frag1(), "");
        adapter.addFragment(new frag2(), "");
        adapter.addFragment(new frag3(), "");
        adapter.addFragment(new frag4(), "");
        adapter.addFragment(new frag5(), "");
        adapter.addFragment(new frag6(), "");
        mViewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://amalthea.iitgn.ac.in/"));
            startActivity(i);

            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent myIntent = new Intent(this, subscribe.class);
            startActivity(myIntent);


        } else if (id == R.id.nav_slideshow) {
            Intent myIntent = new Intent(MainActivity.this,
                    developers.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_manage) {
            Intent i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/amalthea.iitgn/"));
            startActivity(i);

        } else if (id == R.id.lol) {
            Intent i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/amalthea_iitgn/"));
            startActivity(i);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
