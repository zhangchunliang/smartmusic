package eric.com.smartmusic.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.squareup.picasso.Picasso
import eric.com.smartmusic.R
import eric.com.smartmusic.model.HomeItemBean
import kotlinx.android.synthetic.main.home_item.view.*
import com.squareup.picasso.Callback

/**
 * Description:
 *
 * @author Eric(zhangchunliang@lkmotion.com)
 * @since 2020/5/15
 */
class HomeItemView : RelativeLayout {
    constructor(context: Context?):super(context)
    constructor(context: Context?, attrs: AttributeSet?):super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int):super(context, attrs, defStyleAttr)

    init {
        View.inflate(context, R.layout.home_item, this)
    }

    fun setData(data:HomeItemBean) {
        title.apply {
            text = data.title
            println("标题：${data.title}")
        }
        desc.apply {
            text = data.description
            println("简介：${data.description}")
        }

        Picasso.with(context).load(data.posterPic).placeholder(R.mipmap.comment_bg).into(imageView)
        println("图片：${data.posterPic}")
    }
}