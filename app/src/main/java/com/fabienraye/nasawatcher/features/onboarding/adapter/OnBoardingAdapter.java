package com.fabienraye.nasawatcher.features.onboarding.adapter;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fabienraye.nasawatcher.R;
import com.fabienraye.nasawatcher.features.onboarding.OnBoardingEnum;

public class OnBoardingAdapter extends PagerAdapter {

    private Context mContext;

    public OnBoardingAdapter(Context context) {
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        OnBoardingEnum onBoardingEnum = OnBoardingEnum.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.fragment_on_boarding_item, collection, false);

        // Image
        ImageView imageView = (ImageView) layout.findViewById(R.id.image_view);
        imageView.setImageResource(onBoardingEnum.getImageResId());

        // Title
        TextView titleTextView = (TextView) layout.findViewById(R.id.title_text_view);
        titleTextView.setText(onBoardingEnum.getTitleId());

        // Description
        TextView descriptionTextView = (TextView) layout.findViewById(R.id.description_text_view);
        descriptionTextView.setText(onBoardingEnum.getDescriptionId());

        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return OnBoardingEnum.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
