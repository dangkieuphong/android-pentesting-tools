package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzrm;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.tagmanager.zzbf;
import com.google.android.gms.tagmanager.zzcb;
import com.google.android.gms.tagmanager.zzp;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

/* access modifiers changed from: package-private */
public class zzcn implements zzp.zzf {
    private final Context mContext;
    private final String zzaKy;
    private zzbf<zzpx.zza> zzaMU;
    private final ExecutorService zzaNb = Executors.newSingleThreadExecutor();

    zzcn(Context context, String str) {
        this.mContext = context;
        this.zzaKy = str;
    }

    private zzqf.zzc zza(ByteArrayOutputStream byteArrayOutputStream) {
        try {
            return zzaz.zzey(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            zzbg.zzay("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
            return null;
        } catch (JSONException e2) {
            zzbg.zzaC("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
            return null;
        }
    }

    private void zzd(zzpx.zza zza) throws IllegalArgumentException {
        if (zza.zziO == null && zza.zzaPa == null) {
            throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
        }
    }

    private zzqf.zzc zzr(byte[] bArr) {
        try {
            zzqf.zzc zzb = zzqf.zzb(zzaf.zzf.zzc(bArr));
            if (zzb == null) {
                return zzb;
            }
            zzbg.zzaB("The container was successfully loaded from the resource (using binary file)");
            return zzb;
        } catch (zzrm e) {
            zzbg.zzaz("The resource file is corrupted. The container cannot be extracted from the binary file");
            return null;
        } catch (zzqf.zzg e2) {
            zzbg.zzaC("The resource file is invalid. The container from the binary file is invalid");
            return null;
        }
    }

    @Override // com.google.android.gms.common.api.Releasable
    public synchronized void release() {
        this.zzaNb.shutdown();
    }

    @Override // com.google.android.gms.tagmanager.zzp.zzf
    public void zza(zzbf<zzpx.zza> zzbf) {
        this.zzaMU = zzbf;
    }

    @Override // com.google.android.gms.tagmanager.zzp.zzf
    public void zzb(final zzpx.zza zza) {
        this.zzaNb.execute(new Runnable() {
            /* class com.google.android.gms.tagmanager.zzcn.AnonymousClass2 */

            public void run() {
                zzcn.this.zzc(zza);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public boolean zzc(zzpx.zza zza) {
        boolean z = false;
        File zzzo = zzzo();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zzzo);
            try {
                fileOutputStream.write(zzrn.zzf(zza));
                z = true;
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    zzbg.zzaC("error closing stream for writing resource to disk");
                }
            } catch (IOException e2) {
                zzbg.zzaC("Error writing resource to disk. Removing resource from disk.");
                zzzo.delete();
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    zzbg.zzaC("error closing stream for writing resource to disk");
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    zzbg.zzaC("error closing stream for writing resource to disk");
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            zzbg.zzaz("Error opening resource file for writing");
        }
        return z;
    }

    @Override // com.google.android.gms.tagmanager.zzp.zzf
    public zzqf.zzc zziR(int i) {
        try {
            InputStream openRawResource = this.mContext.getResources().openRawResource(i);
            zzbg.zzaB("Attempting to load a container from the resource ID " + i + " (" + this.mContext.getResources().getResourceName(i) + ")");
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzqf.zzc(openRawResource, byteArrayOutputStream);
                zzqf.zzc zza = zza(byteArrayOutputStream);
                if (zza == null) {
                    return zzr(byteArrayOutputStream.toByteArray());
                }
                zzbg.zzaB("The container was successfully loaded from the resource (using JSON file format)");
                return zza;
            } catch (IOException e) {
                zzbg.zzaC("Error reading the default container with resource ID " + i + " (" + this.mContext.getResources().getResourceName(i) + ")");
                return null;
            }
        } catch (Resources.NotFoundException e2) {
            zzbg.zzaC("Failed to load the container. No default container resource found with the resource ID " + i);
            return null;
        }
    }

    @Override // com.google.android.gms.tagmanager.zzp.zzf
    public void zzyw() {
        this.zzaNb.execute(new Runnable() {
            /* class com.google.android.gms.tagmanager.zzcn.AnonymousClass1 */

            public void run() {
                zzcn.this.zzzn();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void zzzn() {
        if (this.zzaMU == null) {
            throw new IllegalStateException("Callback must be set before execute");
        }
        this.zzaMU.zzyv();
        zzbg.zzaB("Attempting to load resource from disk");
        if ((zzcb.zzzf().zzzg() == zzcb.zza.CONTAINER || zzcb.zzzf().zzzg() == zzcb.zza.CONTAINER_DEBUG) && this.zzaKy.equals(zzcb.zzzf().getContainerId())) {
            this.zzaMU.zza(zzbf.zza.NOT_AVAILABLE);
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(zzzo());
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzqf.zzc(fileInputStream, byteArrayOutputStream);
                zzpx.zza zzs = zzpx.zza.zzs(byteArrayOutputStream.toByteArray());
                zzd(zzs);
                this.zzaMU.zzz(zzs);
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    zzbg.zzaC("Error closing stream for reading resource from disk");
                }
            } catch (IOException e2) {
                this.zzaMU.zza(zzbf.zza.IO_ERROR);
                zzbg.zzaC("Failed to read the resource from disk");
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    zzbg.zzaC("Error closing stream for reading resource from disk");
                }
            } catch (IllegalArgumentException e4) {
                this.zzaMU.zza(zzbf.zza.IO_ERROR);
                zzbg.zzaC("Failed to read the resource from disk. The resource is inconsistent");
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    zzbg.zzaC("Error closing stream for reading resource from disk");
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    zzbg.zzaC("Error closing stream for reading resource from disk");
                }
                throw th;
            }
            zzbg.zzaB("The Disk resource was successfully read.");
        } catch (FileNotFoundException e7) {
            zzbg.zzay("Failed to find the resource in the disk");
            this.zzaMU.zza(zzbf.zza.NOT_AVAILABLE);
        }
    }

    /* access modifiers changed from: package-private */
    public File zzzo() {
        return new File(this.mContext.getDir("google_tagmanager", 0), "resource_" + this.zzaKy);
    }
}
