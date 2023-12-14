package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.AbstractPendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.tagmanager.zzbf;
import com.google.android.gms.tagmanager.zzcb;
import com.google.android.gms.tagmanager.zzo;

public class zzp extends AbstractPendingResult<ContainerHolder> {
    private final Context mContext;
    private final Looper zzWt;
    private long zzaKD;
    private final TagManager zzaKK;
    private final zzd zzaKN;
    private final zzcd zzaKO;
    private final int zzaKP;
    private zzf zzaKQ;
    private zzqa zzaKR;
    private volatile zzo zzaKS;
    private volatile boolean zzaKT;
    private zzaf.zzj zzaKU;
    private String zzaKV;
    private zze zzaKW;
    private zza zzaKX;
    private final String zzaKy;
    private final zzlb zzpw;

    /* access modifiers changed from: package-private */
    public interface zza {
        boolean zzb(Container container);
    }

    /* access modifiers changed from: private */
    public class zzb implements zzbf<zzpx.zza> {
        private zzb() {
        }

        /* renamed from: zza */
        public void zzz(zzpx.zza zza) {
            zzaf.zzj zzj;
            if (zza.zzaPa != null) {
                zzj = zza.zzaPa;
            } else {
                zzaf.zzf zzf = zza.zziO;
                zzj = new zzaf.zzj();
                zzj.zziO = zzf;
                zzj.zziN = null;
                zzj.zziP = zzf.version;
            }
            zzp.this.zza(zzj, zza.zzaOZ, true);
        }

        @Override // com.google.android.gms.tagmanager.zzbf
        public void zza(zzbf.zza zza) {
            if (!zzp.this.zzaKT) {
                zzp.this.zzR(0);
            }
        }

        @Override // com.google.android.gms.tagmanager.zzbf
        public void zzyv() {
        }
    }

    /* access modifiers changed from: private */
    public class zzc implements zzbf<zzaf.zzj> {
        private zzc() {
        }

        @Override // com.google.android.gms.tagmanager.zzbf
        public void zza(zzbf.zza zza) {
            synchronized (zzp.this) {
                if (!zzp.this.isReady()) {
                    if (zzp.this.zzaKS != null) {
                        zzp.this.setResult(zzp.this.zzaKS);
                    } else {
                        zzp.this.setResult(zzp.this.createFailedResult(Status.zzXS));
                    }
                }
            }
            zzp.this.zzR(3600000);
        }

        /* renamed from: zzb */
        public void zzz(zzaf.zzj zzj) {
            synchronized (zzp.this) {
                if (zzj.zziO == null) {
                    if (zzp.this.zzaKU.zziO == null) {
                        zzbg.zzaz("Current resource is null; network resource is also null");
                        zzp.this.zzR(3600000);
                        return;
                    }
                    zzj.zziO = zzp.this.zzaKU.zziO;
                }
                zzp.this.zza(zzj, zzp.this.zzpw.currentTimeMillis(), false);
                zzbg.zzaB("setting refresh time to current time: " + zzp.this.zzaKD);
                if (!zzp.this.zzyu()) {
                    zzp.this.zza((zzp) zzj);
                }
            }
        }

        @Override // com.google.android.gms.tagmanager.zzbf
        public void zzyv() {
        }
    }

    /* access modifiers changed from: private */
    public class zzd implements zzo.zza {
        private zzd() {
        }

        @Override // com.google.android.gms.tagmanager.zzo.zza
        public void zzej(String str) {
            zzp.this.zzej(str);
        }

        @Override // com.google.android.gms.tagmanager.zzo.zza
        public String zzyo() {
            return zzp.this.zzyo();
        }

        @Override // com.google.android.gms.tagmanager.zzo.zza
        public void zzyq() {
            if (zzp.this.zzaKO.zzkb()) {
                zzp.this.zzR(0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public interface zze extends Releasable {
        void zza(zzbf<zzaf.zzj> zzbf);

        void zzem(String str);

        void zzf(long j, String str);
    }

    /* access modifiers changed from: package-private */
    public interface zzf extends Releasable {
        void zza(zzbf<zzpx.zza> zzbf);

        void zzb(zzpx.zza zza);

        zzqf.zzc zziR(int i);

        void zzyw();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzp(Context context, TagManager tagManager, Looper looper, String str, int i, zzf zzf2, zze zze2, zzqa zzqa, zzlb zzlb, zzcd zzcd) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.mContext = context;
        this.zzaKK = tagManager;
        this.zzWt = looper == null ? Looper.getMainLooper() : looper;
        this.zzaKy = str;
        this.zzaKP = i;
        this.zzaKQ = zzf2;
        this.zzaKW = zze2;
        this.zzaKR = zzqa;
        this.zzaKN = new zzd();
        this.zzaKU = new zzaf.zzj();
        this.zzpw = zzlb;
        this.zzaKO = zzcd;
        if (zzyu()) {
            zzej(zzcb.zzzf().zzzh());
        }
    }

    public zzp(Context context, TagManager tagManager, Looper looper, String str, int i, zzs zzs) {
        this(context, tagManager, looper, str, i, new zzcn(context, str), new zzcm(context, str, zzs), new zzqa(context), zzld.zzoQ(), new zzbe(30, 900000, 5000, "refreshing", zzld.zzoQ()));
        this.zzaKR.zzeU(zzs.zzyx());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void zzR(long j) {
        if (this.zzaKW == null) {
            zzbg.zzaC("Refresh requested, but no network load scheduler.");
        } else {
            this.zzaKW.zzf(j, this.zzaKU.zziP);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void zza(zzaf.zzj zzj) {
        if (this.zzaKQ != null) {
            zzpx.zza zza2 = new zzpx.zza();
            zza2.zzaOZ = this.zzaKD;
            zza2.zziO = new zzaf.zzf();
            zza2.zzaPa = zzj;
            this.zzaKQ.zzb(zza2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r8.zzaKT != false) goto L_0x000a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void zza(com.google.android.gms.internal.zzaf.zzj r9, long r10, boolean r12) {
        /*
        // Method dump skipped, instructions count: 115
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzp.zza(com.google.android.gms.internal.zzaf$zzj, long, boolean):void");
    }

    private void zzam(final boolean z) {
        this.zzaKQ.zza(new zzb());
        this.zzaKW.zza(new zzc());
        zzqf.zzc zziR = this.zzaKQ.zziR(this.zzaKP);
        if (zziR != null) {
            this.zzaKS = new zzo(this.zzaKK, this.zzWt, new Container(this.mContext, this.zzaKK.getDataLayer(), this.zzaKy, 0, zziR), this.zzaKN);
        }
        this.zzaKX = new zza() {
            /* class com.google.android.gms.tagmanager.zzp.AnonymousClass3 */

            @Override // com.google.android.gms.tagmanager.zzp.zza
            public boolean zzb(Container container) {
                return z ? container.getLastRefreshTime() + 43200000 >= zzp.this.zzpw.currentTimeMillis() : !container.isDefault();
            }
        };
        if (zzyu()) {
            this.zzaKW.zzf(0, "");
        } else {
            this.zzaKQ.zzyw();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean zzyu() {
        zzcb zzzf = zzcb.zzzf();
        return (zzzf.zzzg() == zzcb.zza.CONTAINER || zzzf.zzzg() == zzcb.zza.CONTAINER_DEBUG) && this.zzaKy.equals(zzzf.getContainerId());
    }

    public void load(final String resourceIdParameterName) {
        this.zzaKR.zza(this.zzaKy, this.zzaKP != -1 ? Integer.valueOf(this.zzaKP) : null, resourceIdParameterName, new zzqa.zza() {
            /* class com.google.android.gms.tagmanager.zzp.AnonymousClass1 */

            @Override // com.google.android.gms.internal.zzqa.zza
            public void zza(zzqe zzqe) {
                if (zzqe.getStatus() != Status.zzXP) {
                    zzbg.zzaz("Load request failed for the container " + zzp.this.zzaKy);
                    zzp.this.setResult(zzp.this.createFailedResult(Status.zzXR));
                    return;
                }
                zzqf.zzc zzAk = zzqe.zzAg().zzAk();
                if (zzAk == null) {
                    zzbg.zzaz("Response doesn't have the requested container");
                    zzp.this.setResult(zzp.this.createFailedResult(new Status(8, "Response doesn't have the requested container", null)));
                    return;
                }
                long zzAl = zzqe.zzAg().zzAl();
                zzp.this.zzaKS = new zzo(zzp.this.zzaKK, zzp.this.zzWt, new Container(zzp.this.mContext, zzp.this.zzaKK.getDataLayer(), zzp.this.zzaKy, zzAl, zzAk), new zzo.zza() {
                    /* class com.google.android.gms.tagmanager.zzp.AnonymousClass1.AnonymousClass1 */

                    @Override // com.google.android.gms.tagmanager.zzo.zza
                    public void zzej(String str) {
                        zzp.this.zzej(str);
                    }

                    @Override // com.google.android.gms.tagmanager.zzo.zza
                    public String zzyo() {
                        return zzp.this.zzyo();
                    }

                    @Override // com.google.android.gms.tagmanager.zzo.zza
                    public void zzyq() {
                        if (zzp.this.zzaKO.zzkb()) {
                            zzp.this.load(resourceIdParameterName);
                        }
                    }
                });
                zzp.this.setResult(zzp.this.zzaKS);
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzaU */
    public ContainerHolder createFailedResult(Status status) {
        if (this.zzaKS != null) {
            return this.zzaKS;
        }
        if (status == Status.zzXS) {
            zzbg.zzaz("timer expired: setting result to failure");
        }
        return new zzo(status);
    }

    /* access modifiers changed from: package-private */
    public synchronized void zzej(String str) {
        this.zzaKV = str;
        if (this.zzaKW != null) {
            this.zzaKW.zzem(str);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized String zzyo() {
        return this.zzaKV;
    }

    public void zzyr() {
        zzqf.zzc zziR = this.zzaKQ.zziR(this.zzaKP);
        if (zziR != null) {
            setResult(new zzo(this.zzaKK, this.zzWt, new Container(this.mContext, this.zzaKK.getDataLayer(), this.zzaKy, 0, zziR), new zzo.zza() {
                /* class com.google.android.gms.tagmanager.zzp.AnonymousClass2 */

                @Override // com.google.android.gms.tagmanager.zzo.zza
                public void zzej(String str) {
                    zzp.this.zzej(str);
                }

                @Override // com.google.android.gms.tagmanager.zzo.zza
                public String zzyo() {
                    return zzp.this.zzyo();
                }

                @Override // com.google.android.gms.tagmanager.zzo.zza
                public void zzyq() {
                    zzbg.zzaC("Refresh ignored: container loaded as default only.");
                }
            }));
        } else {
            zzbg.zzaz("Default was requested, but no default container was found");
            setResult(createFailedResult(new Status(10, "Default was requested, but no default container was found", null)));
        }
        this.zzaKW = null;
        this.zzaKQ = null;
    }

    public void zzys() {
        zzam(false);
    }

    public void zzyt() {
        zzam(true);
    }
}
