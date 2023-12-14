package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.SessionRegistrationRequest;
import com.google.android.gms.fitness.request.SessionStartRequest;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;

public interface zzmo extends IInterface {

    public static abstract class zza extends Binder implements zzmo {

        /* access modifiers changed from: private */
        /* renamed from: com.google.android.gms.internal.zzmo$zza$zza  reason: collision with other inner class name */
        public static class C0117zza implements zzmo {
            private IBinder zznF;

            C0117zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }

            @Override // com.google.android.gms.internal.zzmo
            public void zza(SessionInsertRequest sessionInsertRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionInsertRequest != null) {
                        obtain.writeInt(1);
                        sessionInsertRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzmo
            public void zza(SessionReadRequest sessionReadRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionReadRequest != null) {
                        obtain.writeInt(1);
                        sessionReadRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzmo
            public void zza(SessionRegistrationRequest sessionRegistrationRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionRegistrationRequest != null) {
                        obtain.writeInt(1);
                        sessionRegistrationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzmo
            public void zza(SessionStartRequest sessionStartRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionStartRequest != null) {
                        obtain.writeInt(1);
                        sessionStartRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzmo
            public void zza(SessionStopRequest sessionStopRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionStopRequest != null) {
                        obtain.writeInt(1);
                        sessionStopRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzmo
            public void zza(SessionUnregistrationRequest sessionUnregistrationRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionUnregistrationRequest != null) {
                        obtain.writeInt(1);
                        sessionUnregistrationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzmo zzbz(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzmo)) ? new C0117zza(iBinder) : (zzmo) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            SessionUnregistrationRequest sessionUnregistrationRequest = null;
            SessionStartRequest sessionStartRequest = null;
            SessionStopRequest sessionStopRequest = null;
            SessionInsertRequest sessionInsertRequest = null;
            SessionReadRequest sessionReadRequest = null;
            SessionRegistrationRequest sessionRegistrationRequest = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (data.readInt() != 0) {
                        sessionStartRequest = SessionStartRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sessionStartRequest);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (data.readInt() != 0) {
                        sessionStopRequest = SessionStopRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sessionStopRequest);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (data.readInt() != 0) {
                        sessionInsertRequest = SessionInsertRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sessionInsertRequest);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (data.readInt() != 0) {
                        sessionReadRequest = SessionReadRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sessionReadRequest);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (data.readInt() != 0) {
                        sessionRegistrationRequest = SessionRegistrationRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sessionRegistrationRequest);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (data.readInt() != 0) {
                        sessionUnregistrationRequest = SessionUnregistrationRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sessionUnregistrationRequest);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(SessionInsertRequest sessionInsertRequest) throws RemoteException;

    void zza(SessionReadRequest sessionReadRequest) throws RemoteException;

    void zza(SessionRegistrationRequest sessionRegistrationRequest) throws RemoteException;

    void zza(SessionStartRequest sessionStartRequest) throws RemoteException;

    void zza(SessionStopRequest sessionStopRequest) throws RemoteException;

    void zza(SessionUnregistrationRequest sessionUnregistrationRequest) throws RemoteException;
}
