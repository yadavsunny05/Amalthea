package com.amalthea.amalthea.amalthea18;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Rohit Patil on 02-09-2018.
 */

public class developers extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.developers);

        ImageButton btn1 = (ImageButton)findViewById(R.id.btn_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.linkedin.com/in/anshuman-yadav-319694153/"));
                startActivity(i);
            }
        });

        ImageButton btn2 = (ImageButton)findViewById(R.id.btn_2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.linkedin.com/in/rohit-patil-8a4375169/"));
                startActivity(i);
            }
        });
        ImageButton btn3 = (ImageButton)findViewById(R.id.btn_3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.linkedin.com/in/rushil-shah-618054166/"));
                startActivity(i);
            }
        });
}}
