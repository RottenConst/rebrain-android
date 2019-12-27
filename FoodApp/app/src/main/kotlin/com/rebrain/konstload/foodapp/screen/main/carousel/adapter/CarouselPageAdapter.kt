package com.rebrain.konstload.foodapp.screen.main.carousel.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.rebrain.konstload.foodapp.screen.main.carousel.CarouselFragment
import com.rebrain.konstload.foodapp.util.Generator

/**
 * FragmentPagerAdapter - хранит все страницы в памяти, поэтому быстрый при частом или быстрым перелистывании страниц,
 *                        может потреблять много памяти, если страниц много.
 * FragmentStatePagerAdapter - хранит в памяти только соседние страницы(предыдущую и следующую), остальные пересоздаёт,
 *                             поэтому более экономно расходует память, но может притормаживать из-за быстрого/частого
 *                             перелистывания (подходит для большого количества страниц с большим количеством информации
 *                             для медленного перелистывания, например книг)
 */
class FragmentCarouselAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(page: Int): Fragment {
        return CarouselFragment.newInstance(page, Generator.images)
    }

    override fun getCount(): Int {
        return Generator.images.size
    }
}

class FragmentCarouselStateAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(page: Int): Fragment {
        return CarouselFragment.newInstance(page, Generator.images)
    }

    override fun getCount(): Int {
        return Generator.images.size
    }
}