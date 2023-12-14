package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.common.internal.zzu;

/* access modifiers changed from: package-private */
public class zzag extends BroadcastReceiver {
    static final String zzMo = zzag.class.getName();
    private final zzf zzJy;
    private boolean zzMp;
    private boolean zzMq;

    zzag(zzf zzf) {
        zzu.zzu(zzf);
        this.zzJy = zzf;
    }

    private Context getContext() {
        return this.zzJy.getContext();
    }

    private zzaf zzhQ() {
        return this.zzJy.zzhQ();
    }

    private zzb zzhl() {
        return this.zzJy.zzhl();
    }

    private void zzke() {
        zzhQ();
        zzhl();
    }

    public boolean isConnected() {
        if (!this.zzMp) {
            this.zzJy.zzhQ().zzaW("Connectivity unknown. Receiver not registered");
        }
        return this.zzMq;
    }

    public boolean isRegistered() {
        return this.zzMp;
    }

    public void onReceive(Context ctx, Intent intent) {
        zzke();
        String action = intent.getAction();
        this.zzJy.zzhQ().zza("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zzkg = zzkg();
            if (this.zzMq != zzkg) {
                this.zzMq = zzkg;
                zzhl().zzG(zzkg);
            }
        } else if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.zzJy.zzhQ().zzd("NetworkBroadcastReceiver received unknown action", action);
        } else if (!intent.hasExtra(zzMo)) {
            zzhl().zzhK();
        }
    }

    public void unregister() {
        if (isRegistered()) {
            this.zzJy.zzhQ().zzaT("Unregistering connectivity change receiver");
            this.zzMp = false;
            this.zzMq = false;
            try {
                getContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                zzhQ().zze("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public void zzkd() {
        zzke();
        if (!this.zzMp) {
            Context context = getContext();
            context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
            intentFilter.addCategory(context.getPackageName());
            context.registerReceiver(this, intentFilter);
            this.zzMq = zzkg();
            this.zzJy.zzhQ().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzMq));
            this.zzMp = true;
        }
    }

    public void zzkf() {
        if (Build.VERSION.SDK_INT > 10) {
            Context context = getContext();
            Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
            intent.addCategory(context.getPackageName());
            intent.putExtra(zzMo, true);
            context.sendOrderedBroadcast(intent, null);
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzkg() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (SecurityException e) {
            return false;
        }
    }
}
