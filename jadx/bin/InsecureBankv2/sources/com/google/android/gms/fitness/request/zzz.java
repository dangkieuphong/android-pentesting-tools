package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzz implements Parcelable.Creator<SessionUnregistrationRequest> {
    static void zza(SessionUnregistrationRequest sessionUnregistrationRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) sessionUnregistrationRequest.zzrg(), i, false);
        zzb.zzc(parcel, 1000, sessionUnregistrationRequest.getVersionCode());
        zzb.zza(parcel, 2, sessionUnregistrationRequest.zzqU(), false);
        zzb.zza(parcel, 3, sessionUnregistrationRequest.getPackageName(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzcY */
    public SessionUnregistrationRequest createFromParcel(Parcel parcel) {
        String zzo;
        IBinder iBinder;
        PendingIntent pendingIntent;
        int i;
        String str = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        IBinder iBinder2 = null;
        PendingIntent pendingIntent2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = i2;
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzaa, PendingIntent.CREATOR);
                    zzo = str;
                    iBinder = iBinder2;
                    break;
                case 2:
                    pendingIntent = pendingIntent2;
                    i = i2;
                    iBinder = zza.zzp(parcel, zzaa);
                    zzo = str;
                    break;
                case 3:
                    zzo = zza.zzo(parcel, zzaa);
                    iBinder = iBinder2;
                    pendingIntent = pendingIntent2;
                    i = i2;
                    break;
                case 1000:
                    iBinder = iBinder2;
                    pendingIntent = pendingIntent2;
                    i = zza.zzg(parcel, zzaa);
                    zzo = str;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzo = str;
                    iBinder = iBinder2;
                    pendingIntent = pendingIntent2;
                    i = i2;
                    break;
            }
            i2 = i;
            pendingIntent2 = pendingIntent;
            iBinder2 = iBinder;
            str = zzo;
        }
        if (parcel.dataPosition() == zzab) {
            return new SessionUnregistrationRequest(i2, pendingIntent2, iBinder2, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzeT */
    public SessionUnregistrationRequest[] newArray(int i) {
        return new SessionUnregistrationRequest[i];
    }
}
