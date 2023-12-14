package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzal;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class zzam extends zzal {
    private static AdvertisingIdClient zznn = null;
    private static CountDownLatch zzno = new CountDownLatch(1);
    private static boolean zznp;
    private boolean zznq;

    /* access modifiers changed from: package-private */
    public class zza {
        private String zznr;
        private boolean zzns;

        public zza(String str, boolean z) {
            this.zznr = str;
            this.zzns = z;
        }

        public String getId() {
            return this.zznr;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzns;
        }
    }

    private static final class zzb implements Runnable {
        private Context zznu;

        public zzb(Context context) {
            this.zznu = context.getApplicationContext();
            if (this.zznu == null) {
                this.zznu = context;
            }
        }

        public void run() {
            try {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zznu);
                advertisingIdClient.start();
                synchronized (zzam.class) {
                    if (zzam.zznn == null) {
                        AdvertisingIdClient unused = zzam.zznn = advertisingIdClient;
                    } else {
                        advertisingIdClient.finish();
                    }
                }
            } catch (GooglePlayServicesNotAvailableException e) {
                boolean unused2 = zzam.zznp = true;
            } catch (GooglePlayServicesRepairableException | IOException e2) {
            }
            zzam.zzno.countDown();
        }
    }

    protected zzam(Context context, zzap zzap, zzaq zzaq, boolean z) {
        super(context, zzap, zzaq);
        this.zznq = z;
    }

    public static zzam zza(String str, Context context, boolean z) {
        zzah zzah = new zzah();
        zza(str, context, zzah);
        if (z) {
            synchronized (zzam.class) {
                if (zznn == null) {
                    new Thread(new zzb(context)).start();
                }
            }
        }
        return new zzam(context, zzah, new zzas(239), z);
    }

    /* access modifiers changed from: package-private */
    public zza zzY() throws IOException {
        synchronized (zzam.class) {
            try {
                if (!zzno.await(2, TimeUnit.SECONDS)) {
                    return new zza(null, false);
                } else if (zznn == null) {
                    return new zza(null, false);
                } else {
                    AdvertisingIdClient.Info info = zznn.getInfo();
                    return new zza(zzk(info.getId()), info.isLimitAdTrackingEnabled());
                }
            } catch (InterruptedException e) {
                return new zza(null, false);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzak, com.google.android.gms.internal.zzal
    public void zzc(Context context) {
        super.zzc(context);
        try {
            if (zznp || !this.zznq) {
                zza(24, zze(context));
                return;
            }
            zza zzY = zzY();
            String id = zzY.getId();
            if (id != null) {
                zza(28, zzY.isLimitAdTrackingEnabled() ? 1 : 0);
                zza(26, 5);
                zza(24, id);
            }
        } catch (zzal.zza | IOException e) {
        }
    }
}
