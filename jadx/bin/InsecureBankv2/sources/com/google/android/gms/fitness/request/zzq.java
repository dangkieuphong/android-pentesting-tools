package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzq implements Parcelable.Creator<ReadRawRequest> {
    static void zza(ReadRawRequest readRawRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, readRawRequest.zzqU(), false);
        zzb.zzc(parcel, 1000, readRawRequest.getVersionCode());
        zzb.zza(parcel, 2, readRawRequest.getPackageName(), false);
        zzb.zzc(parcel, 3, readRawRequest.zzrf(), false);
        zzb.zza(parcel, 4, readRawRequest.zzra());
        zzb.zza(parcel, 5, readRawRequest.zzqZ());
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzcP */
    public ReadRawRequest createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        boolean z = false;
        int zzab = zza.zzab(parcel);
        boolean z2 = false;
        String str = null;
        IBinder iBinder = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    arrayList = zza.zzc(parcel, zzaa, DataSourceQueryParams.CREATOR);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzaa);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ReadRawRequest(i, iBinder, str, arrayList, z2, z);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzeJ */
    public ReadRawRequest[] newArray(int i) {
        return new ReadRawRequest[i];
    }
}
