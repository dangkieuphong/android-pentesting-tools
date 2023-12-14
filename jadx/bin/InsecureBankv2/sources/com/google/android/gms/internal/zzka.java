package com.google.android.gms.internal;

import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.cast.CastRemoteDisplayApi;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.internal.zzkc;
import com.google.android.gms.internal.zzke;

public class zzka implements CastRemoteDisplayApi {
    private static final zzl zzQW = new zzl("CastRemoteDisplayApiImpl");
    private Api.ClientKey<zzkb> zzVu;
    private VirtualDisplay zzVv;
    private final zzke zzVw = new zzke.zza() {
        /* class com.google.android.gms.internal.zzka.AnonymousClass1 */

        @Override // com.google.android.gms.internal.zzke
        public void zzaR(int i) {
            zzka.zzQW.zzb("onRemoteDisplayEnded", new Object[0]);
            zzka.this.zzmf();
        }
    };

    private abstract class zza extends zzkc.zza {
        private zza() {
        }

        @Override // com.google.android.gms.internal.zzkc
        public void onDisconnected() throws RemoteException {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.gms.internal.zzkc
        public void onError(int statusCode) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.gms.internal.zzkc
        public void zza(int i, int i2, Surface surface) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.gms.internal.zzkc
        public void zzmg() throws RemoteException {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: private */
    public abstract class zzb extends zza.AbstractC0027zza<CastRemoteDisplay.CastRemoteDisplaySessionResult, zzkb> {

        /* access modifiers changed from: protected */
        public final class zza extends zza {
            private final zzkb zzVz;

            public zza(zzkb zzkb) {
                super();
                this.zzVz = zzkb;
            }

            private int zzi(int i, int i2) {
                if (i >= i2) {
                    i = i2;
                }
                return (i * 320) / 1080;
            }

            @Override // com.google.android.gms.internal.zzka.zza, com.google.android.gms.internal.zzkc
            public void onError(int statusCode) throws RemoteException {
                zzka.zzQW.zzb("onError: %d", Integer.valueOf(statusCode));
                zzka.this.zzmf();
                zzb.this.setResult(new zzc(Status.zzXR));
            }

            @Override // com.google.android.gms.internal.zzka.zza, com.google.android.gms.internal.zzkc
            public void zza(int i, int i2, Surface surface) {
                zzka.zzQW.zzb("onConnected", new Object[0]);
                DisplayManager displayManager = (DisplayManager) this.zzVz.getContext().getSystemService("display");
                if (displayManager == null) {
                    zzka.zzQW.zzc("Unable to get the display manager", new Object[0]);
                    zzb.this.setResult(new zzc(Status.zzXR));
                    return;
                }
                zzka.this.zzmf();
                int zzi = zzi(i, i2);
                zzka.this.zzVv = displayManager.createVirtualDisplay("private_display", i, i2, zzi, surface, 2);
                if (zzka.this.zzVv == null) {
                    zzka.zzQW.zzc("Unable to create virtual display", new Object[0]);
                    zzb.this.setResult(new zzc(Status.zzXR));
                } else if (zzka.this.zzVv.getDisplay() == null) {
                    zzka.zzQW.zzc("Virtual display does not have a display", new Object[0]);
                    zzb.this.setResult(new zzc(Status.zzXR));
                } else {
                    try {
                        this.zzVz.zza(this, zzka.this.zzVv.getDisplay().getDisplayId());
                    } catch (RemoteException e) {
                        zzb.this.setResult(new zzc(Status.zzXR));
                    }
                }
            }

            @Override // com.google.android.gms.internal.zzka.zza, com.google.android.gms.internal.zzkc
            public void zzmg() {
                zzka.zzQW.zzb("onConnectedWithDisplay", new Object[0]);
                Display display = zzka.this.zzVv.getDisplay();
                if (display != null) {
                    zzb.this.setResult(new zzc(display));
                    return;
                }
                zzka.zzQW.zzc("Virtual display no longer has a display", new Object[0]);
                zzb.this.setResult(new zzc(Status.zzXR));
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: com.google.android.gms.internal.zzka$zzb$zzb  reason: collision with other inner class name */
        public final class BinderC0100zzb extends zza {
            protected BinderC0100zzb() {
                super();
            }

            @Override // com.google.android.gms.internal.zzka.zza, com.google.android.gms.internal.zzkc
            public void onDisconnected() throws RemoteException {
                zzka.zzQW.zzb("onDisconnected", new Object[0]);
                zzka.this.zzmf();
                zzb.this.setResult(new zzc(Status.zzXP));
            }

            @Override // com.google.android.gms.internal.zzka.zza, com.google.android.gms.internal.zzkc
            public void onError(int statusCode) throws RemoteException {
                zzka.zzQW.zzb("onError: %d", Integer.valueOf(statusCode));
                zzka.this.zzmf();
                zzb.this.setResult(new zzc(Status.zzXR));
            }
        }

        public zzb(GoogleApiClient googleApiClient) {
            super(zzka.this.zzVu, googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzq */
        public CastRemoteDisplay.CastRemoteDisplaySessionResult createFailedResult(Status status) {
            return new zzc(status);
        }
    }

    /* access modifiers changed from: private */
    public static final class zzc implements CastRemoteDisplay.CastRemoteDisplaySessionResult {
        private final Status zzOt;
        private final Display zzRi;

        public zzc(Display display) {
            this.zzOt = Status.zzXP;
            this.zzRi = display;
        }

        public zzc(Status status) {
            this.zzOt = status;
            this.zzRi = null;
        }

        @Override // com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult
        public Display getPresentationDisplay() {
            return this.zzRi;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    public zzka(Api.ClientKey<zzkb> clientKey) {
        this.zzVu = clientKey;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzmf() {
        if (this.zzVv != null) {
            if (this.zzVv.getDisplay() != null) {
                zzQW.zzb("releasing virtual display: " + this.zzVv.getDisplay().getDisplayId(), new Object[0]);
            }
            this.zzVv.release();
            this.zzVv = null;
        }
    }

    @Override // com.google.android.gms.cast.CastRemoteDisplayApi
    public PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> startRemoteDisplay(GoogleApiClient apiClient, final String appId) {
        zzQW.zzb("startRemoteDisplay", new Object[0]);
        return apiClient.zzb(new zzb(apiClient) {
            /* class com.google.android.gms.internal.zzka.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(zzkb zzkb) throws RemoteException {
                zzkb.zza(new zzb.zza(zzkb), zzka.this.zzVw, appId);
            }
        });
    }

    @Override // com.google.android.gms.cast.CastRemoteDisplayApi
    public PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> stopRemoteDisplay(GoogleApiClient apiClient) {
        zzQW.zzb("stopRemoteDisplay", new Object[0]);
        return apiClient.zzb(new zzb(apiClient) {
            /* class com.google.android.gms.internal.zzka.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public void zza(zzkb zzkb) throws RemoteException {
                zzkb.zza(new zzb.BinderC0100zzb());
            }
        });
    }
}
