package com.google.android.gms.internal;

import com.google.android.gms.fitness.FitnessStatusCodes;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class zzw implements zzy {
    protected final HttpClient zzaE;

    public static final class zza extends HttpEntityEnclosingRequestBase {
        public zza() {
        }

        public zza(String str) {
            setURI(URI.create(str));
        }

        public String getMethod() {
            return "PATCH";
        }
    }

    public zzw(HttpClient httpClient) {
        this.zzaE = httpClient;
    }

    private static void zza(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, zzk<?> zzk) throws zza {
        byte[] zzq = zzk.zzq();
        if (zzq != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(zzq));
        }
    }

    private static void zza(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, map.get(str));
        }
    }

    static HttpUriRequest zzb(zzk<?> zzk, Map<String, String> map) throws zza {
        switch (zzk.getMethod()) {
            case -1:
                byte[] zzm = zzk.zzm();
                if (zzm == null) {
                    return new HttpGet(zzk.getUrl());
                }
                HttpPost httpPost = new HttpPost(zzk.getUrl());
                httpPost.addHeader("Content-Type", zzk.zzl());
                httpPost.setEntity(new ByteArrayEntity(zzm));
                return httpPost;
            case 0:
                return new HttpGet(zzk.getUrl());
            case 1:
                HttpPost httpPost2 = new HttpPost(zzk.getUrl());
                httpPost2.addHeader("Content-Type", zzk.zzp());
                zza((HttpEntityEnclosingRequestBase) httpPost2, zzk);
                return httpPost2;
            case 2:
                HttpPut httpPut = new HttpPut(zzk.getUrl());
                httpPut.addHeader("Content-Type", zzk.zzp());
                zza((HttpEntityEnclosingRequestBase) httpPut, zzk);
                return httpPut;
            case 3:
                return new HttpDelete(zzk.getUrl());
            case 4:
                return new HttpHead(zzk.getUrl());
            case 5:
                return new HttpOptions(zzk.getUrl());
            case 6:
                return new HttpTrace(zzk.getUrl());
            case 7:
                zza zza2 = new zza(zzk.getUrl());
                zza2.addHeader("Content-Type", zzk.zzp());
                zza((HttpEntityEnclosingRequestBase) zza2, zzk);
                return zza2;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    @Override // com.google.android.gms.internal.zzy
    public HttpResponse zza(zzk<?> zzk, Map<String, String> map) throws IOException, zza {
        HttpUriRequest zzb = zzb(zzk, map);
        zza(zzb, map);
        zza(zzb, zzk.getHeaders());
        zza(zzb);
        HttpParams params = zzb.getParams();
        int zzt = zzk.zzt();
        HttpConnectionParams.setConnectionTimeout(params, FitnessStatusCodes.NEEDS_OAUTH_PERMISSIONS);
        HttpConnectionParams.setSoTimeout(params, zzt);
        return this.zzaE.execute(zzb);
    }

    /* access modifiers changed from: protected */
    public void zza(HttpUriRequest httpUriRequest) throws IOException {
    }
}
