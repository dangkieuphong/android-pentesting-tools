package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.ClaimBleDeviceRequest;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.StopBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;
import com.google.android.gms.internal.zzlx;
import com.google.android.gms.internal.zzni;

public class zzmz implements BleApi {

    /* access modifiers changed from: private */
    public static class zza extends zzni.zza {
        private final zza.zzb<BleDevicesResult> zzOs;

        private zza(zza.zzb<BleDevicesResult> zzb) {
            this.zzOs = zzb;
        }

        @Override // com.google.android.gms.internal.zzni
        public void zza(BleDevicesResult bleDevicesResult) {
            this.zzOs.zzm(bleDevicesResult);
        }
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult<Status> claimBleDevice(GoogleApiClient client, final BleDevice bleDevice) {
        return client.zzb(new zzlx.zzc(client) {
            /* class com.google.android.gms.internal.zzmz.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public void zza(zzlx zzlx) throws RemoteException {
                ((zzmi) zzlx.zznM()).zza(new ClaimBleDeviceRequest(bleDevice.getAddress(), bleDevice, new zzng(this), zzlx.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult<Status> claimBleDevice(GoogleApiClient client, final String deviceAddress) {
        return client.zzb(new zzlx.zzc(client) {
            /* class com.google.android.gms.internal.zzmz.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public void zza(zzlx zzlx) throws RemoteException {
                ((zzmi) zzlx.zznM()).zza(new ClaimBleDeviceRequest(deviceAddress, null, new zzng(this), zzlx.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient client) {
        return client.zza(new zzlx.zza<BleDevicesResult>(client) {
            /* class com.google.android.gms.internal.zzmz.AnonymousClass6 */

            /* access modifiers changed from: protected */
            /* renamed from: zzB */
            public BleDevicesResult createFailedResult(Status status) {
                return BleDevicesResult.zzJ(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzlx zzlx) throws RemoteException {
                ((zzmi) zzlx.zznM()).zza(new ListClaimedBleDevicesRequest(new zza(this), zzlx.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult<Status> startBleScan(GoogleApiClient client, final StartBleScanRequest request) {
        return client.zza(new zzlx.zzc(client) {
            /* class com.google.android.gms.internal.zzmz.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zzlx zzlx) throws RemoteException {
                ((zzmi) zzlx.zznM()).zza(new StartBleScanRequest(request, new zzng(this), zzlx.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult<Status> stopBleScan(GoogleApiClient client, final BleScanCallback requestCallback) {
        return client.zza(new zzlx.zzc(client) {
            /* class com.google.android.gms.internal.zzmz.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(zzlx zzlx) throws RemoteException {
                ((zzmi) zzlx.zznM()).zza(new StopBleScanRequest(requestCallback, new zzng(this), zzlx.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return unclaimBleDevice(client, bleDevice.getAddress());
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, final String deviceAddress) {
        return client.zzb(new zzlx.zzc(client) {
            /* class com.google.android.gms.internal.zzmz.AnonymousClass5 */

            /* access modifiers changed from: protected */
            public void zza(zzlx zzlx) throws RemoteException {
                ((zzmi) zzlx.zznM()).zza(new UnclaimBleDeviceRequest(deviceAddress, new zzng(this), zzlx.getContext().getPackageName()));
            }
        });
    }
}
