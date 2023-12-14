package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.zznl;

public interface zznm extends IInterface {

    public static abstract class zza extends Binder implements zznm {

        /* access modifiers changed from: private */
        /* renamed from: com.google.android.gms.internal.zznm$zza$zza  reason: collision with other inner class name */
        public static class C0128zza implements zznm {
            private IBinder zznF;

            C0128zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }

            @Override // com.google.android.gms.internal.zznm
            public void zza(zznl zznl, UserAddressRequest userAddressRequest, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.identity.intents.internal.IAddressService");
                    obtain.writeStrongBinder(zznl != null ? zznl.asBinder() : null);
                    if (userAddressRequest != null) {
                        obtain.writeInt(1);
                        userAddressRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
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
        }

        public static zznm zzbQ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.identity.intents.internal.IAddressService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zznm)) ? new C0128zza(iBinder) : (zznm) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.identity.intents.internal.IAddressService");
                    zza(zznl.zza.zzbP(data.readStrongBinder()), data.readInt() != 0 ? UserAddressRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.identity.intents.internal.IAddressService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zznl zznl, UserAddressRequest userAddressRequest, Bundle bundle) throws RemoteException;
}
