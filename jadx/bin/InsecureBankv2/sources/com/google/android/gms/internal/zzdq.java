package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzgd
public class zzdq implements Iterable<zzdp> {
    private final List<zzdp> zzwE = new LinkedList();

    private zzdp zzc(zzid zzid) {
        Iterator<zzdp> it = zzo.zzbH().iterator();
        while (it.hasNext()) {
            zzdp next = it.next();
            if (next.zzoA == zzid) {
                return next;
            }
        }
        return null;
    }

    @Override // java.lang.Iterable
    public Iterator<zzdp> iterator() {
        return this.zzwE.iterator();
    }

    public void zza(zzdp zzdp) {
        this.zzwE.add(zzdp);
    }

    public boolean zza(zzid zzid) {
        zzdp zzc = zzc(zzid);
        if (zzc == null) {
            return false;
        }
        zzc.zzwB.abort();
        return true;
    }

    public void zzb(zzdp zzdp) {
        this.zzwE.remove(zzdp);
    }

    public boolean zzb(zzid zzid) {
        return zzc(zzid) != null;
    }
}
