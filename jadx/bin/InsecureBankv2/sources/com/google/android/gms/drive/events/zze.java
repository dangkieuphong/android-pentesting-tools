package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;

public class zze implements Parcelable.Creator<CompletionEvent> {
    static void zza(CompletionEvent completionEvent, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, completionEvent.zzCY);
        zzb.zza(parcel, 2, (Parcelable) completionEvent.zzacT, i, false);
        zzb.zza(parcel, 3, completionEvent.zzOx, false);
        zzb.zza(parcel, 4, (Parcelable) completionEvent.zzadT, i, false);
        zzb.zza(parcel, 5, (Parcelable) completionEvent.zzadU, i, false);
        zzb.zza(parcel, 6, (Parcelable) completionEvent.zzadV, i, false);
        zzb.zzb(parcel, 7, completionEvent.zzadW, false);
        zzb.zzc(parcel, 8, completionEvent.zzwS);
        zzb.zza(parcel, 9, completionEvent.zzadX, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzay */
    public CompletionEvent createFromParcel(Parcel parcel) {
        int i = 0;
        IBinder iBinder = null;
        int zzab = zza.zzab(parcel);
        ArrayList<String> arrayList = null;
        MetadataBundle metadataBundle = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        String str = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzaa, DriveId.CREATOR);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) zza.zza(parcel, zzaa, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzaa, ParcelFileDescriptor.CREATOR);
                    break;
                case 6:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzaa, MetadataBundle.CREATOR);
                    break;
                case 7:
                    arrayList = zza.zzC(parcel, zzaa);
                    break;
                case 8:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 9:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new CompletionEvent(i2, driveId, str, parcelFileDescriptor2, parcelFileDescriptor, metadataBundle, arrayList, i, iBinder);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzch */
    public CompletionEvent[] newArray(int i) {
        return new CompletionEvent[i];
    }
}
