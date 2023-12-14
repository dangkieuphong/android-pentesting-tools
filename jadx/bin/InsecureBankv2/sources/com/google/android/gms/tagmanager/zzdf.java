package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class zzdf {
    private static Map<Object, Object> zzaOA = new HashMap();
    private static zzag.zza zzaOB = zzI(zzaOx);
    private static final Object zzaOt = null;
    private static Long zzaOu = new Long(0);
    private static Double zzaOv = new Double(0.0d);
    private static zzde zzaOw = zzde.zzT(0);
    private static String zzaOx = new String("");
    private static Boolean zzaOy = new Boolean(false);
    private static List<Object> zzaOz = new ArrayList(0);

    private static double getDouble(Object o) {
        if (o instanceof Number) {
            return ((Number) o).doubleValue();
        }
        zzbg.zzaz("getDouble received non-Number");
        return 0.0d;
    }

    public static String zzD(Object obj) {
        return obj == null ? zzaOx : obj.toString();
    }

    public static zzde zzE(Object obj) {
        return obj instanceof zzde ? (zzde) obj : zzK(obj) ? zzde.zzT(zzL(obj)) : zzJ(obj) ? zzde.zza(Double.valueOf(getDouble(obj))) : zzeK(zzD(obj));
    }

    public static Long zzF(Object obj) {
        return zzK(obj) ? Long.valueOf(zzL(obj)) : zzeL(zzD(obj));
    }

    public static Double zzG(Object obj) {
        return zzJ(obj) ? Double.valueOf(getDouble(obj)) : zzeM(zzD(obj));
    }

    public static Boolean zzH(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : zzeN(zzD(obj));
    }

    public static zzag.zza zzI(Object obj) {
        boolean z = false;
        zzag.zza zza = new zzag.zza();
        if (obj instanceof zzag.zza) {
            return (zzag.zza) obj;
        }
        if (obj instanceof String) {
            zza.type = 1;
            zza.zziR = (String) obj;
        } else if (obj instanceof List) {
            zza.type = 2;
            List<Object> list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            boolean z2 = false;
            for (Object obj2 : list) {
                zzag.zza zzI = zzI(obj2);
                if (zzI == zzaOB) {
                    return zzaOB;
                }
                boolean z3 = z2 || zzI.zzjb;
                arrayList.add(zzI);
                z2 = z3;
            }
            zza.zziS = (zzag.zza[]) arrayList.toArray(new zzag.zza[0]);
            z = z2;
        } else if (obj instanceof Map) {
            zza.type = 3;
            Set<Map.Entry> entrySet = ((Map) obj).entrySet();
            ArrayList arrayList2 = new ArrayList(entrySet.size());
            ArrayList arrayList3 = new ArrayList(entrySet.size());
            boolean z4 = false;
            for (Map.Entry entry : entrySet) {
                zzag.zza zzI2 = zzI(entry.getKey());
                zzag.zza zzI3 = zzI(entry.getValue());
                if (zzI2 == zzaOB || zzI3 == zzaOB) {
                    return zzaOB;
                }
                boolean z5 = z4 || zzI2.zzjb || zzI3.zzjb;
                arrayList2.add(zzI2);
                arrayList3.add(zzI3);
                z4 = z5;
            }
            zza.zziT = (zzag.zza[]) arrayList2.toArray(new zzag.zza[0]);
            zza.zziU = (zzag.zza[]) arrayList3.toArray(new zzag.zza[0]);
            z = z4;
        } else if (zzJ(obj)) {
            zza.type = 1;
            zza.zziR = obj.toString();
        } else if (zzK(obj)) {
            zza.type = 6;
            zza.zziX = zzL(obj);
        } else if (obj instanceof Boolean) {
            zza.type = 8;
            zza.zziY = ((Boolean) obj).booleanValue();
        } else {
            zzbg.zzaz("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
            return zzaOB;
        }
        zza.zzjb = z;
        return zza;
    }

    private static boolean zzJ(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof zzde) && ((zzde) obj).zzzF());
    }

    private static boolean zzK(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof zzde) && ((zzde) obj).zzzG());
    }

    private static long zzL(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        zzbg.zzaz("getInt64 received non-Number");
        return 0;
    }

    public static zzag.zza zzeJ(String str) {
        zzag.zza zza = new zzag.zza();
        zza.type = 5;
        zza.zziW = str;
        return zza;
    }

    private static zzde zzeK(String str) {
        try {
            return zzde.zzeI(str);
        } catch (NumberFormatException e) {
            zzbg.zzaz("Failed to convert '" + str + "' to a number.");
            return zzaOw;
        }
    }

    private static Long zzeL(String str) {
        zzde zzeK = zzeK(str);
        return zzeK == zzaOw ? zzaOu : Long.valueOf(zzeK.longValue());
    }

    private static Double zzeM(String str) {
        zzde zzeK = zzeK(str);
        return zzeK == zzaOw ? zzaOv : Double.valueOf(zzeK.doubleValue());
    }

    private static Boolean zzeN(String str) {
        return "true".equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : zzaOy;
    }

    public static String zzg(zzag.zza zza) {
        return zzD(zzl(zza));
    }

    public static zzde zzh(zzag.zza zza) {
        return zzE(zzl(zza));
    }

    public static Long zzi(zzag.zza zza) {
        return zzF(zzl(zza));
    }

    public static Double zzj(zzag.zza zza) {
        return zzG(zzl(zza));
    }

    public static Boolean zzk(zzag.zza zza) {
        return zzH(zzl(zza));
    }

    public static Object zzl(zzag.zza zza) {
        int i = 0;
        if (zza == null) {
            return zzaOt;
        }
        switch (zza.type) {
            case 1:
                return zza.zziR;
            case 2:
                ArrayList arrayList = new ArrayList(zza.zziS.length);
                zzag.zza[] zzaArr = zza.zziS;
                int length = zzaArr.length;
                while (i < length) {
                    Object zzl = zzl(zzaArr[i]);
                    if (zzl == zzaOt) {
                        return zzaOt;
                    }
                    arrayList.add(zzl);
                    i++;
                }
                return arrayList;
            case 3:
                if (zza.zziT.length != zza.zziU.length) {
                    zzbg.zzaz("Converting an invalid value to object: " + zza.toString());
                    return zzaOt;
                }
                HashMap hashMap = new HashMap(zza.zziU.length);
                while (i < zza.zziT.length) {
                    Object zzl2 = zzl(zza.zziT[i]);
                    Object zzl3 = zzl(zza.zziU[i]);
                    if (zzl2 == zzaOt || zzl3 == zzaOt) {
                        return zzaOt;
                    }
                    hashMap.put(zzl2, zzl3);
                    i++;
                }
                return hashMap;
            case 4:
                zzbg.zzaz("Trying to convert a macro reference to object");
                return zzaOt;
            case 5:
                zzbg.zzaz("Trying to convert a function id to object");
                return zzaOt;
            case 6:
                return Long.valueOf(zza.zziX);
            case 7:
                StringBuffer stringBuffer = new StringBuffer();
                zzag.zza[] zzaArr2 = zza.zziZ;
                int length2 = zzaArr2.length;
                while (i < length2) {
                    String zzg = zzg(zzaArr2[i]);
                    if (zzg == zzaOx) {
                        return zzaOt;
                    }
                    stringBuffer.append(zzg);
                    i++;
                }
                return stringBuffer.toString();
            case 8:
                return Boolean.valueOf(zza.zziY);
            default:
                zzbg.zzaz("Failed to convert a value of type: " + zza.type);
                return zzaOt;
        }
    }

    public static Object zzzK() {
        return zzaOt;
    }

    public static Long zzzL() {
        return zzaOu;
    }

    public static Double zzzM() {
        return zzaOv;
    }

    public static Boolean zzzN() {
        return zzaOy;
    }

    public static zzde zzzO() {
        return zzaOw;
    }

    public static String zzzP() {
        return zzaOx;
    }

    public static zzag.zza zzzQ() {
        return zzaOB;
    }
}
