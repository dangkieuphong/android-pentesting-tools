package com.google.android.gms.tagmanager;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.tagmanager.zzm;
import com.google.android.gms.tagmanager.zzt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* access modifiers changed from: package-private */
public class zzcp {
    private static final zzbw<zzag.zza> zzaNe = new zzbw<>(zzdf.zzzQ(), true);
    private final DataLayer zzaKz;
    private final zzqf.zzc zzaNf;
    private final zzah zzaNg;
    private final Map<String, zzak> zzaNh;
    private final Map<String, zzak> zzaNi;
    private final Map<String, zzak> zzaNj;
    private final zzl<zzqf.zza, zzbw<zzag.zza>> zzaNk;
    private final zzl<String, zzb> zzaNl;
    private final Set<zzqf.zze> zzaNm;
    private final Map<String, zzc> zzaNn;
    private volatile String zzaNo;
    private int zzaNp;

    /* access modifiers changed from: package-private */
    public interface zza {
        void zza(zzqf.zze zze, Set<zzqf.zza> set, Set<zzqf.zza> set2, zzck zzck);
    }

    /* access modifiers changed from: private */
    public static class zzb {
        private zzbw<zzag.zza> zzaNv;
        private zzag.zza zzaNw;

        public zzb(zzbw<zzag.zza> zzbw, zzag.zza zza) {
            this.zzaNv = zzbw;
            this.zzaNw = zza;
        }

        public int getSize() {
            return (this.zzaNw == null ? 0 : this.zzaNw.zzBU()) + this.zzaNv.getObject().zzBU();
        }

        public zzbw<zzag.zza> zzzr() {
            return this.zzaNv;
        }

        public zzag.zza zzzs() {
            return this.zzaNw;
        }
    }

    /* access modifiers changed from: private */
    public static class zzc {
        private final Map<zzqf.zze, List<String>> zzaNA = new HashMap();
        private zzqf.zza zzaNB;
        private final Set<zzqf.zze> zzaNm = new HashSet();
        private final Map<zzqf.zze, List<zzqf.zza>> zzaNx = new HashMap();
        private final Map<zzqf.zze, List<zzqf.zza>> zzaNy = new HashMap();
        private final Map<zzqf.zze, List<String>> zzaNz = new HashMap();

        public void zza(zzqf.zze zze) {
            this.zzaNm.add(zze);
        }

        public void zza(zzqf.zze zze, zzqf.zza zza) {
            List<zzqf.zza> list = this.zzaNx.get(zze);
            if (list == null) {
                list = new ArrayList<>();
                this.zzaNx.put(zze, list);
            }
            list.add(zza);
        }

        public void zza(zzqf.zze zze, String str) {
            List<String> list = this.zzaNz.get(zze);
            if (list == null) {
                list = new ArrayList<>();
                this.zzaNz.put(zze, list);
            }
            list.add(str);
        }

        public void zzb(zzqf.zza zza) {
            this.zzaNB = zza;
        }

        public void zzb(zzqf.zze zze, zzqf.zza zza) {
            List<zzqf.zza> list = this.zzaNy.get(zze);
            if (list == null) {
                list = new ArrayList<>();
                this.zzaNy.put(zze, list);
            }
            list.add(zza);
        }

        public void zzb(zzqf.zze zze, String str) {
            List<String> list = this.zzaNA.get(zze);
            if (list == null) {
                list = new ArrayList<>();
                this.zzaNA.put(zze, list);
            }
            list.add(str);
        }

        public Set<zzqf.zze> zzzt() {
            return this.zzaNm;
        }

        public Map<zzqf.zze, List<zzqf.zza>> zzzu() {
            return this.zzaNx;
        }

        public Map<zzqf.zze, List<String>> zzzv() {
            return this.zzaNz;
        }

        public Map<zzqf.zze, List<String>> zzzw() {
            return this.zzaNA;
        }

        public Map<zzqf.zze, List<zzqf.zza>> zzzx() {
            return this.zzaNy;
        }

        public zzqf.zza zzzy() {
            return this.zzaNB;
        }
    }

    public zzcp(Context context, zzqf.zzc zzc2, DataLayer dataLayer, zzt.zza zza2, zzt.zza zza3, zzah zzah) {
        if (zzc2 == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.zzaNf = zzc2;
        this.zzaNm = new HashSet(zzc2.zzAq());
        this.zzaKz = dataLayer;
        this.zzaNg = zzah;
        this.zzaNk = new zzm().zza(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new zzm.zza<zzqf.zza, zzbw<zzag.zza>>() {
            /* class com.google.android.gms.tagmanager.zzcp.AnonymousClass1 */

            /* renamed from: zza */
            public int sizeOf(zzqf.zza zza, zzbw<zzag.zza> zzbw) {
                return zzbw.getObject().zzBU();
            }
        });
        this.zzaNl = new zzm().zza(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new zzm.zza<String, zzb>() {
            /* class com.google.android.gms.tagmanager.zzcp.AnonymousClass2 */

            /* renamed from: zza */
            public int sizeOf(String str, zzb zzb) {
                return str.length() + zzb.getSize();
            }
        });
        this.zzaNh = new HashMap();
        zzb(new zzj(context));
        zzb(new zzt(zza3));
        zzb(new zzx(dataLayer));
        zzb(new zzdg(context, dataLayer));
        zzb(new zzdb(context, dataLayer));
        this.zzaNi = new HashMap();
        zzc(new zzr());
        zzc(new zzae());
        zzc(new zzaf());
        zzc(new zzam());
        zzc(new zzan());
        zzc(new zzbc());
        zzc(new zzbd());
        zzc(new zzcf());
        zzc(new zzcy());
        this.zzaNj = new HashMap();
        zza(new zzb(context));
        zza(new zzc(context));
        zza(new zze(context));
        zza(new zzf(context));
        zza(new zzg(context));
        zza(new zzh(context));
        zza(new zzi(context));
        zza(new zzn());
        zza(new zzq(this.zzaNf.getVersion()));
        zza(new zzt(zza2));
        zza(new zzv(dataLayer));
        zza(new zzaa(context));
        zza(new zzab());
        zza(new zzad());
        zza(new zzai(this));
        zza(new zzao());
        zza(new zzap());
        zza(new zzaw(context));
        zza(new zzay());
        zza(new zzbb());
        zza(new zzbi());
        zza(new zzbk(context));
        zza(new zzbx());
        zza(new zzbz());
        zza(new zzcc());
        zza(new zzce());
        zza(new zzcg(context));
        zza(new zzcq());
        zza(new zzcr());
        zza(new zzda());
        zza(new zzdh());
        this.zzaNn = new HashMap();
        for (zzqf.zze zze : this.zzaNm) {
            if (zzah.zzyL()) {
                zza(zze.zzAy(), zze.zzAz(), "add macro");
                zza(zze.zzAD(), zze.zzAA(), "remove macro");
                zza(zze.zzAw(), zze.zzAB(), "add tag");
                zza(zze.zzAx(), zze.zzAC(), "remove tag");
            }
            for (int i = 0; i < zze.zzAy().size(); i++) {
                zzqf.zza zza4 = zze.zzAy().get(i);
                String str = "Unknown";
                if (zzah.zzyL() && i < zze.zzAz().size()) {
                    str = zze.zzAz().get(i);
                }
                zzc zzh = zzh(this.zzaNn, zza(zza4));
                zzh.zza(zze);
                zzh.zza(zze, zza4);
                zzh.zza(zze, str);
            }
            for (int i2 = 0; i2 < zze.zzAD().size(); i2++) {
                zzqf.zza zza5 = zze.zzAD().get(i2);
                String str2 = "Unknown";
                if (zzah.zzyL() && i2 < zze.zzAA().size()) {
                    str2 = zze.zzAA().get(i2);
                }
                zzc zzh2 = zzh(this.zzaNn, zza(zza5));
                zzh2.zza(zze);
                zzh2.zzb(zze, zza5);
                zzh2.zzb(zze, str2);
            }
        }
        for (Map.Entry<String, List<zzqf.zza>> entry : this.zzaNf.zzAr().entrySet()) {
            for (zzqf.zza zza6 : entry.getValue()) {
                if (!zzdf.zzk(zza6.zzAn().get(zzae.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    zzh(this.zzaNn, entry.getKey()).zzb(zza6);
                }
            }
        }
    }

    private zzbw<zzag.zza> zza(zzag.zza zza2, Set<String> set, zzdi zzdi) {
        if (!zza2.zzjb) {
            return new zzbw<>(zza2, true);
        }
        switch (zza2.type) {
            case 2:
                zzag.zza zzo = zzqf.zzo(zza2);
                zzo.zziS = new zzag.zza[zza2.zziS.length];
                for (int i = 0; i < zza2.zziS.length; i++) {
                    zzbw<zzag.zza> zza3 = zza(zza2.zziS[i], set, zzdi.zziU(i));
                    if (zza3 == zzaNe) {
                        return zzaNe;
                    }
                    zzo.zziS[i] = zza3.getObject();
                }
                return new zzbw<>(zzo, false);
            case 3:
                zzag.zza zzo2 = zzqf.zzo(zza2);
                if (zza2.zziT.length != zza2.zziU.length) {
                    zzbg.zzaz("Invalid serving value: " + zza2.toString());
                    return zzaNe;
                }
                zzo2.zziT = new zzag.zza[zza2.zziT.length];
                zzo2.zziU = new zzag.zza[zza2.zziT.length];
                for (int i2 = 0; i2 < zza2.zziT.length; i2++) {
                    zzbw<zzag.zza> zza4 = zza(zza2.zziT[i2], set, zzdi.zziV(i2));
                    zzbw<zzag.zza> zza5 = zza(zza2.zziU[i2], set, zzdi.zziW(i2));
                    if (zza4 == zzaNe || zza5 == zzaNe) {
                        return zzaNe;
                    }
                    zzo2.zziT[i2] = zza4.getObject();
                    zzo2.zziU[i2] = zza5.getObject();
                }
                return new zzbw<>(zzo2, false);
            case 4:
                if (set.contains(zza2.zziV)) {
                    zzbg.zzaz("Macro cycle detected.  Current macro reference: " + zza2.zziV + "." + "  Previous macro references: " + set.toString() + ".");
                    return zzaNe;
                }
                set.add(zza2.zziV);
                zzbw<zzag.zza> zza6 = zzdj.zza(zza(zza2.zziV, set, zzdi.zzyZ()), zza2.zzja);
                set.remove(zza2.zziV);
                return zza6;
            case 5:
            case 6:
            default:
                zzbg.zzaz("Unknown type: " + zza2.type);
                return zzaNe;
            case 7:
                zzag.zza zzo3 = zzqf.zzo(zza2);
                zzo3.zziZ = new zzag.zza[zza2.zziZ.length];
                for (int i3 = 0; i3 < zza2.zziZ.length; i3++) {
                    zzbw<zzag.zza> zza7 = zza(zza2.zziZ[i3], set, zzdi.zziX(i3));
                    if (zza7 == zzaNe) {
                        return zzaNe;
                    }
                    zzo3.zziZ[i3] = zza7.getObject();
                }
                return new zzbw<>(zzo3, false);
        }
    }

    private zzbw<zzag.zza> zza(String str, Set<String> set, zzbj zzbj) {
        zzqf.zza next;
        this.zzaNp++;
        zzb zzb2 = this.zzaNl.get(str);
        if (zzb2 == null || this.zzaNg.zzyL()) {
            zzc zzc2 = this.zzaNn.get(str);
            if (zzc2 == null) {
                zzbg.zzaz(zzzq() + "Invalid macro: " + str);
                this.zzaNp--;
                return zzaNe;
            }
            zzbw<Set<zzqf.zza>> zza2 = zza(str, zzc2.zzzt(), zzc2.zzzu(), zzc2.zzzv(), zzc2.zzzx(), zzc2.zzzw(), set, zzbj.zzyB());
            if (zza2.getObject().isEmpty()) {
                next = zzc2.zzzy();
            } else {
                if (zza2.getObject().size() > 1) {
                    zzbg.zzaC(zzzq() + "Multiple macros active for macroName " + str);
                }
                next = zza2.getObject().iterator().next();
            }
            if (next == null) {
                this.zzaNp--;
                return zzaNe;
            }
            zzbw<zzag.zza> zza3 = zza(this.zzaNj, next, set, zzbj.zzyR());
            zzbw<zzag.zza> zzbw = zza3 == zzaNe ? zzaNe : new zzbw<>(zza3.getObject(), zza2.zzza() && zza3.zzza());
            zzag.zza zzzs = next.zzzs();
            if (zzbw.zzza()) {
                this.zzaNl.zzf(str, new zzb(zzbw, zzzs));
            }
            zza(zzzs, set);
            this.zzaNp--;
            return zzbw;
        }
        zza(zzb2.zzzs(), set);
        this.zzaNp--;
        return zzb2.zzzr();
    }

    private zzbw<zzag.zza> zza(Map<String, zzak> map, zzqf.zza zza2, Set<String> set, zzch zzch) {
        boolean z;
        boolean z2 = true;
        zzag.zza zza3 = zza2.zzAn().get(zzae.FUNCTION.toString());
        if (zza3 == null) {
            zzbg.zzaz("No function id in properties");
            return zzaNe;
        }
        String str = zza3.zziW;
        zzak zzak = map.get(str);
        if (zzak == null) {
            zzbg.zzaz(str + " has no backing implementation.");
            return zzaNe;
        }
        zzbw<zzag.zza> zzbw = this.zzaNk.get(zza2);
        if (!(zzbw == null || this.zzaNg.zzyL())) {
            return zzbw;
        }
        HashMap hashMap = new HashMap();
        boolean z3 = true;
        for (Map.Entry<String, zzag.zza> entry : zza2.zzAn().entrySet()) {
            zzbw<zzag.zza> zza4 = zza(entry.getValue(), set, zzch.zzez(entry.getKey()).zze(entry.getValue()));
            if (zza4 == zzaNe) {
                return zzaNe;
            }
            if (zza4.zzza()) {
                zza2.zza(entry.getKey(), zza4.getObject());
                z = z3;
            } else {
                z = false;
            }
            hashMap.put(entry.getKey(), zza4.getObject());
            z3 = z;
        }
        if (!zzak.zzg(hashMap.keySet())) {
            zzbg.zzaz("Incorrect keys for function " + str + " required " + zzak.zzyN() + " had " + hashMap.keySet());
            return zzaNe;
        }
        if (!z3 || !zzak.zzyh()) {
            z2 = false;
        }
        zzbw<zzag.zza> zzbw2 = new zzbw<>(zzak.zzE(hashMap), z2);
        if (z2) {
            this.zzaNk.zzf(zza2, zzbw2);
        }
        zzch.zzd(zzbw2.getObject());
        return zzbw2;
    }

    private zzbw<Set<zzqf.zza>> zza(Set<zzqf.zze> set, Set<String> set2, zza zza2, zzco zzco) {
        Set<zzqf.zza> hashSet = new HashSet<>();
        Set<zzqf.zza> hashSet2 = new HashSet<>();
        boolean z = true;
        for (zzqf.zze zze : set) {
            zzck zzyY = zzco.zzyY();
            zzbw<Boolean> zza3 = zza(zze, set2, zzyY);
            if (zza3.getObject().booleanValue()) {
                zza2.zza(zze, hashSet, hashSet2, zzyY);
            }
            z = z && zza3.zzza();
        }
        hashSet.removeAll(hashSet2);
        zzco.zzh(hashSet);
        return new zzbw<>(hashSet, z);
    }

    private static String zza(zzqf.zza zza2) {
        return zzdf.zzg(zza2.zzAn().get(zzae.INSTANCE_NAME.toString()));
    }

    private void zza(zzag.zza zza2, Set<String> set) {
        zzbw<zzag.zza> zza3;
        if (zza2 != null && (zza3 = zza(zza2, set, new zzbu())) != zzaNe) {
            Object zzl = zzdf.zzl(zza3.getObject());
            if (zzl instanceof Map) {
                this.zzaKz.push((Map) zzl);
            } else if (zzl instanceof List) {
                for (Object obj : (List) zzl) {
                    if (obj instanceof Map) {
                        this.zzaKz.push((Map) obj);
                    } else {
                        zzbg.zzaC("pushAfterEvaluate: value not a Map");
                    }
                }
            } else {
                zzbg.zzaC("pushAfterEvaluate: value not a Map or List");
            }
        }
    }

    private static void zza(List<zzqf.zza> list, List<String> list2, String str) {
        if (list.size() != list2.size()) {
            zzbg.zzaA("Invalid resource: imbalance of rule names of functions for " + str + " operation. Using default rule name instead");
        }
    }

    private static void zza(Map<String, zzak> map, zzak zzak) {
        if (map.containsKey(zzak.zzyM())) {
            throw new IllegalArgumentException("Duplicate function type name: " + zzak.zzyM());
        }
        map.put(zzak.zzyM(), zzak);
    }

    private static zzc zzh(Map<String, zzc> map, String str) {
        zzc zzc2 = map.get(str);
        if (zzc2 != null) {
            return zzc2;
        }
        zzc zzc3 = new zzc();
        map.put(str, zzc3);
        return zzc3;
    }

    private String zzzq() {
        if (this.zzaNp <= 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(this.zzaNp));
        for (int i = 2; i < this.zzaNp; i++) {
            sb.append(' ');
        }
        sb.append(": ");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public zzbw<Boolean> zza(zzqf.zza zza2, Set<String> set, zzch zzch) {
        zzbw<zzag.zza> zza3 = zza(this.zzaNi, zza2, set, zzch);
        Boolean zzk = zzdf.zzk(zza3.getObject());
        zzch.zzd(zzdf.zzI(zzk));
        return new zzbw<>(zzk, zza3.zzza());
    }

    /* access modifiers changed from: package-private */
    public zzbw<Boolean> zza(zzqf.zze zze, Set<String> set, zzck zzck) {
        boolean z = true;
        for (zzqf.zza zza2 : zze.zzAv()) {
            zzbw<Boolean> zza3 = zza(zza2, set, zzck.zzyS());
            if (zza3.getObject().booleanValue()) {
                zzck.zzf(zzdf.zzI(false));
                return new zzbw<>(false, zza3.zzza());
            }
            z = z && zza3.zzza();
        }
        for (zzqf.zza zza4 : zze.zzAu()) {
            zzbw<Boolean> zza5 = zza(zza4, set, zzck.zzyT());
            if (!zza5.getObject().booleanValue()) {
                zzck.zzf(zzdf.zzI(false));
                return new zzbw<>(false, zza5.zzza());
            }
            z = z && zza5.zzza();
        }
        zzck.zzf(zzdf.zzI(true));
        return new zzbw<>(true, z);
    }

    /* access modifiers changed from: package-private */
    public zzbw<Set<zzqf.zza>> zza(String str, Set<zzqf.zze> set, final Map<zzqf.zze, List<zzqf.zza>> map, final Map<zzqf.zze, List<String>> map2, final Map<zzqf.zze, List<zzqf.zza>> map3, final Map<zzqf.zze, List<String>> map4, Set<String> set2, zzco zzco) {
        return zza(set, set2, new zza() {
            /* class com.google.android.gms.tagmanager.zzcp.AnonymousClass3 */

            @Override // com.google.android.gms.tagmanager.zzcp.zza
            public void zza(zzqf.zze zze, Set<zzqf.zza> set, Set<zzqf.zza> set2, zzck zzck) {
                List<zzqf.zza> list = (List) map.get(zze);
                List<String> list2 = (List) map2.get(zze);
                if (list != null) {
                    set.addAll(list);
                    zzck.zzyU().zzc(list, list2);
                }
                List<zzqf.zza> list3 = (List) map3.get(zze);
                List<String> list4 = (List) map4.get(zze);
                if (list3 != null) {
                    set2.addAll(list3);
                    zzck.zzyV().zzc(list3, list4);
                }
            }
        }, zzco);
    }

    /* access modifiers changed from: package-private */
    public zzbw<Set<zzqf.zza>> zza(Set<zzqf.zze> set, zzco zzco) {
        return zza(set, new HashSet(), new zza() {
            /* class com.google.android.gms.tagmanager.zzcp.AnonymousClass4 */

            @Override // com.google.android.gms.tagmanager.zzcp.zza
            public void zza(zzqf.zze zze, Set<zzqf.zza> set, Set<zzqf.zza> set2, zzck zzck) {
                set.addAll(zze.zzAw());
                set2.addAll(zze.zzAx());
                zzck.zzyW().zzc(zze.zzAw(), zze.zzAB());
                zzck.zzyX().zzc(zze.zzAx(), zze.zzAC());
            }
        }, zzco);
    }

    /* access modifiers changed from: package-private */
    public void zza(zzak zzak) {
        zza(this.zzaNj, zzak);
    }

    /* access modifiers changed from: package-private */
    public void zzb(zzak zzak) {
        zza(this.zzaNh, zzak);
    }

    /* access modifiers changed from: package-private */
    public void zzc(zzak zzak) {
        zza(this.zzaNi, zzak);
    }

    public zzbw<zzag.zza> zzeD(String str) {
        this.zzaNp = 0;
        zzag zzet = this.zzaNg.zzet(str);
        zzbw<zzag.zza> zza2 = zza(str, new HashSet(), zzet.zzyI());
        zzet.zzyK();
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public synchronized void zzeE(String str) {
        this.zzaNo = str;
    }

    public synchronized void zzeh(String str) {
        zzeE(str);
        zzag zzeu = this.zzaNg.zzeu(str);
        zzu zzyJ = zzeu.zzyJ();
        for (zzqf.zza zza2 : zza(this.zzaNm, zzyJ.zzyB()).getObject()) {
            zza(this.zzaNh, zza2, new HashSet(), zzyJ.zzyA());
        }
        zzeu.zzyK();
        zzeE(null);
    }

    public synchronized void zzs(List<zzaf.zzi> list) {
        for (zzaf.zzi zzi : list) {
            if (zzi.name == null || !zzi.name.startsWith("gaExperiment:")) {
                zzbg.zzaB("Ignored supplemental: " + zzi);
            } else {
                zzaj.zza(this.zzaKz, zzi);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized String zzzp() {
        return this.zzaNo;
    }
}
