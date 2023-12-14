package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;

public class OnListEntriesResponse extends WriteAwareParcelable implements SafeParcelable {
    public static final Parcelable.Creator<OnListEntriesResponse> CREATOR = new zzbb();
    final int zzCY;
    final boolean zzaeL;
    final DataHolder zzagp;

    OnListEntriesResponse(int versionCode, DataHolder entries, boolean moreEntriesMayExist) {
        this.zzCY = versionCode;
        this.zzagp = entries;
        this.zzaeL = moreEntriesMayExist;
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.WriteAwareParcelable
    public void zzI(Parcel parcel, int i) {
        zzbb.zza(this, parcel, i);
    }

    public DataHolder zzpP() {
        return this.zzagp;
    }

    public boolean zzpQ() {
        return this.zzaeL;
    }
}
