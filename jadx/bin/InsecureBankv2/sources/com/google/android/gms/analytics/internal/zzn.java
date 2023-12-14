package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzu;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class zzn extends zzd {
    private volatile String zzJd;
    private Future<String> zzKG;

    protected zzn(zzf zzf) {
        super(zzf);
    }

    private boolean zzg(Context context, String str) {
        boolean z = false;
        zzu.zzcj(str);
        zzu.zzbZ("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        try {
            zza("Storing clientId", str);
            fileOutputStream = context.openFileOutput("gaClientId", 0);
            fileOutputStream.write(str.getBytes());
            z = true;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    zze("Failed to close clientId writing stream", e);
                }
            }
        } catch (FileNotFoundException e2) {
            zze("Error creating clientId file", e2);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    zze("Failed to close clientId writing stream", e3);
                }
            }
        } catch (IOException e4) {
            zze("Error writing to clientId file", e4);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    zze("Failed to close clientId writing stream", e5);
                }
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e6) {
                    zze("Failed to close clientId writing stream", e6);
                }
            }
            throw th;
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String zziS() {
        String zziT = zziT();
        try {
            return !zzg(zzhS().getContext(), zziT) ? "0" : zziT;
        } catch (Exception e) {
            zze("Error saving clientId file", e);
            return "0";
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0074 A[SYNTHETIC, Splitter:B:31:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008d A[SYNTHETIC, Splitter:B:41:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009d A[SYNTHETIC, Splitter:B:48:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String zzX(android.content.Context r7) {
        /*
        // Method dump skipped, instructions count: 175
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzn.zzX(android.content.Context):java.lang.String");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.analytics.internal.zzd
    public void zzhn() {
    }

    public String zziP() {
        String str;
        zzia();
        synchronized (this) {
            if (this.zzJd == null) {
                this.zzKG = zzhS().zzb(new Callable<String>() {
                    /* class com.google.android.gms.analytics.internal.zzn.AnonymousClass1 */

                    /* renamed from: zziU */
                    public String call() throws Exception {
                        return zzn.this.zziR();
                    }
                });
            }
            if (this.zzKG != null) {
                try {
                    this.zzJd = this.zzKG.get();
                } catch (InterruptedException e) {
                    zzd("ClientId loading or generation was interrupted", e);
                    this.zzJd = "0";
                } catch (ExecutionException e2) {
                    zze("Failed to load or generate client id", e2);
                    this.zzJd = "0";
                }
                if (this.zzJd == null) {
                    this.zzJd = "0";
                }
                zza("Loaded clientId", this.zzJd);
                this.zzKG = null;
            }
            str = this.zzJd;
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public String zziQ() {
        synchronized (this) {
            this.zzJd = null;
            this.zzKG = zzhS().zzb(new Callable<String>() {
                /* class com.google.android.gms.analytics.internal.zzn.AnonymousClass2 */

                /* renamed from: zziU */
                public String call() throws Exception {
                    return zzn.this.zziS();
                }
            });
        }
        return zziP();
    }

    /* access modifiers changed from: package-private */
    public String zziR() {
        String zzX = zzX(zzhS().getContext());
        return zzX == null ? zziS() : zzX;
    }

    /* access modifiers changed from: protected */
    public String zziT() {
        return UUID.randomUUID().toString().toLowerCase();
    }
}
