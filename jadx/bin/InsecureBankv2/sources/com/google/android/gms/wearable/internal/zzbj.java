package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.ChannelImpl;
import com.google.android.gms.wearable.internal.zzav;
import com.google.android.gms.wearable.internal.zzax;
import com.google.android.gms.wearable.internal.zzg;
import com.google.android.gms.wearable.internal.zzi;
import com.google.android.gms.wearable.internal.zzu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.FutureTask;

final class zzbj {

    /* access modifiers changed from: package-private */
    public static final class zza extends zzb<CapabilityApi.AddLocalCapabilityResult> {
        public zza(zza.zzb<CapabilityApi.AddLocalCapabilityResult> zzb) {
            super(zzb);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zza(AddLocalCapabilityResponse addLocalCapabilityResponse) {
            zzP(new zzg.zzb(zzbg.zzfn(addLocalCapabilityResponse.statusCode)));
        }
    }

    static abstract class zzb<T> extends zza {
        private zza.zzb<T> zzNO;

        public zzb(zza.zzb<T> zzb) {
            this.zzNO = zzb;
        }

        public void zzP(T t) {
            zza.zzb<T> zzb = this.zzNO;
            if (zzb != null) {
                zzb.zzm(t);
                this.zzNO = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zzc extends zzb<Status> {
        public zzc(zza.zzb<Status> zzb) {
            super(zzb);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zza(CloseChannelResponse closeChannelResponse) {
            zzP(new Status(closeChannelResponse.statusCode));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zzd extends zzb<Status> {
        public zzd(zza.zzb<Status> zzb) {
            super(zzb);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zzb(CloseChannelResponse closeChannelResponse) {
            zzP(new Status(closeChannelResponse.statusCode));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zze extends zzb<DataApi.DeleteDataItemsResult> {
        public zze(zza.zzb<DataApi.DeleteDataItemsResult> zzb) {
            super(zzb);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zza(DeleteDataItemsResponse deleteDataItemsResponse) {
            zzP(new zzu.zzc(zzbg.zzfn(deleteDataItemsResponse.statusCode), deleteDataItemsResponse.zzaUp));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zzf extends zzb<CapabilityApi.GetAllCapabilitiesResult> {
        public zzf(zza.zzb<CapabilityApi.GetAllCapabilitiesResult> zzb) {
            super(zzb);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zza(GetAllCapabilitiesResponse getAllCapabilitiesResponse) {
            zzP(new zzg.zzd(zzbg.zzfn(getAllCapabilitiesResponse.statusCode), zzbj.zzv(getAllCapabilitiesResponse.zzaUq)));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zzg extends zzb<CapabilityApi.GetCapabilityResult> {
        public zzg(zza.zzb<CapabilityApi.GetCapabilityResult> zzb) {
            super(zzb);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zza(GetCapabilityResponse getCapabilityResponse) {
            zzP(new zzg.zze(zzbg.zzfn(getCapabilityResponse.statusCode), new zzg.zzc(getCapabilityResponse.zzaUr)));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zzh extends zzb<Channel.GetInputStreamResult> {
        private final zzq zzaUQ;

        public zzh(zza.zzb<Channel.GetInputStreamResult> zzb, zzq zzq) {
            super(zzb);
            this.zzaUQ = (zzq) com.google.android.gms.common.internal.zzu.zzu(zzq);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zza(GetChannelInputStreamResponse getChannelInputStreamResponse) {
            zzm zzm = null;
            if (getChannelInputStreamResponse.zzaUs != null) {
                zzm = new zzm(new ParcelFileDescriptor.AutoCloseInputStream(getChannelInputStreamResponse.zzaUs));
                this.zzaUQ.zza(zzm.zzBb());
            }
            zzP(new ChannelImpl.zza(new Status(getChannelInputStreamResponse.statusCode), zzm));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zzi extends zzb<Channel.GetOutputStreamResult> {
        private final zzq zzaUQ;

        public zzi(zza.zzb<Channel.GetOutputStreamResult> zzb, zzq zzq) {
            super(zzb);
            this.zzaUQ = (zzq) com.google.android.gms.common.internal.zzu.zzu(zzq);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zza(GetChannelOutputStreamResponse getChannelOutputStreamResponse) {
            zzn zzn = null;
            if (getChannelOutputStreamResponse.zzaUs != null) {
                zzn = new zzn(new ParcelFileDescriptor.AutoCloseOutputStream(getChannelOutputStreamResponse.zzaUs));
                this.zzaUQ.zza(zzn.zzBb());
            }
            zzP(new ChannelImpl.zzb(new Status(getChannelOutputStreamResponse.statusCode), zzn));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zzj extends zzb<NodeApi.GetConnectedNodesResult> {
        public zzj(zza.zzb<NodeApi.GetConnectedNodesResult> zzb) {
            super(zzb);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zza(GetConnectedNodesResponse getConnectedNodesResponse) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(getConnectedNodesResponse.zzaUw);
            zzP(new zzax.zzb(zzbg.zzfn(getConnectedNodesResponse.statusCode), arrayList));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zzk extends zzb<DataApi.DataItemResult> {
        public zzk(zza.zzb<DataApi.DataItemResult> zzb) {
            super(zzb);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zza(GetDataItemResponse getDataItemResponse) {
            zzP(new zzu.zzb(zzbg.zzfn(getDataItemResponse.statusCode), getDataItemResponse.zzaUx));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zzl extends zzb<DataItemBuffer> {
        public zzl(zza.zzb<DataItemBuffer> zzb) {
            super(zzb);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zzad(DataHolder dataHolder) {
            zzP(new DataItemBuffer(dataHolder));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zzm extends zzb<DataApi.GetFdForAssetResult> {
        public zzm(zza.zzb<DataApi.GetFdForAssetResult> zzb) {
            super(zzb);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zza(GetFdForAssetResponse getFdForAssetResponse) {
            zzP(new zzu.zzd(zzbg.zzfn(getFdForAssetResponse.statusCode), getFdForAssetResponse.zzaUy));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zzn extends zzb<NodeApi.GetLocalNodeResult> {
        public zzn(zza.zzb<NodeApi.GetLocalNodeResult> zzb) {
            super(zzb);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zza(GetLocalNodeResponse getLocalNodeResponse) {
            zzP(new zzax.zzc(zzbg.zzfn(getLocalNodeResponse.statusCode), getLocalNodeResponse.zzaUz));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zzo extends zza {
        zzo() {
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zza(Status status) {
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zzp extends zzb<ChannelApi.OpenChannelResult> {
        public zzp(zza.zzb<ChannelApi.OpenChannelResult> zzb) {
            super(zzb);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zza(OpenChannelResponse openChannelResponse) {
            zzP(new zzi.zzb(zzbg.zzfn(openChannelResponse.statusCode), openChannelResponse.zzaTP));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zzq extends zzb<DataApi.DataItemResult> {
        private final List<FutureTask<Boolean>> zzwE;

        zzq(zza.zzb<DataApi.DataItemResult> zzb, List<FutureTask<Boolean>> list) {
            super(zzb);
            this.zzwE = list;
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zza(PutDataResponse putDataResponse) {
            zzP(new zzu.zzb(zzbg.zzfn(putDataResponse.statusCode), putDataResponse.zzaUx));
            if (putDataResponse.statusCode != 0) {
                for (FutureTask<Boolean> futureTask : this.zzwE) {
                    futureTask.cancel(true);
                }
            }
        }
    }

    static final class zzr extends zzb<Status> {
        public zzr(zza.zzb<Status> zzb) {
            super(zzb);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zza(ChannelSendFileResponse channelSendFileResponse) {
            zzP(new Status(channelSendFileResponse.statusCode));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zzs extends zzb<CapabilityApi.RemoveLocalCapabilityResult> {
        public zzs(zza.zzb<CapabilityApi.RemoveLocalCapabilityResult> zzb) {
            super(zzb);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zza(RemoveLocalCapabilityResponse removeLocalCapabilityResponse) {
            zzP(new zzg.zzb(zzbg.zzfn(removeLocalCapabilityResponse.statusCode)));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zzt extends zzb<MessageApi.SendMessageResult> {
        public zzt(zza.zzb<MessageApi.SendMessageResult> zzb) {
            super(zzb);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zza(SendMessageResponse sendMessageResponse) {
            zzP(new zzav.zzb(zzbg.zzfn(sendMessageResponse.statusCode), sendMessageResponse.zzaxg));
        }
    }

    static final class zzu extends zzb<Status> {
        public zzu(zza.zzb<Status> zzb) {
            super(zzb);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zza(ChannelReceiveFileResponse channelReceiveFileResponse) {
            zzP(new Status(channelReceiveFileResponse.statusCode));
        }
    }

    /* access modifiers changed from: private */
    public static Map<String, CapabilityInfo> zzv(List<CapabilityInfoParcelable> list) {
        HashMap hashMap = new HashMap(list.size() * 2);
        for (CapabilityInfoParcelable capabilityInfoParcelable : list) {
            hashMap.put(capabilityInfoParcelable.getName(), new zzg.zzc(capabilityInfoParcelable));
        }
        return hashMap;
    }
}
