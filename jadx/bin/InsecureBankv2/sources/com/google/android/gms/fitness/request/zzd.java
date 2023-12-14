package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;

public class zzd implements Parcelable.Creator<DataDeleteRequest> {
    static void zza(DataDeleteRequest dataDeleteRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, dataDeleteRequest.zzkt());
        zzb.zzc(parcel, 1000, dataDeleteRequest.getVersionCode());
        zzb.zza(parcel, 2, dataDeleteRequest.zzqs());
        zzb.zzc(parcel, 3, dataDeleteRequest.getDataSources(), false);
        zzb.zzc(parcel, 4, dataDeleteRequest.getDataTypes(), false);
        zzb.zzc(parcel, 5, dataDeleteRequest.getSessions(), false);
        zzb.zza(parcel, 6, dataDeleteRequest.zzqV());
        zzb.zza(parcel, 7, dataDeleteRequest.zzqW());
        zzb.zza(parcel, 8, dataDeleteRequest.zzqU(), false);
        zzb.zza(parcel, 9, dataDeleteRequest.getPackageName(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzcD */
    public DataDeleteRequest createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        long j = 0;
        long j2 = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        boolean z = false;
        boolean z2 = false;
        IBinder iBinder = null;
        String str = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzaa);
                    break;
                case 3:
                    arrayList = zza.zzc(parcel, zzaa, DataSource.CREATOR);
                    break;
                case 4:
                    arrayList2 = zza.zzc(parcel, zzaa, DataType.CREATOR);
                    break;
                case 5:
                    arrayList3 = zza.zzc(parcel, zzaa, Session.CREATOR);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 7:
                    z2 = zza.zzc(parcel, zzaa);
                    break;
                case 8:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 9:
                    str = zza.zzo(parcel, zzaa);
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
            return new DataDeleteRequest(i, j, j2, arrayList, arrayList2, arrayList3, z, z2, iBinder, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzex */
    public DataDeleteRequest[] newArray(int i) {
        return new DataDeleteRequest[i];
    }
}
