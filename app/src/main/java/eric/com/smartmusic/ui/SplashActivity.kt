package eric.com.smartmusic.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.widget.ImageView
import androidx.core.animation.doOnEnd
import eric.com.smartmusic.R
import eric.com.smartmusic.base.BaseActivity

class SplashActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initData() {
        super.initData()
        var imageView = findViewById<ImageView>(R.id.image)
        var scaleX = ObjectAnimator.ofFloat(imageView, "scaleX", 1f).apply {
            duration = 1000L
        }
        var scaleY = ObjectAnimator.ofFloat(imageView, "scaleY", 1f).apply {
            duration = 1000L
        }
        scaleX.doOnEnd {

        }
        AnimatorSet().apply {
            play(scaleX).with(scaleY)
            /*
            addListener(object : AnimatorListenerAdapter() {

                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)

                    }
                }
            })*/
            doOnEnd {
                Intent(this@SplashActivity, MainActivity::class.java).apply {
                    startActivity(this)
                    finish()
                }
            }
            start()
        }
    }
}
