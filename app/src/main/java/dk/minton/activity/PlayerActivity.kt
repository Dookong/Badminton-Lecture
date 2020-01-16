package dk.minton.activity

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Surface
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import dk.minton.R
import dk.minton.api.Key
import gun0912.tedadhelper.TedAdHelper
import gun0912.tedadhelper.nativead.OnNativeAdListener
import gun0912.tedadhelper.nativead.TedNativeAdHolder
import kotlinx.android.synthetic.main.playerlayout.*
import kr.co.prnd.YouTubePlayerView

class PlayerActivity : AppCompatActivity() {

    lateinit var player: YouTubePlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.playerlayout)

        you_tube_player_view.play(intent.getStringExtra("url")!!, object : YouTubePlayerView.OnInitializedListener{
            override fun onInitializationFailure(
                provider: YouTubePlayer.Provider,
                result: YouTubeInitializationResult
            ) {
                Toast.makeText(this@PlayerActivity, "동영상을 불러오는데 실패했습니다:(", Toast.LENGTH_SHORT).show()
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

        val adHolder = TedNativeAdHolder(
            native_container, this, getString(R.string.app_name),
            Key.FACEBOOK_KEY, Key.ADMOB_KEY,
            TedAdHelper.ImageProvider { imageView, imageUrl ->
                Glide.with(this).load(imageUrl).into(imageView)
            },
            TedAdHelper.ADMOB_NATIVE_AD_TYPE.NATIVE_ADVANCED
        )

        adHolder.loadAD(arrayOf(TedAdHelper.AD_FACEBOOK, TedAdHelper.AD_ADMOB),
            object : OnNativeAdListener{
                override fun onAdClicked(adType: Int) {
                }

                override fun onLoaded(adType: Int) {
                }

                override fun onError(errorMessage: String?) {
                    Log.d("debug", "광고 로드 실패: $errorMessage")
                }
            })

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
}
