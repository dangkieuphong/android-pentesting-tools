package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzgd
public final class zzem<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzeh zzyg;

    public zzem(zzeh zzeh) {
        this.zzyg = zzeh;
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzay("Adapter called onClick.");
        if (!zzk.zzcA().zzgw()) {
            zzb.zzaC("onClick must be called on the main UI thread.");
            zza.zzGF.post(new Runnable() {
                /* class com.google.android.gms.internal.zzem.AnonymousClass1 */

                public void run() {
                    try {
                        zzem.this.zzyg.onAdClicked();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdClicked.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzyg.onAdClicked();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClicked.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzay("Adapter called onDismissScreen.");
        if (!zzk.zzcA().zzgw()) {
            zzb.zzaC("onDismissScreen must be called on the main UI thread.");
            zza.zzGF.post(new Runnable() {
                /* class com.google.android.gms.internal.zzem.AnonymousClass4 */

                public void run() {
                    try {
                        zzem.this.zzyg.onAdClosed();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdClosed.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzyg.onAdClosed();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzay("Adapter called onDismissScreen.");
        if (!zzk.zzcA().zzgw()) {
            zzb.zzaC("onDismissScreen must be called on the main UI thread.");
            zza.zzGF.post(new Runnable() {
                /* class com.google.android.gms.internal.zzem.AnonymousClass9 */

                public void run() {
                    try {
                        zzem.this.zzyg.onAdClosed();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdClosed.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzyg.onAdClosed();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, final AdRequest.ErrorCode errorCode) {
        zzb.zzay("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (!zzk.zzcA().zzgw()) {
            zzb.zzaC("onFailedToReceiveAd must be called on the main UI thread.");
            zza.zzGF.post(new Runnable() {
                /* class com.google.android.gms.internal.zzem.AnonymousClass5 */

                public void run() {
                    try {
                        zzem.this.zzyg.onAdFailedToLoad(zzen.zza(errorCode));
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdFailedToLoad.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzyg.onAdFailedToLoad(zzen.zza(errorCode));
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, final AdRequest.ErrorCode errorCode) {
        zzb.zzay("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (!zzk.zzcA().zzgw()) {
            zzb.zzaC("onFailedToReceiveAd must be called on the main UI thread.");
            zza.zzGF.post(new Runnable() {
                /* class com.google.android.gms.internal.zzem.AnonymousClass10 */

                public void run() {
                    try {
                        zzem.this.zzyg.onAdFailedToLoad(zzen.zza(errorCode));
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdFailedToLoad.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzyg.onAdFailedToLoad(zzen.zza(errorCode));
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzay("Adapter called onLeaveApplication.");
        if (!zzk.zzcA().zzgw()) {
            zzb.zzaC("onLeaveApplication must be called on the main UI thread.");
            zza.zzGF.post(new Runnable() {
                /* class com.google.android.gms.internal.zzem.AnonymousClass6 */

                public void run() {
                    try {
                        zzem.this.zzyg.onAdLeftApplication();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdLeftApplication.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzyg.onAdLeftApplication();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzay("Adapter called onLeaveApplication.");
        if (!zzk.zzcA().zzgw()) {
            zzb.zzaC("onLeaveApplication must be called on the main UI thread.");
            zza.zzGF.post(new Runnable() {
                /* class com.google.android.gms.internal.zzem.AnonymousClass11 */

                public void run() {
                    try {
                        zzem.this.zzyg.onAdLeftApplication();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdLeftApplication.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzyg.onAdLeftApplication();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzay("Adapter called onPresentScreen.");
        if (!zzk.zzcA().zzgw()) {
            zzb.zzaC("onPresentScreen must be called on the main UI thread.");
            zza.zzGF.post(new Runnable() {
                /* class com.google.android.gms.internal.zzem.AnonymousClass7 */

                public void run() {
                    try {
                        zzem.this.zzyg.onAdOpened();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdOpened.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzyg.onAdOpened();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzay("Adapter called onPresentScreen.");
        if (!zzk.zzcA().zzgw()) {
            zzb.zzaC("onPresentScreen must be called on the main UI thread.");
            zza.zzGF.post(new Runnable() {
                /* class com.google.android.gms.internal.zzem.AnonymousClass2 */

                public void run() {
                    try {
                        zzem.this.zzyg.onAdOpened();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdOpened.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzyg.onAdOpened();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzay("Adapter called onReceivedAd.");
        if (!zzk.zzcA().zzgw()) {
            zzb.zzaC("onReceivedAd must be called on the main UI thread.");
            zza.zzGF.post(new Runnable() {
                /* class com.google.android.gms.internal.zzem.AnonymousClass8 */

                public void run() {
                    try {
                        zzem.this.zzyg.onAdLoaded();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdLoaded.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzyg.onAdLoaded();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzay("Adapter called onReceivedAd.");
        if (!zzk.zzcA().zzgw()) {
            zzb.zzaC("onReceivedAd must be called on the main UI thread.");
            zza.zzGF.post(new Runnable() {
                /* class com.google.android.gms.internal.zzem.AnonymousClass3 */

                public void run() {
                    try {
                        zzem.this.zzyg.onAdLoaded();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdLoaded.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzyg.onAdLoaded();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }
}
