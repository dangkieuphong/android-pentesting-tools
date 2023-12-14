package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.request.SubscribeRequest;
import com.google.android.gms.fitness.request.UnsubscribeRequest;

public interface zzmm extends IInterface {

    public static abstract class zza extends Binder implements zzmm {

        /* access modifiers changed from: private */
        /* renamed from: com.google.android.gms.internal.zzmm$zza$zza  reason: collision with other inner class name */
        public static class C0115zza implements zzmm {
            private IBinder zznF;

            C0115zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }

            @Override // com.google.android.gms.internal.zzmm
            public void zza(ListSubscriptionsRequest listSubscriptionsRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (listSubscriptionsRequest != null) {
                        obtain.writeInt(1);
                        listSubscriptionsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzmm
            public void zza(SubscribeRequest subscribeRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (subscribeRequest != null) {
                        obtain.writeInt(1);
                        subscribeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzmm
            public void zza(UnsubscribeRequest unsubscribeRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (unsubscribeRequest != null) {
                        obtain.writeInt(1);
                        unsubscribeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzmm zzbx(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzmm)) ? new C0115zza(iBinder) : (zzmm) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ListSubscriptionsRequest listSubscriptionsRequest = null;
            SubscribeRequest subscribeRequest = null;
            UnsubscribeRequest unsubscribeRequest = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (data.readInt() != 0) {
                        subscribeRequest = SubscribeRequest.CREATOR.createFromParcel(data);
                    }
                    zza(subscribeRequest);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (data.readInt() != 0) {
                        unsubscribeRequest = UnsubscribeRequest.CREATOR.createFromParcel(data);
                    }
                    zza(unsubscribeRequest);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (data.readInt() != 0) {
                        listSubscriptionsRequest = ListSubscriptionsRequest.CREATOR.createFromParcel(data);
                    }
                    zza(listSubscriptionsRequest);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(ListSubscriptionsRequest listSubscriptionsRequest) throws RemoteException;

    void zza(SubscribeRequest subscribeRequest) throws RemoteException;

    void zza(UnsubscribeRequest unsubscribeRequest) throws RemoteException;
}
