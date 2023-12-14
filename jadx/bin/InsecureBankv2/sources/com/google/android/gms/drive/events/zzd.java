package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveSpace;
import java.util.ArrayList;

public class zzd implements Parcelable.Creator<ChangesAvailableOptions> {
    static void zza(ChangesAvailableOptions changesAvailableOptions, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, changesAvailableOptions.zzCY);
        zzb.zzc(parcel, 2, changesAvailableOptions.zzadP);
        zzb.zza(parcel, 3, changesAvailableOptions.zzadQ);
        zzb.zzc(parcel, 4, changesAvailableOptions.zzadR, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzax */
    public ChangesAvailableOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzab = zza.zzab(parcel);
        ArrayList arrayList = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 4:
                    arrayList = zza.zzc(parcel, zzaa, DriveSpace.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ChangesAvailableOptions(i2, i, z, arrayList);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzcg */
    public ChangesAvailableOptions[] newArray(int i) {
        return new ChangesAvailableOptions[i];
    }
}
