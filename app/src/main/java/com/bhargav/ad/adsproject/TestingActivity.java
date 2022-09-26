package com.bhargav.ad.adsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bhargav.ad.adsproject.AdsCode.AdsClass;

public class TestingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
    }

    @Override
    public void onBackPressed() {

        AdsClass.BackInterstitial(TestingActivity.this);

    }


//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//    }
}