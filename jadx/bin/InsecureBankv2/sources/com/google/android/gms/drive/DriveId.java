package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.internal.zzar;
import com.google.android.gms.drive.internal.zzas;
import com.google.android.gms.drive.internal.zzx;
import com.google.android.gms.internal.zzrm;
import com.google.android.gms.internal.zzrn;

public class DriveId implements SafeParcelable {
    public static final Parcelable.Creator<DriveId> CREATOR = new zzd();
    public static final int RESOURCE_TYPE_FILE = 0;
    public static final int RESOURCE_TYPE_FOLDER = 1;
    public static final int RESOURCE_TYPE_UNKNOWN = -1;
    final int zzCY;
    final long zzacO;
    private volatile String zzacQ;
    final String zzadd;
    final long zzade;
    final int zzadf;
    private volatile String zzadg;

    DriveId(int versionCode, String resourceId, long sqlId, long databaseInstanceId, int resourceType) {
        boolean z = false;
        this.zzacQ = null;
        this.zzadg = null;
        this.zzCY = versionCode;
        this.zzadd = resourceId;
        zzu.zzV(!"".equals(resourceId));
        zzu.zzV((resourceId == null && sqlId == -1) ? z : true);
        this.zzade = sqlId;
        this.zzacO = databaseInstanceId;
        this.zzadf = resourceType;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DriveId(String resourceId, long sqlId, long databaseInstanceId, int resourceType) {
        this(1, (resourceId == null || !resourceId.startsWith("generated-android-")) ? resourceId : null, sqlId, databaseInstanceId, resourceType);
    }

    public static DriveId decodeFromString(String s) {
        zzu.zzb(s.startsWith("DriveId:"), "Invalid DriveId: " + s);
        return zzk(Base64.decode(s.substring("DriveId:".length()), 10));
    }

    public static DriveId zzcs(String str) {
        zzu.zzu(str);
        return new DriveId(str, -1, -1, -1);
    }

    static DriveId zzk(byte[] bArr) {
        try {
            zzar zzl = zzar.zzl(bArr);
            return new DriveId(zzl.versionCode, "".equals(zzl.zzafX) ? null : zzl.zzafX, zzl.zzafY, zzl.zzafV, zzl.zzafZ);
        } catch (zzrm e) {
            throw new IllegalArgumentException();
        }
    }

    private byte[] zzph() {
        zzas zzas = new zzas();
        zzas.zzafY = this.zzade;
        zzas.zzafV = this.zzacO;
        return zzrn.zzf(zzas);
    }

    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.zzacQ == null) {
            this.zzacQ = "DriveId:" + Base64.encodeToString(zzpb(), 10);
        }
        return this.zzacQ;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (!(obj instanceof DriveId)) {
            return false;
        }
        DriveId driveId = (DriveId) obj;
        if (driveId.zzacO != this.zzacO) {
            zzx.zzu("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
            return false;
        } else if (driveId.zzade == -1 && this.zzade == -1) {
            return driveId.zzadd.equals(this.zzadd);
        } else {
            if (this.zzadd == null || driveId.zzadd == null) {
                if (driveId.zzade != this.zzade) {
                    z = false;
                }
                return z;
            } else if (driveId.zzade != this.zzade) {
                return false;
            } else {
                if (driveId.zzadd.equals(this.zzadd)) {
                    return true;
                }
                zzx.zzu("DriveId", "Unexpected unequal resourceId for same DriveId object.");
                return false;
            }
        }
    }

    public String getResourceId() {
        return this.zzadd;
    }

    public int getResourceType() {
        return this.zzadf;
    }

    public int hashCode() {
        return this.zzade == -1 ? this.zzadd.hashCode() : (String.valueOf(this.zzacO) + String.valueOf(this.zzade)).hashCode();
    }

    public final String toInvariantString() {
        if (this.zzadg == null) {
            this.zzadg = Base64.encodeToString(zzph(), 10);
        }
        return this.zzadg;
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }

    /* access modifiers changed from: package-private */
    public final byte[] zzpb() {
        zzar zzar = new zzar();
        zzar.versionCode = this.zzCY;
        zzar.zzafX = this.zzadd == null ? "" : this.zzadd;
        zzar.zzafY = this.zzade;
        zzar.zzafV = this.zzacO;
        zzar.zzafZ = this.zzadf;
        return zzrn.zzf(zzar);
    }
}
