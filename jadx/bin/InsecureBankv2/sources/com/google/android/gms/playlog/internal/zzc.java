package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Parcelable.Creator<LogEvent> {
    static void zza(LogEvent logEvent, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, logEvent.versionCode);
        zzb.zza(parcel, 2, logEvent.zzaGF);
        zzb.zza(parcel, 3, logEvent.tag, false);
        zzb.zza(parcel, 4, logEvent.zzaGG, false);
        zzb.zza(parcel, 5, logEvent.zzaGH, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzfG */
    public LogEvent createFromParcel(Parcel parcel) {
        Bundle bundle = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        long j = 0;
        byte[] bArr = null;
        String str = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    bArr = zza.zzr(parcel, zzaa);
                    break;
                case 5:
                    bundle = zza.zzq(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new LogEvent(i, j, str, bArr, bundle);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zziv */
    public LogEvent[] newArray(int i) {
        return new LogEvent[i];
    }
}
