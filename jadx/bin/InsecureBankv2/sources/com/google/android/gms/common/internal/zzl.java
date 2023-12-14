package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* access modifiers changed from: package-private */
public final class zzl extends zzk implements Handler.Callback {
    private final Handler mHandler;
    private final HashMap<zza, zzb> zzaaL = new HashMap<>();
    private final com.google.android.gms.common.stats.zzb zzaaM;
    private final long zzaaN;
    private final Context zzqw;

    /* access modifiers changed from: private */
    public static final class zza {
        private final ComponentName zzaaO;
        private final String zzuO;

        public zza(ComponentName componentName) {
            this.zzuO = null;
            this.zzaaO = (ComponentName) zzu.zzu(componentName);
        }

        public zza(String str) {
            this.zzuO = zzu.zzcj(str);
            this.zzaaO = null;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            return zzt.equal(this.zzuO, zza.zzuO) && zzt.equal(this.zzaaO, zza.zzaaO);
        }

        public int hashCode() {
            return zzt.hashCode(this.zzuO, this.zzaaO);
        }

        public String toString() {
            return this.zzuO == null ? this.zzaaO.flattenToString() : this.zzuO;
        }

        public Intent zznV() {
            return this.zzuO != null ? new Intent(this.zzuO).setPackage("com.google.android.gms") : new Intent().setComponent(this.zzaaO);
        }
    }

    /* access modifiers changed from: private */
    public final class zzb {
        private int mState = 2;
        private IBinder zzZQ;
        private ComponentName zzaaO;
        private final zza zzaaP = new zza();
        private final Set<ServiceConnection> zzaaQ = new HashSet();
        private boolean zzaaR;
        private final zza zzaaS;

        public class zza implements ServiceConnection {
            public zza() {
            }

            public void onServiceConnected(ComponentName component, IBinder binder) {
                synchronized (zzl.this.zzaaL) {
                    zzb.this.zzZQ = binder;
                    zzb.this.zzaaO = component;
                    for (ServiceConnection serviceConnection : zzb.this.zzaaQ) {
                        serviceConnection.onServiceConnected(component, binder);
                    }
                    zzb.this.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName component) {
                synchronized (zzl.this.zzaaL) {
                    zzb.this.zzZQ = null;
                    zzb.this.zzaaO = component;
                    for (ServiceConnection serviceConnection : zzb.this.zzaaQ) {
                        serviceConnection.onServiceDisconnected(component);
                    }
                    zzb.this.mState = 2;
                }
            }
        }

        public zzb(zza zza2) {
            this.zzaaS = zza2;
        }

        public IBinder getBinder() {
            return this.zzZQ;
        }

        public ComponentName getComponentName() {
            return this.zzaaO;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.zzaaR;
        }

        public void zza(ServiceConnection serviceConnection, String str) {
            zzl.this.zzaaM.zza(zzl.this.zzqw, serviceConnection, str, this.zzaaS.zznV());
            this.zzaaQ.add(serviceConnection);
        }

        public boolean zza(ServiceConnection serviceConnection) {
            return this.zzaaQ.contains(serviceConnection);
        }

        public void zzb(ServiceConnection serviceConnection, String str) {
            zzl.this.zzaaM.zzb(zzl.this.zzqw, serviceConnection);
            this.zzaaQ.remove(serviceConnection);
        }

        public void zzcc(String str) {
            this.zzaaR = zzl.this.zzaaM.zza(zzl.this.zzqw, str, this.zzaaS.zznV(), this.zzaaP, 129);
            if (this.zzaaR) {
                this.mState = 3;
                return;
            }
            try {
                zzl.this.zzaaM.zza(zzl.this.zzqw, this.zzaaP);
            } catch (IllegalArgumentException e) {
            }
        }

        public void zzcd(String str) {
            zzl.this.zzaaM.zza(zzl.this.zzqw, this.zzaaP);
            this.zzaaR = false;
            this.mState = 2;
        }

        public boolean zznW() {
            return this.zzaaQ.isEmpty();
        }
    }

    zzl(Context context) {
        this.zzqw = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.zzaaM = com.google.android.gms.common.stats.zzb.zzoO();
        this.zzaaN = 5000;
    }

    private boolean zza(zza zza2, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        zzu.zzb(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzaaL) {
            zzb zzb2 = this.zzaaL.get(zza2);
            if (zzb2 != null) {
                this.mHandler.removeMessages(0, zzb2);
                if (!zzb2.zza(serviceConnection)) {
                    zzb2.zza(serviceConnection, str);
                    switch (zzb2.getState()) {
                        case 1:
                            serviceConnection.onServiceConnected(zzb2.getComponentName(), zzb2.getBinder());
                            break;
                        case 2:
                            zzb2.zzcc(str);
                            break;
                    }
                } else {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + zza2);
                }
            } else {
                zzb2 = new zzb(zza2);
                zzb2.zza(serviceConnection, str);
                zzb2.zzcc(str);
                this.zzaaL.put(zza2, zzb2);
            }
            isBound = zzb2.isBound();
        }
        return isBound;
    }

    private void zzb(zza zza2, ServiceConnection serviceConnection, String str) {
        zzu.zzb(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzaaL) {
            zzb zzb2 = this.zzaaL.get(zza2);
            if (zzb2 == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + zza2);
            } else if (!zzb2.zza(serviceConnection)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + zza2);
            } else {
                zzb2.zzb(serviceConnection, str);
                if (zzb2.zznW()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, zzb2), this.zzaaN);
                }
            }
        }
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 0:
                zzb zzb2 = (zzb) msg.obj;
                synchronized (this.zzaaL) {
                    if (zzb2.zznW()) {
                        if (zzb2.isBound()) {
                            zzb2.zzcd("GmsClientSupervisor");
                        }
                        this.zzaaL.remove(zzb2.zzaaS);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    @Override // com.google.android.gms.common.internal.zzk
    public boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zza(componentName), serviceConnection, str);
    }

    @Override // com.google.android.gms.common.internal.zzk
    public boolean zza(String str, ServiceConnection serviceConnection, String str2) {
        return zza(new zza(str), serviceConnection, str2);
    }

    @Override // com.google.android.gms.common.internal.zzk
    public void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzb(new zza(componentName), serviceConnection, str);
    }

    @Override // com.google.android.gms.common.internal.zzk
    public void zzb(String str, ServiceConnection serviceConnection, String str2) {
        zzb(new zza(str), serviceConnection, str2);
    }
}
