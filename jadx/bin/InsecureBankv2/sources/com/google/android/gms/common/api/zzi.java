package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzu;

public final class zzi<L> {
    private volatile L mListener;
    private final zzi<L>.zza zzXL;

    private final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            boolean z = true;
            if (msg.what != 1) {
                z = false;
            }
            zzu.zzV(z);
            zzi.this.zzb((zzb) msg.obj);
        }
    }

    public interface zzb<L> {
        void zzmw();

        void zzn(L l);
    }

    zzi(Looper looper, L l) {
        this.zzXL = new zza(looper);
        this.mListener = (L) zzu.zzb(l, "Listener must not be null");
    }

    public void clear() {
        this.mListener = null;
    }

    public void zza(zzb<? super L> zzb2) {
        zzu.zzb(zzb2, "Notifier must not be null");
        this.zzXL.sendMessage(this.zzXL.obtainMessage(1, zzb2));
    }

    /* access modifiers changed from: package-private */
    public void zzb(zzb<? super L> zzb2) {
        L l = this.mListener;
        if (l == null) {
            zzb2.zzmw();
            return;
        }
        try {
            zzb2.zzn(l);
        } catch (RuntimeException e) {
            zzb2.zzmw();
            throw e;
        }
    }
}
