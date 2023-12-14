package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Set;

/* access modifiers changed from: package-private */
public class zze {
    static MetadataField<?> zzb(MetadataBundle metadataBundle) {
        Set<MetadataField<?>> zzpY = metadataBundle.zzpY();
        if (zzpY.size() == 1) {
            return zzpY.iterator().next();
        }
        throw new IllegalArgumentException("bundle should have exactly 1 populated field");
    }
}
