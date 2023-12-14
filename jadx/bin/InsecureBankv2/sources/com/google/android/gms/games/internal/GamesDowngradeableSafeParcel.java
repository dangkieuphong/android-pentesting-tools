package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.internal.zzlf;

public abstract class GamesDowngradeableSafeParcel extends DowngradeableSafeParcel {
    /* access modifiers changed from: protected */
    public static boolean zzd(Integer num) {
        if (num == null) {
            return false;
        }
        return zzlf.zzbQ(num.intValue());
    }
}
