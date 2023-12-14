package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public class zzes {
    private final boolean zzyO;
    private final boolean zzyP;
    private final boolean zzyQ;
    private final boolean zzyR;
    private final boolean zzyS;

    public static final class zza {
        private boolean zzyO;
        private boolean zzyP;
        private boolean zzyQ;
        private boolean zzyR;
        private boolean zzyS;

        public zzes zzeg() {
            return new zzes(this);
        }

        public zza zzo(boolean z) {
            this.zzyO = z;
            return this;
        }

        public zza zzp(boolean z) {
            this.zzyP = z;
            return this;
        }

        public zza zzq(boolean z) {
            this.zzyQ = z;
            return this;
        }

        public zza zzr(boolean z) {
            this.zzyR = z;
            return this;
        }

        public zza zzs(boolean z) {
            this.zzyS = z;
            return this;
        }
    }

    private zzes(zza zza2) {
        this.zzyO = zza2.zzyO;
        this.zzyP = zza2.zzyP;
        this.zzyQ = zza2.zzyQ;
        this.zzyR = zza2.zzyR;
        this.zzyS = zza2.zzyS;
    }

    public JSONObject toJson() {
        try {
            return new JSONObject().put("sms", this.zzyO).put("tel", this.zzyP).put("calendar", this.zzyQ).put("storePicture", this.zzyR).put("inlineVideo", this.zzyS);
        } catch (JSONException e) {
            zzb.zzb("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
