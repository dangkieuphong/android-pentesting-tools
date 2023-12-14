package com.google.android.gms.internal;

import android.os.Binder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@zzgd
public class zzbw {
    private final Collection<zzbv<String>> zztA = new ArrayList();
    private final Collection<zzbs> zzty = new ArrayList();
    private final Collection<zzbv<String>> zztz = new ArrayList();

    public void zza(zzbs zzbs) {
        this.zzty.add(zzbs);
    }

    public void zza(zzbv<String> zzbv) {
        this.zztz.add(zzbv);
    }

    public void zzb(zzbv<String> zzbv) {
        this.zztA.add(zzbv);
    }

    public List<String> zzda() {
        ArrayList arrayList = new ArrayList();
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            for (zzbv<String> zzbv : this.zztA) {
                String str = zzbv.zzcZ().get();
                if (str != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public List<String> zzdb() {
        ArrayList arrayList = new ArrayList();
        for (zzbv<String> zzbv : this.zztz) {
            String str = zzbv.get();
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
