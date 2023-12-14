package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzw implements Parcelable.Creator<SessionRegistrationRequest> {
    static void zza(SessionRegistrationRequest sessionRegistrationRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) sessionRegistrationRequest.zzrg(), i, false);
        zzb.zzc(parcel, 1000, sessionRegistrationRequest.getVersionCode());
        zzb.zza(parcel, 2, sessionRegistrationRequest.zzqU(), false);
        zzb.zza(parcel, 3, sessionRegistrationRequest.getPackageName(), false);
        zzb.zzc(parcel, 4, sessionRegistrationRequest.zzrp());
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzcV */
    public SessionRegistrationRequest createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzab = zza.zzab(parcel);
        IBinder iBinder = null;
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzaa, PendingIntent.CREATOR);
                    break;
                case 2:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new SessionRegistrationRequest(i2, pendingIntent, iBinder, str, i);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzeQ */
    public SessionRegistrationRequest[] newArray(int i) {
        return new SessionRegistrationRequest[i];
    }
}
