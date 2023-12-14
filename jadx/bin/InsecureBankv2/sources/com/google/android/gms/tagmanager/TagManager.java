package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager zzaOb;
    private final Context mContext;
    private final DataLayer zzaKz;
    private final zzs zzaMV;
    private final zza zzaNY;
    private final zzct zzaNZ;
    private final ConcurrentMap<zzo, Boolean> zzaOa;

    public interface zza {
        zzp zza(Context context, TagManager tagManager, Looper looper, String str, int i, zzs zzs);
    }

    TagManager(Context context, zza containerHolderLoaderProvider, DataLayer dataLayer, zzct serviceManager) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.zzaNZ = serviceManager;
        this.zzaNY = containerHolderLoaderProvider;
        this.zzaOa = new ConcurrentHashMap();
        this.zzaKz = dataLayer;
        this.zzaKz.zza(new DataLayer.zzb() {
            /* class com.google.android.gms.tagmanager.TagManager.AnonymousClass1 */

            @Override // com.google.android.gms.tagmanager.DataLayer.zzb
            public void zzF(Map<String, Object> map) {
                Object obj = map.get("event");
                if (obj != null) {
                    TagManager.this.zzeF(obj.toString());
                }
            }
        });
        this.zzaKz.zza(new zzd(this.mContext));
        this.zzaMV = new zzs();
        zzzE();
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (zzaOb == null) {
                if (context == null) {
                    zzbg.zzaz("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                zzaOb = new TagManager(context, new zza() {
                    /* class com.google.android.gms.tagmanager.TagManager.AnonymousClass2 */

                    @Override // com.google.android.gms.tagmanager.TagManager.zza
                    public zzp zza(Context context, TagManager tagManager, Looper looper, String str, int i, zzs zzs) {
                        return new zzp(context, tagManager, looper, str, i, zzs);
                    }
                }, new DataLayer(new zzw(context)), zzcu.zzzz());
            }
            tagManager = zzaOb;
        }
        return tagManager;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzeF(String str) {
        for (zzo zzo : this.zzaOa.keySet()) {
            zzo.zzeh(str);
        }
    }

    private void zzzE() {
        if (Build.VERSION.SDK_INT >= 14) {
            this.mContext.registerComponentCallbacks(new ComponentCallbacks2() {
                /* class com.google.android.gms.tagmanager.TagManager.AnonymousClass3 */

                public void onConfigurationChanged(Configuration configuration) {
                }

                public void onLowMemory() {
                }

                public void onTrimMemory(int i) {
                    if (i == 20) {
                        TagManager.this.dispatch();
                    }
                }
            });
        }
    }

    public void dispatch() {
        this.zzaNZ.dispatch();
    }

    public DataLayer getDataLayer() {
        return this.zzaKz;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId) {
        zzp zza2 = this.zzaNY.zza(this.mContext, this, null, containerId, defaultContainerResourceId, this.zzaMV);
        zza2.zzyr();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId, Handler handler) {
        zzp zza2 = this.zzaNY.zza(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.zzaMV);
        zza2.zzyr();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId) {
        zzp zza2 = this.zzaNY.zza(this.mContext, this, null, containerId, defaultContainerResourceId, this.zzaMV);
        zza2.zzyt();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId, Handler handler) {
        zzp zza2 = this.zzaNY.zza(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.zzaMV);
        zza2.zzyt();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId) {
        zzp zza2 = this.zzaNY.zza(this.mContext, this, null, containerId, defaultContainerResourceId, this.zzaMV);
        zza2.zzys();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId, Handler handler) {
        zzp zza2 = this.zzaNY.zza(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.zzaMV);
        zza2.zzys();
        return zza2;
    }

    public void setVerboseLoggingEnabled(boolean enableVerboseLogging) {
        zzbg.setLogLevel(enableVerboseLogging ? 2 : 5);
    }

    /* access modifiers changed from: package-private */
    public void zza(zzo zzo) {
        this.zzaOa.put(zzo, true);
    }

    /* access modifiers changed from: package-private */
    public boolean zzb(zzo zzo) {
        return this.zzaOa.remove(zzo) != null;
    }

    public PendingResult<ContainerHolder> zzc(String str, int i, String str2) {
        zzp zza2 = this.zzaNY.zza(this.mContext, this, null, str, i, this.zzaMV);
        zza2.load(str2);
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean zzl(Uri uri) {
        boolean z;
        zzcb zzzf = zzcb.zzzf();
        if (zzzf.zzl(uri)) {
            String containerId = zzzf.getContainerId();
            switch (zzzf.zzzg()) {
                case NONE:
                    for (zzo zzo : this.zzaOa.keySet()) {
                        if (zzo.getContainerId().equals(containerId)) {
                            zzo.zzej(null);
                            zzo.refresh();
                        }
                    }
                    break;
                case CONTAINER:
                case CONTAINER_DEBUG:
                    for (zzo zzo2 : this.zzaOa.keySet()) {
                        if (zzo2.getContainerId().equals(containerId)) {
                            zzo2.zzej(zzzf.zzzh());
                            zzo2.refresh();
                        } else if (zzo2.zzyo() != null) {
                            zzo2.zzej(null);
                            zzo2.refresh();
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }
}
