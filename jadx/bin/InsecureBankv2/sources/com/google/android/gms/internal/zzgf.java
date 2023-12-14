package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzi;
import com.google.android.gms.ads.internal.request.zzj;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.internal.zzdt;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzie;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public final class zzgf extends zzi.zza {
    private static zzgf zzDv;
    private static final Object zzoW = new Object();
    private final Context mContext;
    private final zzge zzDw;
    private final zzbr zzDx;
    private final zzdt zzqC;

    zzgf(Context context, zzbr zzbr, zzge zzge) {
        this.mContext = context;
        this.zzDw = zzge;
        this.zzDx = zzbr;
        this.zzqC = new zzdt(context.getApplicationContext() != null ? context.getApplicationContext() : context, new VersionInfoParcel(7571000, 7571000, true), zzbr.zzcW(), new zzdt.zzb<zzbb>() {
            /* class com.google.android.gms.internal.zzgf.AnonymousClass5 */

            /* renamed from: zza */
            public void zzc(zzbb zzbb) {
                zzbb.zza("/log", zzdf.zzwc);
            }
        }, new zzdt.zzc());
    }

    private static AdResponseParcel zza(final Context context, final zzdt zzdt, final zzbr zzbr, zzge zzge, final AdRequestInfoParcel adRequestInfoParcel) {
        String string;
        zzb.zzay("Starting ad request from service.");
        zzbz.zzw(context);
        final zzce zzce = new zzce("load_ad");
        zzcd zzdo = zzce.zzdo();
        zzge.zzDs.init();
        zzgk zzC = zzo.zzbB().zzC(context);
        if (zzC.zzEy == -1) {
            zzb.zzay("Device is offline.");
            return new AdResponseParcel(2);
        }
        String uuid = adRequestInfoParcel.versionCode >= 7 ? adRequestInfoParcel.zzCE : UUID.randomUUID().toString();
        final zzgh zzgh = new zzgh(uuid, adRequestInfoParcel.applicationInfo.packageName);
        if (adRequestInfoParcel.zzCm.extras != null && (string = adRequestInfoParcel.zzCm.extras.getString("_ad")) != null) {
            return zzgg.zza(context, adRequestInfoParcel, string);
        }
        Location zzc = zzge.zzDs.zzc(250);
        String zzc2 = zzge.zzDt.zzc(context, adRequestInfoParcel.zzCn.packageName);
        JSONObject zza = zzgg.zza(adRequestInfoParcel, zzC, zzc, zzbr, zzc2, zzge.zzDu.zzar(adRequestInfoParcel.zzCo), zzge.zzDr.zza(adRequestInfoParcel));
        if (adRequestInfoParcel.versionCode < 7) {
            try {
                zza.put("request_id", uuid);
            } catch (JSONException e) {
            }
        }
        if (zza == null) {
            return new AdResponseParcel(0);
        }
        final String jSONObject = zza.toString();
        zzce.zza(zzdo, "arc");
        final zzcd zzdo2 = zzce.zzdo();
        if (zzbz.zztE.get().booleanValue()) {
            zzhl.zzGk.post(new Runnable() {
                /* class com.google.android.gms.internal.zzgf.AnonymousClass1 */

                public void run() {
                    zzdt.zzd zzdU = zzdt.zzdU();
                    zzgh.zzb(zzdU);
                    zzce.zza(zzdo2, "rwc");
                    final zzcd zzdo = zzce.zzdo();
                    zzdU.zza(new zzhx.zzc<zzbe>() {
                        /* class com.google.android.gms.internal.zzgf.AnonymousClass1.AnonymousClass1 */

                        /* renamed from: zzb */
                        public void zzc(zzbe zzbe) {
                            zzce.zza(zzdo, "jsf");
                            zzce.zzdp();
                            zzbe.zza("/invalidRequest", zzgh.zzDO);
                            zzbe.zza("/loadAdURL", zzgh.zzDP);
                            try {
                                zzbe.zza("AFMA_buildAdURL", jSONObject);
                            } catch (Exception e) {
                                zzb.zzb("Error requesting an ad url", e);
                            }
                        }
                    }, new zzhx.zza() {
                        /* class com.google.android.gms.internal.zzgf.AnonymousClass1.AnonymousClass2 */

                        @Override // com.google.android.gms.internal.zzhx.zza
                        public void run() {
                        }
                    });
                }
            });
        } else {
            zzhl.zzGk.post(new Runnable() {
                /* class com.google.android.gms.internal.zzgf.AnonymousClass2 */

                public void run() {
                    zzid zza = zzo.zzbw().zza(context, new AdSizeParcel(), false, false, null, adRequestInfoParcel.zzpJ);
                    if (zzo.zzby().zzge()) {
                        zza.getWebView().clearCache(true);
                    }
                    zza.setWillNotDraw(true);
                    zzgh.zze(zza);
                    zzce.zza(zzdo2, "rwc");
                    zzie.zza zza2 = zzgf.zza(jSONObject, zzce, zzce.zzdo());
                    zzie zzgF = zza.zzgF();
                    zzgF.zza("/invalidRequest", zzgh.zzDO);
                    zzgF.zza("/loadAdURL", zzgh.zzDP);
                    zzgF.zza("/log", zzdf.zzwc);
                    zzgF.zza(zza2);
                    zzb.zzay("Loading the JS library.");
                    zza.loadUrl(zzbr.zzcW());
                }
            });
        }
        try {
            zzgj zzgj = zzgh.zzfE().get(10, TimeUnit.SECONDS);
            if (zzgj == null) {
                try {
                    return new AdResponseParcel(0);
                } finally {
                    zzhl.zzGk.post(new Runnable() {
                        /* class com.google.android.gms.internal.zzgf.AnonymousClass3 */

                        public void run() {
                            zzgh.zzfF();
                            if (zzgh.zzfD() != null) {
                                zzgh.zzfD().release();
                            }
                        }
                    });
                }
            } else if (zzgj.getErrorCode() != -2) {
                AdResponseParcel adResponseParcel = new AdResponseParcel(zzgj.getErrorCode());
                zzhl.zzGk.post(new Runnable() {
                    /* class com.google.android.gms.internal.zzgf.AnonymousClass3 */

                    public void run() {
                        zzgh.zzfF();
                        if (zzgh.zzfD() != null) {
                            zzgh.zzfD().release();
                        }
                    }
                });
                return adResponseParcel;
            } else {
                if (zzce.zzds() != null) {
                    zzce.zza(zzce.zzds(), "rur");
                }
                String str = null;
                if (zzgj.zzfI()) {
                    str = zzge.zzDq.zzaq(adRequestInfoParcel.zzCn.packageName);
                }
                zzcd zzdo3 = zzce.zzdo();
                AdResponseParcel zza2 = zza(adRequestInfoParcel, context, adRequestInfoParcel.zzpJ.zzGG, zzgj.getUrl(), str, zzc2, zzgj);
                if (zza2.zzCW == 1) {
                    zzge.zzDt.clearToken(context, adRequestInfoParcel.zzCn.packageName);
                }
                zzce.zza(zzdo3, "ufe");
                zzce.zza(zzdo, "tts");
                if (zzhg.zzfY() != null) {
                    zzhg.zzfY().zza(zzce);
                }
                zzhl.zzGk.post(new Runnable() {
                    /* class com.google.android.gms.internal.zzgf.AnonymousClass3 */

                    public void run() {
                        zzgh.zzfF();
                        if (zzgh.zzfD() != null) {
                            zzgh.zzfD().release();
                        }
                    }
                });
                return zza2;
            }
        } catch (Exception e2) {
            AdResponseParcel adResponseParcel2 = new AdResponseParcel(0);
            zzhl.zzGk.post(new Runnable() {
                /* class com.google.android.gms.internal.zzgf.AnonymousClass3 */

                public void run() {
                    zzgh.zzfF();
                    if (zzgh.zzfD() != null) {
                        zzgh.zzfD().release();
                    }
                }
            });
            return adResponseParcel2;
        }
    }

    public static AdResponseParcel zza(AdRequestInfoParcel adRequestInfoParcel, Context context, String str, String str2, String str3, String str4, zzgj zzgj) {
        HttpURLConnection httpURLConnection;
        int responseCode;
        try {
            zzgi zzgi = new zzgi(adRequestInfoParcel);
            zzb.zzay("AdRequestServiceImpl: Sending request: " + str2);
            URL url = new URL(str2);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            URL url2 = url;
            int i = 0;
            while (true) {
                httpURLConnection = (HttpURLConnection) url2.openConnection();
                try {
                    zzo.zzbv().zza(context, str, false, httpURLConnection);
                    if (!TextUtils.isEmpty(str3)) {
                        httpURLConnection.addRequestProperty("x-afma-drt-cookie", str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        httpURLConnection.addRequestProperty("Authorization", "Bearer " + str4);
                    }
                    if (zzgj != null && !TextUtils.isEmpty(zzgj.zzfH())) {
                        httpURLConnection.setDoOutput(true);
                        byte[] bytes = zzgj.zzfH().getBytes();
                        httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                        bufferedOutputStream.write(bytes);
                        bufferedOutputStream.close();
                    }
                    responseCode = httpURLConnection.getResponseCode();
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    if (responseCode < 200 || responseCode >= 300) {
                        zza(url2.toString(), headerFields, null, responseCode);
                        if (responseCode < 300 || responseCode >= 400) {
                            zzb.zzaC("Received error HTTP response code: " + responseCode);
                            AdResponseParcel adResponseParcel = new AdResponseParcel(0);
                            httpURLConnection.disconnect();
                        } else {
                            String headerField = httpURLConnection.getHeaderField("Location");
                            if (TextUtils.isEmpty(headerField)) {
                                zzb.zzaC("No location header to follow redirect.");
                                AdResponseParcel adResponseParcel2 = new AdResponseParcel(0);
                                httpURLConnection.disconnect();
                                return adResponseParcel2;
                            }
                            url2 = new URL(headerField);
                            i++;
                            if (i > 5) {
                                zzb.zzaC("Too many redirects.");
                                AdResponseParcel adResponseParcel3 = new AdResponseParcel(0);
                                httpURLConnection.disconnect();
                                return adResponseParcel3;
                            }
                            zzgi.zzi(headerFields);
                        }
                    } else {
                        String url3 = url2.toString();
                        String zza = zzo.zzbv().zza(new InputStreamReader(httpURLConnection.getInputStream()));
                        zza(url3, headerFields, zza, responseCode);
                        zzgi.zza(url3, headerFields, zza);
                        AdResponseParcel zzj = zzgi.zzj(elapsedRealtime);
                        httpURLConnection.disconnect();
                        return zzj;
                    }
                } finally {
                    httpURLConnection.disconnect();
                }
            }
            zzb.zzaC("Received error HTTP response code: " + responseCode);
            AdResponseParcel adResponseParcel4 = new AdResponseParcel(0);
            httpURLConnection.disconnect();
            return adResponseParcel4;
        } catch (IOException e) {
            zzb.zzaC("Error while connecting to ad server: " + e.getMessage());
            return new AdResponseParcel(2);
        }
    }

    public static zzgf zza(Context context, zzbr zzbr, zzge zzge) {
        zzgf zzgf;
        synchronized (zzoW) {
            if (zzDv == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzDv = new zzgf(context, zzbr, zzge);
            }
            zzgf = zzDv;
        }
        return zzgf;
    }

    /* access modifiers changed from: private */
    public static zzie.zza zza(final String str, final zzce zzce, final zzcd zzcd) {
        return new zzie.zza() {
            /* class com.google.android.gms.internal.zzgf.AnonymousClass4 */

            @Override // com.google.android.gms.internal.zzie.zza
            public void zza(zzid zzid, boolean z) {
                zzce.zza(zzcd, "jsf");
                zzce.zzdp();
                zzid.zza("AFMA_buildAdURL", str);
            }
        };
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (zzb.zzL(2)) {
            zzb.zzaB("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    zzb.zzaB("    " + str3 + ":");
                    Iterator<String> it = map.get(str3).iterator();
                    while (it.hasNext()) {
                        zzb.zzaB("      " + it.next());
                    }
                }
            }
            zzb.zzaB("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    zzb.zzaB(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                zzb.zzaB("    null");
            }
            zzb.zzaB("  Response Code:\n    " + i + "\n}");
        }
    }

    @Override // com.google.android.gms.ads.internal.request.zzi
    public void zza(final AdRequestInfoParcel adRequestInfoParcel, final zzj zzj) {
        zzo.zzby().zzb(this.mContext, adRequestInfoParcel.zzpJ);
        new zzhh() {
            /* class com.google.android.gms.internal.zzgf.AnonymousClass6 */

            @Override // com.google.android.gms.internal.zzhh
            public void onStop() {
                try {
                    zzj.zzb(new AdResponseParcel(-1));
                } catch (RemoteException e) {
                    zzb.zzd("Fail to forward ad response.", e);
                }
            }

            @Override // com.google.android.gms.internal.zzhh
            public void zzdP() {
                AdResponseParcel adResponseParcel;
                try {
                    adResponseParcel = zzgf.this.zze(adRequestInfoParcel);
                } catch (Exception e) {
                    zzo.zzby().zzc((Throwable) e, true);
                    zzb.zzd("Could not fetch ad response due to an Exception.", e);
                    adResponseParcel = null;
                }
                if (adResponseParcel == null) {
                    adResponseParcel = new AdResponseParcel(0);
                }
                try {
                    zzj.zzb(adResponseParcel);
                } catch (RemoteException e2) {
                    zzb.zzd("Fail to forward ad response.", e2);
                }
            }
        }.zzgi();
    }

    @Override // com.google.android.gms.ads.internal.request.zzi
    public AdResponseParcel zze(AdRequestInfoParcel adRequestInfoParcel) {
        zzhg.zze(this.mContext, adRequestInfoParcel.zzpJ.zzGG);
        return zza(this.mContext, this.zzqC, this.zzDx, this.zzDw, adRequestInfoParcel);
    }
}
