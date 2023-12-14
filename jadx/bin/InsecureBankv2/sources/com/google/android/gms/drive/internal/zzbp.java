package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;

public class zzbp implements Parcelable.Creator<SetResourceParentsRequest> {
    static void zza(SetResourceParentsRequest setResourceParentsRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, setResourceParentsRequest.zzCY);
        zzb.zza(parcel, 2, (Parcelable) setResourceParentsRequest.zzagv, i, false);
        zzb.zzc(parcel, 3, setResourceParentsRequest.zzagw, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzbt */
    public SetResourceParentsRequest createFromParcel(Parcel parcel) {
        ArrayList zzc;
        DriveId driveId;
        int i;
        ArrayList arrayList = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        DriveId driveId2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    driveId = driveId2;
                    i = zza.zzg(parcel, zzaa);
                    zzc = arrayList;
                    break;
                case 2:
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzaa, DriveId.CREATOR);
                    i = i2;
                    zzc = arrayList;
                    driveId = driveId3;
                    break;
                case 3:
                    zzc = zza.zzc(parcel, zzaa, DriveId.CREATOR);
                    driveId = driveId2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzc = arrayList;
                    driveId = driveId2;
                    i = i2;
                    break;
            }
            i2 = i;
            driveId2 = driveId;
            arrayList = zzc;
        }
        if (parcel.dataPosition() == zzab) {
            return new SetResourceParentsRequest(i2, driveId2, arrayList);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzdi */
    public SetResourceParentsRequest[] newArray(int i) {
        return new SetResourceParentsRequest[i];
    }
}
