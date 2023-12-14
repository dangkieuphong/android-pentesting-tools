package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzno {
    private final zznr zzaDU;
    private boolean zzaDV;
    private long zzaDW;
    private long zzaDX;
    private long zzaDY;
    private long zzaDZ;
    private long zzaEa;
    private boolean zzaEb;
    private final Map<Class<? extends zznq>, zznq> zzaEc;
    private final List<zznu> zzaEd;
    private final zzlb zzpw;

    zzno(zzno zzno) {
        this.zzaDU = zzno.zzaDU;
        this.zzpw = zzno.zzpw;
        this.zzaDW = zzno.zzaDW;
        this.zzaDX = zzno.zzaDX;
        this.zzaDY = zzno.zzaDY;
        this.zzaDZ = zzno.zzaDZ;
        this.zzaEa = zzno.zzaEa;
        this.zzaEd = new ArrayList(zzno.zzaEd);
        this.zzaEc = new HashMap(zzno.zzaEc.size());
        for (Map.Entry<Class<? extends zznq>, zznq> entry : zzno.zzaEc.entrySet()) {
            zznq zzf = zzf(entry.getKey());
            entry.getValue().zza(zzf);
            this.zzaEc.put(entry.getKey(), zzf);
        }
    }

    zzno(zznr zznr, zzlb zzlb) {
        zzu.zzu(zznr);
        zzu.zzu(zzlb);
        this.zzaDU = zznr;
        this.zzpw = zzlb;
        this.zzaDZ = 1800000;
        this.zzaEa = 3024000000L;
        this.zzaEc = new HashMap();
        this.zzaEd = new ArrayList();
    }

    private static <T extends zznq> T zzf(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("dataType doesn't have default constructor", e);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException("dataType default constructor is not accessible", e2);
        }
    }

    public void zzL(long j) {
        this.zzaDX = j;
    }

    public void zzb(zznq zznq) {
        zzu.zzu(zznq);
        Class<?> cls = zznq.getClass();
        if (cls.getSuperclass() != zznq.class) {
            throw new IllegalArgumentException();
        }
        zznq.zza(zze(cls));
    }

    public <T extends zznq> T zzd(Class<T> cls) {
        return (T) this.zzaEc.get(cls);
    }

    public <T extends zznq> T zze(Class<T> cls) {
        T t = (T) this.zzaEc.get(cls);
        if (t != null) {
            return t;
        }
        T t2 = (T) zzf(cls);
        this.zzaEc.put(cls, t2);
        return t2;
    }

    public zzno zzvP() {
        return new zzno(this);
    }

    public Collection<zznq> zzvQ() {
        return this.zzaEc.values();
    }

    public List<zznu> zzvR() {
        return this.zzaEd;
    }

    public long zzvS() {
        return this.zzaDW;
    }

    public void zzvT() {
        zzvX().zze(this);
    }

    public boolean zzvU() {
        return this.zzaDV;
    }

    /* access modifiers changed from: package-private */
    public void zzvV() {
        this.zzaDY = this.zzpw.elapsedRealtime();
        if (this.zzaDX != 0) {
            this.zzaDW = this.zzaDX;
        } else {
            this.zzaDW = this.zzpw.currentTimeMillis();
        }
        this.zzaDV = true;
    }

    /* access modifiers changed from: package-private */
    public zznr zzvW() {
        return this.zzaDU;
    }

    /* access modifiers changed from: package-private */
    public zzns zzvX() {
        return this.zzaDU.zzvX();
    }

    /* access modifiers changed from: package-private */
    public boolean zzvY() {
        return this.zzaEb;
    }

    /* access modifiers changed from: package-private */
    public void zzvZ() {
        this.zzaEb = true;
    }
}
