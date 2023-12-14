package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import com.google.android.gms.drive.events.zzc;
import com.google.android.gms.drive.events.zzf;
import com.google.android.gms.drive.events.zzi;
import com.google.android.gms.drive.events.zzj;
import com.google.android.gms.drive.events.zzl;
import com.google.android.gms.drive.internal.zzam;
import java.util.ArrayList;
import java.util.List;

public class zzac extends zzam.zza {
    private final int zzaca;
    private final zzf zzafC;
    private final zza zzafD;
    private final List<Integer> zzafE = new ArrayList();

    private static class zza extends Handler {
        private final Context mContext;

        private zza(Looper looper, Context context) {
            super(looper);
            this.mContext = context;
        }

        private static void zza(zzl zzl, QueryResultEventParcelable queryResultEventParcelable) {
            DataHolder zzpx = queryResultEventParcelable.zzpx();
            if (zzpx != null) {
                final MetadataBuffer metadataBuffer = new MetadataBuffer(zzpx);
                zzl.zza(new zzj() {
                    /* class com.google.android.gms.drive.internal.zzac.zza.AnonymousClass1 */
                });
            }
            if (queryResultEventParcelable.zzpy()) {
                zzl.zzck(queryResultEventParcelable.zzpz());
            }
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    zzf zzf = (zzf) pair.first;
                    DriveEvent driveEvent = (DriveEvent) pair.second;
                    switch (driveEvent.getType()) {
                        case 1:
                            ((ChangeListener) zzf).onChange((ChangeEvent) driveEvent);
                            return;
                        case 2:
                            ((CompletionListener) zzf).onCompletion((CompletionEvent) driveEvent);
                            return;
                        case 3:
                            zza((zzl) zzf, (QueryResultEventParcelable) driveEvent);
                            return;
                        case 4:
                            ((zzc) zzf).zza((ChangesAvailableEvent) driveEvent);
                            return;
                        case 5:
                        case 6:
                            ((zzi) zzf).zza((ProgressEvent) driveEvent);
                            return;
                        default:
                            zzx.zzu("EventCallback", "Unexpected event: " + driveEvent);
                            return;
                    }
                default:
                    zzx.zze(this.mContext, "EventCallback", "Don't know how to handle this event");
                    return;
            }
        }

        public void zza(zzf zzf, DriveEvent driveEvent) {
            sendMessage(obtainMessage(1, new Pair(zzf, driveEvent)));
        }
    }

    public zzac(Looper looper, Context context, int i, zzf zzf) {
        this.zzaca = i;
        this.zzafC = zzf;
        this.zzafD = new zza(looper, context);
    }

    @Override // com.google.android.gms.drive.internal.zzam
    public void zzc(OnEventResponse onEventResponse) throws RemoteException {
        DriveEvent zzpO = onEventResponse.zzpO();
        zzu.zzU(this.zzaca == zzpO.getType());
        zzu.zzU(this.zzafE.contains(Integer.valueOf(zzpO.getType())));
        this.zzafD.zza(this.zzafC, zzpO);
    }

    public void zzcA(int i) {
        this.zzafE.add(Integer.valueOf(i));
    }

    public boolean zzcB(int i) {
        return this.zzafE.contains(Integer.valueOf(i));
    }
}
