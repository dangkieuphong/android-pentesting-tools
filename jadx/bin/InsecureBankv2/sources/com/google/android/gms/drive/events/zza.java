package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zza implements Parcelable.Creator<ChangeEvent> {
    static void zza(ChangeEvent changeEvent, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, changeEvent.zzCY);
        zzb.zza(parcel, 2, (Parcelable) changeEvent.zzacT, i, false);
        zzb.zzc(parcel, 3, changeEvent.zzadN);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzav */
    public ChangeEvent createFromParcel(Parcel parcel) {
        int zzg;
        DriveId driveId;
        int i;
        int i2 = 0;
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        DriveId driveId2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    driveId = driveId2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    zzg = i2;
                    break;
                case 2:
                    DriveId driveId3 = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, DriveId.CREATOR);
                    i = i3;
                    zzg = i2;
                    driveId = driveId3;
                    break;
                case 3:
                    zzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    driveId = driveId2;
                    i = i3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
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
            return new ChangeEvent(i3, driveId2, i2);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzce */
    public ChangeEvent[] newArray(int i) {
        return new ChangeEvent[i];
    }
}
