package com.google.android.gms.internal;

import android.content.Context;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzha;

@zzgd
public class zzfw extends zzfs {
    private zzdw zzBA;
    protected zzec zzBB;
    private zzef zzoq;
    private zzdy zzxn;

    zzfw(Context context, zzha.zza zza, zzid zzid, zzef zzef, zzft.zza zza2) {
        super(context, zza, zzid, zza2);
        this.zzoq = zzef;
        this.zzxn = zza.zzFm;
    }

    @Override // com.google.android.gms.internal.zzhh, com.google.android.gms.internal.zzfs
    public void onStop() {
        synchronized (this.zzBr) {
            super.onStop();
            if (this.zzBA != null) {
                this.zzBA.cancel();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfs
    public void zzh(long j) throws zzfs.zza {
        synchronized (this.zzBr) {
            this.zzBA = new zzdw(this.mContext, this.zzBs.zzFr, this.zzoq, this.zzxn);
        }
        this.zzBB = this.zzBA.zza(j, 60000);
        switch (this.zzBB.zzxY) {
            case 0:
                return;
            case 1:
                throw new zzfs.zza("No fill from any mediation ad networks.", 3);
            default:
                throw new zzfs.zza("Unexpected mediation result: " + this.zzBB.zzxY, 0);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfs
    public zzha zzz(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.zzBs.zzFr;
        return new zzha(adRequestInfoParcel.zzCm, this.zzoA, this.zzBt.zzxF, i, this.zzBt.zzxG, this.zzBt.zzCM, this.zzBt.orientation, this.zzBt.zzxJ, adRequestInfoParcel.zzCp, this.zzBt.zzCK, this.zzBB != null ? this.zzBB.zzxZ : null, this.zzBB != null ? this.zzBB.zzya : null, this.zzBB != null ? this.zzBB.zzyb : AdMobAdapter.class.getName(), this.zzxn, this.zzBB != null ? this.zzBB.zzyc : null, this.zzBt.zzCL, this.zzBs.zzpN, this.zzBt.zzCJ, this.zzBs.zzFo, this.zzBt.zzCO, this.zzBt.zzCP, this.zzBs.zzFl, null, adRequestInfoParcel.zzCC);
    }
}
