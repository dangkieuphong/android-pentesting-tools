package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc implements Parcelable.Creator<Bucket> {
    static void zza(Bucket bucket, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, bucket.zzkt());
        zzb.zzc(parcel, 1000, bucket.getVersionCode());
        zzb.zza(parcel, 2, bucket.zzqs());
        zzb.zza(parcel, 3, (Parcelable) bucket.getSession(), i, false);
        zzb.zzc(parcel, 4, bucket.zzqq());
        zzb.zzc(parcel, 5, bucket.getDataSets(), false);
        zzb.zzc(parcel, 6, bucket.getBucketType());
        zzb.zza(parcel, 7, bucket.zzqr());
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzck */
    public Bucket createFromParcel(Parcel parcel) {
        long j = 0;
        ArrayList arrayList = null;
        boolean z = false;
        int zzab = zza.zzab(parcel);
        int i = 0;
        int i2 = 0;
        Session session = null;
        long j2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    j2 = zza.zzi(parcel, zzaa);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 3:
                    session = (Session) zza.zza(parcel, zzaa, Session.CREATOR);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    arrayList = zza.zzc(parcel, zzaa, DataSet.CREATOR);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new Bucket(i3, j2, j, session, i2, arrayList, i, z);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzec */
    public Bucket[] newArray(int i) {
        return new Bucket[i];
    }
}
