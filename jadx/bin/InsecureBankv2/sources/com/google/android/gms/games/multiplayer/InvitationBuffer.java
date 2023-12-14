package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class InvitationBuffer extends zzf<Invitation> {
    public InvitationBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    public String zzni() {
        return "external_invitation_id";
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzo */
    public Invitation zzj(int i, int i2) {
        return new InvitationRef(this.zzWu, i, i2);
    }
}
