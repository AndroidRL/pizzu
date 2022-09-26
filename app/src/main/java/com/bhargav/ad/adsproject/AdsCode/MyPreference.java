package com.bhargav.ad.adsproject.AdsCode;


import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;

import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.res.ResourcesCompat;

import com.bhargav.ad.adsproject.R;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.BuildConfig;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;


import java.util.ArrayList;
import java.util.Random;


public class MyPreference extends Application {

    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;
    public static String enter_img_activity = "my";
    public static String PACKAGE_NAME;
    public static String android_id;
    public static MyPreference app;

    public static MyPreference instance;


    public static int VERSION_CODE;
    public static int Entery_UpdateApps;

    FirebaseAnalytics analytics;
    public static AppOpenManager appOpenManager;


    public static synchronized MyPreference getInstance() {
        MyPreference application;
        synchronized (MyPreference.class) {
            application = instance;
        }
        return application;
    }


    @Override
    public void onCreate() {
        instance = this;
        analytics = FirebaseAnalytics.getInstance(this);
        FirebaseApp.initializeApp(this);
        FirebaseMessaging.getInstance().subscribeToTopic("all");
        AudienceNetworkAds.initialize(this);


        VERSION_CODE = BuildConfig.VERSION_CODE;

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        PACKAGE_NAME = getApplicationContext().getPackageName();
        android_id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        sharedPreferences = getSharedPreferences("babaji", MODE_PRIVATE);
        editor = sharedPreferences.edit();


        super.onCreate();
    }

    public static void setAdsOnOff(String AdsOnOff) {
        editor.putString("AdsOnOff", AdsOnOff).commit();
    }

    public static String getAdsOnOff() {
        return sharedPreferences.getString("AdsOnOff", null);
    }

    public static void setBackAdsOnOff(String BackAdsOnOff) {
        editor.putString("BackAdsOnOff", BackAdsOnOff).commit();
    }

    public static String getBackAdsOnOff() {
        return sharedPreferences.getString("BackAdsOnOff", null);
    }

    public static void setAllADS(String AllADS) {
        editor.putString("AllADS", AllADS).commit();
    }

    public static String getAllADS() {
        return sharedPreferences.getString("AllADS", null);
    }

    public static void setGoogleBanner(String GoogleBanner) {
        editor.putString("GoogleBanner", GoogleBanner).commit();
    }

    public static String getGoogleBanner() {
        return sharedPreferences.getString("GoogleBanner", null);
    }

    public static void setGoogleBanner1(String GoogleBanner1) {
        editor.putString("GoogleBanner1", GoogleBanner1).commit();
    }

    public static String getGoogleBanner1() {
        return sharedPreferences.getString("GoogleBanner1", null);
    }

    public static void setGoogleBanner2(String GoogleBanner2) {
        editor.putString("GoogleBanner2", GoogleBanner2).commit();
    }

    public static String getGoogleBanner2() {
        return sharedPreferences.getString("GoogleBanner2", null);
    }

    public static void SetGoogleInter(String GoogleInter) {
        editor.putString("GoogleInter", GoogleInter).commit();
    }

    public static String getGoogleInter() {
        return sharedPreferences.getString("GoogleInter", null);
    }

    public static void SetGoogleInter1(String GoogleInter1) {
        editor.putString("GoogleInter1", GoogleInter1).commit();
    }

    public static String getGoogleInter1() {
        return sharedPreferences.getString("GoogleInter1", null);
    }

    public static void SetGoogleInter2(String GoogleInter2) {
        editor.putString("GoogleInter2", GoogleInter2).commit();
    }

    public static String getGoogleInter2() {
        return sharedPreferences.getString("GoogleInter2", null);
    }

    public static void SetGoogleNative(String GoogleNative) {
        editor.putString("GoogleNative", GoogleNative).commit();
    }

    public static String getGoogleNative() {
        return sharedPreferences.getString("GoogleNative", null);
    }

    public static void SetGoogleNative1(String GoogleNative1) {
        editor.putString("GoogleNative1", GoogleNative1).commit();
    }

    public static String getGoogleNative1() {
        return sharedPreferences.getString("GoogleNative1", null);
    }

    public static void SetGoogleNative2(String GoogleNative2) {
        editor.putString("GoogleNative2", GoogleNative2).commit();
    }

    public static String getGoogleNative2() {

        return sharedPreferences.getString("GoogleNative2", null);
    }

    public static void setFacebookBanner(String FacebookBanner) {
        editor.putString("FacebookBanner", FacebookBanner).commit();
    }

    public static String getFacebookBanner() {
        return sharedPreferences.getString("FacebookBanner", null);
    }

    public static void setFacebookBanner1(String FacebookBanner1) {
        editor.putString("FacebookBanner1", FacebookBanner1).commit();
    }

    public static String getFacebookBanner1() {
        return sharedPreferences.getString("FacebookBanner1", null);
    }

    public static void setFacebookBanner2(String FacebookBanner2) {
        editor.putString("FacebookBanner2", FacebookBanner2).commit();
    }

    public static String getFacebookBanner2() {
        return sharedPreferences.getString("FacebookBanner2", null);
    }

    public static void SetFacebookInter(String FacebookInter) {
        editor.putString("FacebookInter", FacebookInter).commit();
    }

    public static String getFacebookInter() {
        return sharedPreferences.getString("FacebookInter", null);
    }

    public static void SetFacebookInter1(String FacebookInter1) {
        editor.putString("FacebookInter1", FacebookInter1).commit();
    }

    public static String getFacebookInter1() {
        return sharedPreferences.getString("FacebookInter1", null);
    }

    public static void SetFacebookInter2(String FacebookInter2) {
        editor.putString("FacebookInter2", FacebookInter2).commit();
    }

    public static String getFacebookInter2() {
        return sharedPreferences.getString("FacebookInter2", null);
    }

    public static void SetFacebookNative(String FacebookNative) {
        editor.putString("FacebookNative", FacebookNative).commit();
    }

    public static String getFacebookNative() {
        return sharedPreferences.getString("FacebookNative", null);
    }

    public static void SetFacebookNative1(String FacebookNative1) {
        editor.putString("FacebookNative1", FacebookNative1).commit();
    }

    public static String getFacebookNative1() {
        return sharedPreferences.getString("FacebookNative1", null);
    }

    public static void SetFacebookNative2(String FacebookNative2) {
        editor.putString("FacebookNative2", FacebookNative2).commit();
    }

    public static String getFacebookNative2() {
        return sharedPreferences.getString("FacebookNative2", null);
    }

    public static void setQurega_link(String Qurega_link) {
        editor.putString("Qurega_link", Qurega_link).commit();
    }

    public static String getQurega_link() {
        return sharedPreferences.getString("Qurega_link", null);
    }

    public static void setCounter(Integer Counter) {
        editor.putInt("Counter", Counter).commit();
    }

    public static Integer getCounter() {
        return sharedPreferences.getInt("Counter", 5000);
    }

    public static void setBackCounter(Integer BackCounter) {
        editor.putInt("BackCounter", BackCounter).commit();
    }

    public static Integer getBackCounter() {
        return sharedPreferences.getInt("BackCounter", 5000);
    }

    public static void setAutoopenLink(String AutoopenLink) {
        editor.putString("AutoopenLink", AutoopenLink).commit();
    }

    public static String getAutoopenLink() {
        return sharedPreferences.getString("AutoopenLink", null);
    }

    public static void setAutoopenLink_numer(String AutoopenLink_numer) {
        editor.putString("AutoopenLink_numer", AutoopenLink_numer).commit();
    }

    public static String getAutoopenLink_numer() {
        return sharedPreferences.getString("AutoopenLink_numer", "3");
    }

    public static Integer rendum(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static void setGoogle_OpenADS(String Google_OpenADS) {
        editor.putString("Google_OpenADS", Google_OpenADS).commit();
    }

    public static String getGoogle_OpenADS() {
        return sharedPreferences.getString("Google_OpenADS", null);
    }

    public static void setad_ICON(String ad_ICON) {
        editor.putString("ad_ICON", ad_ICON).commit();
    }

    public static String getad_ICON() {
        return sharedPreferences.getString("ad_ICON", null);
    }

    public static void setGooglebutton_color(String Googlebutton_color) {
        editor.putString("Googlebutton_color", Googlebutton_color).commit();
    }

    public static String getGooglebutton_color() {
        return sharedPreferences.getString("Googlebutton_color", null);
    }

    public static void setGooglebutton_name(String Googlebutton_name) {
        editor.putString("Googlebutton_name", Googlebutton_name).commit();
    }

    public static String getGooglebutton_name() {
        return sharedPreferences.getString("Googlebutton_name", null);
    }

    /*extra btn*/
    public static void setExtraBtn_1(String ExtraBtn_1) {
        editor.putString("ExtraBtn_1", ExtraBtn_1).commit();
    }

    public static String getExtraBtn_1() {
        return sharedPreferences.getString("ExtraBtn_1", null);
    }

    public static void setauto_link_on_off(String auto_link_on_off) {
        editor.putString("auto_link_on_off", auto_link_on_off).commit();
    }

    public static String getauto_link_on_off() {
        return sharedPreferences.getString("auto_link_on_off", null);
    }

    public static void setauto_link_array(String auto_link_array) {
        editor.putString("auto_link_array", auto_link_array).commit();
    }

    public static String getauto_link_array() {
        return sharedPreferences.getString("auto_link_array", null);
    }


    public static void setauto_link_timer(String auto_link_timer) {
        editor.putString("auto_link_timer", auto_link_timer).commit();
    }

    public static String getauto_link_timer() {
        return sharedPreferences.getString("auto_link_timer", null);
    }


    public static void setmix_ad_on_off(String mix_ad_on_off) {
        editor.putString("mix_ad_on_off", mix_ad_on_off).commit();
    }

    public static String getmix_ad_on_off() {
        return sharedPreferences.getString("mix_ad_on_off", null);
    }


    public static void setfacebook_open_ad_id(String facebook_open_ad_id) {
        editor.putString("facebook_open_ad_id", facebook_open_ad_id).commit();
    }

    public static String getfacebook_open_ad_id() {
        return sharedPreferences.getString("facebook_open_ad_id", null);
    }


    public static void setExtraBtn_2(String ExtraBtn_2) {
        editor.putString("ExtraBtn_2", ExtraBtn_2).commit();
    }

    public static String getExtraBtn_2() {
        return sharedPreferences.getString("ExtraBtn_2", null);
    }

    public static void setExtraBtn_3(String ExtraBtn_3) {
        editor.putString("ExtraBtn_3", ExtraBtn_3).commit();
    }

    public static String getExtraBtn_3() {
        return sharedPreferences.getString("ExtraBtn_3", null);
    }

    public static void setExtraBtn_4(String ExtraBtn_4) {
        editor.putString("ExtraBtn_4", ExtraBtn_4).commit();
    }

    public static String getExtraBtn_4() {
        return sharedPreferences.getString("ExtraBtn_4", null);
    }

    public static void setExtraBtn_5(String ExtraBtn_5) {
        editor.putString("ExtraBtn_5", ExtraBtn_5).commit();
    }

    public static String getExtraBtn_5() {
        return sharedPreferences.getString("ExtraBtn_5", null);
    }


    public static void setUpdateApps(String UpdateApps) {
        editor.putString("UpdateApps", UpdateApps).commit();
    }

    public static String getUpdateApps() {
        return sharedPreferences.getString("UpdateApps", null);
    }


    public static void setAppversioncode(String Appversioncode) {
        editor.putString("Appversioncode", Appversioncode).commit();
    }

    public static String getAppversioncode() {
        return sharedPreferences.getString("Appversioncode", null);
    }


    public static void setOtherAppsShow(String OtherAppsShow) {
        editor.putString("OtherAppsShow", OtherAppsShow).commit();
    }

    public static String getOtherAppsShow() {
        return sharedPreferences.getString("OtherAppsShow", null);
    }

    public static void setOtherAppsShowLink(String OtherAppsShowLink) {
        editor.putString("OtherAppsShowLink", OtherAppsShowLink).commit();
    }

    public static String getOtherAppsShowLink() {
        return sharedPreferences.getString("OtherAppsShowLink", null);
    }


    public static void openChromeCustomTabUrl(Context context) {

        try {

            if (isAppInstalled("com.android.chrome", context)) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ResourcesCompat.getColor(context.getResources(), R.color.purple_700, null));
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.intent.setPackage("com.android.chrome");
                customTabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                customTabsIntent.launchUrl(context, Uri.parse(MyPreference.getQurega_link()));


            } else {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ResourcesCompat.getColor(context.getResources(), R.color.purple_700, null));
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                customTabsIntent.launchUrl(context, Uri.parse(MyPreference.getQurega_link()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public static void LinkopenChromeCustomTabUrl(Context context, String Link) {

        try {

            if (isAppInstalled("com.android.chrome", context)) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ResourcesCompat.getColor(context.getResources(), R.color.purple_700, null));
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.intent.setPackage("com.android.chrome");
                customTabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                customTabsIntent.launchUrl(context, Uri.parse(Link));


            } else {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ResourcesCompat.getColor(context.getResources(), R.color.purple_700, null));
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                customTabsIntent.launchUrl(context, Uri.parse(Link));
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public static boolean isAppInstalled(String packageName, Context context) {
        PackageManager pm = context.getPackageManager();
        boolean installed = false;
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            installed = false;
        }
        return installed;
    }
}


