package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import java.util.ArrayList;

public final class AppContentSectionBuffer extends zzf<AppContentSection> {
    private final ArrayList<DataHolder> zzaoD;

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.api.Releasable
    public void release() {
        super.release();
        int size = this.zzaoD.size();
        for (int i = 1; i < size; i++) {
            DataHolder dataHolder = this.zzaoD.get(i);
            if (dataHolder != null) {
                dataHolder.close();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzm */
    public AppContentSection zzj(int i, int i2) {
        return new AppContentSectionRef(this.zzaoD, i, i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    public String zzni() {
        return "section_id";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    public String zznk() {
        return "card_id";
    }
}
