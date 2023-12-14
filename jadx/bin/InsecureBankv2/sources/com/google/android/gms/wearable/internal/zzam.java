package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzam implements Parcelable.Creator<GetConnectedNodesResponse> {
    static void zza(GetConnectedNodesResponse getConnectedNodesResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getConnectedNodesResponse.versionCode);
        zzb.zzc(parcel, 2, getConnectedNodesResponse.statusCode);
        zzb.zzc(parcel, 3, getConnectedNodesResponse.zzaUw, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzhe */
    public GetConnectedNodesResponse createFromParcel(Parcel parcel) {
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
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 3:
                    arrayList = zza.zzc(parcel, zzaa, NodeParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetConnectedNodesResponse(i2, i, arrayList);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzkm */
    public GetConnectedNodesResponse[] newArray(int i) {
        return new GetConnectedNodesResponse[i];
    }
}
