package com.amalthea.amalthea.amalthea18;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import cz.msebera.android.httpclient.Header;

public class subscribe extends AppCompatActivity {


    private String url = "https://script.google.com/macros/s/AKfycbzWSEFcdfeOxVOeML-cCVuKzu4S-NFgWpv6-DyvlY6k8P7lSwNQ/exec";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subscribe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Button submit = (Button) findViewById(R.id.submit);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AsyncHttpClient client = new AsyncHttpClient();

                EditText name = (EditText) findViewById(R.id.editName);
                EditText email = (EditText) findViewById(R.id.editEmail);


                String namestr = name.getText().toString();
                String emailstr = email.getText().toString();
                //Log.d("subscribe","spaceless"+namestr);
                String namestrwspaceremoved = namestr.replaceAll("\\s","");
                //Log.d("subscribe","space"+namestrwspaceremoved);
                Date now = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss aa");
                String dateString = formatter.format(now);

                Log.d("subscribe","hehe"+dateString);
                final RequestParams params = new RequestParams();
                params.put("name",namestr);
                params.put("email",emailstr);
                params.put("tstamp",dateString);
                if (namestrwspaceremoved.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Name field is Empty", Toast.LENGTH_SHORT).show();
                }


                else if (!isValidEmail((CharSequence) emailstr)){
                    Toast.makeText(getApplicationContext(),"Invalid Email-id", Toast.LENGTH_SHORT).show();
                }
                else{

                    client.get(url, params, new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                            Toast.makeText(getApplicationContext(),"Successfully Submitted", Toast.LENGTH_SHORT).show();
                            Log.d("subscribe","hihi"+params);
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                            Toast.makeText(getApplicationContext(),"Sorry"+"  "+error, Toast.LENGTH_LONG).show();
                            Log.d("subscribe","error"+"  "+error+ Arrays.toString(headers));
                        }
                    });
                }
            }
        });


    }



    public static boolean isValidEmail(CharSequence target) {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

}
