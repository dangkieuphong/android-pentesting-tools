package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.mediarouter.R;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MediaRouteChooserDialog extends Dialog {
    private RouteAdapter mAdapter;
    private boolean mAttachedToWindow;
    private final MediaRouterCallback mCallback;
    private ListView mListView;
    private final MediaRouter mRouter;
    private ArrayList<MediaRouter.RouteInfo> mRoutes;
    private MediaRouteSelector mSelector;

    public MediaRouteChooserDialog(Context context) {
        this(context, 0);
    }

    public MediaRouteChooserDialog(Context context, int theme) {
        super(MediaRouterThemeHelper.createThemedContext(context), theme);
        this.mSelector = MediaRouteSelector.EMPTY;
        this.mRouter = MediaRouter.getInstance(getContext());
        this.mCallback = new MediaRouterCallback();
    }

    @NonNull
    public MediaRouteSelector getRouteSelector() {
        return this.mSelector;
    }

    public void setRouteSelector(@NonNull MediaRouteSelector selector) {
        if (selector == null) {
            throw new IllegalArgumentException("selector must not be null");
        } else if (!this.mSelector.equals(selector)) {
            this.mSelector = selector;
            if (this.mAttachedToWindow) {
                this.mRouter.removeCallback(this.mCallback);
                this.mRouter.addCallback(selector, this.mCallback, 1);
            }
            refreshRoutes();
        }
    }

    public void onFilterRoutes(@NonNull List<MediaRouter.RouteInfo> routes) {
        int i = routes.size();
        while (true) {
            i--;
            if (i <= 0) {
                return;
            }
            if (!onFilterRoute(routes.get(i))) {
                routes.remove(i);
            }
        }
    }

    public boolean onFilterRoute(@NonNull MediaRouter.RouteInfo route) {
        return !route.isDefault() && route.isEnabled() && route.matchesSelector(this.mSelector);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(3);
        setContentView(R.layout.mr_media_route_chooser_dialog);
        setTitle(R.string.mr_media_route_chooser_title);
        getWindow().setFeatureDrawableResource(3, MediaRouterThemeHelper.getThemeResource(getContext(), R.attr.mediaRouteOffDrawable));
        this.mRoutes = new ArrayList<>();
        this.mAdapter = new RouteAdapter(getContext(), this.mRoutes);
        this.mListView = (ListView) findViewById(R.id.media_route_list);
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
        this.mListView.setOnItemClickListener(this.mAdapter);
        this.mListView.setEmptyView(findViewById(16908292));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttachedToWindow = true;
        this.mRouter.addCallback(this.mSelector, this.mCallback, 1);
        refreshRoutes();
    }

    public void onDetachedFromWindow() {
        this.mAttachedToWindow = false;
        this.mRouter.removeCallback(this.mCallback);
        super.onDetachedFromWindow();
    }

    public void refreshRoutes() {
        if (this.mAttachedToWindow) {
            this.mRoutes.clear();
            this.mRoutes.addAll(this.mRouter.getRoutes());
            onFilterRoutes(this.mRoutes);
            Collections.sort(this.mRoutes, RouteComparator.sInstance);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final class RouteAdapter extends ArrayAdapter<MediaRouter.RouteInfo> implements AdapterView.OnItemClickListener {
        private final LayoutInflater mInflater;

        public RouteAdapter(Context context, List<MediaRouter.RouteInfo> routes) {
            super(context, 0, routes);
            this.mInflater = LayoutInflater.from(context);
        }

        public boolean areAllItemsEnabled() {
            return false;
        }

        public boolean isEnabled(int position) {
            return ((MediaRouter.RouteInfo) getItem(position)).isEnabled();
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = this.mInflater.inflate(R.layout.mr_media_route_list_item, parent, false);
            }
            MediaRouter.RouteInfo route = (MediaRouter.RouteInfo) getItem(position);
            TextView text2 = (TextView) view.findViewById(16908309);
            ((TextView) view.findViewById(16908308)).setText(route.getName());
            String description = route.getDescription();
            if (TextUtils.isEmpty(description)) {
                text2.setVisibility(8);
                text2.setText("");
            } else {
                text2.setVisibility(0);
                text2.setText(description);
            }
            view.setEnabled(route.isEnabled());
            return view;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            MediaRouter.RouteInfo route = (MediaRouter.RouteInfo) getItem(position);
            if (route.isEnabled()) {
                route.select();
                MediaRouteChooserDialog.this.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    public final class MediaRouterCallback extends MediaRouter.Callback {
        private MediaRouterCallback() {
        }

        @Override // android.support.v7.media.MediaRouter.Callback
        public void onRouteAdded(MediaRouter router, MediaRouter.RouteInfo info) {
            MediaRouteChooserDialog.this.refreshRoutes();
        }

        @Override // android.support.v7.media.MediaRouter.Callback
        public void onRouteRemoved(MediaRouter router, MediaRouter.RouteInfo info) {
            MediaRouteChooserDialog.this.refreshRoutes();
        }

        @Override // android.support.v7.media.MediaRouter.Callback
        public void onRouteChanged(MediaRouter router, MediaRouter.RouteInfo info) {
            MediaRouteChooserDialog.this.refreshRoutes();
        }

        @Override // android.support.v7.media.MediaRouter.Callback
        public void onRouteSelected(MediaRouter router, MediaRouter.RouteInfo route) {
            MediaRouteChooserDialog.this.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final class RouteComparator implements Comparator<MediaRouter.RouteInfo> {
        public static final RouteComparator sInstance = new RouteComparator();

        private RouteComparator() {
        }

        public int compare(MediaRouter.RouteInfo lhs, MediaRouter.RouteInfo rhs) {
            return lhs.getName().compareTo(rhs.getName());
        }
    }
}
