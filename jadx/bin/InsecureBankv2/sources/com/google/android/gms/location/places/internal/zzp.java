package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.location.places.zzg;

public class zzp implements zzg {
    private int mIndex;
    private final String zzaAW;
    private final CharSequence zzaAX;
    private final int zzyZ;
    private final int zzza;

    public zzp(String str, int i, int i2, CharSequence charSequence, int i3) {
        this.zzaAW = str;
        this.zzyZ = i;
        this.zzza = i2;
        this.zzaAX = charSequence;
        this.mIndex = i3;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof zzp)) {
            return false;
        }
        zzp zzp = (zzp) other;
        return zzp.zzyZ == this.zzyZ && zzp.zzza == this.zzza && zzt.equal(zzp.zzaAW, this.zzaAW) && zzt.equal(zzp.zzaAX, this.zzaAX);
    }

    public int hashCode() {
        return zzt.hashCode(Integer.valueOf(this.zzyZ), Integer.valueOf(this.zzza), this.zzaAW, this.zzaAX);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    /* renamed from: zzuZ */
    public zzg freeze() {
        return this;
    }
}
