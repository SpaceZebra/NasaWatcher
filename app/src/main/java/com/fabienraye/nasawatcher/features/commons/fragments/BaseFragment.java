package com.fabienraye.nasawatcher.features.commons.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import rx.subscriptions.CompositeSubscription;

public abstract class BaseFragment extends Fragment {

    private CompositeSubscription mCompositeSubscription;

    protected abstract int getLayout();

    protected Bundle getCurrentArguments() {
        Bundle args = getArguments();
        if (args == null) {
            args = new Bundle();
        }
        return args;
    }

    protected CompositeSubscription getCompositeSubscription() {
        if (mCompositeSubscription == null || mCompositeSubscription.isUnsubscribed()) {
            mCompositeSubscription = new CompositeSubscription();
        }
        return mCompositeSubscription;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    public void onBackPressed() {
    }

    public void refresh() {
        getFragmentManager().beginTransaction()
                .detach(this)
                .attach(this)
                .commitAllowingStateLoss();
    }
}
