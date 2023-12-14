package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzck;
import java.util.ArrayList;
import java.util.List;

@zzgd
public class zzcp extends NativeAppInstallAd {
    private final zzco zzvK;
    private final List<NativeAd.Image> zzvL = new ArrayList();
    private final zzcl zzvM;

    public zzcp(zzco zzco) {
        zzcl zzcl;
        this.zzvK = zzco;
        try {
            for (Object obj : this.zzvK.getImages()) {
                zzck zzd = zzd(obj);
                if (zzd != null) {
                    this.zzvL.add(new zzcl(zzd));
                }
            }
        } catch (RemoteException e) {
            zzb.zzb("Failed to get image.", e);
        }
        try {
            zzck zzdy = this.zzvK.zzdy();
            if (zzdy != null) {
                zzcl = new zzcl(zzdy);
                this.zzvM = zzcl;
            }
        } catch (RemoteException e2) {
            zzb.zzb("Failed to get icon.", e2);
        }
        zzcl = null;
        this.zzvM = zzcl;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public CharSequence getBody() {
        try {
            return this.zzvK.getBody();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get body.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public CharSequence getCallToAction() {
        try {
            return this.zzvK.zzdz();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get call to action.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public CharSequence getHeadline() {
        try {
            return this.zzvK.zzdx();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get headline.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public NativeAd.Image getIcon() {
        return this.zzvM;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public List<NativeAd.Image> getImages() {
        return this.zzvL;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public CharSequence getPrice() {
        try {
            return this.zzvK.zzdC();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get price.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public Double getStarRating() {
        try {
            double zzdA = this.zzvK.zzdA();
            if (zzdA == -1.0d) {
                return null;
            }
            return Double.valueOf(zzdA);
        } catch (RemoteException e) {
            zzb.zzb("Failed to get star rating.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public CharSequence getStore() {
        try {
            return this.zzvK.zzdB();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get store", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public zzck zzd(Object obj) {
        if (obj instanceof IBinder) {
            return zzck.zza.zzt((IBinder) obj);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdD */
    public zzd zzaH() {
        try {
            return this.zzvK.zzdD();
        } catch (RemoteException e) {
            zzb.zzb("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
