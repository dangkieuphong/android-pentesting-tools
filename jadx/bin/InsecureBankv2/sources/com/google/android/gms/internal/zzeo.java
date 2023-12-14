package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.R;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.plus.PlusShare;
import java.util.Map;

@zzgd
public class zzeo extends zzeu {
    private final Context mContext;
    private final Map<String, String> zzyn;
    private String zzyo;
    private long zzyp;
    private long zzyq;
    private String zzyr;
    private String zzys;

    public zzeo(zzid zzid, Map<String, String> map) {
        super(zzid, "createCalendarEvent");
        this.zzyn = map;
        this.mContext = zzid.zzgB();
        zzeb();
    }

    private String zzab(String str) {
        return TextUtils.isEmpty(this.zzyn.get(str)) ? "" : this.zzyn.get(str);
    }

    private long zzac(String str) {
        String str2 = this.zzyn.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void zzeb() {
        this.zzyo = zzab(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        this.zzyr = zzab("summary");
        this.zzyp = zzac("start_ticks");
        this.zzyq = zzac("end_ticks");
        this.zzys = zzab("location");
    }

    /* access modifiers changed from: package-private */
    public Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.zzyo);
        data.putExtra("eventLocation", this.zzys);
        data.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.zzyr);
        if (this.zzyp > -1) {
            data.putExtra("beginTime", this.zzyp);
        }
        if (this.zzyq > -1) {
            data.putExtra("endTime", this.zzyq);
        }
        data.setFlags(DriveFile.MODE_READ_ONLY);
        return data;
    }

    public void execute() {
        if (this.mContext == null) {
            zzae("Activity context is not available.");
        } else if (!zzo.zzbv().zzK(this.mContext).zzcV()) {
            zzae("This feature is not available on the device.");
        } else {
            AlertDialog.Builder zzJ = zzo.zzbv().zzJ(this.mContext);
            zzJ.setTitle(zzo.zzby().zzc(R.string.create_calendar_title, "Create calendar event"));
            zzJ.setMessage(zzo.zzby().zzc(R.string.create_calendar_message, "Allow Ad to create a calendar event?"));
            zzJ.setPositiveButton(zzo.zzby().zzc(R.string.accept, "Accept"), new DialogInterface.OnClickListener() {
                /* class com.google.android.gms.internal.zzeo.AnonymousClass1 */

                public void onClick(DialogInterface dialog, int which) {
                    zzeo.this.mContext.startActivity(zzeo.this.createIntent());
                }
            });
            zzJ.setNegativeButton(zzo.zzby().zzc(R.string.decline, "Decline"), new DialogInterface.OnClickListener() {
                /* class com.google.android.gms.internal.zzeo.AnonymousClass2 */

                public void onClick(DialogInterface dialog, int which) {
                    zzeo.this.zzae("Operation denied by user.");
                }
            });
            zzJ.create().show();
        }
    }
}
