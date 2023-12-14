package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.internal.widget.ActivityChooserView;
import android.text.TextUtils;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzad;
import com.google.android.gms.analytics.internal.zzal;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zznx;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Tracker extends zzd {
    private boolean zzIH;
    private final Map<String, String> zzII = new HashMap();
    private final zzad zzIJ;
    private final zza zzIK;
    private ExceptionReporter zzIL;
    private zzal zzIM;
    private final Map<String, String> zzyn = new HashMap();

    /* access modifiers changed from: private */
    public class zza extends zzd implements GoogleAnalytics.zza {
        private boolean zzIV;
        private int zzIW;
        private long zzIX = -1;
        private boolean zzIY;
        private long zzIZ;

        protected zza(zzf zzf) {
            super(zzf);
        }

        private void zzhr() {
            if (this.zzIX >= 0 || this.zzIV) {
                zzhg().zza(Tracker.this.zzIK);
            } else {
                zzhg().zzb(Tracker.this.zzIK);
            }
        }

        public void enableAutoActivityTracking(boolean enabled) {
            this.zzIV = enabled;
            zzhr();
        }

        public void setSessionTimeout(long sessionTimeout) {
            this.zzIX = sessionTimeout;
            zzhr();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.analytics.internal.zzd
        public void zzhn() {
        }

        public synchronized boolean zzhq() {
            boolean z;
            z = this.zzIY;
            this.zzIY = false;
            return z;
        }

        /* access modifiers changed from: package-private */
        public boolean zzhs() {
            return zzhP().elapsedRealtime() >= this.zzIZ + Math.max(1000, this.zzIX);
        }

        @Override // com.google.android.gms.analytics.GoogleAnalytics.zza
        public void zzn(Activity activity) {
            if (this.zzIW == 0 && zzhs()) {
                this.zzIY = true;
            }
            this.zzIW++;
            if (this.zzIV) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Tracker.this.setCampaignParamsOnNextHit(intent.getData());
                }
                HashMap hashMap = new HashMap();
                hashMap.put("&t", "screenview");
                Tracker.this.set("&cd", Tracker.this.zzIM != null ? Tracker.this.zzIM.zzq(activity) : activity.getClass().getCanonicalName());
                if (TextUtils.isEmpty((CharSequence) hashMap.get("&dr"))) {
                    String zzp = Tracker.zzp(activity);
                    if (!TextUtils.isEmpty(zzp)) {
                        hashMap.put("&dr", zzp);
                    }
                }
                Tracker.this.send(hashMap);
            }
        }

        @Override // com.google.android.gms.analytics.GoogleAnalytics.zza
        public void zzo(Activity activity) {
            this.zzIW--;
            this.zzIW = Math.max(0, this.zzIW);
            if (this.zzIW == 0) {
                this.zzIZ = zzhP().elapsedRealtime();
            }
        }
    }

    Tracker(zzf analytics, String trackingId, zzad rateLimiter) {
        super(analytics);
        if (trackingId != null) {
            this.zzyn.put("&tid", trackingId);
        }
        this.zzyn.put("useSecure", "1");
        this.zzyn.put("&a", Integer.toString(new Random().nextInt(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + 1));
        if (rateLimiter == null) {
            this.zzIJ = new zzad("tracking");
        } else {
            this.zzIJ = rateLimiter;
        }
        this.zzIK = new zza(analytics);
    }

    private static void zza(Map<String, String> map, Map<String, String> map2) {
        zzu.zzu(map2);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String zzb = zzb(entry);
                if (zzb != null) {
                    map2.put(zzb, entry.getValue());
                }
            }
        }
    }

    private static boolean zza(Map.Entry<String, String> entry) {
        String key = entry.getKey();
        entry.getValue();
        return key.startsWith("&") && key.length() >= 2;
    }

    private static String zzb(Map.Entry<String, String> entry) {
        if (!zza(entry)) {
            return null;
        }
        return entry.getKey().substring(1);
    }

    private static void zzb(Map<String, String> map, Map<String, String> map2) {
        zzu.zzu(map2);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String zzb = zzb(entry);
                if (zzb != null && !map2.containsKey(zzb)) {
                    map2.put(zzb, entry.getValue());
                }
            }
        }
    }

    private boolean zzho() {
        return this.zzIL != null;
    }

    static String zzp(Activity activity) {
        zzu.zzu(activity);
        Intent intent = activity.getIntent();
        if (intent == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (!TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
        return null;
    }

    public void enableAdvertisingIdCollection(boolean enabled) {
        this.zzIH = enabled;
    }

    public void enableAutoActivityTracking(boolean enabled) {
        this.zzIK.enableAutoActivityTracking(enabled);
    }

    public void enableExceptionReporting(boolean enable) {
        synchronized (this) {
            if (zzho() != enable) {
                if (enable) {
                    this.zzIL = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), getContext());
                    Thread.setDefaultUncaughtExceptionHandler(this.zzIL);
                    zzaT("Uncaught exceptions will be reported to Google Analytics");
                } else {
                    Thread.setDefaultUncaughtExceptionHandler(this.zzIL.zzhh());
                    zzaT("Uncaught exceptions will not be reported to Google Analytics");
                }
            }
        }
    }

    public String get(String key) {
        zzia();
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        if (this.zzyn.containsKey(key)) {
            return this.zzyn.get(key);
        }
        if (key.equals("&ul")) {
            return zzam.zza(Locale.getDefault());
        }
        if (key.equals("&cid")) {
            return zzhV().zziP();
        }
        if (key.equals("&sr")) {
            return zzhY().zzjF();
        }
        if (key.equals("&aid")) {
            return zzhX().zzix().zzsK();
        }
        if (key.equals("&an")) {
            return zzhX().zzix().zzjL();
        }
        if (key.equals("&av")) {
            return zzhX().zzix().zzjN();
        }
        if (key.equals("&aiid")) {
            return zzhX().zzix().zzwi();
        }
        return null;
    }

    public void send(Map<String, String> params) {
        final long currentTimeMillis = zzhP().currentTimeMillis();
        if (zzhg().getAppOptOut()) {
            zzaU("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        final boolean isDryRunEnabled = zzhg().isDryRunEnabled();
        final HashMap hashMap = new HashMap();
        zza(this.zzyn, hashMap);
        zza(params, hashMap);
        final boolean zze = zzam.zze(this.zzyn.get("useSecure"), true);
        zzb(this.zzII, hashMap);
        this.zzII.clear();
        final String str = hashMap.get("t");
        if (TextUtils.isEmpty(str)) {
            zzhQ().zzg(hashMap, "Missing hit type parameter");
            return;
        }
        final String str2 = hashMap.get("tid");
        if (TextUtils.isEmpty(str2)) {
            zzhQ().zzg(hashMap, "Missing tracking id parameter");
            return;
        }
        final boolean zzhp = zzhp();
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str) || "pageview".equalsIgnoreCase(str) || "appview".equalsIgnoreCase(str) || TextUtils.isEmpty(str)) {
                int parseInt = Integer.parseInt(this.zzyn.get("&a")) + 1;
                if (parseInt >= Integer.MAX_VALUE) {
                    parseInt = 1;
                }
                this.zzyn.put("&a", Integer.toString(parseInt));
            }
        }
        zzhS().zze(new Runnable() {
            /* class com.google.android.gms.analytics.Tracker.AnonymousClass1 */

            public void run() {
                boolean z = true;
                if (Tracker.this.zzIK.zzhq()) {
                    hashMap.put("sc", "start");
                }
                zzam.zzc(hashMap, "cid", Tracker.this.zzhg().getClientId());
                String str = (String) hashMap.get("sf");
                if (str != null) {
                    double zza = zzam.zza(str, 100.0d);
                    if (zzam.zza(zza, (String) hashMap.get("cid"))) {
                        Tracker.this.zzb("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(zza));
                        return;
                    }
                }
                com.google.android.gms.analytics.internal.zza zzhW = Tracker.this.zzhW();
                if (zzhp) {
                    zzam.zzb(hashMap, "ate", zzhW.zzhy());
                    zzam.zzb(hashMap, "adid", zzhW.zzhC());
                } else {
                    hashMap.remove("ate");
                    hashMap.remove("adid");
                }
                zznx zzix = Tracker.this.zzhX().zzix();
                zzam.zzb(hashMap, "an", zzix.zzjL());
                zzam.zzb(hashMap, "av", zzix.zzjN());
                zzam.zzb(hashMap, "aid", zzix.zzsK());
                zzam.zzb(hashMap, "aiid", zzix.zzwi());
                hashMap.put("v", "1");
                hashMap.put("_v", zze.zzJB);
                zzam.zzb(hashMap, "ul", Tracker.this.zzhY().zzjE().getLanguage());
                zzam.zzb(hashMap, "sr", Tracker.this.zzhY().zzjF());
                if ((str.equals("transaction") || str.equals("item")) || Tracker.this.zzIJ.zzkb()) {
                    long zzbj = zzam.zzbj((String) hashMap.get("ht"));
                    if (zzbj == 0) {
                        zzbj = currentTimeMillis;
                    }
                    if (isDryRunEnabled) {
                        Tracker.this.zzhQ().zzc("Dry run enabled. Would have sent hit", new zzab(Tracker.this, hashMap, zzbj, zze));
                        return;
                    }
                    String str2 = (String) hashMap.get("cid");
                    HashMap hashMap = new HashMap();
                    zzam.zza(hashMap, "uid", hashMap);
                    zzam.zza(hashMap, "an", hashMap);
                    zzam.zza(hashMap, "aid", hashMap);
                    zzam.zza(hashMap, "av", hashMap);
                    zzam.zza(hashMap, "aiid", hashMap);
                    String str3 = str2;
                    if (TextUtils.isEmpty((CharSequence) hashMap.get("adid"))) {
                        z = false;
                    }
                    hashMap.put("_s", String.valueOf(Tracker.this.zzhl().zza(new zzh(0, str2, str3, z, 0, hashMap))));
                    Tracker.this.zzhl().zza(new zzab(Tracker.this, hashMap, zzbj, zze));
                    return;
                }
                Tracker.this.zzhQ().zzg(hashMap, "Too many hits sent too quickly, rate limiting invoked");
            }
        });
    }

    public void set(String key, String value) {
        zzu.zzb(key, "Key should be non-null");
        if (!TextUtils.isEmpty(key)) {
            this.zzyn.put(key, value);
        }
    }

    public void setAnonymizeIp(boolean anonymize) {
        set("&aip", zzam.zzH(anonymize));
    }

    public void setAppId(String appId) {
        set("&aid", appId);
    }

    public void setAppInstallerId(String appInstallerId) {
        set("&aiid", appInstallerId);
    }

    public void setAppName(String appName) {
        set("&an", appName);
    }

    public void setAppVersion(String appVersion) {
        set("&av", appVersion);
    }

    public void setCampaignParamsOnNextHit(Uri uri) {
        if (uri != null && !uri.isOpaque()) {
            String queryParameter = uri.getQueryParameter("referrer");
            if (!TextUtils.isEmpty(queryParameter)) {
                Uri parse = Uri.parse("http://hostname/?" + queryParameter);
                String queryParameter2 = parse.getQueryParameter("utm_id");
                if (queryParameter2 != null) {
                    this.zzII.put("&ci", queryParameter2);
                }
                String queryParameter3 = parse.getQueryParameter("anid");
                if (queryParameter3 != null) {
                    this.zzII.put("&anid", queryParameter3);
                }
                String queryParameter4 = parse.getQueryParameter("utm_campaign");
                if (queryParameter4 != null) {
                    this.zzII.put("&cn", queryParameter4);
                }
                String queryParameter5 = parse.getQueryParameter("utm_content");
                if (queryParameter5 != null) {
                    this.zzII.put("&cc", queryParameter5);
                }
                String queryParameter6 = parse.getQueryParameter("utm_medium");
                if (queryParameter6 != null) {
                    this.zzII.put("&cm", queryParameter6);
                }
                String queryParameter7 = parse.getQueryParameter("utm_source");
                if (queryParameter7 != null) {
                    this.zzII.put("&cs", queryParameter7);
                }
                String queryParameter8 = parse.getQueryParameter("utm_term");
                if (queryParameter8 != null) {
                    this.zzII.put("&ck", queryParameter8);
                }
                String queryParameter9 = parse.getQueryParameter("dclid");
                if (queryParameter9 != null) {
                    this.zzII.put("&dclid", queryParameter9);
                }
                String queryParameter10 = parse.getQueryParameter("gclid");
                if (queryParameter10 != null) {
                    this.zzII.put("&gclid", queryParameter10);
                }
                String queryParameter11 = parse.getQueryParameter("aclid");
                if (queryParameter11 != null) {
                    this.zzII.put("&aclid", queryParameter11);
                }
            }
        }
    }

    public void setClientId(String clientId) {
        set("&cid", clientId);
    }

    public void setEncoding(String encoding) {
        set("&de", encoding);
    }

    public void setHostname(String hostname) {
        set("&dh", hostname);
    }

    public void setLanguage(String language) {
        set("&ul", language);
    }

    public void setLocation(String location) {
        set("&dl", location);
    }

    public void setPage(String page) {
        set("&dp", page);
    }

    public void setReferrer(String referrer) {
        set("&dr", referrer);
    }

    public void setSampleRate(double sampleRate) {
        set("&sf", Double.toString(sampleRate));
    }

    public void setScreenColors(String screenColors) {
        set("&sd", screenColors);
    }

    public void setScreenName(String screenName) {
        set("&cd", screenName);
    }

    public void setScreenResolution(int width, int height) {
        if (width >= 0 || height >= 0) {
            set("&sr", width + "x" + height);
        } else {
            zzaW("Invalid width or height. The values should be non-negative.");
        }
    }

    public void setSessionTimeout(long sessionTimeout) {
        this.zzIK.setSessionTimeout(1000 * sessionTimeout);
    }

    public void setTitle(String title) {
        set("&dt", title);
    }

    public void setUseSecure(boolean useSecure) {
        set("useSecure", zzam.zzH(useSecure));
    }

    public void setViewportSize(String viewportSize) {
        set("&vp", viewportSize);
    }

    /* access modifiers changed from: package-private */
    public void zza(zzal zzal) {
        zzaT("Loading Tracker config values");
        this.zzIM = zzal;
        if (this.zzIM.zzky()) {
            String trackingId = this.zzIM.getTrackingId();
            set("&tid", trackingId);
            zza("trackingId loaded", trackingId);
        }
        if (this.zzIM.zzkz()) {
            String d = Double.toString(this.zzIM.zzkA());
            set("&sf", d);
            zza("Sample frequency loaded", d);
        }
        if (this.zzIM.zzkB()) {
            int sessionTimeout = this.zzIM.getSessionTimeout();
            setSessionTimeout((long) sessionTimeout);
            zza("Session timeout loaded", Integer.valueOf(sessionTimeout));
        }
        if (this.zzIM.zzkC()) {
            boolean zzkD = this.zzIM.zzkD();
            enableAutoActivityTracking(zzkD);
            zza("Auto activity tracking loaded", Boolean.valueOf(zzkD));
        }
        if (this.zzIM.zzkE()) {
            boolean zzkF = this.zzIM.zzkF();
            if (zzkF) {
                set("&aip", "1");
            }
            zza("Anonymize ip loaded", Boolean.valueOf(zzkF));
        }
        enableExceptionReporting(this.zzIM.zzkG());
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.analytics.internal.zzd
    public void zzhn() {
        this.zzIK.zza();
        String zzjL = zzhm().zzjL();
        if (zzjL != null) {
            set("&an", zzjL);
        }
        String zzjN = zzhm().zzjN();
        if (zzjN != null) {
            set("&av", zzjN);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzhp() {
        return this.zzIH;
    }
}
