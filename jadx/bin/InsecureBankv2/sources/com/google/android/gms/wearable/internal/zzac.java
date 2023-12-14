package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;

public final class zzac extends zzc implements DataItem {
    private final int zzaoG;

    public zzac(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzaoG = i2;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public Map<String, DataItemAsset> getAssets() {
        HashMap hashMap = new HashMap(this.zzaoG);
        for (int i = 0; i < this.zzaoG; i++) {
            zzz zzz = new zzz(this.zzWu, this.zzYs + i);
            if (zzz.getDataItemKey() != null) {
                hashMap.put(zzz.getDataItemKey(), zzz);
            }
        }
        return hashMap;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public byte[] getData() {
        return getByteArray("data");
    }

    @Override // com.google.android.gms.wearable.DataItem
    public Uri getUri() {
        return Uri.parse(getString("path"));
    }

    @Override // com.google.android.gms.wearable.DataItem
    public DataItem setData(byte[] data) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean verbose) {
        byte[] data = getData();
        Map<String, DataItemAsset> assets = getAssets();
        StringBuilder sb = new StringBuilder("DataItemInternal{ ");
        sb.append("uri=" + getUri());
        sb.append(", dataSz=" + (data == null ? "null" : Integer.valueOf(data.length)));
        sb.append(", numAssets=" + assets.size());
        if (verbose && !assets.isEmpty()) {
            sb.append(", assets=[");
            String str = "";
            for (Map.Entry<String, DataItemAsset> entry : assets.entrySet()) {
                sb.append(str + entry.getKey() + ": " + entry.getValue().getId());
                str = ", ";
            }
            sb.append("]");
        }
        sb.append(" }");
        return sb.toString();
    }

    /* renamed from: zzBe */
    public DataItem freeze() {
        return new zzaa(this);
    }
}
