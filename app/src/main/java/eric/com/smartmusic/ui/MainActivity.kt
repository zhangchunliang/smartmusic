package eric.com.smartmusic.ui

import androidx.appcompat.widget.Toolbar
import eric.com.smartmusic.R
import eric.com.smartmusic.base.BaseActivity
import eric.com.smartmusic.util.ToolBarManager

class MainActivity : BaseActivity() , ToolBarManager{

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        initMainToolBar()
    }

    override var toolbar: Toolbar
        get() = findViewById(R.id.toolbar)
        set(value) {}
}
