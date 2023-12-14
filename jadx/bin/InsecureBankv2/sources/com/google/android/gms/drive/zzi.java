package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzi implements Parcelable.Creator<RealtimeDocumentSyncRequest> {
    static void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, realtimeDocumentSyncRequest.zzCY);
        zzb.zzb(parcel, 2, realtimeDocumentSyncRequest.zzadF, false);
        zzb.zzb(parcel, 3, realtimeDocumentSyncRequest.zzadG, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzat */
    public RealtimeDocumentSyncRequest createFromParcel(Parcel parcel) {
        ArrayList<String> arrayList = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        ArrayList<String> arrayList2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    arrayList2 = zza.zzC(parcel, zzaa);
                    break;
                case 3:
                    arrayList = zza.zzC(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new RealtimeDocumentSyncRequest(i, arrayList2, arrayList);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzcc */
    public RealtimeDocumentSyncRequest[] newArray(int i) {
        return new RealtimeDocumentSyncRequest[i];
    }
}
