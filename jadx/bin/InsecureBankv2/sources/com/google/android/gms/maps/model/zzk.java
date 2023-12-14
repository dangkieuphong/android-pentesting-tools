package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Parcelable.Creator<StreetViewPanoramaLocation> {
    static void zza(StreetViewPanoramaLocation streetViewPanoramaLocation, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, streetViewPanoramaLocation.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable[]) streetViewPanoramaLocation.links, i, false);
        zzb.zza(parcel, 3, (Parcelable) streetViewPanoramaLocation.position, i, false);
        zzb.zza(parcel, 4, streetViewPanoramaLocation.panoId, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzeV */
    public StreetViewPanoramaLocation createFromParcel(Parcel parcel) {
        String zzo;
        LatLng latLng;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr;
        int i;
        String str = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        LatLng latLng2 = null;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    latLng = latLng2;
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = zza.zzg(parcel, zzaa);
                    zzo = str;
                    break;
                case 2:
                    i = i2;
                    streetViewPanoramaLinkArr = (StreetViewPanoramaLink[]) zza.zzb(parcel, zzaa, StreetViewPanoramaLink.CREATOR);
                    zzo = str;
                    latLng = latLng2;
                    break;
                case 3:
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = i2;
                    latLng = (LatLng) zza.zza(parcel, zzaa, LatLng.CREATOR);
                    zzo = str;
                    break;
                case 4:
                    zzo = zza.zzo(parcel, zzaa);
                    latLng = latLng2;
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzo = str;
                    latLng = latLng2;
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = i2;
                    break;
            }
            i2 = i;
            streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
            latLng2 = latLng;
            str = zzo;
        }
        if (parcel.dataPosition() == zzab) {
            return new StreetViewPanoramaLocation(i2, streetViewPanoramaLinkArr2, latLng2, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzhv */
    public StreetViewPanoramaLocation[] newArray(int i) {
        return new StreetViewPanoramaLocation[i];
    }
}
