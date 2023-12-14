package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqr;
import com.google.android.gms.internal.zzqy;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragment extends Fragment {
    private boolean mCreated = false;
    private WalletFragmentOptions zzaRS;
    private WalletFragmentInitParams zzaRT;
    private MaskedWalletRequest zzaRU;
    private MaskedWallet zzaRV;
    private Boolean zzaRW;
    private zzb zzaSb;
    private final com.google.android.gms.dynamic.zzb zzaSc = com.google.android.gms.dynamic.zzb.zza(this);
    private final zzc zzaSd = new zzc();
    private zza zzaSe = new zza(this);
    private final Fragment zzajt = this;

    public interface OnStateChangedListener {
        void onStateChanged(WalletFragment walletFragment, int i, int i2, Bundle bundle);
    }

    /* access modifiers changed from: package-private */
    public static class zza extends zzqr.zza {
        private OnStateChangedListener zzaSf;
        private final WalletFragment zzaSg;

        zza(WalletFragment walletFragment) {
            this.zzaSg = walletFragment;
        }

        @Override // com.google.android.gms.internal.zzqr
        public void zza(int i, int i2, Bundle bundle) {
            if (this.zzaSf != null) {
                this.zzaSf.onStateChanged(this.zzaSg, i, i2, bundle);
            }
        }

        public void zza(OnStateChangedListener onStateChangedListener) {
            this.zzaSf = onStateChangedListener;
        }
    }

    /* access modifiers changed from: private */
    public static class zzb implements LifecycleDelegate {
        private final zzqq zzaRZ;

        private zzb(zzqq zzqq) {
            this.zzaRZ = zzqq;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private int getState() {
            try {
                return this.zzaRZ.getState();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void initialize(WalletFragmentInitParams startParams) {
            try {
                this.zzaRZ.initialize(startParams);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void onActivityResult(int requestCode, int resultCode, Intent data) {
            try {
                this.zzaRZ.onActivityResult(requestCode, resultCode, data);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void setEnabled(boolean enabled) {
            try {
                this.zzaRZ.setEnabled(enabled);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void updateMaskedWallet(MaskedWallet maskedWallet) {
            try {
                this.zzaRZ.updateMaskedWallet(maskedWallet);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void updateMaskedWalletRequest(MaskedWalletRequest request) {
            try {
                this.zzaRZ.updateMaskedWalletRequest(request);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onCreate(Bundle savedInstanceState) {
            try {
                this.zzaRZ.onCreate(savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) zze.zzn(this.zzaRZ.onCreateView(zze.zzw(inflater), zze.zzw(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onDestroy() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onDestroyView() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.zzaRZ.zza(zze.zzw(activity), (WalletFragmentOptions) attrs.getParcelable("extraWalletFragmentOptions"), savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onLowMemory() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onPause() {
            try {
                this.zzaRZ.onPause();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onResume() {
            try {
                this.zzaRZ.onResume();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzaRZ.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onStart() {
            try {
                this.zzaRZ.onStart();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onStop() {
            try {
                this.zzaRZ.onStop();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class zzc extends com.google.android.gms.dynamic.zza<zzb> implements View.OnClickListener {
        private zzc() {
        }

        public void onClick(View view) {
            Activity activity = WalletFragment.this.zzajt.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.dynamic.zza
        public void zza(FrameLayout frameLayout) {
            WalletFragmentStyle fragmentStyle;
            Button button = new Button(WalletFragment.this.zzajt.getActivity());
            button.setText(R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (!(WalletFragment.this.zzaRS == null || (fragmentStyle = WalletFragment.this.zzaRS.getFragmentStyle()) == null)) {
                DisplayMetrics displayMetrics = WalletFragment.this.zzajt.getResources().getDisplayMetrics();
                i = fragmentStyle.zza("buyButtonWidth", displayMetrics, -1);
                i2 = fragmentStyle.zza("buyButtonHeight", displayMetrics, -2);
            }
            button.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.dynamic.zza
        public void zza(zzf<zzb> zzf) {
            Activity activity = WalletFragment.this.zzajt.getActivity();
            if (WalletFragment.this.zzaSb == null && WalletFragment.this.mCreated && activity != null) {
                try {
                    zzqq zza = zzqy.zza(activity, WalletFragment.this.zzaSc, WalletFragment.this.zzaRS, WalletFragment.this.zzaSe);
                    WalletFragment.this.zzaSb = new zzb(zza);
                    WalletFragment.this.zzaRS = null;
                    zzf.zza(WalletFragment.this.zzaSb);
                    if (WalletFragment.this.zzaRT != null) {
                        WalletFragment.this.zzaSb.initialize(WalletFragment.this.zzaRT);
                        WalletFragment.this.zzaRT = null;
                    }
                    if (WalletFragment.this.zzaRU != null) {
                        WalletFragment.this.zzaSb.updateMaskedWalletRequest(WalletFragment.this.zzaRU);
                        WalletFragment.this.zzaRU = null;
                    }
                    if (WalletFragment.this.zzaRV != null) {
                        WalletFragment.this.zzaSb.updateMaskedWallet(WalletFragment.this.zzaRV);
                        WalletFragment.this.zzaRV = null;
                    }
                    if (WalletFragment.this.zzaRW != null) {
                        WalletFragment.this.zzaSb.setEnabled(WalletFragment.this.zzaRW.booleanValue());
                        WalletFragment.this.zzaRW = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }
    }

    public static WalletFragment newInstance(WalletFragmentOptions options) {
        WalletFragment walletFragment = new WalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        walletFragment.zzajt.setArguments(bundle);
        return walletFragment;
    }

    public int getState() {
        if (this.zzaSb != null) {
            return this.zzaSb.getState();
        }
        return 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.zzaSb != null) {
            this.zzaSb.initialize(initParams);
            this.zzaRT = null;
        } else if (this.zzaRT == null) {
            this.zzaRT = initParams;
            if (this.zzaRU != null) {
                Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.zzaRV != null) {
                Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.zzaSb != null) {
            this.zzaSb.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        WalletFragmentOptions walletFragmentOptions;
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.zzaRT != null) {
                    Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }
                this.zzaRT = walletFragmentInitParams;
            }
            if (this.zzaRU == null) {
                this.zzaRU = (MaskedWalletRequest) savedInstanceState.getParcelable("maskedWalletRequest");
            }
            if (this.zzaRV == null) {
                this.zzaRV = (MaskedWallet) savedInstanceState.getParcelable("maskedWallet");
            }
            if (savedInstanceState.containsKey("walletFragmentOptions")) {
                this.zzaRS = (WalletFragmentOptions) savedInstanceState.getParcelable("walletFragmentOptions");
            }
            if (savedInstanceState.containsKey("enabled")) {
                this.zzaRW = Boolean.valueOf(savedInstanceState.getBoolean("enabled"));
            }
        } else if (!(this.zzajt.getArguments() == null || (walletFragmentOptions = (WalletFragmentOptions) this.zzajt.getArguments().getParcelable("extraWalletFragmentOptions")) == null)) {
            walletFragmentOptions.zzaL(this.zzajt.getActivity());
            this.zzaRS = walletFragmentOptions;
        }
        this.mCreated = true;
        this.zzaSd.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.zzaSd.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    @Override // android.app.Fragment
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        if (this.zzaRS == null) {
            this.zzaRS = WalletFragmentOptions.zza(activity, attrs);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("attrKeyWalletFragmentOptions", this.zzaRS);
        this.zzaSd.onInflate(activity, bundle, savedInstanceState);
    }

    public void onPause() {
        super.onPause();
        this.zzaSd.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzaSd.onResume();
        FragmentManager fragmentManager = this.zzajt.getActivity().getFragmentManager();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            fragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzajt.getActivity()), this.zzajt.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.zzaSd.onSaveInstanceState(outState);
        if (this.zzaRT != null) {
            outState.putParcelable("walletFragmentInitParams", this.zzaRT);
            this.zzaRT = null;
        }
        if (this.zzaRU != null) {
            outState.putParcelable("maskedWalletRequest", this.zzaRU);
            this.zzaRU = null;
        }
        if (this.zzaRV != null) {
            outState.putParcelable("maskedWallet", this.zzaRV);
            this.zzaRV = null;
        }
        if (this.zzaRS != null) {
            outState.putParcelable("walletFragmentOptions", this.zzaRS);
            this.zzaRS = null;
        }
        if (this.zzaRW != null) {
            outState.putBoolean("enabled", this.zzaRW.booleanValue());
            this.zzaRW = null;
        }
    }

    public void onStart() {
        super.onStart();
        this.zzaSd.onStart();
    }

    public void onStop() {
        super.onStop();
        this.zzaSd.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.zzaSb != null) {
            this.zzaSb.setEnabled(enabled);
            this.zzaRW = null;
            return;
        }
        this.zzaRW = Boolean.valueOf(enabled);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.zzaSe.zza(listener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.zzaSb != null) {
            this.zzaSb.updateMaskedWallet(maskedWallet);
            this.zzaRV = null;
            return;
        }
        this.zzaRV = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.zzaSb != null) {
            this.zzaSb.updateMaskedWalletRequest(request);
            this.zzaRU = null;
            return;
        }
        this.zzaRU = request;
    }
}
