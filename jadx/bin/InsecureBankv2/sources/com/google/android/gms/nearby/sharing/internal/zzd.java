package com.google.android.gms.nearby.sharing.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.sharing.internal.zzc;

public interface zzd extends IInterface {

    public static abstract class zza extends Binder implements zzd {

        /* access modifiers changed from: private */
        /* renamed from: com.google.android.gms.nearby.sharing.internal.zzd$zza$zza  reason: collision with other inner class name */
        public static class C0212zza implements zzd {
            private IBinder zznF;

            C0212zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }

            @Override // com.google.android.gms.nearby.sharing.internal.zzd
            public void zza(ProvideContentRequest provideContentRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (provideContentRequest != null) {
                        obtain.writeInt(1);
                        provideContentRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.nearby.sharing.internal.zzd
            public void zza(ReceiveContentRequest receiveContentRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (receiveContentRequest != null) {
                        obtain.writeInt(1);
                        receiveContentRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.nearby.sharing.internal.zzd
            public void zza(StopProvidingContentRequest stopProvidingContentRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (stopProvidingContentRequest != null) {
                        obtain.writeInt(1);
                        stopProvidingContentRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.nearby.sharing.internal.zzd
            public void zza(TrustedDevicesRequest trustedDevicesRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (trustedDevicesRequest != null) {
                        obtain.writeInt(1);
                        trustedDevicesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.nearby.sharing.internal.zzd
            public void zza(zzc zzc) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (zzc != null) {
                        iBinder = zzc.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznF.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzd zzdk(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzd)) ? new C0212zza(iBinder) : (zzd) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ReceiveContentRequest receiveContentRequest = null;
            ProvideContentRequest provideContentRequest = null;
            StopProvidingContentRequest stopProvidingContentRequest = null;
            TrustedDevicesRequest trustedDevicesRequest = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (data.readInt() != 0) {
                        provideContentRequest = ProvideContentRequest.CREATOR.createFromParcel(data);
                    }
                    zza(provideContentRequest);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (data.readInt() != 0) {
                        stopProvidingContentRequest = StopProvidingContentRequest.CREATOR.createFromParcel(data);
                    }
                    zza(stopProvidingContentRequest);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (data.readInt() != 0) {
                        trustedDevicesRequest = TrustedDevicesRequest.CREATOR.createFromParcel(data);
                    }
                    zza(trustedDevicesRequest);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (data.readInt() != 0) {
                        receiveContentRequest = ReceiveContentRequest.CREATOR.createFromParcel(data);
                    }
                    zza(receiveContentRequest);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    zza(zzc.zza.zzdj(data.readStrongBinder()));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(ProvideContentRequest provideContentRequest) throws RemoteException;

    void zza(ReceiveContentRequest receiveContentRequest) throws RemoteException;

    void zza(StopProvidingContentRequest stopProvidingContentRequest) throws RemoteException;

    void zza(TrustedDevicesRequest trustedDevicesRequest) throws RemoteException;

    void zza(zzc zzc) throws RemoteException;
}
