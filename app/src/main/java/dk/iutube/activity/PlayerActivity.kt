package dk.iutube.activity

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Surface
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import dk.iutube.R
import dk.iutube.api.Key
import com.facebook.ads.*
import kotlinx.android.synthetic.main.playerlayout.*
import kr.co.prnd.YouTubePlayerView

class PlayerActivity : AppCompatActivity() {

    lateinit var player: YouTubePlayer
    private var adView: AdView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.playerlayout)

        you_tube_player_view.play(intent.getStringExtra("url")!!, object : YouTubePlayerView.OnInitializedListener{
            override fun onInitializationFailure(
                provider: YouTubePlayer.Provider,
                result: YouTubeInitializationResult
            ) {
                Toast.makeText(this@PlayerActivity, "Loading Failed:(", Toast.LENGTH_SHORT).show()
            }

            override fun onInitializationSuccess(
                provider: YouTubePlayer.Provider,
                player: YouTubePlayer,
                wasRestored: Boolean
            ) {
                player.play()
                this@PlayerActivity.player = player
            }

        })

        loadAd()
    }

    private fun loadAd() {
        AudienceNetworkAds.initialize(this)
        adView = AdView(this, Key.FACEBOOK_KEY, AdSize.RECTANGLE_HEIGHT_250)
        findViewById<LinearLayout>(R.id.banner_container).addView(adView)
        adView?.loadAd()
    }

    override fun onBackPressed() {
        when(windowManager.defaultDisplay.rotation){
            Surface.ROTATION_0 -> super.onBackPressed()
            else -> {
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                player.setFullscreen(false)
            }
        }
    }

    override fun onDestroy() {
        adView?.destroy()
        super.onDestroy()
    }
}
