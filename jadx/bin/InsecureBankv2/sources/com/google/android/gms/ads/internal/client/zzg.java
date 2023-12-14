package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzgd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzgd
public class zzg {
    public static final zzg zzsl = new zzg();

    protected zzg() {
    }

    public static zzg zzcw() {
        return zzsl;
    }

    public AdRequestParcel zza(Context context, zzx zzx) {
        Date birthday = zzx.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1;
        String contentUrl = zzx.getContentUrl();
        int gender = zzx.getGender();
        Set<String> keywords = zzx.getKeywords();
        List unmodifiableList = !keywords.isEmpty() ? Collections.unmodifiableList(new ArrayList(keywords)) : null;
        boolean isTestDevice = zzx.isTestDevice(context);
        int zzcL = zzx.zzcL();
        Location location = zzx.getLocation();
        Bundle networkExtrasBundle = zzx.getNetworkExtrasBundle(AdMobAdapter.class);
        boolean manualImpressionsEnabled = zzx.getManualImpressionsEnabled();
        String publisherProvidedId = zzx.getPublisherProvidedId();
        SearchAdRequest zzcI = zzx.zzcI();
        return new AdRequestParcel(5, time, networkExtrasBundle, gender, unmodifiableList, isTestDevice, zzcL, manualImpressionsEnabled, publisherProvidedId, zzcI != null ? new SearchAdRequestParcel(zzcI) : null, location, contentUrl, zzx.zzcK(), zzx.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(zzx.zzcM())), zzx.zzcH());
    }

    public RewardedVideoAdRequestParcel zza(Context context, zzx zzx, String str) {
        return new RewardedVideoAdRequestParcel(zza(context, zzx), str);
    }
}
