package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.zzi;

public interface zze extends IInterface {

    public static abstract class zza extends Binder implements zze {

        /* access modifiers changed from: private */
        /* renamed from: com.google.android.gms.maps.internal.zze$zza$zza  reason: collision with other inner class name */
        public static class C0175zza implements zze {
            private IBinder zznF;

            C0175zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }

            @Override // com.google.android.gms.maps.internal.zze
            public Bitmap zza(zzi zzi, int i, int i2) throws RemoteException {
                Bitmap bitmap = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowRenderer");
                    obtain.writeStrongBinder(zzi != null ? zzi.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.zznF.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bitmap = (Bitmap) Bitmap.CREATOR.createFromParcel(obtain2);
                    }
                    return bitmap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zze zzcj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowRenderer");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zze)) ? new C0175zza(iBinder) : (zze) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowRenderer");
                    Bitmap zza = zza(zzi.zza.zzcP(data.readStrongBinder()), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (zza != null) {
                        reply.writeInt(1);
                        zza.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IInfoWindowRenderer");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    Bitmap zza(zzi zzi, int i, int i2) throws RemoteException;
}
