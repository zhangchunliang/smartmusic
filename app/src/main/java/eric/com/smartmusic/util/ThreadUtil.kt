package eric.com.smartmusic.util

import android.os.Handler
import android.os.Looper

/**
 * Description:
 *
 * @author Eric(zhangchunliang@lkmotion.com)
 * @since 2020/5/16
 */
object ThreadUtil {

    val handler = Handler(Looper.getMainLooper())

    fun runOnMainUiThread(runnable: () -> Unit){
        handler.post(runnable)
    }
}