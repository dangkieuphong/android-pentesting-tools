package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GetBuyFlowInitializationTokenRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetBuyFlowInitializationTokenRequest> CREATOR = new zzb();
    private final int zzCY;
    byte[] zzaRJ;

    GetBuyFlowInitializationTokenRequest() {
        this(1, null);
    }

    GetBuyFlowInitializationTokenRequest(int versionCode, byte[] encryptedBuyFlowParameters) {
        this.zzCY = versionCode;
        this.zzaRJ = encryptedBuyFlowParameters;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
