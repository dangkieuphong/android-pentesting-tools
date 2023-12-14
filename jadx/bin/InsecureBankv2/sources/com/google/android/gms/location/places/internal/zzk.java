package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;

public class zzk implements Parcelable.Creator<PlaceImpl> {
    static void zza(PlaceImpl placeImpl, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, placeImpl.getId(), false);
        zzb.zza(parcel, 2, placeImpl.zzuT(), false);
        zzb.zza(parcel, 3, (Parcelable) placeImpl.zzuV(), i, false);
        zzb.zza(parcel, 4, (Parcelable) placeImpl.getLatLng(), i, false);
        zzb.zza(parcel, 5, placeImpl.zzuO());
        zzb.zza(parcel, 6, (Parcelable) placeImpl.getViewport(), i, false);
        zzb.zza(parcel, 7, placeImpl.zzuU(), false);
        zzb.zza(parcel, 8, (Parcelable) placeImpl.getWebsiteUri(), i, false);
        zzb.zza(parcel, 9, placeImpl.zzuR());
        zzb.zza(parcel, 10, placeImpl.getRating());
        zzb.zzc(parcel, 11, placeImpl.getPriceLevel());
        zzb.zza(parcel, 12, placeImpl.zzuS());
        zzb.zza(parcel, 13, placeImpl.zzuN(), false);
        zzb.zza(parcel, 14, placeImpl.getAddress(), false);
        zzb.zza(parcel, 15, placeImpl.getPhoneNumber(), false);
        zzb.zzb(parcel, 17, placeImpl.zzuQ(), false);
        zzb.zza(parcel, 16, placeImpl.zzuP(), false);
        zzb.zzc(parcel, 1000, placeImpl.zzCY);
        zzb.zza(parcel, 19, placeImpl.getName(), false);
        zzb.zza(parcel, 18, placeImpl.zzaAE);
        zzb.zza(parcel, 20, placeImpl.getPlaceTypes(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzey */
    public PlaceImpl createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        ArrayList<Integer> arrayList = null;
        ArrayList<Integer> arrayList2 = null;
        Bundle bundle = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        ArrayList<String> arrayList3 = null;
        LatLng latLng = null;
        float f = 0.0f;
        LatLngBounds latLngBounds = null;
        String str6 = null;
        Uri uri = null;
        boolean z = false;
        float f2 = 0.0f;
        int i2 = 0;
        long j = 0;
        boolean z2 = false;
        PlaceLocalization placeLocalization = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    bundle = zza.zzq(parcel, zzaa);
                    break;
                case 3:
                    placeLocalization = (PlaceLocalization) zza.zza(parcel, zzaa, PlaceLocalization.CREATOR);
                    break;
                case 4:
                    latLng = (LatLng) zza.zza(parcel, zzaa, LatLng.CREATOR);
                    break;
                case 5:
                    f = zza.zzl(parcel, zzaa);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) zza.zza(parcel, zzaa, LatLngBounds.CREATOR);
                    break;
                case 7:
                    str6 = zza.zzo(parcel, zzaa);
                    break;
                case 8:
                    uri = (Uri) zza.zza(parcel, zzaa, Uri.CREATOR);
                    break;
                case 9:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 10:
                    f2 = zza.zzl(parcel, zzaa);
                    break;
                case 11:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 12:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 13:
                    arrayList2 = zza.zzB(parcel, zzaa);
                    break;
                case 14:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 15:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 16:
                    str5 = zza.zzo(parcel, zzaa);
                    break;
                case 17:
                    arrayList3 = zza.zzC(parcel, zzaa);
                    break;
                case 18:
                    z2 = zza.zzc(parcel, zzaa);
                    break;
                case 19:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 20:
                    arrayList = zza.zzB(parcel, zzaa);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new PlaceImpl(i, str, arrayList, arrayList2, bundle, str2, str3, str4, str5, arrayList3, latLng, f, latLngBounds, str6, uri, z, f2, i2, j, z2, placeLocalization);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzgY */
    public PlaceImpl[] newArray(int i) {
        return new PlaceImpl[i];
    }
}
