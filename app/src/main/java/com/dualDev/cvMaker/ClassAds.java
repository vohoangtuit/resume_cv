package com.dualDev.cvMaker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class ClassAds {

    @SuppressLint("MissingPermission")
    public void mobileAds(Context context, InterstitialAd mInterstitialAd) {
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(context, context.getResources().getString(R.string.admob_app_id));// admob_app_id  // admob_reward
        if (!mInterstitialAd.isLoading() && !mInterstitialAd.isLoaded()) {
            AdRequest adRequestInter = new AdRequest.Builder().build();
            mInterstitialAd.loadAd(adRequestInter);
        }
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
            }
        });
        // todo check status ads
        mInterstitialAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
            @Override
            public void onRewardedVideoAdLoaded() {
                Log.e("Tú ","onRewardedVideoAdLoaded");
            }

            @Override
            public void onRewardedVideoAdOpened() {
                Log.e("Tú ","onRewardedVideoAdOpened");
            }

            @Override
            public void onRewardedVideoStarted() {
                Log.e("Tú ","onRewardedVideoStarted");
            }

            @Override
            public void onRewardedVideoAdClosed() {
                Log.e("Tú ","onRewardedVideoAdClosed");
            }

            @Override
            public void onRewarded(RewardItem rewardItem) {
                Log.e("Tú ","onRewarded");
            }

            @Override
            public void onRewardedVideoAdLeftApplication() {
                Log.e("Tú ","onRewardedVideoAdLeftApplication");
            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int i) {
                Log.e("Tú ","onRewardedVideoAdFailedToLoad");
            }

            @Override
            public void onRewardedVideoCompleted() {
                Log.e("Tú ","onRewardedVideoCompleted");
            }
        });

    }
}
