package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzg implements Parcelable.Creator<GetRecentContextCall.Response> {
    static void zza(GetRecentContextCall.Response response, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1000, response.zzCY);
        zzb.zza(parcel, 1, (Parcelable) response.zzNn, i, false);
        zzb.zzc(parcel, 2, response.zzNo, false);
        zzb.zza(parcel, 3, response.zzNp, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzah */
    public GetRecentContextCall.Response[] newArray(int i) {
        return new GetRecentContextCall.Response[i];
    }

    /* renamed from: zzw */
    public GetRecentContextCall.Response createFromParcel(Parcel parcel) {
        String[] zzA;
        ArrayList arrayList;
        Status status;
        int i;
        String[] strArr = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        ArrayList arrayList2 = null;
        Status status2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = i2;
                    status = (Status) zza.zza(parcel, zzaa, Status.CREATOR);
                    zzA = strArr;
                    arrayList = arrayList2;
                    break;
                case 2:
                    status = status2;
                    i = i2;
                    arrayList = zza.zzc(parcel, zzaa, UsageInfo.CREATOR);
                    zzA = strArr;
                    break;
                case 3:
                    zzA = zza.zzA(parcel, zzaa);
                    arrayList = arrayList2;
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    arrayList = arrayList2;
                    status = status2;
                    i = zza.zzg(parcel, zzaa);
                    zzA = strArr;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzA = strArr;
                    arrayList = arrayList2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            arrayList2 = arrayList;
            strArr = zzA;
        }
        if (parcel.dataPosition() == zzab) {
            return new GetRecentContextCall.Response(i2, status2, arrayList2, strArr);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }
}
