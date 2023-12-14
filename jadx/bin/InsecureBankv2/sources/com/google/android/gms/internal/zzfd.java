package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzgd
public class zzfd implements zzfb {
    private final Context mContext;
    final Set<WebView> zzAt = Collections.synchronizedSet(new HashSet());

    public zzfd(Context context) {
        this.mContext = context;
    }

    @Override // com.google.android.gms.internal.zzfb
    public void zza(String str, final String str2, final String str3) {
        zzb.zzay("Fetching assets for the given html");
        zzhl.zzGk.post(new Runnable() {
            /* class com.google.android.gms.internal.zzfd.AnonymousClass1 */

            public void run() {
                final WebView zzeZ = zzfd.this.zzeZ();
                zzeZ.setWebViewClient(new WebViewClient() {
                    /* class com.google.android.gms.internal.zzfd.AnonymousClass1.AnonymousClass1 */

                    public void onPageFinished(WebView view, String url) {
                        zzb.zzay("Loading assets have finished");
                        zzfd.this.zzAt.remove(zzeZ);
                    }

                    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                        zzb.zzaC("Loading assets have failed.");
                        zzfd.this.zzAt.remove(zzeZ);
                    }
                });
                zzfd.this.zzAt.add(zzeZ);
                zzeZ.loadDataWithBaseURL(str2, str3, "text/html", "UTF-8", null);
                zzb.zzay("Fetching assets finished.");
            }
        });
    }

    public WebView zzeZ() {
        WebView webView = new WebView(this.mContext);
        webView.getSettings().setJavaScriptEnabled(true);
        return webView;
    }
}
