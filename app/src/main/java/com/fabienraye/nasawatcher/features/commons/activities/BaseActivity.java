package com.fabienraye.nasawatcher.features.commons.activities;


import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.fabienraye.nasawatcher.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.subscriptions.CompositeSubscription;

public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    @Nullable
    Toolbar mToolbar;

    protected CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeSubscription.unsubscribe();
    }

    @Override
    public void setContentView(int layoutID) {
        super.setContentView(layoutID);
        ButterKnife.bind(this);
        if (mToolbar != null) {
            if (useToolbar()) {
                setToolbarProperties();
            } else {
                mToolbar.setVisibility(View.GONE);
            }
        }
    }

    // region TOOLBAR

    private void setToolbarProperties() {
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
        }

        // Set the color of the picture to main color
        if (mToolbar != null && mToolbar.getNavigationIcon() != null) {
            mToolbar.getNavigationIcon().setColorFilter(
                    ContextCompat.getColor(this, android.R.color.white),
                    PorterDuff.Mode.SRC);

            mToolbar.setNavigationOnClickListener(v -> onBackPressed());
        }
    }

    protected boolean useToolbar() {
        return true;
    }

    @SuppressWarnings("unused")
    public void hideToolBar() {
        if (mToolbar != null) {
            mToolbar.setVisibility(View.GONE);
        }
    }

    @SuppressWarnings("unused")
    public void showToolBar() {
        if (mToolbar != null) {
            mToolbar.setVisibility(View.VISIBLE);
        }
    }

    // endregion

}
