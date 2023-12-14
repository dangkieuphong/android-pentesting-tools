package com.google.android.gms.ads.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.client.zzt;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.ads.internal.request.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzaw;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzaz;
import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbk;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzcd;
import com.google.android.gms.internal.zzce;
import com.google.android.gms.internal.zzci;
import com.google.android.gms.internal.zzde;
import com.google.android.gms.internal.zzff;
import com.google.android.gms.internal.zzfj;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzhe;
import com.google.android.gms.internal.zzhf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@zzgd
public abstract class zza extends zzr.zza implements com.google.android.gms.ads.internal.client.zza, zzk, zza.AbstractC0012zza, zzaw, zzde, zzft.zza, zzhe {
    private zzce zzoj;
    private zzcd zzok;
    private zzcd zzol;
    protected final zzn zzom;
    protected final zzp zzon;
    protected transient AdRequestParcel zzoo;
    protected final zzay zzop;

    zza(zzp zzp, zzn zzn) {
        this.zzon = zzp;
        this.zzom = zzn == null ? new zzn(this) : zzn;
        zzo.zzbv().zzH(this.zzon.zzpH);
        zzo.zzby().zzb(this.zzon.zzpH, this.zzon.zzpJ);
        this.zzop = zzo.zzby().zzgd();
    }

    private boolean zzaR() {
        zzb.zzaA("Ad leaving application.");
        if (this.zzon.zzpS == null) {
            return false;
        }
        try {
            this.zzon.zzpS.onAdLeftApplication();
            return true;
        } catch (RemoteException e) {
            zzb.zzd("Could not call AdListener.onAdLeftApplication().", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public void destroy() {
        zzu.zzbY("destroy must be called on the main UI thread.");
        this.zzom.cancel();
        this.zzop.zzh(this.zzon.zzpO);
        this.zzon.destroy();
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public boolean isReady() {
        zzu.zzbY("isLoaded must be called on the main UI thread.");
        return this.zzon.zzpL == null && this.zzon.zzpM == null && this.zzon.zzpO != null;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public void onAdClicked() {
        if (this.zzon.zzpO == null) {
            zzb.zzaC("Ad state was null when trying to ping click URLs.");
            return;
        }
        zzb.zzay("Pinging click URLs.");
        this.zzon.zzpQ.zzfQ();
        if (this.zzon.zzpO.zzxF != null) {
            zzo.zzbv().zza(this.zzon.zzpH, this.zzon.zzpJ.zzGG, zza(this.zzon.zzpO.zzxF, this.zzon.zzpO.zzCC));
        }
        if (this.zzon.zzpR != null) {
            try {
                this.zzon.zzpR.onAdClicked();
            } catch (RemoteException e) {
                zzb.zzd("Could not notify onAdClicked event.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzde
    public void onAppEvent(String name, String info) {
        if (this.zzon.zzpT != null) {
            try {
                this.zzon.zzpT.onAppEvent(name, info);
            } catch (RemoteException e) {
                zzb.zzd("Could not call the AppEventListener.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public void pause() {
        zzu.zzbY("pause must be called on the main UI thread.");
    }

    /* access modifiers changed from: protected */
    public void recordImpression() {
        zzc(this.zzon.zzpO);
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public void resume() {
        zzu.zzbY("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public void stopLoading() {
        zzu.zzbY("stopLoading must be called on the main UI thread.");
        this.zzon.zzf(true);
    }

    /* access modifiers changed from: package-private */
    public Bundle zza(zzbk zzbk) {
        String str;
        if (zzbk == null) {
            return null;
        }
        if (zzbk.zzct()) {
            zzbk.wakeup();
        }
        zzbh zzcr = zzbk.zzcr();
        if (zzcr != null) {
            str = zzcr.zzci();
            zzb.zzay("In AdManger: loadAd, " + zzcr.toString());
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        Bundle bundle = new Bundle(1);
        bundle.putString("fingerprint", str);
        bundle.putInt("v", 1);
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public String zza(String str, String str2, int i) {
        return (!zzbz.zzun.get().booleanValue() || !zzl.zzq(this.zzon.zzpH).zzbl() || TextUtils.isEmpty(str)) ? str : Uri.parse(str).buildUpon().appendQueryParameter("ga_cid", str2).appendQueryParameter("ga_hid", String.valueOf(i)).build().toString();
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String> zza(List<String> list, String str) {
        int zzbn = zzl.zzq(this.zzon.zzpH).zzbn();
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : list) {
            arrayList.add(zza(str2, str, zzbn));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public void zza(AdSizeParcel adSizeParcel) {
        zzu.zzbY("setAdSize must be called on the main UI thread.");
        this.zzon.zzpN = adSizeParcel;
        if (this.zzon.zzpO != null && this.zzon.zzqh == 0) {
            this.zzon.zzpO.zzzE.zza(adSizeParcel);
        }
        if (this.zzon.zzpK != null) {
            if (this.zzon.zzpK.getChildCount() > 1) {
                this.zzon.zzpK.removeView(this.zzon.zzpK.getNextView());
            }
            this.zzon.zzpK.setMinimumWidth(adSizeParcel.widthPixels);
            this.zzon.zzpK.setMinimumHeight(adSizeParcel.heightPixels);
            this.zzon.zzpK.requestLayout();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public void zza(zzm zzm) {
        zzu.zzbY("setAdListener must be called on the main UI thread.");
        this.zzon.zzpR = zzm;
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public void zza(zzn zzn) {
        zzu.zzbY("setAdListener must be called on the main UI thread.");
        this.zzon.zzpS = zzn;
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public void zza(zzt zzt) {
        zzu.zzbY("setAppEventListener must be called on the main UI thread.");
        this.zzon.zzpT = zzt;
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public void zza(com.google.android.gms.ads.internal.client.zzu zzu) {
        zzu.zzbY("setCorrelationIdProvider must be called on the main UI thread");
        this.zzon.zzpU = zzu;
    }

    @Override // com.google.android.gms.internal.zzaw
    public void zza(zzaz zzaz, boolean z) {
        if (this.zzon.zzpO != null && this.zzon.zzpO.zzzE != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("isVisible", z ? "1" : "0");
            this.zzon.zzpO.zzzE.zzc("onAdVisibilityChanged", hashMap);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public void zza(zzci zzci) {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public void zza(zzff zzff) {
        throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public void zza(zzfj zzfj, String str) {
        throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
    }

    @Override // com.google.android.gms.ads.internal.request.zza.AbstractC0012zza
    public void zza(zzha.zza zza) {
        this.zzoj.zza(this.zzok, "arf");
        this.zzol = this.zzoj.zzdo();
        this.zzon.zzpL = null;
        this.zzon.zzpP = zza;
        if (zzb(zza)) {
            zzb.zzay("AdRenderer: " + this.zzon.zzpM.getClass().getName());
        }
    }

    @Override // com.google.android.gms.internal.zzhe
    public void zza(HashSet<zzhb> hashSet) {
        this.zzon.zza(hashSet);
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public boolean zza(AdRequestParcel adRequestParcel) {
        zzu.zzbY("loadAd must be called on the main UI thread.");
        if (this.zzon.zzpL == null && this.zzon.zzpM == null) {
            zzb.zzaA("Starting ad request.");
            zzaL();
            this.zzok = this.zzoj.zzdo();
            if (!adRequestParcel.zzsa) {
                zzb.zzaA("Use AdRequest.Builder.addTestDevice(\"" + com.google.android.gms.ads.internal.client.zzk.zzcA().zzO(this.zzon.zzpH) + "\") to get test ads on this device.");
            }
            return zzb(adRequestParcel);
        }
        if (this.zzoo != null) {
            zzb.zzaC("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
        }
        this.zzoo = adRequestParcel;
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean zza(zzha zzha) {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(zzha zzha, zzha zzha2);

    /* access modifiers changed from: package-private */
    public void zzaL() {
        this.zzoj = new zzce("load_ad");
        this.zzok = new zzcd(-1, null, null);
        this.zzol = new zzcd(-1, null, null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public zzd zzaM() {
        zzu.zzbY("getAdFrame must be called on the main UI thread.");
        return zze.zzw(this.zzon.zzpK);
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public AdSizeParcel zzaN() {
        zzu.zzbY("getAdSize must be called on the main UI thread.");
        return this.zzon.zzpN;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzk
    public void zzaO() {
        zzaR();
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public void zzaP() {
        zzu.zzbY("recordManualImpression must be called on the main UI thread.");
        if (this.zzon.zzpO == null) {
            zzb.zzaC("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        zzb.zzay("Pinging manual tracking URLs.");
        if (this.zzon.zzpO.zzCM != null) {
            zzo.zzbv().zza(this.zzon.zzpH, this.zzon.zzpJ.zzGG, this.zzon.zzpO.zzCM);
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzaQ() {
        zzb.zzaB("Ad closing.");
        if (this.zzon.zzpS == null) {
            return false;
        }
        try {
            this.zzon.zzpS.onAdClosed();
            return true;
        } catch (RemoteException e) {
            zzb.zzd("Could not call AdListener.onAdClosed().", e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzaS() {
        zzb.zzaA("Ad opening.");
        if (this.zzon.zzpS == null) {
            return false;
        }
        try {
            this.zzon.zzpS.onAdOpened();
            return true;
        } catch (RemoteException e) {
            zzb.zzd("Could not call AdListener.onAdOpened().", e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzaT() {
        zzb.zzaA("Ad finished loading.");
        if (this.zzon.zzpS == null) {
            return false;
        }
        try {
            this.zzon.zzpS.onAdLoaded();
            return true;
        } catch (RemoteException e) {
            zzb.zzd("Could not call AdListener.onAdLoaded().", e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void zzb(View view) {
        this.zzon.zzpK.addView(view, zzo.zzbx().zzgt());
    }

    @Override // com.google.android.gms.internal.zzft.zza
    public void zzb(zzha zzha) {
        this.zzoj.zza(this.zzol, "awr");
        this.zzoj.zza(this.zzok, "ttc");
        this.zzon.zzpM = null;
        if (!(zzha.errorCode == -2 || zzha.errorCode == 3)) {
            zzo.zzby().zzb(this.zzon.zzbI());
        }
        if (zzha.errorCode != -1) {
            if (zza(zzha)) {
                zzb.zzay("Ad refresh scheduled.");
            }
            if (zzha.errorCode != -2) {
                zze(zzha.errorCode);
                return;
            }
            if (this.zzon.zzqf == null) {
                this.zzon.zzqf = new zzhf(this.zzon.zzpG);
            }
            this.zzop.zzg(this.zzon.zzpO);
            if (zza(this.zzon.zzpO, zzha)) {
                this.zzon.zzpO = zzha;
                this.zzon.zzbO();
                if (zzo.zzby().zzfY() != null) {
                    zzo.zzby().zzfY().zza(this.zzoj);
                }
                if (this.zzon.zzbM()) {
                    zzaT();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzb(AdRequestParcel adRequestParcel);

    /* access modifiers changed from: protected */
    public abstract boolean zzb(zzha.zza zza);

    /* access modifiers changed from: protected */
    public void zzc(zzha zzha) {
        if (zzha == null) {
            zzb.zzaC("Ad state was null when trying to ping impression URLs.");
            return;
        }
        zzb.zzay("Pinging Impression URLs.");
        this.zzon.zzpQ.zzfP();
        if (zzha.zzxG != null) {
            zzo.zzbv().zza(this.zzon.zzpH, this.zzon.zzpJ.zzGG, zza(zzha.zzxG, zzha.zzCC));
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzc(AdRequestParcel adRequestParcel) {
        ViewParent parent = this.zzon.zzpK.getParent();
        return (parent instanceof View) && ((View) parent).isShown() && zzo.zzbv().zzgl();
    }

    public void zzd(AdRequestParcel adRequestParcel) {
        if (zzc(adRequestParcel)) {
            zza(adRequestParcel);
            return;
        }
        zzb.zzaA("Ad is not visible. Not refreshing ad.");
        this.zzom.zzf(adRequestParcel);
    }

    /* access modifiers changed from: protected */
    public boolean zze(int i) {
        zzb.zzaC("Failed to load ad: " + i);
        if (this.zzon.zzpS == null) {
            return false;
        }
        try {
            this.zzon.zzpS.onAdFailedToLoad(i);
            return true;
        } catch (RemoteException e) {
            zzb.zzd("Could not call AdListener.onAdFailedToLoad().", e);
            return false;
        }
    }
}
