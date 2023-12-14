package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.signin.internal.zze;

public interface zzf extends IInterface {

    public static abstract class zza extends Binder implements zzf {

        /* access modifiers changed from: private */
        /* renamed from: com.google.android.gms.signin.internal.zzf$zza$zza  reason: collision with other inner class name */
        public static class C0220zza implements zzf {
            private IBinder zznF;

            C0220zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }

            @Override // com.google.android.gms.signin.internal.zzf
            public void zza(int i, Account account, zze zze) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zze != null ? zze.asBinder() : null);
                    this.zznF.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.signin.internal.zzf
            public void zza(AuthAccountRequest authAccountRequest, zze zze) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (authAccountRequest != null) {
                        obtain.writeInt(1);
                        authAccountRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zze != null ? zze.asBinder() : null);
                    this.zznF.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.signin.internal.zzf
            public void zza(IAccountAccessor iAccountAccessor, int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(iAccountAccessor != null ? iAccountAccessor.asBinder() : null);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.zznF.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.signin.internal.zzf
            public void zza(ResolveAccountRequest resolveAccountRequest, zzq zzq) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (resolveAccountRequest != null) {
                        obtain.writeInt(1);
                        resolveAccountRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzq != null ? zzq.asBinder() : null);
                    this.zznF.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.signin.internal.zzf
            public void zza(CheckServerAuthResult checkServerAuthResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (checkServerAuthResult != null) {
                        obtain.writeInt(1);
                        checkServerAuthResult.writeToParcel(obtain, 0);
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

            @Override // com.google.android.gms.signin.internal.zzf
            public void zzal(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zznF.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.signin.internal.zzf
            public void zziQ(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    this.zznF.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzf zzdD(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzf)) ? new C0220zza(iBinder) : (zzf) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            Account account = null;
            AuthAccountRequest authAccountRequest = null;
            CheckServerAuthResult checkServerAuthResult = null;
            ResolveAccountRequest resolveAccountRequest = null;
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (data.readInt() != 0) {
                        authAccountRequest = AuthAccountRequest.CREATOR.createFromParcel(data);
                    }
                    zza(authAccountRequest, zze.zza.zzdC(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (data.readInt() != 0) {
                        checkServerAuthResult = CheckServerAuthResult.CREATOR.createFromParcel(data);
                    }
                    zza(checkServerAuthResult);
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    zzal(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (data.readInt() != 0) {
                        resolveAccountRequest = ResolveAccountRequest.CREATOR.createFromParcel(data);
                    }
                    zza(resolveAccountRequest, zzq.zza.zzaH(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    zziQ(data.readInt());
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    int readInt = data.readInt();
                    if (data.readInt() != 0) {
                        account = (Account) Account.CREATOR.createFromParcel(data);
                    }
                    zza(readInt, account, zze.zza.zzdC(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    IAccountAccessor zzaD = IAccountAccessor.zza.zzaD(data.readStrongBinder());
                    int readInt2 = data.readInt();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zza(zzaD, readInt2, z);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.signin.internal.ISignInService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(int i, Account account, zze zze) throws RemoteException;

    void zza(AuthAccountRequest authAccountRequest, zze zze) throws RemoteException;

    void zza(IAccountAccessor iAccountAccessor, int i, boolean z) throws RemoteException;

    void zza(ResolveAccountRequest resolveAccountRequest, zzq zzq) throws RemoteException;

    void zza(CheckServerAuthResult checkServerAuthResult) throws RemoteException;

    void zzal(boolean z) throws RemoteException;

    void zziQ(int i) throws RemoteException;
}
