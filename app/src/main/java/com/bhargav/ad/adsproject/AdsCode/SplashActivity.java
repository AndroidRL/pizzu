package com.bhargav.ad.adsproject.AdsCode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.bhargav.ad.adsproject.MainActivity;
import com.bhargav.ad.adsproject.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        FirebaseGetId(SplashActivity.this, new Intent(this, MainActivity.class));
    }

    public static void FirebaseGetId(Context context, Intent intent) {

        if (isOnline(context)) {

            FirebaseFirestore db = FirebaseFirestore.getInstance();
            db.collection("AdsProject").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                    if (task.isSuccessful()) {

                        for (QueryDocumentSnapshot document : task.getResult()) {

                            if (document.getId().equalsIgnoreCase("Ads")) {

                                // google set
                                MyPreference.SetGoogleInter(document.getString("interstitialId").replace(" ", ""));
                                MyPreference.SetGoogleInter1(document.getString("interstitialId_op").replace(" ", ""));
                                MyPreference.SetGoogleInter2(document.getString("interstitialId_op_2").replace(" ", ""));
                                MyPreference.SetGoogleNative(document.getString("nativeId").replace(" ", ""));
                                MyPreference.SetGoogleNative1(document.getString("nativeId_op").replace(" ", ""));
                                MyPreference.SetGoogleNative2(document.getString("nativeId_op_2").replace(" ", ""));
                                MyPreference.setGoogle_OpenADS(document.getString("openAds").replace(" ", ""));

                                // color & name set
                                if (document.getString("adColor") != null && !document.getString("adColor").isEmpty()) {
                                    MyPreference.setGooglebutton_color(document.getString("adColor").replace(" ", ""));
                                } else {
                                    MyPreference.setGooglebutton_color("#000000");
                                }
                                MyPreference.setGooglebutton_name(document.getString("adName").replace(" ", ""));


                                //facebook set
                                MyPreference.setFacebookBanner(document.getString("bannerIdFb").replace(" ", ""));
                                MyPreference.setFacebookBanner1(document.getString("bannerIdFb_op").replace(" ", ""));
                                MyPreference.setFacebookBanner2(document.getString("bannerIdFb_op_2").replace(" ", ""));
                                MyPreference.SetFacebookInter(document.getString("interstitialIdFb").replace(" ", ""));
                                MyPreference.SetFacebookInter1(document.getString("interstitialIdFb_op").replace(" ", ""));
                                MyPreference.SetFacebookInter2(document.getString("interstitialIdFb_op_2").replace(" ", ""));
                                MyPreference.SetFacebookNative(document.getString("nativeIdFb").replace(" ", ""));
                                MyPreference.SetFacebookNative1(document.getString("nativeIdFb_op").replace(" ", ""));
                                MyPreference.SetFacebookNative2(document.getString("nativeIdFb_op_2").replace(" ", ""));
                                MyPreference.setfacebook_open_ad_id(document.getString("facebook_open_ad_id").replace(" ", "")); //on inter Google on rakhva ni and aama 1


                                //util set
                                MyPreference.setAllADS(document.getString("changeAd").replace(" ", ""));
                                if (document.getString("adsOnOff") != null && !document.getString("adsOnOff").isEmpty()) {
                                    MyPreference.setAdsOnOff(document.getString("adsOnOff").replace(" ", ""));
                                } else {
                                    MyPreference.setAdsOnOff("0");
                                }

                                if (document.getString("backAdsOnOff") != null && !document.getString("backAdsOnOff").isEmpty()) {
                                    MyPreference.setBackAdsOnOff(document.getString("backAdsOnOff").replace(" ", ""));

                                } else {
                                    MyPreference.setBackAdsOnOff("0");
                                }

                                if (document.getString("counted_ads") != null && !document.getString("counted_ads").isEmpty()) {
                                    MyPreference.setCounter(Integer.parseInt(document.getString("counted_ads").replace(" ", "")));  //skip ads number
                                } else {
                                    MyPreference.setCounter(5000);
                                }

                                if (document.getString("counted_ads_back") != null && !document.getString("counted_ads_back").isEmpty()) {
                                    MyPreference.setBackCounter(Integer.parseInt(document.getString("counted_ads_back").replace(" ", "")));  //skip ads number
                                } else {
                                    MyPreference.setBackCounter(5000);
                                }


                                //extra btn set
                                if (document.getString("extraBtn_1") != null && !document.getString("extraBtn_1").isEmpty()) {
                                    MyPreference.setExtraBtn_1(document.getString("extraBtn_1").replace(" ", ""));
                                } else {
                                    MyPreference.setExtraBtn_1("0");
                                }


                                if (document.getString("auto_link_on_off") != null && !document.getString("auto_link_on_off").isEmpty()) {
                                    MyPreference.setauto_link_on_off(document.getString("auto_link_on_off").replace(" ", ""));  //on_off Auto link
                                } else {
                                    MyPreference.setauto_link_on_off("0");  //on_off Auto link
                                }
                                MyPreference.setauto_link_array(document.getString("auto_link_array").replace(" ", "")); //link Array
                                MyPreference.setauto_link_timer(document.getString("auto_link_timer").replace(" ", "")); //open Timer

                                if (document.getString("mix_ad_on_off") != null && !document.getString("mix_ad_on_off").isEmpty()) {
                                    MyPreference.setmix_ad_on_off(document.getString("mix_ad_on_off").replace(" ", "")); //on inter Google on rakhva ni and aama 1
                                } else {
                                    MyPreference.setmix_ad_on_off("0"); //on inter Google on rakhva ni and aama 1
                                }

                                //oepn 2 apps
                                if (document.getString("OtherAppsShow") != null && !document.getString("OtherAppsShow").isEmpty()) {
                                    MyPreference.setOtherAppsShow(document.getString("OtherAppsShow").replace(" ", ""));
                                } else {
                                    MyPreference.setOtherAppsShow("0");
                                }
                                MyPreference.setOtherAppsShowLink(document.getString("OtherAppsShowLink").replace(" ", ""));


                                //update our apps
                                if (document.getString("UpdateApps") != null && !document.getString("UpdateApps").isEmpty()) {
                                    MyPreference.setUpdateApps(document.getString("UpdateApps").replace(" ", ""));
                                } else {
                                    MyPreference.setUpdateApps("0");
                                }
                                MyPreference.setAppversioncode(document.getString("Appversioncode").replace(" ", ""));


                                if (MyPreference.getUpdateApps().equals("1")) {
                                    if (!MyPreference.getAppversioncode().equals(String.valueOf(MyPreference.VERSION_CODE))) {
                                        MyPreference.Entery_UpdateApps = 1;
                                        context.startActivity(new Intent(context, UpdateAppActivity.class));
                                        return;
                                    }
                                }
                                if (MyPreference.getOtherAppsShow().equals("1")) {
                                    MyPreference.Entery_UpdateApps = 2;
                                    context.startActivity(new Intent(context, UpdateAppActivity.class));
                                    return;
                                }


                                if (MyPreference.getAdsOnOff().equals("1")) {

                                    if (MyPreference.getAllADS().equals("G")) {
                                        AdsClass.mix_adsInter = 0;
                                        AdsClass.mix_adsInter_back = 0;

                                        AdsClass.AutoGoogleInterID = 1;
                                        AdsClass.GoogleInterstitialAdLoad(context);
                                        if (MyPreference.getmix_ad_on_off().equals("1")) {
                                            AdsClass.AutoLoadFBInterID = 1;
                                            AdsClass.FacebookInterLoad(context);
                                        }
                                        if (MyPreference.getFacebookInter() != null && !MyPreference.getFacebookInter().isEmpty()) {
                                            AdsClass.AutoLoadFBInterID = 1;
                                            AdsClass.Google_failed_FacebookInterLoad(context);
                                        }
                                        try {
                                            AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                                                public void onAppOpenAdLoaded(AppOpenAd appOpenAd) {
                                                    appOpenAd.show((Activity) context, new FullScreenContentCallback() {
                                                        public void onAdShowedFullScreenContent() {
                                                        }

                                                        public void onAdDismissedFullScreenContent() {
                                                            NextIntent(context,intent);
                                                        }

                                                        public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                                                            AdsClass.Google_open_failed_Facebook_Open(context, new Intent(context, MainActivity.class));
                                                        }
                                                    });
                                                }

                                                public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {
                                                    AdsClass.Google_open_failed_Facebook_Open(context, new Intent(context, MainActivity.class));

                                                }
                                            };
                                            AppOpenAd.load((Context) context, MyPreference.getGoogle_OpenADS(), new AdRequest.Builder().build(), 1, loadCallback);
                                            MyPreference.appOpenManager = new AppOpenManager(MyPreference.getInstance());

                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                    } else if (MyPreference.getAllADS().equals("F")) {
                                        AdsClass.AutoLoadFBInterID = 1;
                                        AdsClass.mix_adsInter = 1;
                                        AdsClass.mix_adsInter_back = 1;
                                        AdsClass.FacebookInterLoad(context);
                                        if (MyPreference.getmix_ad_on_off().equals("1")) {
                                            AdsClass.AutoLoadFBInterID = 1;
                                            AdsClass.FacebookInterLoad(context);
                                        }
                                        if (MyPreference.getGoogleInter() != null && !MyPreference.getGoogleInter().isEmpty()) {
                                            AdsClass.AutoGoogleInterID = 1;
                                            AdsClass.GoogleInterstitialAdLoad(context);
                                        }
                                        AdsClass.Facebook_Open(context, new Intent(context, MainActivity.class));

                                    } else if (MyPreference.getAllADS().equals("Q")) {
                                        AdsClass.Interstitial((Activity) context, new Intent(context, MainActivity.class), 1);
                                    }
                                } else {
                                    NextIntent(context, intent);

                                }
                            }
                        }


                    } else {

                        MyPreference.setAdsOnOff("0");
                        MyPreference.setBackAdsOnOff("0");
                        MyPreference.setExtraBtn_1("0");
                        MyPreference.setauto_link_on_off("0");
                        MyPreference.setmix_ad_on_off("0");
                        NextIntent(context, intent);

                    }
                }
            });

            return;
        }

        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.no_internet_item);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        dialog.findViewById(R.id.cancel_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                ((Activity) context).finish();
            }
        });

        dialog.findViewById(R.id.retry_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
//                FirebaseGetId(context,);
            }
        });

        dialog.show();

    }

    public static boolean isOnline(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static void NextIntent(Context context, Intent intent) {
        context.startActivity(intent);
        ((Activity) context).finish();

    }
}