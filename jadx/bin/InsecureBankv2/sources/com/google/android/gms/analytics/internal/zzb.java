package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzns;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class zzb extends zzd {
    private final zzl zzJq;

    public zzb(zzf zzf, zzg zzg) {
        super(zzf);
        zzu.zzu(zzg);
        this.zzJq = zzg.zzj(zzf);
    }

    /* access modifiers changed from: package-private */
    public void onServiceConnected() {
        zzhO();
        this.zzJq.onServiceConnected();
    }

    public void setLocalDispatchPeriod(final int dispatchPeriodInSeconds) {
        zzia();
        zzb("setLocalDispatchPeriod (sec)", Integer.valueOf(dispatchPeriodInSeconds));
        zzhS().zze(new Runnable() {
            /* class com.google.android.gms.analytics.internal.zzb.AnonymousClass1 */

            public void run() {
                zzb.this.zzJq.zzs(((long) dispatchPeriodInSeconds) * 1000);
            }
        });
    }

    public void start() {
        this.zzJq.start();
    }

    public void zzG(final boolean z) {
        zza("Network connectivity status changed", Boolean.valueOf(z));
        zzhS().zze(new Runnable() {
            /* class com.google.android.gms.analytics.internal.zzb.AnonymousClass2 */

            public void run() {
                zzb.this.zzJq.zzG(z);
            }
        });
    }

    public long zza(zzh zzh) {
        zzia();
        zzu.zzu(zzh);
        zzhO();
        long zza = this.zzJq.zza(zzh, true);
        if (zza == 0) {
            this.zzJq.zzc(zzh);
        }
        return zza;
    }

    public void zza(final zzab zzab) {
        zzu.zzu(zzab);
        zzia();
        zzb("Hit delivery requested", zzab);
        zzhS().zze(new Runnable() {
            /* class com.google.android.gms.analytics.internal.zzb.AnonymousClass4 */

            public void run() {
                zzb.this.zzJq.zza(zzab);
            }
        });
    }

    public void zza(final zzw zzw) {
        zzia();
        zzhS().zze(new Runnable() {
            /* class com.google.android.gms.analytics.internal.zzb.AnonymousClass6 */

            public void run() {
                zzb.this.zzJq.zzb(zzw);
            }
        });
    }

    public void zza(final String str, final Runnable runnable) {
        zzu.zzh(str, "campaign param can't be empty");
        zzhS().zze(new Runnable() {
            /* class com.google.android.gms.analytics.internal.zzb.AnonymousClass3 */

            public void run() {
                zzb.this.zzJq.zzbb(str);
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }

    public void zzhG() {
        zzia();
        zzhN();
        zzhS().zze(new Runnable() {
            /* class com.google.android.gms.analytics.internal.zzb.AnonymousClass5 */

            public void run() {
                zzb.this.zzJq.zzhG();
            }
        });
    }

    public void zzhH() {
        zzia();
        Context context = getContext();
        if (!AnalyticsReceiver.zzT(context) || !AnalyticsService.zzU(context)) {
            zza((zzw) null);
            return;
        }
        Intent intent = new Intent(context, AnalyticsService.class);
        intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        context.startService(intent);
    }

    public boolean zzhI() {
        zzia();
        try {
            zzhS().zzb(new Callable<Void>() {
                /* class com.google.android.gms.analytics.internal.zzb.AnonymousClass7 */

                /* renamed from: zzgk */
                public Void call() throws Exception {
                    zzb.this.zzJq.zziF();
                    return null;
                }
            }).get();
            return true;
        } catch (InterruptedException e) {
            zzd("syncDispatchLocalHits interrupted", e);
            return false;
        } catch (ExecutionException e2) {
            zze("syncDispatchLocalHits failed", e2);
            return false;
        }
    }

    public void zzhJ() {
        zzia();
        zzns.zzhO();
        this.zzJq.zzhJ();
    }

    public void zzhK() {
        zzaT("Radio powered up");
        zzhH();
    }

    /* access modifiers changed from: package-private */
    public void zzhL() {
        zzhO();
        this.zzJq.zzhL();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.analytics.internal.zzd
    public void zzhn() {
        this.zzJq.zza();
    }
}
