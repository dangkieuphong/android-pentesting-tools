package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DrivePreferences;

public class zzbn implements Parcelable.Creator<SetDrivePreferencesRequest> {
    static void zza(SetDrivePreferencesRequest setDrivePreferencesRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, setDrivePreferencesRequest.zzCY);
        zzb.zza(parcel, 2, (Parcelable) setDrivePreferencesRequest.zzagi, i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzbr */
    public SetDrivePreferencesRequest createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        DrivePreferences drivePreferences = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    drivePreferences = (DrivePreferences) zza.zza(parcel, zzaa, DrivePreferences.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new SetDrivePreferencesRequest(i, drivePreferences);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzdg */
    public SetDrivePreferencesRequest[] newArray(int i) {
        return new SetDrivePreferencesRequest[i];
    }
}
