package dk.minton.activity

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Surface
import android.widget.Toast
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import dk.minton.R
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
