package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class GameNotificationBuffer extends AbstractDataBuffer<GameNotification> {
    /* renamed from: zzfN */
    public GameNotification get(int i) {
        return new GameNotificationRef(this.zzWu, i);
    }
}
