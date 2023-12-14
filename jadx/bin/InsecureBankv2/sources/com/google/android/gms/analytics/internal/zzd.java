package com.google.android.gms.analytics.internal;

public abstract class zzd extends zzc {
    private boolean zzJA;
    private boolean zzJz;

    protected zzd(zzf zzf) {
        super(zzf);
    }

    public boolean isInitialized() {
        return this.zzJz && !this.zzJA;
    }

    public void zza() {
        zzhn();
        this.zzJz = true;
    }

    /* access modifiers changed from: protected */
    public abstract void zzhn();

    /* access modifiers changed from: protected */
    public void zzia() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
