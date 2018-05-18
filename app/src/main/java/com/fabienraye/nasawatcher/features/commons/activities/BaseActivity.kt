package com.fabienraye.nasawatcher.features.commons.activities


import android.graphics.PorterDuff
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import butterknife.BindView
import butterknife.ButterKnife
import com.fabienraye.nasawatcher.R
import rx.subscriptions.CompositeSubscription

abstract class BaseActivity : AppCompatActivity() {

    @BindView(R.id.toolbar)
    internal var mToolbar: Toolbar? = null

    private var _compositeSubscription = CompositeSubscription()

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

    override fun onDestroy() {
        super.onDestroy()
        _compositeSubscription.unsubscribe()
    }

    override fun setContentView(layoutID: Int) {
        super.setContentView(layoutID)
        ButterKnife.bind(this)

        // Handle Toolbar
        mToolbar?.also {
            if (useToolbar()) {
                setToolbarProperties()
            } else {
                it.visibility = View.GONE
            }
        }
    }

    // region TOOLBAR

    private fun setToolbarProperties() {
        // Set action bar
        setSupportActionBar(mToolbar)

        // Configure action bar
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
            setDisplayUseLogoEnabled(true)
        }

        // Set navigation color
        mToolbar?.navigationIcon?.apply {
            setColorFilter(
                    ContextCompat.getColor(
                            this@BaseActivity,
                            android.R.color.white),
                    PorterDuff.Mode.SRC)
        }

        mToolbar?.setNavigationOnClickListener { onBackPressed() }
    }

    protected fun useToolbar(): Boolean {
        return true
    }

    fun hideToolBar() {
        mToolbar?.apply {
            visibility = View.GONE
        }
    }

    fun showToolBar() {
        mToolbar?.apply {
            visibility = View.VISIBLE
        }
    }

    // endregion
}
