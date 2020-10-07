package dk.iutube.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import dk.iutube.R
import dk.iutube.fragment.MainFragment

const val TAB_COUNT = 6

class MainTabPagerAdapter(fm: FragmentManager, val context: Context)
    : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val titles = arrayOf(R.string.iu, R.string.official, R.string.song, R.string.video, R.string.clip, R.string.commercial)
    private val urls = arrayOf(
        "PLGhOCcpfhWjeZqunx7WlGOwcJgNIVSTTj",
        "PLGhOCcpfhWje6mTDcL8Yz3yQoKiHZTJhv",
        "PL2ACgmfvv3rbUsofr-XyAe9eMk7nMoheE",
        "PLGhOCcpfhWjenR_5jrOkGhdNILM1_oY9L",
        "PLGhOCcpfhWjfqBvakt9CaKDuYnjlBl8Kt",
        "PLGhOCcpfhWjc6k4PyfzV_zOvYDk1El20V"
    )

    override fun getItem(position: Int): Fragment =
        MainFragment.newInstance(urls[position])

    override fun getCount() = TAB_COUNT

    override fun getPageTitle(position: Int): CharSequence? {
        return context.getString(titles[position])
    }
}
