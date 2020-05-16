package eric.com.smartmusic.ui.activity

import android.content.Context
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import eric.com.smartmusic.R
import eric.com.smartmusic.base.BaseActivity
import eric.com.smartmusic.util.FragmentUtil
import eric.com.smartmusic.util.ThreadUtil
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
                    showToast("home tab click")
                }
                R.id.tab_mv -> {
                    Toast.makeText(this, "mv tab click", Toast.LENGTH_SHORT).show()
                }
                R.id.tab_vlist -> {
                    ThreadUtil.runOnMainUiThread{
                        Toast.makeText(this, "vlist tab click", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.tab_mvlist -> {
                    Toast.makeText(this, "mvlist tab click", Toast.LENGTH_SHORT).show()
                }

            }

            FragmentUtil.fragmentUtil.getFragment(it)?.let { it1 ->
                    supportFragmentManager.beginTransaction().replace(R.id.container, it1, it.toString()).commit()
            }
        }
    }
    override var toolbar: Toolbar
        get() = findViewById(R.id.toolbar)
        set(value) {}
}
