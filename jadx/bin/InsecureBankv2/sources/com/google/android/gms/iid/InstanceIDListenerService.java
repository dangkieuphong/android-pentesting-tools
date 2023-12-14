package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v7.media.MediaRouteProviderProtocol;
import android.util.Log;
import com.google.android.gms.gcm.GcmReceiver;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.IOException;

public class InstanceIDListenerService extends Service {
    static String ACTION = "action";
    private static String zzavK = "google.com/iid";
    private static String zzawW = "CMD";
    MessengerCompat zzawU = new MessengerCompat(new Handler(Looper.getMainLooper()) {
        /* class com.google.android.gms.iid.InstanceIDListenerService.AnonymousClass1 */

        public void handleMessage(Message msg) {
            InstanceIDListenerService.this.zza((InstanceIDListenerService) msg, (Message) MessengerCompat.zzc(msg));
        }
    });
    BroadcastReceiver zzawV = new BroadcastReceiver() {
        /* class com.google.android.gms.iid.InstanceIDListenerService.AnonymousClass2 */

        public void onReceive(Context context, Intent intent) {
            if (Log.isLoggable("InstanceID", 3)) {
                intent.getStringExtra("registration_id");
                Log.d("InstanceID", "Received GSF callback using dynamic receiver: " + intent.getExtras());
            }
            InstanceIDListenerService.this.zzn(intent);
            InstanceIDListenerService.this.stop();
        }
    };
    int zzawX;
    int zzawY;

    static void zza(Context context, zzd zzd) {
        zzd.zzul();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra(zzawW, "RST");
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zza(Message message, int i) {
        zzc.zzaw(this);
        getPackageManager();
        if (i == zzc.zzaxf || i == zzc.zzaxe) {
            zzn((Intent) message.obj);
        } else {
            Log.w("InstanceID", "Message from unexpected caller " + i + " mine=" + zzc.zzaxe + " appid=" + zzc.zzaxf);
        }
    }

    static void zzav(Context context) {
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.setPackage(context.getPackageName());
        intent.putExtra(zzawW, "SYNC");
        context.startService(intent);
    }

    public IBinder onBind(Intent intent) {
        if (intent == null || !"com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
            return null;
        }
        return this.zzawU.getBinder();
    }

    public void onCreate() {
        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentFilter.addCategory(getPackageName());
        registerReceiver(this.zzawV, intentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
    }

    public void onDestroy() {
        unregisterReceiver(this.zzawV);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent intent2;
        zzgn(startId);
        if (intent == null) {
            stop();
            return 2;
        }
        try {
            if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
                if (Build.VERSION.SDK_INT > 18 || (intent2 = (Intent) intent.getParcelableExtra("GSF")) == null) {
                    zzn(intent);
                } else {
                    startService(intent2);
                    return 1;
                }
            }
            stop();
            if (intent.getStringExtra("from") != null) {
                GcmReceiver.completeWakefulIntent(intent);
            }
            return 2;
        } finally {
            stop();
        }
    }

    public void onTokenRefresh() {
    }

    /* access modifiers changed from: package-private */
    public void stop() {
        synchronized (this) {
            this.zzawX--;
            if (this.zzawX == 0) {
                stopSelf(this.zzawY);
            }
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Stop " + this.zzawX + " " + this.zzawY);
            }
        }
    }

    public void zzab(boolean z) {
        onTokenRefresh();
    }

    /* access modifiers changed from: package-private */
    public void zzgn(int i) {
        synchronized (this) {
            this.zzawX++;
            if (i > this.zzawY) {
                this.zzawY = i;
            }
        }
    }

    public void zzn(Intent intent) {
        InstanceID zza;
        String stringExtra = intent.getStringExtra("subtype");
        if (stringExtra == null) {
            zza = InstanceID.getInstance(this);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("subtype", stringExtra);
            zza = InstanceID.zza(this, bundle);
        }
        String stringExtra2 = intent.getStringExtra(zzawW);
        if (intent.getStringExtra(MediaRouteProviderProtocol.SERVICE_DATA_ERROR) == null && intent.getStringExtra("registration_id") == null) {
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Service command " + stringExtra + " " + stringExtra2 + " " + intent.getExtras());
            }
            if (intent.getStringExtra("unregistered") != null) {
                zzd zzug = zza.zzug();
                if (stringExtra == null) {
                    stringExtra = "";
                }
                zzug.zzdi(stringExtra);
                zza.zzuh().zzr(intent);
            } else if ("RST".equals(stringExtra2)) {
                zza.zzuf();
                zzab(true);
            } else if ("RST_FULL".equals(stringExtra2)) {
                if (!zza.zzug().isEmpty()) {
                    zza.zzug().zzul();
                    zzab(true);
                }
            } else if ("SYNC".equals(stringExtra2)) {
                zza.zzug().zzdi(stringExtra);
                zzab(false);
            } else if ("PING".equals(stringExtra2)) {
                try {
                    GoogleCloudMessaging.getInstance(this).send(zzavK, zzc.zzuk(), 0, intent.getExtras());
                } catch (IOException e) {
                    Log.w("InstanceID", "Failed to send ping response");
                }
            }
        } else {
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Register result in service " + stringExtra);
            }
            zza.zzuh().zzr(intent);
        }
    }
}
