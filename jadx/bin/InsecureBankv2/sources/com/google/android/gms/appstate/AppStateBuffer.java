package com.google.android.gms.appstate;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class AppStateBuffer extends AbstractDataBuffer<AppState> {
    public AppStateBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.data.AbstractDataBuffer
    public AppState get(int position) {
        return new zzb(this.zzWu, position);
    }
}
