package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataItemAsset;

public class zzz extends zzc implements DataItemAsset {
    public zzz(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public String getDataItemKey() {
        return getString("asset_key");
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public String getId() {
        return getString("asset_id");
    }

    /* renamed from: zzBd */
    public DataItemAsset freeze() {
        return new zzx(this);
    }
}
