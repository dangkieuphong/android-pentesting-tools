package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.zzat;
import com.google.android.gms.wearable.internal.zzbj;
import com.google.android.gms.wearable.zza;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class zzbk extends zzi<zzat> {
    private final ExecutorService zzaNb = Executors.newCachedThreadPool();
    private final zzau<zza.AbstractC0226zza> zzaUR = new zzau<>();
    private final zzau<ChannelApi.ChannelListener> zzaUS = new zzau<>();
    private final zzau<DataApi.DataListener> zzaUT = new zzau<>();
    private final zzau<MessageApi.MessageListener> zzaUU = new zzau<>();
    private final zzau<NodeApi.NodeListener> zzaUV = new zzau<>();
    private final zzau<NodeApi.zza> zzaUW = new zzau<>();
    private final Map<String, zzau<CapabilityApi.CapabilityListener>> zzaUX = new HashMap();

    public zzbk(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, zze zze) {
        super(context, looper, 14, connectionCallbacks, onConnectionFailedListener, zze);
    }

    private FutureTask<Boolean> zza(final ParcelFileDescriptor parcelFileDescriptor, final byte[] bArr) {
        return new FutureTask<>(new Callable<Boolean>() {
            /* class com.google.android.gms.wearable.internal.zzbk.AnonymousClass1 */

            /* renamed from: zzBg */
            public Boolean call() {
                if (Log.isLoggable("WearableClient", 3)) {
                    Log.d("WearableClient", "processAssets: writing data to FD : " + parcelFileDescriptor);
                }
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptor);
                try {
                    autoCloseOutputStream.write(bArr);
                    autoCloseOutputStream.flush();
                    if (Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: wrote data: " + parcelFileDescriptor);
                    }
                    try {
                        if (Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: closing: " + parcelFileDescriptor);
                        }
                        autoCloseOutputStream.close();
                        return true;
                    } catch (IOException e) {
                        return true;
                    }
                } catch (IOException e2) {
                    Log.w("WearableClient", "processAssets: writing data failed: " + parcelFileDescriptor);
                    try {
                        if (Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: closing: " + parcelFileDescriptor);
                        }
                        autoCloseOutputStream.close();
                    } catch (IOException e3) {
                    }
                    return false;
                } catch (Throwable th) {
                    try {
                        if (Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: closing: " + parcelFileDescriptor);
                        }
                        autoCloseOutputStream.close();
                    } catch (IOException e4) {
                    }
                    throw th;
                }
            }
        });
    }

    private FutureTask<Void> zzb(final zza.zzb<Status> zzb, final String str, final Uri uri, final long j, final long j2) {
        zzu.zzu(zzb);
        zzu.zzu(str);
        zzu.zzu(uri);
        zzu.zzb(j >= 0, "startOffset is negative: %s", Long.valueOf(j));
        zzu.zzb(j2 >= -1, "invalid length: %s", Long.valueOf(j2));
        return new FutureTask<>(new Runnable() {
            /* class com.google.android.gms.wearable.internal.zzbk.AnonymousClass3 */

            public void run() {
                if (Log.isLoggable("WearableClient", 2)) {
                    Log.v("WearableClient", "Executing sendFileToChannelTask");
                }
                if (!"file".equals(uri.getScheme())) {
                    Log.w("WearableClient", "Channel.sendFile used with non-file URI");
                    zzb.zzr(new Status(10, "Channel.sendFile used with non-file URI"));
                    return;
                }
                File file = new File(uri.getPath());
                try {
                    ParcelFileDescriptor open = ParcelFileDescriptor.open(file, DriveFile.MODE_READ_ONLY);
                    try {
                        ((zzat) zzbk.this.zznM()).zza(new zzbj.zzr(zzb), str, open, j, j2);
                        try {
                            open.close();
                        } catch (IOException e) {
                            Log.w("WearableClient", "Failed to close sourceFd", e);
                        }
                    } catch (RemoteException e2) {
                        Log.w("WearableClient", "Channel.sendFile failed.", e2);
                        zzb.zzr(new Status(8));
                        try {
                            open.close();
                        } catch (IOException e3) {
                            Log.w("WearableClient", "Failed to close sourceFd", e3);
                        }
                    } catch (Throwable th) {
                        try {
                            open.close();
                        } catch (IOException e4) {
                            Log.w("WearableClient", "Failed to close sourceFd", e4);
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e5) {
                    Log.w("WearableClient", "File couldn't be opened for Channel.sendFile: " + file);
                    zzb.zzr(new Status(13));
                }
            }
        }, null);
    }

    private FutureTask<Void> zzb(final zza.zzb<Status> zzb, final String str, final Uri uri, final boolean z) {
        zzu.zzu(zzb);
        zzu.zzu(str);
        zzu.zzu(uri);
        return new FutureTask<>(new Runnable() {
            /* class com.google.android.gms.wearable.internal.zzbk.AnonymousClass2 */

            public void run() {
                if (Log.isLoggable("WearableClient", 2)) {
                    Log.v("WearableClient", "Executing receiveFileFromChannelTask");
                }
                if (!"file".equals(uri.getScheme())) {
                    Log.w("WearableClient", "Channel.receiveFile used with non-file URI");
                    zzb.zzr(new Status(10, "Channel.receiveFile used with non-file URI"));
                    return;
                }
                File file = new File(uri.getPath());
                try {
                    ParcelFileDescriptor open = ParcelFileDescriptor.open(file, (z ? 33554432 : 0) | DriveFile.MODE_WRITE_ONLY);
                    try {
                        ((zzat) zzbk.this.zznM()).zza(new zzbj.zzu(zzb), str, open);
                        try {
                            open.close();
                        } catch (IOException e) {
                            Log.w("WearableClient", "Failed to close targetFd", e);
                        }
                    } catch (RemoteException e2) {
                        Log.w("WearableClient", "Channel.receiveFile failed.", e2);
                        zzb.zzr(new Status(8));
                        try {
                            open.close();
                        } catch (IOException e3) {
                            Log.w("WearableClient", "Failed to close targetFd", e3);
                        }
                    } catch (Throwable th) {
                        try {
                            open.close();
                        } catch (IOException e4) {
                            Log.w("WearableClient", "Failed to close targetFd", e4);
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e5) {
                    Log.w("WearableClient", "File couldn't be opened for Channel.receiveFile: " + file);
                    zzb.zzr(new Status(13));
                }
            }
        }, null);
    }

    private zzau<CapabilityApi.CapabilityListener> zzfh(String str) {
        zzau<CapabilityApi.CapabilityListener> zzau = this.zzaUX.get(str);
        if (zzau != null) {
            return zzau;
        }
        zzau<CapabilityApi.CapabilityListener> zzau2 = new zzau<>();
        this.zzaUX.put(str, zzau2);
        return zzau2;
    }

    @Override // com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.zzi
    public void disconnect() {
        this.zzaUR.zzb(this);
        this.zzaUT.zzb(this);
        this.zzaUU.zzb(this);
        this.zzaUV.zzb(this);
        this.zzaUW.zzb(this);
        synchronized (this.zzaUX) {
            for (zzau<CapabilityApi.CapabilityListener> zzau : this.zzaUX.values()) {
                zzau.zzb(this);
            }
        }
        super.disconnect();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getServiceDescriptor() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getStartServiceAction() {
        return "com.google.android.gms.wearable.BIND";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (Log.isLoggable("WearableClient", 2)) {
            Log.d("WearableClient", "onPostInitHandler: statusCode " + i);
        }
        if (i == 0) {
            this.zzaUR.zzdR(iBinder);
            this.zzaUT.zzdR(iBinder);
            this.zzaUU.zzdR(iBinder);
            this.zzaUV.zzdR(iBinder);
            this.zzaUW.zzdR(iBinder);
            synchronized (this.zzaUX) {
                for (zzau<CapabilityApi.CapabilityListener> zzau : this.zzaUX.values()) {
                    zzau.zzdR(iBinder);
                }
            }
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(zza.zzb<DataApi.DataItemResult> zzb, Uri uri) throws RemoteException {
        ((zzat) zznM()).zza(new zzbj.zzk(zzb), uri);
    }

    public void zza(zza.zzb<DataItemBuffer> zzb, Uri uri, int i) throws RemoteException {
        ((zzat) zznM()).zza(new zzbj.zzl(zzb), uri, i);
    }

    public void zza(zza.zzb<DataApi.GetFdForAssetResult> zzb, Asset asset) throws RemoteException {
        ((zzat) zznM()).zza(new zzbj.zzm(zzb), asset);
    }

    public void zza(zza.zzb<Status> zzb, CapabilityApi.CapabilityListener capabilityListener, String str) throws RemoteException {
        synchronized (this.zzaUX) {
            zzfh(str).zza(this, zzb, capabilityListener, zzbl.zza(capabilityListener, str));
        }
    }

    public void zza(zza.zzb<Status> zzb, ChannelApi.ChannelListener channelListener, String str) throws RemoteException {
        if (str == null) {
            this.zzaUS.zza(this, zzb, channelListener, zzbl.zzb(channelListener));
            return;
        }
        zzbf zzbf = new zzbf(str, channelListener);
        this.zzaUS.zza(this, zzb, zzbf, zzbl.zza(zzbf, str));
    }

    public void zza(zza.zzb<Status> zzb, DataApi.DataListener dataListener) throws RemoteException {
        this.zzaUT.zza(this, zzb, dataListener);
    }

    public void zza(zza.zzb<Status> zzb, DataApi.DataListener dataListener, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzaUT.zza(this, zzb, dataListener, zzbl.zza(dataListener, intentFilterArr));
    }

    public void zza(zza.zzb<DataApi.GetFdForAssetResult> zzb, DataItemAsset dataItemAsset) throws RemoteException {
        zza(zzb, Asset.createFromRef(dataItemAsset.getId()));
    }

    public void zza(zza.zzb<Status> zzb, MessageApi.MessageListener messageListener) throws RemoteException {
        this.zzaUU.zza(this, zzb, messageListener);
    }

    public void zza(zza.zzb<Status> zzb, MessageApi.MessageListener messageListener, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzaUU.zza(this, zzb, messageListener, zzbl.zza(messageListener, intentFilterArr));
    }

    public void zza(zza.zzb<Status> zzb, NodeApi.NodeListener nodeListener) throws RemoteException {
        this.zzaUV.zza(this, zzb, nodeListener, zzbl.zza(nodeListener));
    }

    public void zza(zza.zzb<DataApi.DataItemResult> zzb, PutDataRequest putDataRequest) throws RemoteException {
        for (Map.Entry<String, Asset> entry : putDataRequest.getAssets().entrySet()) {
            Asset value = entry.getValue();
            if (value.getData() == null && value.getDigest() == null && value.getFd() == null && value.getUri() == null) {
                throw new IllegalArgumentException("Put for " + putDataRequest.getUri() + " contains invalid asset: " + value);
            }
        }
        PutDataRequest zzn = PutDataRequest.zzn(putDataRequest.getUri());
        zzn.setData(putDataRequest.getData());
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Asset> entry2 : putDataRequest.getAssets().entrySet()) {
            Asset value2 = entry2.getValue();
            if (value2.getData() == null) {
                zzn.putAsset(entry2.getKey(), entry2.getValue());
            } else {
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    if (Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: replacing data with FD in asset: " + value2 + " read:" + createPipe[0] + " write:" + createPipe[1]);
                    }
                    zzn.putAsset(entry2.getKey(), Asset.createFromFd(createPipe[0]));
                    FutureTask<Boolean> zza = zza(createPipe[1], value2.getData());
                    arrayList.add(zza);
                    this.zzaNb.submit(zza);
                } catch (IOException e) {
                    throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + putDataRequest, e);
                }
            }
        }
        ((zzat) zznM()).zza(new zzbj.zzq(zzb, arrayList), zzn);
    }

    public void zza(zza.zzb<Status> zzb, String str, Uri uri, long j, long j2) {
        try {
            this.zzaNb.submit(zzb(zzb, str, uri, j, j2));
        } catch (RuntimeException e) {
            zzb.zzr(new Status(8));
            throw e;
        }
    }

    public void zza(zza.zzb<Status> zzb, String str, Uri uri, boolean z) {
        try {
            this.zzaNb.submit(zzb(zzb, str, uri, z));
        } catch (RuntimeException e) {
            zzb.zzr(new Status(8));
            throw e;
        }
    }

    public void zza(zza.zzb<MessageApi.SendMessageResult> zzb, String str, String str2, byte[] bArr) throws RemoteException {
        ((zzat) zznM()).zza(new zzbj.zzt(zzb), str, str2, bArr);
    }

    public void zzb(zza.zzb<DataApi.DeleteDataItemsResult> zzb, Uri uri, int i) throws RemoteException {
        ((zzat) zznM()).zzb(new zzbj.zze(zzb), uri, i);
    }

    public void zzb(zza.zzb<Status> zzb, CapabilityApi.CapabilityListener capabilityListener, String str) throws RemoteException {
        synchronized (this.zzaUX) {
            zzau<CapabilityApi.CapabilityListener> zzfh = zzfh(str);
            zzfh.zza(this, zzb, capabilityListener);
            if (zzfh.isEmpty()) {
                this.zzaUX.remove(str);
            }
        }
    }

    public void zzb(zza.zzb<Status> zzb, ChannelApi.ChannelListener channelListener, String str) throws RemoteException {
        if (str == null) {
            this.zzaUS.zza(this, zzb, channelListener);
            return;
        }
        this.zzaUS.zza(this, zzb, new zzbf(str, channelListener));
    }

    public void zzb(zza.zzb<Status> zzb, NodeApi.NodeListener nodeListener) throws RemoteException {
        this.zzaUV.zza(this, zzb, nodeListener);
    }

    public void zzd(zza.zzb<CapabilityApi.GetAllCapabilitiesResult> zzb, int i) throws RemoteException {
        ((zzat) zznM()).zza(new zzbj.zzf(zzb), i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdS */
    public zzat zzT(IBinder iBinder) {
        return zzat.zza.zzdQ(iBinder);
    }

    public void zze(zza.zzb<ChannelApi.OpenChannelResult> zzb, String str, String str2) throws RemoteException {
        ((zzat) zznM()).zza(new zzbj.zzp(zzb), str, str2);
    }

    public void zzg(zza.zzb<CapabilityApi.GetCapabilityResult> zzb, String str, int i) throws RemoteException {
        ((zzat) zznM()).zza(new zzbj.zzg(zzb), str, i);
    }

    public void zzh(zza.zzb<Status> zzb, String str, int i) throws RemoteException {
        ((zzat) zznM()).zzb(new zzbj.zzd(zzb), str, i);
    }

    public void zzl(zza.zzb<DataItemBuffer> zzb) throws RemoteException {
        ((zzat) zznM()).zzb(new zzbj.zzl(zzb));
    }

    public void zzm(zza.zzb<NodeApi.GetLocalNodeResult> zzb) throws RemoteException {
        ((zzat) zznM()).zzc(new zzbj.zzn(zzb));
    }

    public void zzn(zza.zzb<NodeApi.GetConnectedNodesResult> zzb) throws RemoteException {
        ((zzat) zznM()).zzd(new zzbj.zzj(zzb));
    }

    public void zzr(zza.zzb<CapabilityApi.AddLocalCapabilityResult> zzb, String str) throws RemoteException {
        ((zzat) zznM()).zzd(new zzbj.zza(zzb), str);
    }

    public void zzs(zza.zzb<CapabilityApi.RemoveLocalCapabilityResult> zzb, String str) throws RemoteException {
        ((zzat) zznM()).zze(new zzbj.zzs(zzb), str);
    }

    public void zzt(zza.zzb<Status> zzb, String str) throws RemoteException {
        ((zzat) zznM()).zzf(new zzbj.zzc(zzb), str);
    }

    public void zzu(zza.zzb<Channel.GetInputStreamResult> zzb, String str) throws RemoteException {
        zzq zzq = new zzq();
        ((zzat) zznM()).zza(new zzbj.zzh(zzb, zzq), zzq, str);
    }

    public void zzv(zza.zzb<Channel.GetOutputStreamResult> zzb, String str) throws RemoteException {
        zzq zzq = new zzq();
        ((zzat) zznM()).zzb(new zzbj.zzi(zzb, zzq), zzq, str);
    }
}
