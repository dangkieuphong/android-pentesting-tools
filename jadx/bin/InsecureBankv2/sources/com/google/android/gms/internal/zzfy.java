package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzg;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzho;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.plus.PlusShare;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public class zzfy implements Callable<zzha> {
    private static final long zzBF = TimeUnit.SECONDS.toMillis(60);
    private final Context mContext;
    private final zzho zzBG;
    private final zzm zzBH;
    private final zzbc zzBI;
    private boolean zzBJ;
    private List<String> zzBK;
    private final zzha.zza zzBs;
    private int zzBv;
    private final Object zzqt = new Object();
    private final zzan zzvA;

    public interface zza<T extends zzg.zza> {
        T zza(zzfy zzfy, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException;
    }

    /* access modifiers changed from: package-private */
    public class zzb {
        public zzdg zzBX;

        zzb() {
        }
    }

    public zzfy(Context context, zzm zzm, zzbc zzbc, zzho zzho, zzan zzan, zzha.zza zza2) {
        this.mContext = context;
        this.zzBH = zzm;
        this.zzBG = zzho;
        this.zzBI = zzbc;
        this.zzBs = zza2;
        this.zzvA = zzan;
        this.zzBJ = false;
        this.zzBv = -2;
        this.zzBK = null;
    }

    private zzg.zza zza(zzbb zzbb, zza zza2, JSONObject jSONObject) throws ExecutionException, InterruptedException, JSONException {
        if (zzfr()) {
            return null;
        }
        String[] zzc = zzc(jSONObject.getJSONObject("tracking_urls_and_actions"), "impression_tracking_urls");
        this.zzBK = zzc == null ? null : Arrays.asList(zzc);
        zzg.zza zza3 = zza2.zza(this, jSONObject);
        if (zza3 == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaz("Failed to retrieve ad assets.");
            return null;
        }
        zza3.zza(new zzg(this.mContext, this.zzBH, zzbb, this.zzvA, jSONObject, zza3));
        return zza3;
    }

    private zzha zza(zzg.zza zza2) {
        int i;
        synchronized (this.zzqt) {
            i = this.zzBv;
            if (zza2 == null && this.zzBv == -2) {
                i = 0;
            }
        }
        return new zzha(this.zzBs.zzFr.zzCm, null, this.zzBs.zzFs.zzxF, i, this.zzBs.zzFs.zzxG, this.zzBK, this.zzBs.zzFs.orientation, this.zzBs.zzFs.zzxJ, this.zzBs.zzFr.zzCp, false, null, null, null, null, null, 0, this.zzBs.zzpN, this.zzBs.zzFs.zzCJ, this.zzBs.zzFo, this.zzBs.zzFp, this.zzBs.zzFs.zzCP, this.zzBs.zzFl, i != -2 ? null : zza2, this.zzBs.zzFr.zzCC);
    }

    private zzhv<zzc> zza(JSONObject jSONObject, final boolean z, boolean z2) throws JSONException {
        final String string = z ? jSONObject.getString(PlusShare.KEY_CALL_TO_ACTION_URL) : jSONObject.optString(PlusShare.KEY_CALL_TO_ACTION_URL);
        if (!TextUtils.isEmpty(string)) {
            return z2 ? new zzht(new zzc(null, Uri.parse(string))) : this.zzBG.zza(string, new zzho.zza<zzc>() {
                /* class com.google.android.gms.internal.zzfy.AnonymousClass5 */

                /* renamed from: zzfs */
                public zzc zzft() {
                    zzfy.this.zza(2, z);
                    return null;
                }

                /* renamed from: zzg */
                public zzc zzh(InputStream inputStream) {
                    byte[] bArr;
                    try {
                        bArr = zzlg.zzk(inputStream);
                    } catch (IOException e) {
                        bArr = null;
                    }
                    if (bArr == null) {
                        zzfy.this.zza(2, z);
                        return null;
                    }
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    if (decodeByteArray != null) {
                        return new zzc(new BitmapDrawable(Resources.getSystem(), decodeByteArray), Uri.parse(string));
                    }
                    zzfy.this.zza(2, z);
                    return null;
                }
            });
        }
        zza(0, z);
        return new zzht(null);
    }

    private void zza(zzg.zza zza2, zzbb zzbb) {
        if (zza2 instanceof zzf) {
            final zzf zzf = (zzf) zza2;
            zzb zzb2 = new zzb();
            AnonymousClass3 r1 = new zzdg() {
                /* class com.google.android.gms.internal.zzfy.AnonymousClass3 */

                @Override // com.google.android.gms.internal.zzdg
                public void zza(zzid zzid, Map<String, String> map) {
                    zzfy.this.zzb((zzfy) zzf, (zzcs) map.get("asset"));
                }
            };
            zzb2.zzBX = r1;
            zzbb.zza("/nativeAdCustomClick", r1);
        }
    }

    private Integer zzb(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            return null;
        }
    }

    private JSONObject zzb(final zzbb zzbb) throws TimeoutException, JSONException {
        if (zzfr()) {
            return null;
        }
        final zzhs zzhs = new zzhs();
        final zzb zzb2 = new zzb();
        AnonymousClass1 r2 = new zzdg() {
            /* class com.google.android.gms.internal.zzfy.AnonymousClass1 */

            @Override // com.google.android.gms.internal.zzdg
            public void zza(zzid zzid, Map<String, String> map) {
                zzbb.zzb("/nativeAdPreProcess", zzb2.zzBX);
                try {
                    String str = map.get("success");
                    if (!TextUtils.isEmpty(str)) {
                        zzhs.zzf(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
                        return;
                    }
                } catch (JSONException e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzb("Malformed native JSON response.", e);
                }
                zzfy.this.zzB(0);
                zzu.zza(zzfy.this.zzfr(), "Unable to set the ad state error!");
                zzhs.zzf(null);
            }
        };
        zzb2.zzBX = r2;
        zzbb.zza("/nativeAdPreProcess", r2);
        zzbb.zza("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(this.zzBs.zzFs.zzCI));
        return (JSONObject) zzhs.get(zzBF, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzb(zzcs zzcs, String str) {
        try {
            zzcw zzq = this.zzBH.zzq(zzcs.getCustomTemplateId());
            if (zzq != null) {
                zzq.zza(zzcs, str);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call onCustomClick for asset " + str + ".", e);
        }
    }

    private String[] zzc(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    private zzbb zzfq() throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        if (zzfr()) {
            return null;
        }
        zzbb zzbb = this.zzBI.zza(this.mContext, this.zzBs.zzFr.zzpJ, (this.zzBs.zzFs.zzzG.indexOf("https") == 0 ? "https:" : "http:") + zzbz.zzur.get()).get(zzBF, TimeUnit.MILLISECONDS);
        zzbb.zza(this.zzBH, this.zzBH, this.zzBH, this.zzBH, false, null, null, null, null);
        return zzbb;
    }

    public void zzB(int i) {
        synchronized (this.zzqt) {
            this.zzBJ = true;
            this.zzBv = i;
        }
    }

    public zzhv<zzc> zza(JSONObject jSONObject, String str, boolean z, boolean z2) throws JSONException {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, z, z2);
    }

    public List<zzhv<zzc>> zza(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) throws JSONException {
        JSONArray jSONArray = z ? jSONObject.getJSONArray(str) : jSONObject.optJSONArray(str);
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() == 0) {
            zza(0, z);
            return arrayList;
        }
        int length = z3 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            arrayList.add(zza(jSONObject2, z, z2));
        }
        return arrayList;
    }

    public Future<zzc> zza(JSONObject jSONObject, String str, boolean z) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, optBoolean, z);
    }

    public void zza(int i, boolean z) {
        if (z) {
            zzB(i);
        }
    }

    /* access modifiers changed from: protected */
    public zza zzd(JSONObject jSONObject) throws JSONException, TimeoutException {
        if (zzfr()) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        boolean z = this.zzBs.zzFr.zzqb != null ? this.zzBs.zzFr.zzqb.zzvC : false;
        boolean z2 = this.zzBs.zzFr.zzqb != null ? this.zzBs.zzFr.zzqb.zzvE : false;
        if ("2".equals(string)) {
            return new zzfz(z, z2);
        }
        if ("1".equals(string)) {
            return new zzga(z, z2);
        }
        if ("3".equals(string)) {
            final String string2 = jSONObject.getString("custom_template_id");
            final zzhs zzhs = new zzhs();
            zzhl.zzGk.post(new Runnable() {
                /* class com.google.android.gms.internal.zzfy.AnonymousClass2 */

                public void run() {
                    zzhs.zzf(zzfy.this.zzBH.zzbo().get(string2));
                }
            });
            if (zzhs.get(zzBF, TimeUnit.MILLISECONDS) != null) {
                return new zzgb(z);
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaz("No handler for custom template: " + jSONObject.getString("custom_template_id"));
        } else {
            zzB(0);
        }
        return null;
    }

    public zzhv<com.google.android.gms.ads.internal.formats.zza> zze(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return new zzht(null);
        }
        final String optString = optJSONObject.optString("text");
        final int optInt = optJSONObject.optInt("text_size", -1);
        final Integer zzb2 = zzb(optJSONObject, "text_color");
        final Integer zzb3 = zzb(optJSONObject, "bg_color");
        return zzhu.zza(zza(optJSONObject, "image", false, false), new zzhu.zza<zzc, com.google.android.gms.ads.internal.formats.zza>() {
            /* class com.google.android.gms.internal.zzfy.AnonymousClass4 */

            /* renamed from: zza */
            public com.google.android.gms.ads.internal.formats.zza zze(zzc zzc) {
                com.google.android.gms.ads.internal.formats.zza zza;
                if (zzc != null) {
                    try {
                        if (!TextUtils.isEmpty(optString)) {
                            zza = new com.google.android.gms.ads.internal.formats.zza(optString, (Drawable) zze.zzn(zzc.zzdw()), zzb3, zzb2, optInt > 0 ? Integer.valueOf(optInt) : null);
                            return zza;
                        }
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzb("Could not get attribution icon", e);
                        return null;
                    }
                }
                zza = null;
                return zza;
            }
        });
    }

    /* renamed from: zzfp */
    public zzha call() {
        try {
            zzbb zzfq = zzfq();
            JSONObject zzb2 = zzb(zzfq);
            zzg.zza zza2 = zza(zzfq, zzd(zzb2), zzb2);
            zza(zza2, zzfq);
            return zza(zza2);
        } catch (InterruptedException | CancellationException | ExecutionException e) {
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Malformed native JSON response.", e2);
        } catch (TimeoutException e3) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Timeout when loading native ad.", e3);
        }
        if (!this.zzBJ) {
            zzB(0);
        }
        return zza((zzg.zza) null);
    }

    public boolean zzfr() {
        boolean z;
        synchronized (this.zzqt) {
            z = this.zzBJ;
        }
        return z;
    }
}
