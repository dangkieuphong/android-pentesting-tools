package com.google.android.gms.internal;

import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.zzb;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class zzt implements zzf {
    protected static final boolean DEBUG = zzs.DEBUG;
    private static int zzao = GamesStatusCodes.STATUS_ACHIEVEMENT_UNLOCK_FAILURE;
    private static int zzap = 4096;
    protected final zzy zzaq;
    protected final zzu zzar;

    public zzt(zzy zzy) {
        this(zzy, new zzu(zzap));
    }

    public zzt(zzy zzy, zzu zzu) {
        this.zzaq = zzy;
        this.zzar = zzu;
    }

    protected static Map<String, String> zza(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }

    private void zza(long j, zzk<?> zzk, byte[] bArr, StatusLine statusLine) {
        if (DEBUG || j > ((long) zzao)) {
            Object[] objArr = new Object[5];
            objArr[0] = zzk;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(zzk.zzu().zze());
            zzs.zzb("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void zza(String str, zzk<?> zzk, zzr zzr) throws zzr {
        zzo zzu = zzk.zzu();
        int zzt = zzk.zzt();
        try {
            zzu.zza(zzr);
            zzk.zzc(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(zzt)));
        } catch (zzr e) {
            zzk.zzc(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(zzt)));
            throw e;
        }
    }

    private void zza(Map<String, String> map, zzb.zza zza) {
        if (zza != null) {
            if (zza.zzb != null) {
                map.put("If-None-Match", zza.zzb);
            }
            if (zza.zzd > 0) {
                map.put("If-Modified-Since", DateUtils.formatDate(new Date(zza.zzd)));
            }
        }
    }

    private byte[] zza(HttpEntity httpEntity) throws IOException, zzp {
        zzaa zzaa = new zzaa(this.zzar, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new zzp();
            }
            bArr = this.zzar.zzb(1024);
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    break;
                }
                zzaa.write(bArr, 0, read);
            }
            byte[] byteArray = zzaa.toByteArray();
            try {
            } catch (IOException e) {
                zzs.zza("Error occured when calling consumingContent", new Object[0]);
            }
            return byteArray;
        } finally {
            try {
                httpEntity.consumeContent();
            } catch (IOException e2) {
                zzs.zza("Error occured when calling consumingContent", new Object[0]);
            }
            this.zzar.zza(bArr);
            zzaa.close();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0091, code lost:
        zza("socket", r19, new com.google.android.gms.internal.zzq());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b2, code lost:
        zza("connection", r19, new com.google.android.gms.internal.zzq());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c0, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00dd, code lost:
        throw new java.lang.RuntimeException("Bad URL " + r19.getUrl(), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00de, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00df, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e3, code lost:
        r4 = r3.getStatusLine().getStatusCode();
        com.google.android.gms.internal.zzs.zzc("Unexpected response code %d for %s", java.lang.Integer.valueOf(r4), r19.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0101, code lost:
        if (r5 != null) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0103, code lost:
        r3 = new com.google.android.gms.internal.zzi(r4, r5, r6, false, android.os.SystemClock.elapsedRealtime() - r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0111, code lost:
        if (r4 == 401) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0117, code lost:
        zza("auth", r19, new com.google.android.gms.internal.zza(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x012a, code lost:
        throw new com.google.android.gms.internal.zzj(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0130, code lost:
        throw new com.google.android.gms.internal.zzp(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0136, code lost:
        throw new com.google.android.gms.internal.zzh((com.google.android.gms.internal.zzi) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0137, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0138, code lost:
        r5 = null;
        r3 = r15;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0090 A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), Splitter:B:2:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b1 A[ExcHandler: ConnectTimeoutException (e org.apache.http.conn.ConnectTimeoutException), Splitter:B:2:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c0 A[ExcHandler: MalformedURLException (r2v9 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0125 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.zzf
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzi zza(com.google.android.gms.internal.zzk<?> r19) throws com.google.android.gms.internal.zzr {
        /*
        // Method dump skipped, instructions count: 319
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzt.zza(com.google.android.gms.internal.zzk):com.google.android.gms.internal.zzi");
    }
}
