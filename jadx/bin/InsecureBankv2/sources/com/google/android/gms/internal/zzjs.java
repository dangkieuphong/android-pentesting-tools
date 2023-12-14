package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.games.GameManagerClient;
import com.google.android.gms.cast.games.GameManagerState;
import com.google.android.gms.cast.games.PlayerInfo;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.cast.internal.zzp;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class zzjs extends com.google.android.gms.cast.internal.zzc {
    static final String NAMESPACE = zzf.zzbE("com.google.cast.games");
    private static final zzl zzQW = new zzl("GameManagerChannel");
    private String zzTA;
    private final Map<String, String> zzTn = new ConcurrentHashMap();
    private final List<zzp> zzTo;
    private final String zzTp;
    private final Cast.CastApi zzTq;
    private final GoogleApiClient zzTr;
    private zzjt zzTs;
    private boolean zzTt = false;
    private GameManagerState zzTu;
    private GameManagerState zzTv;
    private String zzTw;
    private JSONObject zzTx;
    private long zzTy = 0;
    private GameManagerClient.Listener zzTz;
    private final SharedPreferences zztB;

    public abstract class zza extends zzb<GameManagerClient.GameManagerResult> {
        public zza() {
            super();
            this.zzTa = new zzo(zzjs.this) {
                /* class com.google.android.gms.internal.zzjs.zza.AnonymousClass1 */

                @Override // com.google.android.gms.cast.internal.zzo
                public void zza(long j, int i, Object obj) {
                    if (obj == null) {
                        try {
                            zza.this.setResult(new zze(new Status(i, null, null), null, j, null));
                        } catch (ClassCastException e) {
                            zza.this.setResult(zza.this.createFailedResult(new Status(13)));
                        }
                    } else {
                        zzju zzju = (zzju) obj;
                        String playerId = zzju.getPlayerId();
                        if (i == 0 && playerId != null) {
                            zzjs.this.zzTA = playerId;
                        }
                        zza.this.setResult(new zze(new Status(i, zzju.zzlD(), null), playerId, zzju.getRequestId(), zzju.getExtraMessageData()));
                    }
                }

                @Override // com.google.android.gms.cast.internal.zzo
                public void zzy(long j) {
                    zza.this.setResult(zza.this.createFailedResult(new Status(2103)));
                }
            };
        }

        /* renamed from: zzo */
        public GameManagerClient.GameManagerResult createFailedResult(Status status) {
            return new zze(status, null, -1, null);
        }
    }

    public abstract class zzb<R extends Result> extends com.google.android.gms.cast.internal.zzb<R> {
        protected zzo zzTa;

        public zzb() {
            super(zzjs.this.zzTr);
        }

        public abstract void execute();

        /* access modifiers changed from: protected */
        public void zza(com.google.android.gms.cast.internal.zze zze) {
            execute();
        }

        public zzo zzlA() {
            return this.zzTa;
        }
    }

    public abstract class zzc extends zzb<GameManagerClient.GameManagerInstanceResult> {
        private GameManagerClient zzTJ;

        public zzc(GameManagerClient gameManagerClient) {
            super();
            this.zzTJ = gameManagerClient;
            this.zzTa = new zzo(zzjs.this) {
                /* class com.google.android.gms.internal.zzjs.zzc.AnonymousClass1 */

                @Override // com.google.android.gms.cast.internal.zzo
                public void zza(long j, int i, Object obj) {
                    if (obj == null) {
                        try {
                            zzc.this.setResult(new zzd(new Status(i, null, null), zzc.this.zzTJ));
                        } catch (ClassCastException e) {
                            zzc.this.setResult(zzc.this.createFailedResult(new Status(13)));
                        }
                    } else {
                        zzju zzju = (zzju) obj;
                        zzjt zzlH = zzju.zzlH();
                        if (zzlH == null || zzf.zza("1.0.0", zzlH.getVersion())) {
                            zzc.this.setResult(new zzd(new Status(i, zzju.zzlD(), null), zzc.this.zzTJ));
                            return;
                        }
                        zzc.this.setResult(zzc.this.createFailedResult(new Status(GameManagerClient.STATUS_INCORRECT_VERSION, String.format(Locale.ROOT, "Incorrect Game Manager SDK version. Receiver: %s Sender: %s", zzlH.getVersion(), "1.0.0"))));
                        zzjs.this.zzTs = null;
                    }
                }

                @Override // com.google.android.gms.cast.internal.zzo
                public void zzy(long j) {
                    zzc.this.setResult(zzc.this.createFailedResult(new Status(2103)));
                }
            };
        }

        /* renamed from: zzp */
        public GameManagerClient.GameManagerInstanceResult createFailedResult(Status status) {
            return new zzd(status, null);
        }
    }

    /* access modifiers changed from: private */
    public static final class zzd implements GameManagerClient.GameManagerInstanceResult {
        private final Status zzOt;
        private final GameManagerClient zzTJ;

        zzd(Status status, GameManagerClient gameManagerClient) {
            this.zzOt = status;
            this.zzTJ = gameManagerClient;
        }

        @Override // com.google.android.gms.cast.games.GameManagerClient.GameManagerInstanceResult
        public GameManagerClient getGameManagerClient() {
            return this.zzTJ;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    /* access modifiers changed from: private */
    public static final class zze implements GameManagerClient.GameManagerResult {
        private final Status zzOt;
        private final String zzTL;
        private final long zzTM;
        private final JSONObject zzTN;

        zze(Status status, String str, long j, JSONObject jSONObject) {
            this.zzOt = status;
            this.zzTL = str;
            this.zzTM = j;
            this.zzTN = jSONObject;
        }

        @Override // com.google.android.gms.cast.games.GameManagerClient.GameManagerResult
        public JSONObject getExtraMessageData() {
            return this.zzTN;
        }

        @Override // com.google.android.gms.cast.games.GameManagerClient.GameManagerResult
        public String getPlayerId() {
            return this.zzTL;
        }

        @Override // com.google.android.gms.cast.games.GameManagerClient.GameManagerResult
        public long getRequestId() {
            return this.zzTM;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    public zzjs(GoogleApiClient googleApiClient, String str, Cast.CastApi castApi) throws IllegalArgumentException, IllegalStateException {
        super(NAMESPACE, "CastGameManagerChannel", null);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("castSessionId cannot be null.");
        } else if (googleApiClient == null || !googleApiClient.isConnected() || !googleApiClient.hasConnectedApi(Cast.API)) {
            throw new IllegalArgumentException("googleApiClient needs to be connected and contain the Cast.API API.");
        } else {
            this.zzTo = new ArrayList();
            this.zzTp = str;
            this.zzTq = castApi;
            this.zzTr = googleApiClient;
            Context applicationContext = googleApiClient.getContext().getApplicationContext();
            this.zztB = applicationContext.getApplicationContext().getSharedPreferences(String.format(Locale.ROOT, "%s.%s", applicationContext.getPackageName(), "game_manager_channel_data"), 0);
            this.zzTv = null;
            this.zzTu = new zzjw(0, 0, "", null, new ArrayList(), "", -1);
        }
    }

    private JSONObject zza(long j, String str, int i, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("requestId", j);
            jSONObject2.put("type", i);
            jSONObject2.put("extraMessageData", jSONObject);
            jSONObject2.put("playerId", str);
            jSONObject2.put("playerToken", zzbA(str));
            return jSONObject2;
        } catch (JSONException e) {
            zzQW.zzf("JSONException when trying to create a message: %s", e.getMessage());
            return null;
        }
    }

    private synchronized void zza(zzju zzju) {
        boolean z = true;
        synchronized (this) {
            if (zzju.zzlC() != 1) {
                z = false;
            }
            this.zzTv = this.zzTu;
            if (z && zzju.zzlH() != null) {
                this.zzTs = zzju.zzlH();
            }
            if (isInitialized()) {
                ArrayList arrayList = new ArrayList();
                for (zzjy zzjy : zzju.zzlE()) {
                    String playerId = zzjy.getPlayerId();
                    arrayList.add(new zzjx(playerId, zzjy.getPlayerState(), zzjy.getPlayerData(), this.zzTn.containsKey(playerId)));
                }
                this.zzTu = new zzjw(zzju.getLobbyState(), zzju.getGameplayState(), zzju.zzlF(), zzju.getGameData(), arrayList, this.zzTs.zzlB(), this.zzTs.getMaxPlayers());
                PlayerInfo player = this.zzTu.getPlayer(zzju.getPlayerId());
                if (player != null && player.isControllable() && zzju.zzlC() == 2) {
                    this.zzTw = zzju.getPlayerId();
                    this.zzTx = zzju.getExtraMessageData();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zza(String str, int i, JSONObject jSONObject, zzo zzo) {
        final long j = 1 + this.zzTy;
        this.zzTy = j;
        JSONObject zza2 = zza(j, str, i, jSONObject);
        if (zza2 == null) {
            zzo.zza(-1, 2001, null);
            zzQW.zzf("Not sending request because it was invalid.", new Object[0]);
            return;
        }
        zzp zzp = new zzp(30000);
        zzp.zza(j, zzo);
        this.zzTo.add(zzp);
        zzQ(true);
        this.zzTq.sendMessage(this.zzTr, getNamespace(), zza2.toString()).setResultCallback(new ResultCallback<Status>() {
            /* class com.google.android.gms.internal.zzjs.AnonymousClass4 */

            /* renamed from: zzm */
            public void onResult(Status status) {
                if (!status.isSuccess()) {
                    zzjs.this.zzb(j, status.getStatusCode());
                }
            }
        });
    }

    private int zzaI(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 2001;
            case 2:
                return 2003;
            case 3:
                return GameManagerClient.STATUS_INCORRECT_VERSION;
            case 4:
                return GameManagerClient.STATUS_TOO_MANY_PLAYERS;
            default:
                zzQW.zzf("Unknown GameManager protocol status code: " + i, new Object[0]);
                return 13;
        }
    }

    private void zzb(long j, int i, Object obj) {
        Iterator<zzp> it = this.zzTo.iterator();
        while (it.hasNext()) {
            if (it.next().zzc(j, i, obj)) {
                it.remove();
            }
        }
    }

    private synchronized void zzlv() throws IllegalStateException {
        if (!isInitialized()) {
            throw new IllegalStateException("Attempted to perform an operation on the GameManagerChannel before it is initialized.");
        } else if (isDisposed()) {
            throw new IllegalStateException("Attempted to perform an operation on the GameManagerChannel after it has been disposed.");
        }
    }

    private void zzlw() {
        if (this.zzTz != null) {
            if (this.zzTv != null && !this.zzTu.equals(this.zzTv)) {
                this.zzTz.onStateChanged(this.zzTu, this.zzTv);
            }
            if (!(this.zzTx == null || this.zzTw == null)) {
                this.zzTz.onGameMessageReceived(this.zzTw, this.zzTx);
            }
        }
        this.zzTv = null;
        this.zzTw = null;
        this.zzTx = null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void zzlx() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("castSessionId", this.zzTp);
            jSONObject.put("playerTokenMap", new JSONObject(this.zzTn));
            this.zztB.edit().putString("save_data", jSONObject.toString()).commit();
        } catch (JSONException e) {
            zzQW.zzf("Error while saving data: %s", e.getMessage());
        }
        return;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void zzly() {
        String string = this.zztB.getString("save_data", null);
        if (string != null) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (this.zzTp.equals(jSONObject.getString("castSessionId"))) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("playerTokenMap");
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.zzTn.put(next, jSONObject2.getString(next));
                    }
                    this.zzTy = 0;
                }
            } catch (JSONException e) {
                zzQW.zzf("Error while loading data: %s", e.getMessage());
            }
        }
    }

    public synchronized void dispose() throws IllegalStateException {
        if (!this.zzTt) {
            this.zzTu = null;
            this.zzTv = null;
            this.zzTw = null;
            this.zzTx = null;
            this.zzTt = true;
            try {
                this.zzTq.removeMessageReceivedCallbacks(this.zzTr, getNamespace());
            } catch (IOException e) {
                zzQW.zzf("Exception while detaching game manager channel.", e);
            }
        }
    }

    public synchronized GameManagerState getCurrentState() throws IllegalStateException {
        zzlv();
        return this.zzTu;
    }

    public synchronized String getLastUsedPlayerId() throws IllegalStateException {
        zzlv();
        return this.zzTA;
    }

    public synchronized boolean isDisposed() {
        return this.zzTt;
    }

    public synchronized boolean isInitialized() {
        return this.zzTs != null;
    }

    public synchronized void sendGameMessage(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        zzlv();
        long j = 1 + this.zzTy;
        this.zzTy = j;
        JSONObject zza2 = zza(j, playerId, 7, extraMessageData);
        if (zza2 != null) {
            this.zzTq.sendMessage(this.zzTr, getNamespace(), zza2.toString());
        }
    }

    public synchronized PendingResult<GameManagerClient.GameManagerResult> sendGameRequest(final String playerId, final JSONObject extraMessageData) throws IllegalStateException {
        zzlv();
        return this.zzTr.zzb(new zza() {
            /* class com.google.android.gms.internal.zzjs.AnonymousClass3 */

            @Override // com.google.android.gms.internal.zzjs.zzb
            public void execute() {
                zzjs.this.zza((zzjs) playerId, (String) 6, (int) extraMessageData, (JSONObject) zzlA());
            }
        });
    }

    public synchronized void setListener(GameManagerClient.Listener listener) {
        this.zzTz = listener;
    }

    public synchronized PendingResult<GameManagerClient.GameManagerInstanceResult> zza(GameManagerClient gameManagerClient) throws IllegalArgumentException {
        if (gameManagerClient == null) {
            throw new IllegalArgumentException("gameManagerClient can't be null.");
        }
        return this.zzTr.zzb(new zzc(gameManagerClient) {
            /* class com.google.android.gms.internal.zzjs.AnonymousClass1 */

            @Override // com.google.android.gms.internal.zzjs.zzb
            public void execute() {
                try {
                    zzjs.this.zzTq.setMessageReceivedCallbacks(zzjs.this.zzTr, zzjs.this.getNamespace(), new Cast.MessageReceivedCallback() {
                        /* class com.google.android.gms.internal.zzjs.AnonymousClass1.AnonymousClass1 */

                        @Override // com.google.android.gms.cast.Cast.MessageReceivedCallback
                        public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
                            zzjs.this.zzbB(message);
                        }
                    });
                    zzjs.this.zzly();
                    zzjs.this.zzlx();
                    zzjs.this.zza((zzjs) null, (String) 1100, (int) null, (JSONObject) zzlA());
                } catch (IOException | IllegalStateException e) {
                    zzlA().zza(-1, 8, null);
                }
            }
        });
    }

    public synchronized PendingResult<GameManagerClient.GameManagerResult> zza(final String str, final int i, final JSONObject jSONObject) throws IllegalStateException {
        zzlv();
        return this.zzTr.zzb(new zza() {
            /* class com.google.android.gms.internal.zzjs.AnonymousClass2 */

            @Override // com.google.android.gms.internal.zzjs.zzb
            public void execute() {
                int zzaJ = zzjv.zzaJ(i);
                if (zzaJ == 0) {
                    zzlA().zza(-1, 2001, null);
                    zzjs.zzQW.zzf("sendPlayerRequest for unsupported playerState: %d", Integer.valueOf(i));
                    return;
                }
                zzjs.this.zza((zzjs) str, (String) zzaJ, (int) jSONObject, (JSONObject) zzlA());
            }
        });
    }

    @Override // com.google.android.gms.cast.internal.zzd
    public void zzb(long j, int i) {
        zzb(j, i, null);
    }

    public synchronized String zzbA(String str) throws IllegalStateException {
        return str == null ? null : this.zzTn.get(str);
    }

    @Override // com.google.android.gms.cast.internal.zzd
    public final void zzbB(String str) {
        zzQW.zzb("message received: %s", str);
        try {
            zzju zzh = zzju.zzh(new JSONObject(str));
            if (zzh == null) {
                zzQW.zzf("Could not parse game manager message from string: %s", str);
            } else if ((isInitialized() || zzh.zzlH() != null) && !isDisposed()) {
                boolean z = zzh.zzlC() == 1;
                if (z && !TextUtils.isEmpty(zzh.zzlG())) {
                    this.zzTn.put(zzh.getPlayerId(), zzh.zzlG());
                    zzlx();
                }
                if (zzh.getStatusCode() == 0) {
                    zza(zzh);
                } else {
                    zzQW.zzf("Not updating from game message because the message contains error code: %d", Integer.valueOf(zzh.getStatusCode()));
                }
                int zzaI = zzaI(zzh.getStatusCode());
                if (z) {
                    zzb(zzh.getRequestId(), zzaI, zzh);
                }
                if (isInitialized() && zzaI == 0) {
                    zzlw();
                }
            }
        } catch (JSONException e) {
            zzQW.zzf("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.cast.internal.zzc
    public boolean zzz(long j) {
        boolean z;
        Iterator<zzp> it = this.zzTo.iterator();
        while (it.hasNext()) {
            if (it.next().zzd(j, 15)) {
                it.remove();
            }
        }
        synchronized (zzp.zzVr) {
            Iterator<zzp> it2 = this.zzTo.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().zzme()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
        }
        return z;
    }
}
