package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zznr;
import java.util.ArrayList;
import java.util.List;

public abstract class zznr<T extends zznr> {
    private final zzns zzaEe;
    protected final zzno zzaEf;
    private final List<zznp> zzaEg = new ArrayList();

    protected zznr(zzns zzns, zzlb zzlb) {
        zzu.zzu(zzns);
        this.zzaEe = zzns;
        zzno zzno = new zzno(this, zzlb);
        zzno.zzvZ();
        this.zzaEf = zzno;
    }

    /* access modifiers changed from: protected */
    public void zza(zzno zzno) {
    }

    /* access modifiers changed from: protected */
    public void zzd(zzno zzno) {
        for (zznp zznp : this.zzaEg) {
            zznp.zza(this, zzno);
        }
    }

    public zzno zzhc() {
        zzno zzvP = this.zzaEf.zzvP();
        zzd(zzvP);
        return zzvP;
    }

    /* access modifiers changed from: protected */
    public zzns zzvX() {
        return this.zzaEe;
    }

    public zzno zzwa() {
        return this.zzaEf;
    }

    public List<zznu> zzwb() {
        return this.zzaEf.zzvR();
    }
}
