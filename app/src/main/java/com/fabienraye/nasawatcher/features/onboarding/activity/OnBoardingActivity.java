package com.fabienraye.nasawatcher.features.onboarding.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.fabienraye.nasawatcher.R;
import com.fabienraye.nasawatcher.features.commons.activities.BaseActivity;
import com.fabienraye.nasawatcher.features.onboarding.adapter.OnBoardingAdapter;
import com.rd.PageIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OnBoardingActivity extends BaseActivity {

    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @BindView(R.id.page_indicator_view)
    PageIndicatorView mPageIndicatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
        ButterKnife.bind(this);

        mViewPager.setAdapter(new OnBoardingAdapter(this));
    }

    @OnClick(R.id.get_started_button)
    void getStartedClicked() {
        // TODO add call to presenter
    }
}
