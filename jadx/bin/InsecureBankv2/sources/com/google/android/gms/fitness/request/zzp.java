package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;

public class zzp implements Parcelable.Creator<ListSubscriptionsRequest> {
    static void zza(ListSubscriptionsRequest listSubscriptionsRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) listSubscriptionsRequest.getDataType(), i, false);
        zzb.zzc(parcel, 1000, listSubscriptionsRequest.getVersionCode());
        zzb.zza(parcel, 2, listSubscriptionsRequest.zzqU(), false);
        zzb.zza(parcel, 3, listSubscriptionsRequest.getPackageName(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzcO */
    public ListSubscriptionsRequest createFromParcel(Parcel parcel) {
        String zzo;
        IBinder iBinder;
        DataType dataType;
        int i;
        String str = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        IBinder iBinder2 = null;
        DataType dataType2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = i2;
                    dataType = (DataType) zza.zza(parcel, zzaa, DataType.CREATOR);
                    zzo = str;
                    iBinder = iBinder2;
                    break;
                case 2:
                    dataType = dataType2;
                    i = i2;
                    iBinder = zza.zzp(parcel, zzaa);
                    zzo = str;
                    break;
                case 3:
                    zzo = zza.zzo(parcel, zzaa);
                    iBinder = iBinder2;
                    dataType = dataType2;
                    i = i2;
                    break;
                case 1000:
                    iBinder = iBinder2;
                    dataType = dataType2;
                    i = zza.zzg(parcel, zzaa);
                    zzo = str;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzo = str;
                    iBinder = iBinder2;
                    dataType = dataType2;
                    i = i2;
                    break;
            }
            i2 = i;
            dataType2 = dataType;
            iBinder2 = iBinder;
            str = zzo;
        }
        if (parcel.dataPosition() == zzab) {
            return new ListSubscriptionsRequest(i2, dataType2, iBinder2, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzeI */
    public ListSubscriptionsRequest[] newArray(int i) {
        return new ListSubscriptionsRequest[i];
    }
}
