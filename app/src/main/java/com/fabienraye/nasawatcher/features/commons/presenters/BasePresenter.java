package com.fabienraye.nasawatcher.features.commons.presenters;


import rx.subscriptions.CompositeSubscription;

public abstract class BasePresenter<T extends IView> {
    protected T mView;

    // To manage observables in the presenter lifecycle
    protected CompositeSubscription mCompositeSubscription;

    public BasePresenter() {
        mCompositeSubscription = new CompositeSubscription();
    }

    public void onViewCreated() {}

    public void onViewStarted() {}

    public void onViewResumed() {}

    /**
     * View will be destroyed
     */
    public void onViewDestroyed() {
        mCompositeSubscription.unsubscribe();
    }
}
