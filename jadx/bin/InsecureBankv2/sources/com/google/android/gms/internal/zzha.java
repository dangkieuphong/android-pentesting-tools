package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzg;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@zzgd
public class zzha {
    public final int errorCode;
    public final int orientation;
    public final String zzCC;
    public final long zzCJ;
    public final boolean zzCK;
    public final long zzCL;
    public final List<String> zzCM;
    public final String zzCP;
    public final AdRequestParcel zzCm;
    public final String zzCp;
    public final JSONObject zzFl;
    public final zzdy zzFm;
    public final AdSizeParcel zzFn;
    public final long zzFo;
    public final long zzFp;
    public final zzg.zza zzFq;
    public final List<String> zzxF;
    public final List<String> zzxG;
    public final long zzxJ;
    public final zzdx zzxZ;
    public final zzeg zzya;
    public final String zzyb;
    public final zzea zzyc;
    public final zzid zzzE;

    @zzgd
    public static final class zza {
        public final int errorCode;
        public final JSONObject zzFl;
        public final zzdy zzFm;
        public final long zzFo;
        public final long zzFp;
        public final AdRequestInfoParcel zzFr;
        public final AdResponseParcel zzFs;
        public final AdSizeParcel zzpN;

        public zza(AdRequestInfoParcel adRequestInfoParcel, AdResponseParcel adResponseParcel, zzdy zzdy, AdSizeParcel adSizeParcel, int i, long j, long j2, JSONObject jSONObject) {
            this.zzFr = adRequestInfoParcel;
            this.zzFs = adResponseParcel;
            this.zzFm = zzdy;
            this.zzpN = adSizeParcel;
            this.errorCode = i;
            this.zzFo = j;
            this.zzFp = j2;
            this.zzFl = jSONObject;
        }
    }

    public zzha(AdRequestParcel adRequestParcel, zzid zzid, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, zzdx zzdx, zzeg zzeg, String str2, zzdy zzdy, zzea zzea, long j2, AdSizeParcel adSizeParcel, long j3, long j4, long j5, String str3, JSONObject jSONObject, zzg.zza zza2, String str4) {
        this.zzCm = adRequestParcel;
        this.zzzE = zzid;
        this.zzxF = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i;
        this.zzxG = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzCM = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.orientation = i2;
        this.zzxJ = j;
        this.zzCp = str;
        this.zzCK = z;
        this.zzxZ = zzdx;
        this.zzya = zzeg;
        this.zzyb = str2;
        this.zzFm = zzdy;
        this.zzyc = zzea;
        this.zzCL = j2;
        this.zzFn = adSizeParcel;
        this.zzCJ = j3;
        this.zzFo = j4;
        this.zzFp = j5;
        this.zzCP = str3;
        this.zzFl = jSONObject;
        this.zzFq = zza2;
        this.zzCC = str4;
    }

    public zzha(zza zza2, zzid zzid, zzdx zzdx, zzeg zzeg, String str, zzea zzea, zzg.zza zza3) {
        this(zza2.zzFr.zzCm, zzid, zza2.zzFs.zzxF, zza2.errorCode, zza2.zzFs.zzxG, zza2.zzFs.zzCM, zza2.zzFs.orientation, zza2.zzFs.zzxJ, zza2.zzFr.zzCp, zza2.zzFs.zzCK, zzdx, zzeg, str, zza2.zzFm, zzea, zza2.zzFs.zzCL, zza2.zzpN, zza2.zzFs.zzCJ, zza2.zzFo, zza2.zzFp, zza2.zzFs.zzCP, zza2.zzFl, zza3, zza2.zzFr.zzCC);
    }

    public boolean zzbU() {
        if (this.zzzE == null || this.zzzE.zzgF() == null) {
            return false;
        }
        return this.zzzE.zzgF().zzbU();
    }
}
