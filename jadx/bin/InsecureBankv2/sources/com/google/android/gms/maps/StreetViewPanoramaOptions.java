package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    private final int zzCY;
    private Boolean zzaBJ;
    private Boolean zzaBP;
    private Boolean zzaCA;
    private Boolean zzaCB;
    private StreetViewPanoramaCamera zzaCv;
    private String zzaCw;
    private LatLng zzaCx;
    private Integer zzaCy;
    private Boolean zzaCz;

    public StreetViewPanoramaOptions() {
        this.zzaCz = true;
        this.zzaBP = true;
        this.zzaCA = true;
        this.zzaCB = true;
        this.zzCY = 1;
    }

    StreetViewPanoramaOptions(int versionCode, StreetViewPanoramaCamera camera, String panoId, LatLng position, Integer radius, byte userNavigationEnabled, byte zoomGesturesEnabled, byte panningGesturesEnabled, byte streetNamesEnabled, byte useViewLifecycleInFragment) {
        this.zzaCz = true;
        this.zzaBP = true;
        this.zzaCA = true;
        this.zzaCB = true;
        this.zzCY = versionCode;
        this.zzaCv = camera;
        this.zzaCx = position;
        this.zzaCy = radius;
        this.zzaCw = panoId;
        this.zzaCz = zza.zza(userNavigationEnabled);
        this.zzaBP = zza.zza(zoomGesturesEnabled);
        this.zzaCA = zza.zza(panningGesturesEnabled);
        this.zzaCB = zza.zza(streetNamesEnabled);
        this.zzaBJ = zza.zza(useViewLifecycleInFragment);
    }

    public int describeContents() {
        return 0;
    }

    public Boolean getPanningGesturesEnabled() {
        return this.zzaCA;
    }

    public String getPanoramaId() {
        return this.zzaCw;
    }

    public LatLng getPosition() {
        return this.zzaCx;
    }

    public Integer getRadius() {
        return this.zzaCy;
    }

    public Boolean getStreetNamesEnabled() {
        return this.zzaCB;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.zzaCv;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.zzaBJ;
    }

    public Boolean getUserNavigationEnabled() {
        return this.zzaCz;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.zzCY;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.zzaBP;
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean enabled) {
        this.zzaCA = Boolean.valueOf(enabled);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera camera) {
        this.zzaCv = camera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String panoId) {
        this.zzaCw = panoId;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng position) {
        this.zzaCx = position;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng position, Integer radius) {
        this.zzaCx = position;
        this.zzaCy = radius;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean enabled) {
        this.zzaCB = Boolean.valueOf(enabled);
        return this;
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        this.zzaBJ = Boolean.valueOf(useViewLifecycleInFragment);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean enabled) {
        this.zzaCz = Boolean.valueOf(enabled);
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean enabled) {
        this.zzaBP = Boolean.valueOf(enabled);
        return this;
    }

    /* access modifiers changed from: package-private */
    public byte zzvA() {
        return zza.zze(this.zzaCB);
    }

    /* access modifiers changed from: package-private */
    public byte zzvk() {
        return zza.zze(this.zzaBJ);
    }

    /* access modifiers changed from: package-private */
    public byte zzvo() {
        return zza.zze(this.zzaBP);
    }

    /* access modifiers changed from: package-private */
    public byte zzvy() {
        return zza.zze(this.zzaCz);
    }

    /* access modifiers changed from: package-private */
    public byte zzvz() {
        return zza.zze(this.zzaCA);
    }
}
