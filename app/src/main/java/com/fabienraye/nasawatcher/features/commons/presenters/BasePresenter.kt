package com.fabienraye.nasawatcher.features.commons.presenters


import rx.subscriptions.CompositeSubscription

abstract class BasePresenter<T : IView> {

    protected var mView: T? = null

    // To manage observables in the presenter lifecycle
    protected var mCompositeSubscription: CompositeSubscription = CompositeSubscription()

    fun onViewCreated() {}

    fun onViewStarted() {}

    fun onViewResumed() {}

    /**
     * View will be destroyed
     */
    fun onViewDestroyed() {
        mCompositeSubscription.unsubscribe()
    }
}
