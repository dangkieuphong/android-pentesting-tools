package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzf<T> extends AbstractDataBuffer<T> {
    private boolean zzYK = false;
    private ArrayList<Integer> zzYL;

    protected zzf(DataHolder dataHolder) {
        super(dataHolder);
    }

    private void zznj() {
        synchronized (this) {
            if (!this.zzYK) {
                int count = this.zzWu.getCount();
                this.zzYL = new ArrayList<>();
                if (count > 0) {
                    this.zzYL.add(0);
                    String zzni = zzni();
                    String zzd = this.zzWu.zzd(zzni, 0, this.zzWu.zzbh(0));
                    int i = 1;
                    while (i < count) {
                        int zzbh = this.zzWu.zzbh(i);
                        String zzd2 = this.zzWu.zzd(zzni, i, zzbh);
                        if (zzd2 == null) {
                            throw new NullPointerException("Missing value for markerColumn: " + zzni + ", at row: " + i + ", for window: " + zzbh);
                        }
                        if (!zzd2.equals(zzd)) {
                            this.zzYL.add(Integer.valueOf(i));
                        } else {
                            zzd2 = zzd;
                        }
                        i++;
                        zzd = zzd2;
                    }
                }
                this.zzYK = true;
            }
        }
    }

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.data.AbstractDataBuffer
    public final T get(int position) {
        zznj();
        return zzj(zzbk(position), zzbl(position));
    }

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.data.AbstractDataBuffer
    public int getCount() {
        zznj();
        return this.zzYL.size();
    }

    /* access modifiers changed from: package-private */
    public int zzbk(int i) {
        if (i >= 0 && i < this.zzYL.size()) {
            return this.zzYL.get(i).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    /* access modifiers changed from: protected */
    public int zzbl(int i) {
        if (i < 0 || i == this.zzYL.size()) {
            return 0;
        }
        int count = i == this.zzYL.size() + -1 ? this.zzWu.getCount() - this.zzYL.get(i).intValue() : this.zzYL.get(i + 1).intValue() - this.zzYL.get(i).intValue();
        if (count != 1) {
            return count;
        }
        int zzbk = zzbk(i);
        int zzbh = this.zzWu.zzbh(zzbk);
        String zznk = zznk();
        if (zznk == null || this.zzWu.zzd(zznk, zzbk, zzbh) != null) {
            return count;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract T zzj(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String zzni();

    /* access modifiers changed from: protected */
    public String zznk() {
        return null;
    }
}
