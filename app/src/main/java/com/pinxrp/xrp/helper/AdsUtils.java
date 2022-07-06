package com.pinxrp.xrp.helper;

import android.util.Log;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.integration.IntegrationHelper;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InitializationListener;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import com.pinxrp.xrp.BaseActivity;
import com.pinxrp.xrp.R;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;

public class AdsUtils {
    final String TAG = AdsUtils.class.getName();
    public static String APP_ID = "4107295";
    public static String APP_ID_IRON_SOURCE = "4107295";

    public static String bannerPlacement = "banner";
    public static String interstitialPlacement = "video";
    public static String videoPlacement = "rewardedVideo";
    public static Boolean testMode = false;
    static AdsUtils instance;
    AdsStatus listener;

    AdsUtils(BaseActivity activity) {
        UnityAds.initialize(activity, AdsUtils.APP_ID, true);

        /**
         * iron source
         */
//        IronSource.init(activity, AdsUtils.APP_ID_IRON_SOURCE, IronSource.AD_UNIT.INTERSTITIAL, IronSource.AD_UNIT.REWARDED_VIDEO, IronSource.AD_UNIT.BANNER);
//        IronSource.init(activity, AdsUtils.APP_ID_IRON_SOURCE, new InitializationListener() {
//            @Override
//            public void onInitializationComplete() {
//                Log.e("ironsource","ironSource is initialized");
//            }
//        });
//        IntegrationHelper.validateIntegration(activity);

//        UnityAds.addListener(new IUnityAdsListener() {
//            @Override
//            public void onUnityAdsReady(String s) {
//                Log.d(TAG, "onUnityAdsReady: " + s);
//                listener.onAdloaded();
//            }
//
//            @Override
//            public void onUnityAdsStart(String s) {
//                Log.d(TAG, "onUnityAdsStart: " + s);
//            }
//
//            @Override
//            public void onUnityAdsFinish(String s, UnityAds.FinishState finishState) {
//                Log.d(TAG, "onUnityAdsFinish: " + s);
//                listener.onAdshown(s);
//            }
//
//            @Override
//            public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String s) {
//                Log.d(TAG, "onUnityAdsError: " + s);
//            }
//        });
//        UnityAds.initialize(activity, AdsUtils.APP_ID, null, AdsUtils.testMode);
//        UnityAds.addListener(new IUnityAdsListener() {
//            @Override
//            public void onUnityAdsReady(String s) {
//                Log.d(TAG, "onUnityAdsReady: " + s);
//                listener.onAdloaded();
//            }
//
//            @Override
//            public void onUnityAdsStart(String s) {
//                Log.d(TAG, "onUnityAdsStart: " + s);
//            }
//
//            @Override
//            public void onUnityAdsFinish(String s, UnityAds.FinishState finishState) {
//                Log.d(TAG, "onUnityAdsFinish: " + s);
//                listener.onAdshown(s);
//            }
//
//            @Override
//            public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String s) {
//                Log.d(TAG, "onUnityAdsError: " + s);
//            }
//        });
    }

    public static AdsUtils getInstance(BaseActivity activity) {
        if (instance == null)
            instance = new AdsUtils(activity);
        return instance;
    }

    public void loadBannerAd(BaseActivity activity) {
        listener = (AdsStatus) activity;
        RelativeLayout bottomBannerView = activity.findViewById(R.id.ly_banner);
        BannerView bannerView = new BannerView(activity, AdsUtils.bannerPlacement, new UnityBannerSize(320, 50));
        bottomBannerView.addView(bannerView);
        bannerView.load();
    }

    public void showInterstitialAd(AppCompatActivity activity) {
        if (UnityAds.isInitialized()) {
            UnityAds.show(activity, interstitialPlacement);
        }
    }

    public void showRewardedAd(AppCompatActivity activity) {

        if (UnityAds.isInitialized()) {
            UnityAds.show(activity, videoPlacement);
        }

        IronSource.setInterstitialListener(new InterstitialListener() {
            /**
             * Invoked when Interstitial Ad is ready to be shown after load function was called.
             */
            @Override
            public void onInterstitialAdReady() {
                Log.e("ironsource","interstitial AdReady");

            }
            /**
             * invoked when there is no Interstitial Ad available after calling load function.
             */
            @Override
            public void onInterstitialAdLoadFailed(IronSourceError error) {
                Log.e("ironsource","interstitial AdLoadFailed erorr " + error.getErrorMessage());

            }
            /**
             * Invoked when the Interstitial Ad Unit is opened
             */
            @Override
            public void onInterstitialAdOpened() {
                Log.e("ironsource","interstitial Ad Opend");
            }
            /*
             * Invoked when the ad is closed and the user is about to return to the application.
             */
            @Override
            public void onInterstitialAdClosed() {
                Log.e("ironsource","interstitial AdClosed");

            }
            /**
             * Invoked when Interstitial ad failed to show.
             * @param error - An object which represents the reason of showInterstitial failure.
             */
            @Override
            public void onInterstitialAdShowFailed(IronSourceError error) {
                Log.e("ironsource","interstitial AdShowFailed" + error.getErrorMessage());

            }
            /*
             * Invoked when the end user clicked on the interstitial ad, for supported networks only.
             */
            @Override
            public void onInterstitialAdClicked() {
                Log.e("ironsource","interstitial AdClicked");

            }
            /** Invoked right before the Interstitial screen is about to open.
             *  NOTE - This event is available only for some of the networks.
             *  You should NOT treat this event as an interstitial impression, but rather use InterstitialAdOpenedEvent
             */
            @Override
            public void onInterstitialAdShowSucceeded() {
                Log.e("ironsource","interstitial AdShowSucceeded");

            }
        });
    }

    public boolean isRewardedAdsReady() {
        return UnityAds.isInitialized();
       // return UnityAds.isReady(videoPlacement);
    }

    public boolean isInterstitialAdsReady() {
        return UnityAds.isInitialized();

//        return UnityAds.isReady(interstitialPlacement);
    }

    public interface AdsStatus {
        default void onAdloaded() {
        }

        default void onAdshown(String type) {
        }
    }
}
