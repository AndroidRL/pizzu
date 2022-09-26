package com.bhargav.ad.adsproject.AdsCode;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bhargav.ad.adsproject.R;


public class ExitScreen extends Activity {

    ImageView txt_rate, txt_no, txt_yes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SystemUiManager.setTransparentStatus(ExitScreen.this, true);
        setContentView(R.layout.exit_screen);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.setMargins(0, SystemUiManager.getStatusBarHeight(ExitScreen.this), 0, 0);
        findViewById(R.id.rRoot_main).setLayoutParams(params);

        txt_rate = findViewById(R.id.txt_rate);
        txt_yes = findViewById(R.id.txt_yes);
        txt_no = findViewById(R.id.txt_no);

        txt_rate.setOnClickListener(v -> rate());
        txt_yes.setOnClickListener(v -> yes());
        txt_no.setOnClickListener(v -> no());
    }

    private void rate() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
        } catch (ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }

    private void yes() {
        finish();
        finishAffinity();
    }

    private void no() {
        AdsClass.BackInterstitial(ExitScreen.this);
    }

    @Override
    public void onBackPressed() {
        final Dialog dialog = new Dialog(ExitScreen.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.back_dialog_exit);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        dialog.findViewById(R.id.no_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.yes_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yes();
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    @Override
    protected void onResume() {
        super.onResume();

        AdsClass.NativeAds( this, findViewById(R.id.native_detail),
                findViewById(R.id.banner_native), findViewById(R.id.addcontain)
                , findViewById(R.id.ad_native_fb));

    }
}
