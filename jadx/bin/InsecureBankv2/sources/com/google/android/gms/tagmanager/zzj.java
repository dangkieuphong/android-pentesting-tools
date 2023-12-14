package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* access modifiers changed from: package-private */
public class zzj extends zzdd {
    private static final String ID = zzad.ARBITRARY_PIXEL.toString();
    private static final String URL = zzae.URL.toString();
    private static final String zzaKr = zzae.ADDITIONAL_PARAMS.toString();
    private static final String zzaKs = zzae.UNREPEATABLE.toString();
    static final String zzaKt = ("gtm_" + ID + "_unrepeatable");
    private static final Set<String> zzaKu = new HashSet();
    private final Context mContext;
    private final zza zzaKv;

    public interface zza {
        zzar zzyi();
    }

    public zzj(final Context context) {
        this(context, new zza() {
            /* class com.google.android.gms.tagmanager.zzj.AnonymousClass1 */

            @Override // com.google.android.gms.tagmanager.zzj.zza
            public zzar zzyi() {
                return zzz.zzaF(context);
            }
        });
    }

    zzj(Context context, zza zza2) {
        super(ID, URL);
        this.zzaKv = zza2;
        this.mContext = context;
    }

    private synchronized boolean zzeb(String str) {
        boolean z = true;
        synchronized (this) {
            if (!zzed(str)) {
                if (zzec(str)) {
                    zzaKu.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    @Override // com.google.android.gms.tagmanager.zzdd
    public void zzG(Map<String, zzag.zza> map) {
        String zzg = map.get(zzaKs) != null ? zzdf.zzg(map.get(zzaKs)) : null;
        if (zzg == null || !zzeb(zzg)) {
            Uri.Builder buildUpon = Uri.parse(zzdf.zzg(map.get(URL))).buildUpon();
            zzag.zza zza2 = map.get(zzaKr);
            if (zza2 != null) {
                Object zzl = zzdf.zzl(zza2);
                if (!(zzl instanceof List)) {
                    zzbg.zzaz("ArbitraryPixel: additional params not a list: not sending partial hit: " + buildUpon.build().toString());
                    return;
                }
                for (Object obj : (List) zzl) {
                    if (!(obj instanceof Map)) {
                        zzbg.zzaz("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + buildUpon.build().toString());
                        return;
                    }
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                    }
                }
            }
            String uri = buildUpon.build().toString();
            this.zzaKv.zzyi().zzes(uri);
            zzbg.zzaB("ArbitraryPixel: url = " + uri);
            if (zzg != null) {
                synchronized (zzj.class) {
                    zzaKu.add(zzg);
                    zzcv.zza(this.mContext, zzaKt, zzg, "true");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzec(String str) {
        return this.mContext.getSharedPreferences(zzaKt, 0).contains(str);
    }

    /* access modifiers changed from: package-private */
    public boolean zzed(String str) {
        return zzaKu.contains(str);
    }
}
