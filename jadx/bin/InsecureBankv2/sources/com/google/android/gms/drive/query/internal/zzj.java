package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzj implements Parcelable.Creator<InFilter> {
    static void zza(InFilter inFilter, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1000, inFilter.zzCY);
        zzb.zza(parcel, 1, (Parcelable) inFilter.zzahR, i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzbN */
    public InFilter createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzaa, MetadataBundle.CREATOR);
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
            return new InFilter(i, metadataBundle);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzdC */
    public InFilter[] newArray(int i) {
        return new InFilter[i];
    }
}
