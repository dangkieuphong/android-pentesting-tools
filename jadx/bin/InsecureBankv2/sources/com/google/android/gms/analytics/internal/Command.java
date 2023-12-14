package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;

public class Command implements Parcelable {
    @Deprecated
    public static final Parcelable.Creator<Command> CREATOR = new Parcelable.Creator<Command>() {
        /* class com.google.android.gms.analytics.internal.Command.AnonymousClass1 */

        @Deprecated
        /* renamed from: zzaa */
        public Command[] newArray(int i) {
            return new Command[i];
        }

        @Deprecated
        /* renamed from: zzq */
        public Command createFromParcel(Parcel parcel) {
            return new Command(parcel);
        }
    };
    private String mValue;
    private String zzKI;
    private String zzKJ;

    @Deprecated
    public Command() {
    }

    @Deprecated
    Command(Parcel in) {
        readFromParcel(in);
    }

    @Deprecated
    private void readFromParcel(Parcel in) {
        this.zzKI = in.readString();
        this.zzKJ = in.readString();
        this.mValue = in.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzKI;
    }

    public String getValue() {
        return this.mValue;
    }

    @Deprecated
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.zzKI);
        out.writeString(this.zzKJ);
        out.writeString(this.mValue);
    }
}
