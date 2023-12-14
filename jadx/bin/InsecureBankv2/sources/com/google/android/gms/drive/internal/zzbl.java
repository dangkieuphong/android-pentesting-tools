package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbl implements Parcelable.Creator<RemoveEventListenerRequest> {
    static void zza(RemoveEventListenerRequest removeEventListenerRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, removeEventListenerRequest.zzCY);
        zzb.zza(parcel, 2, (Parcelable) removeEventListenerRequest.zzacT, i, false);
        zzb.zzc(parcel, 3, removeEventListenerRequest.zzaca);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzbp */
    public RemoveEventListenerRequest createFromParcel(Parcel parcel) {
        int zzg;
        DriveId driveId;
        int i;
        int i2 = 0;
        int zzab = zza.zzab(parcel);
        DriveId driveId2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    driveId = driveId2;
                    i = zza.zzg(parcel, zzaa);
                    zzg = i2;
                    break;
                case 2:
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzaa, DriveId.CREATOR);
                    i = i3;
                    zzg = i2;
                    driveId = driveId3;
                    break;
                case 3:
                    zzg = zza.zzg(parcel, zzaa);
                    driveId = driveId2;
                    i = i3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzg = i2;
                    driveId = driveId2;
                    i = i3;
                    break;
            }
            i3 = i;
            driveId2 = driveId;
            i2 = zzg;
        }
        if (parcel.dataPosition() == zzab) {
            return new RemoveEventListenerRequest(i3, driveId2, i2);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzde */
    public RemoveEventListenerRequest[] newArray(int i) {
        return new RemoveEventListenerRequest[i];
    }
}
