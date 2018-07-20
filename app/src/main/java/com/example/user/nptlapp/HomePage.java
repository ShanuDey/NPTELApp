package com.example.user.nptlapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HomePage extends AppCompatActivity {

    private AlertDialog alert;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        Handler handler = new Handler();
        intent = new Intent(this,MainActivity.class);

        /*
        alert = new AlertDialog.Builder(this)
                .setTitle("!!! Opps !!! ")
                .setMessage("No internet Connection.\nPlease check the internet connection.")
                .setCancelable(false)
                .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(isOnline()){
                            startActivity(intent);
                            finish();
                        }
                        else{
                            showAlert();
                        }
                    }
                })
                .show();
                */
        if(isOnline()){
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(intent);
                    finish();
                }
            },3000);
        }
        else{
            showAlert();
        }

    }

    public void showAlert(){
        /*alert = new AlertDialog.Builder(this)
                .setTitle("!!! Opps !!! ")
                .setMessage("No internet Connection.\nPlease check the internet connection.")
                .setCancelable(false)
                .show();

                */
        alert = new AlertDialog.Builder(this)
                .setTitle("!!! Opps !!! ")
                .setMessage("No internet Connection.\nPlease check the internet connection.")
                .setCancelable(false)
                .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(isOnline()){
                            startActivity(intent);
                            finish();
                        }
                        else{
                            showAlert();
                        }
                    }
                })
                .show();

    }

    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }
}
