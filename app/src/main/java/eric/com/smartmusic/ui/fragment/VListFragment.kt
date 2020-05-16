package eric.com.smartmusic.ui.fragment

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import eric.com.smartmusic.ui.fragment.BaseFragment

/**
 * Description:
 *
 * @author Eric(zhangchunliang@lkmotion.com)
 * @since 2020/5/15
 */
class VListFragment: BaseFragment() {
    override fun initView(): View? {
        var text = TextView(context).apply {
            gravity = Gravity.CENTER
            setTextColor(Color.RED)
            text = "VListFragment"
        }

        return text
    }
}