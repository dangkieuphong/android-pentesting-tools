package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.analytics.zza;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzio;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzno;
import com.google.android.gms.internal.zzns;
import com.google.android.gms.internal.zznx;
import com.google.android.gms.internal.zzny;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
public class zzl extends zzd {
    private boolean mStarted;
    private final zzj zzKn;
    private final zzah zzKo;
    private final zzag zzKp;
    private final zzi zzKq;
    private long zzKr = Long.MIN_VALUE;
    private final zzt zzKs;
    private final zzt zzKt;
    private final zzaj zzKu;
    private long zzKv;
    private boolean zzKw;

    protected zzl(zzf zzf, zzg zzg) {
        super(zzf);
        zzu.zzu(zzg);
        this.zzKp = zzg.zzk(zzf);
        this.zzKn = zzg.zzm(zzf);
        this.zzKo = zzg.zzn(zzf);
        this.zzKq = zzg.zzo(zzf);
        this.zzKu = new zzaj(zzhP());
        this.zzKs = new zzt(zzf) {
            /* class com.google.android.gms.analytics.internal.zzl.AnonymousClass1 */

            @Override // com.google.android.gms.analytics.internal.zzt
            public void run() {
                zzl.this.zziA();
            }
        };
        this.zzKt = new zzt(zzf) {
            /* class com.google.android.gms.analytics.internal.zzl.AnonymousClass2 */

            @Override // com.google.android.gms.analytics.internal.zzt
            public void run() {
                zzl.this.zziB();
            }
        };
    }

    private void zza(zzh zzh, zzny zzny) {
        zzu.zzu(zzh);
        zzu.zzu(zzny);
        zza zza = new zza(zzhM());
        zza.zzaI(zzh.zzij());
        zza.enableAdvertisingIdCollection(zzh.zzik());
        zzno zzhc = zza.zzhc();
        zzip zzip = (zzip) zzhc.zze(zzip.class);
        zzip.zzaN("data");
        zzip.zzF(true);
        zzhc.zzb(zzny);
        zzio zzio = (zzio) zzhc.zze(zzio.class);
        zznx zznx = (zznx) zzhc.zze(zznx.class);
        for (Map.Entry<String, String> entry : zzh.zzn().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if ("an".equals(key)) {
                zznx.setAppName(value);
            } else if ("av".equals(key)) {
                zznx.setAppVersion(value);
            } else if ("aid".equals(key)) {
                zznx.setAppId(value);
            } else if ("aiid".equals(key)) {
                zznx.setAppInstallerId(value);
            } else if ("uid".equals(key)) {
                zzip.setUserId(value);
            } else {
                zzio.set(key, value);
            }
        }
        zzb("Sending installation campaign to", zzh.zzij(), zzny);
        zzhc.zzL(zzhU().zzkk());
        zzhc.zzvT();
    }

    private boolean zzba(String str) {
        return getContext().checkCallingOrSelfPermission(str) == 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zziA() {
        zzb(new zzw() {
            /* class com.google.android.gms.analytics.internal.zzl.AnonymousClass4 */

            @Override // com.google.android.gms.analytics.internal.zzw
            public void zzc(Throwable th) {
                zzl.this.zziG();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zziB() {
        try {
            this.zzKn.zzis();
            zziG();
        } catch (SQLiteException e) {
            zzd("Failed to delete stale hits", e);
        }
        this.zzKt.zzt(zzhR().zzjy());
    }

    private boolean zziH() {
        if (this.zzKw) {
            return false;
        }
        return (!zzhR().zziW() || zzhR().zziX()) && zziN() > 0;
    }

    private void zziI() {
        zzv zzhT = zzhT();
        if (zzhT.zzjG() && !zzhT.zzbp()) {
            long zzit = zzit();
            if (zzit != 0 && Math.abs(zzhP().currentTimeMillis() - zzit) <= zzhR().zzjg()) {
                zza("Dispatch alarm scheduled (ms)", Long.valueOf(zzhR().zzjf()));
                zzhT.zzjH();
            }
        }
    }

    private void zziJ() {
        long min;
        zziI();
        long zziN = zziN();
        long zzkm = zzhU().zzkm();
        if (zzkm != 0) {
            min = zziN - Math.abs(zzhP().currentTimeMillis() - zzkm);
            if (min <= 0) {
                min = Math.min(zzhR().zzjd(), zziN);
            }
        } else {
            min = Math.min(zzhR().zzjd(), zziN);
        }
        zza("Dispatch scheduled (ms)", Long.valueOf(min));
        if (this.zzKs.zzbp()) {
            this.zzKs.zzu(Math.max(1L, min + this.zzKs.zzjD()));
            return;
        }
        this.zzKs.zzt(min);
    }

    private void zziK() {
        zziL();
        zziM();
    }

    private void zziL() {
        if (this.zzKs.zzbp()) {
            zzaT("All hits dispatched or no network/service. Going to power save mode");
        }
        this.zzKs.cancel();
    }

    private void zziM() {
        zzv zzhT = zzhT();
        if (zzhT.zzbp()) {
            zzhT.cancel();
        }
    }

    private void zziy() {
        Context context = zzhM().getContext();
        if (!AnalyticsReceiver.zzT(context)) {
            zzaW("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!AnalyticsService.zzU(context)) {
            zzaX("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.zzT(context)) {
            zzaW("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!CampaignTrackingService.zzU(context)) {
            zzaW("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
    }

    /* access modifiers changed from: protected */
    public void onServiceConnected() {
        zzhO();
        if (!zzhR().zziW()) {
            zziD();
        }
    }

    /* access modifiers changed from: package-private */
    public void start() {
        zzia();
        zzu.zza(!this.mStarted, "Analytics backend already started");
        this.mStarted = true;
        if (!zzhR().zziW()) {
            zziy();
        }
        zzhS().zze(new Runnable() {
            /* class com.google.android.gms.analytics.internal.zzl.AnonymousClass3 */

            public void run() {
                zzl.this.zziz();
            }
        });
    }

    public void zzG(boolean z) {
        zziG();
    }

    public long zza(zzh zzh, boolean z) {
        long j;
        zzu.zzu(zzh);
        zzia();
        zzhO();
        try {
            this.zzKn.beginTransaction();
            this.zzKn.zza(zzh.zzii(), zzh.getClientId());
            j = this.zzKn.zza(zzh.zzii(), zzh.getClientId(), zzh.zzij());
            if (!z) {
                zzh.zzn(j);
            } else {
                zzh.zzn(1 + j);
            }
            this.zzKn.zzb(zzh);
            this.zzKn.setTransactionSuccessful();
            try {
                this.zzKn.endTransaction();
            } catch (SQLiteException e) {
                zze("Failed to end transaction", e);
            }
        } catch (SQLiteException e2) {
            zze("Failed to update Analytics property", e2);
            j = -1;
            try {
                this.zzKn.endTransaction();
            } catch (SQLiteException e3) {
                zze("Failed to end transaction", e3);
            }
        } catch (Throwable th) {
            try {
                this.zzKn.endTransaction();
            } catch (SQLiteException e4) {
                zze("Failed to end transaction", e4);
            }
            throw th;
        }
        return j;
    }

    public void zza(zzab zzab) {
        zzu.zzu(zzab);
        zzns.zzhO();
        zzia();
        if (this.zzKw) {
            zzaU("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            zza("Delivering hit", zzab);
        }
        zzab zzf = zzf(zzab);
        zziC();
        if (this.zzKq.zzb(zzf)) {
            zzaU("Hit sent to the device AnalyticsService for delivery");
        } else if (zzhR().zziW()) {
            zzhQ().zza(zzf, "Service unavailable on package side");
        } else {
            try {
                this.zzKn.zzc(zzf);
                zziG();
            } catch (SQLiteException e) {
                zze("Delivery failed to save hit to a database", e);
                zzhQ().zza(zzf, "deliver: failed to insert hit to database");
            }
        }
    }

    public void zza(final zzw zzw, final long j) {
        zzns.zzhO();
        zzia();
        long j2 = -1;
        long zzkm = zzhU().zzkm();
        if (zzkm != 0) {
            j2 = Math.abs(zzhP().currentTimeMillis() - zzkm);
        }
        zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(j2));
        if (!zzhR().zziW()) {
            zziC();
        }
        try {
            if (zziE()) {
                zzhS().zze(new Runnable() {
                    /* class com.google.android.gms.analytics.internal.zzl.AnonymousClass5 */

                    public void run() {
                        zzl.this.zza(zzw, j);
                    }
                });
                return;
            }
            zzhU().zzkn();
            zziG();
            if (zzw != null) {
                zzw.zzc(null);
            }
            if (this.zzKv != j) {
                this.zzKp.zzkf();
            }
        } catch (Throwable th) {
            zze("Local dispatch failed", th);
            zzhU().zzkn();
            zziG();
            if (zzw != null) {
                zzw.zzc(th);
            }
        }
    }

    public void zzb(zzw zzw) {
        zza(zzw, this.zzKv);
    }

    public void zzbb(String str) {
        zzu.zzcj(str);
        zzhO();
        zzhN();
        zzny zza = zzam.zza(zzhQ(), str);
        if (zza == null) {
            zzd("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        String zzko = zzhU().zzko();
        if (str.equals(zzko)) {
            zzaW("Ignoring duplicate install campaign");
        } else if (!TextUtils.isEmpty(zzko)) {
            zzd("Ignoring multiple install campaigns. original, new", zzko, str);
        } else {
            zzhU().zzbf(str);
            if (zzhU().zzkl().zzv(zzhR().zzjB())) {
                zzd("Campaign received too late, ignoring", zza);
                return;
            }
            zzb("Received installation campaign", zza);
            for (zzh zzh : this.zzKn.zzr(0)) {
                zza(zzh, zza);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzc(zzh zzh) {
        zzhO();
        zzb("Sending first hit to property", zzh.zzij());
        if (!zzhU().zzkl().zzv(zzhR().zzjB())) {
            String zzko = zzhU().zzko();
            if (!TextUtils.isEmpty(zzko)) {
                zzny zza = zzam.zza(zzhQ(), zzko);
                zzb("Found relevant installation campaign", zza);
                zza(zzh, zza);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public zzab zzf(zzab zzab) {
        Pair<String, Long> zzks;
        if (!TextUtils.isEmpty(zzab.zzka()) || (zzks = zzhU().zzkp().zzks()) == null) {
            return zzab;
        }
        String str = ((Long) zzks.second) + ":" + ((String) zzks.first);
        HashMap hashMap = new HashMap(zzab.zzn());
        hashMap.put("_m", str);
        return zzab.zza(this, zzab, hashMap);
    }

    public void zzhG() {
        zzns.zzhO();
        zzia();
        if (!zzhR().zziW()) {
            zzaT("Delete all hits from local store");
            try {
                this.zzKn.zziq();
                this.zzKn.zzir();
                zziG();
            } catch (SQLiteException e) {
                zzd("Failed to delete hits from store", e);
            }
        }
        zziC();
        if (this.zzKq.zzim()) {
            zzaT("Device service unavailable. Can't clear hits stored on the device service.");
        }
    }

    public void zzhJ() {
        zzns.zzhO();
        zzia();
        zzaT("Service disconnected");
    }

    /* access modifiers changed from: package-private */
    public void zzhL() {
        zzhO();
        this.zzKv = zzhP().currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.analytics.internal.zzd
    public void zzhn() {
        this.zzKn.zza();
        this.zzKo.zza();
        this.zzKq.zza();
    }

    /* access modifiers changed from: protected */
    public void zziC() {
        if (!this.zzKw && zzhR().zziY() && !this.zzKq.isConnected()) {
            if (this.zzKu.zzv(zzhR().zzjt())) {
                this.zzKu.start();
                zzaT("Connecting to service");
                if (this.zzKq.connect()) {
                    zzaT("Connected to service");
                    this.zzKu.clear();
                    onServiceConnected();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0062 A[LOOP:1: B:18:0x0062->B:17:?, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0048 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zziD() {
        /*
        // Method dump skipped, instructions count: 133
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzl.zziD():void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f9, code lost:
        if (r12.zzKq.isConnected() == false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0103, code lost:
        if (zzhR().zziW() != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0105, code lost:
        zzaT("Service connected, sending hits to the service");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010e, code lost:
        if (r8.isEmpty() != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0110, code lost:
        r0 = r8.get(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x011d, code lost:
        if (r12.zzKq.zzb(r0) != false) goto L_0x0148;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x011f, code lost:
        r0 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0126, code lost:
        if (r12.zzKo.zzkg() == false) goto L_0x0199;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0128, code lost:
        r9 = r12.zzKo.zzf(r8);
        r10 = r9.iterator();
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0137, code lost:
        if (r10.hasNext() == false) goto L_0x018d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0139, code lost:
        r4 = java.lang.Math.max(r4, r10.next().longValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0148, code lost:
        r4 = java.lang.Math.max(r4, r0.zzjV());
        r8.remove(r0);
        zzb("Hit sent do device AnalyticsService for delivery", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r12.zzKn.zzq(r0.zzjV());
        r3.add(java.lang.Long.valueOf(r0.zzjV()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x016d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x016e, code lost:
        zze("Failed to remove hit that was send for delivery", r0);
        zziK();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        r12.zzKn.setTransactionSuccessful();
        r12.zzKn.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0182, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0183, code lost:
        zze("Failed to commit local dispatch transaction", r0);
        zziK();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x018d, code lost:
        r8.removeAll(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r12.zzKn.zzd(r9);
        r3.addAll(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0198, code lost:
        r0 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x019d, code lost:
        if (r3.isEmpty() == false) goto L_0x01d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        r12.zzKn.setTransactionSuccessful();
        r12.zzKn.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01ab, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01ac, code lost:
        zze("Failed to commit local dispatch transaction", r0);
        zziK();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01b6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01b7, code lost:
        zze("Failed to remove successfully uploaded hits", r0);
        zziK();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r12.zzKn.setTransactionSuccessful();
        r12.zzKn.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01cb, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01cc, code lost:
        zze("Failed to commit local dispatch transaction", r0);
        zziK();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        r12.zzKn.setTransactionSuccessful();
        r12.zzKn.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01e3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01e4, code lost:
        zze("Failed to commit local dispatch transaction", r0);
        zziK();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0205, code lost:
        r0 = r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean zziE() {
        /*
        // Method dump skipped, instructions count: 520
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzl.zziE():boolean");
    }

    public void zziF() {
        zzns.zzhO();
        zzia();
        zzaU("Sync dispatching local hits");
        long j = this.zzKv;
        if (!zzhR().zziW()) {
            zziC();
        }
        do {
            try {
            } catch (Throwable th) {
                zze("Sync local dispatch failed", th);
                zziG();
                return;
            }
        } while (zziE());
        zzhU().zzkn();
        zziG();
        if (this.zzKv != j) {
            this.zzKp.zzkf();
        }
    }

    public void zziG() {
        boolean z;
        zzhM().zzhO();
        zzia();
        if (!zziH()) {
            this.zzKp.unregister();
            zziK();
        } else if (this.zzKn.isEmpty()) {
            this.zzKp.unregister();
            zziK();
        } else {
            if (!zzy.zzLI.get().booleanValue()) {
                this.zzKp.zzkd();
                z = this.zzKp.isConnected();
            } else {
                z = true;
            }
            if (z) {
                zziJ();
                return;
            }
            zziK();
            zziI();
        }
    }

    public long zziN() {
        if (this.zzKr != Long.MIN_VALUE) {
            return this.zzKr;
        }
        return zzhm().zzjQ() ? ((long) zzhm().zzkH()) * 1000 : zzhR().zzje();
    }

    public void zziO() {
        zzia();
        zzhO();
        this.zzKw = true;
        this.zzKq.disconnect();
        zziG();
    }

    public long zzit() {
        zzns.zzhO();
        zzia();
        try {
            return this.zzKn.zzit();
        } catch (SQLiteException e) {
            zze("Failed to get min/max hit times from local store", e);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public void zziz() {
        zzia();
        zzhU().zzkk();
        if (!zzba("android.permission.ACCESS_NETWORK_STATE")) {
            zzaX("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zziO();
        }
        if (!zzba("android.permission.INTERNET")) {
            zzaX("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zziO();
        }
        if (AnalyticsService.zzU(getContext())) {
            zzaT("AnalyticsService registered in the app manifest and enabled");
        } else if (zzhR().zziW()) {
            zzaX("Device AnalyticsService not registered! Hits will not be delivered reliably.");
        } else {
            zzaW("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!this.zzKw && !zzhR().zziW() && !this.zzKn.isEmpty()) {
            zziC();
        }
        zziG();
    }

    public void zzs(long j) {
        zzns.zzhO();
        zzia();
        if (j < 0) {
            j = 0;
        }
        this.zzKr = j;
        zziG();
    }
}
