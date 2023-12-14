package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DrivePreferences;

public class zzay implements Parcelable.Creator<OnDrivePreferencesResponse> {
    static void zza(OnDrivePreferencesResponse onDrivePreferencesResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, onDrivePreferencesResponse.zzCY);
        zzb.zza(parcel, 2, (Parcelable) onDrivePreferencesResponse.zzagi, i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzbd */
    public OnDrivePreferencesResponse createFromParcel(Parcel parcel) {
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
            return new OnDrivePreferencesResponse(i, drivePreferences);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzcS */
    public OnDrivePreferencesResponse[] newArray(int i) {
        return new OnDrivePreferencesResponse[i];
    }
}
