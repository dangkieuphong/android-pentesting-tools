package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class zzh implements Parcelable.Creator<CloseContentsRequest> {
    static void zza(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, closeContentsRequest.zzCY);
        zzb.zza(parcel, 2, (Parcelable) closeContentsRequest.zzaes, i, false);
        zzb.zza(parcel, 3, closeContentsRequest.zzaew, false);
        zzb.zzc(parcel, 4, closeContentsRequest.zzaeu);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzaH */
    public CloseContentsRequest createFromParcel(Parcel parcel) {
        int zzg;
        Boolean bool;
        Contents contents;
        int i;
        Boolean bool2 = null;
        int i2 = 0;
        int zzab = zza.zzab(parcel);
        Contents contents2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    bool = bool2;
                    contents = contents2;
                    i = zza.zzg(parcel, zzaa);
                    zzg = i2;
                    break;
                case 2:
                    i = i3;
                    contents = (Contents) zza.zza(parcel, zzaa, Contents.CREATOR);
                    zzg = i2;
                    bool = bool2;
                    break;
                case 3:
                    contents = contents2;
                    i = i3;
                    bool = zza.zzd(parcel, zzaa);
                    zzg = i2;
                    break;
                case 4:
                    zzg = zza.zzg(parcel, zzaa);
                    bool = bool2;
                    contents = contents2;
                    i = i3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzg = i2;
                    bool = bool2;
                    contents = contents2;
                    i = i3;
                    break;
            }
            i3 = i;
            contents2 = contents;
            bool2 = bool;
            i2 = zzg;
        }
        if (parcel.dataPosition() == zzab) {
            return new CloseContentsRequest(i3, contents2, bool2, i2);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzcr */
    public CloseContentsRequest[] newArray(int i) {
        return new CloseContentsRequest[i];
    }
}
