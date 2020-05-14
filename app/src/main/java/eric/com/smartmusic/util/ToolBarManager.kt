package eric.com.smartmusic.util

import android.view.MenuItem
import android.widget.Toast
import android.widget.Toast.*
import androidx.appcompat.widget.Toolbar
import eric.com.smartmusic.R

/**
 * Description:
 *
 * @author Eric(zhangchunliang1@gmail.com)
 * @since 2020/5/14
 */
interface ToolBarManager {

    var toolbar: Toolbar

    fun initMainToolBar() {
        toolbar.title = "智慧影音"
        toolbar.inflateMenu(R.menu.main_setting)
        /*
        toolbar.setOnMenuItemClickListener(object :Toolbar.OnMenuItemClickListener{
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                if (item != null) {
                    when(item.itemId){
                        R.id.setting->{
                            Toast.makeText(toolbar.context, "setting", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                return true
            }
        })
         */
        toolbar.setOnMenuItemClickListener { item ->
            if (item != null) {
                when(item.itemId){
                    R.id.setting->{
                        Toast.makeText(toolbar.context, "setting", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            true
        }
    }

}