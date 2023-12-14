package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Parcelable.Creator<SharedContent> {
    static void zza(SharedContent sharedContent, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, sharedContent.getVersionCode());
        zzb.zza(parcel, 3, sharedContent.getUri(), false);
        zzb.zza(parcel, 8, (Parcelable[]) sharedContent.zzxe(), i, false);
        zzb.zza(parcel, 9, (Parcelable[]) sharedContent.zzxf(), i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzfA */
    public SharedContent createFromParcel(Parcel parcel) {
        LocalContent[] localContentArr;
        ViewableItem[] viewableItemArr;
        String str;
        int i;
        LocalContent[] localContentArr2 = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        ViewableItem[] viewableItemArr2 = null;
        String str2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    viewableItemArr = viewableItemArr2;
                    str = str2;
                    i = zza.zzg(parcel, zzaa);
                    localContentArr = localContentArr2;
                    break;
                case 2:
                case 4:
                case 5:
                case 6:
                case 7:
                default:
                    zza.zzb(parcel, zzaa);
                    localContentArr = localContentArr2;
                    viewableItemArr = viewableItemArr2;
                    str = str2;
                    i = i2;
                    break;
                case 3:
                    i = i2;
                    str = zza.zzo(parcel, zzaa);
                    localContentArr = localContentArr2;
                    viewableItemArr = viewableItemArr2;
                    break;
                case 8:
                    str = str2;
                    i = i2;
                    viewableItemArr = (ViewableItem[]) zza.zzb(parcel, zzaa, ViewableItem.CREATOR);
                    localContentArr = localContentArr2;
                    break;
                case 9:
                    localContentArr = (LocalContent[]) zza.zzb(parcel, zzaa, LocalContent.CREATOR);
                    viewableItemArr = viewableItemArr2;
                    str = str2;
                    i = i2;
                    break;
            }
            i2 = i;
            str2 = str;
            viewableItemArr2 = viewableItemArr;
            localContentArr2 = localContentArr;
        }
        if (parcel.dataPosition() == zzab) {
            return new SharedContent(i2, str2, viewableItemArr2, localContentArr2);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzip */
    public SharedContent[] newArray(int i) {
        return new SharedContent[i];
    }
}
