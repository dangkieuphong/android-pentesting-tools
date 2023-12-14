package com.google.android.gms.internal;

import com.google.android.gms.internal.zzrc;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class zzrb {

    public static class zza {
        public final zzrc zzaVj;
        public final List<Asset> zzaVk;

        public zza(zzrc zzrc, List<Asset> list) {
            this.zzaVj = zzrc;
            this.zzaVk = list;
        }
    }

    private static int zza(String str, zzrc.zza.C0149zza[] zzaArr) {
        int i = 14;
        for (zzrc.zza.C0149zza zza2 : zzaArr) {
            if (i == 14) {
                if (zza2.type == 9 || zza2.type == 2 || zza2.type == 6) {
                    i = zza2.type;
                } else if (zza2.type != 14) {
                    throw new IllegalArgumentException("Unexpected TypedValue type: " + zza2.type + " for key " + str);
                }
            } else if (zza2.type != i) {
                throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + zza2.type);
            }
        }
        return i;
    }

    static int zza(List<Asset> list, Asset asset) {
        list.add(asset);
        return list.size() - 1;
    }

    public static zza zza(DataMap dataMap) {
        zzrc zzrc = new zzrc();
        ArrayList arrayList = new ArrayList();
        zzrc.zzaVl = zza(dataMap, arrayList);
        return new zza(zzrc, arrayList);
    }

    private static zzrc.zza.C0149zza zza(List<Asset> list, Object obj) {
        int i;
        int i2 = 0;
        zzrc.zza.C0149zza zza2 = new zzrc.zza.C0149zza();
        if (obj == null) {
            zza2.type = 14;
            return zza2;
        }
        zza2.zzaVp = new zzrc.zza.C0149zza.C0150zza();
        if (obj instanceof String) {
            zza2.type = 2;
            zza2.zzaVp.zzaVr = (String) obj;
        } else if (obj instanceof Integer) {
            zza2.type = 6;
            zza2.zzaVp.zzaVv = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            zza2.type = 5;
            zza2.zzaVp.zzaVu = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            zza2.type = 3;
            zza2.zzaVp.zzaVs = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            zza2.type = 4;
            zza2.zzaVp.zzaVt = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            zza2.type = 8;
            zza2.zzaVp.zzaVx = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            zza2.type = 7;
            zza2.zzaVp.zzaVw = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            zza2.type = 1;
            zza2.zzaVp.zzaVq = (byte[]) obj;
        } else if (obj instanceof String[]) {
            zza2.type = 11;
            zza2.zzaVp.zzaVA = (String[]) obj;
        } else if (obj instanceof long[]) {
            zza2.type = 12;
            zza2.zzaVp.zzaVB = (long[]) obj;
        } else if (obj instanceof float[]) {
            zza2.type = 15;
            zza2.zzaVp.zzaVC = (float[]) obj;
        } else if (obj instanceof Asset) {
            zza2.type = 13;
            zza2.zzaVp.zzaVD = (long) zza(list, (Asset) obj);
        } else if (obj instanceof DataMap) {
            zza2.type = 9;
            DataMap dataMap = (DataMap) obj;
            Set<String> keySet = dataMap.keySet();
            zzrc.zza[] zzaArr = new zzrc.zza[keySet.size()];
            for (String str : keySet) {
                zzaArr[i2] = new zzrc.zza();
                zzaArr[i2].name = str;
                zzaArr[i2].zzaVn = zza(list, dataMap.get(str));
                i2++;
            }
            zza2.zzaVp.zzaVy = zzaArr;
        } else if (obj instanceof ArrayList) {
            zza2.type = 10;
            ArrayList arrayList = (ArrayList) obj;
            zzrc.zza.C0149zza[] zzaArr2 = new zzrc.zza.C0149zza[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i3 = 0;
            int i4 = 14;
            while (i3 < size) {
                Object obj3 = arrayList.get(i3);
                zzrc.zza.C0149zza zza3 = zza(list, obj3);
                if (zza3.type == 14 || zza3.type == 2 || zza3.type == 6 || zza3.type == 9) {
                    if (i4 == 14 && zza3.type != 14) {
                        i = zza3.type;
                    } else if (zza3.type != i4) {
                        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                    } else {
                        obj3 = obj2;
                        i = i4;
                    }
                    zzaArr2[i3] = zza3;
                    i3++;
                    i4 = i;
                    obj2 = obj3;
                } else {
                    throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                }
            }
            zza2.zzaVp.zzaVz = zzaArr2;
        } else {
            throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
        }
        return zza2;
    }

    public static DataMap zza(zza zza2) {
        DataMap dataMap = new DataMap();
        zzrc.zza[] zzaArr = zza2.zzaVj.zzaVl;
        for (zzrc.zza zza3 : zzaArr) {
            zza(zza2.zzaVk, dataMap, zza3.name, zza3.zzaVn);
        }
        return dataMap;
    }

    private static ArrayList zza(List<Asset> list, zzrc.zza.C0149zza.C0150zza zza2, int i) {
        ArrayList arrayList = new ArrayList(zza2.zzaVz.length);
        zzrc.zza.C0149zza[] zzaArr = zza2.zzaVz;
        for (zzrc.zza.C0149zza zza3 : zzaArr) {
            if (zza3.type == 14) {
                arrayList.add(null);
            } else if (i == 9) {
                DataMap dataMap = new DataMap();
                zzrc.zza[] zzaArr2 = zza3.zzaVp.zzaVy;
                for (zzrc.zza zza4 : zzaArr2) {
                    zza(list, dataMap, zza4.name, zza4.zzaVn);
                }
                arrayList.add(dataMap);
            } else if (i == 2) {
                arrayList.add(zza3.zzaVp.zzaVr);
            } else if (i == 6) {
                arrayList.add(Integer.valueOf(zza3.zzaVp.zzaVv));
            } else {
                throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
            }
        }
        return arrayList;
    }

    private static void zza(List<Asset> list, DataMap dataMap, String str, zzrc.zza.C0149zza zza2) {
        int i = zza2.type;
        if (i == 14) {
            dataMap.putString(str, null);
            return;
        }
        zzrc.zza.C0149zza.C0150zza zza3 = zza2.zzaVp;
        if (i == 1) {
            dataMap.putByteArray(str, zza3.zzaVq);
        } else if (i == 11) {
            dataMap.putStringArray(str, zza3.zzaVA);
        } else if (i == 12) {
            dataMap.putLongArray(str, zza3.zzaVB);
        } else if (i == 15) {
            dataMap.putFloatArray(str, zza3.zzaVC);
        } else if (i == 2) {
            dataMap.putString(str, zza3.zzaVr);
        } else if (i == 3) {
            dataMap.putDouble(str, zza3.zzaVs);
        } else if (i == 4) {
            dataMap.putFloat(str, zza3.zzaVt);
        } else if (i == 5) {
            dataMap.putLong(str, zza3.zzaVu);
        } else if (i == 6) {
            dataMap.putInt(str, zza3.zzaVv);
        } else if (i == 7) {
            dataMap.putByte(str, (byte) zza3.zzaVw);
        } else if (i == 8) {
            dataMap.putBoolean(str, zza3.zzaVx);
        } else if (i == 13) {
            if (list == null) {
                throw new RuntimeException("populateBundle: unexpected type for: " + str);
            }
            dataMap.putAsset(str, list.get((int) zza3.zzaVD));
        } else if (i == 9) {
            DataMap dataMap2 = new DataMap();
            zzrc.zza[] zzaArr = zza3.zzaVy;
            for (zzrc.zza zza4 : zzaArr) {
                zza(list, dataMap2, zza4.name, zza4.zzaVn);
            }
            dataMap.putDataMap(str, dataMap2);
        } else if (i == 10) {
            int zza5 = zza(str, zza3.zzaVz);
            ArrayList<Integer> zza6 = zza(list, zza3, zza5);
            if (zza5 == 14) {
                dataMap.putStringArrayList(str, zza6);
            } else if (zza5 == 9) {
                dataMap.putDataMapArrayList(str, zza6);
            } else if (zza5 == 2) {
                dataMap.putStringArrayList(str, zza6);
            } else if (zza5 == 6) {
                dataMap.putIntegerArrayList(str, zza6);
            } else {
                throw new IllegalStateException("Unexpected typeOfArrayList: " + zza5);
            }
        } else {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
    }

    private static zzrc.zza[] zza(DataMap dataMap, List<Asset> list) {
        Set<String> keySet = dataMap.keySet();
        zzrc.zza[] zzaArr = new zzrc.zza[keySet.size()];
        int i = 0;
        for (String str : keySet) {
            Object obj = dataMap.get(str);
            zzaArr[i] = new zzrc.zza();
            zzaArr[i].name = str;
            zzaArr[i].zzaVn = zza(list, obj);
            i++;
        }
        return zzaArr;
    }
}
