package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbh implements Parcelable.Creator<OpenContentsRequest> {
    static void zza(OpenContentsRequest openContentsRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, openContentsRequest.zzCY);
        zzb.zza(parcel, 2, (Parcelable) openContentsRequest.zzaeq, i, false);
        zzb.zzc(parcel, 3, openContentsRequest.zzacS);
        zzb.zzc(parcel, 4, openContentsRequest.zzagr);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzbm */
    public OpenContentsRequest createFromParcel(Parcel parcel) {
        int zzg;
        int i;
        DriveId driveId;
        int i2;
        int i3 = 0;
        int zzab = zza.zzab(parcel);
        DriveId driveId2 = null;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = i4;
                    driveId = driveId2;
                    i2 = zza.zzg(parcel, zzaa);
                    zzg = i3;
                    break;
                case 2:
                    i2 = i5;
                    driveId = (DriveId) zza.zza(parcel, zzaa, DriveId.CREATOR);
                    zzg = i3;
                    i = i4;
                    break;
                case 3:
                    driveId = driveId2;
                    i2 = i5;
                    i = zza.zzg(parcel, zzaa);
                    zzg = i3;
                    break;
                case 4:
                    zzg = zza.zzg(parcel, zzaa);
                    i = i4;
                    driveId = driveId2;
                    i2 = i5;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzg = i3;
                    i = i4;
                    driveId = driveId2;
                    i2 = i5;
                    break;
            }
            i5 = i2;
            driveId2 = driveId;
            i4 = i;
            i3 = zzg;
        }
        if (parcel.dataPosition() == zzab) {
            return new OpenContentsRequest(i5, driveId2, i4, i3);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzdb */
    public OpenContentsRequest[] newArray(int i) {
        return new OpenContentsRequest[i];
    }
}
