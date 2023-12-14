package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.search.SearchAuth;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@zzgd
public class zzdt {
    private final Context mContext;
    private final VersionInfoParcel zzoM;
    private final Object zzqt;
    private final String zzwO;
    private zzb<zzbb> zzwP;
    private zzb<zzbb> zzwQ;
    private zze zzwR;
    private int zzwS;

    static class zza {
        static int zzxc = 60000;
        static int zzxd = SearchAuth.StatusCodes.AUTH_DISABLED;
    }

    public interface zzb<T> {
        void zzc(T t);
    }

    public static class zzc<T> implements zzb<T> {
        @Override // com.google.android.gms.internal.zzdt.zzb
        public void zzc(T t) {
        }
    }

    public static class zzd extends zzhy<zzbe> {
        private final Object zzqt = new Object();
        private final zze zzxe;
        private boolean zzxf;

        public zzd(zze zze) {
            this.zzxe = zze;
        }

        public void release() {
            synchronized (this.zzqt) {
                if (!this.zzxf) {
                    this.zzxf = true;
                    zza(new zzhx.zzc<zzbe>() {
                        /* class com.google.android.gms.internal.zzdt.zzd.AnonymousClass1 */

                        /* renamed from: zzb */
                        public void zzc(zzbe zzbe) {
                            com.google.android.gms.ads.internal.util.client.zzb.zzaB("Ending javascript session.");
                            ((zzbf) zzbe).zzcg();
                        }
                    }, new zzhx.zzb());
                    zza(new zzhx.zzc<zzbe>() {
                        /* class com.google.android.gms.internal.zzdt.zzd.AnonymousClass2 */

                        /* renamed from: zzb */
                        public void zzc(zzbe zzbe) {
                            com.google.android.gms.ads.internal.util.client.zzb.zzaB("Releasing engine reference.");
                            zzd.this.zzxe.zzdW();
                        }
                    }, new zzhx.zza() {
                        /* class com.google.android.gms.internal.zzdt.zzd.AnonymousClass3 */

                        @Override // com.google.android.gms.internal.zzhx.zza
                        public void run() {
                            zzd.this.zzxe.zzdW();
                        }
                    });
                }
            }
        }
    }

    public static class zze extends zzhy<zzbb> {
        private final Object zzqt = new Object();
        private zzb<zzbb> zzwQ;
        private boolean zzxh;
        private int zzxi;

        public zze(zzb<zzbb> zzb) {
            this.zzwQ = zzb;
            this.zzxh = false;
            this.zzxi = 0;
        }

        public zzd zzdV() {
            final zzd zzd = new zzd(this);
            synchronized (this.zzqt) {
                zza(new zzhx.zzc<zzbb>() {
                    /* class com.google.android.gms.internal.zzdt.zze.AnonymousClass1 */

                    /* renamed from: zza */
                    public void zzc(zzbb zzbb) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzaB("Getting a new session for JS Engine.");
                        zzd.zzg(zzbb.zzce());
                    }
                }, new zzhx.zza() {
                    /* class com.google.android.gms.internal.zzdt.zze.AnonymousClass2 */

                    @Override // com.google.android.gms.internal.zzhx.zza
                    public void run() {
                        com.google.android.gms.ads.internal.util.client.zzb.zzaB("Rejecting reference for JS Engine.");
                        zzd.reject();
                    }
                });
                zzu.zzU(this.zzxi >= 0);
                this.zzxi++;
            }
            return zzd;
        }

        /* access modifiers changed from: protected */
        public void zzdW() {
            boolean z = true;
            synchronized (this.zzqt) {
                if (this.zzxi < 1) {
                    z = false;
                }
                zzu.zzU(z);
                com.google.android.gms.ads.internal.util.client.zzb.zzaB("Releasing 1 reference for JS Engine");
                this.zzxi--;
                zzdY();
            }
        }

        public void zzdX() {
            boolean z = true;
            synchronized (this.zzqt) {
                if (this.zzxi < 0) {
                    z = false;
                }
                zzu.zzU(z);
                com.google.android.gms.ads.internal.util.client.zzb.zzaB("Releasing root reference. JS Engine will be destroyed once other references are released.");
                this.zzxh = true;
                zzdY();
            }
        }

        /* access modifiers changed from: protected */
        public void zzdY() {
            synchronized (this.zzqt) {
                zzu.zzU(this.zzxi >= 0);
                if (!this.zzxh || this.zzxi != 0) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaB("There are still references to the engine. Not destroying.");
                } else {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaB("No reference is left (including root). Cleaning up engine.");
                    zza(new zzhx.zzc<zzbb>() {
                        /* class com.google.android.gms.internal.zzdt.zze.AnonymousClass3 */

                        /* renamed from: zza */
                        public void zzc(final zzbb zzbb) {
                            zzhl.runOnUiThread(new Runnable() {
                                /* class com.google.android.gms.internal.zzdt.zze.AnonymousClass3.AnonymousClass1 */

                                public void run() {
                                    zze.this.zzwQ.zzc(zzbb);
                                    zzbb.destroy();
                                }
                            });
                        }
                    }, new zzhx.zzb());
                }
            }
        }
    }

    public zzdt(Context context, VersionInfoParcel versionInfoParcel, String str) {
        this.zzqt = new Object();
        this.zzwS = 1;
        this.zzwO = str;
        this.mContext = context.getApplicationContext();
        this.zzoM = versionInfoParcel;
        this.zzwP = new zzc();
        this.zzwQ = new zzc();
    }

    public zzdt(Context context, VersionInfoParcel versionInfoParcel, String str, zzb<zzbb> zzb2, zzb<zzbb> zzb3) {
        this(context, versionInfoParcel, str);
        this.zzwP = zzb2;
        this.zzwQ = zzb3;
    }

    private zze zzdS() {
        final zze zze2 = new zze(this.zzwQ);
        zzhl.runOnUiThread(new Runnable() {
            /* class com.google.android.gms.internal.zzdt.AnonymousClass1 */

            public void run() {
                final zzbb zza = zzdt.this.zza(zzdt.this.mContext, zzdt.this.zzoM);
                zza.zza(new zzbb.zza() {
                    /* class com.google.android.gms.internal.zzdt.AnonymousClass1.AnonymousClass1 */

                    @Override // com.google.android.gms.internal.zzbb.zza
                    public void zzcf() {
                        new Timer().schedule(new TimerTask() {
                            /* class com.google.android.gms.internal.zzdt.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                synchronized (zzdt.this.zzqt) {
                                    if (zze2.getStatus() != -1 && zze2.getStatus() != 1) {
                                        zze2.reject();
                                        zzhl.runOnUiThread(new Runnable() {
                                            /* class com.google.android.gms.internal.zzdt.AnonymousClass1.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                            public void run() {
                                                zza.destroy();
                                            }
                                        });
                                        com.google.android.gms.ads.internal.util.client.zzb.zzaB("Could not receive loaded message in a timely manner. Rejecting.");
                                    }
                                }
                            }
                        }, (long) zza.zzxd);
                    }
                });
                zza.zza("/jsLoaded", new zzdg() {
                    /* class com.google.android.gms.internal.zzdt.AnonymousClass1.AnonymousClass2 */

                    @Override // com.google.android.gms.internal.zzdg
                    public void zza(zzid zzid, Map<String, String> map) {
                        synchronized (zzdt.this.zzqt) {
                            if (zze2.getStatus() != -1 && zze2.getStatus() != 1) {
                                zzdt.this.zzwS = 0;
                                zzdt.this.zzwP.zzc(zza);
                                zze2.zzg(zza);
                                zzdt.this.zzwR = zze2;
                                com.google.android.gms.ads.internal.util.client.zzb.zzaB("Successfully loaded JS Engine.");
                            }
                        }
                    }
                });
                final zzhr zzhr = new zzhr();
                AnonymousClass3 r2 = new zzdg() {
                    /* class com.google.android.gms.internal.zzdt.AnonymousClass1.AnonymousClass3 */

                    @Override // com.google.android.gms.internal.zzdg
                    public void zza(zzid zzid, Map<String, String> map) {
                        synchronized (zzdt.this.zzqt) {
                            com.google.android.gms.ads.internal.util.client.zzb.zzaA("JS Engine is requesting an update");
                            if (zzdt.this.zzwS == 0) {
                                com.google.android.gms.ads.internal.util.client.zzb.zzaA("Starting reload.");
                                zzdt.this.zzwS = 2;
                                zzdt.this.zzdT();
                            }
                            zza.zzb("/requestReload", (zzdg) zzhr.get());
                        }
                    }
                };
                zzhr.set(r2);
                zza.zza("/requestReload", r2);
                if (zzdt.this.zzwO.endsWith(".js")) {
                    zza.zzr(zzdt.this.zzwO);
                } else if (zzdt.this.zzwO.startsWith("<html>")) {
                    zza.zzt(zzdt.this.zzwO);
                } else {
                    zza.zzs(zzdt.this.zzwO);
                }
                new Timer().schedule(new TimerTask() {
                    /* class com.google.android.gms.internal.zzdt.AnonymousClass1.AnonymousClass4 */

                    public void run() {
                        synchronized (zzdt.this.zzqt) {
                            if (zze2.getStatus() != -1 && zze2.getStatus() != 1) {
                                zze2.reject();
                                zzhl.runOnUiThread(new Runnable() {
                                    /* class com.google.android.gms.internal.zzdt.AnonymousClass1.AnonymousClass4.AnonymousClass1 */

                                    public void run() {
                                        zza.destroy();
                                    }
                                });
                                com.google.android.gms.ads.internal.util.client.zzb.zzaB("Could not receive loaded message in a timely manner. Rejecting.");
                            }
                        }
                    }
                }, (long) zza.zzxc);
            }
        });
        return zze2;
    }

    /* access modifiers changed from: protected */
    public zzbb zza(Context context, VersionInfoParcel versionInfoParcel) {
        return new zzbd(context, versionInfoParcel);
    }

    /* access modifiers changed from: protected */
    public zze zzdT() {
        final zze zzdS = zzdS();
        zzdS.zza(new zzhx.zzc<zzbb>() {
            /* class com.google.android.gms.internal.zzdt.AnonymousClass2 */

            /* renamed from: zza */
            public void zzc(zzbb zzbb) {
                synchronized (zzdt.this.zzqt) {
                    zzdt.this.zzwS = 0;
                    if (!(zzdt.this.zzwR == null || zzdS == zzdt.this.zzwR)) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzaB("New JS engine is loaded, marking previous one as destroyable.");
                        zzdt.this.zzwR.zzdX();
                    }
                    zzdt.this.zzwR = zzdS;
                }
            }
        }, new zzhx.zza() {
            /* class com.google.android.gms.internal.zzdt.AnonymousClass3 */

            @Override // com.google.android.gms.internal.zzhx.zza
            public void run() {
                synchronized (zzdt.this.zzqt) {
                    zzdt.this.zzwS = 1;
                    com.google.android.gms.ads.internal.util.client.zzb.zzaB("Failed loading new engine. Marking new engine destroyable.");
                    zzdS.zzdX();
                }
            }
        });
        return zzdS;
    }

    public zzd zzdU() {
        zzd zzd2;
        synchronized (this.zzqt) {
            if (this.zzwR == null || this.zzwR.getStatus() == -1) {
                this.zzwS = 2;
                this.zzwR = zzdT();
                zzd2 = this.zzwR.zzdV();
            } else if (this.zzwS == 0) {
                zzd2 = this.zzwR.zzdV();
            } else if (this.zzwS == 1) {
                this.zzwS = 2;
                zzdT();
                zzd2 = this.zzwR.zzdV();
            } else {
                zzd2 = this.zzwS == 2 ? this.zzwR.zzdV() : this.zzwR.zzdV();
            }
        }
        return zzd2;
    }
}
