package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;

public class zzat implements Parcelable.Creator<OnChangesResponse> {
    static void zza(OnChangesResponse onChangesResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, onChangesResponse.zzCY);
        zzb.zza(parcel, 2, (Parcelable) onChangesResponse.zzaga, i, false);
        zzb.zzc(parcel, 3, onChangesResponse.zzagb, false);
        zzb.zza(parcel, 4, (Parcelable) onChangesResponse.zzagc, i, false);
        zzb.zza(parcel, 5, onChangesResponse.zzagd);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzaY */
    public OnChangesResponse createFromParcel(Parcel parcel) {
        boolean z = false;
        ChangeSequenceNumber changeSequenceNumber = null;
        int zzab = zza.zzab(parcel);
        ArrayList arrayList = null;
        DataHolder dataHolder = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    dataHolder = (DataHolder) zza.zza(parcel, zzaa, DataHolder.CREATOR);
                    break;
                case 3:
                    arrayList = zza.zzc(parcel, zzaa, DriveId.CREATOR);
                    break;
                case 4:
                    changeSequenceNumber = (ChangeSequenceNumber) zza.zza(parcel, zzaa, ChangeSequenceNumber.CREATOR);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new OnChangesResponse(i, dataHolder, arrayList, changeSequenceNumber, z);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzcN */
    public OnChangesResponse[] newArray(int i) {
        return new OnChangesResponse[i];
    }
}
