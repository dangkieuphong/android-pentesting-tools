package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzag implements Parcelable.Creator<GetDriveIdFromUniqueIdentifierRequest> {
    static void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getDriveIdFromUniqueIdentifierRequest.zzCY);
        zzb.zza(parcel, 2, getDriveIdFromUniqueIdentifierRequest.zzafL, false);
        zzb.zza(parcel, 3, getDriveIdFromUniqueIdentifierRequest.zzafM);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzaS */
    public GetDriveIdFromUniqueIdentifierRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzab = zza.zzab(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetDriveIdFromUniqueIdentifierRequest(i, str, z);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzcH */
    public GetDriveIdFromUniqueIdentifierRequest[] newArray(int i) {
        return new GetDriveIdFromUniqueIdentifierRequest[i];
    }
}
