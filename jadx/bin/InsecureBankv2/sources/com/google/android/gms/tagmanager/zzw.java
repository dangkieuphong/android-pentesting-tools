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
import com.google.android.gms.tagmanager.DataLayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* access modifiers changed from: package-private */
public class zzw implements DataLayer.zzc {
    private static final String zzaLp = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", "datalayer", "ID", "key", "value", "expires");
    private final Context mContext;
    private final Executor zzaLq;
    private zza zzaLr;
    private int zzaLs;
    private zzlb zzpw;

    /* access modifiers changed from: package-private */
    public class zza extends SQLiteOpenHelper {
        zza(Context context, String str) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzw.zza.zza(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
        }

        /* JADX INFO: finally extract failed */
        private void zzc(SQLiteDatabase sQLiteDatabase) {
            String[] columnNames;
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            HashSet hashSet = new HashSet();
            try {
                for (String str : rawQuery.getColumnNames()) {
                    hashSet.add(str);
                }
                rawQuery.close();
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
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
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                zzw.this.mContext.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
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
            if (!zza("datalayer", db)) {
                db.execSQL(zzw.zzaLp);
            } else {
                zzc(db);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    /* access modifiers changed from: private */
    public static class zzb {
        final byte[] zzaLy;
        final String zztw;

        zzb(String str, byte[] bArr) {
            this.zztw = str;
            this.zzaLy = bArr;
        }

        public String toString() {
            return "KeyAndSerialized: key = " + this.zztw + " serialized hash = " + Arrays.hashCode(this.zzaLy);
        }
    }

    public zzw(Context context) {
        this(context, zzld.zzoQ(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    zzw(Context context, zzlb zzlb, String str, int i, Executor executor) {
        this.mContext = context;
        this.zzpw = zzlb;
        this.zzaLs = i;
        this.zzaLq = executor;
        this.zzaLr = new zza(this.mContext, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001f A[SYNTHETIC, Splitter:B:13:0x001f] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002e A[SYNTHETIC, Splitter:B:20:0x002e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] zzA(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>()
            java.io.ObjectOutputStream r1 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x001b, all -> 0x0028 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x001b, all -> 0x0028 }
            r1.writeObject(r6)     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            byte[] r0 = r2.toByteArray()     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            if (r1 == 0) goto L_0x0017
            r1.close()     // Catch:{ IOException -> 0x003b }
        L_0x0017:
            r2.close()     // Catch:{ IOException -> 0x003b }
        L_0x001a:
            return r0
        L_0x001b:
            r1 = move-exception
            r1 = r0
        L_0x001d:
            if (r1 == 0) goto L_0x0022
            r1.close()     // Catch:{ IOException -> 0x0026 }
        L_0x0022:
            r2.close()     // Catch:{ IOException -> 0x0026 }
            goto L_0x001a
        L_0x0026:
            r1 = move-exception
            goto L_0x001a
        L_0x0028:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x002c:
            if (r1 == 0) goto L_0x0031
            r1.close()     // Catch:{ IOException -> 0x0035 }
        L_0x0031:
            r2.close()     // Catch:{ IOException -> 0x0035 }
        L_0x0034:
            throw r0
        L_0x0035:
            r1 = move-exception
            goto L_0x0034
        L_0x0037:
            r0 = move-exception
            goto L_0x002c
        L_0x0039:
            r3 = move-exception
            goto L_0x001d
        L_0x003b:
            r1 = move-exception
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzw.zzA(java.lang.Object):byte[]");
    }

    private void zzS(long j) {
        SQLiteDatabase zzer = zzer("Error opening database for deleteOlderThan.");
        if (zzer != null) {
            try {
                zzbg.zzaB("Deleted " + zzer.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
            } catch (SQLiteException e) {
                zzbg.zzaC("Error deleting old entries.");
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void zzb(List<zzb> list, long j) {
        try {
            long currentTimeMillis = this.zzpw.currentTimeMillis();
            zzS(currentTimeMillis);
            zziS(list.size());
            zzc(list, currentTimeMillis + j);
        } finally {
            zzyF();
        }
    }

    private void zzc(List<zzb> list, long j) {
        SQLiteDatabase zzer = zzer("Error opening database for writeEntryToDatabase.");
        if (zzer != null) {
            for (zzb zzb2 : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", zzb2.zztw);
                contentValues.put("value", zzb2.zzaLy);
                zzer.insert("datalayer", null, contentValues);
            }
        }
    }

    private void zze(String[] strArr) {
        SQLiteDatabase zzer;
        if (strArr != null && strArr.length != 0 && (zzer = zzer("Error opening database for deleteEntries.")) != null) {
            try {
                zzer.delete("datalayer", String.format("%s in (%s)", "ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))), strArr);
            } catch (SQLiteException e) {
                zzbg.zzaC("Error deleting entries " + Arrays.toString(strArr));
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzeq(String str) {
        SQLiteDatabase zzer = zzer("Error opening database for clearKeysWithPrefix.");
        if (zzer != null) {
            try {
                zzbg.zzaB("Cleared " + zzer.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
            } catch (SQLiteException e) {
                zzbg.zzaC("Error deleting entries with key prefix: " + str + " (" + e + ").");
            } finally {
                zzyF();
            }
        }
    }

    private SQLiteDatabase zzer(String str) {
        try {
            return this.zzaLr.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbg.zzaC(str);
            return null;
        }
    }

    private void zziS(int i) {
        int zzyE = (zzyE() - this.zzaLs) + i;
        if (zzyE > 0) {
            List<String> zziT = zziT(zzyE);
            zzbg.zzaA("DataLayer store full, deleting " + zziT.size() + " entries to make room.");
            zze((String[]) zziT.toArray(new String[0]));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.lang.String> zziT(int r14) {
        /*
        // Method dump skipped, instructions count: 138
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzw.zziT(int):java.util.List");
    }

    private List<DataLayer.zza> zzp(List<zzb> list) {
        ArrayList arrayList = new ArrayList();
        for (zzb zzb2 : list) {
            arrayList.add(new DataLayer.zza(zzb2.zztw, zzq(zzb2.zzaLy)));
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001c A[SYNTHETIC, Splitter:B:13:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0029 A[SYNTHETIC, Splitter:B:20:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0038 A[SYNTHETIC, Splitter:B:27:0x0038] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object zzq(byte[] r6) {
        /*
            r5 = this;
            r0 = 0
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            r2.<init>(r6)
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x0018, ClassNotFoundException -> 0x0025, all -> 0x0032 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0018, ClassNotFoundException -> 0x0025, all -> 0x0032 }
            java.lang.Object r0 = r1.readObject()     // Catch:{ IOException -> 0x0045, ClassNotFoundException -> 0x0043, all -> 0x0041 }
            if (r1 == 0) goto L_0x0014
            r1.close()     // Catch:{ IOException -> 0x0047 }
        L_0x0014:
            r2.close()     // Catch:{ IOException -> 0x0047 }
        L_0x0017:
            return r0
        L_0x0018:
            r1 = move-exception
            r1 = r0
        L_0x001a:
            if (r1 == 0) goto L_0x001f
            r1.close()     // Catch:{ IOException -> 0x0023 }
        L_0x001f:
            r2.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0017
        L_0x0023:
            r1 = move-exception
            goto L_0x0017
        L_0x0025:
            r1 = move-exception
            r1 = r0
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            r1.close()     // Catch:{ IOException -> 0x0030 }
        L_0x002c:
            r2.close()     // Catch:{ IOException -> 0x0030 }
            goto L_0x0017
        L_0x0030:
            r1 = move-exception
            goto L_0x0017
        L_0x0032:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0036:
            if (r1 == 0) goto L_0x003b
            r1.close()     // Catch:{ IOException -> 0x003f }
        L_0x003b:
            r2.close()     // Catch:{ IOException -> 0x003f }
        L_0x003e:
            throw r0
        L_0x003f:
            r1 = move-exception
            goto L_0x003e
        L_0x0041:
            r0 = move-exception
            goto L_0x0036
        L_0x0043:
            r3 = move-exception
            goto L_0x0027
        L_0x0045:
            r3 = move-exception
            goto L_0x001a
        L_0x0047:
            r1 = move-exception
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzw.zzq(byte[]):java.lang.Object");
    }

    private List<zzb> zzq(List<DataLayer.zza> list) {
        ArrayList arrayList = new ArrayList();
        for (DataLayer.zza zza2 : list) {
            arrayList.add(new zzb(zza2.zztw, zzA(zza2.zzGK)));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private List<DataLayer.zza> zzyC() {
        try {
            zzS(this.zzpw.currentTimeMillis());
            return zzp(zzyD());
        } finally {
            zzyF();
        }
    }

    private List<zzb> zzyD() {
        SQLiteDatabase zzer = zzer("Error opening database for loadSerialized.");
        ArrayList arrayList = new ArrayList();
        if (zzer == null) {
            return arrayList;
        }
        Cursor query = zzer.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new zzb(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private int zzyE() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase zzer = zzer("Error opening database for getNumStoredEntries.");
        if (zzer != null) {
            try {
                Cursor rawQuery = zzer.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (rawQuery.moveToFirst()) {
                    i = (int) rawQuery.getLong(0);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e) {
                zzbg.zzaC("Error getting numStoredEntries");
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

    private void zzyF() {
        try {
            this.zzaLr.close();
        } catch (SQLiteException e) {
        }
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzc
    public void zza(final DataLayer.zzc.zza zza2) {
        this.zzaLq.execute(new Runnable() {
            /* class com.google.android.gms.tagmanager.zzw.AnonymousClass2 */

            public void run() {
                zza2.zzo(zzw.this.zzyC());
            }
        });
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzc
    public void zza(List<DataLayer.zza> list, final long j) {
        final List<zzb> zzq = zzq(list);
        this.zzaLq.execute(new Runnable() {
            /* class com.google.android.gms.tagmanager.zzw.AnonymousClass1 */

            public void run() {
                zzw.this.zzb(zzq, j);
            }
        });
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzc
    public void zzep(final String str) {
        this.zzaLq.execute(new Runnable() {
            /* class com.google.android.gms.tagmanager.zzw.AnonymousClass3 */

            public void run() {
                zzw.this.zzeq(str);
            }
        });
    }
}
