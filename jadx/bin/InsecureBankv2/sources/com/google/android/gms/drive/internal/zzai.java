package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzai implements Parcelable.Creator<GetPermissionsRequest> {
    static void zza(GetPermissionsRequest getPermissionsRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getPermissionsRequest.zzCY);
        zzb.zza(parcel, 2, (Parcelable) getPermissionsRequest.zzacT, i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzaU */
    public GetPermissionsRequest createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzaa, DriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetPermissionsRequest(i, driveId);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzcJ */
    public GetPermissionsRequest[] newArray(int i) {
        return new GetPermissionsRequest[i];
    }
}
