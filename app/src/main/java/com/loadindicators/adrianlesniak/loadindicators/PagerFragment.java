package com.loadindicators.adrianlesniak.loadindicators;

import android.graphics.Typeface;
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
public class PagerFragment extends Fragment
{
    private LoaderIndicator imageView;
    private TextView textView;
    private Typeface typeface;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/chunkfive.ttf");
    }

    public static PagerFragment newInstance() {
        PagerFragment fragment = new PagerFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getReferences(view);
        textView.setTypeface(typeface);
    }

    private void getReferences(View view) {
        imageView = view.findViewById(R.id.imageLoader);
        textView = view.findViewById(R.id.text);
    }
}
