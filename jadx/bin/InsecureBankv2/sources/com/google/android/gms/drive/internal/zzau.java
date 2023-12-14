package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class zzau implements Parcelable.Creator<OnContentsResponse> {
    static void zza(OnContentsResponse onContentsResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, onContentsResponse.zzCY);
        zzb.zza(parcel, 2, (Parcelable) onContentsResponse.zzafa, i, false);
        zzb.zza(parcel, 3, onContentsResponse.zzage);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzaZ */
    public OnContentsResponse createFromParcel(Parcel parcel) {
        boolean zzc;
        Contents contents;
        int i;
        boolean z = false;
        int zzab = zza.zzab(parcel);
        Contents contents2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    contents = contents2;
                    i = zza.zzg(parcel, zzaa);
                    zzc = z;
                    break;
                case 2:
                    Contents contents3 = (Contents) zza.zza(parcel, zzaa, Contents.CREATOR);
                    i = i2;
                    zzc = z;
                    contents = contents3;
                    break;
                case 3:
                    zzc = zza.zzc(parcel, zzaa);
                    contents = contents2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzc = z;
                    contents = contents2;
                    i = i2;
                    break;
            }
            i2 = i;
            contents2 = contents;
            z = zzc;
        }
        if (parcel.dataPosition() == zzab) {
            return new OnContentsResponse(i2, contents2, z);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzcO */
    public OnContentsResponse[] newArray(int i) {
        return new OnContentsResponse[i];
    }
}
