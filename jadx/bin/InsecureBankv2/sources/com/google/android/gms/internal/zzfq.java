package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.internal.zzie;

@zzgd
public class zzfq implements Runnable {
    private final Handler zzBf;
    private final long zzBg;
    private long zzBh;
    private zzie.zza zzBi;
    protected boolean zzBj;
    protected boolean zzBk;
    private final int zznM;
    private final int zznN;
    protected final zzid zzoA;

    protected final class zza extends AsyncTask<Void, Void, Boolean> {
        private final WebView zzBl;
        private Bitmap zzBm;

        public zza(WebView webView) {
            this.zzBl = webView;
        }

        /* access modifiers changed from: protected */
        public synchronized void onPreExecute() {
            this.zzBm = Bitmap.createBitmap(zzfq.this.zznM, zzfq.this.zznN, Bitmap.Config.ARGB_8888);
            this.zzBl.setVisibility(0);
            this.zzBl.measure(View.MeasureSpec.makeMeasureSpec(zzfq.this.zznM, 0), View.MeasureSpec.makeMeasureSpec(zzfq.this.zznN, 0));
            this.zzBl.layout(0, 0, zzfq.this.zznM, zzfq.this.zznN);
            this.zzBl.draw(new Canvas(this.zzBm));
            this.zzBl.invalidate();
        }

        /* access modifiers changed from: protected */
        /* renamed from: zza */
        public synchronized Boolean doInBackground(Void... voidArr) {
            boolean z;
            int width = this.zzBm.getWidth();
            int height = this.zzBm.getHeight();
            if (width == 0 || height == 0) {
                z = false;
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.zzBm.getPixel(i2, i3) != 0) {
                            i++;
                        }
                    }
                }
                z = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
            }
            return z;
        }

        /* access modifiers changed from: protected */
        /* renamed from: zza */
        public void onPostExecute(Boolean bool) {
            zzfq.zzc(zzfq.this);
            if (bool.booleanValue() || zzfq.this.zzfl() || zzfq.this.zzBh <= 0) {
                zzfq.this.zzBk = bool.booleanValue();
                zzfq.this.zzBi.zza(zzfq.this.zzoA, true);
            } else if (zzfq.this.zzBh > 0) {
                if (zzb.zzL(2)) {
                    zzb.zzay("Ad not detected, scheduling another run.");
                }
                zzfq.this.zzBf.postDelayed(zzfq.this, zzfq.this.zzBg);
            }
        }
    }

    public zzfq(zzie.zza zza2, zzid zzid, int i, int i2) {
        this(zza2, zzid, i, i2, 200, 50);
    }

    public zzfq(zzie.zza zza2, zzid zzid, int i, int i2, long j, long j2) {
        this.zzBg = j;
        this.zzBh = j2;
        this.zzBf = new Handler(Looper.getMainLooper());
        this.zzoA = zzid;
        this.zzBi = zza2;
        this.zzBj = false;
        this.zzBk = false;
        this.zznN = i2;
        this.zznM = i;
    }

    static /* synthetic */ long zzc(zzfq zzfq) {
        long j = zzfq.zzBh - 1;
        zzfq.zzBh = j;
        return j;
    }

    public void run() {
        if (this.zzoA == null || zzfl()) {
            this.zzBi.zza(this.zzoA, true);
        } else {
            new zza(this.zzoA.getWebView()).execute(new Void[0]);
        }
    }

    public void zza(AdResponseParcel adResponseParcel) {
        zza(adResponseParcel, new zzil(this, this.zzoA, adResponseParcel.zzCR));
    }

    public void zza(AdResponseParcel adResponseParcel, zzil zzil) {
        this.zzoA.setWebViewClient(zzil);
        this.zzoA.loadDataWithBaseURL(TextUtils.isEmpty(adResponseParcel.zzzG) ? null : zzo.zzbv().zzat(adResponseParcel.zzzG), adResponseParcel.zzCI, "text/html", "UTF-8", null);
    }

    public void zzfj() {
        this.zzBf.postDelayed(this, this.zzBg);
    }

    public synchronized void zzfk() {
        this.zzBj = true;
    }

    public synchronized boolean zzfl() {
        return this.zzBj;
    }

    public boolean zzfm() {
        return this.zzBk;
    }
}
