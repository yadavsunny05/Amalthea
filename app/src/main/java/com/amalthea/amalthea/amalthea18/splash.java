package com.amalthea.amalthea.amalthea18;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Rohit Patil on 05-09-2018.
 */

public class splash extends AppCompatActivity {
    private int SLEEP_TIMER = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);


        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash);

        LogoLauncher logoLauncher = new LogoLauncher();
        logoLauncher.start();
    }
    private class LogoLauncher extends Thread{
        public void run(){
            SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
            try{
                sleep(1000 * SLEEP_TIMER);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            if(isFirstRun)
                {
                    // Code to run once
                    SharedPreferences.Editor editor = wmbPreference.edit();
                    editor.putBoolean("FIRSTRUN", false);
                    editor.commit();
                    Intent intent = new Intent(splash.this,QRCodegenerate.class);
                    startActivity(intent);
                }
            else {
                Intent intent = new Intent(splash.this, MainActivity.class);
                startActivity(intent);
                splash.this.finish();
            }}
    }
}
