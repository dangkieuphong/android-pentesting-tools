package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Parcelable.Creator<StreetViewPanoramaLink> {
    static void zza(StreetViewPanoramaLink streetViewPanoramaLink, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, streetViewPanoramaLink.getVersionCode());
        zzb.zza(parcel, 2, streetViewPanoramaLink.panoId, false);
        zzb.zza(parcel, 3, streetViewPanoramaLink.bearing);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzeU */
    public StreetViewPanoramaLink createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        float f = 0.0f;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    f = zza.zzl(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new StreetViewPanoramaLink(i, str, f);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzhu */
    public StreetViewPanoramaLink[] newArray(int i) {
        return new StreetViewPanoramaLink[i];
    }
}
