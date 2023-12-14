package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Parcelable.Creator<CreateWalletObjectsRequest> {
    static void zza(CreateWalletObjectsRequest createWalletObjectsRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, createWalletObjectsRequest.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) createWalletObjectsRequest.zzaQj, i, false);
        zzb.zza(parcel, 3, (Parcelable) createWalletObjectsRequest.zzaQk, i, false);
        zzb.zza(parcel, 4, (Parcelable) createWalletObjectsRequest.zzaQl, i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzgd */
    public CreateWalletObjectsRequest createFromParcel(Parcel parcel) {
        GiftCardWalletObject giftCardWalletObject;
        OfferWalletObject offerWalletObject;
        LoyaltyWalletObject loyaltyWalletObject;
        int i;
        GiftCardWalletObject giftCardWalletObject2 = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        OfferWalletObject offerWalletObject2 = null;
        LoyaltyWalletObject loyaltyWalletObject2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    offerWalletObject = offerWalletObject2;
                    loyaltyWalletObject = loyaltyWalletObject2;
                    i = zza.zzg(parcel, zzaa);
                    giftCardWalletObject = giftCardWalletObject2;
                    break;
                case 2:
                    i = i2;
                    loyaltyWalletObject = (LoyaltyWalletObject) zza.zza(parcel, zzaa, LoyaltyWalletObject.CREATOR);
                    giftCardWalletObject = giftCardWalletObject2;
                    offerWalletObject = offerWalletObject2;
                    break;
                case 3:
                    loyaltyWalletObject = loyaltyWalletObject2;
                    i = i2;
                    offerWalletObject = (OfferWalletObject) zza.zza(parcel, zzaa, OfferWalletObject.CREATOR);
                    giftCardWalletObject = giftCardWalletObject2;
                    break;
                case 4:
                    giftCardWalletObject = (GiftCardWalletObject) zza.zza(parcel, zzaa, GiftCardWalletObject.CREATOR);
                    offerWalletObject = offerWalletObject2;
                    loyaltyWalletObject = loyaltyWalletObject2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    giftCardWalletObject = giftCardWalletObject2;
                    offerWalletObject = offerWalletObject2;
                    loyaltyWalletObject = loyaltyWalletObject2;
                    i = i2;
                    break;
            }
            i2 = i;
            loyaltyWalletObject2 = loyaltyWalletObject;
            offerWalletObject2 = offerWalletObject;
            giftCardWalletObject2 = giftCardWalletObject;
        }
        if (parcel.dataPosition() == zzab) {
            return new CreateWalletObjectsRequest(i2, loyaltyWalletObject2, offerWalletObject2, giftCardWalletObject2);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzjf */
    public CreateWalletObjectsRequest[] newArray(int i) {
        return new CreateWalletObjectsRequest[i];
    }
}
