package com.google.android.gms.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class zzaa extends ByteArrayOutputStream {
    private final zzu zzar;

    public zzaa(zzu zzu, int i) {
        this.zzar = zzu;
        this.buf = this.zzar.zzb(Math.max(i, 256));
    }

    private void zzd(int i) {
        if (this.count + i > this.buf.length) {
            byte[] zzb = this.zzar.zzb((this.count + i) * 2);
            System.arraycopy(this.buf, 0, zzb, 0, this.count);
            this.zzar.zza(this.buf);
            this.buf = zzb;
        }
    }

    @Override // java.io.OutputStream, java.io.ByteArrayOutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.zzar.zza(this.buf);
        this.buf = null;
        super.close();
    }

    @Override // java.lang.Object
    public void finalize() {
        this.zzar.zza(this.buf);
    }

    @Override // java.io.OutputStream, java.io.ByteArrayOutputStream
    public synchronized void write(int oneByte) {
        zzd(1);
        super.write(oneByte);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] buffer, int offset, int len) {
        zzd(len);
        super.write(buffer, offset, len);
    }
}
