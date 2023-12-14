package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq implements Parcelable.Creator<SessionDataSet> {
    static void zza(SessionDataSet sessionDataSet, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) sessionDataSet.getSession(), i, false);
        zzb.zzc(parcel, 1000, sessionDataSet.zzCY);
        zzb.zza(parcel, 2, (Parcelable) sessionDataSet.zzqK(), i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzcw */
    public SessionDataSet createFromParcel(Parcel parcel) {
        DataSet dataSet;
        Session session;
        int i;
        DataSet dataSet2 = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        Session session2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    Session session3 = (Session) zza.zza(parcel, zzaa, Session.CREATOR);
                    i = i2;
                    dataSet = dataSet2;
                    session = session3;
                    break;
                case 2:
                    dataSet = (DataSet) zza.zza(parcel, zzaa, DataSet.CREATOR);
                    session = session2;
                    i = i2;
                    break;
                case 1000:
                    session = session2;
                    i = zza.zzg(parcel, zzaa);
                    dataSet = dataSet2;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    dataSet = dataSet2;
                    session = session2;
                    i = i2;
                    break;
            }
            i2 = i;
            session2 = session;
            dataSet2 = dataSet;
        }
        if (parcel.dataPosition() == zzab) {
            return new SessionDataSet(i2, session2, dataSet2);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzeq */
    public SessionDataSet[] newArray(int i) {
        return new SessionDataSet[i];
    }
}
