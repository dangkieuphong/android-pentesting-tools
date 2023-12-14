package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.tagmanager.zzbg;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class zzqh {
    public static final Integer zzaPM = 0;
    public static final Integer zzaPN = 1;
    private final Context mContext;
    private final ExecutorService zzaNb;

    public zzqh(Context context) {
        this(context, Executors.newSingleThreadExecutor());
    }

    zzqh(Context context, ExecutorService executorService) {
        this.mContext = context;
        this.zzaNb = executorService;
    }

    private String zzfc(String str) {
        return "resource_" + str;
    }

    private byte[] zzm(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            zzlg.zza(inputStream, byteArrayOutputStream);
            try {
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                zzbg.zzaC("Error closing stream for reading resource from disk");
                return null;
            }
        } catch (IOException e2) {
            zzbg.zzaC("Failed to read the resource from disk");
            try {
                inputStream.close();
            } catch (IOException e3) {
                zzbg.zzaC("Error closing stream for reading resource from disk");
                return null;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
                throw th;
            } catch (IOException e4) {
                zzbg.zzaC("Error closing stream for reading resource from disk");
                return null;
            }
        }
    }

    public void zza(final String str, final Integer num, final zzqb zzqb, final zzqg zzqg) {
        this.zzaNb.execute(new Runnable() {
            /* class com.google.android.gms.internal.zzqh.AnonymousClass1 */

            public void run() {
                zzqh.this.zzb(str, num, zzqb, zzqg);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void zzb(String str, Integer num, zzqb zzqb, zzqg zzqg) {
        Object zzt;
        zzbg.zzaB("DiskLoader: Starting to load resource from Disk.");
        try {
            Object zzt2 = zzqb.zzt(zzm(new FileInputStream(zzfb(str))));
            if (zzt2 != null) {
                zzbg.zzaB("Saved resource loaded: " + zzfc(str));
                zzqg.zza(Status.zzXP, zzt2, zzaPN, zzfa(str));
                return;
            }
        } catch (FileNotFoundException e) {
            zzbg.zzaz("Saved resource not found: " + zzfc(str));
        } catch (zzqf.zzg e2) {
            zzbg.zzaz("Saved resource is corrupted: " + zzfc(str));
        }
        if (num == null) {
            zzqg.zza(Status.zzXR, null, null, 0);
            return;
        }
        try {
            InputStream openRawResource = this.mContext.getResources().openRawResource(num.intValue());
            if (!(openRawResource == null || (zzt = zzqb.zzt(zzm(openRawResource))) == null)) {
                zzbg.zzaB("Default resource loaded: " + this.mContext.getResources().getResourceEntryName(num.intValue()));
                zzqg.zza(Status.zzXP, zzt, zzaPM, 0);
                return;
            }
        } catch (Resources.NotFoundException e3) {
            zzbg.zzaz("Default resource not found. ID: " + num);
        } catch (zzqf.zzg e4) {
            zzbg.zzaz("Default resource resource is corrupted: " + num);
        }
        zzqg.zza(Status.zzXR, null, null, 0);
    }

    public void zze(final String str, final byte[] bArr) {
        this.zzaNb.execute(new Runnable() {
            /* class com.google.android.gms.internal.zzqh.AnonymousClass2 */

            public void run() {
                zzqh.this.zzf(str, bArr);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void zzf(String str, byte[] bArr) {
        File zzfb = zzfb(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zzfb);
            try {
                fileOutputStream.write(bArr);
                try {
                    fileOutputStream.close();
                    zzbg.zzaB("Resource " + str + " saved on Disk.");
                } catch (IOException e) {
                    zzbg.zzaz("Error closing stream for writing resource to disk");
                }
            } catch (IOException e2) {
                zzbg.zzaz("Error writing resource to disk. Removing resource from disk");
                zzfb.delete();
                try {
                    fileOutputStream.close();
                    zzbg.zzaB("Resource " + str + " saved on Disk.");
                } catch (IOException e3) {
                    zzbg.zzaz("Error closing stream for writing resource to disk");
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                    zzbg.zzaB("Resource " + str + " saved on Disk.");
                } catch (IOException e4) {
                    zzbg.zzaz("Error closing stream for writing resource to disk");
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            zzbg.zzaz("Error opening resource file for writing");
        }
    }

    public long zzfa(String str) {
        File zzfb = zzfb(str);
        if (zzfb.exists()) {
            return zzfb.lastModified();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public File zzfb(String str) {
        return new File(this.mContext.getDir("google_tagmanager", 0), zzfc(str));
    }
}
