package dk.minton

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.ListFragment

const val TAB_COUNT = 7

class MainTabPagerAdapter(fm: FragmentManager, val context: Context)
    : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val titles = arrayOf("기초", "타구", "스텝", "클리어", "드라이브", "스매시", "헤어핀")

    override fun getItem(position: Int): Fragment =
        when(position){
            0 -> ListFragment()
            else -> ListFragment()
        }

    override fun getCount() = TAB_COUNT

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

}
