package com.amalthea.amalthea.amalthea18;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Calendar;

import cz.msebera.android.httpclient.Header;

public class QRCodegenerate extends AppCompatActivity {

    private String url = "https://script.google.com/macros/s/AKfycbyTEOlBN4permZhI9J6KLF6NwJXPxryFUrhkVyzuXujSbUljyY/exec";
    public final static int QRcodeWidth = 100 ;
    private static final String IMAGE_DIRECTORY = "/QRcodeDemonuts";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcodegenerate);
        //setContentView(R.layout.activity_main);

        Button submit = (Button) findViewById(R.id.submit);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AsyncHttpClient client = new AsyncHttpClient();

                EditText name = (EditText) findViewById(R.id.name);
                EditText email = (EditText) findViewById(R.id.email);
                EditText college = findViewById(R.id.college);


                String namestr2 = name.getText().toString();
                final String emailstr2 = email.getText().toString();
                String collegestr2 = college.getText().toString();
                //Log.d("MainActivity","spaceless"+namestr);
                String namestrwspaceremoved = namestr2.replaceAll("\\s","");
                //Log.d("MainActivity","space"+namestrwspaceremoved);



                final RequestParams params = new RequestParams();
                params.put("Name",namestr2);
                params.put("Email",emailstr2);
                params.put("CollegeName",collegestr2);

                if (namestrwspaceremoved.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Name field is Empty",Toast.LENGTH_SHORT).show();
                }


                else if (!isValidEmail((CharSequence) emailstr2)){
                    Toast.makeText(getApplicationContext(),"Invalid Email-id",Toast.LENGTH_SHORT).show();
                }
                else if (collegestr2.isEmpty()){
                    Toast.makeText(getApplicationContext(),"College field is Empty",Toast.LENGTH_SHORT).show();
                }
                else{

                    client.get(url, params, new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                            Toast.makeText(getApplicationContext(),"Successfully Submitted",Toast.LENGTH_SHORT).show();
                            //Log.d("MainActivity","hihi"+params);

                            Log.d("MainActivity","huhuhu"+emailstr2);

                            try {
                                TextToImageEncode(emailstr2);


                                //SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                //SharedPreferences.Editor editor = wmbPreference.edit();
                                //editor.putBoolean("QRCODEDONE", true);
                            } catch (WriterException e) {
                                e.printStackTrace();
                                Log.d("MainActivity","halo"+e);
                            }
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                            //Toast.makeText(getApplicationContext(),"Sorry"+"  "+error,Toast.LENGTH_LONG).show();
                            Log.d("MainActivity","error"+"  "+error+ Arrays.toString(headers));
                        }
                    });
                }
            }
        });


    }



    public static boolean isValidEmail(CharSequence target) {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();

    }

    public String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY);
        // have the object build the directory structure, if needed.

        if (!wallpaperDirectory.exists()) {
            Log.d("dirrrrrr", "" + wallpaperDirectory.mkdirs());
            wallpaperDirectory.mkdirs();
        }

        try {
            File f = new File( getCacheDir(),"qr.jpg");//give read write permission
            FileOutputStream fo = new FileOutputStream(f);
            myBitmap.compress(Bitmap.CompressFormat.PNG, 100, fo);

            Log.d("FILESAVED", "File Saved::--->" + f.getAbsolutePath());
            fo.close();

            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }


    private void TextToImageEncode(String Value) throws WriterException {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(
                    Value,
                    BarcodeFormat.QR_CODE,
                    QRcodeWidth, QRcodeWidth, null
            );

        } catch (IllegalArgumentException Illegalargumentexception) {

            return ;
        }
        int bitMatrixWidth = bitMatrix.getWidth();

        int bitMatrixHeight = bitMatrix.getHeight();
        Log.d("MainActivity","size"+bitMatrixWidth);

        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];

        for (int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;

            for (int x = 0; x < bitMatrixWidth; x++) {

                pixels[offset + x] = bitMatrix.get(x, y) ?
                        getResources().getColor(R.color.colorPrimary):getResources().getColor(R.color.grey);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);
        bitmap.setPixels(pixels,0,100,0,0,100,100);
        Log.d("MainActivity","pixels"+ Arrays.toString(pixels));
        ImageView iv = (ImageView) findViewById(R.id.qrimage);
        //ImageView iv2 =(ImageView) findViewById(R.id.qrviewinmenu);
        TextView qrtext = findViewById(R.id.qrtext);


        iv.setImageBitmap(bitmap);
        //iv2.setImageBitmap(bitmap);

        String path = saveImage(bitmap);  //give read write permission
        Toast.makeText(getApplicationContext(), "QRCode saved to -> "+path, Toast.LENGTH_SHORT).show();
        final Intent mintent = new Intent(QRCodegenerate.this,MainActivity.class);
        mintent.putExtra("bitmap",bitmap);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                startActivity(mintent);
            }
        }, 5000);

        qrtext.setText("This is the QR Code that will be used when you visit Amalthea");
        return ;
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

}
