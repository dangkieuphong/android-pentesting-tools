package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzf implements Parcelable.Creator<AdRequestInfoParcel> {
    static void zza(AdRequestInfoParcel adRequestInfoParcel, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, adRequestInfoParcel.versionCode);
        zzb.zza(parcel, 2, adRequestInfoParcel.zzCl, false);
        zzb.zza(parcel, 3, (Parcelable) adRequestInfoParcel.zzCm, i, false);
        zzb.zza(parcel, 4, (Parcelable) adRequestInfoParcel.zzpN, i, false);
        zzb.zza(parcel, 5, adRequestInfoParcel.zzpG, false);
        zzb.zza(parcel, 6, (Parcelable) adRequestInfoParcel.applicationInfo, i, false);
        zzb.zza(parcel, 7, (Parcelable) adRequestInfoParcel.zzCn, i, false);
        zzb.zza(parcel, 8, adRequestInfoParcel.zzCo, false);
        zzb.zza(parcel, 9, adRequestInfoParcel.zzCp, false);
        zzb.zza(parcel, 10, adRequestInfoParcel.zzCq, false);
        zzb.zza(parcel, 11, (Parcelable) adRequestInfoParcel.zzpJ, i, false);
        zzb.zza(parcel, 12, adRequestInfoParcel.zzCr, false);
        zzb.zzc(parcel, 13, adRequestInfoParcel.zzCs);
        zzb.zzb(parcel, 14, adRequestInfoParcel.zzqd, false);
        zzb.zza(parcel, 15, adRequestInfoParcel.zzCt, false);
        zzb.zza(parcel, 17, (Parcelable) adRequestInfoParcel.zzCv, i, false);
        zzb.zza(parcel, 16, adRequestInfoParcel.zzCu);
        zzb.zzc(parcel, 19, adRequestInfoParcel.zzCx);
        zzb.zzc(parcel, 18, adRequestInfoParcel.zzCw);
        zzb.zza(parcel, 21, adRequestInfoParcel.zzCz, false);
        zzb.zza(parcel, 20, adRequestInfoParcel.zzCy);
        zzb.zzc(parcel, 23, adRequestInfoParcel.zzCB);
        zzb.zza(parcel, 22, adRequestInfoParcel.zzCA);
        zzb.zza(parcel, 25, adRequestInfoParcel.zzCD);
        zzb.zza(parcel, 24, adRequestInfoParcel.zzCC, false);
        zzb.zzb(parcel, 27, adRequestInfoParcel.zzCF, false);
        zzb.zza(parcel, 26, adRequestInfoParcel.zzCE, false);
        zzb.zza(parcel, 29, (Parcelable) adRequestInfoParcel.zzqb, i, false);
        zzb.zza(parcel, 28, adRequestInfoParcel.zzpF, false);
        zzb.zzb(parcel, 30, adRequestInfoParcel.zzCG, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzC */
    public AdRequestInfoParcel[] newArray(int i) {
        return new AdRequestInfoParcel[i];
    }

    /* renamed from: zzj */
    public AdRequestInfoParcel createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        Bundle bundle = null;
        AdRequestParcel adRequestParcel = null;
        AdSizeParcel adSizeParcel = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        VersionInfoParcel versionInfoParcel = null;
        Bundle bundle2 = null;
        int i2 = 0;
        ArrayList<String> arrayList = null;
        Bundle bundle3 = null;
        boolean z = false;
        Messenger messenger = null;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        String str5 = null;
        boolean z2 = false;
        int i5 = 0;
        String str6 = null;
        long j = 0;
        String str7 = null;
        ArrayList<String> arrayList2 = null;
        String str8 = null;
        NativeAdOptionsParcel nativeAdOptionsParcel = null;
        ArrayList<String> arrayList3 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    bundle = zza.zzq(parcel, zzaa);
                    break;
                case 3:
                    adRequestParcel = (AdRequestParcel) zza.zza(parcel, zzaa, AdRequestParcel.CREATOR);
                    break;
                case 4:
                    adSizeParcel = (AdSizeParcel) zza.zza(parcel, zzaa, AdSizeParcel.CREATOR);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) zza.zza(parcel, zzaa, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) zza.zza(parcel, zzaa, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 9:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 10:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 11:
                    versionInfoParcel = (VersionInfoParcel) zza.zza(parcel, zzaa, VersionInfoParcel.CREATOR);
                    break;
                case 12:
                    bundle2 = zza.zzq(parcel, zzaa);
                    break;
                case 13:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 14:
                    arrayList = zza.zzC(parcel, zzaa);
                    break;
                case 15:
                    bundle3 = zza.zzq(parcel, zzaa);
                    break;
                case 16:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 17:
                    messenger = (Messenger) zza.zza(parcel, zzaa, Messenger.CREATOR);
                    break;
                case 18:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 19:
                    i4 = zza.zzg(parcel, zzaa);
                    break;
                case 20:
                    f = zza.zzl(parcel, zzaa);
                    break;
                case 21:
                    str5 = zza.zzo(parcel, zzaa);
                    break;
                case 22:
                    z2 = zza.zzc(parcel, zzaa);
                    break;
                case 23:
                    i5 = zza.zzg(parcel, zzaa);
                    break;
                case 24:
                    str6 = zza.zzo(parcel, zzaa);
                    break;
                case 25:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 26:
                    str7 = zza.zzo(parcel, zzaa);
                    break;
                case 27:
                    arrayList2 = zza.zzC(parcel, zzaa);
                    break;
                case 28:
                    str8 = zza.zzo(parcel, zzaa);
                    break;
                case 29:
                    nativeAdOptionsParcel = (NativeAdOptionsParcel) zza.zza(parcel, zzaa, NativeAdOptionsParcel.CREATOR);
                    break;
                case 30:
                    arrayList3 = zza.zzC(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new AdRequestInfoParcel(i, bundle, adRequestParcel, adSizeParcel, str, applicationInfo, packageInfo, str2, str3, str4, versionInfoParcel, bundle2, i2, arrayList, bundle3, z, messenger, i3, i4, f, str5, z2, i5, str6, j, str7, arrayList2, str8, nativeAdOptionsParcel, arrayList3);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }
}
