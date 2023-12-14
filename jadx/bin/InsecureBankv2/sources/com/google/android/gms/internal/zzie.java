package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.support.v4.media.TransportMediator;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzf;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@zzgd
public class zzie extends WebViewClient {
    private zza zzBi;
    private final HashMap<String, List<zzdg>> zzHb;
    private zzf zzHc;
    private boolean zzHd;
    private zzk zzHe;
    private final zzet zzHf;
    private boolean zzHg;
    private boolean zzHh;
    private boolean zzHi;
    private boolean zzHj;
    private int zzHk;
    protected final zzid zzoA;
    private boolean zzqs;
    private final Object zzqt;
    private com.google.android.gms.ads.internal.client.zza zzrU;
    private zzde zzvU;
    private zzdk zzwu;
    private zzd zzww;
    private zzep zzwx;
    private zzdi zzwz;
    private zzev zzyE;

    public interface zza {
        void zza(zzid zzid, boolean z);
    }

    private static class zzb implements zzf {
        private zzf zzHc;
        private zzid zzHn;

        public zzb(zzid zzid, zzf zzf) {
            this.zzHn = zzid;
            this.zzHc = zzf;
        }

        @Override // com.google.android.gms.ads.internal.overlay.zzf
        public void zzaV() {
            this.zzHc.zzaV();
            this.zzHn.zzgA();
        }

        @Override // com.google.android.gms.ads.internal.overlay.zzf
        public void zzaW() {
            this.zzHc.zzaW();
            this.zzHn.zzew();
        }
    }

    /* access modifiers changed from: private */
    public class zzc implements zzdg {
        private zzc() {
        }

        @Override // com.google.android.gms.internal.zzdg
        public void zza(zzid zzid, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                zzie.this.zzgO();
            } else if (map.keySet().contains("stop")) {
                zzie.this.zzgP();
            } else if (map.keySet().contains("cancel")) {
                zzie.this.zzgQ();
            }
        }
    }

    public zzie(zzid zzid, boolean z) {
        this(zzid, z, new zzet(zzid, zzid.zzgC(), new zzbq(zzid.getContext())), null);
    }

    zzie(zzid zzid, boolean z, zzet zzet, zzep zzep) {
        this.zzHb = new HashMap<>();
        this.zzqt = new Object();
        this.zzHd = false;
        this.zzoA = zzid;
        this.zzqs = z;
        this.zzHf = zzet;
        this.zzwx = zzep;
    }

    private static boolean zzf(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzgO() {
        this.zzHk++;
        zzgR();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzgP() {
        this.zzHk--;
        zzgR();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzgQ() {
        this.zzHj = true;
        zzgR();
    }

    public final void onLoadResource(WebView webView, String url) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("Loading resource: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzg(parse);
        }
    }

    public final void onPageFinished(WebView webView, String url) {
        synchronized (this.zzqt) {
            if (!this.zzHh || !"about:blank".equals(url)) {
                this.zzHi = true;
                zzgR();
                return;
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaB("Blank page loaded, 1...");
            this.zzoA.zzgK();
        }
    }

    public final void reset() {
        synchronized (this.zzqt) {
            this.zzHb.clear();
            this.zzrU = null;
            this.zzHc = null;
            this.zzBi = null;
            this.zzvU = null;
            this.zzHd = false;
            this.zzqs = false;
            this.zzwz = null;
            this.zzHe = null;
            if (this.zzwx != null) {
                this.zzwx.zzn(true);
                this.zzwx = null;
            }
            this.zzHg = false;
        }
    }

    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        switch (event.getKeyCode()) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case TransportMediator.KEYCODE_MEDIA_PLAY:
            case TransportMediator.KEYCODE_MEDIA_PAUSE:
            case 128:
            case 129:
            case TransportMediator.KEYCODE_MEDIA_RECORD:
            case 222:
                return true;
            default:
                return false;
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String url) {
        Uri uri;
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("AdWebView shouldOverrideUrlLoading: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzg(parse);
        } else if (this.zzHd && webView == this.zzoA && zzf(parse)) {
            if (!this.zzHg) {
                this.zzHg = true;
                if (this.zzrU != null && zzbz.zzul.get().booleanValue()) {
                    this.zzrU.onAdClicked();
                }
            }
            return super.shouldOverrideUrlLoading(webView, url);
        } else if (!this.zzoA.willNotDraw()) {
            try {
                zzan zzgH = this.zzoA.zzgH();
                if (zzgH != null && zzgH.zzb(parse)) {
                    parse = zzgH.zza(parse, this.zzoA.getContext());
                }
                uri = parse;
            } catch (zzao e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("Unable to append parameter to URL: " + url);
                uri = parse;
            }
            if (this.zzww == null || this.zzww.zzbd()) {
                zza(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            } else {
                this.zzww.zzo(url);
            }
        } else {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("AdWebView unable to handle URL: " + url);
        }
        return true;
    }

    public void zzD(boolean z) {
        this.zzHd = z;
    }

    public void zza(int i, int i2, boolean z) {
        this.zzHf.zze(i, i2);
        if (this.zzwx != null) {
            this.zzwx.zza(i, i2, z);
        }
    }

    public final void zza(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel) {
        zzf zzf = null;
        boolean zzgJ = this.zzoA.zzgJ();
        com.google.android.gms.ads.internal.client.zza zza2 = (!zzgJ || this.zzoA.zzaN().zzsn) ? this.zzrU : null;
        if (!zzgJ) {
            zzf = this.zzHc;
        }
        zza(new AdOverlayInfoParcel(adLauncherIntentInfoParcel, zza2, zzf, this.zzHe, this.zzoA.zzgI()));
    }

    public void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean zzee = this.zzwx != null ? this.zzwx.zzee() : false;
        com.google.android.gms.ads.internal.overlay.zzd zzbt = zzo.zzbt();
        Context context = this.zzoA.getContext();
        if (!zzee) {
            z = true;
        }
        zzbt.zza(context, adOverlayInfoParcel, z);
    }

    public void zza(zza zza2) {
        this.zzBi = zza2;
    }

    public final void zza(String str, zzdg zzdg) {
        synchronized (this.zzqt) {
            List<zzdg> list = this.zzHb.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList<>();
                this.zzHb.put(str, list);
            }
            list.add(zzdg);
        }
    }

    public final void zza(boolean z, int i) {
        zza(new AdOverlayInfoParcel((!this.zzoA.zzgJ() || this.zzoA.zzaN().zzsn) ? this.zzrU : null, this.zzHc, this.zzHe, this.zzoA, z, i, this.zzoA.zzgI()));
    }

    public final void zza(boolean z, int i, String str) {
        zzb zzb2 = null;
        boolean zzgJ = this.zzoA.zzgJ();
        com.google.android.gms.ads.internal.client.zza zza2 = (!zzgJ || this.zzoA.zzaN().zzsn) ? this.zzrU : null;
        if (!zzgJ) {
            zzb2 = new zzb(this.zzoA, this.zzHc);
        }
        zza(new AdOverlayInfoParcel(zza2, zzb2, this.zzvU, this.zzHe, this.zzoA, z, i, str, this.zzoA.zzgI(), this.zzwz));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzgJ = this.zzoA.zzgJ();
        zza(new AdOverlayInfoParcel((!zzgJ || this.zzoA.zzaN().zzsn) ? this.zzrU : null, zzgJ ? null : new zzb(this.zzoA, this.zzHc), this.zzvU, this.zzHe, this.zzoA, z, i, str, str2, this.zzoA.zzgI(), this.zzwz));
    }

    public void zzb(com.google.android.gms.ads.internal.client.zza zza2, zzf zzf, zzde zzde, zzk zzk, boolean z, zzdi zzdi, zzdk zzdk, zzd zzd, zzev zzev) {
        if (zzd == null) {
            zzd = new zzd(false);
        }
        this.zzwx = new zzep(this.zzoA, zzev);
        zza("/appEvent", new zzdd(zzde));
        zza("/canOpenURLs", zzdf.zzvW);
        zza("/canOpenIntents", zzdf.zzvX);
        zza("/click", zzdf.zzvY);
        zza("/close", zzdf.zzvZ);
        zza("/customClose", zzdf.zzwa);
        zza("/delayPageLoaded", new zzc());
        zza("/httpTrack", zzdf.zzwb);
        zza("/log", zzdf.zzwc);
        zza("/mraid", new zzdm(zzd, this.zzwx));
        zza("/open", new zzdn(zzdi, zzd, this.zzwx));
        zza("/precache", zzdf.zzwf);
        zza("/touch", zzdf.zzwd);
        zza("/video", zzdf.zzwe);
        if (zzdk != null) {
            zza("/setInterstitialProperties", new zzdj(zzdk));
        }
        this.zzrU = zza2;
        this.zzHc = zzf;
        this.zzvU = zzde;
        this.zzwz = zzdi;
        this.zzHe = zzk;
        this.zzww = zzd;
        this.zzyE = zzev;
        this.zzwu = zzdk;
        zzD(z);
        this.zzHg = false;
    }

    public final void zzb(String str, zzdg zzdg) {
        synchronized (this.zzqt) {
            List<zzdg> list = this.zzHb.get(str);
            if (list != null) {
                list.remove(zzdg);
            }
        }
    }

    public boolean zzbU() {
        boolean z;
        synchronized (this.zzqt) {
            z = this.zzqs;
        }
        return z;
    }

    public void zzd(int i, int i2) {
        if (this.zzwx != null) {
            this.zzwx.zzd(i, i2);
        }
    }

    public final void zzet() {
        synchronized (this.zzqt) {
            this.zzHd = false;
            this.zzqs = true;
            this.zzoA.zzgL();
            final com.google.android.gms.ads.internal.overlay.zzc zzgD = this.zzoA.zzgD();
            if (zzgD != null) {
                if (!com.google.android.gms.ads.internal.client.zzk.zzcA().zzgw()) {
                    zzhl.zzGk.post(new Runnable() {
                        /* class com.google.android.gms.internal.zzie.AnonymousClass1 */

                        public void run() {
                            zzgD.zzet();
                        }
                    });
                } else {
                    zzgD.zzet();
                }
            }
        }
    }

    public void zzg(Uri uri) {
        String path = uri.getPath();
        List<zzdg> list = this.zzHb.get(path);
        if (list != null) {
            Map<String, String> zzd = zzo.zzbv().zzd(uri);
            if (com.google.android.gms.ads.internal.util.client.zzb.zzL(2)) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaB("Received GMSG: " + path);
                for (String str : zzd.keySet()) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaB("  " + str + ": " + zzd.get(str));
                }
            }
            for (zzdg zzdg : list) {
                zzdg.zza(this.zzoA, zzd);
            }
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("No GMSG handler found for GMSG: " + uri);
    }

    public zzd zzgM() {
        return this.zzww;
    }

    public void zzgN() {
        synchronized (this.zzqt) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaB("Loading blank page in WebView, 2...");
            this.zzHh = true;
            this.zzoA.zzaD("about:blank");
        }
    }

    public final void zzgR() {
        if (this.zzBi == null) {
            return;
        }
        if ((this.zzHi && this.zzHk <= 0) || this.zzHj) {
            this.zzBi.zza(this.zzoA, !this.zzHj);
            this.zzBi = null;
        }
    }

    public void zzgS() {
        if (zzbU()) {
            this.zzHf.zzek();
        }
    }
}
