package com.pinxrp.xrp.helper;

import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.pinxrp.xrp.BaseActivity;
import com.pinxrp.xrp.R;
import com.pinxrp.xrp.adsImplementation.ADS;
import com.pinxrp.xrp.adsImplementation.AdsTypes;
import com.pinxrp.xrp.adsImplementation.FactoryCreator;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import com.yodo1.mas.error.Yodo1MasError;
import com.yodo1.mas.interstitial.Yodo1MasInterstitialAd;
import com.yodo1.mas.interstitial.Yodo1MasInterstitialAdListener;
import com.yodo1.mas.reward.Yodo1MasRewardAd;
import com.yodo1.mas.reward.Yodo1MasRewardAdListener;

public class AdsUtils {
    final String TAG = AdsUtils.class.getName();
    public static String APP_ID = "4107295";
    public static String APP_ID_IRON_SOURCE = "130bb405d";

    public static String bannerPlacement = "banner";
    public static String interstitialPlacement = "video";
    public static String videoPlacement = "rewardedVideo";
    public static Boolean testMode = false;
    static AdsUtils instance;
    AdsStatus listener;
    AdsTypes adsTypesChooser;

    AdsUtils(BaseActivity activity) {
        //  UnityAds.initialize(activity, AdsUtils.APP_ID, true);

        FactoryCreator factoryCreator = new FactoryCreator(activity);
        adsTypesChooser = factoryCreator.getAdType(ADS.YODO);



        //   IntegrationHelper.validateIntegration(activity);

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
//        if (UnityAds.isInitialized()) {
//            UnityAds.show(activity, interstitialPlacement);
//        }
     //   adsTypesChooser.showInterstitial();

        Yodo1MasInterstitialAd.getInstance().setAdListener(new Yodo1MasInterstitialAdListener() {

            @Override
            public void onInterstitialAdLoaded(Yodo1MasInterstitialAd ad) {

            }

            @Override
            public void onInterstitialAdFailedToLoad(Yodo1MasInterstitialAd ad, @NonNull Yodo1MasError error) {

            }

            @Override
            public void onInterstitialAdOpened(Yodo1MasInterstitialAd ad) {

            }

            @Override
            public void onInterstitialAdFailedToOpen(Yodo1MasInterstitialAd ad, @NonNull Yodo1MasError error) {
                ad.loadAd(activity);
            }

            @Override
            public void onInterstitialAdClosed(Yodo1MasInterstitialAd ad) {
                //ad.loadAd(activity);
            }
        });
        Yodo1MasInterstitialAd.getInstance().loadAndShowAd(activity);

    }

    public void showRewardedAd(AppCompatActivity activity) {

//        if (UnityAds.isInitialized()) {
//            UnityAds.show(activity, videoPlacement);
//        }

//        adsTypesChooser.showRewardVedios();

        Yodo1MasRewardAd.getInstance().setAdListener(new Yodo1MasRewardAdListener() {

            @Override
            public void onRewardAdLoaded(Yodo1MasRewardAd ad) {

            }

            @Override
            public void onRewardAdFailedToLoad(Yodo1MasRewardAd ad, @NonNull Yodo1MasError error) {

            }

            @Override
            public void onRewardAdOpened(Yodo1MasRewardAd ad) {

            }

            @Override
            public void onRewardAdFailedToOpen(Yodo1MasRewardAd ad, @NonNull Yodo1MasError error) {
                ad.loadAd(activity);
            }

            @Override
            public void onRewardAdClosed(Yodo1MasRewardAd ad) {
                ad.loadAd(activity);
            }

            @Override
            public void onRewardAdEarned(Yodo1MasRewardAd ad) {

            }
        });
        Yodo1MasRewardAd.getInstance().loadAndShowAd(activity);





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
