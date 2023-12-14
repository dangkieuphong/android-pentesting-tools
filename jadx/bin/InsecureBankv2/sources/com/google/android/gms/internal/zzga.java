package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.internal.zzfy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public class zzga implements zzfy.zza<zze> {
    private final boolean zzBY;
    private final boolean zzBZ;

    public zzga(boolean z, boolean z2) {
        this.zzBY = z;
        this.zzBZ = z2;
    }

    /* renamed from: zzc */
    public zze zza(zzfy zzfy, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        List<zzhv<zzc>> zza = zzfy.zza(jSONObject, "images", true, this.zzBY, this.zzBZ);
        zzhv<zzc> zza2 = zzfy.zza(jSONObject, "secondary_image", false, this.zzBY);
        zzhv<zza> zze = zzfy.zze(jSONObject);
        ArrayList arrayList = new ArrayList();
        for (zzhv<zzc> zzhv : zza) {
            arrayList.add(zzhv.get());
        }
        return new zze(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), (zzc) zza2.get(), jSONObject.getString("call_to_action"), jSONObject.getString("advertiser"), (zza) zze.get());
    }
}
