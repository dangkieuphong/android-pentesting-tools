package com.google.android.gms.internal;

import android.os.SystemClock;
import com.google.android.gms.internal.zzb;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class zzv implements zzb {
    private final int zzaA;
    private final Map<String, zza> zzax;
    private long zzay;
    private final File zzaz;

    /* access modifiers changed from: package-private */
    public static class zza {
        public long zzaB;
        public String zzaC;
        public String zzb;
        public long zzc;
        public long zzd;
        public long zze;
        public long zzf;
        public Map<String, String> zzg;

        private zza() {
        }

        public zza(String str, zzb.zza zza) {
            this.zzaC = str;
            this.zzaB = (long) zza.data.length;
            this.zzb = zza.zzb;
            this.zzc = zza.zzc;
            this.zzd = zza.zzd;
            this.zze = zza.zze;
            this.zzf = zza.zzf;
            this.zzg = zza.zzg;
        }

        public static zza zzf(InputStream inputStream) throws IOException {
            zza zza = new zza();
            if (zzv.zzb(inputStream) != 538247942) {
                throw new IOException();
            }
            zza.zzaC = zzv.zzd(inputStream);
            zza.zzb = zzv.zzd(inputStream);
            if (zza.zzb.equals("")) {
                zza.zzb = null;
            }
            zza.zzc = zzv.zzc(inputStream);
            zza.zzd = zzv.zzc(inputStream);
            zza.zze = zzv.zzc(inputStream);
            zza.zzf = zzv.zzc(inputStream);
            zza.zzg = zzv.zze(inputStream);
            return zza;
        }

        public boolean zza(OutputStream outputStream) {
            try {
                zzv.zza(outputStream, 538247942);
                zzv.zza(outputStream, this.zzaC);
                zzv.zza(outputStream, this.zzb == null ? "" : this.zzb);
                zzv.zza(outputStream, this.zzc);
                zzv.zza(outputStream, this.zzd);
                zzv.zza(outputStream, this.zze);
                zzv.zza(outputStream, this.zzf);
                zzv.zza(this.zzg, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                zzs.zzb("%s", e.toString());
                return false;
            }
        }

        public zzb.zza zzb(byte[] bArr) {
            zzb.zza zza = new zzb.zza();
            zza.data = bArr;
            zza.zzb = this.zzb;
            zza.zzc = this.zzc;
            zza.zzd = this.zzd;
            zza.zze = this.zze;
            zza.zzf = this.zzf;
            zza.zzg = this.zzg;
            return zza;
        }
    }

    private static class zzb extends FilterInputStream {
        private int zzaD;

        private zzb(InputStream inputStream) {
            super(inputStream);
            this.zzaD = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.zzaD++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] buffer, int offset, int count) throws IOException {
            int read = super.read(buffer, offset, count);
            if (read != -1) {
                this.zzaD += read;
            }
            return read;
        }
    }

    public zzv(File file) {
        this(file, 5242880);
    }

    public zzv(File file, int i) {
        this.zzax = new LinkedHashMap(16, 0.75f, true);
        this.zzay = 0;
        this.zzaz = file;
        this.zzaA = i;
    }

    private void removeEntry(String key) {
        zza zza2 = this.zzax.get(key);
        if (zza2 != null) {
            this.zzay -= zza2.zzaB;
            this.zzax.remove(key);
        }
    }

    private static int zza(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static void zza(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void zza(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) (j >>> 0)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void zza(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        zza(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void zza(String str, zza zza2) {
        if (!this.zzax.containsKey(str)) {
            this.zzay += zza2.zzaB;
        } else {
            this.zzay = (zza2.zzaB - this.zzax.get(str).zzaB) + this.zzay;
        }
        this.zzax.put(str, zza2);
    }

    static void zza(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map != null) {
            zza(outputStream, map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                zza(outputStream, entry.getKey());
                zza(outputStream, entry.getValue());
            }
            return;
        }
        zza(outputStream, 0);
    }

    private static byte[] zza(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    static int zzb(InputStream inputStream) throws IOException {
        return 0 | (zza(inputStream) << 0) | (zza(inputStream) << 8) | (zza(inputStream) << 16) | (zza(inputStream) << 24);
    }

    static long zzc(InputStream inputStream) throws IOException {
        return 0 | ((((long) zza(inputStream)) & 255) << 0) | ((((long) zza(inputStream)) & 255) << 8) | ((((long) zza(inputStream)) & 255) << 16) | ((((long) zza(inputStream)) & 255) << 24) | ((((long) zza(inputStream)) & 255) << 32) | ((((long) zza(inputStream)) & 255) << 40) | ((((long) zza(inputStream)) & 255) << 48) | ((((long) zza(inputStream)) & 255) << 56);
    }

    private void zzc(int i) {
        int i2;
        if (this.zzay + ((long) i) >= ((long) this.zzaA)) {
            if (zzs.DEBUG) {
                zzs.zza("Pruning old cache entries.", new Object[0]);
            }
            long j = this.zzay;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, zza>> it = this.zzax.entrySet().iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = i3;
                    break;
                }
                zza value = it.next().getValue();
                if (zzf(value.zzaC).delete()) {
                    this.zzay -= value.zzaB;
                } else {
                    zzs.zzb("Could not delete cache entry for key=%s, filename=%s", value.zzaC, zze(value.zzaC));
                }
                it.remove();
                i2 = i3 + 1;
                if (((float) (this.zzay + ((long) i))) < ((float) this.zzaA) * 0.9f) {
                    break;
                }
                i3 = i2;
            }
            if (zzs.DEBUG) {
                zzs.zza("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.zzay - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    static String zzd(InputStream inputStream) throws IOException {
        return new String(zza(inputStream, (int) zzc(inputStream)), "UTF-8");
    }

    private String zze(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    static Map<String, String> zze(InputStream inputStream) throws IOException {
        int zzb2 = zzb(inputStream);
        Map<String, String> emptyMap = zzb2 == 0 ? Collections.emptyMap() : new HashMap<>(zzb2);
        for (int i = 0; i < zzb2; i++) {
            emptyMap.put(zzd(inputStream).intern(), zzd(inputStream).intern());
        }
        return emptyMap;
    }

    public synchronized void remove(String key) {
        boolean delete = zzf(key).delete();
        removeEntry(key);
        if (!delete) {
            zzs.zzb("Could not delete cache entry for key=%s, filename=%s", key, zze(key));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005a A[SYNTHETIC, Splitter:B:24:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0066 A[SYNTHETIC, Splitter:B:32:0x0066] */
    @Override // com.google.android.gms.internal.zzb
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.google.android.gms.internal.zzb.zza zza(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 116
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzv.zza(java.lang.String):com.google.android.gms.internal.zzb$zza");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a A[SYNTHETIC, Splitter:B:26:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005f A[SYNTHETIC, Splitter:B:29:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068 A[SYNTHETIC, Splitter:B:34:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0052 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.zzb
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void zza() {
        /*
        // Method dump skipped, instructions count: 122
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzv.zza():void");
    }

    @Override // com.google.android.gms.internal.zzb
    public synchronized void zza(String str, zzb.zza zza2) {
        zzc(zza2.data.length);
        File zzf = zzf(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zzf);
            zza zza3 = new zza(str, zza2);
            if (!zza3.zza(fileOutputStream)) {
                fileOutputStream.close();
                zzs.zzb("Failed to write header for %s", zzf.getAbsolutePath());
                throw new IOException();
            }
            fileOutputStream.write(zza2.data);
            fileOutputStream.close();
            zza(str, zza3);
        } catch (IOException e) {
            if (!zzf.delete()) {
                zzs.zzb("Could not clean up file %s", zzf.getAbsolutePath());
            }
        }
    }

    public File zzf(String str) {
        return new File(this.zzaz, zze(str));
    }
}
