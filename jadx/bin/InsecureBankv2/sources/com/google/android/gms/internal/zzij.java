package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzgd
public class zzij extends zzie {
    public zzij(zzid zzid, boolean z) {
        super(zzid, z);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String url) {
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(url).getName())) {
                return super.shouldInterceptRequest(webView, url);
            }
            if (!(webView instanceof zzid)) {
                zzb.zzaC("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(webView, url);
            }
            zzid zzid = (zzid) webView;
            zzid.zzgF().zzet();
            String str = zzid.zzaN().zzsn ? zzbz.zztX.get() : zzid.zzgJ() ? zzbz.zztW.get() : zzbz.zztV.get();
            zzb.zzaB("shouldInterceptRequest(" + str + ")");
            return zzd(zzid.getContext(), this.zzoA.zzgI().zzGG, str);
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            zzb.zzaC("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, url);
        }
    }

    /* access modifiers changed from: protected */
    public WebResourceResponse zzd(Context context, String str, String str2) throws IOException, ExecutionException, InterruptedException, TimeoutException {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", zzo.zzbv().zzf(context, str));
        hashMap.put("Cache-Control", "max-stale=3600");
        String str3 = (String) new zzho(context).zzb(str2, hashMap).get(60, TimeUnit.SECONDS);
        if (str3 == null) {
            return null;
        }
        return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
    }
}
