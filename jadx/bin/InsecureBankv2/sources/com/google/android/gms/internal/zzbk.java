package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public class zzbk extends Thread {
    private boolean mStarted = false;
    private boolean zzam = false;
    private final Object zzqt;
    private final int zzrA;
    private final int zzrB;
    private final int zzrj;
    private final int zzrl;
    private boolean zzrv = false;
    private final zzbj zzrw;
    private final zzbi zzrx;
    private final zzgc zzry;
    private final int zzrz;

    /* access modifiers changed from: package-private */
    @zzgd
    public class zza {
        final int zzrI;
        final int zzrJ;

        zza(int i, int i2) {
            this.zzrI = i;
            this.zzrJ = i2;
        }
    }

    public zzbk(zzbj zzbj, zzbi zzbi, zzgc zzgc) {
        this.zzrw = zzbj;
        this.zzrx = zzbi;
        this.zzry = zzgc;
        this.zzqt = new Object();
        this.zzrj = zzbz.zzud.get().intValue();
        this.zzrA = zzbz.zzue.get().intValue();
        this.zzrl = zzbz.zzuf.get().intValue();
        this.zzrB = zzbz.zzug.get().intValue();
        this.zzrz = zzbz.zzuh.get().intValue();
        setName("ContentFetchTask");
    }

    public void run() {
        while (!this.zzam) {
            try {
                if (zzcq()) {
                    Activity activity = this.zzrw.getActivity();
                    if (activity == null) {
                        zzb.zzay("ContentFetchThread: no activity");
                    } else {
                        zza(activity);
                    }
                } else {
                    zzb.zzay("ContentFetchTask: sleeping");
                    zzcs();
                }
                Thread.sleep((long) (this.zzrz * 1000));
            } catch (Throwable th) {
                zzb.zzb("Error in ContentFetchTask", th);
                this.zzry.zza(th, true);
            }
            synchronized (this.zzqt) {
                while (this.zzrv) {
                    try {
                        zzb.zzay("ContentFetchTask: waiting");
                        this.zzqt.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    public void wakeup() {
        synchronized (this.zzqt) {
            this.zzrv = false;
            this.zzqt.notifyAll();
            zzb.zzay("ContentFetchThread: wakeup");
        }
    }

    /* access modifiers changed from: package-private */
    public zza zza(View view, zzbh zzbh) {
        if (view == null) {
            return new zza(0, 0);
        }
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zza(0, 0);
            }
            zzbh.zzv(text.toString());
            return new zza(1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzid)) {
            zzbh.zzcl();
            return zza((WebView) view, zzbh) ? new zza(0, 1) : new zza(0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new zza(0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                zza zza2 = zza(viewGroup.getChildAt(i3), zzbh);
                i2 += zza2.zzrI;
                i += zza2.zzrJ;
            }
            return new zza(i2, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(Activity activity) {
        if (activity != null) {
            View view = null;
            if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                view = activity.getWindow().getDecorView().findViewById(16908290);
            }
            if (view != null) {
                zzf(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(zzbh zzbh, WebView webView, String str) {
        zzbh.zzck();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (!TextUtils.isEmpty(webView.getTitle())) {
                    zzbh.zzu(webView.getTitle() + "\n" + optString);
                } else {
                    zzbh.zzu(optString);
                }
            }
            if (zzbh.zzch()) {
                this.zzrx.zzb(zzbh);
            }
        } catch (JSONException e) {
            zzb.zzay("Json string may be malformed.");
        } catch (Throwable th) {
            zzb.zza("Failed to get webview content.", th);
            this.zzry.zza(th, true);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zza(ActivityManager.RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance == 100;
    }

    /* access modifiers changed from: package-private */
    public boolean zza(final WebView webView, final zzbh zzbh) {
        if (!zzlk.zzoX()) {
            return false;
        }
        zzbh.zzcl();
        webView.post(new Runnable() {
            /* class com.google.android.gms.internal.zzbk.AnonymousClass2 */
            ValueCallback<String> zzrE = new ValueCallback<String>() {
                /* class com.google.android.gms.internal.zzbk.AnonymousClass2.AnonymousClass1 */

                /* renamed from: zzx */
                public void onReceiveValue(String str) {
                    zzbk.this.zza(zzbh, webView, str);
                }
            };

            public void run() {
                if (webView.getSettings().getJavaScriptEnabled()) {
                    try {
                        webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzrE);
                    } catch (Throwable th) {
                        this.zzrE.onReceiveValue("");
                    }
                }
            }
        });
        return true;
    }

    public void zzcp() {
        synchronized (this.zzqt) {
            if (this.mStarted) {
                zzb.zzay("Content hash thread already started, quiting...");
                return;
            }
            this.mStarted = true;
            start();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzcq() {
        try {
            Context context = this.zzrw.getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (Process.myPid() == next.pid) {
                    if (zza(next) && !keyguardManager.inKeyguardRestrictedInputMode() && zzr(context)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public zzbh zzcr() {
        return this.zzrx.zzco();
    }

    public void zzcs() {
        synchronized (this.zzqt) {
            this.zzrv = true;
            zzb.zzay("ContentFetchThread: paused, mPause = " + this.zzrv);
        }
    }

    public boolean zzct() {
        return this.zzrv;
    }

    /* access modifiers changed from: package-private */
    public boolean zzf(final View view) {
        if (view == null) {
            return false;
        }
        view.post(new Runnable() {
            /* class com.google.android.gms.internal.zzbk.AnonymousClass1 */

            public void run() {
                zzbk.this.zzg(view);
            }
        });
        return true;
    }

    /* access modifiers changed from: package-private */
    public void zzg(View view) {
        try {
            zzbh zzbh = new zzbh(this.zzrj, this.zzrA, this.zzrl, this.zzrB);
            zza zza2 = zza(view, zzbh);
            zzbh.zzcm();
            if (zza2.zzrI != 0 || zza2.zzrJ != 0) {
                if (zza2.zzrJ != 0 || zzbh.zzcn() != 0) {
                    if (zza2.zzrJ != 0 || !this.zzrx.zza(zzbh)) {
                        this.zzrx.zzc(zzbh);
                    }
                }
            }
        } catch (Exception e) {
            zzb.zzb("Exception in fetchContentOnUIThread", e);
            this.zzry.zza(e, true);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzr(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return false;
        }
        return powerManager.isScreenOn();
    }
}
