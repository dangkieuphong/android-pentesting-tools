package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzgd
public class zzbi {
    private final Object zzqt = new Object();
    private int zzrt;
    private List<zzbh> zzru = new LinkedList();

    public boolean zza(zzbh zzbh) {
        boolean z;
        synchronized (this.zzqt) {
            z = this.zzru.contains(zzbh);
        }
        return z;
    }

    public boolean zzb(zzbh zzbh) {
        boolean z;
        synchronized (this.zzqt) {
            Iterator<zzbh> it = this.zzru.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                zzbh next = it.next();
                if (zzbh != next && next.zzci().equals(zzbh.zzci())) {
                    it.remove();
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    public void zzc(zzbh zzbh) {
        synchronized (this.zzqt) {
            if (this.zzru.size() >= 10) {
                zzb.zzay("Queue is full, current size = " + this.zzru.size());
                this.zzru.remove(0);
            }
            int i = this.zzrt;
            this.zzrt = i + 1;
            zzbh.zzg(i);
            this.zzru.add(zzbh);
        }
    }

    public zzbh zzco() {
        int i;
        zzbh zzbh;
        zzbh zzbh2 = null;
        synchronized (this.zzqt) {
            if (this.zzru.size() == 0) {
                zzb.zzay("Queue empty");
                return null;
            } else if (this.zzru.size() >= 2) {
                int i2 = Integer.MIN_VALUE;
                for (zzbh zzbh3 : this.zzru) {
                    int score = zzbh3.getScore();
                    if (score > i2) {
                        zzbh = zzbh3;
                        i = score;
                    } else {
                        i = i2;
                        zzbh = zzbh2;
                    }
                    i2 = i;
                    zzbh2 = zzbh;
                }
                this.zzru.remove(zzbh2);
                return zzbh2;
            } else {
                zzbh zzbh4 = this.zzru.get(0);
                zzbh4.zzcj();
                return zzbh4;
            }
        }
    }
}
