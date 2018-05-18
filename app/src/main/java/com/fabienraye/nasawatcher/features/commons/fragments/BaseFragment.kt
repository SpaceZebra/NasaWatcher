package com.fabienraye.nasawatcher.features.commons.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import butterknife.ButterKnife
import rx.subscriptions.CompositeSubscription

abstract class BaseFragment : Fragment() {

    private var _compositeSubscription: CompositeSubscription = CompositeSubscription()

    protected val compositeSubscription: CompositeSubscription
        get() {
            return _compositeSubscription.let {
                if (it.isUnsubscribed) {
                    CompositeSubscription()
                } else {
                    it
                }
            }
        }

    protected abstract val layout: Int

    protected val currentArguments: Bundle
        get() {
            var args = arguments
            if (args == null) {
                args = Bundle()
            }
            return args
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(layout, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (compositeSubscription.hasSubscriptions()) {
            _compositeSubscription.unsubscribe()
        }
    }

    fun onBackPressed() {}

    fun refresh() {
        fragmentManager!!.beginTransaction()
                .detach(this)
                .attach(this)
                .commitAllowingStateLoss()
    }
}
