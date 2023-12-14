package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new Parcelable.Creator<BinderWrapper>() {
        /* class com.google.android.gms.common.internal.BinderWrapper.AnonymousClass1 */

        /* renamed from: zzV */
        public BinderWrapper createFromParcel(Parcel parcel) {
            return new BinderWrapper(parcel);
        }

        /* renamed from: zzbq */
        public BinderWrapper[] newArray(int i) {
            return new BinderWrapper[i];
        }
    };
    private IBinder zzZQ;

    public BinderWrapper() {
        this.zzZQ = null;
    }

    public BinderWrapper(IBinder binder) {
        this.zzZQ = null;
        this.zzZQ = binder;
    }

    private BinderWrapper(Parcel in) {
        this.zzZQ = null;
        this.zzZQ = in.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongBinder(this.zzZQ);
    }
}
