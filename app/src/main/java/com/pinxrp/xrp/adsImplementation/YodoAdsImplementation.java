package com.pinxrp.xrp.adsImplementation;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;

import com.yodo1.mas.Yodo1Mas;
import com.yodo1.mas.banner.Yodo1MasBannerAdListener;
import com.yodo1.mas.banner.Yodo1MasBannerAdSize;
import com.yodo1.mas.banner.Yodo1MasBannerAdView;
import com.yodo1.mas.error.Yodo1MasError;
import com.yodo1.mas.interstitial.Yodo1MasInterstitialAd;
import com.yodo1.mas.interstitial.Yodo1MasInterstitialAdListener;
import com.yodo1.mas.reward.Yodo1MasRewardAd;
import com.yodo1.mas.reward.Yodo1MasRewardAdListener;

public class YodoAdsImplementation implements AdsTypes {
    Activity activity;

    YodoAdsImplementation(Activity activity) {
        this.activity = activity;
        Yodo1Mas.getInstance().initMas(activity, "ITp8nXaVxG", new Yodo1Mas.InitListener() {
            @Override
            public void onMasInitSuccessful() {
            }

            @Override
            public void onMasInitFailed(@NonNull Yodo1MasError error) {

            }
        });
    }

    @Override
    public void showRewardVedios() {
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

    @Override
    public void showInterstitial() {
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

    @Override
    public void showNativeAds() {

    }

    @Override
    public void showBannerAdas() {

        // Load banner ads, the banner ad will be displayed automatically after loaded
        Yodo1MasBannerAdView bannerAdView = new Yodo1MasBannerAdView(activity);
        bannerAdView.setAdSize(Yodo1MasBannerAdSize.Banner);
        bannerAdView.setAdListener(new Yodo1MasBannerAdListener() {
            @Override
            public void onBannerAdLoaded(Yodo1MasBannerAdView bannerAdView) {
                Log.e("yodo", "banner loaded");

            }

            @Override
            public void onBannerAdFailedToLoad(Yodo1MasBannerAdView bannerAdView, @NonNull Yodo1MasError error) {
                Log.e("yodo", "yodo banner ad failed to load  " + error.getMessage());
            }

            @Override
            public void onBannerAdOpened(Yodo1MasBannerAdView bannerAdView) {
                Log.e("yodo", "banner opened");

            }

            @Override
            public void onBannerAdFailedToOpen(Yodo1MasBannerAdView bannerAdView, @NonNull Yodo1MasError error) {
                Log.e("yodo", "yodo banner ad failed to open  " + error.getMessage());

            }

            @Override
            public void onBannerAdClosed(Yodo1MasBannerAdView bannerAdView) {

            }
        });
        bannerAdView.loadAd();

    }
}
