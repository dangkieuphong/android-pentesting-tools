package com.google.android.gms.analytics.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzu;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

/* access modifiers changed from: package-private */
public class zzj extends zzd implements Closeable {
    private static final String zzKg = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id");
    private static final String zzKh = String.format("SELECT MAX(%s) FROM %s WHERE 1;", "hit_time", "hits2");
    private final zza zzKi;
    private final zzaj zzKj = new zzaj(zzhP());
    private final zzaj zzKk = new zzaj(zzhP());

    /* access modifiers changed from: package-private */
    public class zza extends SQLiteOpenHelper {
        zza(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        private void zza(SQLiteDatabase sQLiteDatabase) {
            boolean z = true;
            Set<String> zzb = zzb(sQLiteDatabase, "hits2");
            String[] strArr = {"hit_id", "hit_string", "hit_time", "hit_url"};
            for (String str : strArr) {
                if (!zzb.remove(str)) {
                    throw new SQLiteException("Database hits2 is missing required column: " + str);
                }
            }
            if (zzb.remove("hit_app_id")) {
                z = false;
            }
            if (!zzb.isEmpty()) {
                throw new SQLiteException("Database hits2 has extra columns");
            } else if (z) {
                sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0039  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean zza(android.database.sqlite.SQLiteDatabase r11, java.lang.String r12) {
            /*
                r10 = this;
                r8 = 0
                r9 = 0
                java.lang.String r1 = "SQLITE_MASTER"
                r0 = 1
                java.lang.String[] r2 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0026, all -> 0x0036 }
                r0 = 0
                java.lang.String r3 = "name"
                r2[r0] = r3     // Catch:{ SQLiteException -> 0x0026, all -> 0x0036 }
                java.lang.String r3 = "name=?"
                r0 = 1
                java.lang.String[] r4 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0026, all -> 0x0036 }
                r0 = 0
                r4[r0] = r12     // Catch:{ SQLiteException -> 0x0026, all -> 0x0036 }
                r5 = 0
                r6 = 0
                r7 = 0
                r0 = r11
                android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0026, all -> 0x0036 }
                boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0040 }
                if (r1 == 0) goto L_0x0025
                r1.close()
            L_0x0025:
                return r0
            L_0x0026:
                r0 = move-exception
                r1 = r9
            L_0x0028:
                com.google.android.gms.analytics.internal.zzj r2 = com.google.android.gms.analytics.internal.zzj.this     // Catch:{ all -> 0x003d }
                java.lang.String r3 = "Error querying for table"
                r2.zzc(r3, r12, r0)     // Catch:{ all -> 0x003d }
                if (r1 == 0) goto L_0x0034
                r1.close()
            L_0x0034:
                r0 = r8
                goto L_0x0025
            L_0x0036:
                r0 = move-exception
            L_0x0037:
                if (r9 == 0) goto L_0x003c
                r9.close()
            L_0x003c:
                throw r0
            L_0x003d:
                r0 = move-exception
                r9 = r1
                goto L_0x0037
            L_0x0040:
                r0 = move-exception
                goto L_0x0028
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzj.zza.zza(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
        }

        private Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
            String[] columnNames;
            HashSet hashSet = new HashSet();
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
            try {
                for (String str2 : rawQuery.getColumnNames()) {
                    hashSet.add(str2);
                }
                return hashSet;
            } finally {
                rawQuery.close();
            }
        }

        private void zzb(SQLiteDatabase sQLiteDatabase) {
            Set<String> zzb = zzb(sQLiteDatabase, "properties");
            String[] strArr = {"app_uid", "cid", "tid", "params", "adid", "hits_count"};
            for (String str : strArr) {
                if (!zzb.remove(str)) {
                    throw new SQLiteException("Database properties is missing required column: " + str);
                }
            }
            if (!zzb.isEmpty()) {
                throw new SQLiteException("Database properties table has extra columns");
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!zzj.this.zzKk.zzv(3600000)) {
                throw new SQLiteException("Database open failed");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e) {
                zzj.this.zzKk.start();
                zzj.this.zzaX("Opening the database failed, dropping the table and recreating it");
                zzj.this.getContext().getDatabasePath(zzj.this.zziv()).delete();
                try {
                    SQLiteDatabase writableDatabase = super.getWritableDatabase();
                    zzj.this.zzKk.clear();
                    return writableDatabase;
                } catch (SQLiteException e2) {
                    zzj.this.zze("Failed to open freshly created database", e2);
                    throw e2;
                }
            }
        }

        public void onCreate(SQLiteDatabase database) {
            zzx.zzbe(database.getPath());
        }

        public void onOpen(SQLiteDatabase database) {
            if (Build.VERSION.SDK_INT < 15) {
                Cursor rawQuery = database.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (!zza(database, "hits2")) {
                database.execSQL(zzj.zzKg);
            } else {
                zza(database);
            }
            if (!zza(database, "properties")) {
                database.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
            } else {
                zzb(database);
            }
        }

        public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        }
    }

    zzj(zzf zzf) {
        super(zzf);
        this.zzKi = new zza(zzf.getContext(), zziv());
    }

    private static String zzA(Map<String, String> map) {
        zzu.zzu(map);
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        String encodedQuery = builder.build().getEncodedQuery();
        return encodedQuery == null ? "" : encodedQuery;
    }

    private long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                j = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } else if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzd("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzd("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private String zzd(zzab zzab) {
        return zzab.zzjY() ? zzhR().zzjk() : zzhR().zzjl();
    }

    private static String zze(zzab zzab) {
        zzu.zzu(zzab);
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry<String, String> entry : zzab.zzn().entrySet()) {
            String key = entry.getKey();
            if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key)) {
                builder.appendQueryParameter(key, entry.getValue());
            }
        }
        String encodedQuery = builder.build().getEncodedQuery();
        return encodedQuery == null ? "" : encodedQuery;
    }

    private void zziu() {
        int zzju = zzhR().zzju();
        long zzil = zzil();
        if (zzil > ((long) (zzju - 1))) {
            List<Long> zzo = zzo((zzil - ((long) zzju)) + 1);
            zzd("Store full, deleting hits to make room, count", Integer.valueOf(zzo.size()));
            zzd(zzo);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String zziv() {
        return !zzhR().zziW() ? zzhR().zzjw() : zzhR().zziX() ? zzhR().zzjw() : zzhR().zzjx();
    }

    public void beginTransaction() {
        zzia();
        getWritableDatabase().beginTransaction();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.zzKi.close();
        } catch (SQLiteException e) {
            zze("Sql error closing database", e);
        } catch (IllegalStateException e2) {
            zze("Error closing database", e2);
        }
    }

    public void endTransaction() {
        zzia();
        getWritableDatabase().endTransaction();
    }

    /* access modifiers changed from: package-private */
    public SQLiteDatabase getWritableDatabase() {
        try {
            return this.zzKi.getWritableDatabase();
        } catch (SQLiteException e) {
            zzd("Error opening database", e);
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isEmpty() {
        return zzil() == 0;
    }

    public void setTransactionSuccessful() {
        zzia();
        getWritableDatabase().setTransactionSuccessful();
    }

    public long zza(long j, String str, String str2) {
        zzu.zzcj(str);
        zzu.zzcj(str2);
        zzia();
        zzhO();
        return zza("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j), str, str2}, 0);
    }

    public void zza(long j, String str) {
        zzu.zzcj(str);
        zzia();
        zzhO();
        int delete = getWritableDatabase().delete("properties", "app_uid=? AND cid<>?", new String[]{String.valueOf(j), str});
        if (delete > 0) {
            zza("Deleted property records", Integer.valueOf(delete));
        }
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> zzaY(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                str = "?" + str;
            }
            List<NameValuePair> parse = URLEncodedUtils.parse(new URI(str), "UTF-8");
            HashMap hashMap = new HashMap(parse.size());
            for (NameValuePair nameValuePair : parse) {
                hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
            return hashMap;
        } catch (URISyntaxException e) {
            zze("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> zzaZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            List<NameValuePair> parse = URLEncodedUtils.parse(new URI("?" + str), "UTF-8");
            HashMap hashMap = new HashMap(parse.size());
            for (NameValuePair nameValuePair : parse) {
                hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
            return hashMap;
        } catch (URISyntaxException e) {
            zze("Error parsing property parameters", e);
            return new HashMap(0);
        }
    }

    public void zzb(zzh zzh) {
        zzu.zzu(zzh);
        zzia();
        zzhO();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        String zzA = zzA(zzh.zzn());
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_uid", Long.valueOf(zzh.zzii()));
        contentValues.put("cid", zzh.getClientId());
        contentValues.put("tid", zzh.zzij());
        contentValues.put("adid", Integer.valueOf(zzh.zzik() ? 1 : 0));
        contentValues.put("hits_count", Long.valueOf(zzh.zzil()));
        contentValues.put("params", zzA);
        try {
            if (writableDatabase.insertWithOnConflict("properties", null, contentValues, 5) == -1) {
                zzaX("Failed to insert/update a property (got -1)");
            }
        } catch (SQLiteException e) {
            zze("Error storing a property", e);
        }
    }

    public void zzc(zzab zzab) {
        zzu.zzu(zzab);
        zzhO();
        zzia();
        String zze = zze(zzab);
        if (zze.length() > 8192) {
            zzhQ().zza(zzab, "Hit length exceeds the maximum allowed size");
            return;
        }
        zziu();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", zze);
        contentValues.put("hit_time", Long.valueOf(zzab.zzjW()));
        contentValues.put("hit_app_id", Integer.valueOf(zzab.zzjU()));
        contentValues.put("hit_url", zzd(zzab));
        try {
            long insert = writableDatabase.insert("hits2", null, contentValues);
            if (insert == -1) {
                zzaX("Failed to insert a hit (got -1)");
            } else {
                zzb("Hit saved to database. db-id, hit", Long.valueOf(insert), zzab);
            }
        } catch (SQLiteException e) {
            zze("Error storing a hit", e);
        }
    }

    public void zzd(List<Long> list) {
        zzu.zzu(list);
        zzhO();
        zzia();
        if (!list.isEmpty()) {
            StringBuilder sb = new StringBuilder("hit_id");
            sb.append(" in (");
            for (int i = 0; i < list.size(); i++) {
                Long l = list.get(i);
                if (l == null || l.longValue() == 0) {
                    throw new SQLiteException("Invalid hit id");
                }
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(l);
            }
            sb.append(")");
            String sb2 = sb.toString();
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                zza("Deleting dispatched hits. count", Integer.valueOf(list.size()));
                int delete = writableDatabase.delete("hits2", sb2, null);
                if (delete != list.size()) {
                    zzb("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(delete), sb2);
                }
            } catch (SQLiteException e) {
                zze("Error deleting hits", e);
                throw e;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.analytics.internal.zzd
    public void zzhn() {
    }

    public long zzil() {
        zzhO();
        zzia();
        return zzb("SELECT COUNT(*) FROM hits2", (String[]) null);
    }

    public void zziq() {
        zzhO();
        zzia();
        getWritableDatabase().delete("hits2", null, null);
    }

    public void zzir() {
        zzhO();
        zzia();
        getWritableDatabase().delete("properties", null, null);
    }

    public int zzis() {
        zzhO();
        zzia();
        if (!this.zzKj.zzv(86400000)) {
            return 0;
        }
        this.zzKj.start();
        zzaT("Deleting stale hits (if any)");
        int delete = getWritableDatabase().delete("hits2", "hit_time < ?", new String[]{Long.toString(zzhP().currentTimeMillis() - 2592000000L)});
        zza("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }

    public long zzit() {
        zzhO();
        zzia();
        return zza(zzKh, (String[]) null, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.Long> zzo(long r14) {
        /*
        // Method dump skipped, instructions count: 119
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzj.zzo(long):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009e, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a2, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a5, code lost:
        r1 = r9;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a2 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x0019] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.analytics.internal.zzab> zzp(long r14) {
        /*
        // Method dump skipped, instructions count: 167
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzj.zzp(long):java.util.List");
    }

    public void zzq(long j) {
        zzhO();
        zzia();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        zza("Deleting hit, id", Long.valueOf(j));
        zzd(arrayList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b8, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ba, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00bb, code lost:
        r1 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b8 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x000c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.analytics.internal.zzh> zzr(long r14) {
        /*
        // Method dump skipped, instructions count: 189
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzj.zzr(long):java.util.List");
    }
}
