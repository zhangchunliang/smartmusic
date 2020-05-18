package eric.com.smartmusic.presenter.Interf

import eric.com.smartmusic.model.HomeItemBean

/**
 * Description:
 *
 * @author Eric(zhangchunliang@lkmotion.com)
 * @since 2020/5/16
 */
interface HomeView {
    fun onFailure(message: String?)

    fun onSuccess(list: List<HomeItemBean>?)

    fun loadMore(list: List<HomeItemBean>?)
}