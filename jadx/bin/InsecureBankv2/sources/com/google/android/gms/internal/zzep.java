package com.google.android.gms.internal;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzgd
public class zzep extends zzeu {
    static final Set<String> zzyu = new HashSet(Arrays.asList("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center"));
    private int zznM = -1;
    private int zznN = -1;
    private final zzid zzoA;
    private final Object zzqt = new Object();
    private AdSizeParcel zzxT;
    private int zzyA = 0;
    private final Activity zzyB;
    private ImageView zzyC;
    private LinearLayout zzyD;
    private zzev zzyE;
    private PopupWindow zzyF;
    private RelativeLayout zzyG;
    private ViewGroup zzyH;
    private String zzyv = "top-right";
    private boolean zzyw = true;
    private int zzyx = 0;
    private int zzyy = 0;
    private int zzyz = 0;

    public zzep(zzid zzid, zzev zzev) {
        super(zzid, "resize");
        this.zzoA = zzid;
        this.zzyB = zzid.zzgB();
        this.zzyE = zzev;
    }

    private int[] zzed() {
        if (!zzef()) {
            return null;
        }
        if (this.zzyw) {
            return new int[]{this.zzyx + this.zzyz, this.zzyy + this.zzyA};
        }
        int[] zzh = zzo.zzbv().zzh(this.zzyB);
        int[] zzj = zzo.zzbv().zzj(this.zzyB);
        int i = zzh[0];
        int i2 = this.zzyx + this.zzyz;
        int i3 = this.zzyy + this.zzyA;
        if (i2 < 0) {
            i2 = 0;
        } else if (this.zznM + i2 > i) {
            i2 = i - this.zznM;
        }
        if (i3 < zzj[0]) {
            i3 = zzj[0];
        } else if (this.zznN + i3 > zzj[1]) {
            i3 = zzj[1] - this.zznN;
        }
        return new int[]{i2, i3};
    }

    private void zzg(Map<String, String> map) {
        if (!TextUtils.isEmpty(map.get("width"))) {
            this.zznM = zzo.zzbv().zzau(map.get("width"));
        }
        if (!TextUtils.isEmpty(map.get("height"))) {
            this.zznN = zzo.zzbv().zzau(map.get("height"));
        }
        if (!TextUtils.isEmpty(map.get("offsetX"))) {
            this.zzyz = zzo.zzbv().zzau(map.get("offsetX"));
        }
        if (!TextUtils.isEmpty(map.get("offsetY"))) {
            this.zzyA = zzo.zzbv().zzau(map.get("offsetY"));
        }
        if (!TextUtils.isEmpty(map.get("allowOffscreen"))) {
            this.zzyw = Boolean.parseBoolean(map.get("allowOffscreen"));
        }
        String str = map.get("customClosePosition");
        if (!TextUtils.isEmpty(str)) {
            this.zzyv = str;
        }
    }

    public void zza(int i, int i2, boolean z) {
        synchronized (this.zzqt) {
            this.zzyx = i;
            this.zzyy = i2;
            if (this.zzyF != null && z) {
                int[] zzed = zzed();
                if (zzed != null) {
                    this.zzyF.update(zzk.zzcA().zzb(this.zzyB, zzed[0]), zzk.zzcA().zzb(this.zzyB, zzed[1]), this.zzyF.getWidth(), this.zzyF.getHeight());
                    zzc(zzed[0], zzed[1]);
                } else {
                    zzn(true);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void zzb(int i, int i2) {
        if (this.zzyE != null) {
            this.zzyE.zza(i, i2, this.zznM, this.zznN);
        }
    }

    /* access modifiers changed from: package-private */
    public void zzc(int i, int i2) {
        zzb(i, i2 - zzo.zzbv().zzj(this.zzyB)[0], this.zznM, this.zznN);
    }

    public void zzd(int i, int i2) {
        this.zzyx = i;
        this.zzyy = i2;
    }

    /* access modifiers changed from: package-private */
    public boolean zzec() {
        return this.zznM > -1 && this.zznN > -1;
    }

    public boolean zzee() {
        boolean z;
        synchronized (this.zzqt) {
            z = this.zzyF != null;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean zzef() {
        int i;
        int i2;
        int[] zzh = zzo.zzbv().zzh(this.zzyB);
        int[] zzj = zzo.zzbv().zzj(this.zzyB);
        int i3 = zzh[0];
        int i4 = zzh[1];
        if (this.zznM < 50 || this.zznM > i3) {
            zzb.zzaC("Width is too small or too large.");
            return false;
        } else if (this.zznN < 50 || this.zznN > i4) {
            zzb.zzaC("Height is too small or too large.");
            return false;
        } else if (this.zznN == i4 && this.zznM == i3) {
            zzb.zzaC("Cannot resize to a full-screen ad.");
            return false;
        } else {
            if (this.zzyw) {
                String str = this.zzyv;
                char c = 65535;
                switch (str.hashCode()) {
                    case -1364013995:
                        if (str.equals("center")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1012429441:
                        if (str.equals("top-left")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -655373719:
                        if (str.equals("bottom-left")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 1163912186:
                        if (str.equals("bottom-right")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 1288627767:
                        if (str.equals("bottom-center")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 1755462605:
                        if (str.equals("top-center")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        i = this.zzyz + this.zzyx;
                        i2 = this.zzyy + this.zzyA;
                        break;
                    case 1:
                        i = ((this.zzyx + this.zzyz) + (this.zznM / 2)) - 25;
                        i2 = this.zzyy + this.zzyA;
                        break;
                    case 2:
                        i = ((this.zzyx + this.zzyz) + (this.zznM / 2)) - 25;
                        i2 = ((this.zzyy + this.zzyA) + (this.zznN / 2)) - 25;
                        break;
                    case 3:
                        i = this.zzyz + this.zzyx;
                        i2 = ((this.zzyy + this.zzyA) + this.zznN) - 50;
                        break;
                    case 4:
                        i = ((this.zzyx + this.zzyz) + (this.zznM / 2)) - 25;
                        i2 = ((this.zzyy + this.zzyA) + this.zznN) - 50;
                        break;
                    case 5:
                        i = ((this.zzyx + this.zzyz) + this.zznM) - 50;
                        i2 = ((this.zzyy + this.zzyA) + this.zznN) - 50;
                        break;
                    default:
                        i = ((this.zzyx + this.zzyz) + this.zznM) - 50;
                        i2 = this.zzyy + this.zzyA;
                        break;
                }
                if (i < 0 || i + 50 > i3 || i2 < zzj[0] || i2 + 50 > zzj[1]) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public void zzh(Map<String, String> map) {
        char c;
        synchronized (this.zzqt) {
            if (this.zzyB == null) {
                zzae("Not an activity context. Cannot resize.");
            } else if (this.zzoA.zzaN() == null) {
                zzae("Webview is not yet available, size is not set.");
            } else if (this.zzoA.zzaN().zzsn) {
                zzae("Is interstitial. Cannot resize an interstitial.");
            } else if (this.zzoA.zzgJ()) {
                zzae("Cannot resize an expanded banner.");
            } else {
                zzg(map);
                if (!zzec()) {
                    zzae("Invalid width and height options. Cannot resize.");
                    return;
                }
                Window window = this.zzyB.getWindow();
                if (window == null || window.getDecorView() == null) {
                    zzae("Activity context is not ready, cannot get window or decor view.");
                    return;
                }
                int[] zzed = zzed();
                if (zzed == null) {
                    zzae("Resize location out of screen or close button is not visible.");
                    return;
                }
                int zzb = zzk.zzcA().zzb(this.zzyB, this.zznM);
                int zzb2 = zzk.zzcA().zzb(this.zzyB, this.zznN);
                ViewParent parent = this.zzoA.getWebView().getParent();
                if (parent == null || !(parent instanceof ViewGroup)) {
                    zzae("Webview is detached, probably in the middle of a resize or expand.");
                    return;
                }
                ((ViewGroup) parent).removeView(this.zzoA.getWebView());
                if (this.zzyF == null) {
                    this.zzyH = (ViewGroup) parent;
                    Bitmap zzj = zzo.zzbv().zzj(this.zzoA.getWebView());
                    this.zzyC = new ImageView(this.zzyB);
                    this.zzyC.setImageBitmap(zzj);
                    this.zzxT = this.zzoA.zzaN();
                    this.zzyH.addView(this.zzyC);
                } else {
                    this.zzyF.dismiss();
                }
                this.zzyG = new RelativeLayout(this.zzyB);
                this.zzyG.setBackgroundColor(0);
                this.zzyG.setLayoutParams(new ViewGroup.LayoutParams(zzb, zzb2));
                this.zzyF = zzo.zzbv().zza((View) this.zzyG, zzb, zzb2, false);
                this.zzyF.setOutsideTouchable(true);
                this.zzyF.setTouchable(true);
                this.zzyF.setClippingEnabled(!this.zzyw);
                this.zzyG.addView(this.zzoA.getWebView(), -1, -1);
                this.zzyD = new LinearLayout(this.zzyB);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(zzk.zzcA().zzb(this.zzyB, 50), zzk.zzcA().zzb(this.zzyB, 50));
                String str = this.zzyv;
                switch (str.hashCode()) {
                    case -1364013995:
                        if (str.equals("center")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1012429441:
                        if (str.equals("top-left")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case -655373719:
                        if (str.equals("bottom-left")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1163912186:
                        if (str.equals("bottom-right")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1288627767:
                        if (str.equals("bottom-center")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1755462605:
                        if (str.equals("top-center")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        layoutParams.addRule(10);
                        layoutParams.addRule(9);
                        break;
                    case 1:
                        layoutParams.addRule(10);
                        layoutParams.addRule(14);
                        break;
                    case 2:
                        layoutParams.addRule(13);
                        break;
                    case 3:
                        layoutParams.addRule(12);
                        layoutParams.addRule(9);
                        break;
                    case 4:
                        layoutParams.addRule(12);
                        layoutParams.addRule(14);
                        break;
                    case 5:
                        layoutParams.addRule(12);
                        layoutParams.addRule(11);
                        break;
                    default:
                        layoutParams.addRule(10);
                        layoutParams.addRule(11);
                        break;
                }
                this.zzyD.setOnClickListener(new View.OnClickListener() {
                    /* class com.google.android.gms.internal.zzep.AnonymousClass1 */

                    public void onClick(View view) {
                        zzep.this.zzn(true);
                    }
                });
                this.zzyD.setContentDescription("Close button");
                this.zzyG.addView(this.zzyD, layoutParams);
                try {
                    this.zzyF.showAtLocation(window.getDecorView(), 0, zzk.zzcA().zzb(this.zzyB, zzed[0]), zzk.zzcA().zzb(this.zzyB, zzed[1]));
                    zzb(zzed[0], zzed[1]);
                    this.zzoA.zza(new AdSizeParcel(this.zzyB, new AdSize(this.zznM, this.zznN)));
                    zzc(zzed[0], zzed[1]);
                    zzag("resized");
                } catch (RuntimeException e) {
                    zzae("Cannot show popup window: " + e.getMessage());
                    this.zzyG.removeView(this.zzoA.getWebView());
                    if (this.zzyH != null) {
                        this.zzyH.removeView(this.zzyC);
                        this.zzyH.addView(this.zzoA.getWebView());
                        this.zzoA.zza(this.zzxT);
                    }
                }
            }
        }
    }

    public void zzn(boolean z) {
        synchronized (this.zzqt) {
            if (this.zzyF != null) {
                this.zzyF.dismiss();
                this.zzyG.removeView(this.zzoA.getWebView());
                if (this.zzyH != null) {
                    this.zzyH.removeView(this.zzyC);
                    this.zzyH.addView(this.zzoA.getWebView());
                    this.zzoA.zza(this.zzxT);
                }
                if (z) {
                    zzag("default");
                    if (this.zzyE != null) {
                        this.zzyE.zzbc();
                    }
                }
                this.zzyF = null;
                this.zzyG = null;
                this.zzyH = null;
                this.zzyD = null;
            }
        }
    }
}
