package com.pinxrp.xrp;

import android.app.ProgressDialog;

import androidx.appcompat.app.AppCompatActivity;


import com.pinxrp.xrp.helper.AdsUtils;


public abstract class BaseActivity extends AppCompatActivity implements AdsUtils.AdsStatus {

    private ProgressDialog mProgressDialog;



    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this, R.style.Theme_AppCompat_Light_Dialog_Alert);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMessage("Hi! Please Wait...");
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    public void setProgressMessage(String msg) {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.setMessage(msg);
        }

    }

    public void loadBannerAd() {
        //AdsUtils.getInstance(this).loadBannerAd(this);
        /**
         * for production purpose , set this to false :
         *
         * Appodea.setTesting(false)
         */
//        Appodeal.setTesting(true);
//
//        Appodeal.initialize(this, "dcd4a159df076c6fb242d40a8cc8ccc3cac69462cf1d04c5", Appodeal.REWARDED_VIDEO | Appodeal.BANNER | Appodeal.INTERSTITIAL);
//        Appodeal.show(this, Appodeal.BANNER_BOTTOM);  // Display banner at the right of the screen
    }

    public void showRewardedVideo() {
        AdsUtils.getInstance(this).showRewardedAd(this);
    }

//    public void showAppoDealRewardVideo() {
//        Appodeal.show(this, Appodeal.REWARDED_VIDEO);
//    }
//
//
//    public void showAppoDealIntersitial() {
//        Appodeal.show(this, Appodeal.INTERSTITIAL);
//    }


    public void showInterstitialAd() {
        AdsUtils.getInstance(this).showInterstitialAd(this);
    }

    public boolean isInterstitialLoaded() {

        return AdsUtils.getInstance(this).isInterstitialAdsReady();
    }

    public boolean isRewardedLoaded() {
        return AdsUtils.getInstance(this).isRewardedAdsReady();
    }

    @Override
    public void onAdloaded() {

    }

    @Override
    public void onBackPressed() {

       // if (isInterstitialLoaded()) {
            showInterstitialAd();
            //showAppoDealIntersitial();
       // }
        finish();
    }
}
