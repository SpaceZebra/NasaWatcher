package com.fabienraye.nasawatcher.features.onboarding.adapter


import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fabienraye.nasawatcher.R
import com.fabienraye.nasawatcher.features.onboarding.OnBoardingEnum
import kotlinx.android.synthetic.main.fragment_on_boarding_item.view.*

class OnBoardingAdapter(private val context: Context) : PagerAdapter() {

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val onBoardingEnum = OnBoardingEnum.values()[position]
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(R.layout.fragment_on_boarding_item, collection, false) as ViewGroup

        // Image
        layout.onBoardingItemImageView.setImageResource(onBoardingEnum.imageResId)

        // Title
        layout.title_text_view.setText(onBoardingEnum.titleId)

        // Description
        layout.description_text_view.setText(onBoardingEnum.descriptionId)

        // Add to the group
        collection.addView(layout)

        return layout
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getCount(): Int {
        return OnBoardingEnum.values().size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }
}
