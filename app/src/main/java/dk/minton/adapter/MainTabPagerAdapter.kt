package dk.minton.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import dk.minton.fragment.MainFragment

const val TAB_COUNT = 5

class MainTabPagerAdapter(fm: FragmentManager, val context: Context)
    : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val titles = arrayOf("하태권", "김용태", "윤이콕", "짱코치", "달인콕")
    private val urls = arrayOf(
        "PL9Df21bffZzr4mT35tSHqoTomPfQ_s4BN",
        "PLqPoGMl-3GsYoUaidb18OVW91uL9Ep0v0",
        "PLp8hA-7NWk2D-jAOOhM3Lt67p_UbRfGea",
        "PLfWTnSSRkKrhKs_4Zqf_BKWZGb3dY_ZKc",
        "PLkUfjhFb5sgT3qXPoBP7pRWw2hG136R1I"
    )

    override fun getItem(position: Int): Fragment =
        MainFragment.newInstance(urls[position])

    override fun getCount() = TAB_COUNT

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

}
