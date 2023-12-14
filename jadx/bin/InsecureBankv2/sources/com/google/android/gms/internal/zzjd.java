package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.internal.zzjc;

public interface zzjd extends IInterface {

    public static abstract class zza extends Binder implements zzjd {

        /* access modifiers changed from: private */
        /* renamed from: com.google.android.gms.internal.zzjd$zza$zza  reason: collision with other inner class name */
        public static class C0094zza implements zzjd {
            private IBinder zznF;

            C0094zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }

            @Override // com.google.android.gms.internal.zzjd
            public void zza(zzjc zzjc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(zzjc != null ? zzjc.asBinder() : null);
                    this.zznF.transact(FitnessStatusCodes.UNKNOWN_AUTH_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public void zza(zzjc zzjc, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(zzjc != null ? zzjc.asBinder() : null);
                    obtain.writeInt(i);
                    this.zznF.transact(FitnessStatusCodes.APP_MISMATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public void zza(zzjc zzjc, int i, String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(zzjc != null ? zzjc.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.zznF.transact(FitnessStatusCodes.MISSING_BLE_PERMISSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public void zza(zzjc zzjc, int i, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(zzjc != null ? zzjc.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.zznF.transact(FitnessStatusCodes.DATA_TYPE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public void zzb(zzjc zzjc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(zzjc != null ? zzjc.asBinder() : null);
                    this.zznF.transact(FitnessStatusCodes.TRANSIENT_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public void zzb(zzjc zzjc, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(zzjc != null ? zzjc.asBinder() : null);
                    obtain.writeInt(i);
                    this.zznF.transact(FitnessStatusCodes.UNSUPPORTED_PLATFORM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public void zzc(zzjc zzjc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(zzjc != null ? zzjc.asBinder() : null);
                    this.zznF.transact(FitnessStatusCodes.EQUIVALENT_SESSION_ENDED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public int zzkV() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.zznF.transact(FitnessStatusCodes.CONFLICTING_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public int zzkW() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.zznF.transact(FitnessStatusCodes.INCONSISTENT_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzjd zzal(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzjd)) ? new C0094zza(iBinder) : (zzjd) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case FitnessStatusCodes.CONFLICTING_DATA_TYPE:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    int zzkV = zzkV();
                    reply.writeNoException();
                    reply.writeInt(zzkV);
                    return true;
                case FitnessStatusCodes.INCONSISTENT_DATA_TYPE:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    int zzkW = zzkW();
                    reply.writeNoException();
                    reply.writeInt(zzkW);
                    return true;
                case FitnessStatusCodes.DATA_TYPE_NOT_FOUND:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(zzjc.zza.zzak(data.readStrongBinder()), data.readInt(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.APP_MISMATCH:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(zzjc.zza.zzak(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.UNKNOWN_AUTH_ERROR:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(zzjc.zza.zzak(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.MISSING_BLE_PERMISSION:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(zzjc.zza.zzak(data.readStrongBinder()), data.readInt(), data.readString(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.UNSUPPORTED_PLATFORM:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzb(zzjc.zza.zzak(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.TRANSIENT_ERROR:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzb(zzjc.zza.zzak(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.EQUIVALENT_SESSION_ENDED:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzc(zzjc.zza.zzak(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.appstate.internal.IAppStateService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzjc zzjc) throws RemoteException;

    void zza(zzjc zzjc, int i) throws RemoteException;

    void zza(zzjc zzjc, int i, String str, byte[] bArr) throws RemoteException;

    void zza(zzjc zzjc, int i, byte[] bArr) throws RemoteException;

    void zzb(zzjc zzjc) throws RemoteException;

    void zzb(zzjc zzjc, int i) throws RemoteException;

    void zzc(zzjc zzjc) throws RemoteException;

    int zzkV() throws RemoteException;

    int zzkW() throws RemoteException;
}
