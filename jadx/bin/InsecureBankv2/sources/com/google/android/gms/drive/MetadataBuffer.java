package com.google.android.gms.drive;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.zzn;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.zze;
import com.google.android.gms.internal.zzlo;

public final class MetadataBuffer extends AbstractDataBuffer<Metadata> {
    private zza zzadq;

    /* access modifiers changed from: private */
    public static class zza extends Metadata {
        private final DataHolder zzWu;
        private final int zzYt;
        private final int zzadr;

        public zza(DataHolder dataHolder, int i) {
            this.zzWu = dataHolder;
            this.zzadr = i;
            this.zzYt = dataHolder.zzbh(i);
        }

        @Override // com.google.android.gms.common.data.Freezable
        public boolean isDataValid() {
            return !this.zzWu.isClosed();
        }

        @Override // com.google.android.gms.drive.Metadata
        public <T> T zza(MetadataField<T> metadataField) {
            return metadataField.zza(this.zzWu, this.zzadr, this.zzYt);
        }

        /* renamed from: zzpl */
        public Metadata freeze() {
            MetadataBundle zzpX = MetadataBundle.zzpX();
            for (MetadataField<?> metadataField : zze.zzpW()) {
                if (metadataField != zzlo.zzaho) {
                    metadataField.zza(this.zzWu, zzpX, this.zzadr, this.zzYt);
                }
            }
            return new zzn(zzpX);
        }
    }

    public MetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
        dataHolder.zznb().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.data.AbstractDataBuffer
    public Metadata get(int row) {
        zza zza2 = this.zzadq;
        if (zza2 != null && zza2.zzadr == row) {
            return zza2;
        }
        zza zza3 = new zza(this.zzWu, row);
        this.zzadq = zza3;
        return zza3;
    }

    @Deprecated
    public String getNextPageToken() {
        return null;
    }

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.api.Releasable
    public void release() {
        if (this.zzWu != null) {
            zze.zzb(this.zzWu);
        }
        super.release();
    }
}
