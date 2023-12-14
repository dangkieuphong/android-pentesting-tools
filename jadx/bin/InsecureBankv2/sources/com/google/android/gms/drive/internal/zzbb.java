package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbb implements Parcelable.Creator<OnListEntriesResponse> {
    static void zza(OnListEntriesResponse onListEntriesResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, onListEntriesResponse.zzCY);
        zzb.zza(parcel, 2, (Parcelable) onListEntriesResponse.zzagp, i, false);
        zzb.zza(parcel, 3, onListEntriesResponse.zzaeL);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzbg */
    public OnListEntriesResponse createFromParcel(Parcel parcel) {
        boolean zzc;
        DataHolder dataHolder;
        int i;
        boolean z = false;
        int zzab = zza.zzab(parcel);
        DataHolder dataHolder2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    dataHolder = dataHolder2;
                    i = zza.zzg(parcel, zzaa);
                    zzc = z;
                    break;
                case 2:
                    DataHolder dataHolder3 = (DataHolder) zza.zza(parcel, zzaa, DataHolder.CREATOR);
                    i = i2;
                    zzc = z;
                    dataHolder = dataHolder3;
                    break;
                case 3:
                    zzc = zza.zzc(parcel, zzaa);
                    dataHolder = dataHolder2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzc = z;
                    dataHolder = dataHolder2;
                    i = i2;
                    break;
            }
            i2 = i;
            dataHolder2 = dataHolder;
            z = zzc;
        }
        if (parcel.dataPosition() == zzab) {
            return new OnListEntriesResponse(i2, dataHolder2, z);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzcV */
    public OnListEntriesResponse[] newArray(int i) {
        return new OnListEntriesResponse[i];
    }
}
