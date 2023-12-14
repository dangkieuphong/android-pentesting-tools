package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.analytics.internal.zzac;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.stats.zzb;
import java.util.Collections;

public class zzi extends zzd {
    private final zza zzJW = new zza();
    private zzac zzJX;
    private final zzt zzJY;
    private zzaj zzJZ;

    /* access modifiers changed from: protected */
    public class zza implements ServiceConnection {
        private volatile zzac zzKb;
        private volatile boolean zzKc;

        protected zza() {
        }

        public void onServiceConnected(ComponentName name, IBinder binder) {
            zzu.zzbY("AnalyticsServiceConnection.onServiceConnected");
            synchronized (this) {
                if (binder == null) {
                    try {
                        zzi.this.zzaX("Service connected with null binder");
                    } finally {
                        notifyAll();
                    }
                } else {
                    final zzac zzac = null;
                    try {
                        String interfaceDescriptor = binder.getInterfaceDescriptor();
                        if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(interfaceDescriptor)) {
                            zzac = zzac.zza.zzac(binder);
                            zzi.this.zzaT("Bound to IAnalyticsService interface");
                        } else {
                            zzi.this.zze("Got binder with a wrong descriptor", interfaceDescriptor);
                        }
                    } catch (RemoteException e) {
                        zzi.this.zzaX("Service connect failed to get IAnalyticsService");
                    }
                    if (zzac == null) {
                        try {
                            zzb.zzoO().zza(zzi.this.getContext(), zzi.this.zzJW);
                        } catch (IllegalArgumentException e2) {
                        }
                    } else if (!this.zzKc) {
                        zzi.this.zzaW("onServiceConnected received after the timeout limit");
                        zzi.this.zzhS().zze(new Runnable() {
                            /* class com.google.android.gms.analytics.internal.zzi.zza.AnonymousClass1 */

                            public void run() {
                                if (!zzi.this.isConnected()) {
                                    zzi.this.zzaU("Connected to service after a timeout");
                                    zzi.this.zza((zzi) zzac);
                                }
                            }
                        });
                    } else {
                        this.zzKb = zzac;
                    }
                    notifyAll();
                }
            }
        }

        public void onServiceDisconnected(final ComponentName name) {
            zzu.zzbY("AnalyticsServiceConnection.onServiceDisconnected");
            zzi.this.zzhS().zze(new Runnable() {
                /* class com.google.android.gms.analytics.internal.zzi.zza.AnonymousClass2 */

                public void run() {
                    zzi.this.onServiceDisconnected(name);
                }
            });
        }

        public zzac zzip() {
            zzac zzac = null;
            zzi.this.zzhO();
            Intent intent = new Intent("com.google.android.gms.analytics.service.START");
            intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
            Context context = zzi.this.getContext();
            intent.putExtra("app_package_name", context.getPackageName());
            zzb zzoO = zzb.zzoO();
            synchronized (this) {
                this.zzKb = null;
                this.zzKc = true;
                boolean zza = zzoO.zza(context, intent, zzi.this.zzJW, 129);
                zzi.this.zza("Bind to service requested", Boolean.valueOf(zza));
                if (!zza) {
                    this.zzKc = false;
                } else {
                    try {
                        wait(zzi.this.zzhR().zzjs());
                    } catch (InterruptedException e) {
                        zzi.this.zzaW("Wait for service connect was interrupted");
                    }
                    this.zzKc = false;
                    zzac = this.zzKb;
                    this.zzKb = null;
                    if (zzac == null) {
                        zzi.this.zzaX("Successfully bound to service but never got onServiceConnected callback");
                    }
                }
            }
            return zzac;
        }
    }

    protected zzi(zzf zzf) {
        super(zzf);
        this.zzJZ = new zzaj(zzf.zzhP());
        this.zzJY = new zzt(zzf) {
            /* class com.google.android.gms.analytics.internal.zzi.AnonymousClass1 */

            @Override // com.google.android.gms.analytics.internal.zzt
            public void run() {
                zzi.this.zzio();
            }
        };
    }

    private void onDisconnect() {
        zzhl().zzhJ();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onServiceDisconnected(ComponentName name) {
        zzhO();
        if (this.zzJX != null) {
            this.zzJX = null;
            zza("Disconnected from device AnalyticsService", name);
            onDisconnect();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zza(zzac zzac) {
        zzhO();
        this.zzJX = zzac;
        zzin();
        zzhl().onServiceConnected();
    }

    private void zzin() {
        this.zzJZ.start();
        this.zzJY.zzt(zzhR().zzjr());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzio() {
        zzhO();
        if (isConnected()) {
            zzaT("Inactivity, disconnecting from device AnalyticsService");
            disconnect();
        }
    }

    public boolean connect() {
        zzhO();
        zzia();
        if (this.zzJX != null) {
            return true;
        }
        zzac zzip = this.zzJW.zzip();
        if (zzip == null) {
            return false;
        }
        this.zzJX = zzip;
        zzin();
        return true;
    }

    public void disconnect() {
        zzhO();
        zzia();
        try {
            zzb.zzoO().zza(getContext(), this.zzJW);
        } catch (IllegalArgumentException | IllegalStateException e) {
        }
        if (this.zzJX != null) {
            this.zzJX = null;
            onDisconnect();
        }
    }

    public boolean isConnected() {
        zzhO();
        zzia();
        return this.zzJX != null;
    }

    public boolean zzb(zzab zzab) {
        zzu.zzu(zzab);
        zzhO();
        zzia();
        zzac zzac = this.zzJX;
        if (zzac == null) {
            return false;
        }
        try {
            zzac.zza(zzab.zzn(), zzab.zzjW(), zzab.zzjY() ? zzhR().zzjk() : zzhR().zzjl(), Collections.emptyList());
            zzin();
            return true;
        } catch (RemoteException e) {
            zzaT("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.analytics.internal.zzd
    public void zzhn() {
    }

    public boolean zzim() {
        zzhO();
        zzia();
        zzac zzac = this.zzJX;
        if (zzac == null) {
            return false;
        }
        try {
            zzac.zzhG();
            zzin();
            return true;
        } catch (RemoteException e) {
            zzaT("Failed to clear hits from AnalyticsService");
            return false;
        }
    }
}
