package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.zza;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzbe;
import com.google.android.gms.internal.zzbr;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzdg;
import com.google.android.gms.internal.zzdh;
import com.google.android.gms.internal.zzdl;
import com.google.android.gms.internal.zzdt;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhh;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public class zzl extends zzhh {
    static final long zzDf = TimeUnit.SECONDS.toMillis(10);
    private static boolean zzDg = false;
    private static zzdt zzDh = null;
    private static zzdh zzDi = null;
    private static zzdl zzDj = null;
    private static zzdg zzDk = null;
    private static final Object zzoW = new Object();
    private final Context mContext;
    private final Object zzBr = new Object();
    private final zza.AbstractC0012zza zzCd;
    private final AdRequestInfoParcel.zza zzCe;
    private zzdt.zzd zzDl;

    public static class zza implements zzdt.zzb<zzbb> {
        /* renamed from: zza */
        public void zzc(zzbb zzbb) {
            zzl.zzd(zzbb);
        }
    }

    public static class zzb implements zzdt.zzb<zzbb> {
        /* renamed from: zza */
        public void zzc(zzbb zzbb) {
            zzl.zzc(zzbb);
        }
    }

    public static class zzc implements zzdg {
        @Override // com.google.android.gms.internal.zzdg
        public void zza(zzid zzid, Map<String, String> map) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Invalid request: " + map.get("errors"));
            zzl.zzDj.zzV(map.get("request_id"));
        }
    }

    public zzl(Context context, AdRequestInfoParcel.zza zza2, zza.AbstractC0012zza zza3) {
        this.zzCd = zza3;
        this.mContext = context;
        this.zzCe = zza2;
        synchronized (zzoW) {
            if (!zzDg) {
                zzDj = new zzdl();
                zzDi = new zzdh(context.getApplicationContext(), zza2.zzpJ);
                zzDk = new zzc();
                zzDh = new zzdt(this.mContext.getApplicationContext(), this.zzCe.zzpJ, zzbz.zztD.get(), new zzb(), new zza());
                zzDg = true;
            }
        }
    }

    private JSONObject zza(AdRequestInfoParcel adRequestInfoParcel, String str) {
        JSONObject zza2;
        AdvertisingIdClient.Info info;
        Bundle bundle = adRequestInfoParcel.zzCm.extras.getBundle("sdk_less_server_data");
        String string = adRequestInfoParcel.zzCm.extras.getString("sdk_less_network_id");
        if (bundle == null || (zza2 = zzgg.zza(adRequestInfoParcel, zzo.zzbB().zzC(this.mContext), null, new zzbr(zzbz.zztD.get()), null, null, new ArrayList())) == null) {
            return null;
        }
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Cannot get advertising id info", e);
            info = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("request_id", str);
        hashMap.put("network_id", string);
        hashMap.put("request_param", zza2);
        hashMap.put("data", bundle);
        if (info != null) {
            hashMap.put("adid", info.getId());
            hashMap.put("lat", Integer.valueOf(info.isLimitAdTrackingEnabled() ? 1 : 0));
        }
        try {
            return zzo.zzbv().zzy(hashMap);
        } catch (JSONException e2) {
            return null;
        }
    }

    protected static void zzc(zzbb zzbb) {
        zzbb.zza("/loadAd", zzDj);
        zzbb.zza("/fetchHttpRequest", zzDi);
        zzbb.zza("/invalidRequest", zzDk);
    }

    protected static void zzd(zzbb zzbb) {
        zzbb.zzb("/loadAd", zzDj);
        zzbb.zzb("/fetchHttpRequest", zzDi);
        zzbb.zzb("/invalidRequest", zzDk);
    }

    private AdResponseParcel zzf(AdRequestInfoParcel adRequestInfoParcel) {
        final String uuid = UUID.randomUUID().toString();
        final JSONObject zza2 = zza(adRequestInfoParcel, uuid);
        if (zza2 == null) {
            return new AdResponseParcel(0);
        }
        long elapsedRealtime = zzo.zzbz().elapsedRealtime();
        Future<JSONObject> zzU = zzDj.zzU(uuid);
        com.google.android.gms.ads.internal.util.client.zza.zzGF.post(new Runnable() {
            /* class com.google.android.gms.ads.internal.request.zzl.AnonymousClass2 */

            public void run() {
                zzl.this.zzDl = zzl.zzDh.zzdU();
                zzl.this.zzDl.zza(new zzhx.zzc<zzbe>() {
                    /* class com.google.android.gms.ads.internal.request.zzl.AnonymousClass2.AnonymousClass1 */

                    /* renamed from: zzb */
                    public void zzc(zzbe zzbe) {
                        try {
                            zzbe.zza("AFMA_getAdapterLessMediationAd", zza2);
                        } catch (Exception e) {
                            com.google.android.gms.ads.internal.util.client.zzb.zzb("Error requesting an ad url", e);
                            zzl.zzDj.zzV(uuid);
                        }
                    }
                }, new zzhx.zza() {
                    /* class com.google.android.gms.ads.internal.request.zzl.AnonymousClass2.AnonymousClass2 */

                    @Override // com.google.android.gms.internal.zzhx.zza
                    public void run() {
                        zzl.zzDj.zzV(uuid);
                    }
                });
            }
        });
        try {
            JSONObject jSONObject = zzU.get(zzDf - (zzo.zzbz().elapsedRealtime() - elapsedRealtime), TimeUnit.MILLISECONDS);
            if (jSONObject == null) {
                return new AdResponseParcel(-1);
            }
            AdResponseParcel zza3 = zzgg.zza(this.mContext, adRequestInfoParcel, jSONObject.toString());
            return (zza3.errorCode == -3 || !TextUtils.isEmpty(zza3.zzCI)) ? zza3 : new AdResponseParcel(3);
        } catch (InterruptedException | CancellationException e) {
            return new AdResponseParcel(-1);
        } catch (TimeoutException e2) {
            return new AdResponseParcel(2);
        } catch (ExecutionException e3) {
            return new AdResponseParcel(0);
        }
    }

    @Override // com.google.android.gms.internal.zzhh
    public void onStop() {
        synchronized (this.zzBr) {
            com.google.android.gms.ads.internal.util.client.zza.zzGF.post(new Runnable() {
                /* class com.google.android.gms.ads.internal.request.zzl.AnonymousClass3 */

                public void run() {
                    if (zzl.this.zzDl != null) {
                        zzl.this.zzDl.release();
                        zzl.this.zzDl = null;
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.zzhh
    public void zzdP() {
        com.google.android.gms.ads.internal.util.client.zzb.zzay("SdkLessAdLoaderBackgroundTask started.");
        AdRequestInfoParcel adRequestInfoParcel = new AdRequestInfoParcel(this.zzCe, null, null);
        AdResponseParcel zzf = zzf(adRequestInfoParcel);
        final zzha.zza zza2 = new zzha.zza(adRequestInfoParcel, zzf, null, null, zzf.errorCode, zzo.zzbz().elapsedRealtime(), zzf.zzCO, null);
        com.google.android.gms.ads.internal.util.client.zza.zzGF.post(new Runnable() {
            /* class com.google.android.gms.ads.internal.request.zzl.AnonymousClass1 */

            public void run() {
                zzl.this.zzCd.zza(zza2);
                if (zzl.this.zzDl != null) {
                    zzl.this.zzDl.release();
                    zzl.this.zzDl = null;
                }
            }
        });
    }
}
