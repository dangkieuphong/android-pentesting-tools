package com.google.android.gms.fitness.internal.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;
import com.google.android.gms.internal.zzmg;
import com.google.android.gms.internal.zzmu;

public interface zzc extends IInterface {

    public static abstract class zza extends Binder implements zzc {
        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            FitnessUnregistrationRequest fitnessUnregistrationRequest = null;
            FitnessDataSourcesRequest fitnessDataSourcesRequest = null;
            FitnessSensorServiceRequest fitnessSensorServiceRequest = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (data.readInt() != 0) {
                        fitnessDataSourcesRequest = FitnessDataSourcesRequest.CREATOR.createFromParcel(data);
                    }
                    zza(fitnessDataSourcesRequest, zzmg.zza.zzbr(data.readStrongBinder()));
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (data.readInt() != 0) {
                        fitnessSensorServiceRequest = FitnessSensorServiceRequest.CREATOR.createFromParcel(data);
                    }
                    zza(fitnessSensorServiceRequest, zzmu.zza.zzbF(data.readStrongBinder()));
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (data.readInt() != 0) {
                        fitnessUnregistrationRequest = FitnessUnregistrationRequest.CREATOR.createFromParcel(data);
                    }
                    zza(fitnessUnregistrationRequest, zzmu.zza.zzbF(data.readStrongBinder()));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(FitnessDataSourcesRequest fitnessDataSourcesRequest, zzmg zzmg) throws RemoteException;

    void zza(FitnessUnregistrationRequest fitnessUnregistrationRequest, zzmu zzmu) throws RemoteException;

    void zza(FitnessSensorServiceRequest fitnessSensorServiceRequest, zzmu zzmu) throws RemoteException;
}
