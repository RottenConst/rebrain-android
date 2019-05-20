package com.rebrain.konstload.foodapp.screen.main.carousel.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import com.rebrain.konstload.foodapp.screen.main.carousel.CarouselFragment

/**
 * FragmentPagerAdapter - хранит все страницы в памяти, каждый раз не создает, поэтому быстрый,
 *                        но затратный(подходит для быстрого перелистывания небольшого числа страниц)
 * FragmentStatePagerAdapter - хранит в паняти только соседнии страцы, остальные пересоздает,
 *                             поэтому может притормаживать из-за быстрого перелистывания
 *                             (подходит для большого количества страниц с большим количеством информации
 *                             для медленного перелистывания, например книг)
 */
class FragmentCarouselAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(page: Int): Fragment {
        return CarouselFragment.newInstance(page)
    }

    override fun getCount(): Int {
        return CarouselFragment.images.size
    }
}

class FragmentCarouselStateAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(page: Int): Fragment {
        return CarouselFragment.newInstance(page)
    }

    override fun getCount(): Int {
        return CarouselFragment.images.size
    }
}