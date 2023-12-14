package com.google.android.gms.auth.api.credentials.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks;

public interface ICredentialsService extends IInterface {

    public static abstract class zza extends Binder implements ICredentialsService {

        /* access modifiers changed from: private */
        /* renamed from: com.google.android.gms.auth.api.credentials.internal.ICredentialsService$zza$zza  reason: collision with other inner class name */
        public static class C0024zza implements ICredentialsService {
            private IBinder zznF;

            C0024zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }

            @Override // com.google.android.gms.auth.api.credentials.internal.ICredentialsService
            public void performCredentialsDeleteOperation(ICredentialsCallbacks callbacks, DeleteRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(callbacks != null ? callbacks.asBinder() : null);
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.auth.api.credentials.internal.ICredentialsService
            public void performCredentialsRequestOperation(ICredentialsCallbacks callbacks, CredentialRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(callbacks != null ? callbacks.asBinder() : null);
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.auth.api.credentials.internal.ICredentialsService
            public void performCredentialsSaveOperation(ICredentialsCallbacks callbacks, SaveRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(callbacks != null ? callbacks.asBinder() : null);
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.auth.api.credentials.internal.ICredentialsService
            public void performDisableAutoSignInOperation(ICredentialsCallbacks callbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(callbacks != null ? callbacks.asBinder() : null);
                    this.zznF.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static ICredentialsService zzaq(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ICredentialsService)) ? new C0024zza(iBinder) : (ICredentialsService) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            DeleteRequest deleteRequest = null;
            CredentialRequest credentialRequest = null;
            SaveRequest saveRequest = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    ICredentialsCallbacks zzap = ICredentialsCallbacks.zza.zzap(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        credentialRequest = CredentialRequest.CREATOR.createFromParcel(data);
                    }
                    performCredentialsRequestOperation(zzap, credentialRequest);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    ICredentialsCallbacks zzap2 = ICredentialsCallbacks.zza.zzap(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        saveRequest = SaveRequest.CREATOR.createFromParcel(data);
                    }
                    performCredentialsSaveOperation(zzap2, saveRequest);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    ICredentialsCallbacks zzap3 = ICredentialsCallbacks.zza.zzap(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        deleteRequest = DeleteRequest.CREATOR.createFromParcel(data);
                    }
                    performCredentialsDeleteOperation(zzap3, deleteRequest);
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    performDisableAutoSignInOperation(ICredentialsCallbacks.zza.zzap(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void performCredentialsDeleteOperation(ICredentialsCallbacks iCredentialsCallbacks, DeleteRequest deleteRequest) throws RemoteException;

    void performCredentialsRequestOperation(ICredentialsCallbacks iCredentialsCallbacks, CredentialRequest credentialRequest) throws RemoteException;

    void performCredentialsSaveOperation(ICredentialsCallbacks iCredentialsCallbacks, SaveRequest saveRequest) throws RemoteException;

    void performDisableAutoSignInOperation(ICredentialsCallbacks iCredentialsCallbacks) throws RemoteException;
}
