package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.internal.zzdt;
import com.google.android.gms.internal.zzhx;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public class zzaz implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private boolean zzpj = false;
    private final WeakReference<View> zzqA;
    private final zzax zzqB;
    private final zzdt zzqC;
    private final zzdt.zzd zzqD;
    private boolean zzqE;
    private final WindowManager zzqF;
    private final PowerManager zzqG;
    private final KeyguardManager zzqH;
    private zzba zzqI;
    private boolean zzqJ;
    private boolean zzqK = false;
    private boolean zzqL;
    private boolean zzqM;
    private BroadcastReceiver zzqN;
    private final HashSet<zzaw> zzqO = new HashSet<>();
    private final zzdg zzqP = new zzdg() {
        /* class com.google.android.gms.internal.zzaz.AnonymousClass6 */

        @Override // com.google.android.gms.internal.zzdg
        public void zza(zzid zzid, Map<String, String> map) {
            if (zzaz.this.zzb(map)) {
                zzaz.this.zza(zzid.getWebView(), map);
            }
        }
    };
    private final zzdg zzqQ = new zzdg() {
        /* class com.google.android.gms.internal.zzaz.AnonymousClass7 */

        @Override // com.google.android.gms.internal.zzdg
        public void zza(zzid zzid, Map<String, String> map) {
            if (zzaz.this.zzb(map)) {
                zzb.zzay("Received request to untrack: " + zzaz.this.zzqB.zzbT());
                zzaz.this.destroy();
            }
        }
    };
    private final zzdg zzqR = new zzdg() {
        /* class com.google.android.gms.internal.zzaz.AnonymousClass8 */

        @Override // com.google.android.gms.internal.zzdg
        public void zza(zzid zzid, Map<String, String> map) {
            if (zzaz.this.zzb(map) && map.containsKey("isVisible")) {
                zzaz.this.zzg(Boolean.valueOf("1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible"))).booleanValue());
            }
        }
    };
    private zzhq zzqm;
    private final Object zzqt = new Object();
    private final Context zzqw;
    private final WeakReference<zzha> zzqy;
    private WeakReference<ViewTreeObserver> zzqz;

    public zzaz(AdSizeParcel adSizeParcel, zzha zzha, VersionInfoParcel versionInfoParcel, View view, zzdt zzdt) {
        this.zzqC = zzdt;
        this.zzqy = new WeakReference<>(zzha);
        this.zzqA = new WeakReference<>(view);
        this.zzqz = new WeakReference<>(null);
        this.zzqL = true;
        this.zzqm = new zzhq(200);
        this.zzqB = new zzax(UUID.randomUUID().toString(), versionInfoParcel, adSizeParcel.zzsm, zzha.zzFl, zzha.zzbU());
        this.zzqD = this.zzqC.zzdU();
        this.zzqF = (WindowManager) view.getContext().getSystemService("window");
        this.zzqG = (PowerManager) view.getContext().getApplicationContext().getSystemService("power");
        this.zzqH = (KeyguardManager) view.getContext().getSystemService("keyguard");
        this.zzqw = view.getContext().getApplicationContext();
        try {
            final JSONObject zzd = zzd(view);
            this.zzqD.zza(new zzhx.zzc<zzbe>() {
                /* class com.google.android.gms.internal.zzaz.AnonymousClass1 */

                /* renamed from: zzb */
                public void zzc(zzbe zzbe) {
                    zzaz.this.zza(zzd);
                }
            }, new zzhx.zza() {
                /* class com.google.android.gms.internal.zzaz.AnonymousClass2 */

                @Override // com.google.android.gms.internal.zzhx.zza
                public void run() {
                }
            });
        } catch (JSONException e) {
        } catch (RuntimeException e2) {
            zzb.zzb("Failure while processing active view data.", e2);
        }
        this.zzqD.zza(new zzhx.zzc<zzbe>() {
            /* class com.google.android.gms.internal.zzaz.AnonymousClass3 */

            /* renamed from: zzb */
            public void zzc(zzbe zzbe) {
                zzaz.this.zzqE = true;
                zzaz.this.zza(zzbe);
                zzaz.this.zzbV();
                zzaz.this.zzh(false);
            }
        }, new zzhx.zza() {
            /* class com.google.android.gms.internal.zzaz.AnonymousClass4 */

            @Override // com.google.android.gms.internal.zzhx.zza
            public void run() {
                zzaz.this.destroy();
            }
        });
        zzb.zzay("Tracking ad unit: " + this.zzqB.zzbT());
    }

    /* access modifiers changed from: protected */
    public void destroy() {
        synchronized (this.zzqt) {
            zzcb();
            zzbW();
            this.zzqL = false;
            zzbY();
            this.zzqD.release();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isScreenOn() {
        return this.zzqG.isScreenOn();
    }

    public void onGlobalLayout() {
        zzh(false);
    }

    public void onScrollChanged() {
        zzh(true);
    }

    public void pause() {
        synchronized (this.zzqt) {
            this.zzpj = true;
            zzh(false);
        }
    }

    public void resume() {
        synchronized (this.zzqt) {
            this.zzpj = false;
            zzh(false);
        }
    }

    public void stop() {
        synchronized (this.zzqt) {
            this.zzqK = true;
            zzh(false);
        }
    }

    /* access modifiers changed from: protected */
    public int zza(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    /* access modifiers changed from: protected */
    public void zza(View view, Map<String, String> map) {
        zzh(false);
    }

    public void zza(zzaw zzaw) {
        this.zzqO.add(zzaw);
    }

    public void zza(zzba zzba) {
        synchronized (this.zzqt) {
            this.zzqI = zzba;
        }
    }

    /* access modifiers changed from: protected */
    public void zza(zzbe zzbe) {
        zzbe.zza("/updateActiveView", this.zzqP);
        zzbe.zza("/untrackActiveViewUnit", this.zzqQ);
        zzbe.zza("/visibilityChanged", this.zzqR);
    }

    /* access modifiers changed from: protected */
    public void zza(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = new JSONArray();
            final JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(jSONObject);
            jSONObject2.put("units", jSONArray);
            this.zzqD.zza(new zzhx.zzc<zzbe>() {
                /* class com.google.android.gms.internal.zzaz.AnonymousClass9 */

                /* renamed from: zzb */
                public void zzc(zzbe zzbe) {
                    zzbe.zza("AFMA_updateActiveView", jSONObject2);
                }
            }, new zzhx.zzb());
        } catch (Throwable th) {
            zzb.zzb("Skipping active view message.", th);
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzb(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.zzqB.zzbT());
    }

    /* access modifiers changed from: protected */
    public void zzbV() {
        synchronized (this.zzqt) {
            if (this.zzqN == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                this.zzqN = new BroadcastReceiver() {
                    /* class com.google.android.gms.internal.zzaz.AnonymousClass5 */

                    public void onReceive(Context context, Intent intent) {
                        zzaz.this.zzh(false);
                    }
                };
                this.zzqw.registerReceiver(this.zzqN, intentFilter);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzbW() {
        synchronized (this.zzqt) {
            if (this.zzqN != null) {
                this.zzqw.unregisterReceiver(this.zzqN);
                this.zzqN = null;
            }
        }
    }

    public void zzbX() {
        synchronized (this.zzqt) {
            if (this.zzqL) {
                this.zzqM = true;
                try {
                    zza(zzcd());
                } catch (JSONException e) {
                    zzb.zzb("JSON failure while processing active view data.", e);
                } catch (RuntimeException e2) {
                    zzb.zzb("Failure while processing active view data.", e2);
                }
                zzb.zzay("Untracking ad unit: " + this.zzqB.zzbT());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzbY() {
        if (this.zzqI != null) {
            this.zzqI.zza(this);
        }
    }

    public boolean zzbZ() {
        boolean z;
        synchronized (this.zzqt) {
            z = this.zzqL;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public void zzca() {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        View view = this.zzqA.get();
        if (view != null && (viewTreeObserver2 = view.getViewTreeObserver()) != (viewTreeObserver = this.zzqz.get())) {
            zzcb();
            if (!this.zzqJ || (viewTreeObserver != null && viewTreeObserver.isAlive())) {
                this.zzqJ = true;
                viewTreeObserver2.addOnScrollChangedListener(this);
                viewTreeObserver2.addOnGlobalLayoutListener(this);
            }
            this.zzqz = new WeakReference<>(viewTreeObserver2);
        }
    }

    /* access modifiers changed from: protected */
    public void zzcb() {
        ViewTreeObserver viewTreeObserver = this.zzqz.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    /* access modifiers changed from: protected */
    public JSONObject zzcc() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.zzqB.zzbR()).put("activeViewJSON", this.zzqB.zzbS()).put("timestamp", zzo.zzbz().elapsedRealtime()).put("adFormat", this.zzqB.zzbQ()).put("hashCode", this.zzqB.zzbT()).put("isMraid", this.zzqB.zzbU());
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    public JSONObject zzcd() throws JSONException {
        JSONObject zzcc = zzcc();
        zzcc.put("doneReasonCode", "u");
        return zzcc;
    }

    /* access modifiers changed from: protected */
    public JSONObject zzd(View view) throws JSONException {
        boolean zzk = zzo.zzbx().zzk(view);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            view.getLocationInWindow(iArr2);
        } catch (Exception e) {
            zzb.zzb("Failure getting view location.", e);
        }
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        rect2.right = this.zzqF.getDefaultDisplay().getWidth();
        rect2.bottom = this.zzqF.getDefaultDisplay().getHeight();
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, null);
        Rect rect4 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect4);
        Rect rect5 = new Rect();
        view.getHitRect(rect5);
        JSONObject zzcc = zzcc();
        zzcc.put("windowVisibility", view.getWindowVisibility()).put("isStopped", this.zzqK).put("isPaused", this.zzpj).put("isAttachedToWindow", zzk).put("viewBox", new JSONObject().put("top", zza(rect2.top, displayMetrics)).put("bottom", zza(rect2.bottom, displayMetrics)).put("left", zza(rect2.left, displayMetrics)).put("right", zza(rect2.right, displayMetrics))).put("adBox", new JSONObject().put("top", zza(rect.top, displayMetrics)).put("bottom", zza(rect.bottom, displayMetrics)).put("left", zza(rect.left, displayMetrics)).put("right", zza(rect.right, displayMetrics))).put("globalVisibleBox", new JSONObject().put("top", zza(rect3.top, displayMetrics)).put("bottom", zza(rect3.bottom, displayMetrics)).put("left", zza(rect3.left, displayMetrics)).put("right", zza(rect3.right, displayMetrics))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", zza(rect4.top, displayMetrics)).put("bottom", zza(rect4.bottom, displayMetrics)).put("left", zza(rect4.left, displayMetrics)).put("right", zza(rect4.right, displayMetrics))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", zza(rect5.top, displayMetrics)).put("bottom", zza(rect5.bottom, displayMetrics)).put("left", zza(rect5.left, displayMetrics)).put("right", zza(rect5.right, displayMetrics))).put("screenDensity", (double) displayMetrics.density).put("isVisible", zze(view));
        return zzcc;
    }

    /* access modifiers changed from: protected */
    public boolean zze(View view) {
        return view.getVisibility() == 0 && view.isShown() && isScreenOn() && (!this.zzqH.inKeyguardRestrictedInputMode() || zzo.zzbv().zzgl());
    }

    /* access modifiers changed from: protected */
    public void zzg(boolean z) {
        Iterator<zzaw> it = this.zzqO.iterator();
        while (it.hasNext()) {
            it.next().zza(this, z);
        }
    }

    /* access modifiers changed from: protected */
    public void zzh(boolean z) {
        synchronized (this.zzqt) {
            if (this.zzqE && this.zzqL) {
                if (!z || this.zzqm.tryAcquire()) {
                    zzha zzha = this.zzqy.get();
                    View view = this.zzqA.get();
                    if (view == null || zzha == null) {
                        zzbX();
                        return;
                    }
                    try {
                        zza(zzd(view));
                    } catch (RuntimeException | JSONException e) {
                        zzb.zza("Active view update failed.", e);
                    }
                    zzca();
                    zzbY();
                }
            }
        }
    }
}
