package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class RoomBuffer extends zzf<Room> {
    public RoomBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    public String zzni() {
        return "external_match_id";
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzp */
    public Room zzj(int i, int i2) {
        return new RoomRef(this.zzWu, i, i2);
    }
}
