package com.google.android.gms.ads.internal.reward.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardItem;

public class zze implements RewardItem {
    private final zza zzER;

    public zze(zza zza) {
        this.zzER = zza;
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public int getAmount() {
        if (this.zzER == null) {
            return 0;
        }
        try {
            return this.zzER.getAmount();
        } catch (RemoteException e) {
            zzb.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public String getType() {
        if (this.zzER == null) {
            return null;
        }
        try {
            return this.zzER.getType();
        } catch (RemoteException e) {
            zzb.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }
}
