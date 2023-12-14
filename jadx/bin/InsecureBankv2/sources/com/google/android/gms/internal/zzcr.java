package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzck;
import java.util.ArrayList;
import java.util.List;

@zzgd
public class zzcr extends NativeContentAd {
    private final List<NativeAd.Image> zzvL = new ArrayList();
    private final zzcq zzvN;
    private final zzcl zzvO;

    public zzcr(zzcq zzcq) {
        zzcl zzcl;
        this.zzvN = zzcq;
        try {
            for (Object obj : this.zzvN.getImages()) {
                zzck zzd = zzd(obj);
                if (zzd != null) {
                    this.zzvL.add(new zzcl(zzd));
                }
            }
        } catch (RemoteException e) {
            zzb.zzb("Failed to get image.", e);
        }
        try {
            zzck zzdG = this.zzvN.zzdG();
            if (zzdG != null) {
                zzcl = new zzcl(zzdG);
                this.zzvO = zzcl;
            }
        } catch (RemoteException e2) {
            zzb.zzb("Failed to get icon.", e2);
        }
        zzcl = null;
        this.zzvO = zzcl;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public CharSequence getAdvertiser() {
        try {
            return this.zzvN.zzdH();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get attribution.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public CharSequence getBody() {
        try {
            return this.zzvN.getBody();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get body.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public CharSequence getCallToAction() {
        try {
            return this.zzvN.zzdz();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get call to action.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public CharSequence getHeadline() {
        try {
            return this.zzvN.zzdx();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get headline.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public List<NativeAd.Image> getImages() {
        return this.zzvL;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public NativeAd.Image getLogo() {
        return this.zzvO;
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
            return this.zzvN.zzdD();
        } catch (RemoteException e) {
            zzb.zzb("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
