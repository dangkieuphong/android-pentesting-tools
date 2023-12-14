package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataTypeResult;

public interface zzmh extends IInterface {

    public static abstract class zza extends Binder implements zzmh {

        /* access modifiers changed from: private */
        /* renamed from: com.google.android.gms.internal.zzmh$zza$zza  reason: collision with other inner class name */
        public static class C0110zza implements zzmh {
            private IBinder zznF;

            C0110zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }

            @Override // com.google.android.gms.internal.zzmh
            public void zza(DataTypeResult dataTypeResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IDataTypeCallback");
                    if (dataTypeResult != null) {
                        obtain.writeInt(1);
                        dataTypeResult.writeToParcel(obtain, 0);
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
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.IDataTypeCallback");
        }

        public static zzmh zzbs(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataTypeCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzmh)) ? new C0110zza(iBinder) : (zzmh) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IDataTypeCallback");
                    zza(data.readInt() != 0 ? DataTypeResult.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IDataTypeCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(DataTypeResult dataTypeResult) throws RemoteException;
}
