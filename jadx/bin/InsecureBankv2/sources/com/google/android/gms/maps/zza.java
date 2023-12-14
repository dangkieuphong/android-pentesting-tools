package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.maps.model.CameraPosition;

public class zza implements Parcelable.Creator<GoogleMapOptions> {
    static void zza(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, googleMapOptions.getVersionCode());
        zzb.zza(parcel, 2, googleMapOptions.zzvj());
        zzb.zza(parcel, 3, googleMapOptions.zzvk());
        zzb.zzc(parcel, 4, googleMapOptions.getMapType());
        zzb.zza(parcel, 5, (Parcelable) googleMapOptions.getCamera(), i, false);
        zzb.zza(parcel, 6, googleMapOptions.zzvl());
        zzb.zza(parcel, 7, googleMapOptions.zzvm());
        zzb.zza(parcel, 8, googleMapOptions.zzvn());
        zzb.zza(parcel, 9, googleMapOptions.zzvo());
        zzb.zza(parcel, 10, googleMapOptions.zzvp());
        zzb.zza(parcel, 11, googleMapOptions.zzvq());
        zzb.zza(parcel, 12, googleMapOptions.zzvr());
        zzb.zza(parcel, 14, googleMapOptions.zzvs());
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzeI */
    public GoogleMapOptions createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        byte b = -1;
        byte b2 = -1;
        int i2 = 0;
        CameraPosition cameraPosition = null;
        byte b3 = -1;
        byte b4 = -1;
        byte b5 = -1;
        byte b6 = -1;
        byte b7 = -1;
        byte b8 = -1;
        byte b9 = -1;
        byte b10 = -1;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    b = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzaa);
                    break;
                case 3:
                    b2 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzaa);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, CameraPosition.CREATOR);
                    break;
                case 6:
                    b3 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzaa);
                    break;
                case 7:
                    b4 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzaa);
                    break;
                case 8:
                    b5 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzaa);
                    break;
                case 9:
                    b6 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzaa);
                    break;
                case 10:
                    b7 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzaa);
                    break;
                case 11:
                    b8 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzaa);
                    break;
                case 12:
                    b9 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzaa);
                    break;
                case 13:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
                case 14:
                    b10 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GoogleMapOptions(i, b, b2, i2, cameraPosition, b3, b4, b5, b6, b7, b8, b9, b10);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzhi */
    public GoogleMapOptions[] newArray(int i) {
        return new GoogleMapOptions[i];
    }
}
