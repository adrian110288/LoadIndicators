package com.loadindicators.adrianlesniak.loadindicators;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loadindicators.adrianlesniak.library.LoaderIndicator;

/**
 * Created by Adrian on 22-Nov-14.
 */
public class PagerFragment extends Fragment {

    private static final String LOADER_MODEl_EXTRA = "LOADER_MODEl_EXTRA";

    public static PagerFragment newInstance(LoaderModel loaderModel) {
        PagerFragment fragment = new PagerFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(LOADER_MODEl_EXTRA, loaderModel);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LoaderModel loader = getLoader();

        TextView framesTv = view.findViewById(R.id.frames);
        framesTv.setText(loader.getFrameCount() + " frames");
        framesTv.setTypeface(TypefaceCache.getTypeface(getActivity().getAssets(), "fonts/chunkfive.ttf"));

        LoaderIndicator loaderIndicator = view.findViewById(R.id.loader);
        loaderIndicator.setLoaderSource(loader.getLoaderSrc(), loader.getFrameCount());
        loaderIndicator.startAnimate();
    }

    private LoaderModel getLoader() {
        return (LoaderModel) getArguments().getParcelable(LOADER_MODEl_EXTRA);
    }
}
