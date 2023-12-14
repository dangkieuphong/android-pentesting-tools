package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc implements Parcelable.Creator<ParcelableEvent> {
    static void zza(ParcelableEvent parcelableEvent, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, parcelableEvent.zzCY);
        zzb.zza(parcel, 2, parcelableEvent.zzFE, false);
        zzb.zza(parcel, 3, parcelableEvent.zzEO, false);
        zzb.zzb(parcel, 4, parcelableEvent.zzaiC, false);
        zzb.zza(parcel, 5, parcelableEvent.zzaiD);
        zzb.zza(parcel, 6, parcelableEvent.zzaiw, false);
        zzb.zza(parcel, 7, parcelableEvent.zzaiG, false);
        zzb.zza(parcel, 8, (Parcelable) parcelableEvent.zzaiH, i, false);
        zzb.zza(parcel, 9, (Parcelable) parcelableEvent.zzaiI, i, false);
        zzb.zza(parcel, 10, (Parcelable) parcelableEvent.zzaiJ, i, false);
        zzb.zza(parcel, 11, (Parcelable) parcelableEvent.zzaiK, i, false);
        zzb.zza(parcel, 12, (Parcelable) parcelableEvent.zzaiL, i, false);
        zzb.zza(parcel, 13, (Parcelable) parcelableEvent.zzaiM, i, false);
        zzb.zza(parcel, 14, (Parcelable) parcelableEvent.zzaiN, i, false);
        zzb.zza(parcel, 15, (Parcelable) parcelableEvent.zzaiO, i, false);
        zzb.zza(parcel, 17, parcelableEvent.zzaiF);
        zzb.zza(parcel, 16, parcelableEvent.zzaiE);
        zzb.zza(parcel, 18, (Parcelable) parcelableEvent.zzaiP, i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzbZ */
    public ParcelableEvent createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str3 = null;
        String str4 = null;
        TextInsertedDetails textInsertedDetails = null;
        TextDeletedDetails textDeletedDetails = null;
        ValuesAddedDetails valuesAddedDetails = null;
        ValuesRemovedDetails valuesRemovedDetails = null;
        ValuesSetDetails valuesSetDetails = null;
        ValueChangedDetails valueChangedDetails = null;
        ReferenceShiftedDetails referenceShiftedDetails = null;
        ObjectChangedDetails objectChangedDetails = null;
        FieldChangedDetails fieldChangedDetails = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    arrayList = zza.zzC(parcel, zzaa);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 6:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 7:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 8:
                    textInsertedDetails = (TextInsertedDetails) zza.zza(parcel, zzaa, TextInsertedDetails.CREATOR);
                    break;
                case 9:
                    textDeletedDetails = (TextDeletedDetails) zza.zza(parcel, zzaa, TextDeletedDetails.CREATOR);
                    break;
                case 10:
                    valuesAddedDetails = (ValuesAddedDetails) zza.zza(parcel, zzaa, ValuesAddedDetails.CREATOR);
                    break;
                case 11:
                    valuesRemovedDetails = (ValuesRemovedDetails) zza.zza(parcel, zzaa, ValuesRemovedDetails.CREATOR);
                    break;
                case 12:
                    valuesSetDetails = (ValuesSetDetails) zza.zza(parcel, zzaa, ValuesSetDetails.CREATOR);
                    break;
                case 13:
                    valueChangedDetails = (ValueChangedDetails) zza.zza(parcel, zzaa, ValueChangedDetails.CREATOR);
                    break;
                case 14:
                    referenceShiftedDetails = (ReferenceShiftedDetails) zza.zza(parcel, zzaa, ReferenceShiftedDetails.CREATOR);
                    break;
                case 15:
                    objectChangedDetails = (ObjectChangedDetails) zza.zza(parcel, zzaa, ObjectChangedDetails.CREATOR);
                    break;
                case 16:
                    z2 = zza.zzc(parcel, zzaa);
                    break;
                case 17:
                    z3 = zza.zzc(parcel, zzaa);
                    break;
                case 18:
                    fieldChangedDetails = (FieldChangedDetails) zza.zza(parcel, zzaa, FieldChangedDetails.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ParcelableEvent(i, str, str2, arrayList, z, z2, z3, str3, str4, textInsertedDetails, textDeletedDetails, valuesAddedDetails, valuesRemovedDetails, valuesSetDetails, valueChangedDetails, referenceShiftedDetails, objectChangedDetails, fieldChangedDetails);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzdP */
    public ParcelableEvent[] newArray(int i) {
        return new ParcelableEvent[i];
    }
}
