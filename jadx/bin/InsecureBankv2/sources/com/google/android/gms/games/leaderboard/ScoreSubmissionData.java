package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.games.internal.constants.TimeSpan;
import java.util.HashMap;

public final class ScoreSubmissionData {
    private static final String[] zzatw = {"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    private String zzTL;
    private int zzTS;
    private String zzaty;
    private HashMap<Integer, Result> zzauc = new HashMap<>();

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long rawScore2, String formattedScore2, String scoreTag2, boolean newBest2) {
            this.rawScore = rawScore2;
            this.formattedScore = formattedScore2;
            this.scoreTag = scoreTag2;
            this.newBest = newBest2;
        }

        public String toString() {
            return zzt.zzt(this).zzg("RawScore", Long.valueOf(this.rawScore)).zzg("FormattedScore", this.formattedScore).zzg("ScoreTag", this.scoreTag).zzg("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    public ScoreSubmissionData(DataHolder dataHolder) {
        this.zzTS = dataHolder.getStatusCode();
        int count = dataHolder.getCount();
        zzu.zzV(count == 3);
        for (int i = 0; i < count; i++) {
            int zzbh = dataHolder.zzbh(i);
            if (i == 0) {
                this.zzaty = dataHolder.zzd("leaderboardId", i, zzbh);
                this.zzTL = dataHolder.zzd("playerId", i, zzbh);
            }
            if (dataHolder.zze("hasResult", i, zzbh)) {
                zza(new Result(dataHolder.zzb("rawScore", i, zzbh), dataHolder.zzd("formattedScore", i, zzbh), dataHolder.zzd("scoreTag", i, zzbh), dataHolder.zze("newBest", i, zzbh)), dataHolder.zzc("timeSpan", i, zzbh));
            }
        }
    }

    private void zza(Result result, int i) {
        this.zzauc.put(Integer.valueOf(i), result);
    }

    public String getLeaderboardId() {
        return this.zzaty;
    }

    public String getPlayerId() {
        return this.zzTL;
    }

    public Result getScoreResult(int timeSpan) {
        return this.zzauc.get(Integer.valueOf(timeSpan));
    }

    public String toString() {
        zzt.zza zzg = zzt.zzt(this).zzg("PlayerId", this.zzTL).zzg("StatusCode", Integer.valueOf(this.zzTS));
        for (int i = 0; i < 3; i++) {
            Result result = this.zzauc.get(Integer.valueOf(i));
            zzg.zzg("TimesSpan", TimeSpan.zzfG(i));
            zzg.zzg("Result", result == null ? "null" : result.toString());
        }
        return zzg.toString();
    }
}
