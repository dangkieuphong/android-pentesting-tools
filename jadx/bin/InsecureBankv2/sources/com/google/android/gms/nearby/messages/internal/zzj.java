package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

public class zzj implements Parcelable.Creator<SubscribeRequest> {
    static void zza(SubscribeRequest subscribeRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, subscribeRequest.zzCY);
        zzb.zza(parcel, 2, subscribeRequest.zzxb(), false);
        zzb.zza(parcel, 3, (Parcelable) subscribeRequest.zzaGc, i, false);
        zzb.zza(parcel, 4, subscribeRequest.zzxa(), false);
        zzb.zza(parcel, 5, (Parcelable) subscribeRequest.zzaGg, i, false);
        zzb.zza(parcel, 6, (Parcelable) subscribeRequest.zzaGh, i, false);
        zzb.zzc(parcel, 7, subscribeRequest.zzaGi);
        zzb.zza(parcel, 8, subscribeRequest.zzayp, false);
        zzb.zza(parcel, 9, subscribeRequest.zzaGe, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzfv */
    public SubscribeRequest createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzab = zza.zzab(parcel);
        String str2 = null;
        PendingIntent pendingIntent = null;
        MessageFilter messageFilter = null;
        IBinder iBinder = null;
        Strategy strategy = null;
        IBinder iBinder2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    iBinder2 = zza.zzp(parcel, zzaa);
                    break;
                case 3:
                    strategy = (Strategy) zza.zza(parcel, zzaa, Strategy.CREATOR);
                    break;
                case 4:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 5:
                    messageFilter = (MessageFilter) zza.zza(parcel, zzaa, MessageFilter.CREATOR);
                    break;
                case 6:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzaa, PendingIntent.CREATOR);
                    break;
                case 7:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 8:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 9:
                    str = zza.zzo(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new SubscribeRequest(i2, iBinder2, strategy, iBinder, messageFilter, pendingIntent, i, str2, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzik */
    public SubscribeRequest[] newArray(int i) {
        return new SubscribeRequest[i];
    }
}
