package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzqn;
import com.google.android.gms.tagmanager.zzbg;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzqa {
    private final Context mContext;
    private String zzaLc;
    private final zzqh zzaPe;
    Map<String, zzc<zzqf.zzc>> zzaPf;
    private final Map<String, zzqp> zzaPg;
    private final zzlb zzpw;

    public interface zza {
        void zza(zzqe zzqe);
    }

    class zzb extends zzqn {
        private final zza zzaPk;

        zzb(zzqd zzqd, zzqb zzqb, zza zza) {
            super(zzqd, zzqb);
            this.zzaPk = zza;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzqn
        public zzqn.zzb zza(zzpy zzpy) {
            return null;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzqn
        public void zza(zzqe zzqe) {
            zzqe.zza zzAg = zzqe.zzAg();
            zzqa.this.zza(zzAg);
            if (zzAg.getStatus() != Status.zzXP || zzAg.zzAh() != zzqe.zza.EnumC0142zza.NETWORK || zzAg.zzAi() == null || zzAg.zzAi().length <= 0) {
                zzbg.zzaB("Response status: " + (zzAg.getStatus().isSuccess() ? "SUCCESS" : "FAILURE"));
                if (zzAg.getStatus().isSuccess()) {
                    zzbg.zzaB("Response source: " + zzAg.zzAh().toString());
                    zzbg.zzaB("Response size: " + zzAg.zzAi().length);
                }
                zzqa.this.zza(zzAg.zzAj(), this.zzaPk);
                return;
            }
            zzqa.this.zzaPe.zze(zzAg.zzAj().zzAb(), zzAg.zzAi());
            zzbg.zzaB("Resource successfully load from Network.");
            this.zzaPk.zza(zzqe);
        }
    }

    /* access modifiers changed from: package-private */
    public static class zzc<T> {
        private T mData;
        private Status zzOt;
        private long zzaPl;

        public zzc(Status status, T t, long j) {
            this.zzOt = status;
            this.mData = t;
            this.zzaPl = j;
        }

        public long zzAe() {
            return this.zzaPl;
        }

        public void zzO(T t) {
            this.mData = t;
        }

        public void zzU(long j) {
            this.zzaPl = j;
        }

        public void zzaV(Status status) {
            this.zzOt = status;
        }
    }

    public zzqa(Context context) {
        this(context, new HashMap(), new zzqh(context), zzld.zzoQ());
    }

    zzqa(Context context, Map<String, zzqp> map, zzqh zzqh, zzlb zzlb) {
        this.zzaLc = null;
        this.zzaPf = new HashMap();
        this.mContext = context;
        this.zzpw = zzlb;
        this.zzaPe = zzqh;
        this.zzaPg = map;
    }

    private void zza(zzqd zzqd, zza zza2) {
        boolean z = true;
        List<zzpy> zzAf = zzqd.zzAf();
        if (zzAf.size() != 1) {
            z = false;
        }
        zzu.zzV(z);
        zza(zzAf.get(0), zza2);
    }

    /* access modifiers changed from: package-private */
    public void zza(final zzpy zzpy, final zza zza2) {
        this.zzaPe.zza(zzpy.zzAb(), zzpy.zzzZ(), zzqc.zzaPm, new zzqg() {
            /* class com.google.android.gms.internal.zzqa.AnonymousClass1 */

            @Override // com.google.android.gms.internal.zzqg
            public void zza(Status status, Object obj, Integer num, long j) {
                zzqe.zza zza;
                if (status.isSuccess()) {
                    zza = new zzqe.zza(Status.zzXP, zzpy, null, (zzqf.zzc) obj, num == zzqh.zzaPM ? zzqe.zza.EnumC0142zza.DEFAULT : zzqe.zza.EnumC0142zza.DISK, j);
                } else {
                    zza = new zzqe.zza(new Status(16, "There is no valid resource for the container: " + zzpy.getContainerId()), null, zzqe.zza.EnumC0142zza.DISK);
                }
                zza2.zza(new zzqe(zza));
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void zza(zzqd zzqd, zza zza2, zzqn zzqn) {
        zzqp zzqp;
        boolean z = false;
        for (zzpy zzpy : zzqd.zzAf()) {
            zzc<zzqf.zzc> zzc2 = this.zzaPf.get(zzpy.getContainerId());
            z = (zzc2 != null ? zzc2.zzAe() : this.zzaPe.zzfa(zzpy.getContainerId())) + 900000 < this.zzpw.currentTimeMillis() ? true : z;
        }
        if (z) {
            zzqp zzqp2 = this.zzaPg.get(zzqd.getId());
            if (zzqp2 == null) {
                zzqp zzqp3 = this.zzaLc == null ? new zzqp() : new zzqp(this.zzaLc);
                this.zzaPg.put(zzqd.getId(), zzqp3);
                zzqp = zzqp3;
            } else {
                zzqp = zzqp2;
            }
            zzqp.zza(this.mContext, zzqd, 0, zzqn);
            return;
        }
        zza(zzqd, zza2);
    }

    /* access modifiers changed from: package-private */
    public void zza(zzqe.zza zza2) {
        String containerId = zza2.zzAj().getContainerId();
        Status status = zza2.getStatus();
        zzqf.zzc zzAk = zza2.zzAk();
        if (this.zzaPf.containsKey(containerId)) {
            zzc<zzqf.zzc> zzc2 = this.zzaPf.get(containerId);
            zzc2.zzU(this.zzpw.currentTimeMillis());
            if (status == Status.zzXP) {
                zzc2.zzaV(status);
                zzc2.zzO(zzAk);
                return;
            }
            return;
        }
        this.zzaPf.put(containerId, new zzc<>(status, zzAk, this.zzpw.currentTimeMillis()));
    }

    public void zza(String str, Integer num, String str2, zza zza2) {
        zzqd zzb2 = new zzqd().zzb(new zzpy(str, num, str2, false));
        zza(zzb2, zza2, new zzb(zzb2, zzqc.zzaPm, zza2));
    }

    public void zzeU(String str) {
        this.zzaLc = str;
    }
}
