package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzm;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.util.Locale;
import org.json.JSONObject;

public class RemoteMediaPlayer implements Cast.MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    private final zzm zzSt = new zzm(null) {
        /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass1 */

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.cast.internal.zzm
        public void onMetadataUpdated() {
            RemoteMediaPlayer.this.onMetadataUpdated();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.cast.internal.zzm
        public void onPreloadStatusUpdated() {
            RemoteMediaPlayer.this.onPreloadStatusUpdated();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.cast.internal.zzm
        public void onQueueStatusUpdated() {
            RemoteMediaPlayer.this.onQueueStatusUpdated();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.cast.internal.zzm
        public void onStatusUpdated() {
            RemoteMediaPlayer.this.onStatusUpdated();
        }
    };
    private final zza zzSu = new zza();
    private OnPreloadStatusUpdatedListener zzSv;
    private OnQueueStatusUpdatedListener zzSw;
    private OnMetadataUpdatedListener zzSx;
    private OnStatusUpdatedListener zzSy;
    private final Object zzqt = new Object();

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnPreloadStatusUpdatedListener {
        void onPreloadStatusUpdated();
    }

    public interface OnQueueStatusUpdatedListener {
        void onQueueStatusUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    /* access modifiers changed from: private */
    public class zza implements zzn {
        private GoogleApiClient zzSW;
        private long zzSX = 0;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$zza$zza  reason: collision with other inner class name */
        private final class C0025zza implements ResultCallback<Status> {
            private final long zzSY;

            C0025zza(long j) {
                this.zzSY = j;
            }

            /* renamed from: zzm */
            public void onResult(Status status) {
                if (!status.isSuccess()) {
                    RemoteMediaPlayer.this.zzSt.zzb(this.zzSY, status.getStatusCode());
                }
            }
        }

        public zza() {
        }

        @Override // com.google.android.gms.cast.internal.zzn
        public void zza(String str, String str2, long j, String str3) throws IOException {
            if (this.zzSW == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.zzSW, str, str2).setResultCallback(new C0025zza(j));
        }

        public void zzb(GoogleApiClient googleApiClient) {
            this.zzSW = googleApiClient;
        }

        @Override // com.google.android.gms.cast.internal.zzn
        public long zzlu() {
            long j = this.zzSX + 1;
            this.zzSX = j;
            return j;
        }
    }

    private static abstract class zzb extends com.google.android.gms.cast.internal.zzb<MediaChannelResult> {
        zzo zzTa = new zzo() {
            /* class com.google.android.gms.cast.RemoteMediaPlayer.zzb.AnonymousClass1 */

            @Override // com.google.android.gms.cast.internal.zzo
            public void zza(long j, int i, Object obj) {
                zzb.this.setResult(new zzc(new Status(i), obj instanceof JSONObject ? (JSONObject) obj : null));
            }

            @Override // com.google.android.gms.cast.internal.zzo
            public void zzy(long j) {
                zzb.this.setResult(zzb.this.createFailedResult(new Status(2103)));
            }
        };

        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzn */
        public MediaChannelResult createFailedResult(final Status status) {
            return new MediaChannelResult() {
                /* class com.google.android.gms.cast.RemoteMediaPlayer.zzb.AnonymousClass2 */

                @Override // com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult
                public JSONObject getCustomData() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static final class zzc implements MediaChannelResult {
        private final Status zzOt;
        private final JSONObject zzRJ;

        zzc(Status status, JSONObject jSONObject) {
            this.zzOt = status;
            this.zzRJ = jSONObject;
        }

        @Override // com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult
        public JSONObject getCustomData() {
            return this.zzRJ;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    public RemoteMediaPlayer() {
        this.zzSt.zza(this.zzSu);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onMetadataUpdated() {
        if (this.zzSx != null) {
            this.zzSx.onMetadataUpdated();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onPreloadStatusUpdated() {
        if (this.zzSv != null) {
            this.zzSv.onPreloadStatusUpdated();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onQueueStatusUpdated() {
        if (this.zzSw != null) {
            this.zzSw.onQueueStatusUpdated();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onStatusUpdated() {
        if (this.zzSy != null) {
            this.zzSy.onStatusUpdated();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int zzaH(int i) {
        MediaStatus mediaStatus = getMediaStatus();
        for (int i2 = 0; i2 < mediaStatus.getQueueItemCount(); i2++) {
            if (mediaStatus.getQueueItem(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.zzqt) {
            approximateStreamPosition = this.zzSt.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.zzqt) {
            mediaInfo = this.zzSt.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.zzqt) {
            mediaStatus = this.zzSt.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.zzSt.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.zzqt) {
            streamDuration = this.zzSt.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo) {
        return load(apiClient, mediaInfo, true, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay) {
        return load(apiClient, mediaInfo, autoplay, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, JSONObject customData) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, customData);
    }

    public PendingResult<MediaChannelResult> load(final GoogleApiClient apiClient, final MediaInfo mediaInfo, final boolean autoplay, final long playPosition, final long[] activeTrackIds, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) {
            /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass12 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzSt.zza(this.zzTa, mediaInfo, autoplay, playPosition, activeTrackIds, customData);
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    @Override // com.google.android.gms.cast.Cast.MessageReceivedCallback
    public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
        this.zzSt.zzbB(message);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient) {
        return pause(apiClient, null);
    }

    public PendingResult<MediaChannelResult> pause(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) {
            /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass16 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzSt.zza(this.zzTa, customData);
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient) {
        return play(apiClient, null);
    }

    public PendingResult<MediaChannelResult> play(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) {
            /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass18 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzSt.zzc(this.zzTa, customData);
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueAppendItem(GoogleApiClient apiClient, MediaQueueItem item, JSONObject customData) throws IllegalArgumentException {
        return queueInsertItems(apiClient, new MediaQueueItem[]{item}, 0, customData);
    }

    public PendingResult<MediaChannelResult> queueInsertItems(final GoogleApiClient apiClient, final MediaQueueItem[] itemsToInsert, final int insertBeforeItemId, final JSONObject customData) throws IllegalArgumentException {
        return apiClient.zzb(new zzb(apiClient) {
            /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass5 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzSt.zza(this.zzTa, itemsToInsert, insertBeforeItemId, customData);
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(final GoogleApiClient apiClient, final int itemId, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) {
            /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass14 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    if (RemoteMediaPlayer.this.zzaH(itemId) == -1) {
                        setResult(createFailedResult(new Status(0)));
                        return;
                    }
                    RemoteMediaPlayer.this.zzSu.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzSt.zza(this.zzTa, itemId, (MediaQueueItem[]) null, 0, (Integer) null, customData);
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueLoad(final GoogleApiClient apiClient, final MediaQueueItem[] items, final int startIndex, final int repeatMode, final JSONObject customData) throws IllegalArgumentException {
        return apiClient.zzb(new zzb(apiClient) {
            /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzSt.zza(this.zzTa, items, startIndex, repeatMode, customData);
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueMoveItemToNewIndex(final GoogleApiClient apiClient, final int itemId, final int newIndex, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) {
            /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass15 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                int i = 0;
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    int zzaH = RemoteMediaPlayer.this.zzaH(itemId);
                    if (zzaH == -1) {
                        setResult(createFailedResult(new Status(0)));
                    } else if (newIndex < 0) {
                        setResult(createFailedResult(new Status(2001, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", Integer.valueOf(newIndex)))));
                    } else if (zzaH == newIndex) {
                        setResult(createFailedResult(new Status(0)));
                    } else {
                        MediaQueueItem queueItem = RemoteMediaPlayer.this.getMediaStatus().getQueueItem(newIndex > zzaH ? newIndex + 1 : newIndex);
                        if (queueItem != null) {
                            i = queueItem.getItemId();
                        }
                        RemoteMediaPlayer.this.zzSu.zzb(apiClient);
                        try {
                            RemoteMediaPlayer.this.zzSt.zza(this.zzTa, new int[]{itemId}, i, customData);
                        } catch (IOException e) {
                            setResult(createFailedResult(new Status(2100)));
                        } finally {
                            RemoteMediaPlayer.this.zzSu.zzb(null);
                        }
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueNext(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) {
            /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass10 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzSt.zza(this.zzTa, 0, (MediaQueueItem[]) null, 1, (Integer) null, customData);
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queuePrev(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) {
            /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass9 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzSt.zza(this.zzTa, 0, (MediaQueueItem[]) null, -1, (Integer) null, customData);
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueRemoveItem(final GoogleApiClient apiClient, final int itemId, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) {
            /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass13 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    if (RemoteMediaPlayer.this.zzaH(itemId) == -1) {
                        setResult(createFailedResult(new Status(0)));
                        return;
                    }
                    RemoteMediaPlayer.this.zzSu.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzSt.zza(this.zzTa, new int[]{itemId}, customData);
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueRemoveItems(final GoogleApiClient apiClient, final int[] itemIdsToRemove, final JSONObject customData) throws IllegalArgumentException {
        return apiClient.zzb(new zzb(apiClient) {
            /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass7 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzSt.zza(this.zzTa, itemIdsToRemove, customData);
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueReorderItems(final GoogleApiClient apiClient, final int[] itemIdsToReorder, final int insertBeforeItemId, final JSONObject customData) throws IllegalArgumentException {
        return apiClient.zzb(new zzb(apiClient) {
            /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass8 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzSt.zza(this.zzTa, itemIdsToReorder, insertBeforeItemId, customData);
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueSetRepeatMode(final GoogleApiClient apiClient, final int repeatMode, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) {
            /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass11 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzSt.zza(this.zzTa, 0, (MediaQueueItem[]) null, 0, Integer.valueOf(repeatMode), customData);
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueUpdateItems(final GoogleApiClient apiClient, final MediaQueueItem[] itemsToUpdate, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) {
            /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass6 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzSt.zza(this.zzTa, 0, itemsToUpdate, 0, (Integer) null, customData);
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> requestStatus(final GoogleApiClient apiClient) {
        return apiClient.zzb(new zzb(apiClient) {
            /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass22 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzSt.zza(this.zzTa);
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position) {
        return seek(apiClient, position, 0, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState) {
        return seek(apiClient, position, resumeState, null);
    }

    public PendingResult<MediaChannelResult> seek(final GoogleApiClient apiClient, final long position, final int resumeState, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) {
            /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass19 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzSt.zza(this.zzTa, position, resumeState, customData);
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(final GoogleApiClient apiClient, final long[] trackIds) {
        if (trackIds != null) {
            return apiClient.zzb(new zzb(apiClient) {
                /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass2 */

                /* access modifiers changed from: protected */
                public void zza(zze zze) {
                    synchronized (RemoteMediaPlayer.this.zzqt) {
                        RemoteMediaPlayer.this.zzSu.zzb(apiClient);
                        try {
                            RemoteMediaPlayer.this.zzSt.zza(this.zzTa, trackIds);
                        } catch (IOException e) {
                            setResult(createFailedResult(new Status(2100)));
                        } finally {
                            RemoteMediaPlayer.this.zzSu.zzb(null);
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackIds cannot be null");
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener listener) {
        this.zzSx = listener;
    }

    public void setOnPreloadStatusUpdatedListener(OnPreloadStatusUpdatedListener listener) {
        this.zzSv = listener;
    }

    public void setOnQueueStatusUpdatedListener(OnQueueStatusUpdatedListener listener) {
        this.zzSw = listener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener listener) {
        this.zzSy = listener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState) {
        return setStreamMute(apiClient, muteState, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(final GoogleApiClient apiClient, final boolean muteState, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) {
            /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass21 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzSt.zza(this.zzTa, muteState, customData);
                    } catch (IOException | IllegalStateException e) {
                        setResult(createFailedResult(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume) throws IllegalArgumentException {
        return setStreamVolume(apiClient, volume, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(final GoogleApiClient apiClient, final double volume, final JSONObject customData) throws IllegalArgumentException {
        if (!Double.isInfinite(volume) && !Double.isNaN(volume)) {
            return apiClient.zzb(new zzb(apiClient) {
                /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass20 */

                /* access modifiers changed from: protected */
                public void zza(zze zze) {
                    synchronized (RemoteMediaPlayer.this.zzqt) {
                        RemoteMediaPlayer.this.zzSu.zzb(apiClient);
                        try {
                            RemoteMediaPlayer.this.zzSt.zza(this.zzTa, volume, customData);
                        } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                            setResult(createFailedResult(new Status(2100)));
                        } finally {
                            RemoteMediaPlayer.this.zzSu.zzb(null);
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("Volume cannot be " + volume);
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(final GoogleApiClient apiClient, final TextTrackStyle trackStyle) {
        if (trackStyle != null) {
            return apiClient.zzb(new zzb(apiClient) {
                /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass3 */

                /* access modifiers changed from: protected */
                public void zza(zze zze) {
                    synchronized (RemoteMediaPlayer.this.zzqt) {
                        RemoteMediaPlayer.this.zzSu.zzb(apiClient);
                        try {
                            RemoteMediaPlayer.this.zzSt.zza(this.zzTa, trackStyle);
                        } catch (IOException e) {
                            setResult(createFailedResult(new Status(2100)));
                        } finally {
                            RemoteMediaPlayer.this.zzSu.zzb(null);
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackStyle cannot be null");
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient) {
        return stop(apiClient, null);
    }

    public PendingResult<MediaChannelResult> stop(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) {
            /* class com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass17 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzSt.zzb(this.zzTa, customData);
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                    }
                }
            }
        });
    }
}
