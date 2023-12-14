package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.OutputStream;

public final class zzn extends OutputStream {
    private volatile zzj zzaTY;
    private final OutputStream zzaUa;

    public zzn(OutputStream outputStream) {
        this.zzaUa = (OutputStream) zzu.zzu(outputStream);
    }

    private IOException zza(IOException iOException) {
        zzj zzj = this.zzaTY;
        if (zzj == null) {
            return iOException;
        }
        if (Log.isLoggable("ChannelOutputStream", 2)) {
            Log.v("ChannelOutputStream", "Caught IOException, but channel has been closed. Translating to ChannelIOException.", iOException);
        }
        return new ChannelIOException("Channel closed unexpectedly before stream was finished", zzj.zzaTN, zzj.zzaTO);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.zzaUa.close();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        try {
            this.zzaUa.flush();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        try {
            this.zzaUa.write(i);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] buffer) throws IOException {
        try {
            this.zzaUa.write(buffer);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] buffer, int offset, int count) throws IOException {
        try {
            this.zzaUa.write(buffer, offset, count);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    /* access modifiers changed from: package-private */
    public zzr zzBb() {
        return new zzr() {
            /* class com.google.android.gms.wearable.internal.zzn.AnonymousClass1 */

            @Override // com.google.android.gms.wearable.internal.zzr
            public void zzb(zzj zzj) {
                zzn.this.zzc(zzj);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void zzc(zzj zzj) {
        this.zzaTY = zzj;
    }
}
