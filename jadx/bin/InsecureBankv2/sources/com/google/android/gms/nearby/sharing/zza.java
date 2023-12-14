package com.google.android.gms.nearby.sharing;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<AppContentReceivedResult> {
    static void zza(AppContentReceivedResult appContentReceivedResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, appContentReceivedResult.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) appContentReceivedResult.zzxc(), i, false);
        zzb.zzc(parcel, 3, appContentReceivedResult.getStatusCode());
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzfy */
    public AppContentReceivedResult createFromParcel(Parcel parcel) {
        int zzg;
        Uri uri;
        int i;
        int i2 = 0;
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        Uri uri2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    uri = uri2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    zzg = i2;
                    break;
                case 2:
                    Uri uri3 = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, Uri.CREATOR);
                    i = i3;
                    zzg = i2;
                    uri = uri3;
                    break;
                case 3:
                    zzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    uri = uri2;
                    i = i3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    zzg = i2;
                    uri = uri2;
                    i = i3;
                    break;
            }
            i3 = i;
            uri2 = uri;
            i2 = zzg;
        }
        if (parcel.dataPosition() == zzab) {
            return new AppContentReceivedResult(i3, uri2, i2);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzin */
    public AppContentReceivedResult[] newArray(int i) {
        return new AppContentReceivedResult[i];
    }
}
