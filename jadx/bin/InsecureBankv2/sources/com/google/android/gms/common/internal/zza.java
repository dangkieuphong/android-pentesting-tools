package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.IAccountAccessor;

public class zza extends IAccountAccessor.zza {
    private Context mContext;
    private Account zzMY;
    int zzZN;

    public static Account zza(IAccountAccessor iAccountAccessor) {
        Account account = null;
        if (iAccountAccessor != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = iAccountAccessor.getAccount();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof zza)) {
            return false;
        }
        return this.zzMY.equals(((zza) o).zzMY);
    }

    @Override // com.google.android.gms.common.internal.IAccountAccessor
    public Account getAccount() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.zzZN) {
            return this.zzMY;
        }
        if (GooglePlayServicesUtil.zzd(this.mContext, callingUid)) {
            this.zzZN = callingUid;
            return this.zzMY;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }
}
