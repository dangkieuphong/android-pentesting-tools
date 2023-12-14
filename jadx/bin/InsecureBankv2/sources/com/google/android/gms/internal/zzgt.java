package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzgd
public class zzgt extends zza.AbstractBinderC0020zza {
    private zzgu zzEW;
    private zzgr zzFc;
    private zzgs zzFd;

    public zzgt(zzgs zzgs) {
        this.zzFd = zzgs;
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zza(zzd zzd, RewardItemParcel rewardItemParcel) {
        if (this.zzFd != null) {
            this.zzFd.zza(rewardItemParcel);
        }
    }

    public void zza(zzgr zzgr) {
        this.zzFc = zzgr;
    }

    public void zza(zzgu zzgu) {
        this.zzEW = zzgu;
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzb(zzd zzd, int i) {
        if (this.zzFc != null) {
            this.zzFc.zzI(i);
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzc(zzd zzd, int i) {
        if (this.zzEW != null) {
            this.zzEW.zzb(zze.zzn(zzd).getClass().getName(), i);
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zze(zzd zzd) {
        if (this.zzFc != null) {
            this.zzFc.zzfO();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzf(zzd zzd) {
        if (this.zzEW != null) {
            this.zzEW.zzap(zze.zzn(zzd).getClass().getName());
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzg(zzd zzd) {
        if (this.zzFd != null) {
            this.zzFd.onRewardedVideoAdOpened();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzh(zzd zzd) {
        if (this.zzFd != null) {
            this.zzFd.onRewardedVideoStarted();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzi(zzd zzd) {
        if (this.zzFd != null) {
            this.zzFd.onRewardedVideoAdClosed();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzj(zzd zzd) {
        if (this.zzFd != null) {
            this.zzFd.zzfL();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzk(zzd zzd) {
        if (this.zzFd != null) {
            this.zzFd.onRewardedVideoAdLeftApplication();
        }
    }
}
