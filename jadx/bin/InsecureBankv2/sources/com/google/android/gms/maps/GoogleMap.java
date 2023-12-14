package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.ILocationSourceDelegate;
import com.google.android.gms.maps.internal.zzb;
import com.google.android.gms.maps.internal.zzd;
import com.google.android.gms.maps.internal.zzf;
import com.google.android.gms.maps.internal.zzg;
import com.google.android.gms.maps.internal.zzh;
import com.google.android.gms.maps.internal.zzj;
import com.google.android.gms.maps.internal.zzk;
import com.google.android.gms.maps.internal.zzl;
import com.google.android.gms.maps.internal.zzn;
import com.google.android.gms.maps.internal.zzo;
import com.google.android.gms.maps.internal.zzp;
import com.google.android.gms.maps.internal.zzq;
import com.google.android.gms.maps.internal.zzw;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.zzf;
import com.google.android.gms.maps.model.internal.zzg;
import com.google.android.gms.maps.model.internal.zzi;
import com.google.android.gms.maps.model.internal.zzk;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate zzaBp;
    private UiSettings zzaBq;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    private static final class zza extends zzb.zza {
        private final CancelableCallback zzaBH;

        zza(CancelableCallback cancelableCallback) {
            this.zzaBH = cancelableCallback;
        }

        @Override // com.google.android.gms.maps.internal.zzb
        public void onCancel() {
            this.zzaBH.onCancel();
        }

        @Override // com.google.android.gms.maps.internal.zzb
        public void onFinish() {
            this.zzaBH.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate map) {
        this.zzaBp = (IGoogleMapDelegate) zzu.zzu(map);
    }

    public final Circle addCircle(CircleOptions options) {
        try {
            return new Circle(this.zzaBp.addCircle(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions options) {
        try {
            zzf addGroundOverlay = this.zzaBp.addGroundOverlay(options);
            if (addGroundOverlay != null) {
                return new GroundOverlay(addGroundOverlay);
            }
            return null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions options) {
        try {
            zzi addMarker = this.zzaBp.addMarker(options);
            if (addMarker != null) {
                return new Marker(addMarker);
            }
            return null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions options) {
        try {
            return new Polygon(this.zzaBp.addPolygon(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions options) {
        try {
            return new Polyline(this.zzaBp.addPolyline(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions options) {
        try {
            zzk addTileOverlay = this.zzaBp.addTileOverlay(options);
            if (addTileOverlay != null) {
                return new TileOverlay(addTileOverlay);
            }
            return null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update) {
        try {
            this.zzaBp.animateCamera(update.zzvg());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, int durationMs, CancelableCallback callback) {
        try {
            this.zzaBp.animateCameraWithDurationAndCallback(update.zzvg(), durationMs, callback == null ? null : new zza(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, CancelableCallback callback) {
        try {
            this.zzaBp.animateCameraWithCallback(update.zzvg(), callback == null ? null : new zza(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.zzaBp.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.zzaBp.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public IndoorBuilding getFocusedBuilding() {
        try {
            zzg focusedBuilding = this.zzaBp.getFocusedBuilding();
            if (focusedBuilding != null) {
                return new IndoorBuilding(focusedBuilding);
            }
            return null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.zzaBp.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.zzaBp.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.zzaBp.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.zzaBp.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.zzaBp.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.zzaBq == null) {
                this.zzaBq = new UiSettings(this.zzaBp.getUiSettings());
            }
            return this.zzaBq;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.zzaBp.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.zzaBp.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.zzaBp.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.zzaBp.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate update) {
        try {
            this.zzaBp.moveCamera(update.zzvg());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBuildingsEnabled(boolean enabled) {
        try {
            this.zzaBp.setBuildingsEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setContentDescription(String description) {
        try {
            this.zzaBp.setContentDescription(description);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean enabled) {
        try {
            return this.zzaBp.setIndoorEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(final InfoWindowAdapter adapter) {
        if (adapter == null) {
            try {
                this.zzaBp.setInfoWindowAdapter(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaBp.setInfoWindowAdapter(new zzd.zza() {
                /* class com.google.android.gms.maps.GoogleMap.AnonymousClass13 */

                @Override // com.google.android.gms.maps.internal.zzd
                public com.google.android.gms.dynamic.zzd zzf(zzi zzi) {
                    return zze.zzw(adapter.getInfoWindow(new Marker(zzi)));
                }

                @Override // com.google.android.gms.maps.internal.zzd
                public com.google.android.gms.dynamic.zzd zzg(zzi zzi) {
                    return zze.zzw(adapter.getInfoContents(new Marker(zzi)));
                }
            });
        }
    }

    public final void setLocationSource(final LocationSource source) {
        if (source == null) {
            try {
                this.zzaBp.setLocationSource(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaBp.setLocationSource(new ILocationSourceDelegate.zza() {
                /* class com.google.android.gms.maps.GoogleMap.AnonymousClass6 */

                @Override // com.google.android.gms.maps.internal.ILocationSourceDelegate
                public void activate(final com.google.android.gms.maps.internal.zzi listener) {
                    source.activate(new LocationSource.OnLocationChangedListener() {
                        /* class com.google.android.gms.maps.GoogleMap.AnonymousClass6.AnonymousClass1 */

                        @Override // com.google.android.gms.maps.LocationSource.OnLocationChangedListener
                        public void onLocationChanged(Location location) {
                            try {
                                listener.zzd(location);
                            } catch (RemoteException e) {
                                throw new RuntimeRemoteException(e);
                            }
                        }
                    });
                }

                @Override // com.google.android.gms.maps.internal.ILocationSourceDelegate
                public void deactivate() {
                    source.deactivate();
                }
            });
        }
    }

    public final void setMapType(int type) {
        try {
            this.zzaBp.setMapType(type);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean enabled) {
        try {
            this.zzaBp.setMyLocationEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraChangeListener(final OnCameraChangeListener listener) {
        if (listener == null) {
            try {
                this.zzaBp.setOnCameraChangeListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaBp.setOnCameraChangeListener(new zzf.zza() {
                /* class com.google.android.gms.maps.GoogleMap.AnonymousClass7 */

                @Override // com.google.android.gms.maps.internal.zzf
                public void onCameraChange(CameraPosition position) {
                    listener.onCameraChange(position);
                }
            });
        }
    }

    public final void setOnIndoorStateChangeListener(final OnIndoorStateChangeListener listener) {
        if (listener == null) {
            try {
                this.zzaBp.setOnIndoorStateChangeListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaBp.setOnIndoorStateChangeListener(new zzg.zza() {
                /* class com.google.android.gms.maps.GoogleMap.AnonymousClass1 */

                @Override // com.google.android.gms.maps.internal.zzg
                public void onIndoorBuildingFocused() {
                    listener.onIndoorBuildingFocused();
                }

                @Override // com.google.android.gms.maps.internal.zzg
                public void zza(com.google.android.gms.maps.model.internal.zzg zzg) {
                    listener.onIndoorLevelActivated(new IndoorBuilding(zzg));
                }
            });
        }
    }

    public final void setOnInfoWindowClickListener(final OnInfoWindowClickListener listener) {
        if (listener == null) {
            try {
                this.zzaBp.setOnInfoWindowClickListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaBp.setOnInfoWindowClickListener(new zzh.zza() {
                /* class com.google.android.gms.maps.GoogleMap.AnonymousClass12 */

                @Override // com.google.android.gms.maps.internal.zzh
                public void zze(zzi zzi) {
                    listener.onInfoWindowClick(new Marker(zzi));
                }
            });
        }
    }

    public final void setOnMapClickListener(final OnMapClickListener listener) {
        if (listener == null) {
            try {
                this.zzaBp.setOnMapClickListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaBp.setOnMapClickListener(new zzj.zza() {
                /* class com.google.android.gms.maps.GoogleMap.AnonymousClass8 */

                @Override // com.google.android.gms.maps.internal.zzj
                public void onMapClick(LatLng point) {
                    listener.onMapClick(point);
                }
            });
        }
    }

    public void setOnMapLoadedCallback(final OnMapLoadedCallback callback) {
        if (callback == null) {
            try {
                this.zzaBp.setOnMapLoadedCallback(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaBp.setOnMapLoadedCallback(new zzk.zza() {
                /* class com.google.android.gms.maps.GoogleMap.AnonymousClass4 */

                @Override // com.google.android.gms.maps.internal.zzk
                public void onMapLoaded() throws RemoteException {
                    callback.onMapLoaded();
                }
            });
        }
    }

    public final void setOnMapLongClickListener(final OnMapLongClickListener listener) {
        if (listener == null) {
            try {
                this.zzaBp.setOnMapLongClickListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaBp.setOnMapLongClickListener(new zzl.zza() {
                /* class com.google.android.gms.maps.GoogleMap.AnonymousClass9 */

                @Override // com.google.android.gms.maps.internal.zzl
                public void onMapLongClick(LatLng point) {
                    listener.onMapLongClick(point);
                }
            });
        }
    }

    public final void setOnMarkerClickListener(final OnMarkerClickListener listener) {
        if (listener == null) {
            try {
                this.zzaBp.setOnMarkerClickListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaBp.setOnMarkerClickListener(new zzn.zza() {
                /* class com.google.android.gms.maps.GoogleMap.AnonymousClass10 */

                @Override // com.google.android.gms.maps.internal.zzn
                public boolean zza(zzi zzi) {
                    return listener.onMarkerClick(new Marker(zzi));
                }
            });
        }
    }

    public final void setOnMarkerDragListener(final OnMarkerDragListener listener) {
        if (listener == null) {
            try {
                this.zzaBp.setOnMarkerDragListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaBp.setOnMarkerDragListener(new zzo.zza() {
                /* class com.google.android.gms.maps.GoogleMap.AnonymousClass11 */

                @Override // com.google.android.gms.maps.internal.zzo
                public void zzb(zzi zzi) {
                    listener.onMarkerDragStart(new Marker(zzi));
                }

                @Override // com.google.android.gms.maps.internal.zzo
                public void zzc(zzi zzi) {
                    listener.onMarkerDragEnd(new Marker(zzi));
                }

                @Override // com.google.android.gms.maps.internal.zzo
                public void zzd(zzi zzi) {
                    listener.onMarkerDrag(new Marker(zzi));
                }
            });
        }
    }

    public final void setOnMyLocationButtonClickListener(final OnMyLocationButtonClickListener listener) {
        if (listener == null) {
            try {
                this.zzaBp.setOnMyLocationButtonClickListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaBp.setOnMyLocationButtonClickListener(new zzp.zza() {
                /* class com.google.android.gms.maps.GoogleMap.AnonymousClass3 */

                @Override // com.google.android.gms.maps.internal.zzp
                public boolean onMyLocationButtonClick() throws RemoteException {
                    return listener.onMyLocationButtonClick();
                }
            });
        }
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(final OnMyLocationChangeListener listener) {
        if (listener == null) {
            try {
                this.zzaBp.setOnMyLocationChangeListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaBp.setOnMyLocationChangeListener(new zzq.zza() {
                /* class com.google.android.gms.maps.GoogleMap.AnonymousClass2 */

                @Override // com.google.android.gms.maps.internal.zzq
                public void zzc(Location location) {
                    listener.onMyLocationChange(location);
                }

                @Override // com.google.android.gms.maps.internal.zzq
                public void zzo(com.google.android.gms.dynamic.zzd zzd) {
                    listener.onMyLocationChange((Location) zze.zzn(zzd));
                }
            });
        }
    }

    public final void setPadding(int left, int top, int right, int bottom) {
        try {
            this.zzaBp.setPadding(left, top, right, bottom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean enabled) {
        try {
            this.zzaBp.setTrafficEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback callback) {
        snapshot(callback, null);
    }

    public final void snapshot(final SnapshotReadyCallback callback, Bitmap bitmap) {
        try {
            this.zzaBp.snapshot(new zzw.zza() {
                /* class com.google.android.gms.maps.GoogleMap.AnonymousClass5 */

                @Override // com.google.android.gms.maps.internal.zzw
                public void onSnapshotReady(Bitmap snapshot) throws RemoteException {
                    callback.onSnapshotReady(snapshot);
                }

                @Override // com.google.android.gms.maps.internal.zzw
                public void zzp(com.google.android.gms.dynamic.zzd zzd) throws RemoteException {
                    callback.onSnapshotReady((Bitmap) zze.zzn(zzd));
                }
            }, (zze) (bitmap != null ? zze.zzw(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.zzaBp.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public IGoogleMapDelegate zzvi() {
        return this.zzaBp;
    }
}
