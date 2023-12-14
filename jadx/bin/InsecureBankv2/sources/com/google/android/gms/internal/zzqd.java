package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzu;
import java.util.ArrayList;
import java.util.List;

public class zzqd {
    private final List<zzpy> zzaPn = new ArrayList();

    public String getId() {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (zzpy zzpy : this.zzaPn) {
            if (z) {
                z = false;
            } else {
                sb.append("#");
            }
            sb.append(zzpy.getContainerId());
        }
        return sb.toString();
    }

    public List<zzpy> zzAf() {
        return this.zzaPn;
    }

    public zzqd zzb(zzpy zzpy) throws IllegalArgumentException {
        zzu.zzu(zzpy);
        for (zzpy zzpy2 : this.zzaPn) {
            if (zzpy2.getContainerId().equals(zzpy.getContainerId())) {
                throw new IllegalArgumentException("The container is already being requested. " + zzpy.getContainerId());
            }
        }
        this.zzaPn.add(zzpy);
        return this;
    }
}
