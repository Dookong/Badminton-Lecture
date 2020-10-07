package dk.iutube.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import dk.iutube.adapter.MainTabPagerAdapter
import android.content.Intent
import android.net.Uri
import android.view.Menu
import android.view.MenuItem
import de.psdev.licensesdialog.*
import de.psdev.licensesdialog.licenses.ApacheSoftwareLicense20
import de.psdev.licensesdialog.licenses.BSD2ClauseLicense
import de.psdev.licensesdialog.model.Notice
import de.psdev.licensesdialog.model.Notices

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(dk.iutube.R.layout.activity_main)

        setSupportActionBar(toolbar)
        tabLayout.setupWithViewPager(viewPager)

        viewPager.apply {
            adapter =
                MainTabPagerAdapter(supportFragmentManager, this@MainActivity)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        val menuInflater = menuInflater
        menuInflater.inflate(dk.iutube.R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)

        when (item.itemId) {
            dk.iutube.R.id.menu_review -> {
                val i = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=dk.iutube")
                )
                startActivity(i)
            }
            dk.iutube.R.id.menu_license -> {
                showLicenseDialog()
            }
        }
        return false
    }

    private fun showLicenseDialog() {
        val notices = Notices()
        notices.addNotice(
            Notice(
                "Retrofit",
                "https://square.github.io/retrofit",
                "Copyright 2013 Square, Inc.",
                ApacheSoftwareLicense20()
            )
        )

        notices.addNotice(
            Notice(
                "Gson",
                "https://github.com/google/gson",
                "Copyright 2008 Google Inc.",
                ApacheSoftwareLicense20()
            )
        )

        notices.addNotice(
            Notice(
                "Glide",
                "https://github.com/bumptech/glide",
                "Copyright 2014 Google, Inc. All rights reserved.",
                BSD2ClauseLicense()
            )
        )
        notices.addNotice(
            Notice(
                "YouTubePlayerView",
                "https://github.com/PRNDcompany/YouTubePlayerView",
                "Copyright 2019 PRND company.",
                ApacheSoftwareLicense20()
            )
        )
        notices.addNotice(
            Notice(
                "TedAdHelper ",
                "https://github.com/ParkSangGwon/TedAdHelper",
                "Copyright 2018 Ted Park",
                ApacheSoftwareLicense20()
            )
        )

        LicensesDialog.Builder(this)
            .setNotices(notices)
            .setIncludeOwnLicense(true)
            .build()
            .show()
    }

    private var time: Long = 0
    override fun onBackPressed() {
        if (System.currentTimeMillis() - time >= 2000) {
            time = System.currentTimeMillis()
            val snack = Snackbar.make(container, "'뒤로' 버튼을 한번 더 누르시면 종료됩니다.", Snackbar.LENGTH_SHORT)
            snack.view.setBackgroundColor(ContextCompat.getColor(this,
                dk.iutube.R.color.colorPrimary
            ))
            snack.show()
        } else if (System.currentTimeMillis() - time < 2000) {
            finish()
        }
    }
}
