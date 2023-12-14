package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.zzj;
import java.util.Arrays;

public class zzlp extends zzj<AppVisibleCustomProperties> {
    public zzlp(int i) {
        super("customProperties", Arrays.asList("customProperties", "sqlId"), Arrays.asList("customPropertiesExtra"), i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzl */
    public AppVisibleCustomProperties zzc(DataHolder dataHolder, int i, int i2) {
        return (AppVisibleCustomProperties) dataHolder.zznb().getSparseParcelableArray("customPropertiesExtra").get(i, AppVisibleCustomProperties.zzagD);
    }
}
