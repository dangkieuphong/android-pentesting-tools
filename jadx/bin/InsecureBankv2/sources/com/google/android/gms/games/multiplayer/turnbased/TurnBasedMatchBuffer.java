package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class TurnBasedMatchBuffer extends zzf<TurnBasedMatch> {
    public TurnBasedMatchBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    public String zzni() {
        return "external_match_id";
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzq */
    public TurnBasedMatch zzj(int i, int i2) {
        return new TurnBasedMatchRef(this.zzWu, i, i2);
    }
}
