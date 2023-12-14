package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public class zzeu {
    private final zzid zzoA;
    private final String zzzd;

    public zzeu(zzid zzid) {
        this(zzid, "");
    }

    public zzeu(zzid zzid, String str) {
        this.zzoA = zzid;
        this.zzzd = str;
    }

    public void zza(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.zzoA.zzb("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put("rotation", i5));
        } catch (JSONException e) {
            zzb.zzb("Error occured while obtaining screen information.", e);
        }
    }

    public void zzae(String str) {
        try {
            this.zzoA.zzb("onError", new JSONObject().put("message", str).put("action", this.zzzd));
        } catch (JSONException e) {
            zzb.zzb("Error occurred while dispatching error event.", e);
        }
    }

    public void zzaf(String str) {
        try {
            this.zzoA.zzb("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zzb.zzb("Error occured while dispatching ready Event.", e);
        }
    }

    public void zzag(String str) {
        try {
            this.zzoA.zzb("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            zzb.zzb("Error occured while dispatching state change.", e);
        }
    }

    public void zzb(int i, int i2, int i3, int i4) {
        try {
            this.zzoA.zzb("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzb.zzb("Error occured while dispatching size change.", e);
        }
    }

    public void zzc(int i, int i2, int i3, int i4) {
        try {
            this.zzoA.zzb("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzb.zzb("Error occured while dispatching default position.", e);
        }
    }
}
