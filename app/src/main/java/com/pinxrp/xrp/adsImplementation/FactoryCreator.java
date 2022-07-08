package com.pinxrp.xrp.adsImplementation;

import android.app.Activity;

public class FactoryCreator {
    Activity activity;

    public FactoryCreator(Activity activity) {
        this.activity = activity;
    }

    public AdsTypes getAdType(ADS ads) {
        switch (ads) {
            case YODO:
                new YodoAdsImplementation(activity);
                break;
            case IRONSOURCe:
                break;

            default:
                new YodoAdsImplementation(activity);
                break;
        }
        return null;
    }
}

