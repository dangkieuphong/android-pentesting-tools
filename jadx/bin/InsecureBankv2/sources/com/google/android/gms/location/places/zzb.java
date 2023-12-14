package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class zzb implements Parcelable.Creator<AddPlaceRequest> {
    static void zza(AddPlaceRequest addPlaceRequest, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, addPlaceRequest.getName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, addPlaceRequest.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) addPlaceRequest.getLatLng(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, addPlaceRequest.getAddress(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, addPlaceRequest.getPlaceTypes(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, addPlaceRequest.getPhoneNumber(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable) addPlaceRequest.getWebsiteUri(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzen */
    public AddPlaceRequest createFromParcel(Parcel parcel) {
        Uri uri = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        ArrayList<Integer> arrayList = null;
        String str2 = null;
        LatLng latLng = null;
        String str3 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    latLng = (LatLng) zza.zza(parcel, zzaa, LatLng.CREATOR);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    arrayList = zza.zzB(parcel, zzaa);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    uri = (Uri) zza.zza(parcel, zzaa, Uri.CREATOR);
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
            return new AddPlaceRequest(i, str3, latLng, str2, arrayList, str, uri);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzgJ */
    public AddPlaceRequest[] newArray(int i) {
        return new AddPlaceRequest[i];
    }
}
