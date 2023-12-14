package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzk implements Parcelable.Creator<ParentDriveIdSet> {
    static void zza(ParentDriveIdSet parentDriveIdSet, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, parentDriveIdSet.zzCY);
        zzb.zzc(parcel, 2, parentDriveIdSet.zzagJ, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzbD */
    public ParentDriveIdSet createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzaa, PartialDriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ParentDriveIdSet(i, arrayList);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzds */
    public ParentDriveIdSet[] newArray(int i) {
        return new ParentDriveIdSet[i];
    }
}
