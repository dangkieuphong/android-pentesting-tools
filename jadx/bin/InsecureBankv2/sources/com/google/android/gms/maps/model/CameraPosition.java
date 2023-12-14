package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;

public final class CameraPosition implements SafeParcelable {
    public static final zza CREATOR = new zza();
    public final float bearing;
    public final LatLng target;
    public final float tilt;
    public final float zoom;
    private final int zzCY;

    public static final class Builder {
        private LatLng zzaCQ;
        private float zzaCR;
        private float zzaCS;
        private float zzaCT;

        public Builder() {
        }

        public Builder(CameraPosition previous) {
            this.zzaCQ = previous.target;
            this.zzaCR = previous.zoom;
            this.zzaCS = previous.tilt;
            this.zzaCT = previous.bearing;
        }

        public Builder bearing(float bearing) {
            this.zzaCT = bearing;
            return this;
        }

        public CameraPosition build() {
            return new CameraPosition(this.zzaCQ, this.zzaCR, this.zzaCS, this.zzaCT);
        }

        public Builder target(LatLng location) {
            this.zzaCQ = location;
            return this;
        }

        public Builder tilt(float tilt) {
            this.zzaCS = tilt;
            return this;
        }

        public Builder zoom(float zoom) {
            this.zzaCR = zoom;
            return this;
        }
    }

    CameraPosition(int versionCode, LatLng target2, float zoom2, float tilt2, float bearing2) {
        zzu.zzb(target2, "null camera target");
        zzu.zzb(0.0f <= tilt2 && tilt2 <= 90.0f, "Tilt needs to be between 0 and 90 inclusive: %s", Float.valueOf(tilt2));
        this.zzCY = versionCode;
        this.target = target2;
        this.zoom = zoom2;
        this.tilt = tilt2 + 0.0f;
        this.bearing = (((double) bearing2) <= 0.0d ? (bearing2 % 360.0f) + 360.0f : bearing2) % 360.0f;
    }

    public CameraPosition(LatLng target2, float zoom2, float tilt2, float bearing2) {
        this(1, target2, zoom2, tilt2, bearing2);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition camera) {
        return new Builder(camera);
    }

    public static CameraPosition createFromAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, R.styleable.MapAttrs);
        LatLng latLng = new LatLng((double) (obtainAttributes.hasValue(R.styleable.MapAttrs_cameraTargetLat) ? obtainAttributes.getFloat(R.styleable.MapAttrs_cameraTargetLat, 0.0f) : 0.0f), (double) (obtainAttributes.hasValue(R.styleable.MapAttrs_cameraTargetLng) ? obtainAttributes.getFloat(R.styleable.MapAttrs_cameraTargetLng, 0.0f) : 0.0f));
        Builder builder = builder();
        builder.target(latLng);
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_cameraZoom)) {
            builder.zoom(obtainAttributes.getFloat(R.styleable.MapAttrs_cameraZoom, 0.0f));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_cameraBearing)) {
            builder.bearing(obtainAttributes.getFloat(R.styleable.MapAttrs_cameraBearing, 0.0f));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_cameraTilt)) {
            builder.tilt(obtainAttributes.getFloat(R.styleable.MapAttrs_cameraTilt, 0.0f));
        }
        return builder.build();
    }

    public static final CameraPosition fromLatLngZoom(LatLng target2, float zoom2) {
        return new CameraPosition(target2, zoom2, 0.0f, 0.0f);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) o;
        return this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    public String toString() {
        return zzt.zzt(this).zzg("target", this.target).zzg("zoom", Float.valueOf(this.zoom)).zzg("tilt", Float.valueOf(this.tilt)).zzg("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }
}
