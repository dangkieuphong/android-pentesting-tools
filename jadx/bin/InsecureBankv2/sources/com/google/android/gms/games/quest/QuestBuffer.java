package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class QuestBuffer extends zzf<Quest> {
    public QuestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    public String zzni() {
        return "external_quest_id";
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzr */
    public Quest zzj(int i, int i2) {
        return new QuestRef(this.zzWu, i, i2);
    }
}
