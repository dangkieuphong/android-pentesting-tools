package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Parcelable.Creator<PlayLoggerContext> {
    static void zza(PlayLoggerContext playLoggerContext, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, playLoggerContext.versionCode);
        zzb.zza(parcel, 2, playLoggerContext.packageName, false);
        zzb.zzc(parcel, 3, playLoggerContext.zzaGP);
        zzb.zzc(parcel, 4, playLoggerContext.zzaGQ);
        zzb.zza(parcel, 5, playLoggerContext.zzaGR, false);
        zzb.zza(parcel, 6, playLoggerContext.zzaGS, false);
        zzb.zza(parcel, 7, playLoggerContext.zzaGT);
        zzb.zza(parcel, 8, playLoggerContext.zzaGU, false);
        zzb.zza(parcel, 9, playLoggerContext.zzaGV);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzfH */
    public PlayLoggerContext createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzab = zza.zzab(parcel);
        boolean z2 = true;
        String str2 = null;
        String str3 = null;
        int i = 0;
        int i2 = 0;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 7:
                    z2 = zza.zzc(parcel, zzaa);
                    break;
                case 8:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 9:
                    z = zza.zzc(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new PlayLoggerContext(i3, str4, i2, i, str3, str2, z2, str, z);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zziw */
    public PlayLoggerContext[] newArray(int i) {
        return new PlayLoggerContext[i];
    }
}
