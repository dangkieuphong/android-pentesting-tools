package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

@zzgd
public class zzay implements zzba {
    private final VersionInfoParcel zzoM;
    private final Object zzqt = new Object();
    private final WeakHashMap<zzha, zzaz> zzqu = new WeakHashMap<>();
    private final ArrayList<zzaz> zzqv = new ArrayList<>();
    private final Context zzqw;
    private final zzdt zzqx;

    public zzay(Context context, VersionInfoParcel versionInfoParcel, zzdt zzdt) {
        this.zzqw = context.getApplicationContext();
        this.zzoM = versionInfoParcel;
        this.zzqx = zzdt;
    }

    public zzaz zza(AdSizeParcel adSizeParcel, zzha zzha) {
        return zza(adSizeParcel, zzha, zzha.zzzE.getWebView());
    }

    public zzaz zza(AdSizeParcel adSizeParcel, zzha zzha, View view) {
        zzaz zzaz;
        synchronized (this.zzqt) {
            if (zzf(zzha)) {
                zzaz = this.zzqu.get(zzha);
            } else {
                zzaz = new zzaz(adSizeParcel, zzha, this.zzoM, view, this.zzqx);
                zzaz.zza(this);
                this.zzqu.put(zzha, zzaz);
                this.zzqv.add(zzaz);
            }
        }
        return zzaz;
    }

    @Override // com.google.android.gms.internal.zzba
    public void zza(zzaz zzaz) {
        synchronized (this.zzqt) {
            if (!zzaz.zzbZ()) {
                this.zzqv.remove(zzaz);
                Iterator<Map.Entry<zzha, zzaz>> it = this.zzqu.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue() == zzaz) {
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean zzf(zzha zzha) {
        boolean z;
        synchronized (this.zzqt) {
            zzaz zzaz = this.zzqu.get(zzha);
            z = zzaz != null && zzaz.zzbZ();
        }
        return z;
    }

    public void zzg(zzha zzha) {
        synchronized (this.zzqt) {
            zzaz zzaz = this.zzqu.get(zzha);
            if (zzaz != null) {
                zzaz.zzbX();
            }
        }
    }

    public void zzh(zzha zzha) {
        synchronized (this.zzqt) {
            zzaz zzaz = this.zzqu.get(zzha);
            if (zzaz != null) {
                zzaz.stop();
            }
        }
    }

    public void zzi(zzha zzha) {
        synchronized (this.zzqt) {
            zzaz zzaz = this.zzqu.get(zzha);
            if (zzaz != null) {
                zzaz.pause();
            }
        }
    }

    public void zzj(zzha zzha) {
        synchronized (this.zzqt) {
            zzaz zzaz = this.zzqu.get(zzha);
            if (zzaz != null) {
                zzaz.resume();
            }
        }
    }
}
