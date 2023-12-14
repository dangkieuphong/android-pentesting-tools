package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.internal.zzq;

public class zzak extends zzq<zzal> {

    private static class zza extends zzc implements zzq.zza<zzal> {
        private final zzal zzMD = new zzal();

        public zza(zzf zzf) {
            super(zzf);
        }

        @Override // com.google.android.gms.analytics.internal.zzq.zza
        public void zzc(String str, boolean z) {
            int i = 1;
            if ("ga_autoActivityTracking".equals(str)) {
                zzal zzal = this.zzMD;
                if (!z) {
                    i = 0;
                }
                zzal.zzMG = i;
            } else if ("ga_anonymizeIp".equals(str)) {
                zzal zzal2 = this.zzMD;
                if (!z) {
                    i = 0;
                }
                zzal2.zzMH = i;
            } else if ("ga_reportUncaughtExceptions".equals(str)) {
                zzal zzal3 = this.zzMD;
                if (!z) {
                    i = 0;
                }
                zzal3.zzMI = i;
            } else {
                zzd("bool configuration name not recognized", str);
            }
        }

        @Override // com.google.android.gms.analytics.internal.zzq.zza
        public void zzd(String str, int i) {
            if ("ga_sessionTimeout".equals(str)) {
                this.zzMD.zzMF = i;
            } else {
                zzd("int configuration name not recognized", str);
            }
        }

        @Override // com.google.android.gms.analytics.internal.zzq.zza
        public void zzk(String str, String str2) {
            this.zzMD.zzMJ.put(str, str2);
        }

        /* renamed from: zzkx */
        public zzal zziV() {
            return this.zzMD;
        }

        @Override // com.google.android.gms.analytics.internal.zzq.zza
        public void zzl(String str, String str2) {
            if ("ga_trackingId".equals(str)) {
                this.zzMD.zztd = str2;
            } else if ("ga_sampleFrequency".equals(str)) {
                try {
                    this.zzMD.zzME = Double.parseDouble(str2);
                } catch (NumberFormatException e) {
                    zzc("Error parsing ga_sampleFrequency value", str2, e);
                }
            } else {
                zzd("string configuration name not recognized", str);
            }
        }
    }

    public zzak(zzf zzf) {
        super(zzf, new zza(zzf));
    }
}
