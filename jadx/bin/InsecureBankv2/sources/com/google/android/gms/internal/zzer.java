package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.R;
import com.google.android.gms.ads.internal.zzo;
import java.util.Map;

@zzgd
public class zzer extends zzeu {
    private final Context mContext;
    private final Map<String, String> zzyn;

    public zzer(zzid zzid, Map<String, String> map) {
        super(zzid, "storePicture");
        this.zzyn = map;
        this.mContext = zzid.zzgB();
    }

    public void execute() {
        if (this.mContext == null) {
            zzae("Activity context is not available");
        } else if (!zzo.zzbv().zzK(this.mContext).zzcS()) {
            zzae("Feature is not supported by the device.");
        } else {
            final String str = this.zzyn.get("iurl");
            if (TextUtils.isEmpty(str)) {
                zzae("Image url cannot be empty.");
            } else if (!URLUtil.isValidUrl(str)) {
                zzae("Invalid image url: " + str);
            } else {
                final String zzad = zzad(str);
                if (!zzo.zzbv().zzav(zzad)) {
                    zzae("Image type not recognized: " + zzad);
                    return;
                }
                AlertDialog.Builder zzJ = zzo.zzbv().zzJ(this.mContext);
                zzJ.setTitle(zzo.zzby().zzc(R.string.store_picture_title, "Save image"));
                zzJ.setMessage(zzo.zzby().zzc(R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
                zzJ.setPositiveButton(zzo.zzby().zzc(R.string.accept, "Accept"), new DialogInterface.OnClickListener() {
                    /* class com.google.android.gms.internal.zzer.AnonymousClass1 */

                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            ((DownloadManager) zzer.this.mContext.getSystemService("download")).enqueue(zzer.this.zzf(str, zzad));
                        } catch (IllegalStateException e) {
                            zzer.this.zzae("Could not store picture.");
                        }
                    }
                });
                zzJ.setNegativeButton(zzo.zzby().zzc(R.string.decline, "Decline"), new DialogInterface.OnClickListener() {
                    /* class com.google.android.gms.internal.zzer.AnonymousClass2 */

                    public void onClick(DialogInterface dialog, int which) {
                        zzer.this.zzae("User canceled the download.");
                    }
                });
                zzJ.create().show();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String zzad(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    /* access modifiers changed from: package-private */
    public DownloadManager.Request zzf(String str, String str2) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        zzo.zzbx().zza(request);
        return request;
    }
}
