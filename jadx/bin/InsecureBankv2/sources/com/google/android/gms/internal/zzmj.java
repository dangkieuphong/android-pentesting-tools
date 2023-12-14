package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.DataTypeReadRequest;
import com.google.android.gms.fitness.request.DisableFitRequest;

public interface zzmj extends IInterface {

    public static abstract class zza extends Binder implements zzmj {

        /* access modifiers changed from: private */
        /* renamed from: com.google.android.gms.internal.zzmj$zza$zza  reason: collision with other inner class name */
        public static class C0112zza implements zzmj {
            private IBinder zznF;

            C0112zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }

            @Override // com.google.android.gms.internal.zzmj
            public void zza(DataTypeCreateRequest dataTypeCreateRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (dataTypeCreateRequest != null) {
                        obtain.writeInt(1);
                        dataTypeCreateRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzmj
            public void zza(DataTypeReadRequest dataTypeReadRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (dataTypeReadRequest != null) {
                        obtain.writeInt(1);
                        dataTypeReadRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzmj
            public void zza(DisableFitRequest disableFitRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (disableFitRequest != null) {
                        obtain.writeInt(1);
                        disableFitRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(22, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzmj zzbu(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzmj)) ? new C0112zza(iBinder) : (zzmj) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            DisableFitRequest disableFitRequest = null;
            DataTypeCreateRequest dataTypeCreateRequest = null;
            DataTypeReadRequest dataTypeReadRequest = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (data.readInt() != 0) {
                        dataTypeCreateRequest = DataTypeCreateRequest.CREATOR.createFromParcel(data);
                    }
                    zza(dataTypeCreateRequest);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (data.readInt() != 0) {
                        dataTypeReadRequest = DataTypeReadRequest.CREATOR.createFromParcel(data);
                    }
                    zza(dataTypeReadRequest);
                    return true;
                case 22:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (data.readInt() != 0) {
                        disableFitRequest = DisableFitRequest.CREATOR.createFromParcel(data);
                    }
                    zza(disableFitRequest);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(DataTypeCreateRequest dataTypeCreateRequest) throws RemoteException;

    void zza(DataTypeReadRequest dataTypeReadRequest) throws RemoteException;

    void zza(DisableFitRequest disableFitRequest) throws RemoteException;
}
