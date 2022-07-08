package com.pinxrp.xrp.adsImplementation;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.yodo1.mas.Yodo1Mas;
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
        Yodo1MasBannerAdView bannerAdView = new Yodo1MasBannerAdView(activity);
        bannerAdView.setAdSize(Yodo1MasBannerAdSize.Banner);
        bannerAdView.loadAd();
    }
}
