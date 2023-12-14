package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;
import com.google.android.gms.drive.internal.zzal;
import com.google.android.gms.drive.internal.zzam;

public interface zzak extends IInterface {

    public static abstract class zza extends Binder implements zzak {

        /* access modifiers changed from: private */
        /* renamed from: com.google.android.gms.drive.internal.zzak$zza$zza  reason: collision with other inner class name */
        public static class C0038zza implements zzak {
            private IBinder zznF;

            C0038zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public IntentSender zza(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        createFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public IntentSender zza(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        openFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public DriveServiceResponse zza(OpenContentsRequest openContentsRequest, zzal zzal) throws RemoteException {
                DriveServiceResponse driveServiceResponse = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openContentsRequest != null) {
                        obtain.writeInt(1);
                        openContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        driveServiceResponse = DriveServiceResponse.CREATOR.createFromParcel(obtain2);
                    }
                    return driveServiceResponse;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (realtimeDocumentSyncRequest != null) {
                        obtain.writeInt(1);
                        realtimeDocumentSyncRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(AddEventListenerRequest addEventListenerRequest, zzam zzam, String str, zzal zzal) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (addEventListenerRequest != null) {
                        obtain.writeInt(1);
                        addEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    obtain.writeString(str);
                    if (zzal != null) {
                        iBinder = zzal.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznF.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(AddPermissionRequest addPermissionRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (addPermissionRequest != null) {
                        obtain.writeInt(1);
                        addPermissionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(AuthorizeAccessRequest authorizeAccessRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (authorizeAccessRequest != null) {
                        obtain.writeInt(1);
                        authorizeAccessRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(CancelPendingActionsRequest cancelPendingActionsRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (cancelPendingActionsRequest != null) {
                        obtain.writeInt(1);
                        cancelPendingActionsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(CheckResourceIdsExistRequest checkResourceIdsExistRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (checkResourceIdsExistRequest != null) {
                        obtain.writeInt(1);
                        checkResourceIdsExistRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsAndUpdateMetadataRequest != null) {
                        obtain.writeInt(1);
                        closeContentsAndUpdateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(CloseContentsRequest closeContentsRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsRequest != null) {
                        obtain.writeInt(1);
                        closeContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(CreateContentsRequest createContentsRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createContentsRequest != null) {
                        obtain.writeInt(1);
                        createContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(CreateFileRequest createFileRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileRequest != null) {
                        obtain.writeInt(1);
                        createFileRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(CreateFolderRequest createFolderRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFolderRequest != null) {
                        obtain.writeInt(1);
                        createFolderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(DeleteResourceRequest deleteResourceRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (deleteResourceRequest != null) {
                        obtain.writeInt(1);
                        deleteResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(DisconnectRequest disconnectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (disconnectRequest != null) {
                        obtain.writeInt(1);
                        disconnectRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(FetchThumbnailRequest fetchThumbnailRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (fetchThumbnailRequest != null) {
                        obtain.writeInt(1);
                        fetchThumbnailRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(GetChangesRequest getChangesRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getChangesRequest != null) {
                        obtain.writeInt(1);
                        getChangesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getDriveIdFromUniqueIdentifierRequest != null) {
                        obtain.writeInt(1);
                        getDriveIdFromUniqueIdentifierRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(GetMetadataRequest getMetadataRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getMetadataRequest != null) {
                        obtain.writeInt(1);
                        getMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(GetPermissionsRequest getPermissionsRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getPermissionsRequest != null) {
                        obtain.writeInt(1);
                        getPermissionsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(ListParentsRequest listParentsRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (listParentsRequest != null) {
                        obtain.writeInt(1);
                        listParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(LoadRealtimeRequest loadRealtimeRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (loadRealtimeRequest != null) {
                        obtain.writeInt(1);
                        loadRealtimeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(QueryRequest queryRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(QueryRequest queryRequest, zzam zzam, zzal zzal) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    if (zzal != null) {
                        iBinder = zzal.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznF.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(RemoveEventListenerRequest removeEventListenerRequest, zzam zzam, String str, zzal zzal) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (removeEventListenerRequest != null) {
                        obtain.writeInt(1);
                        removeEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    obtain.writeString(str);
                    if (zzal != null) {
                        iBinder = zzal.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznF.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(RemovePermissionRequest removePermissionRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (removePermissionRequest != null) {
                        obtain.writeInt(1);
                        removePermissionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(SetDrivePreferencesRequest setDrivePreferencesRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setDrivePreferencesRequest != null) {
                        obtain.writeInt(1);
                        setDrivePreferencesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setFileUploadPreferencesRequest != null) {
                        obtain.writeInt(1);
                        setFileUploadPreferencesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(SetResourceParentsRequest setResourceParentsRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setResourceParentsRequest != null) {
                        obtain.writeInt(1);
                        setResourceParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(TrashResourceRequest trashResourceRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (trashResourceRequest != null) {
                        obtain.writeInt(1);
                        trashResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(UnsubscribeResourceRequest unsubscribeResourceRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (unsubscribeResourceRequest != null) {
                        obtain.writeInt(1);
                        unsubscribeResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(UntrashResourceRequest untrashResourceRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (untrashResourceRequest != null) {
                        obtain.writeInt(1);
                        untrashResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(UpdateMetadataRequest updateMetadataRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updateMetadataRequest != null) {
                        obtain.writeInt(1);
                        updateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(UpdatePermissionRequest updatePermissionRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updatePermissionRequest != null) {
                        obtain.writeInt(1);
                        updatePermissionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(zzam zzam, zzal zzal) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    if (zzal != null) {
                        iBinder = zzal.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznF.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zzb(QueryRequest queryRequest, zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zzb(zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zzc(zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zzd(zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zze(zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zzf(zzal zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzal != null ? zzal.asBinder() : null);
                    this.zznF.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzak zzaO(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzak)) ? new C0038zza(iBinder) : (zzak) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            QueryRequest queryRequest = null;
            GetMetadataRequest getMetadataRequest = null;
            QueryRequest queryRequest2 = null;
            UpdateMetadataRequest updateMetadataRequest = null;
            CreateContentsRequest createContentsRequest = null;
            CreateFileRequest createFileRequest = null;
            CreateFolderRequest createFolderRequest = null;
            OpenContentsRequest openContentsRequest = null;
            CloseContentsRequest closeContentsRequest = null;
            OpenFileIntentSenderRequest openFileIntentSenderRequest = null;
            CreateFileIntentSenderRequest createFileIntentSenderRequest = null;
            AuthorizeAccessRequest authorizeAccessRequest = null;
            ListParentsRequest listParentsRequest = null;
            AddEventListenerRequest addEventListenerRequest = null;
            RemoveEventListenerRequest removeEventListenerRequest = null;
            DisconnectRequest disconnectRequest = null;
            TrashResourceRequest trashResourceRequest = null;
            CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest = null;
            QueryRequest queryRequest3 = null;
            DeleteResourceRequest deleteResourceRequest = null;
            LoadRealtimeRequest loadRealtimeRequest = null;
            SetResourceParentsRequest setResourceParentsRequest = null;
            GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest = null;
            CheckResourceIdsExistRequest checkResourceIdsExistRequest = null;
            SetDrivePreferencesRequest setDrivePreferencesRequest = null;
            RealtimeDocumentSyncRequest realtimeDocumentSyncRequest = null;
            SetFileUploadPreferencesRequest setFileUploadPreferencesRequest = null;
            CancelPendingActionsRequest cancelPendingActionsRequest = null;
            UntrashResourceRequest untrashResourceRequest = null;
            FetchThumbnailRequest fetchThumbnailRequest = null;
            GetChangesRequest getChangesRequest = null;
            UnsubscribeResourceRequest unsubscribeResourceRequest = null;
            GetPermissionsRequest getPermissionsRequest = null;
            AddPermissionRequest addPermissionRequest = null;
            UpdatePermissionRequest updatePermissionRequest = null;
            RemovePermissionRequest removePermissionRequest = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        getMetadataRequest = GetMetadataRequest.CREATOR.createFromParcel(data);
                    }
                    zza(getMetadataRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        queryRequest2 = QueryRequest.CREATOR.createFromParcel(data);
                    }
                    zza(queryRequest2, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        updateMetadataRequest = UpdateMetadataRequest.CREATOR.createFromParcel(data);
                    }
                    zza(updateMetadataRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        createContentsRequest = CreateContentsRequest.CREATOR.createFromParcel(data);
                    }
                    zza(createContentsRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        createFileRequest = CreateFileRequest.CREATOR.createFromParcel(data);
                    }
                    zza(createFileRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        createFolderRequest = CreateFolderRequest.CREATOR.createFromParcel(data);
                    }
                    zza(createFolderRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        openContentsRequest = OpenContentsRequest.CREATOR.createFromParcel(data);
                    }
                    DriveServiceResponse zza = zza(openContentsRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    if (zza != null) {
                        reply.writeInt(1);
                        zza.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        closeContentsRequest = CloseContentsRequest.CREATOR.createFromParcel(data);
                    }
                    zza(closeContentsRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        openFileIntentSenderRequest = OpenFileIntentSenderRequest.CREATOR.createFromParcel(data);
                    }
                    IntentSender zza2 = zza(openFileIntentSenderRequest);
                    reply.writeNoException();
                    if (zza2 != null) {
                        reply.writeInt(1);
                        zza2.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        createFileIntentSenderRequest = CreateFileIntentSenderRequest.CREATOR.createFromParcel(data);
                    }
                    IntentSender zza3 = zza(createFileIntentSenderRequest);
                    reply.writeNoException();
                    if (zza3 != null) {
                        reply.writeInt(1);
                        zza3.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        authorizeAccessRequest = AuthorizeAccessRequest.CREATOR.createFromParcel(data);
                    }
                    zza(authorizeAccessRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        listParentsRequest = ListParentsRequest.CREATOR.createFromParcel(data);
                    }
                    zza(listParentsRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        addEventListenerRequest = AddEventListenerRequest.CREATOR.createFromParcel(data);
                    }
                    zza(addEventListenerRequest, zzam.zza.zzaQ(data.readStrongBinder()), data.readString(), zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        removeEventListenerRequest = RemoveEventListenerRequest.CREATOR.createFromParcel(data);
                    }
                    zza(removeEventListenerRequest, zzam.zza.zzaQ(data.readStrongBinder()), data.readString(), zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 16:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        disconnectRequest = DisconnectRequest.CREATOR.createFromParcel(data);
                    }
                    zza(disconnectRequest);
                    reply.writeNoException();
                    return true;
                case 17:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        trashResourceRequest = TrashResourceRequest.CREATOR.createFromParcel(data);
                    }
                    zza(trashResourceRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        closeContentsAndUpdateMetadataRequest = CloseContentsAndUpdateMetadataRequest.CREATOR.createFromParcel(data);
                    }
                    zza(closeContentsAndUpdateMetadataRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 19:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        queryRequest3 = QueryRequest.CREATOR.createFromParcel(data);
                    }
                    zzb(queryRequest3, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 24:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        deleteResourceRequest = DeleteResourceRequest.CREATOR.createFromParcel(data);
                    }
                    zza(deleteResourceRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 27:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        loadRealtimeRequest = LoadRealtimeRequest.CREATOR.createFromParcel(data);
                    }
                    zza(loadRealtimeRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 28:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        setResourceParentsRequest = SetResourceParentsRequest.CREATOR.createFromParcel(data);
                    }
                    zza(setResourceParentsRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 29:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        getDriveIdFromUniqueIdentifierRequest = GetDriveIdFromUniqueIdentifierRequest.CREATOR.createFromParcel(data);
                    }
                    zza(getDriveIdFromUniqueIdentifierRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 30:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        checkResourceIdsExistRequest = CheckResourceIdsExistRequest.CREATOR.createFromParcel(data);
                    }
                    zza(checkResourceIdsExistRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 31:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzb(zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 32:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzc(zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 33:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        setDrivePreferencesRequest = SetDrivePreferencesRequest.CREATOR.createFromParcel(data);
                    }
                    zza(setDrivePreferencesRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 34:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        realtimeDocumentSyncRequest = RealtimeDocumentSyncRequest.CREATOR.createFromParcel(data);
                    }
                    zza(realtimeDocumentSyncRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 35:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzd(zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 36:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        setFileUploadPreferencesRequest = SetFileUploadPreferencesRequest.CREATOR.createFromParcel(data);
                    }
                    zza(setFileUploadPreferencesRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 37:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        cancelPendingActionsRequest = CancelPendingActionsRequest.CREATOR.createFromParcel(data);
                    }
                    zza(cancelPendingActionsRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 38:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        untrashResourceRequest = UntrashResourceRequest.CREATOR.createFromParcel(data);
                    }
                    zza(untrashResourceRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 41:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zze(zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 42:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        fetchThumbnailRequest = FetchThumbnailRequest.CREATOR.createFromParcel(data);
                    }
                    zza(fetchThumbnailRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 43:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzf(zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 44:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        getChangesRequest = GetChangesRequest.CREATOR.createFromParcel(data);
                    }
                    zza(getChangesRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 46:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        unsubscribeResourceRequest = UnsubscribeResourceRequest.CREATOR.createFromParcel(data);
                    }
                    zza(unsubscribeResourceRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 47:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        getPermissionsRequest = GetPermissionsRequest.CREATOR.createFromParcel(data);
                    }
                    zza(getPermissionsRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 48:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        addPermissionRequest = AddPermissionRequest.CREATOR.createFromParcel(data);
                    }
                    zza(addPermissionRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 49:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        updatePermissionRequest = UpdatePermissionRequest.CREATOR.createFromParcel(data);
                    }
                    zza(updatePermissionRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 50:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        removePermissionRequest = RemovePermissionRequest.CREATOR.createFromParcel(data);
                    }
                    zza(removePermissionRequest, zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 51:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        queryRequest = QueryRequest.CREATOR.createFromParcel(data);
                    }
                    zza(queryRequest, zzam.zza.zzaQ(data.readStrongBinder()), zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 52:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(zzam.zza.zzaQ(data.readStrongBinder()), zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.internal.IDriveService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    IntentSender zza(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException;

    IntentSender zza(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException;

    DriveServiceResponse zza(OpenContentsRequest openContentsRequest, zzal zzal) throws RemoteException;

    void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, zzal zzal) throws RemoteException;

    void zza(AddEventListenerRequest addEventListenerRequest, zzam zzam, String str, zzal zzal) throws RemoteException;

    void zza(AddPermissionRequest addPermissionRequest, zzal zzal) throws RemoteException;

    void zza(AuthorizeAccessRequest authorizeAccessRequest, zzal zzal) throws RemoteException;

    void zza(CancelPendingActionsRequest cancelPendingActionsRequest, zzal zzal) throws RemoteException;

    void zza(CheckResourceIdsExistRequest checkResourceIdsExistRequest, zzal zzal) throws RemoteException;

    void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, zzal zzal) throws RemoteException;

    void zza(CloseContentsRequest closeContentsRequest, zzal zzal) throws RemoteException;

    void zza(CreateContentsRequest createContentsRequest, zzal zzal) throws RemoteException;

    void zza(CreateFileRequest createFileRequest, zzal zzal) throws RemoteException;

    void zza(CreateFolderRequest createFolderRequest, zzal zzal) throws RemoteException;

    void zza(DeleteResourceRequest deleteResourceRequest, zzal zzal) throws RemoteException;

    void zza(DisconnectRequest disconnectRequest) throws RemoteException;

    void zza(FetchThumbnailRequest fetchThumbnailRequest, zzal zzal) throws RemoteException;

    void zza(GetChangesRequest getChangesRequest, zzal zzal) throws RemoteException;

    void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, zzal zzal) throws RemoteException;

    void zza(GetMetadataRequest getMetadataRequest, zzal zzal) throws RemoteException;

    void zza(GetPermissionsRequest getPermissionsRequest, zzal zzal) throws RemoteException;

    void zza(ListParentsRequest listParentsRequest, zzal zzal) throws RemoteException;

    void zza(LoadRealtimeRequest loadRealtimeRequest, zzal zzal) throws RemoteException;

    void zza(QueryRequest queryRequest, zzal zzal) throws RemoteException;

    void zza(QueryRequest queryRequest, zzam zzam, zzal zzal) throws RemoteException;

    void zza(RemoveEventListenerRequest removeEventListenerRequest, zzam zzam, String str, zzal zzal) throws RemoteException;

    void zza(RemovePermissionRequest removePermissionRequest, zzal zzal) throws RemoteException;

    void zza(SetDrivePreferencesRequest setDrivePreferencesRequest, zzal zzal) throws RemoteException;

    void zza(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, zzal zzal) throws RemoteException;

    void zza(SetResourceParentsRequest setResourceParentsRequest, zzal zzal) throws RemoteException;

    void zza(TrashResourceRequest trashResourceRequest, zzal zzal) throws RemoteException;

    void zza(UnsubscribeResourceRequest unsubscribeResourceRequest, zzal zzal) throws RemoteException;

    void zza(UntrashResourceRequest untrashResourceRequest, zzal zzal) throws RemoteException;

    void zza(UpdateMetadataRequest updateMetadataRequest, zzal zzal) throws RemoteException;

    void zza(UpdatePermissionRequest updatePermissionRequest, zzal zzal) throws RemoteException;

    void zza(zzal zzal) throws RemoteException;

    void zza(zzam zzam, zzal zzal) throws RemoteException;

    void zzb(QueryRequest queryRequest, zzal zzal) throws RemoteException;

    void zzb(zzal zzal) throws RemoteException;

    void zzc(zzal zzal) throws RemoteException;

    void zzd(zzal zzal) throws RemoteException;

    void zze(zzal zzal) throws RemoteException;

    void zzf(zzal zzal) throws RemoteException;
}
