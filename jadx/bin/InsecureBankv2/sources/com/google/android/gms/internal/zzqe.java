package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqf;

public class zzqe implements Result {
    private final zza zzaPo;

    public static class zza {
        private final Status zzOt;
        private final EnumC0142zza zzaPp;
        private final byte[] zzaPq;
        private final long zzaPr;
        private final zzpy zzaPs;
        private final zzqf.zzc zzaPt;

        /* renamed from: com.google.android.gms.internal.zzqe$zza$zza  reason: collision with other inner class name */
        public enum EnumC0142zza {
            NETWORK,
            DISK,
            DEFAULT
        }

        public zza(Status status, zzpy zzpy, EnumC0142zza zza) {
            this(status, zzpy, null, null, zza, 0);
        }

        public zza(Status status, zzpy zzpy, byte[] bArr, zzqf.zzc zzc, EnumC0142zza zza, long j) {
            this.zzOt = status;
            this.zzaPs = zzpy;
            this.zzaPq = bArr;
            this.zzaPt = zzc;
            this.zzaPp = zza;
            this.zzaPr = j;
        }

        public Status getStatus() {
            return this.zzOt;
        }

        public EnumC0142zza zzAh() {
            return this.zzaPp;
        }

        public byte[] zzAi() {
            return this.zzaPq;
        }

        public zzpy zzAj() {
            return this.zzaPs;
        }

        public zzqf.zzc zzAk() {
            return this.zzaPt;
        }

        public long zzAl() {
            return this.zzaPr;
        }
    }

    public zzqe(zza zza2) {
        this.zzaPo = zza2;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzaPo.getStatus();
    }

    public zza zzAg() {
        return this.zzaPo;
    }
}
