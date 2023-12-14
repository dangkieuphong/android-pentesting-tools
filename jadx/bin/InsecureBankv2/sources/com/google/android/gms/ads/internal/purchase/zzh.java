package com.google.android.gms.ads.internal.purchase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzgd;

@zzgd
public class zzh {
    private static final String zzAX = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", "InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time");
    private static zzh zzAZ;
    private static final Object zzqt = new Object();
    private final zza zzAY;

    public class zza extends SQLiteOpenHelper {
        public zza(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 4);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(zzh.zzAX);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            zzb.zzaA("Database updated from version " + oldVersion + " to version " + newVersion);
            db.execSQL("DROP TABLE IF EXISTS InAppPurchase");
            onCreate(db);
        }
    }

    zzh(Context context) {
        this.zzAY = new zza(context, "google_inapp_purchase.db");
    }

    public static zzh zzy(Context context) {
        zzh zzh;
        synchronized (zzqt) {
            if (zzAZ == null) {
                zzAZ = new zzh(context);
            }
            zzh = zzAZ;
        }
        return zzh;
    }

    public int getRecordCount() {
        Cursor cursor = null;
        int i = 0;
        synchronized (zzqt) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    Cursor rawQuery = writableDatabase.rawQuery("select count(*) from InAppPurchase", null);
                    if (rawQuery.moveToFirst()) {
                        i = rawQuery.getInt(0);
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    } else if (rawQuery != null) {
                        rawQuery.close();
                    }
                } catch (SQLiteException e) {
                    zzb.zzaC("Error getting record count" + e.getMessage());
                    if (0 != 0) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        }
        return i;
    }

    public SQLiteDatabase getWritableDatabase() {
        try {
            return this.zzAY.getWritableDatabase();
        } catch (SQLiteException e) {
            zzb.zzaC("Error opening writable conversion tracking database");
            return null;
        }
    }

    public zzf zza(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        return new zzf(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
    }

    public void zza(zzf zzf) {
        if (zzf != null) {
            synchronized (zzqt) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase != null) {
                    writableDatabase.delete("InAppPurchase", String.format("%s = %d", "purchase_id", Long.valueOf(zzf.zzAR)), null);
                }
            }
        }
    }

    public void zzb(zzf zzf) {
        if (zzf != null) {
            synchronized (zzqt) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("product_id", zzf.zzAT);
                    contentValues.put("developer_payload", zzf.zzAS);
                    contentValues.put("record_time", Long.valueOf(SystemClock.elapsedRealtime()));
                    zzf.zzAR = writableDatabase.insert("InAppPurchase", null, contentValues);
                    if (((long) getRecordCount()) > 20000) {
                        zzfg();
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.ads.internal.purchase.zzf> zzf(long r14) {
        /*
        // Method dump skipped, instructions count: 120
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.purchase.zzh.zzf(long):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzfg() {
        /*
            r11 = this;
            r9 = 0
            java.lang.Object r10 = com.google.android.gms.ads.internal.purchase.zzh.zzqt
            monitor-enter(r10)
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x000c
            monitor-exit(r10)     // Catch:{ all -> 0x0031 }
        L_0x000b:
            return
        L_0x000c:
            java.lang.String r7 = "record_time ASC"
            java.lang.String r1 = "InAppPurchase"
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r8 = "1"
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0034, all -> 0x0056 }
            if (r1 == 0) goto L_0x002a
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0060 }
            if (r0 == 0) goto L_0x002a
            com.google.android.gms.ads.internal.purchase.zzf r0 = r11.zza(r1)     // Catch:{ SQLiteException -> 0x0060 }
            r11.zza(r0)     // Catch:{ SQLiteException -> 0x0060 }
        L_0x002a:
            if (r1 == 0) goto L_0x002f
            r1.close()
        L_0x002f:
            monitor-exit(r10)
            goto L_0x000b
        L_0x0031:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        L_0x0034:
            r0 = move-exception
            r1 = r9
        L_0x0036:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005e }
            r2.<init>()     // Catch:{ all -> 0x005e }
            java.lang.String r3 = "Error remove oldest record"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x005e }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x005e }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x005e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x005e }
            com.google.android.gms.ads.internal.util.client.zzb.zzaC(r0)     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x002f
            r1.close()
            goto L_0x002f
        L_0x0056:
            r0 = move-exception
            r1 = r9
        L_0x0058:
            if (r1 == 0) goto L_0x005d
            r1.close()
        L_0x005d:
            throw r0
        L_0x005e:
            r0 = move-exception
            goto L_0x0058
        L_0x0060:
            r0 = move-exception
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.purchase.zzh.zzfg():void");
    }
}
