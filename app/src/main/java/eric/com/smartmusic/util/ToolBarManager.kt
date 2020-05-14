package eric.com.smartmusic.util

import androidx.appcompat.widget.Toolbar
import eric.com.smartmusic.R

/**
 * Description:
 *
 * @author Eric(zhangchunliang@lkmotion.com)
 * @since 2020/5/14
 */
interface ToolBarManager {

    var toolbar: Toolbar

    fun initMainToolBar() {
        toolbar.title = "智慧影音"
        toolbar.inflateMenu(R.menu.main_setting)
    }

}