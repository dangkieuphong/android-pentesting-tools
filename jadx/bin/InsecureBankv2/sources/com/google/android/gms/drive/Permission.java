package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.media.MediaRouter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

public class Permission implements SafeParcelable {
    public static final Parcelable.Creator<Permission> CREATOR = new zzh();
    final int zzCY;
    private int zzadA;
    private String zzadB;
    private String zzadC;
    private int zzadD;
    private boolean zzadE;
    private String zzadz;

    Permission(int versionCode, String accountIdentifier, int accountType, String accountDisplayName, String photoLink, int role, boolean isLinkRequired) {
        this.zzCY = versionCode;
        this.zzadz = accountIdentifier;
        this.zzadA = accountType;
        this.zzadB = accountDisplayName;
        this.zzadC = photoLink;
        this.zzadD = role;
        this.zzadE = isLinkRequired;
    }

    public static boolean zzbZ(int i) {
        switch (i) {
            case 256:
            case 257:
            case MediaRouter.GlobalMediaRouter.CallbackHandler.MSG_ROUTE_REMOVED:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzca(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        Permission permission = (Permission) o;
        return zzt.equal(this.zzadz, permission.zzadz) && this.zzadA == permission.zzadA && this.zzadD == permission.zzadD && this.zzadE == permission.zzadE;
    }

    public int getRole() {
        if (!zzca(this.zzadD)) {
            return -1;
        }
        return this.zzadD;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzadz, Integer.valueOf(this.zzadA), Integer.valueOf(this.zzadD), Boolean.valueOf(this.zzadE));
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }

    public String zzpo() {
        if (!zzbZ(this.zzadA)) {
            return null;
        }
        return this.zzadz;
    }

    public int zzpp() {
        if (!zzbZ(this.zzadA)) {
            return -1;
        }
        return this.zzadA;
    }

    public String zzpq() {
        return this.zzadB;
    }

    public String zzpr() {
        return this.zzadC;
    }

    public boolean zzps() {
        return this.zzadE;
    }
}
