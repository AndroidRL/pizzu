package com.bhargav.ad.adsproject.AdsCode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bhargav.ad.adsproject.BuildConfig;
import com.bhargav.ad.adsproject.R;

public class UpdateAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_app);
    }

    public void Update(View view) {

        if (MyPreference.Entery_UpdateApps == 1) {
            MyPreference.LinkopenChromeCustomTabUrl(this, "https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName());

        } else if (MyPreference.Entery_UpdateApps == 2) {
            MyPreference.LinkopenChromeCustomTabUrl(this, MyPreference.getOtherAppsShowLink());
        }
    }
}