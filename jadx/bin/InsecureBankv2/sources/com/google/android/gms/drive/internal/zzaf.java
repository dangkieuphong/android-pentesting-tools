package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import java.util.ArrayList;

public class zzaf implements Parcelable.Creator<GetChangesRequest> {
    static void zza(GetChangesRequest getChangesRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getChangesRequest.zzCY);
        zzb.zza(parcel, 2, (Parcelable) getChangesRequest.zzafJ, i, false);
        zzb.zzc(parcel, 3, getChangesRequest.zzafK);
        zzb.zzc(parcel, 4, getChangesRequest.zzadR, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzaR */
    public GetChangesRequest createFromParcel(Parcel parcel) {
        ArrayList zzc;
        int i;
        ChangeSequenceNumber changeSequenceNumber;
        int i2;
        ArrayList arrayList = null;
        int i3 = 0;
        int zzab = zza.zzab(parcel);
        ChangeSequenceNumber changeSequenceNumber2 = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = i3;
                    changeSequenceNumber = changeSequenceNumber2;
                    i2 = zza.zzg(parcel, zzaa);
                    zzc = arrayList;
                    break;
                case 2:
                    i2 = i4;
                    changeSequenceNumber = (ChangeSequenceNumber) zza.zza(parcel, zzaa, ChangeSequenceNumber.CREATOR);
                    zzc = arrayList;
                    i = i3;
                    break;
                case 3:
                    changeSequenceNumber = changeSequenceNumber2;
                    i2 = i4;
                    i = zza.zzg(parcel, zzaa);
                    zzc = arrayList;
                    break;
                case 4:
                    zzc = zza.zzc(parcel, zzaa, DriveSpace.CREATOR);
                    i = i3;
                    changeSequenceNumber = changeSequenceNumber2;
                    i2 = i4;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzc = arrayList;
                    i = i3;
                    changeSequenceNumber = changeSequenceNumber2;
                    i2 = i4;
                    break;
            }
            i4 = i2;
            changeSequenceNumber2 = changeSequenceNumber;
            i3 = i;
            arrayList = zzc;
        }
        if (parcel.dataPosition() == zzab) {
            return new GetChangesRequest(i4, changeSequenceNumber2, i3, arrayList);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzcG */
    public GetChangesRequest[] newArray(int i) {
        return new GetChangesRequest[i];
    }
}
