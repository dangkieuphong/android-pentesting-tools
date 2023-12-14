package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.zzf;
import java.util.List;

public class zzc implements zzf<String> {
    /* renamed from: zza */
    public <T> String zzb(zzb<T> zzb, T t) {
        return String.format("contains(%s,%s)", zzb.getName(), t);
    }

    /* renamed from: zza */
    public <T> String zzb(Operator operator, MetadataField<T> metadataField, T t) {
        return String.format("cmp(%s,%s,%s)", operator.getTag(), metadataField.getName(), t);
    }

    /* renamed from: zza */
    public String zzb(Operator operator, List<String> list) {
        StringBuilder sb = new StringBuilder(operator.getTag() + "(");
        String str = "";
        for (String str2 : list) {
            sb.append(str);
            sb.append(str2);
            str = ",";
        }
        return sb.append(")").toString();
    }

    /* renamed from: zzc */
    public <T> String zzd(MetadataField<T> metadataField, T t) {
        return String.format("has(%s,%s)", metadataField.getName(), t);
    }

    /* renamed from: zzcA */
    public String zzv(String str) {
        return String.format("not(%s)", str);
    }

    /* renamed from: zzcB */
    public String zzcC(String str) {
        return String.format("fullTextSearch(%s)", str);
    }

    /* renamed from: zzd */
    public String zze(MetadataField<?> metadataField) {
        return String.format("fieldOnly(%s)", metadataField.getName());
    }

    /* renamed from: zzqc */
    public String zzqf() {
        return "all()";
    }

    /* renamed from: zzqd */
    public String zzqe() {
        return "ownedByMe()";
    }
}
