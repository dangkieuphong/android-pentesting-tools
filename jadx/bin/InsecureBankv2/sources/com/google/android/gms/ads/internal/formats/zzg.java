package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzgd;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public class zzg {
    private final Context mContext;
    private final Object zzqt = new Object();
    private final zzan zzvA;
    private boolean zzvB;
    private final zzm zzvw;
    private final JSONObject zzvx;
    private final zzbb zzvy;
    private final zza zzvz;

    public interface zza {
        String getCustomTemplateId();

        void zza(zzg zzg);

        String zzdE();

        zza zzdF();
    }

    public zzg(Context context, zzm zzm, zzbb zzbb, zzan zzan, JSONObject jSONObject, zza zza2) {
        this.mContext = context;
        this.zzvw = zzm;
        this.zzvy = zzbb;
        this.zzvA = zzan;
        this.zzvx = jSONObject;
        this.zzvz = zza2;
    }

    public void performClick(String assetId) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset", assetId);
            jSONObject.put("template", this.zzvz.zzdE());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad", this.zzvx);
            jSONObject2.put("click", jSONObject);
            jSONObject2.put("has_custom_click_handler", this.zzvw.zzq(this.zzvz.getCustomTemplateId()) != null);
            this.zzvy.zza("google.afma.nativeAds.handleClickGmsg", jSONObject2);
        } catch (JSONException e) {
            zzb.zzb("Unable to create click JSON.", e);
        }
    }

    public void recordImpression() {
        this.zzvB = true;
        this.zzvw.zzaP();
    }

    public zzb zza(View.OnClickListener onClickListener) {
        zza zzdF = this.zzvz.zzdF();
        if (zzdF == null) {
            return null;
        }
        zzb zzb = new zzb(this.mContext, zzdF);
        zzb.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        zzb.zzdv().setOnClickListener(onClickListener);
        return zzb;
    }

    public void zzb(MotionEvent motionEvent) {
        this.zzvA.zza(motionEvent);
    }

    public void zzh(View view) {
        synchronized (this.zzqt) {
            if (!this.zzvB) {
                if (view.isShown()) {
                    if (view.getGlobalVisibleRect(new Rect(), null)) {
                        recordImpression();
                    }
                }
            }
        }
    }
}
