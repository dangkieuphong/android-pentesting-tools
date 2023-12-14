package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class MilestoneBuffer extends AbstractDataBuffer<Milestone> {
    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.data.AbstractDataBuffer
    public Milestone get(int position) {
        return new MilestoneRef(this.zzWu, position);
    }
}
