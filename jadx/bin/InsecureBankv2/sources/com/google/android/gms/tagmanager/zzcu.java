package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

/* access modifiers changed from: package-private */
public class zzcu extends zzct {
    private static final Object zzaND = new Object();
    private static zzcu zzaNO;
    private boolean connected = true;
    private Handler handler;
    private Context zzaNE;
    private zzau zzaNF;
    private volatile zzas zzaNG;
    private int zzaNH = 1800000;
    private boolean zzaNI = true;
    private boolean zzaNJ = false;
    private boolean zzaNK = true;
    private zzav zzaNL = new zzav() {
        /* class com.google.android.gms.tagmanager.zzcu.AnonymousClass1 */

        @Override // com.google.android.gms.tagmanager.zzav
        public void zzan(boolean z) {
            zzcu.this.zzd(z, zzcu.this.connected);
        }
    };
    private zzbl zzaNM;
    private boolean zzaNN = false;

    private zzcu() {
    }

    private void zzzA() {
        this.zzaNM = new zzbl(this);
        this.zzaNM.zzaI(this.zzaNE);
    }

    private void zzzB() {
        this.handler = new Handler(this.zzaNE.getMainLooper(), new Handler.Callback() {
            /* class com.google.android.gms.tagmanager.zzcu.AnonymousClass2 */

            public boolean handleMessage(Message msg) {
                if (1 == msg.what && zzcu.zzaND.equals(msg.obj)) {
                    zzcu.this.dispatch();
                    if (zzcu.this.zzaNH > 0 && !zzcu.this.zzaNN) {
                        zzcu.this.handler.sendMessageDelayed(zzcu.this.handler.obtainMessage(1, zzcu.zzaND), (long) zzcu.this.zzaNH);
                    }
                }
                return true;
            }
        });
        if (this.zzaNH > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1, zzaND), (long) this.zzaNH);
        }
    }

    public static zzcu zzzz() {
        if (zzaNO == null) {
            zzaNO = new zzcu();
        }
        return zzaNO;
    }

    @Override // com.google.android.gms.tagmanager.zzct
    public synchronized void dispatch() {
        if (!this.zzaNJ) {
            zzbg.zzaB("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.zzaNI = true;
        } else {
            this.zzaNG.zzf(new Runnable() {
                /* class com.google.android.gms.tagmanager.zzcu.AnonymousClass3 */

                public void run() {
                    zzcu.this.zzaNF.dispatch();
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void zza(Context context, zzas zzas) {
        if (this.zzaNE == null) {
            this.zzaNE = context.getApplicationContext();
            if (this.zzaNG == null) {
                this.zzaNG = zzas;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.tagmanager.zzct
    public synchronized void zzao(boolean z) {
        zzd(this.zzaNN, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized void zzd(boolean z, boolean z2) {
        if (!(this.zzaNN == z && this.connected == z2)) {
            if ((z || !z2) && this.zzaNH > 0) {
                this.handler.removeMessages(1, zzaND);
            }
            if (!z && z2 && this.zzaNH > 0) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, zzaND), (long) this.zzaNH);
            }
            zzbg.zzaB("PowerSaveMode " + ((z || !z2) ? "initiated." : "terminated."));
            this.zzaNN = z;
            this.connected = z2;
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.tagmanager.zzct
    public synchronized void zzhK() {
        if (!this.zzaNN && this.connected && this.zzaNH > 0) {
            this.handler.removeMessages(1, zzaND);
            this.handler.sendMessage(this.handler.obtainMessage(1, zzaND));
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized zzau zzzC() {
        if (this.zzaNF == null) {
            if (this.zzaNE == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.zzaNF = new zzby(this.zzaNL, this.zzaNE);
        }
        if (this.handler == null) {
            zzzB();
        }
        this.zzaNJ = true;
        if (this.zzaNI) {
            dispatch();
            this.zzaNI = false;
        }
        if (this.zzaNM == null && this.zzaNK) {
            zzzA();
        }
        return this.zzaNF;
    }
}
