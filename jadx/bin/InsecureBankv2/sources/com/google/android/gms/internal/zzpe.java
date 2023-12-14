package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public final class zzpe implements People {

    private static abstract class zza extends Plus.zza<People.LoadPeopleResult> {
        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzaQ */
        public People.LoadPeopleResult createFailedResult(final Status status) {
            return new People.LoadPeopleResult() {
                /* class com.google.android.gms.internal.zzpe.zza.AnonymousClass1 */

                @Override // com.google.android.gms.plus.People.LoadPeopleResult
                public String getNextPageToken() {
                    return null;
                }

                @Override // com.google.android.gms.plus.People.LoadPeopleResult
                public PersonBuffer getPersonBuffer() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }

                @Override // com.google.android.gms.common.api.Releasable
                public void release() {
                }
            };
        }
    }

    @Override // com.google.android.gms.plus.People
    public Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.zzf(googleApiClient, true).zzxu();
    }

    @Override // com.google.android.gms.plus.People
    public PendingResult<People.LoadPeopleResult> load(GoogleApiClient googleApiClient, final Collection<String> personIds) {
        return googleApiClient.zza(new zza(googleApiClient) {
            /* class com.google.android.gms.internal.zzpe.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zze.zza(this, personIds);
            }
        });
    }

    @Override // com.google.android.gms.plus.People
    public PendingResult<People.LoadPeopleResult> load(GoogleApiClient googleApiClient, final String... personIds) {
        return googleApiClient.zza(new zza(googleApiClient) {
            /* class com.google.android.gms.internal.zzpe.AnonymousClass5 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zze.zzd(this, personIds);
            }
        });
    }

    @Override // com.google.android.gms.plus.People
    public PendingResult<People.LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zza(googleApiClient) {
            /* class com.google.android.gms.internal.zzpe.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zze.zzj(this);
            }
        });
    }

    @Override // com.google.android.gms.plus.People
    public PendingResult<People.LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final int orderBy, final String pageToken) {
        return googleApiClient.zza(new zza(googleApiClient) {
            /* class com.google.android.gms.internal.zzpe.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                setCancelToken(zze.zza(this, orderBy, pageToken));
            }
        });
    }

    @Override // com.google.android.gms.plus.People
    public PendingResult<People.LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final String pageToken) {
        return googleApiClient.zza(new zza(googleApiClient) {
            /* class com.google.android.gms.internal.zzpe.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                setCancelToken(zze.zzq(this, pageToken));
            }
        });
    }
}
