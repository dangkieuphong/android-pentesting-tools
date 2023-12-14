package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class zzcb {
    private final Context mContext;
    private final String zzqr;
    private int zzuA;
    private int zzuB;
    private int zzuC;
    private String zzuD;
    private BlockingQueue<zzce> zzuF;
    private ExecutorService zzuG;
    private LinkedHashMap<String, String> zzuH = new LinkedHashMap<>();
    private AtomicBoolean zzuI;
    private File zzuJ;
    private int zzuz;

    public zzcb(Context context, String str, String str2, int i, int i2, int i3, int i4, Map<String, String> map, int i5) {
        File externalStorageDirectory;
        this.mContext = context;
        this.zzqr = str;
        this.zzuD = str2;
        this.zzuA = i;
        this.zzuB = i2;
        this.zzuC = i3;
        zzq(i4);
        this.zzuI = new AtomicBoolean(false);
        this.zzuI.set(zzbz.zzub.get().booleanValue());
        if (this.zzuI.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.zzuJ = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            zzd(entry.getKey(), entry.getValue());
        }
        if (i5 == 1) {
            zzdj();
        }
        if (i5 == 2) {
            zzdk();
        }
        init();
    }

    private void init() {
        this.zzuF = new ArrayBlockingQueue(this.zzuA);
        this.zzuG = Executors.newSingleThreadExecutor();
        this.zzuG.execute(new Runnable() {
            /* class com.google.android.gms.internal.zzcb.AnonymousClass1 */

            public void run() {
                zzcb.this.zzdl();
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002b A[SYNTHETIC, Splitter:B:17:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003a A[SYNTHETIC, Splitter:B:24:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zza(java.io.File r4, java.lang.String r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x0045
            r2 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0022, all -> 0x0036 }
            r0 = 1
            r1.<init>(r4, r0)     // Catch:{ IOException -> 0x0022, all -> 0x0036 }
            byte[] r0 = r5.getBytes()     // Catch:{ IOException -> 0x004d }
            r1.write(r0)     // Catch:{ IOException -> 0x004d }
            r0 = 10
            r1.write(r0)     // Catch:{ IOException -> 0x004d }
            if (r1 == 0) goto L_0x001a
            r1.close()     // Catch:{ IOException -> 0x001b }
        L_0x001a:
            return
        L_0x001b:
            r0 = move-exception
            java.lang.String r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.ads.internal.util.client.zzb.zzd(r1, r0)
            goto L_0x001a
        L_0x0022:
            r0 = move-exception
            r1 = r2
        L_0x0024:
            java.lang.String r2 = "CsiReporter: Cannot write to file: sdk_csi_data.txt."
            com.google.android.gms.ads.internal.util.client.zzb.zzd(r2, r0)     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x001a
            r1.close()     // Catch:{ IOException -> 0x002f }
            goto L_0x001a
        L_0x002f:
            r0 = move-exception
            java.lang.String r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.ads.internal.util.client.zzb.zzd(r1, r0)
            goto L_0x001a
        L_0x0036:
            r0 = move-exception
            r1 = r2
        L_0x0038:
            if (r1 == 0) goto L_0x003d
            r1.close()     // Catch:{ IOException -> 0x003e }
        L_0x003d:
            throw r0
        L_0x003e:
            r1 = move-exception
            java.lang.String r2 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.ads.internal.util.client.zzb.zzd(r2, r1)
            goto L_0x003d
        L_0x0045:
            java.lang.String r0 = "CsiReporter: File doesn't exists. Cannot write CSI data to file."
            com.google.android.gms.ads.internal.util.client.zzb.zzaC(r0)
            goto L_0x001a
        L_0x004b:
            r0 = move-exception
            goto L_0x0038
        L_0x004d:
            r0 = move-exception
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcb.zza(java.io.File, java.lang.String):void");
    }

    private void zzb(List<String> list) {
        if (list != null && !list.isEmpty()) {
            zzd("eid", TextUtils.join(",", list));
        }
    }

    private boolean zzc(Map<String, String> map) {
        boolean z = false;
        int i = 0;
        while (!z && i < this.zzuB) {
            try {
                Thread.sleep((long) this.zzuC);
                String zza = zza(this.zzuD, map);
                if (this.zzuI.get()) {
                    zza(this.zzuJ, zza);
                } else {
                    zzo.zzbv().zzc(this.mContext, this.zzqr, zza);
                }
                z = true;
            } catch (InterruptedException e) {
                zzb.zzd("CsiReporter: interrupted in sendReport()", e);
                Thread.currentThread().interrupt();
            }
            i++;
        }
        return z;
    }

    private void zzdj() {
        zzb(zzbz.zzdb());
    }

    private void zzdk() {
        zzb(zzbz.zzx(this.mContext));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzdl() {
        while (true) {
            try {
                List<zzce> zzp = zzp(this.zzuz);
                if (zzp != null) {
                    for (Map<String, String> map : zzc(zzp).values()) {
                        zzc(map);
                    }
                }
            } catch (InterruptedException e) {
                zzb.zzd("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    private List<zzce> zzp(int i) throws InterruptedException {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(this.zzuF.take());
        }
        return arrayList;
    }

    private void zzq(int i) {
        if (i < 1) {
            zzb.zzaC("CsiReporter - too small batch size :" + i + ", changed to 1");
            i = 1;
        }
        if (i > this.zzuA) {
            zzb.zzaC("CsiReporter - batch size :" + i + " bigger than buffer size, " + "change to buffer limit");
            i = this.zzuA;
        }
        this.zzuz = i;
    }

    /* access modifiers changed from: package-private */
    public String zza(String str, Map<String, String> map) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return buildUpon.build().toString();
    }

    public boolean zza(zzce zzce) {
        return this.zzuF.offer(zzce);
    }

    /* access modifiers changed from: package-private */
    public Map<String, Map<String, String>> zzc(List<zzce> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (zzce zzce : list) {
            String zzdr = zzce.zzdr();
            if (linkedHashMap.containsKey(zzdr)) {
                ((List) linkedHashMap.get(zzdr)).add(zzce);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(zzce);
                linkedHashMap.put(zzdr, arrayList);
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            List list2 = (List) entry.getValue();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(this.zzuH);
            try {
                linkedHashMap3.putAll(zzce.zza((zzce[]) list2.toArray(new zzce[list2.size()])));
                linkedHashMap2.put(entry.getKey(), linkedHashMap3);
            } catch (IllegalArgumentException e) {
                zzb.zzd("CsiReporter:failed to merge tickers:" + list2, e);
            }
        }
        return linkedHashMap2;
    }

    /* access modifiers changed from: package-private */
    public void zzd(String str, String str2) {
        this.zzuH.put(str, str2);
    }
}
