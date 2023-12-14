package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzf implements Parcelable.Creator<AdRequestParcel> {
    static void zza(AdRequestParcel adRequestParcel, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, adRequestParcel.versionCode);
        zzb.zza(parcel, 2, adRequestParcel.zzrX);
        zzb.zza(parcel, 3, adRequestParcel.extras, false);
        zzb.zzc(parcel, 4, adRequestParcel.zzrY);
        zzb.zzb(parcel, 5, adRequestParcel.zzrZ, false);
        zzb.zza(parcel, 6, adRequestParcel.zzsa);
        zzb.zzc(parcel, 7, adRequestParcel.zzsb);
        zzb.zza(parcel, 8, adRequestParcel.zzsc);
        zzb.zza(parcel, 9, adRequestParcel.zzsd, false);
        zzb.zza(parcel, 10, (Parcelable) adRequestParcel.zzse, i, false);
        zzb.zza(parcel, 11, (Parcelable) adRequestParcel.zzsf, i, false);
        zzb.zza(parcel, 12, adRequestParcel.zzsg, false);
        zzb.zza(parcel, 13, adRequestParcel.zzsh, false);
        zzb.zza(parcel, 14, adRequestParcel.zzsi, false);
        zzb.zzb(parcel, 15, adRequestParcel.zzsj, false);
        zzb.zza(parcel, 16, adRequestParcel.zzsk, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzb */
    public AdRequestParcel createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        ArrayList<String> arrayList = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        SearchAdRequestParcel searchAdRequestParcel = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        ArrayList<String> arrayList2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 3:
                    bundle = zza.zzq(parcel, zzaa);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    arrayList = zza.zzC(parcel, zzaa);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 7:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 8:
                    z2 = zza.zzc(parcel, zzaa);
                    break;
                case 9:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 10:
                    searchAdRequestParcel = (SearchAdRequestParcel) zza.zza(parcel, zzaa, SearchAdRequestParcel.CREATOR);
                    break;
                case 11:
                    location = (Location) zza.zza(parcel, zzaa, Location.CREATOR);
                    break;
                case 12:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 13:
                    bundle2 = zza.zzq(parcel, zzaa);
                    break;
                case 14:
                    bundle3 = zza.zzq(parcel, zzaa);
                    break;
                case 15:
                    arrayList2 = zza.zzC(parcel, zzaa);
                    break;
                case 16:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new AdRequestParcel(i, j, bundle, i2, arrayList, z, i3, z2, str, searchAdRequestParcel, location, str2, bundle2, bundle3, arrayList2, str3);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzk */
    public AdRequestParcel[] newArray(int i) {
        return new AdRequestParcel[i];
    }
}
