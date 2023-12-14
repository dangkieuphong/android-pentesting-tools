package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqr;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public interface zzqt extends IInterface {

    public static abstract class zza extends Binder implements zzqt {

        /* renamed from: com.google.android.gms.internal.zzqt$zza$zza  reason: collision with other inner class name */
        private static class C0146zza implements zzqt {
            private IBinder zznF;

            C0146zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }

            @Override // com.google.android.gms.internal.zzqt
            public zzqq zza(zzd zzd, zzc zzc, WalletFragmentOptions walletFragmentOptions, zzqr zzqr) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeStrongBinder(zzc != null ? zzc.asBinder() : null);
                    if (walletFragmentOptions != null) {
                        obtain.writeInt(1);
                        walletFragmentOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (zzqr != null) {
                        iBinder = zzqr.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznF.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzqq.zza.zzdF(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzqt zzdI(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzqt)) ? new C0146zza(iBinder) : (zzqt) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    zzqq zza = zza(zzd.zza.zzbg(data.readStrongBinder()), zzc.zza.zzbf(data.readStrongBinder()), data.readInt() != 0 ? WalletFragmentOptions.CREATOR.createFromParcel(data) : null, zzqr.zza.zzdG(data.readStrongBinder()));
                    reply.writeNoException();
                    if (zza != null) {
                        iBinder = zza.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    zzqq zza(zzd zzd, zzc zzc, WalletFragmentOptions walletFragmentOptions, zzqr zzqr) throws RemoteException;
}
