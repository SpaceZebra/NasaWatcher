package com.fabienraye.nasawatcher.features.onboarding


import com.fabienraye.nasawatcher.R

enum class OnBoardingEnum(val imageResId: Int, val titleId: Int, val descriptionId: Int) {

    NASA(
            R.drawable.img_on_boarding_nasa,
            R.string.on_boarding_nasa_title,
            R.string.on_boarding_nasa_speech
    ),
    POTD(
            R.drawable.img_on_boarding_potd,
            R.string.on_boarding_potd_title,
            R.string.on_boarding_potd_speech),
    ASTEROID(
            R.drawable.img_on_boarding_asteroid,
            R.string.on_boarding_asteroid_title,
            R.string.on_boarding_asteroid_speech
    )
}
