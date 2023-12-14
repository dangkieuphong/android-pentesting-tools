package com.google.android.gms.cast;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.text.TextUtils;
import android.view.Display;
import com.google.android.gms.R;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.DriveFile;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class CastRemoteDisplayLocalService extends Service {
    private static final zzl zzQW = new zzl("CastRemoteDisplayLocalService");
    private static final int zzQX = R.id.cast_notification_id;
    private static final Object zzQY = new Object();
    private static AtomicBoolean zzQZ = new AtomicBoolean(false);
    private static CastRemoteDisplayLocalService zzRn;
    private Handler mHandler;
    private Notification mNotification;
    private String zzQv;
    private GoogleApiClient zzRa;
    private CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzRb;
    private Callbacks zzRc;
    private zzb zzRd;
    private NotificationSettings zzRe;
    private Boolean zzRf;
    private PendingIntent zzRg;
    private CastDevice zzRh;
    private Display zzRi;
    private Context zzRj;
    private ServiceConnection zzRk;
    private MediaRouter zzRl;
    private final MediaRouter.Callback zzRm = new MediaRouter.Callback() {
        /* class com.google.android.gms.cast.CastRemoteDisplayLocalService.AnonymousClass1 */

        @Override // android.support.v7.media.MediaRouter.Callback
        public void onRouteUnselected(MediaRouter router, MediaRouter.RouteInfo info) {
            CastRemoteDisplayLocalService.zzQW.zzb("onRouteUnselected", new Object[0]);
            if (CastRemoteDisplayLocalService.this.zzRh == null) {
                CastRemoteDisplayLocalService.zzQW.zzb("onRouteUnselected, no device was selected", new Object[0]);
            } else if (!CastDevice.getFromBundle(info.getExtras()).getDeviceId().equals(CastRemoteDisplayLocalService.this.zzRh.getDeviceId())) {
                CastRemoteDisplayLocalService.zzQW.zzb("onRouteUnselected, device does not match", new Object[0]);
            } else {
                CastRemoteDisplayLocalService.stopService();
            }
        }
    };
    private final IBinder zzRo = new zza();

    public interface Callbacks {
        void onRemoteDisplaySessionError(Status status);

        void onRemoteDisplaySessionStarted(CastRemoteDisplayLocalService castRemoteDisplayLocalService);
    }

    public static final class NotificationSettings {
        private Notification mNotification;
        private PendingIntent zzRv;
        private String zzRw;
        private String zzRx;

        public static final class Builder {
            private NotificationSettings zzRy = new NotificationSettings();

            public NotificationSettings build() {
                if (this.zzRy.mNotification != null) {
                    if (!TextUtils.isEmpty(this.zzRy.zzRw)) {
                        throw new IllegalArgumentException("notificationTitle requires using the default notification");
                    } else if (!TextUtils.isEmpty(this.zzRy.zzRx)) {
                        throw new IllegalArgumentException("notificationText requires using the default notification");
                    } else if (this.zzRy.zzRv != null) {
                        throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
                    }
                } else if (TextUtils.isEmpty(this.zzRy.zzRw) && TextUtils.isEmpty(this.zzRy.zzRx) && this.zzRy.zzRv == null) {
                    throw new IllegalArgumentException("At least an argument must be provided");
                }
                return this.zzRy;
            }

            public Builder setNotification(Notification notification) {
                this.zzRy.mNotification = notification;
                return this;
            }

            public Builder setNotificationPendingIntent(PendingIntent notificationPendingIntent) {
                this.zzRy.zzRv = notificationPendingIntent;
                return this;
            }

            public Builder setNotificationText(String notificationText) {
                this.zzRy.zzRx = notificationText;
                return this;
            }

            public Builder setNotificationTitle(String notificationTitle) {
                this.zzRy.zzRw = notificationTitle;
                return this;
            }
        }

        private NotificationSettings() {
        }

        private NotificationSettings(NotificationSettings newSettings) {
            this.mNotification = newSettings.mNotification;
            this.zzRv = newSettings.zzRv;
            this.zzRw = newSettings.zzRw;
            this.zzRx = newSettings.zzRx;
        }
    }

    private class zza extends Binder {
        private zza() {
        }

        /* access modifiers changed from: package-private */
        public CastRemoteDisplayLocalService zzlp() {
            return CastRemoteDisplayLocalService.this;
        }
    }

    /* access modifiers changed from: private */
    public static final class zzb extends BroadcastReceiver {
        private zzb() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT")) {
                CastRemoteDisplayLocalService.zzQW.zzb("disconnecting", new Object[0]);
                CastRemoteDisplayLocalService.stopService();
            }
        }
    }

    public static CastRemoteDisplayLocalService getInstance() {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService;
        synchronized (zzQY) {
            castRemoteDisplayLocalService = zzRn;
        }
        return castRemoteDisplayLocalService;
    }

    protected static void setDebugEnabled() {
        zzQW.zzS(true);
    }

    public static void startService(final Context activityContext, Class<? extends CastRemoteDisplayLocalService> serviceClass, final String applicationId, final CastDevice device, final NotificationSettings notificationSettings, final Callbacks callbacks) {
        zzQW.zzb("Starting Service", new Object[0]);
        zzb(activityContext, serviceClass);
        zzu.zzb(activityContext, "activityContext is required.");
        zzu.zzb(serviceClass, "serviceClass is required.");
        zzu.zzb(applicationId, "applicationId is required.");
        zzu.zzb(device, "device is required.");
        zzu.zzb(notificationSettings, "notificationSettings is required.");
        zzu.zzb(callbacks, "callbacks is required.");
        if (notificationSettings.mNotification == null && notificationSettings.zzRv == null) {
            throw new IllegalArgumentException("notificationSettings: Either the notification or the notificationPendingIntent must be provided");
        } else if (zzQZ.getAndSet(true)) {
            zzQW.zzc("Service is already being started, startService has been called twice", new Object[0]);
        } else {
            Intent intent = new Intent(activityContext, serviceClass);
            activityContext.startService(intent);
            activityContext.bindService(intent, new ServiceConnection() {
                /* class com.google.android.gms.cast.CastRemoteDisplayLocalService.AnonymousClass2 */

                public void onServiceConnected(ComponentName className, IBinder binder) {
                    CastRemoteDisplayLocalService zzlp = ((zza) binder).zzlp();
                    if (zzlp != null) {
                        zzlp.zza(applicationId, device, notificationSettings, activityContext, this, callbacks);
                        return;
                    }
                    CastRemoteDisplayLocalService.zzQW.zzc("Connected but unable to get the service instance", new Object[0]);
                    callbacks.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
                    CastRemoteDisplayLocalService.zzQZ.set(false);
                    activityContext.unbindService(this);
                }

                public void onServiceDisconnected(ComponentName arg0) {
                    CastRemoteDisplayLocalService.zzQW.zzb("onServiceDisconnected", new Object[0]);
                    callbacks.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_DISCONNECTED, "Service Disconnected"));
                    CastRemoteDisplayLocalService.zzQZ.set(false);
                    activityContext.unbindService(this);
                }
            }, 64);
        }
    }

    public static void stopService() {
        zzM(false);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        if (r0.zzRl == null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        com.google.android.gms.cast.CastRemoteDisplayLocalService.zzQW.zzb("Setting default route", new java.lang.Object[0]);
        r0.zzRl.selectRoute(r0.zzRl.getDefaultRoute());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0045, code lost:
        if (r0.zzRd == null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        com.google.android.gms.cast.CastRemoteDisplayLocalService.zzQW.zzb("Unregistering notification receiver", new java.lang.Object[0]);
        r0.unregisterReceiver(r0.zzRd);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
        r0.zzlk();
        r0.zzll();
        r0.zzlg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0060, code lost:
        if (r0.zzRj == null) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0064, code lost:
        if (r0.zzRk == null) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0066, code lost:
        r0.zzRj.unbindService(r0.zzRk);
        r0.zzRk = null;
        r0.zzRj = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0071, code lost:
        r0.zzRc = null;
        r0.zzQv = null;
        r0.zzRa = null;
        r0.zzRh = null;
        r0.zzRe = null;
        r0.mNotification = null;
        r0.zzRi = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r6 != false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zzM(boolean r6) {
        /*
        // Method dump skipped, instructions count: 131
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.CastRemoteDisplayLocalService.zzM(boolean):void");
    }

    private Notification zzN(boolean z) {
        int i;
        int i2;
        String str;
        int i3 = getApplicationInfo().labelRes;
        String str2 = this.zzRe.zzRw;
        String str3 = this.zzRe.zzRx;
        if (z) {
            i = R.string.cast_notification_connected_message;
            i2 = R.drawable.cast_ic_notification_on;
        } else {
            i = R.string.cast_notification_connecting_message;
            i2 = R.drawable.cast_ic_notification_connecting;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = getString(i3);
        }
        if (TextUtils.isEmpty(str3)) {
            str = getString(i, new Object[]{this.zzRh.getFriendlyName()});
        } else {
            str = str3;
        }
        Notification build = new NotificationCompat.Builder(this).setContentTitle(str2).setContentText(str).setContentIntent(this.zzRe.zzRv).setSmallIcon(i2).setOngoing(true).addAction(17301560, getString(R.string.cast_notification_disconnect), zzlm()).build();
        startForeground(zzQX, build);
        return build;
    }

    private GoogleApiClient zza(CastDevice castDevice) {
        return new GoogleApiClient.Builder(this, new GoogleApiClient.ConnectionCallbacks() {
            /* class com.google.android.gms.cast.CastRemoteDisplayLocalService.AnonymousClass6 */

            @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
            public void onConnected(Bundle bundle) {
                CastRemoteDisplayLocalService.zzQW.zzb("onConnected", new Object[0]);
                CastRemoteDisplayLocalService.this.zzlh();
            }

            @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
            public void onConnectionSuspended(int cause) {
                CastRemoteDisplayLocalService.zzQW.zzf(String.format("ConnectionSuspended %d", Integer.valueOf(cause)), new Object[0]);
            }
        }, new GoogleApiClient.OnConnectionFailedListener() {
            /* class com.google.android.gms.cast.CastRemoteDisplayLocalService.AnonymousClass7 */

            @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
            public void onConnectionFailed(ConnectionResult connectionResult) {
                CastRemoteDisplayLocalService.zzQW.zzc("Connection failed: " + connectionResult, new Object[0]);
                CastRemoteDisplayLocalService.this.zzlj();
            }
        }).addApi(CastRemoteDisplay.API, new CastRemoteDisplay.CastRemoteDisplayOptions.Builder(castDevice, this.zzRb).build()).build();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zza(Display display) {
        this.zzRi = display;
        if (this.zzRf.booleanValue()) {
            this.mNotification = zzN(true);
        }
        if (this.zzRc != null) {
            this.zzRc.onRemoteDisplaySessionStarted(this);
            this.zzRc = null;
        }
        onCreatePresentation(this.zzRi);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zza(String str, CastDevice castDevice, NotificationSettings notificationSettings, Context context, ServiceConnection serviceConnection, Callbacks callbacks) {
        zzQW.zzb("startRemoteDisplaySession", new Object[0]);
        zzu.zzbY("Starting the Cast Remote Display must be done on the main thread");
        synchronized (zzQY) {
            if (zzRn != null) {
                zzM(true);
                zzQW.zzf("An existing service had not been stopped before starting one", new Object[0]);
            }
            zzRn = this;
        }
        this.zzRc = callbacks;
        this.zzQv = str;
        this.zzRh = castDevice;
        this.zzRj = context;
        this.zzRk = serviceConnection;
        this.zzRl = MediaRouter.getInstance(getApplicationContext());
        this.zzRl.addCallback(new MediaRouteSelector.Builder().addControlCategory(CastMediaControlIntent.categoryForCast(this.zzQv)).build(), this.zzRm, 4);
        this.mHandler = new Handler(getMainLooper());
        this.mNotification = notificationSettings.mNotification;
        this.zzRd = new zzb();
        registerReceiver(this.zzRd, new IntentFilter("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"));
        this.zzRe = new NotificationSettings(notificationSettings);
        if (this.zzRe.mNotification == null) {
            this.zzRf = true;
            this.mNotification = zzN(false);
        } else {
            this.zzRf = false;
            this.mNotification = this.zzRe.mNotification;
        }
        this.zzRa = zza(castDevice);
        this.zzRa.connect();
    }

    private static void zzb(Context context, Class cls) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 128);
            if (serviceInfo != null && serviceInfo.exported) {
                throw new IllegalStateException("The service must not be exported, verify the manifest configuration");
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalStateException("Service not found, did you forget to configure it in the manifest?");
        }
    }

    private void zzlg() {
        if (this.zzRl != null) {
            zzu.zzbY("CastRemoteDisplayLocalService calls must be done on the main thread");
            this.zzRl.removeCallback(this.zzRm);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzlh() {
        zzQW.zzb("startRemoteDisplay", new Object[0]);
        if (this.zzRa == null || !this.zzRa.isConnected()) {
            zzQW.zzc("Unable to start the remote display as the API client is not ready", new Object[0]);
        } else {
            CastRemoteDisplay.CastRemoteDisplayApi.startRemoteDisplay(this.zzRa, this.zzQv).setResultCallback(new ResultCallback<CastRemoteDisplay.CastRemoteDisplaySessionResult>() {
                /* class com.google.android.gms.cast.CastRemoteDisplayLocalService.AnonymousClass4 */

                /* renamed from: zza */
                public void onResult(CastRemoteDisplay.CastRemoteDisplaySessionResult castRemoteDisplaySessionResult) {
                    if (!castRemoteDisplaySessionResult.getStatus().isSuccess()) {
                        CastRemoteDisplayLocalService.zzQW.zzc("Connection was not successful", new Object[0]);
                        CastRemoteDisplayLocalService.this.zzlj();
                        return;
                    }
                    Display presentationDisplay = castRemoteDisplaySessionResult.getPresentationDisplay();
                    if (presentationDisplay != null) {
                        CastRemoteDisplayLocalService.this.zza((CastRemoteDisplayLocalService) presentationDisplay);
                    } else {
                        CastRemoteDisplayLocalService.zzQW.zzc("Cast Remote Display session created without display", new Object[0]);
                    }
                    CastRemoteDisplayLocalService.zzQZ.set(false);
                    if (CastRemoteDisplayLocalService.this.zzRj != null && CastRemoteDisplayLocalService.this.zzRk != null) {
                        CastRemoteDisplayLocalService.this.zzRj.unbindService(CastRemoteDisplayLocalService.this.zzRk);
                        CastRemoteDisplayLocalService.this.zzRk = null;
                        CastRemoteDisplayLocalService.this.zzRj = null;
                    }
                }
            });
        }
    }

    private void zzli() {
        zzQW.zzb("stopRemoteDisplay", new Object[0]);
        if (this.zzRa == null || !this.zzRa.isConnected()) {
            zzQW.zzc("Unable to stop the remote display as the API client is not ready", new Object[0]);
        } else {
            CastRemoteDisplay.CastRemoteDisplayApi.stopRemoteDisplay(this.zzRa).setResultCallback(new ResultCallback<CastRemoteDisplay.CastRemoteDisplaySessionResult>() {
                /* class com.google.android.gms.cast.CastRemoteDisplayLocalService.AnonymousClass5 */

                /* renamed from: zza */
                public void onResult(CastRemoteDisplay.CastRemoteDisplaySessionResult castRemoteDisplaySessionResult) {
                    if (!castRemoteDisplaySessionResult.getStatus().isSuccess()) {
                        CastRemoteDisplayLocalService.zzQW.zzb("Unable to stop the remote display, result unsuccessful", new Object[0]);
                    } else {
                        CastRemoteDisplayLocalService.zzQW.zzb("remote display stopped", new Object[0]);
                    }
                    CastRemoteDisplayLocalService.this.zzRi = null;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzlj() {
        if (this.zzRc != null) {
            this.zzRc.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
            this.zzRc = null;
        }
        stopService();
    }

    private void zzlk() {
        zzQW.zzb("stopRemoteDisplaySession", new Object[0]);
        zzli();
        onDismissPresentation();
    }

    private void zzll() {
        zzQW.zzb("Stopping the remote display Service", new Object[0]);
        stopForeground(true);
        stopSelf();
    }

    private PendingIntent zzlm() {
        if (this.zzRg == null) {
            this.zzRg = PendingIntent.getBroadcast(this, 0, new Intent("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"), DriveFile.MODE_READ_ONLY);
        }
        return this.zzRg;
    }

    /* access modifiers changed from: protected */
    public Display getDisplay() {
        return this.zzRi;
    }

    public IBinder onBind(Intent intent) {
        return this.zzRo;
    }

    public void onCreate() {
        super.onCreate();
        this.zzRb = new CastRemoteDisplay.CastRemoteDisplaySessionCallbacks() {
            /* class com.google.android.gms.cast.CastRemoteDisplayLocalService.AnonymousClass3 */

            @Override // com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks
            public void onRemoteDisplayEnded(Status status) {
                CastRemoteDisplayLocalService.zzQW.zzb(String.format("Cast screen has ended: %d", Integer.valueOf(status.getStatusCode())), new Object[0]);
                if (CastRemoteDisplayLocalService.this.mHandler != null) {
                    CastRemoteDisplayLocalService.this.mHandler.post(new Runnable() {
                        /* class com.google.android.gms.cast.CastRemoteDisplayLocalService.AnonymousClass3.AnonymousClass1 */

                        public void run() {
                            CastRemoteDisplayLocalService.zzM(false);
                        }
                    });
                }
            }
        };
    }

    public abstract void onCreatePresentation(Display display);

    public abstract void onDismissPresentation();

    public int onStartCommand(Intent intent, int flags, int startId) {
        zzQW.zzb("onStartCommand", new Object[0]);
        return 2;
    }

    public void updateNotificationSettings(NotificationSettings notificationSettings) {
        zzu.zzb(notificationSettings, "notificationSettings is required.");
        if (!this.zzRf.booleanValue()) {
            zzu.zzb(notificationSettings.mNotification, "notification is required.");
            this.mNotification = notificationSettings.mNotification;
            this.zzRe.mNotification = this.mNotification;
        } else if (notificationSettings.mNotification != null) {
            throw new IllegalStateException("Current mode is default notification, notification attribute must not be provided");
        } else {
            if (notificationSettings.zzRv != null) {
                this.zzRe.zzRv = notificationSettings.zzRv;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzRw)) {
                this.zzRe.zzRw = notificationSettings.zzRw;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzRx)) {
                this.zzRe.zzRx = notificationSettings.zzRx;
            }
            this.mNotification = zzN(true);
        }
        startForeground(zzQX, this.mNotification);
    }
}
