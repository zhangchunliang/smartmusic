package eric.com.smartmusic.ui.activity

import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.preference.PreferenceManager
import eric.com.smartmusic.R
import eric.com.smartmusic.base.BaseActivity
import eric.com.smartmusic.util.ToolBarManager

class SettingActivity : BaseActivity(), ToolBarManager {

    override fun getLayoutId(): Int {
        return R.layout.activity_setting
    }

    override var toolbar: Toolbar
        get() = findViewById(R.id.toolbar)
        set(value) {}

    override fun initData() {
        initSettingToolBar()
        var preferenceManager = PreferenceManager.getDefaultSharedPreferences(this)
        Log.d("SettingActivity", "push:${preferenceManager.getBoolean("push", false)}")
    }

}
