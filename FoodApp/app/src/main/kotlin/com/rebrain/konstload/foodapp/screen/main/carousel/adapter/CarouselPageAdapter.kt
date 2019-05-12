package com.rebrain.konstload.foodapp.screen.main.carousel.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import com.rebrain.konstload.foodapp.ImageEnum
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.screen.main.carousel.CarouselFragment

class FragmentCarouselAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(p0: Int): Fragment {
        return CarouselFragment.newInstance(p0)
    }

    override fun getCount(): Int {
        return CarouselFragment.images.size
    }
}

class FragmentCarouselStateAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment {
        return CarouselFragment.newInstance(p0)
    }

    override fun getCount(): Int {
        return CarouselFragment.images.size
    }
}