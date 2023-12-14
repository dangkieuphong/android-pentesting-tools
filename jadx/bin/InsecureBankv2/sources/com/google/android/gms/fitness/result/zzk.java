package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;

public class zzk implements Parcelable.Creator<SessionStopResult> {
    static void zza(SessionStopResult sessionStopResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1000, sessionStopResult.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) sessionStopResult.getStatus(), i, false);
        zzb.zzc(parcel, 3, sessionStopResult.getSessions(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzdo */
    public SessionStopResult createFromParcel(Parcel parcel) {
        ArrayList zzc;
        Status status;
        int i;
        ArrayList arrayList = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 2:
                    Status status3 = (Status) zza.zza(parcel, zzaa, Status.CREATOR);
                    i = i2;
                    zzc = arrayList;
                    status = status3;
                    break;
                case 3:
                    zzc = zza.zzc(parcel, zzaa, Session.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    status = status2;
                    i = zza.zzg(parcel, zzaa);
                    zzc = arrayList;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzc = arrayList;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            arrayList = zzc;
        }
        if (parcel.dataPosition() == zzab) {
            return new SessionStopResult(i2, status2, arrayList);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzfj */
    public SessionStopResult[] newArray(int i) {
        return new SessionStopResult[i];
    }
}
