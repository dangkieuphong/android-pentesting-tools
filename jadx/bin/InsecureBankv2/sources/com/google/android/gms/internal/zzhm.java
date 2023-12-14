package com.google.android.gms.internal;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@zzgd
public class zzhm {

    /* access modifiers changed from: package-private */
    public static class zza extends zzhm {
        zza() {
            super();
        }

        @Override // com.google.android.gms.internal.zzhm
        public boolean zza(DownloadManager.Request request) {
            request.setShowRunningNotification(true);
            return true;
        }

        @Override // com.google.android.gms.internal.zzhm
        public int zzgq() {
            return 6;
        }

        @Override // com.google.android.gms.internal.zzhm
        public int zzgr() {
            return 7;
        }
    }

    /* access modifiers changed from: package-private */
    public static class zzb extends zza {
        zzb() {
        }

        @Override // com.google.android.gms.internal.zzhm, com.google.android.gms.internal.zzhm.zza
        public boolean zza(DownloadManager.Request request) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            return true;
        }

        @Override // com.google.android.gms.internal.zzhm
        public boolean zza(Context context, WebSettings webSettings) {
            if (context.getCacheDir() != null) {
                webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
                webSettings.setAppCacheMaxSize(0);
                webSettings.setAppCacheEnabled(true);
            }
            webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
            webSettings.setDatabaseEnabled(true);
            webSettings.setDomStorageEnabled(true);
            webSettings.setDisplayZoomControls(false);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setSupportZoom(true);
            return true;
        }

        @Override // com.google.android.gms.internal.zzhm
        public boolean zza(Window window) {
            window.setFlags(ViewCompat.MEASURED_STATE_TOO_SMALL, ViewCompat.MEASURED_STATE_TOO_SMALL);
            return true;
        }

        @Override // com.google.android.gms.internal.zzhm
        public boolean zza(WebView webView) {
            webView.onPause();
            return true;
        }

        @Override // com.google.android.gms.internal.zzhm
        public zzie zzb(zzid zzid, boolean z) {
            return new zzij(zzid, z);
        }

        @Override // com.google.android.gms.internal.zzhm
        public boolean zzb(WebView webView) {
            webView.onResume();
            return true;
        }

        @Override // com.google.android.gms.internal.zzhm
        public Set<String> zze(Uri uri) {
            return uri.getQueryParameterNames();
        }

        @Override // com.google.android.gms.internal.zzhm
        public WebChromeClient zzf(zzid zzid) {
            return new zzii(zzid);
        }

        @Override // com.google.android.gms.internal.zzhm
        public boolean zzl(View view) {
            view.setLayerType(0, null);
            return true;
        }

        @Override // com.google.android.gms.internal.zzhm
        public boolean zzm(View view) {
            view.setLayerType(1, null);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public static class zzc extends zzb {
        zzc() {
        }

        @Override // com.google.android.gms.internal.zzhm, com.google.android.gms.internal.zzhm.zzb
        public WebChromeClient zzf(zzid zzid) {
            return new zzik(zzid);
        }
    }

    /* access modifiers changed from: package-private */
    public static class zzd extends zzf {
        zzd() {
        }

        @Override // com.google.android.gms.internal.zzhm
        public String getDefaultUserAgent(Context context) {
            return WebSettings.getDefaultUserAgent(context);
        }

        @Override // com.google.android.gms.internal.zzhm, com.google.android.gms.internal.zzhm.zzb
        public boolean zza(Context context, WebSettings webSettings) {
            super.zza(context, webSettings);
            webSettings.setMediaPlaybackRequiresUserGesture(false);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public static class zze extends zzd {
        zze() {
        }

        @Override // com.google.android.gms.internal.zzhm
        public int zzgs() {
            return 14;
        }

        @Override // com.google.android.gms.internal.zzhm
        public boolean zzk(View view) {
            return super.zzk(view) || view.getWindowId() != null;
        }
    }

    /* access modifiers changed from: package-private */
    public static class zzf extends zzc {
        zzf() {
        }

        @Override // com.google.android.gms.internal.zzhm
        public void zza(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        @Override // com.google.android.gms.internal.zzhm
        public void zza(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        @Override // com.google.android.gms.internal.zzhm
        public void zzb(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            Window window = activity.getWindow();
            if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
                zza(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class zzg extends zze {
        zzg() {
        }

        @Override // com.google.android.gms.internal.zzhm
        public ViewGroup.LayoutParams zzgt() {
            return new ViewGroup.LayoutParams(-1, -1);
        }

        @Override // com.google.android.gms.internal.zzhm, com.google.android.gms.internal.zzhm.zze
        public boolean zzk(View view) {
            return view.isAttachedToWindow();
        }
    }

    private zzhm() {
    }

    public static zzhm zzK(int i) {
        return i >= 19 ? new zzg() : i >= 18 ? new zze() : i >= 17 ? new zzd() : i >= 16 ? new zzf() : i >= 14 ? new zzc() : i >= 11 ? new zzb() : i >= 9 ? new zza() : new zzhm();
    }

    public String getDefaultUserAgent(Context context) {
        return "";
    }

    public void zza(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    public void zza(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public boolean zza(DownloadManager.Request request) {
        return false;
    }

    public boolean zza(Context context, WebSettings webSettings) {
        return false;
    }

    public boolean zza(Window window) {
        return false;
    }

    public boolean zza(WebView webView) {
        return false;
    }

    public zzie zzb(zzid zzid, boolean z) {
        return new zzie(zzid, z);
    }

    public void zzb(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            zza(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public boolean zzb(WebView webView) {
        return false;
    }

    public Set<String> zze(Uri uri) {
        if (uri.isOpaque()) {
            return Collections.emptySet();
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
            i = indexOf + 1;
        } while (i < encodedQuery.length());
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public WebChromeClient zzf(zzid zzid) {
        return null;
    }

    public int zzgq() {
        return 0;
    }

    public int zzgr() {
        return 1;
    }

    public int zzgs() {
        return 5;
    }

    public ViewGroup.LayoutParams zzgt() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public boolean zzk(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public boolean zzl(View view) {
        return false;
    }

    public boolean zzm(View view) {
        return false;
    }
}
