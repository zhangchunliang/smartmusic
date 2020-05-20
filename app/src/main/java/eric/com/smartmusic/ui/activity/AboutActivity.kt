package eric.com.smartmusic.ui.activity

import com.squareup.picasso.Picasso
import com.squareup.picasso.Callback
import eric.com.smartmusic.R
import eric.com.smartmusic.base.BaseActivity
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.home_item.view.*

class AboutActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_about
    }
}
