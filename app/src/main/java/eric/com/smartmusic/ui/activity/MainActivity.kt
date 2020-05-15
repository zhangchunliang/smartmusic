package eric.com.smartmusic.ui.activity

import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import eric.com.smartmusic.R
import eric.com.smartmusic.base.BaseActivity
import eric.com.smartmusic.util.ToolBarManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() , ToolBarManager{

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        initMainToolBar()
    }

    override fun initListener() {
        bottomBar.setOnTabSelectListener {
            when(it){
                R.id.tab_home -> {
                    Toast.makeText(this, "home tab click", Toast.LENGTH_SHORT).show()
                }
                R.id.tab_mv -> {
                    Toast.makeText(this, "mv tab click", Toast.LENGTH_SHORT).show()
                }
                R.id.tab_vlist -> {
                    Toast.makeText(this, "vlist tab click", Toast.LENGTH_SHORT).show()
                }
                R.id.tab_mvlist -> {
                    Toast.makeText(this, "mvlist tab click", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
    override var toolbar: Toolbar
        get() = findViewById(R.id.toolbar)
        set(value) {}
}
