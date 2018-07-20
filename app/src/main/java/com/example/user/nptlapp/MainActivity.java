package com.example.user.nptlapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize adMob //change the app id from sample to original.
        //sample id is ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        mWebView = (WebView) findViewById(R.id.my_wb);
        WebSettings wb_settings = mWebView.getSettings();
        wb_settings.setJavaScriptEnabled(true);

        wb_settings.setBuiltInZoomControls(false);//false
        wb_settings.setSupportZoom(false);//false
        wb_settings.setJavaScriptCanOpenWindowsAutomatically(true);
        wb_settings.setAllowFileAccess(true);
        wb_settings.setDomStorageEnabled(true);
        wb_settings.setSupportMultipleWindows(true);


        mWebView.setWebViewClient(new WebViewClient());
        //  https://onlinecourses.nptel.ac.in/m#/mycourses
        // https://techrebootyoutube.blogspot.com/
        // https://m.youtube.com/
        mWebView.loadUrl("https://onlinecourses.nptel.ac.in/m#/mycourses");


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }



}
