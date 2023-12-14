package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.InputStream;

public final class zzm extends InputStream {
    private final InputStream zzaTX;
    private volatile zzj zzaTY;

    public zzm(InputStream inputStream) {
        this.zzaTX = (InputStream) zzu.zzu(inputStream);
    }

    private int zzjX(int i) throws ChannelIOException {
        zzj zzj;
        if (i != -1 || (zzj = this.zzaTY) == null) {
            return i;
        }
        throw new ChannelIOException("Channel closed unexpectedly before stream was finished", zzj.zzaTN, zzj.zzaTO);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.zzaTX.available();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() throws IOException {
        this.zzaTX.close();
    }

    public void mark(int readlimit) {
        this.zzaTX.mark(readlimit);
    }

    public boolean markSupported() {
        return this.zzaTX.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return zzjX(this.zzaTX.read());
    }

    @Override // java.io.InputStream
    public int read(byte[] buffer) throws IOException {
        return zzjX(this.zzaTX.read(buffer));
    }

    @Override // java.io.InputStream
    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        return zzjX(this.zzaTX.read(buffer, byteOffset, byteCount));
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.zzaTX.reset();
    }

    @Override // java.io.InputStream
    public long skip(long byteCount) throws IOException {
        return this.zzaTX.skip(byteCount);
    }

    /* access modifiers changed from: package-private */
    public zzr zzBb() {
        return new zzr() {
            /* class com.google.android.gms.wearable.internal.zzm.AnonymousClass1 */

            @Override // com.google.android.gms.wearable.internal.zzr
            public void zzb(zzj zzj) {
                zzm.this.zza(zzj);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void zza(zzj zzj) {
        this.zzaTY = (zzj) zzu.zzu(zzj);
    }
}
