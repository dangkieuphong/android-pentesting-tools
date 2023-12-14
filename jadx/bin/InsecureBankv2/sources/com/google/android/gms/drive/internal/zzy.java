package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.FileUploadPreferences;
import com.google.android.gms.drive.internal.zzr;

public class zzy implements DrivePreferencesApi {

    /* access modifiers changed from: private */
    public class zza extends zzd {
        private final zza.zzb<DrivePreferencesApi.FileUploadPreferencesResult> zzOs;

        private zza(zza.zzb<DrivePreferencesApi.FileUploadPreferencesResult> zzb) {
            this.zzOs = zzb;
        }

        @Override // com.google.android.gms.drive.internal.zzal, com.google.android.gms.drive.internal.zzd
        public void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException {
            this.zzOs.zzm(new zzb(Status.zzXP, onDeviceUsagePreferenceResponse.zzpL()));
        }

        @Override // com.google.android.gms.drive.internal.zzal, com.google.android.gms.drive.internal.zzd
        public void zzt(Status status) throws RemoteException {
            this.zzOs.zzm(new zzb(status, null));
        }
    }

    /* access modifiers changed from: private */
    public class zzb implements DrivePreferencesApi.FileUploadPreferencesResult {
        private final Status zzOt;
        private final FileUploadPreferences zzafw;

        private zzb(Status status, FileUploadPreferences fileUploadPreferences) {
            this.zzOt = status;
            this.zzafw = fileUploadPreferences;
        }

        @Override // com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult
        public FileUploadPreferences getFileUploadPreferences() {
            return this.zzafw;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    private abstract class zzc extends zzr<DrivePreferencesApi.FileUploadPreferencesResult> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzz */
        public DrivePreferencesApi.FileUploadPreferencesResult createFailedResult(Status status) {
            return new zzb(status, null);
        }
    }

    @Override // com.google.android.gms.drive.DrivePreferencesApi
    public PendingResult<DrivePreferencesApi.FileUploadPreferencesResult> getFileUploadPreferences(GoogleApiClient apiClient) {
        return apiClient.zza(new zzc(apiClient) {
            /* class com.google.android.gms.drive.internal.zzy.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zzs zzs) throws RemoteException {
                zzs.zzpB().zzd(new zza(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DrivePreferencesApi
    public PendingResult<Status> setFileUploadPreferences(GoogleApiClient apiClient, FileUploadPreferences fileUploadPreferences) {
        if (!(fileUploadPreferences instanceof FileUploadPreferencesImpl)) {
            throw new IllegalArgumentException("Invalid preference value");
        }
        final FileUploadPreferencesImpl fileUploadPreferencesImpl = (FileUploadPreferencesImpl) fileUploadPreferences;
        return apiClient.zzb(new zzr.zza(apiClient) {
            /* class com.google.android.gms.drive.internal.zzy.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(zzs zzs) throws RemoteException {
                zzs.zzpB().zza(new SetFileUploadPreferencesRequest(fileUploadPreferencesImpl), new zzbq(this));
            }
        });
    }
}
