package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzlg;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class LargeParcelTeleporter implements SafeParcelable {
    public static final Parcelable.Creator<LargeParcelTeleporter> CREATOR = new zzk();
    final int zzCY;
    ParcelFileDescriptor zzCZ;
    private Parcelable zzDa;
    private boolean zzDb;

    LargeParcelTeleporter(int versionCode, ParcelFileDescriptor parcelFileDescriptor) {
        this.zzCY = versionCode;
        this.zzCZ = parcelFileDescriptor;
        this.zzDa = null;
        this.zzDb = true;
    }

    public LargeParcelTeleporter(SafeParcelable teleportee) {
        this.zzCY = 1;
        this.zzCZ = null;
        this.zzDa = teleportee;
        this.zzDb = false;
    }

    public int describeContents() {
        return 0;
    }

    /* JADX INFO: finally extract failed */
    public void writeToParcel(Parcel dest, int flags) {
        if (this.zzCZ == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.zzDa.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                this.zzCZ = zzf(marshall);
            } catch (Throwable th) {
                obtain.recycle();
                throw th;
            }
        }
        zzk.zza(this, dest, flags);
    }

    /* JADX INFO: finally extract failed */
    public <T extends SafeParcelable> T zza(Parcelable.Creator<T> creator) {
        if (this.zzDb) {
            if (this.zzCZ == null) {
                zzb.zzaz("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zzCZ));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr, 0, bArr.length);
                zzlg.zzb(dataInputStream);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.unmarshall(bArr, 0, bArr.length);
                    obtain.setDataPosition(0);
                    this.zzDa = creator.createFromParcel(obtain);
                    obtain.recycle();
                    this.zzDb = false;
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            } catch (IOException e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            } catch (Throwable th2) {
                zzlg.zzb(dataInputStream);
                throw th2;
            }
        }
        return (T) ((SafeParcelable) this.zzDa);
    }

    /* access modifiers changed from: protected */
    public <T> ParcelFileDescriptor zzf(final byte[] bArr) {
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            final ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(createPipe[1]);
            new Thread(new Runnable() {
                /* class com.google.android.gms.ads.internal.request.LargeParcelTeleporter.AnonymousClass1 */

                public void run() {
                    DataOutputStream dataOutputStream = new DataOutputStream(autoCloseOutputStream);
                    try {
                        dataOutputStream.writeInt(bArr.length);
                        dataOutputStream.write(bArr);
                    } catch (IOException e) {
                        zzb.zzb("Error transporting the ad response", e);
                        zzo.zzby().zzc((Throwable) e, true);
                    } finally {
                        zzlg.zzb(dataOutputStream);
                    }
                }
            }).start();
            return createPipe[0];
        } catch (IOException e) {
            zzb.zzb("Error transporting the ad response", e);
            zzo.zzby().zzc((Throwable) e, true);
            return null;
        }
    }
}
