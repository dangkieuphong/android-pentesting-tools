package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Session;

public class zzx implements Parcelable.Creator<SessionStartRequest> {
    static void zza(SessionStartRequest sessionStartRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) sessionStartRequest.getSession(), i, false);
        zzb.zzc(parcel, 1000, sessionStartRequest.getVersionCode());
        zzb.zza(parcel, 2, sessionStartRequest.zzqU(), false);
        zzb.zza(parcel, 3, sessionStartRequest.getPackageName(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzcW */
    public SessionStartRequest createFromParcel(Parcel parcel) {
        String zzo;
        IBinder iBinder;
        Session session;
        int i;
        String str = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        IBinder iBinder2 = null;
        Session session2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = i2;
                    session = (Session) zza.zza(parcel, zzaa, Session.CREATOR);
                    zzo = str;
                    iBinder = iBinder2;
                    break;
                case 2:
                    session = session2;
                    i = i2;
                    iBinder = zza.zzp(parcel, zzaa);
                    zzo = str;
                    break;
                case 3:
                    zzo = zza.zzo(parcel, zzaa);
                    iBinder = iBinder2;
                    session = session2;
                    i = i2;
                    break;
                case 1000:
                    iBinder = iBinder2;
                    session = session2;
                    i = zza.zzg(parcel, zzaa);
                    zzo = str;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzo = str;
                    iBinder = iBinder2;
                    session = session2;
                    i = i2;
                    break;
            }
            i2 = i;
            session2 = session;
            iBinder2 = iBinder;
            str = zzo;
        }
        if (parcel.dataPosition() == zzab) {
            return new SessionStartRequest(i2, session2, iBinder2, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzeR */
    public SessionStartRequest[] newArray(int i) {
        return new SessionStartRequest[i];
    }
}
