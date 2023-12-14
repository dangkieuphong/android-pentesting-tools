package com.google.android.gms.internal;

import com.google.android.gms.internal.zzm;
import java.io.UnsupportedEncodingException;

public class zzab extends zzk<String> {
    private final zzm.zzb<String> zzaH;

    public zzab(int i, String str, zzm.zzb<String> zzb, zzm.zza zza) {
        super(i, str, zza);
        this.zzaH = zzb;
    }

    public zzab(String str, zzm.zzb<String> zzb, zzm.zza zza) {
        this(0, str, zzb, zza);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzk
    public zzm<String> zza(zzi zzi) {
        String str;
        try {
            str = new String(zzi.data, zzx.zza(zzi.zzA));
        } catch (UnsupportedEncodingException e) {
            str = new String(zzi.data);
        }
        return zzm.zza(str, zzx.zzb(zzi));
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzi */
    public void zza(String str) {
        this.zzaH.zzb(str);
    }
}
