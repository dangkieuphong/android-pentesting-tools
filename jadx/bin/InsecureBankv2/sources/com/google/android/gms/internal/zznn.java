package com.google.android.gms.internal;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class zznn implements zznu {
    private static final Uri zzaDR;
    private final LogPrinter zzaDS = new LogPrinter(4, "GA/LogCatTransport");

    static {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority("local");
        zzaDR = builder.build();
    }

    @Override // com.google.android.gms.internal.zznu
    public void zzb(zzno zzno) {
        ArrayList<zznq> arrayList = new ArrayList(zzno.zzvQ());
        Collections.sort(arrayList, new Comparator<zznq>() {
            /* class com.google.android.gms.internal.zznn.AnonymousClass1 */

            /* renamed from: zza */
            public int compare(zznq zznq, zznq zznq2) {
                return zznq.getClass().getCanonicalName().compareTo(zznq2.getClass().getCanonicalName());
            }
        });
        StringBuilder sb = new StringBuilder();
        for (zznq zznq : arrayList) {
            String obj = zznq.toString();
            if (!TextUtils.isEmpty(obj)) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(obj);
            }
        }
        this.zzaDS.println(sb.toString());
    }

    @Override // com.google.android.gms.internal.zznu
    public Uri zzhe() {
        return zzaDR;
    }
}
