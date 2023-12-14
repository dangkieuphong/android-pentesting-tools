package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzgd
public class zzcl implements NativeAd.Image {
    private final Uri mUri;
    private final zzck zzvI;
    private final Drawable zzvJ;

    public zzcl(zzck zzck) {
        Drawable drawable;
        Uri uri = null;
        this.zzvI = zzck;
        try {
            zzd zzdw = this.zzvI.zzdw();
            if (zzdw != null) {
                drawable = (Drawable) zze.zzn(zzdw);
                this.zzvJ = drawable;
                uri = this.zzvI.getUri();
                this.mUri = uri;
            }
        } catch (RemoteException e) {
            zzb.zzb("Failed to get drawable.", e);
        }
        drawable = null;
        this.zzvJ = drawable;
        try {
            uri = this.zzvI.getUri();
        } catch (RemoteException e2) {
            zzb.zzb("Failed to get uri.", e2);
        }
        this.mUri = uri;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public Drawable getDrawable() {
        return this.zzvJ;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public Uri getUri() {
        return this.mUri;
    }
}
