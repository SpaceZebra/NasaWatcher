package com.fabienraye.nasawatcher.features.onboarding.activity

import android.os.Bundle
import butterknife.OnClick
import com.fabienraye.nasawatcher.R
import com.fabienraye.nasawatcher.features.commons.activities.BaseActivity
import com.fabienraye.nasawatcher.features.onboarding.adapter.OnBoardingAdapter
import kotlinx.android.synthetic.main.activity_on_boarding.*

class OnBoardingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
    }

    override fun onStart() {
        super.onStart()

        // Fill view pager
        onBoardingViewPager.adapter = OnBoardingAdapter(this)

        // Start button
        onBoardingStartButton.setOnClickListener {  }
    }

    @OnClick(R.id.onBoardingStartButton)
    internal fun getStartedClicked() {
        // TODO add call to presenter
    }
}
