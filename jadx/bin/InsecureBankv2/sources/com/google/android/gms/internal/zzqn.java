package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.tagmanager.zzbg;

public abstract class zzqn {
    private zzqd zzaPU;
    private zzqb zzaPV;
    private zzlb zzpw;

    public enum zza {
        NOT_AVAILABLE,
        IO_ERROR,
        SERVER_ERROR
    }

    public class zzb {
        private final zzqe.zza.EnumC0142zza zzaPp;
        private final long zzaPr;
        private final Object zzaQa;

        public Object zzAH() {
            return this.zzaQa;
        }

        public zzqe.zza.EnumC0142zza zzAh() {
            return this.zzaPp;
        }

        public long zzAl() {
            return this.zzaPr;
        }
    }

    public zzqn(zzqd zzqd, zzqb zzqb) {
        this(zzqd, zzqb, zzld.zzoQ());
    }

    public zzqn(zzqd zzqd, zzqb zzqb, zzlb zzlb) {
        zzu.zzV(zzqd.zzAf().size() != 1 ? false : true);
        this.zzaPU = zzqd;
        this.zzaPV = zzqb;
        this.zzpw = zzlb;
    }

    /* access modifiers changed from: protected */
    public abstract zzb zza(zzpy zzpy);

    /* access modifiers changed from: protected */
    public abstract void zza(zzqe zzqe);

    public void zza(zza zza2) {
        zzbg.zzaz("ResourceManager: Failed to download a resource: " + zza2.name());
        zzpy zzpy = this.zzaPU.zzAf().get(0);
        zzb zza3 = zza(zzpy);
        zza(new zzqe((zza3 == null || !(zza3.zzAH() instanceof zzqf.zzc)) ? new zzqe.zza(Status.zzXR, zzpy, zzqe.zza.EnumC0142zza.NETWORK) : new zzqe.zza(Status.zzXP, zzpy, null, (zzqf.zzc) zza3.zzAH(), zza3.zzAh(), zza3.zzAl())));
    }

    public void zzu(byte[] bArr) {
        long j;
        zzqe.zza.EnumC0142zza zza2;
        zzqf.zzc zzc;
        zzbg.zzaB("ResourceManager: Resource downloaded from Network: " + this.zzaPU.getId());
        zzpy zzpy = this.zzaPU.zzAf().get(0);
        zzqe.zza.EnumC0142zza zza3 = zzqe.zza.EnumC0142zza.NETWORK;
        try {
            Object zzt = this.zzaPV.zzt(bArr);
            long currentTimeMillis = this.zzpw.currentTimeMillis();
            if (zzt == null) {
                zzbg.zzaA("Parsed resource from network is null");
                zzb zza4 = zza(zzpy);
                if (zza4 != null) {
                    zzt = zza4.zzAH();
                    zza3 = zza4.zzAh();
                    currentTimeMillis = zza4.zzAl();
                }
            }
            j = currentTimeMillis;
            zza2 = zza3;
            zzc = zzt;
        } catch (zzqf.zzg e) {
            zzbg.zzaA("Resource from network is corrupted");
            zzb zza5 = zza(zzpy);
            if (zza5 != null) {
                Object zzAH = zza5.zzAH();
                j = 0;
                zza2 = zza5.zzAh();
                zzc = zzAH;
            } else {
                j = 0;
                zza2 = zza3;
                zzc = null;
            }
        }
        zza(new zzqe(zzc != null ? new zzqe.zza(Status.zzXP, zzpy, bArr, zzc, zza2, j) : new zzqe.zza(Status.zzXR, zzpy, zzqe.zza.EnumC0142zza.NETWORK)));
    }
}
