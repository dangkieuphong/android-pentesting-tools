package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class zzbb extends zzak {
    private static final String ID = zzad.LANGUAGE.toString();

    public zzbb() {
        super(ID, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return zzdf.zzzQ();
        }
        String language = locale.getLanguage();
        return language == null ? zzdf.zzzQ() : zzdf.zzI(language.toLowerCase());
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public /* bridge */ /* synthetic */ String zzyM() {
        return super.zzyM();
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public /* bridge */ /* synthetic */ Set zzyN() {
        return super.zzyN();
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return false;
    }
}
