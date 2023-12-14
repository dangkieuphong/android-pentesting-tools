package com.google.android.gms.games.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class GameRequestBuffer extends zzf<GameRequest> {
    public GameRequestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    public String zzni() {
        return "external_request_id";
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzs */
    public GameRequest zzj(int i, int i2) {
        return new GameRequestRef(this.zzWu, i, i2);
    }
}
