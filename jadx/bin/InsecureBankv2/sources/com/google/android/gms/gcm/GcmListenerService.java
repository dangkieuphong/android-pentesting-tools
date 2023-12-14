package com.google.android.gms.gcm;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.media.MediaRouteProviderProtocol;
import android.util.Log;

public abstract class GcmListenerService extends Service {
    private int zzavB;
    private int zzavC = 0;
    private final Object zzqt = new Object();

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zzk(Intent intent) {
        try {
            if ("com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("message_type");
                String str = stringExtra == null ? GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE : stringExtra;
                char c = 65535;
                switch (str.hashCode()) {
                    case -2062414158:
                        if (str.equals(GoogleCloudMessaging.MESSAGE_TYPE_DELETED)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 102161:
                        if (str.equals(GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 814694033:
                        if (str.equals(GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR)) {
                            c = 3;
                            break;
                        }
                        break;
                    case 814800675:
                        if (str.equals(GoogleCloudMessaging.MESSAGE_TYPE_SEND_EVENT)) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        zzs(intent.getExtras());
                        break;
                    case 1:
                        onDeletedMessages();
                        break;
                    case 2:
                        onMessageSent(intent.getStringExtra("google.message_id"));
                        break;
                    case 3:
                        onSendError(intent.getStringExtra("google.message_id"), intent.getStringExtra(MediaRouteProviderProtocol.SERVICE_DATA_ERROR));
                        break;
                    default:
                        Log.w("GcmListenerService", "Received message with unknown type: " + str);
                        break;
                }
                synchronized (this.zzqt) {
                    this.zzavC--;
                    if (this.zzavC == 0) {
                        zzgf(this.zzavB);
                    }
                }
                GcmReceiver.completeWakefulIntent(intent);
            }
        } finally {
            GcmReceiver.completeWakefulIntent(intent);
        }
    }

    private void zzs(Bundle bundle) {
        bundle.remove("message_type");
        bundle.remove("android.support.content.wakelockid");
        if (zza.zzt(bundle)) {
            zza.zzar(this).zzu(bundle);
            return;
        }
        String string = bundle.getString("from");
        bundle.remove("from");
        onMessageReceived(string, bundle);
    }

    public final IBinder onBind(Intent intent) {
        return null;
    }

    public void onDeletedMessages() {
    }

    public void onMessageReceived(String from, Bundle data) {
    }

    public void onMessageSent(String msgId) {
    }

    public void onSendError(String msgId, String error) {
    }

    public final int onStartCommand(final Intent intent, int flags, int startId) {
        synchronized (this.zzqt) {
            this.zzavB = startId;
            this.zzavC++;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                /* class com.google.android.gms.gcm.GcmListenerService.AnonymousClass1 */

                public void run() {
                    GcmListenerService.this.zzk(intent);
                }
            });
            return 3;
        }
        new AsyncTask<Void, Void, Void>() {
            /* class com.google.android.gms.gcm.GcmListenerService.AnonymousClass2 */

            /* access modifiers changed from: protected */
            /* renamed from: zzb */
            public Void doInBackground(Void... voidArr) {
                GcmListenerService.this.zzk(intent);
                return null;
            }
        }.execute(new Void[0]);
        return 3;
    }

    /* access modifiers changed from: package-private */
    public boolean zzgf(int i) {
        return stopSelfResult(i);
    }
}
