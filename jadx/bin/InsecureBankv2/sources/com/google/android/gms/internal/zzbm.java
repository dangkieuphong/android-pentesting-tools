package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbp;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

public class zzbm {
    private final int zzrL;
    private final int zzrM;
    private final int zzrN;
    private final zzbl zzrO = new zzbo();

    /* access modifiers changed from: package-private */
    public static class zza {
        ByteArrayOutputStream zzrQ = new ByteArrayOutputStream(4096);
        Base64OutputStream zzrR = new Base64OutputStream(this.zzrQ, 10);

        public String toString() {
            String str;
            try {
                this.zzrR.close();
            } catch (IOException e) {
                zzb.zzb("HashManager: Unable to convert to Base64.", e);
            }
            try {
                this.zzrQ.close();
                str = this.zzrQ.toString();
            } catch (IOException e2) {
                zzb.zzb("HashManager: Unable to convert to Base64.", e2);
                str = "";
            } finally {
                this.zzrQ = null;
                this.zzrR = null;
            }
            return str;
        }

        public void write(byte[] data) throws IOException {
            this.zzrR.write(data);
        }
    }

    public zzbm(int i) {
        this.zzrM = i;
        this.zzrL = 6;
        this.zzrN = 0;
    }

    private String zzz(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zza zzcv = zzcv();
        Arrays.sort(split, new Comparator<String>() {
            /* class com.google.android.gms.internal.zzbm.AnonymousClass1 */

            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        int i = 0;
        while (i < split.length && i < this.zzrM) {
            if (split[i].trim().length() != 0) {
                try {
                    zzcv.write(this.zzrO.zzy(split[i]));
                } catch (IOException e) {
                    zzb.zzb("Error while writing hash to byteStream", e);
                }
            }
            i++;
        }
        return zzcv.toString();
    }

    /* access modifiers changed from: package-private */
    public String zzA(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zza zzcv = zzcv();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzrM, new Comparator<zzbp.zza>() {
            /* class com.google.android.gms.internal.zzbm.AnonymousClass2 */

            /* renamed from: zza */
            public int compare(zzbp.zza zza, zzbp.zza zza2) {
                return (int) (zza.value - zza2.value);
            }
        });
        for (String str2 : split) {
            String[] zzC = zzbn.zzC(str2);
            if (zzC.length >= this.zzrL) {
                zzbp.zza(zzC, this.zzrM, this.zzrL, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzcv.write(this.zzrO.zzy(((zzbp.zza) it.next()).zzrT));
            } catch (IOException e) {
                zzb.zzb("Error while writing hash to byteStream", e);
            }
        }
        return zzcv.toString();
    }

    public String zza(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        switch (this.zzrN) {
            case 0:
                return zzA(stringBuffer.toString());
            case 1:
                return zzz(stringBuffer.toString());
            default:
                return "";
        }
    }

    /* access modifiers changed from: package-private */
    public zza zzcv() {
        return new zza();
    }
}
