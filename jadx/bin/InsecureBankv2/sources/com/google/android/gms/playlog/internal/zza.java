package com.google.android.gms.playlog.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface zza extends IInterface {

    /* renamed from: com.google.android.gms.playlog.internal.zza$zza  reason: collision with other inner class name */
    public static abstract class AbstractBinderC0213zza extends Binder implements zza {

        /* access modifiers changed from: private */
        /* renamed from: com.google.android.gms.playlog.internal.zza$zza$zza  reason: collision with other inner class name */
        public static class C0214zza implements zza {
            private IBinder zznF;

            C0214zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }

            @Override // com.google.android.gms.playlog.internal.zza
            public void zza(String str, PlayLoggerContext playLoggerContext, LogEvent logEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (playLoggerContext != null) {
                        obtain.writeInt(1);
                        playLoggerContext.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (logEvent != null) {
                        obtain.writeInt(1);
                        logEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.playlog.internal.zza
            public void zza(String str, PlayLoggerContext playLoggerContext, List<LogEvent> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (playLoggerContext != null) {
                        obtain.writeInt(1);
                        playLoggerContext.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeTypedList(list);
                    this.zznF.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.playlog.internal.zza
            public void zza(String str, PlayLoggerContext playLoggerContext, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (playLoggerContext != null) {
                        obtain.writeInt(1);
                        playLoggerContext.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByteArray(bArr);
                    this.zznF.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zza zzdp(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.playlog.internal.IPlayLogService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zza)) ? new C0214zza(iBinder) : (zza) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            PlayLoggerContext playLoggerContext = null;
            LogEvent logEvent = null;
            PlayLoggerContext playLoggerContext2 = null;
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    String readString = data.readString();
                    PlayLoggerContext zzfH = data.readInt() != 0 ? PlayLoggerContext.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        logEvent = LogEvent.CREATOR.createFromParcel(data);
                    }
                    zza(readString, zzfH, logEvent);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    String readString2 = data.readString();
                    if (data.readInt() != 0) {
                        playLoggerContext2 = PlayLoggerContext.CREATOR.createFromParcel(data);
                    }
                    zza(readString2, playLoggerContext2, data.createTypedArrayList(LogEvent.CREATOR));
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    String readString3 = data.readString();
                    if (data.readInt() != 0) {
                        playLoggerContext = PlayLoggerContext.CREATOR.createFromParcel(data);
                    }
                    zza(readString3, playLoggerContext, data.createByteArray());
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.playlog.internal.IPlayLogService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(String str, PlayLoggerContext playLoggerContext, LogEvent logEvent) throws RemoteException;

    void zza(String str, PlayLoggerContext playLoggerContext, List<LogEvent> list) throws RemoteException;

    void zza(String str, PlayLoggerContext playLoggerContext, byte[] bArr) throws RemoteException;
}
