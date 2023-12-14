package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Permission;
import java.util.ArrayList;

public class zzaj implements Parcelable.Creator<GetPermissionsResponse> {
    static void zza(GetPermissionsResponse getPermissionsResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getPermissionsResponse.zzCY);
        zzb.zzc(parcel, 2, getPermissionsResponse.zzafO, false);
        zzb.zzc(parcel, 3, getPermissionsResponse.zzws);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzaV */
    public GetPermissionsResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        ArrayList arrayList = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzaa, Permission.CREATOR);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetPermissionsResponse(i2, arrayList, i);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzcK */
    public GetPermissionsResponse[] newArray(int i) {
        return new GetPermissionsResponse[i];
    }
}
