package com.fabienraye.nasawatcher.features.onboarding;


import com.fabienraye.nasawatcher.R;

public enum OnBoardingEnum {

    NASA(
            R.drawable.img_on_boarding_nasa,
            R.string.on_boarding_nasa_title,
            R.string.on_boarding_nasa_speech
    ),
    POTD(
            R.drawable.img_on_boarding_potd,
            R.string.on_boarding_potd_title,
            R.string.on_boarding_potd_speech)
    ,
    ASTEROID(
            R.drawable.img_on_boarding_asteroid,
            R.string.on_boarding_asteroid_title,
            R.string.on_boarding_asteroid_speech
    );

    private int mImageResId;
    private int mTitleId;
    private int mDescriptionId;

    OnBoardingEnum(int imageResId, int titleId, int descriptionId) {
        mImageResId = imageResId;
        mTitleId = titleId;
        mDescriptionId = descriptionId;
    }

    public int getImageResId() {
        return mImageResId;
    }

    public int getTitleId() {
        return mTitleId;
    }

    public int getDescriptionId() {
        return mDescriptionId;
    }
}
