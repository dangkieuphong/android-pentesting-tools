package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public final class zzpd implements Moments {

    private static abstract class zza extends Plus.zza<Moments.LoadMomentsResult> {
        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzaP */
        public Moments.LoadMomentsResult createFailedResult(final Status status) {
            return new Moments.LoadMomentsResult() {
                /* class com.google.android.gms.internal.zzpd.zza.AnonymousClass1 */

                @Override // com.google.android.gms.plus.Moments.LoadMomentsResult
                public MomentBuffer getMomentBuffer() {
                    return null;
                }

                @Override // com.google.android.gms.plus.Moments.LoadMomentsResult
                public String getNextPageToken() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }

                @Override // com.google.android.gms.plus.Moments.LoadMomentsResult
                public String getUpdated() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Releasable
                public void release() {
                }
            };
        }
    }

    private static abstract class zzb extends Plus.zza<Status> {
        private zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzb */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    private static abstract class zzc extends Plus.zza<Status> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzb */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    @Override // com.google.android.gms.plus.Moments
    public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zza(googleApiClient) {
            /* class com.google.android.gms.internal.zzpd.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zze.zzi(this);
            }
        });
    }

    @Override // com.google.android.gms.plus.Moments
    public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient googleApiClient, final int maxResults, final String pageToken, final Uri targetUrl, final String type, final String userId) {
        return googleApiClient.zza(new zza(googleApiClient) {
            /* class com.google.android.gms.internal.zzpd.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zze.zza(this, maxResults, pageToken, targetUrl, type, userId);
            }
        });
    }

    @Override // com.google.android.gms.plus.Moments
    public PendingResult<Status> remove(GoogleApiClient googleApiClient, final String momentId) {
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* class com.google.android.gms.internal.zzpd.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zze.zzdX(momentId);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.plus.Moments
    public PendingResult<Status> write(GoogleApiClient googleApiClient, final Moment moment) {
        return googleApiClient.zzb(new zzc(googleApiClient) {
            /* class com.google.android.gms.internal.zzpd.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zze.zza(this, moment);
            }
        });
    }
}
