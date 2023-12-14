package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Parcelable.Creator<DocumentSection> {
    static void zza(DocumentSection documentSection, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, documentSection.zzNe, false);
        zzb.zzc(parcel, 1000, documentSection.zzCY);
        zzb.zza(parcel, 3, (Parcelable) documentSection.zzNf, i, false);
        zzb.zzc(parcel, 4, documentSection.zzNg);
        zzb.zza(parcel, 5, documentSection.zzNh, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzae */
    public DocumentSection[] newArray(int i) {
        return new DocumentSection[i];
    }

    /* renamed from: zzt */
    public DocumentSection createFromParcel(Parcel parcel) {
        byte[] bArr = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        int i2 = -1;
        RegisterSectionInfo registerSectionInfo = null;
        String str = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    registerSectionInfo = (RegisterSectionInfo) zza.zza(parcel, zzaa, RegisterSectionInfo.CREATOR);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    bArr = zza.zzr(parcel, zzaa);
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
            return new DocumentSection(i, str, registerSectionInfo, i2, bArr);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }
}
