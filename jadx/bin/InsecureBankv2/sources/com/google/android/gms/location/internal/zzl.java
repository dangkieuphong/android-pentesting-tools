package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Parcelable.Creator<LocationRequestUpdateData> {
    static void zza(LocationRequestUpdateData locationRequestUpdateData, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, locationRequestUpdateData.zzazf);
        zzb.zzc(parcel, 1000, locationRequestUpdateData.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) locationRequestUpdateData.zzazg, i, false);
        zzb.zza(parcel, 3, locationRequestUpdateData.zzuy(), false);
        zzb.zza(parcel, 4, (Parcelable) locationRequestUpdateData.mPendingIntent, i, false);
        zzb.zza(parcel, 5, locationRequestUpdateData.zzuz(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzel */
    public LocationRequestUpdateData createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        int i2 = 1;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = null;
        LocationRequestInternal locationRequestInternal = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    locationRequestInternal = (LocationRequestInternal) zza.zza(parcel, zzaa, LocationRequestInternal.CREATOR);
                    break;
                case 3:
                    iBinder2 = zza.zzp(parcel, zzaa);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzaa, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder = zza.zzp(parcel, zzaa);
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
            return new LocationRequestUpdateData(i, i2, locationRequestInternal, iBinder2, pendingIntent, iBinder);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzgF */
    public LocationRequestUpdateData[] newArray(int i) {
        return new LocationRequestUpdateData[i];
    }
}
