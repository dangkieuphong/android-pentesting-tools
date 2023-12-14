package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzjo extends IInterface {

    public static abstract class zza extends Binder implements zzjo {

        /* access modifiers changed from: private */
        /* renamed from: com.google.android.gms.internal.zzjo$zza$zza  reason: collision with other inner class name */
        public static class C0099zza implements zzjo {
            private IBinder zznF;

            C0099zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }
        }

        public static zzjo zzau(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzjo)) ? new C0099zza(iBinder) : (zzjo) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1598968902:
                    reply.writeString("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }
}
