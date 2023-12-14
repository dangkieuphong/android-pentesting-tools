package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import com.google.android.gms.drive.query.Filter;
import java.util.List;

public class zzg implements zzf<Boolean> {
    private Boolean zzaid = false;

    private zzg() {
    }

    public static boolean zza(Filter filter) {
        if (filter == null) {
            return false;
        }
        return ((Boolean) filter.zza(new zzg())).booleanValue();
    }

    /* renamed from: zzc */
    public <T> Boolean zzb(zzb<T> zzb, T t) {
        return this.zzaid;
    }

    /* renamed from: zzc */
    public <T> Boolean zzb(Operator operator, MetadataField<T> metadataField, T t) {
        return this.zzaid;
    }

    /* renamed from: zzc */
    public Boolean zzb(Operator operator, List<Boolean> list) {
        return this.zzaid;
    }

    /* renamed from: zzcD */
    public Boolean zzcC(String str) {
        if (!str.isEmpty()) {
            this.zzaid = true;
        }
        return this.zzaid;
    }

    /* renamed from: zzd */
    public Boolean zzv(Boolean bool) {
        return this.zzaid;
    }

    /* renamed from: zze */
    public <T> Boolean zzd(MetadataField<T> metadataField, T t) {
        return this.zzaid;
    }

    /* renamed from: zzf */
    public Boolean zze(MetadataField<?> metadataField) {
        return this.zzaid;
    }

    /* renamed from: zzqg */
    public Boolean zzqf() {
        return this.zzaid;
    }

    /* renamed from: zzqh */
    public Boolean zzqe() {
        return this.zzaid;
    }
}
