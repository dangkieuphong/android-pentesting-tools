package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzo implements Parcelable.Creator<DeleteResourceRequest> {
    static void zza(DeleteResourceRequest deleteResourceRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, deleteResourceRequest.zzCY);
        zzb.zza(parcel, 2, (Parcelable) deleteResourceRequest.zzaeq, i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzaM */
    public DeleteResourceRequest createFromParcel(Parcel parcel) {
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
            return new DeleteResourceRequest(i, driveId);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzcx */
    public DeleteResourceRequest[] newArray(int i) {
        return new DeleteResourceRequest[i];
    }
}
