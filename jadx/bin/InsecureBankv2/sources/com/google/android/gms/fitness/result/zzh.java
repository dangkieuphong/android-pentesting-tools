package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Subscription;
import java.util.ArrayList;

public class zzh implements Parcelable.Creator<ListSubscriptionsResult> {
    static void zza(ListSubscriptionsResult listSubscriptionsResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, listSubscriptionsResult.getSubscriptions(), false);
        zzb.zzc(parcel, 1000, listSubscriptionsResult.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) listSubscriptionsResult.getStatus(), i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzdl */
    public ListSubscriptionsResult createFromParcel(Parcel parcel) {
        Status status = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    arrayList = zza.zzc(parcel, zzaa, Subscription.CREATOR);
                    break;
                case 2:
                    status = (Status) zza.zza(parcel, zzaa, Status.CREATOR);
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
            return new ListSubscriptionsResult(i, arrayList, status);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzfg */
    public ListSubscriptionsResult[] newArray(int i) {
        return new ListSubscriptionsResult[i];
    }
}
