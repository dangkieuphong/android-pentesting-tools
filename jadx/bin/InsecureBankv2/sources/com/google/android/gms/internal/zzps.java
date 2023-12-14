package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.signin.internal.zze;
import java.util.Set;

public interface zzps extends Api.Client {
    void connect();

    void zza(IAccountAccessor iAccountAccessor, Set<Scope> set, zze zze);

    void zza(IAccountAccessor iAccountAccessor, boolean z);

    void zza(zzq zzq);

    void zzxY();
}
