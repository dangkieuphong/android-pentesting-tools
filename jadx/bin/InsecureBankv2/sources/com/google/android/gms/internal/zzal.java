package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.internal.zzar;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public abstract class zzal extends zzak {
    private static long startTime = 0;
    private static Method zzmV;
    private static Method zzmW;
    private static Method zzmX;
    private static Method zzmY;
    private static Method zzmZ;
    private static Method zzna;
    private static Method zznb;
    private static Method zznc;
    private static Method zznd;
    private static Method zzne;
    private static Method zznf;
    private static Method zzng;
    private static Method zznh;
    private static String zzni;
    private static String zznj;
    private static String zznk;
    private static zzar zznl;
    static boolean zznm = false;

    /* access modifiers changed from: package-private */
    public static class zza extends Exception {
        public zza() {
        }

        public zza(Throwable th) {
            super(th);
        }
    }

    protected zzal(Context context, zzap zzap, zzaq zzaq) {
        super(context, zzap, zzaq);
    }

    static String zzU() throws zza {
        if (zzni != null) {
            return zzni;
        }
        throw new zza();
    }

    static Long zzV() throws zza {
        if (zzmV == null) {
            throw new zza();
        }
        try {
            return (Long) zzmV.invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static String zzW() throws zza {
        if (zzmX == null) {
            throw new zza();
        }
        try {
            return (String) zzmX.invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static Long zzX() throws zza {
        if (zzmW == null) {
            throw new zza();
        }
        try {
            return (Long) zzmW.invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static String zza(Context context, zzap zzap) throws zza {
        if (zznj != null) {
            return zznj;
        }
        if (zzmY == null) {
            throw new zza();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) zzmY.invoke(null, context);
            if (byteBuffer == null) {
                throw new zza();
            }
            zznj = zzap.zza(byteBuffer.array(), true);
            return zznj;
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static ArrayList<Long> zza(MotionEvent motionEvent, DisplayMetrics displayMetrics) throws zza {
        if (zzmZ == null || motionEvent == null) {
            throw new zza();
        }
        try {
            return (ArrayList) zzmZ.invoke(null, motionEvent, displayMetrics);
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    protected static synchronized void zza(String str, Context context, zzap zzap) {
        synchronized (zzal.class) {
            if (!zznm) {
                try {
                    zznl = new zzar(zzap, null);
                    zzni = str;
                    zzl(context);
                    startTime = zzV().longValue();
                    zznm = true;
                } catch (zza | UnsupportedOperationException e) {
                }
            }
        }
    }

    static String zzb(Context context, zzap zzap) throws zza {
        if (zznk != null) {
            return zznk;
        }
        if (zznb == null) {
            throw new zza();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) zznb.invoke(null, context);
            if (byteBuffer == null) {
                throw new zza();
            }
            zznk = zzap.zza(byteBuffer.array(), true);
            return zznk;
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    private static String zzb(byte[] bArr, String str) throws zza {
        try {
            return new String(zznl.zzc(bArr, str), "UTF-8");
        } catch (zzar.zza e) {
            throw new zza(e);
        } catch (UnsupportedEncodingException e2) {
            throw new zza(e2);
        }
    }

    static String zze(Context context) throws zza {
        if (zzna == null) {
            throw new zza();
        }
        try {
            String str = (String) zzna.invoke(null, context);
            if (str != null) {
                return str;
            }
            throw new zza();
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static String zzf(Context context) throws zza {
        if (zzne == null) {
            throw new zza();
        }
        try {
            return (String) zzne.invoke(null, context);
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static Long zzg(Context context) throws zza {
        if (zznf == null) {
            throw new zza();
        }
        try {
            return (Long) zznf.invoke(null, context);
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static ArrayList<Long> zzh(Context context) throws zza {
        if (zznc == null) {
            throw new zza();
        }
        try {
            ArrayList<Long> arrayList = (ArrayList) zznc.invoke(null, context);
            if (arrayList != null && arrayList.size() == 2) {
                return arrayList;
            }
            throw new zza();
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static int[] zzi(Context context) throws zza {
        if (zznd == null) {
            throw new zza();
        }
        try {
            return (int[]) zznd.invoke(null, context);
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static int zzj(Context context) throws zza {
        if (zzng == null) {
            throw new zza();
        }
        try {
            return ((Integer) zzng.invoke(null, context)).intValue();
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static int zzk(Context context) throws zza {
        if (zznh == null) {
            throw new zza();
        }
        try {
            return ((Integer) zznh.invoke(null, context)).intValue();
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    private static void zzl(Context context) throws zza {
        try {
            byte[] zzl = zznl.zzl(zzat.getKey());
            byte[] zzc = zznl.zzc(zzl, zzat.zzad());
            File cacheDir = context.getCacheDir();
            if (cacheDir == null && (cacheDir = context.getDir("dex", 0)) == null) {
                throw new zza();
            }
            File createTempFile = File.createTempFile("ads", ".jar", cacheDir);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(zzc, 0, zzc.length);
            fileOutputStream.close();
            try {
                DexClassLoader dexClassLoader = new DexClassLoader(createTempFile.getAbsolutePath(), cacheDir.getAbsolutePath(), null, context.getClassLoader());
                Class loadClass = dexClassLoader.loadClass(zzb(zzl, zzat.zzam()));
                Class loadClass2 = dexClassLoader.loadClass(zzb(zzl, zzat.zzaA()));
                Class loadClass3 = dexClassLoader.loadClass(zzb(zzl, zzat.zzau()));
                Class loadClass4 = dexClassLoader.loadClass(zzb(zzl, zzat.zzaq()));
                Class loadClass5 = dexClassLoader.loadClass(zzb(zzl, zzat.zzaC()));
                Class loadClass6 = dexClassLoader.loadClass(zzb(zzl, zzat.zzao()));
                Class loadClass7 = dexClassLoader.loadClass(zzb(zzl, zzat.zzay()));
                Class loadClass8 = dexClassLoader.loadClass(zzb(zzl, zzat.zzaw()));
                Class loadClass9 = dexClassLoader.loadClass(zzb(zzl, zzat.zzak()));
                Class loadClass10 = dexClassLoader.loadClass(zzb(zzl, zzat.zzai()));
                Class loadClass11 = dexClassLoader.loadClass(zzb(zzl, zzat.zzag()));
                Class loadClass12 = dexClassLoader.loadClass(zzb(zzl, zzat.zzas()));
                Class loadClass13 = dexClassLoader.loadClass(zzb(zzl, zzat.zzae()));
                zzmV = loadClass.getMethod(zzb(zzl, zzat.zzan()), new Class[0]);
                zzmW = loadClass2.getMethod(zzb(zzl, zzat.zzaB()), new Class[0]);
                zzmX = loadClass3.getMethod(zzb(zzl, zzat.zzav()), new Class[0]);
                zzmY = loadClass4.getMethod(zzb(zzl, zzat.zzar()), Context.class);
                zzmZ = loadClass5.getMethod(zzb(zzl, zzat.zzaD()), MotionEvent.class, DisplayMetrics.class);
                zzna = loadClass6.getMethod(zzb(zzl, zzat.zzap()), Context.class);
                zznb = loadClass7.getMethod(zzb(zzl, zzat.zzaz()), Context.class);
                zznc = loadClass8.getMethod(zzb(zzl, zzat.zzax()), Context.class);
                zznd = loadClass9.getMethod(zzb(zzl, zzat.zzal()), Context.class);
                zzne = loadClass10.getMethod(zzb(zzl, zzat.zzaj()), Context.class);
                zznf = loadClass11.getMethod(zzb(zzl, zzat.zzah()), Context.class);
                zzng = loadClass12.getMethod(zzb(zzl, zzat.zzat()), Context.class);
                zznh = loadClass13.getMethod(zzb(zzl, zzat.zzaf()), Context.class);
            } finally {
                String name = createTempFile.getName();
                createTempFile.delete();
                new File(cacheDir, name.replace(".jar", ".dex")).delete();
            }
        } catch (FileNotFoundException e) {
            throw new zza(e);
        } catch (IOException e2) {
            throw new zza(e2);
        } catch (ClassNotFoundException e3) {
            throw new zza(e3);
        } catch (zzar.zza e4) {
            throw new zza(e4);
        } catch (NoSuchMethodException e5) {
            throw new zza(e5);
        } catch (NullPointerException e6) {
            throw new zza(e6);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b9 A[ExcHandler: zza | IOException (e java.lang.Throwable), Splitter:B:6:0x0010] */
    @Override // com.google.android.gms.internal.zzak
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzc(android.content.Context r7) {
        /*
        // Method dump skipped, instructions count: 214
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzal.zzc(android.content.Context):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073 A[ExcHandler: zza | IOException (e java.lang.Throwable), Splitter:B:1:0x0001] */
    @Override // com.google.android.gms.internal.zzak
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzd(android.content.Context r7) {
        /*
        // Method dump skipped, instructions count: 129
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzal.zzd(android.content.Context):void");
    }
}
