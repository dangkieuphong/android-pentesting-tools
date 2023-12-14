package com.google.android.gms.maps.internal;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzz implements Parcelable.Creator<Point> {
    static void zza(Point point, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, point.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) point.zzvG(), i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzeK */
    public Point createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        Point point = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    point = (Point) zza.zza(parcel, zzaa, Point.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new Point(i, point);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzhk */
    public Point[] newArray(int i) {
        return new Point[i];
    }
}
