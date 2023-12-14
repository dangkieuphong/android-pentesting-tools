package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.SessionDataSet;
import java.util.ArrayList;

public class zzj implements Parcelable.Creator<SessionReadResult> {
    static void zza(SessionReadResult sessionReadResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, sessionReadResult.getSessions(), false);
        zzb.zzc(parcel, 1000, sessionReadResult.getVersionCode());
        zzb.zzc(parcel, 2, sessionReadResult.zzry(), false);
        zzb.zza(parcel, 3, (Parcelable) sessionReadResult.getStatus(), i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzdn */
    public SessionReadResult createFromParcel(Parcel parcel) {
        Status status = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    arrayList2 = zza.zzc(parcel, zzaa, Session.CREATOR);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzaa, SessionDataSet.CREATOR);
                    break;
                case 3:
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
            return new SessionReadResult(i, arrayList2, arrayList, status);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzfi */
    public SessionReadResult[] newArray(int i) {
        return new SessionReadResult[i];
    }
}
