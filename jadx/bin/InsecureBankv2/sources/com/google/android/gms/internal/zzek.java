package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.internal.zzu;

@zzgd
public final class zzek implements MediationBannerListener, MediationInterstitialListener {
    private final zzeh zzyg;

    public zzek(zzeh zzeh) {
        this.zzyg = zzeh;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public void onAdClicked(MediationBannerAdapter adapter) {
        zzu.zzbY("onAdClicked must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdClicked.");
        try {
            this.zzyg.onAdClicked();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClicked.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public void onAdClicked(MediationInterstitialAdapter adapter) {
        zzu.zzbY("onAdClicked must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdClicked.");
        try {
            this.zzyg.onAdClicked();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClicked.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public void onAdClosed(MediationBannerAdapter adapter) {
        zzu.zzbY("onAdClosed must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdClosed.");
        try {
            this.zzyg.onAdClosed();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public void onAdClosed(MediationInterstitialAdapter adapter) {
        zzu.zzbY("onAdClosed must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdClosed.");
        try {
            this.zzyg.onAdClosed();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public void onAdFailedToLoad(MediationBannerAdapter adapter, int errorCode) {
        zzu.zzbY("onAdFailedToLoad must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdFailedToLoad with error. " + errorCode);
        try {
            this.zzyg.onAdFailedToLoad(errorCode);
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public void onAdFailedToLoad(MediationInterstitialAdapter adapter, int errorCode) {
        zzu.zzbY("onAdFailedToLoad must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdFailedToLoad with error " + errorCode + ".");
        try {
            this.zzyg.onAdFailedToLoad(errorCode);
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public void onAdLeftApplication(MediationBannerAdapter adapter) {
        zzu.zzbY("onAdLeftApplication must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdLeftApplication.");
        try {
            this.zzyg.onAdLeftApplication();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public void onAdLeftApplication(MediationInterstitialAdapter adapter) {
        zzu.zzbY("onAdLeftApplication must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdLeftApplication.");
        try {
            this.zzyg.onAdLeftApplication();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public void onAdLoaded(MediationBannerAdapter adapter) {
        zzu.zzbY("onAdLoaded must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdLoaded.");
        try {
            this.zzyg.onAdLoaded();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public void onAdLoaded(MediationInterstitialAdapter adapter) {
        zzu.zzbY("onAdLoaded must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdLoaded.");
        try {
            this.zzyg.onAdLoaded();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public void onAdOpened(MediationBannerAdapter adapter) {
        zzu.zzbY("onAdOpened must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdOpened.");
        try {
            this.zzyg.onAdOpened();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public void onAdOpened(MediationInterstitialAdapter adapter) {
        zzu.zzbY("onAdOpened must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdOpened.");
        try {
            this.zzyg.onAdOpened();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }
}
