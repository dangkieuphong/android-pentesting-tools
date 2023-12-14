package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzd<T extends SafeParcelable> extends AbstractDataBuffer<T> {
    private static final String[] zzYu = {"data"};
    private final Parcelable.Creator<T> zzYv;

    public zzd(DataHolder dataHolder, Parcelable.Creator<T> creator) {
        super(dataHolder);
        this.zzYv = creator;
    }

    /* renamed from: zzbg */
    public T get(int i) {
        byte[] zzg = this.zzWu.zzg("data", i, this.zzWu.zzbh(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(zzg, 0, zzg.length);
        obtain.setDataPosition(0);
        T createFromParcel = this.zzYv.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }
}
