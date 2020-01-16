package dk.minton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        tabLayout.setupWithViewPager(viewPager)

        viewPager.apply {
            adapter = MainTabPagerAdapter(supportFragmentManager,this@MainActivity)
        }
    }

    private var time: Long = 0
    override fun onBackPressed() {
        if (System.currentTimeMillis() - time >= 2000) {
            time = System.currentTimeMillis()
            val snack = Snackbar.make(container, "'뒤로' 버튼을 한번 더 누르시면 종료됩니다.", Snackbar.LENGTH_SHORT)
            snack.view.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary))
            snack.show()
        } else if (System.currentTimeMillis() - time < 2000) {
            finish()
        }
    }
}
