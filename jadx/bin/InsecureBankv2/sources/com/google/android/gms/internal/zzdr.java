package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@zzgd
public class zzdr {
    private static final Set<String> zzwF = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzwG = new DecimalFormat("#,###");
    private zzid zzoA;
    private File zzwH;
    private boolean zzwI;

    public zzdr(zzid zzid) {
        this.zzoA = zzid;
        File cacheDir = zzid.getContext().getCacheDir();
        if (cacheDir == null) {
            zzb.zzaC("Context.getCacheDir() returned null");
            return;
        }
        this.zzwH = new File(cacheDir, "admobVideoStreams");
        if (!this.zzwH.isDirectory() && !this.zzwH.mkdirs()) {
            zzb.zzaC("Could not create preload cache directory at " + this.zzwH.getAbsolutePath());
            this.zzwH = null;
        } else if (!this.zzwH.setReadable(true, false) || !this.zzwH.setExecutable(true, false)) {
            zzb.zzaC("Could not set cache file permissions at " + this.zzwH.getAbsolutePath());
            this.zzwH = null;
        }
    }

    private String zzX(String str) {
        return zzk.zzcA().zzax(str);
    }

    private File zza(File file) {
        return new File(this.zzwH, file.getName() + ".done");
    }

    private void zza(final String str, final File file) {
        zza.zzGF.post(new Runnable() {
            /* class com.google.android.gms.internal.zzdr.AnonymousClass3 */

            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put("event", "precacheCanceled");
                hashMap.put("src", str);
                if (file != null) {
                    hashMap.put("cachedSrc", file.getAbsolutePath());
                }
                zzdr.this.zzoA.zzc("onPrecacheEvent", hashMap);
            }
        });
    }

    private void zza(final String str, final File file, final int i) {
        zza.zzGF.post(new Runnable() {
            /* class com.google.android.gms.internal.zzdr.AnonymousClass2 */

            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put("event", "precacheComplete");
                hashMap.put("src", str);
                hashMap.put("cachedSrc", file.getAbsolutePath());
                hashMap.put("totalBytes", Integer.toString(i));
                zzdr.this.zzoA.zzc("onPrecacheEvent", hashMap);
            }
        });
    }

    private void zza(final String str, final File file, final int i, final int i2) {
        zza.zzGF.post(new Runnable() {
            /* class com.google.android.gms.internal.zzdr.AnonymousClass1 */

            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put("event", "precacheProgress");
                hashMap.put("src", str);
                hashMap.put("cachedSrc", file.getAbsolutePath());
                hashMap.put("bytesLoaded", Integer.toString(i));
                hashMap.put("totalBytes", Integer.toString(i2));
                zzdr.this.zzoA.zzc("onPrecacheEvent", hashMap);
            }
        });
    }

    private static void zzb(File file) {
        if (file.isFile()) {
            file.setLastModified(System.currentTimeMillis());
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
        }
    }

    public void abort() {
        this.zzwI = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r5 = new java.net.URL(r27).openConnection();
        r4 = com.google.android.gms.internal.zzbz.zztS.get().intValue();
        r5.setConnectTimeout(r4);
        r5.setReadTimeout(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ee, code lost:
        if ((r5 instanceof java.net.HttpURLConnection) == false) goto L_0x017f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f0, code lost:
        r4 = ((java.net.HttpURLConnection) r5).getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00fa, code lost:
        if (r4 < 400) goto L_0x017f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0120, code lost:
        throw new java.io.IOException("HTTP status code " + r4 + " at " + r27);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0121, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0122, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x012a, code lost:
        if (r26.zzwI == false) goto L_0x02f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x012c, code lost:
        com.google.android.gms.ads.internal.util.client.zzb.zzaA("Preload aborted for URL \"" + r27 + "\"");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0156, code lost:
        com.google.android.gms.ads.internal.util.client.zzb.zzaC("Could not delete partial cache file at " + r7.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0170, code lost:
        zza(r27, r7);
        com.google.android.gms.internal.zzdr.zzwF.remove(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x017f, code lost:
        r10 = r5.getContentLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0183, code lost:
        if (r10 >= 0) goto L_0x01ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0185, code lost:
        com.google.android.gms.ads.internal.util.client.zzb.zzaC("Stream cache aborted, missing content-length header at " + r27);
        zza(r27, r7);
        com.google.android.gms.internal.zzdr.zzwF.remove(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01ac, code lost:
        r11 = com.google.android.gms.internal.zzdr.zzwG.format((long) r10);
        r12 = com.google.android.gms.internal.zzbz.zztP.get().intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01bf, code lost:
        if (r10 <= r12) goto L_0x01f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01c1, code lost:
        com.google.android.gms.ads.internal.util.client.zzb.zzaC("Content length " + r11 + " exceeds limit at " + r27);
        zza(r27, r7);
        com.google.android.gms.internal.zzdr.zzwF.remove(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01f2, code lost:
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Caching " + r11 + " bytes from " + r27);
        r11 = java.nio.channels.Channels.newChannel(r5.getInputStream());
        r5 = new java.io.FileOutputStream(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r13 = r5.getChannel();
        r14 = java.nio.ByteBuffer.allocate(android.support.v4.view.accessibility.AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START);
        r15 = com.google.android.gms.ads.internal.zzo.zzbz();
        r16 = r15.currentTimeMillis();
        r20 = new com.google.android.gms.internal.zzhq(com.google.android.gms.internal.zzbz.zztR.get().longValue());
        r18 = com.google.android.gms.internal.zzbz.zztQ.get().longValue();
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0256, code lost:
        r6 = r11.read(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x025a, code lost:
        if (r6 < 0) goto L_0x02a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x025c, code lost:
        r4 = r4 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x025d, code lost:
        if (r4 <= r12) goto L_0x026a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0266, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0267, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x026a, code lost:
        r14.flip();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0271, code lost:
        if (r13.write(r14) > 0) goto L_0x026d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0273, code lost:
        r14.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0282, code lost:
        if ((r15.currentTimeMillis() - r16) <= (1000 * r18)) goto L_0x028c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x028b, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0290, code lost:
        if (r26.zzwI == false) goto L_0x029a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0299, code lost:
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x029e, code lost:
        if (r20.tryAcquire() == false) goto L_0x0256;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x02a0, code lost:
        zza(r27, r7, r4, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x02a8, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x02b0, code lost:
        if (com.google.android.gms.ads.internal.util.client.zzb.zzL(3) == false) goto L_0x02db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x02b2, code lost:
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Preloaded " + com.google.android.gms.internal.zzdr.zzwG.format((long) r4) + " bytes from " + r27);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x02db, code lost:
        r7.setReadable(true, false);
        zzb(r8);
        zza(r27, r7, r4);
        com.google.android.gms.internal.zzdr.zzwF.remove(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x02ef, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x02f2, code lost:
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Preload failed for URL \"" + r27 + "\"", r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
        return false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02f2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean zzW(java.lang.String r27) {
        /*
        // Method dump skipped, instructions count: 792
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdr.zzW(java.lang.String):boolean");
    }

    public int zzdQ() {
        int i = 0;
        if (this.zzwH != null) {
            for (File file : this.zzwH.listFiles()) {
                if (!file.getName().endsWith(".done")) {
                    i++;
                }
            }
        }
        return i;
    }

    public boolean zzdR() {
        boolean z;
        long j;
        File file;
        if (this.zzwH == null) {
            return false;
        }
        File file2 = null;
        long j2 = Long.MAX_VALUE;
        File[] listFiles = this.zzwH.listFiles();
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file3 = listFiles[i];
            if (!file3.getName().endsWith(".done")) {
                j = file3.lastModified();
                if (j < j2) {
                    file = file3;
                    i++;
                    file2 = file;
                    j2 = j;
                }
            }
            j = j2;
            file = file2;
            i++;
            file2 = file;
            j2 = j;
        }
        if (file2 != null) {
            z = file2.delete();
            File zza = zza(file2);
            if (zza.isFile()) {
                z &= zza.delete();
            }
        } else {
            z = false;
        }
        return z;
    }
}
