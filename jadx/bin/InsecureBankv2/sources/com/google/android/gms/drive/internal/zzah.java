package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzah implements Parcelable.Creator<GetMetadataRequest> {
    static void zza(GetMetadataRequest getMetadataRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getMetadataRequest.zzCY);
        zzb.zza(parcel, 2, (Parcelable) getMetadataRequest.zzaeq, i, false);
        zzb.zza(parcel, 3, getMetadataRequest.zzafN);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzaT */
    public GetMetadataRequest createFromParcel(Parcel parcel) {
        boolean zzc;
        DriveId driveId;
        int i;
        boolean z = false;
        int zzab = zza.zzab(parcel);
        DriveId driveId2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    driveId = driveId2;
                    i = zza.zzg(parcel, zzaa);
                    zzc = z;
                    break;
                case 2:
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzaa, DriveId.CREATOR);
                    i = i2;
                    zzc = z;
                    driveId = driveId3;
                    break;
                case 3:
                    zzc = zza.zzc(parcel, zzaa);
                    driveId = driveId2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzc = z;
                    driveId = driveId2;
                    i = i2;
                    break;
            }
            i2 = i;
            driveId2 = driveId;
            z = zzc;
        }
        if (parcel.dataPosition() == zzab) {
            return new GetMetadataRequest(i2, driveId2, z);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzcI */
    public GetMetadataRequest[] newArray(int i) {
        return new GetMetadataRequest[i];
    }
}
