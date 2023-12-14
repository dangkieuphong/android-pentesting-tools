package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.sharing.SharedContent;
import java.util.ArrayList;

public class zzf implements Parcelable.Creator<ProvideContentRequest> {
    static void zza(ProvideContentRequest provideContentRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, provideContentRequest.versionCode);
        zzb.zza(parcel, 2, provideContentRequest.zzaGp, false);
        zzb.zza(parcel, 3, provideContentRequest.zzxi(), false);
        zzb.zzc(parcel, 4, provideContentRequest.zzaGr, false);
        zzb.zza(parcel, 5, provideContentRequest.zzaGs);
        zzb.zza(parcel, 6, provideContentRequest.zzxa(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzfC */
    public ProvideContentRequest createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        long j = 0;
        ArrayList arrayList = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    iBinder3 = zza.zzp(parcel, zzaa);
                    break;
                case 3:
                    iBinder2 = zza.zzp(parcel, zzaa);
                    break;
                case 4:
                    arrayList = zza.zzc(parcel, zzaa, SharedContent.CREATOR);
                    break;
                case 5:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 6:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ProvideContentRequest(i, iBinder3, iBinder2, arrayList, j, iBinder);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzir */
    public ProvideContentRequest[] newArray(int i) {
        return new ProvideContentRequest[i];
    }
}
