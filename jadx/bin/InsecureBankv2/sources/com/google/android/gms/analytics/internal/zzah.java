package com.google.android.gms.analytics.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.common.internal.zzu;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* access modifiers changed from: package-private */
public class zzah extends zzd {
    private static final byte[] zzMs = "\n".getBytes();
    private final String zzFP = zza("GoogleAnalytics", zze.VERSION, Build.VERSION.RELEASE, zzam.zza(Locale.getDefault()), Build.MODEL, Build.ID);
    private final zzaj zzMr;

    /* access modifiers changed from: private */
    public class zza {
        private int zzMt;
        private ByteArrayOutputStream zzMu = new ByteArrayOutputStream();

        public zza() {
        }

        public byte[] getPayload() {
            return this.zzMu.toByteArray();
        }

        public boolean zzj(zzab zzab) {
            zzu.zzu(zzab);
            if (this.zzMt + 1 > zzah.this.zzhR().zzji()) {
                return false;
            }
            String zza = zzah.this.zza(zzab, false);
            if (zza == null) {
                zzah.this.zzhQ().zza(zzab, "Error formatting hit");
                return true;
            }
            byte[] bytes = zza.getBytes();
            int length = bytes.length;
            if (length > zzah.this.zzhR().zzja()) {
                zzah.this.zzhQ().zza(zzab, "Hit size exceeds the maximum size limit");
                return true;
            }
            if (this.zzMu.size() > 0) {
                length++;
            }
            if (length + this.zzMu.size() > zzah.this.zzhR().zzjc()) {
                return false;
            }
            try {
                if (this.zzMu.size() > 0) {
                    this.zzMu.write(zzah.zzMs);
                }
                this.zzMu.write(bytes);
                this.zzMt++;
                return true;
            } catch (IOException e) {
                zzah.this.zze("Failed to write payload when batching hits", e);
                return true;
            }
        }

        public int zzkj() {
            return this.zzMt;
        }
    }

    zzah(zzf zzf) {
        super(zzf);
        this.zzMr = new zzaj(zzf.zzhP());
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006e A[SYNTHETIC, Splitter:B:26:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0082 A[SYNTHETIC, Splitter:B:35:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int zza(java.net.URL r6, byte[] r7) {
        /*
        // Method dump skipped, instructions count: 150
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzah.zza(java.net.URL, byte[]):int");
    }

    private static String zza(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", str, str2, str3, str4, str5, str6);
    }

    private void zza(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }

    private int zzb(URL url) {
        int i;
        zzu.zzu(url);
        zzb("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection zzc = zzc(url);
            zzc.connect();
            zzb(zzc);
            i = zzc.getResponseCode();
            if (i == 200) {
                zzhl().zzhL();
            }
            zzb("GET status", Integer.valueOf(i));
            if (zzc != null) {
                zzc.disconnect();
            }
        } catch (IOException e) {
            zzd("Network GET connection error", e);
            i = 0;
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00af A[SYNTHETIC, Splitter:B:33:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c3 A[SYNTHETIC, Splitter:B:42:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int zzb(java.net.URL r9, byte[] r10) {
        /*
        // Method dump skipped, instructions count: 226
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzah.zzb(java.net.URL, byte[]):int");
    }

    private URL zzb(zzab zzab, String str) {
        try {
            return new URL(zzab.zzjY() ? zzhR().zzjk() + zzhR().zzjm() + "?" + str : zzhR().zzjl() + zzhR().zzjm() + "?" + str);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private void zzb(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            do {
            } while (inputStream.read(new byte[1024]) > 0);
            if (inputStream != null) {
                try {
                } catch (IOException e) {
                    zze("Error closing http connection input stream", e);
                }
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    zze("Error closing http connection input stream", e2);
                }
            }
        }
    }

    private boolean zzg(zzab zzab) {
        zzu.zzu(zzab);
        String zza2 = zza(zzab, !zzab.zzjY());
        if (zza2 == null) {
            zzhQ().zza(zzab, "Error formatting hit for upload");
            return true;
        } else if (zza2.length() <= zzhR().zziZ()) {
            URL zzb = zzb(zzab, zza2);
            if (zzb != null) {
                return zzb(zzb) == 200;
            }
            zzaX("Failed to build collect GET endpoint url");
            return false;
        } else {
            String zza3 = zza(zzab, false);
            if (zza3 == null) {
                zzhQ().zza(zzab, "Error formatting hit for POST upload");
                return true;
            }
            byte[] bytes = zza3.getBytes();
            if (bytes.length > zzhR().zzjb()) {
                zzhQ().zza(zzab, "Hit payload exceeds size limit");
                return true;
            }
            URL zzh = zzh(zzab);
            if (zzh != null) {
                return zza(zzh, bytes) == 200;
            }
            zzaX("Failed to build collect POST endpoint url");
            return false;
        }
    }

    private static byte[] zzg(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private URL zzh(zzab zzab) {
        try {
            return new URL(zzab.zzjY() ? zzhR().zzjk() + zzhR().zzjm() : zzhR().zzjl() + zzhR().zzjm());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private String zzi(zzab zzab) {
        return String.valueOf(zzab.zzjV());
    }

    private URL zzkh() {
        try {
            return new URL(zzhR().zzjk() + zzhR().zzjn());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String zza(zzab zzab, boolean z) {
        zzu.zzu(zzab);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : zzab.zzn().entrySet()) {
                String key = entry.getKey();
                if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key) && !"z".equals(key) && !"_gmsv".equals(key)) {
                    zza(sb, key, entry.getValue());
                }
            }
            zza(sb, "ht", String.valueOf(zzab.zzjW()));
            zza(sb, "qt", String.valueOf(zzhP().currentTimeMillis() - zzab.zzjW()));
            if (zzhR().zziW()) {
                zza(sb, "_gmsv", zze.VERSION);
            }
            if (z) {
                long zzjZ = zzab.zzjZ();
                zza(sb, "z", zzjZ != 0 ? String.valueOf(zzjZ) : zzi(zzab));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            zze("Failed to encode name or value", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public List<Long> zza(List<zzab> list, boolean z) {
        zzu.zzV(!list.isEmpty());
        zza("Uploading batched hits. compression, count", Boolean.valueOf(z), Integer.valueOf(list.size()));
        zza zza2 = new zza();
        ArrayList arrayList = new ArrayList();
        for (zzab zzab : list) {
            if (!zza2.zzj(zzab)) {
                break;
            }
            arrayList.add(Long.valueOf(zzab.zzjV()));
        }
        if (zza2.zzkj() == 0) {
            return arrayList;
        }
        URL zzkh = zzkh();
        if (zzkh == null) {
            zzaX("Failed to build batching endpoint url");
            return Collections.emptyList();
        }
        int zzb = z ? zzb(zzkh, zza2.getPayload()) : zza(zzkh, zza2.getPayload());
        if (200 == zzb) {
            zza("Batched upload completed. Hits batched", Integer.valueOf(zza2.zzkj()));
            return arrayList;
        }
        zza("Network error uploading hits. status code", Integer.valueOf(zzb));
        if (zzhR().zzjq().contains(Integer.valueOf(zzb))) {
            zzaW("Server instructed the client to stop batching");
            this.zzMr.start();
        }
        return Collections.emptyList();
    }

    /* access modifiers changed from: package-private */
    public HttpURLConnection zzc(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (!(openConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(zzhR().zzjz());
        httpURLConnection.setReadTimeout(zzhR().zzjA());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("User-Agent", this.zzFP);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    public List<Long> zzf(List<zzab> list) {
        boolean z;
        boolean z2 = true;
        zzhO();
        zzia();
        zzu.zzu(list);
        if (zzhR().zzjq().isEmpty() || !this.zzMr.zzv(zzhR().zzjj() * 1000)) {
            z2 = false;
            z = false;
        } else {
            z = zzhR().zzjo() != zzm.NONE;
            if (zzhR().zzjp() != zzo.GZIP) {
                z2 = false;
            }
        }
        return z ? zza(list, z2) : zzg(list);
    }

    /* access modifiers changed from: package-private */
    public List<Long> zzg(List<zzab> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (zzab zzab : list) {
            if (!zzg(zzab)) {
                break;
            }
            arrayList.add(Long.valueOf(zzab.zzjV()));
            if (arrayList.size() >= zzhR().zzjh()) {
                break;
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.analytics.internal.zzd
    public void zzhn() {
        zza("Network initialized. User agent", this.zzFP);
    }

    public boolean zzkg() {
        NetworkInfo networkInfo;
        zzhO();
        zzia();
        try {
            networkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        zzaT("No network connectivity");
        return false;
    }
}
