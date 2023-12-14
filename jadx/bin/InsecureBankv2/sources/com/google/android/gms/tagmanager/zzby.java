package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.tagmanager.zzcx;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.apache.http.impl.client.DefaultHttpClient;

/* access modifiers changed from: package-private */
public class zzby implements zzau {
    private static final String zzKg = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time");
    private final Context mContext;
    private final zzb zzaMs;
    private volatile zzac zzaMt;
    private final zzav zzaMu;
    private final String zzaMv;
    private long zzaMw;
    private final int zzaMx;
    private zzlb zzpw;

    class zza implements zzcx.zza {
        zza() {
        }

        @Override // com.google.android.gms.tagmanager.zzcx.zza
        public void zza(zzaq zzaq) {
            zzby.this.zzq(zzaq.zzyO());
        }

        @Override // com.google.android.gms.tagmanager.zzcx.zza
        public void zzb(zzaq zzaq) {
            zzby.this.zzq(zzaq.zzyO());
            zzbg.zzaB("Permanent failure dispatching hitId: " + zzaq.zzyO());
        }

        @Override // com.google.android.gms.tagmanager.zzcx.zza
        public void zzc(zzaq zzaq) {
            long zzyP = zzaq.zzyP();
            if (zzyP == 0) {
                zzby.this.zzd(zzaq.zzyO(), zzby.this.zzpw.currentTimeMillis());
            } else if (zzyP + 14400000 < zzby.this.zzpw.currentTimeMillis()) {
                zzby.this.zzq(zzaq.zzyO());
                zzbg.zzaB("Giving up on failed hitId: " + zzaq.zzyO());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class zzb extends SQLiteOpenHelper {
        private long zzaMA = 0;
        private boolean zzaMz;

        zzb(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean zza(java.lang.String r11, android.database.sqlite.SQLiteDatabase r12) {
            /*
                r10 = this;
                r8 = 0
                r9 = 0
                java.lang.String r1 = "SQLITE_MASTER"
                r0 = 1
                java.lang.String[] r2 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
                r0 = 0
                java.lang.String r3 = "name"
                r2[r0] = r3     // Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
                java.lang.String r3 = "name=?"
                r0 = 1
                java.lang.String[] r4 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
                r0 = 0
                r4[r0] = r11     // Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
                r5 = 0
                r6 = 0
                r7 = 0
                r0 = r12
                android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
                boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0053, all -> 0x004c }
                if (r1 == 0) goto L_0x0025
                r1.close()
            L_0x0025:
                return r0
            L_0x0026:
                r0 = move-exception
                r0 = r9
            L_0x0028:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
                r1.<init>()     // Catch:{ all -> 0x004f }
                java.lang.String r2 = "Error querying for table "
                java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x004f }
                java.lang.StringBuilder r1 = r1.append(r11)     // Catch:{ all -> 0x004f }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x004f }
                com.google.android.gms.tagmanager.zzbg.zzaC(r1)     // Catch:{ all -> 0x004f }
                if (r0 == 0) goto L_0x0043
                r0.close()
            L_0x0043:
                r0 = r8
                goto L_0x0025
            L_0x0045:
                r0 = move-exception
            L_0x0046:
                if (r9 == 0) goto L_0x004b
                r9.close()
            L_0x004b:
                throw r0
            L_0x004c:
                r0 = move-exception
                r9 = r1
                goto L_0x0046
            L_0x004f:
                r1 = move-exception
                r9 = r0
                r0 = r1
                goto L_0x0046
            L_0x0053:
                r0 = move-exception
                r0 = r1
                goto L_0x0028
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzby.zzb.zza(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
        }

        /* JADX INFO: finally extract failed */
        private void zzc(SQLiteDatabase sQLiteDatabase) {
            String[] columnNames;
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
            HashSet hashSet = new HashSet();
            try {
                for (String str : rawQuery.getColumnNames()) {
                    hashSet.add(str);
                }
                rawQuery.close();
                if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_time") || !hashSet.remove("hit_first_send_time")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } catch (Throwable th) {
                rawQuery.close();
                throw th;
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!this.zzaMz || this.zzaMA + 3600000 <= zzby.this.zzpw.currentTimeMillis()) {
                SQLiteDatabase sQLiteDatabase = null;
                this.zzaMz = true;
                this.zzaMA = zzby.this.zzpw.currentTimeMillis();
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    zzby.this.mContext.getDatabasePath(zzby.this.zzaMv).delete();
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = super.getWritableDatabase();
                }
                this.zzaMz = false;
                return sQLiteDatabase;
            }
            throw new SQLiteException("Database creation failed");
        }

        public void onCreate(SQLiteDatabase db) {
            zzal.zzbe(db.getPath());
        }

        public void onOpen(SQLiteDatabase db) {
            if (Build.VERSION.SDK_INT < 15) {
                Cursor rawQuery = db.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (!zza("gtm_hits", db)) {
                db.execSQL(zzby.zzKg);
            } else {
                zzc(db);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    zzby(zzav zzav, Context context) {
        this(zzav, context, "gtm_urls.db", 2000);
    }

    zzby(zzav zzav, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.zzaMv = str;
        this.zzaMu = zzav;
        this.zzpw = zzld.zzoQ();
        this.zzaMs = new zzb(this.mContext, this.zzaMv);
        this.zzaMt = new zzcx(new DefaultHttpClient(), this.mContext, new zza());
        this.zzaMw = 0;
        this.zzaMx = i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzd(long j, long j2) {
        SQLiteDatabase zzer = zzer("Error opening database for getNumStoredHits.");
        if (zzer != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_first_send_time", Long.valueOf(j2));
            try {
                zzer.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
            } catch (SQLiteException e) {
                zzbg.zzaC("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + j);
                zzq(j);
            }
        }
    }

    private SQLiteDatabase zzer(String str) {
        try {
            return this.zzaMs.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbg.zzaC(str);
            return null;
        }
    }

    private void zzh(long j, String str) {
        SQLiteDatabase zzer = zzer("Error opening database for putHit");
        if (zzer != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_time", Long.valueOf(j));
            contentValues.put("hit_url", str);
            contentValues.put("hit_first_send_time", (Integer) 0);
            try {
                zzer.insert("gtm_hits", null, contentValues);
                this.zzaMu.zzan(false);
            } catch (SQLiteException e) {
                zzbg.zzaC("Error storing hit");
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzq(long j) {
        zzf(new String[]{String.valueOf(j)});
    }

    private void zzzb() {
        int zzzc = (zzzc() - this.zzaMx) + 1;
        if (zzzc > 0) {
            List<String> zziY = zziY(zzzc);
            zzbg.zzaB("Store full, deleting " + zziY.size() + " hits to make room.");
            zzf((String[]) zziY.toArray(new String[0]));
        }
    }

    @Override // com.google.android.gms.tagmanager.zzau
    public void dispatch() {
        zzbg.zzaB("GTM Dispatch running...");
        if (this.zzaMt.zzyH()) {
            List<zzaq> zziZ = zziZ(40);
            if (zziZ.isEmpty()) {
                zzbg.zzaB("...nothing to dispatch");
                this.zzaMu.zzan(true);
                return;
            }
            this.zzaMt.zzr(zziZ);
            if (zzzd() > 0) {
                zzcu.zzzz().dispatch();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void zzf(String[] strArr) {
        SQLiteDatabase zzer;
        boolean z = true;
        if (strArr != null && strArr.length != 0 && (zzer = zzer("Error opening database for deleteHits.")) != null) {
            try {
                zzer.delete("gtm_hits", String.format("HIT_ID in (%s)", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))), strArr);
                zzav zzav = this.zzaMu;
                if (zzzc() != 0) {
                    z = false;
                }
                zzav.zzan(z);
            } catch (SQLiteException e) {
                zzbg.zzaC("Error deleting hits");
            }
        }
    }

    @Override // com.google.android.gms.tagmanager.zzau
    public void zzg(long j, String str) {
        zzis();
        zzzb();
        zzh(j, str);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> zziY(int r14) {
        /*
        // Method dump skipped, instructions count: 138
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzby.zziY(int):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ea, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f2, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x016b, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x016c, code lost:
        r12 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0171, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0172, code lost:
        r3 = r2;
        r4 = r13;
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        return r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0140 A[Catch:{ all -> 0x015f }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x016b A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.tagmanager.zzaq> zziZ(int r17) {
        /*
        // Method dump skipped, instructions count: 384
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzby.zziZ(int):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public int zzis() {
        boolean z = true;
        long currentTimeMillis = this.zzpw.currentTimeMillis();
        if (currentTimeMillis <= this.zzaMw + 86400000) {
            return 0;
        }
        this.zzaMw = currentTimeMillis;
        SQLiteDatabase zzer = zzer("Error opening database for deleteStaleHits.");
        if (zzer == null) {
            return 0;
        }
        int delete = zzer.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.zzpw.currentTimeMillis() - 2592000000L)});
        zzav zzav = this.zzaMu;
        if (zzzc() != 0) {
            z = false;
        }
        zzav.zzan(z);
        return delete;
    }

    /* access modifiers changed from: package-private */
    public int zzzc() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase zzer = zzer("Error opening database for getNumStoredHits.");
        if (zzer != null) {
            try {
                Cursor rawQuery = zzer.rawQuery("SELECT COUNT(*) from gtm_hits", null);
                if (rawQuery.moveToFirst()) {
                    i = (int) rawQuery.getLong(0);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e) {
                zzbg.zzaC("Error getting numStoredHits");
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
        return i;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int zzzd() {
        /*
            r10 = this;
            r8 = 0
            r9 = 0
            java.lang.String r0 = "Error opening database for getNumStoredHits."
            android.database.sqlite.SQLiteDatabase r0 = r10.zzer(r0)
            if (r0 != 0) goto L_0x000b
        L_0x000a:
            return r8
        L_0x000b:
            java.lang.String r1 = "gtm_hits"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x002f, all -> 0x003d }
            r3 = 0
            java.lang.String r4 = "hit_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x002f, all -> 0x003d }
            r3 = 1
            java.lang.String r4 = "hit_first_send_time"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x002f, all -> 0x003d }
            java.lang.String r3 = "hit_first_send_time=0"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x002f, all -> 0x003d }
            int r0 = r1.getCount()     // Catch:{ SQLiteException -> 0x004b, all -> 0x0044 }
            if (r1 == 0) goto L_0x002d
            r1.close()
        L_0x002d:
            r8 = r0
            goto L_0x000a
        L_0x002f:
            r0 = move-exception
            r0 = r9
        L_0x0031:
            java.lang.String r1 = "Error getting num untried hits"
            com.google.android.gms.tagmanager.zzbg.zzaC(r1)     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x004e
            r0.close()
            r0 = r8
            goto L_0x002d
        L_0x003d:
            r0 = move-exception
        L_0x003e:
            if (r9 == 0) goto L_0x0043
            r9.close()
        L_0x0043:
            throw r0
        L_0x0044:
            r0 = move-exception
            r9 = r1
            goto L_0x003e
        L_0x0047:
            r1 = move-exception
            r9 = r0
            r0 = r1
            goto L_0x003e
        L_0x004b:
            r0 = move-exception
            r0 = r1
            goto L_0x0031
        L_0x004e:
            r0 = r8
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzby.zzzd():int");
    }
}
